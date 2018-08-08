package com.almundo.callcenter.entidad;

/**clase abstracta para el manejo de los empleados 
 * con la implementacion Runnable para el manejo de hilos 
 * */
public abstract class Empleado implements Runnable{
	
	public int CAPACIDAD_LLAMADAS = 10;
	public int TIEMPO_MIN_LLAMADAS = 5;
	public int TIEMPO_MAX_LLAMADAS = 10;
		
	/** metodo utilitario para el manejo de la durecion de la llamada  de 5 a 10 segundos aleatoria*/
	public int duracionLlamada() {
		int range = (TIEMPO_MAX_LLAMADAS - TIEMPO_MIN_LLAMADAS) + 1;     
		return 	(int)(Math.random() * range) + TIEMPO_MIN_LLAMADAS;
	}
	
}
