package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.almundo.callcenter.entidad.Call;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallcenterApplicationTests {

	
	@Autowired
	private Dispatcher dispatcher;
	
	
	/**
	 * Prueba con 10 llamadas donde se llama al metodo contruccionCAll con el @numeroDellamadas con el fin de parametrizar la prueba
	 * */
	@Test
    public void pruebaLlamadas10() throws Exception {
		contruccionCAll(10);
    }
	
	@Test
    public void pruebaLlamadas20() throws Exception {
		contruccionCAll(20);
    }
	
	/**
	 * invoca el dispacher @numeroDellamadas 
	 * */
	private void contruccionCAll(int numeroDellamadas) {
		List<Call> lstCall = new ArrayList<>();
		for(int i=0; i<numeroDellamadas; i++) {
			Call call = new Call("id-"+i, "from-"+i, "suject-"+i);
			dispatcher.dispatchCall(call);
		}		
	}
	
	

}
