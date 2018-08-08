package com.almundo.callcenter.entidad;

import com.almundo.callcenter.Dispatcher;

public class LlamadaEnEspera implements Runnable{
	private Call call;
	public LlamadaEnEspera(Call call) {
		this.call = call;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("inicio Llamada en espera: " +call.getId()+"    "+ call.getFrom() + "   "+call.getId()+" running");
		encolar(call);		
		
	}

	public synchronized void encolar(Call call){
	    while(!atenderLlamadasEnCola()){
	        try{
	            wait(1000);
	        }catch(InterruptedException ex){}
	    }
	    System.out.println("descencolar ............. ");
//	    dispatchCallEnCola(call);
//	    lstQueve.remove(call);
	    notifyAll();
//	    return contenido;
	  }
	
	public synchronized boolean atenderLlamadasEnCola() {
		if(Dispatcher.capaDirector > Director.llamadasProceso ) {
			return true;
		}else {
			return false;
		}
	}
}
