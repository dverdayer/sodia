package com.almundo.callcenter.entidad;


public class Operador extends Empleado {

	public static int llamadasProceso = 0;
	public static int llamadasProcesadas = 0;
	
	private Call call;
	
	public Operador(Call call) {
		this.call = call;
	}
	
	/** Implemencion del hilo y se pone a dormir a fin de emular la duracion de la llamada*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("inicio atencion Operador: " +call.getId()+"    "+ call.getFrom() + "   "+call.getId()+" running");
		int nlduracionllamada = duracionLlamada();
		try {
			Thread.sleep(nlduracionllamada*1000);			
			System.out.println("llamada procesada Operador: " +call.getId()+"    "+ call.getFrom() + "   "+call.getId()+" runned 		duracion llamada(seg): "+nlduracionllamada+"  numerollamadasProcesadas:"+llamadasProcesadas);
			llamadasProcesadas++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			llamadasProceso--;
		}
	}	
	
	
	    
}
