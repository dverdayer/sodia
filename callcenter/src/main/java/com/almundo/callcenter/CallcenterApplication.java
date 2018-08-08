package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.almundo.callcenter.entidad.Call;

@SpringBootApplication
public class CallcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallcenterApplication.class, args);
		
		
		Dispatcher dispatcher = new Dispatcher();		
		for(int i=0; i<25; i++) {
			Call call = new Call("id-"+i, "from-"+i, "suject-"+i);
			dispatcher.dispatchCall(call);
		}		
		
		
		
	}
}
