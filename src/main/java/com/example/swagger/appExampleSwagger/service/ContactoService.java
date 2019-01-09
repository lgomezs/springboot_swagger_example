package com.example.swagger.appExampleSwagger.service;

import com.example.swagger.appExampleSwagger.bean.Contacto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContactoService {

	
	public Flux<Contacto> listAllContact();
	
	public Mono<Contacto> saveContacto(Contacto contacto);
	
	public Mono<Contacto> getContactoByID(String id);
	
	public Mono<Void> deleteContactoByID(String id) ;
	
	
}
