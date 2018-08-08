package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.almundo.callcenter.entidad.Call;
import com.almundo.callcenter.entidad.Director;
import com.almundo.callcenter.entidad.Empleado;
import com.almundo.callcenter.entidad.Operador;
import com.almundo.callcenter.entidad.Supervisor;

@Service
public class Dispatcher {

	
	/** variables con la cual se emula la cola y asi lograr que haya justicia en cuanto al orden de llegada de las peticiones lstQueve */
	private static List<Call> lstQueve = new ArrayList<>();

	
	/** variables estaticas de capacidad*/
	public static int capaOperador = 6;
	public static int capaSupervisor = 3;
	public static int capaDirector = 1;
	

//	@Router
//    public String dispatchCall(Call call) {		
//		String channelName = "llamada-id:"+call.getId();
//        syncrhonized(channelName.intern()) {
//            if (lstQueve.get(channelName) == null) {                            	           
//            	QueueChannel activeChannel = createNewChannel(channelName);                
////                delete            	
//            	System.out.println("Thread terminado: " + getName() + " running");
//            }
//        }
//        return channelName;
//	}

	
	/**
	 * Este metodo se encarga se hacer la redireccion de la llamada @call
	 * segun la capacidad que esta descripta en las variables estaticas que 
	 * pueden ser mapeadas en el aplicacion.properties  y teniendo encuenta 
	 * el orden de asignacion segun sea el cargo del empleado 
	 * 
	 * @call instancia de la llamada a ser redireccionada
	 * 
	 * */
	public void dispatchCall(Call call) {
		
		if(lstQueve.isEmpty()) {
			if (atenderLlamadasOperador()) {
				Empleado empleado = new Operador(call);
				Thread thread = new Thread(empleado);
				thread.start();
			} else if (atenderLlamadasSupervisor()) {
				Empleado empleado = new Supervisor(call);
				Thread thread = new Thread(empleado);
				thread.start();
			} else if (atenderLlamadasDirector()) {	
				Empleado empleado = new Director(call);
				Thread thread = new Thread(empleado);
				thread.start();
			} else {	
				lstQueve.add(call);
				encolar(call);
//				LlamadaEnEspera empleado = new LlamadaEnEspera(call);
//				Thread thread = new Thread(empleado);
//				thread.start();
			}
		}else {
			lstQueve.add(call);
			encolar(call);
//			LlamadaEnEspera empleado = new LlamadaEnEspera(call);
//			Thread thread = new Thread(empleado);
//			thread.start();
		}
	}
	
	/**Proceso de redirecion de la instancias cuando estan encoladas
	 * @call  la instancia de llamada a ser redireccionada  
	 * */
	private void dispatchCallEnCola(Call call) {			
		if (atenderLlamadasOperador()) {
			Empleado empleado = new Operador(call);
			Thread thread = new Thread(empleado);
			thread.start();
		} else if (atenderLlamadasSupervisor()) {
			Empleado empleado = new Supervisor(call);
			Thread thread = new Thread(empleado);
			thread.start();
		} else if (atenderLlamadasDirector()) {	
			Empleado empleado = new Director(call);
			Thread thread = new Thread(empleado);
			thread.start();
		} else {	
			lstQueve.add(call);
			encolar(call);
		}
		
	}
	
	/**Proceso de redirecion de la instancias cuando estan encoladas
	 * @call  la instancia de llamada a ser redireccionada  
	 * */
	private  boolean atenderLlamadasOperador() {
		if(capaOperador > Operador.llamadasProceso) {
			Operador.llamadasProceso++;
			return true;
		}else {
			return false;
		}		
	}

	/** se da elsip de la atencion de la llamada y se actualiza las 
	 * llamadas en proceso de capara pool de empleados por ramgo
	 * */
	private synchronized boolean atenderLlamadasSupervisor() {
		if(capaSupervisor > Supervisor.llamadasProceso) {
			Supervisor.llamadasProceso++;
			return true;
		}else {
			return false;
		}
	}
	
	/** se da elsip de la atencion de la llamada y se actualiza las 
	 * llamadas en proceso de capara pool de empleados por ramgo
	 * */
	private synchronized boolean atenderLlamadasDirector() {
		if(capaDirector > Director.llamadasProceso) {
			Director.llamadasProceso++;
			return true;
		}else {
			return false;
		}
	}
	
	/**en este metodo se mira si hay disponibilidad de algunos de los empleados
	 * para atender las llamadas en cola
	 * */
	private boolean hayCapacidadLlamadasEnCola() {
		if(capaDirector > Director.llamadasProceso 
				|| capaSupervisor > Supervisor.llamadasProceso
				|| capaOperador > Operador.llamadasProceso) {
			return true;
		}else {
			return false;
		}
	}
	
	/**se encola la llamada y es monitoreada con una lista que se apila y se des-apila segun el orden de llegada
	 * */
	private synchronized void encolar(Call call){
	    while(!hayCapacidadLlamadasEnCola()){
	        try{
	            wait(1000);
	        }catch(InterruptedException ex){}
	    }
	    dispatchCallEnCola(call);
	    lstQueve.remove(call);
	    notify();
	  }

	/* Encola */
	private void addCall(String callId, Call call) {
		lstQueve.add(call);
	}

	/* des-encola */
	private void deleteCall(String callId) {
		lstQueve.remove(callId);
	}

}
