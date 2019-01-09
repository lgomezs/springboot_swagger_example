package com.example.swagger.appExampleSwagger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger.appExampleSwagger.bean.Contacto;
import com.example.swagger.appExampleSwagger.respository.ContactoRepository;
import com.example.swagger.appExampleSwagger.service.ContactoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactoServiceImpl implements ContactoService{

	@Autowired
	private ContactoRepository contactoRepository;
	
	public Flux<Contacto> listAllContact() {	
			return contactoRepository.findAll();				
	}
	
	public Mono<Contacto> saveContacto(Contacto contacto){
		return  contactoRepository.save(contacto);
	}
	
	public Mono<Contacto> getContactoByID(String id){
		return contactoRepository.findById(id);
	}
	
	public Mono<Void> deleteContactoByID(String id) {
		return contactoRepository.deleteById(id);
	}
}
