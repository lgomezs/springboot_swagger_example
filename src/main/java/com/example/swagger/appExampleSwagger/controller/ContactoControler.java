package com.example.swagger.appExampleSwagger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.appExampleSwagger.bean.Contacto;
import com.example.swagger.appExampleSwagger.service.ContactoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api(tags= {"ContactoControler"},description="Servicio de Negocios de Contacto ")
@RestController()
@RequestMapping("/contacto")
public class ContactoControler {
	
	@Autowired
	private ContactoService contactoService;
	
	@ApiOperation(value="Metodo que devuelve lista de Contactos.",response=Flux.class)
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Devolver lista de contactos fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al devolver la lista de contactos."),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
          @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
          @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	@GetMapping("/listAllContacto")	
	public Flux<Contacto> getAllContact(){		
			return contactoService.listAllContact();			
	}
	
	@ApiOperation(value="Metodo que registra un Contacto")
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Contacto registrado fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al registrar contacto."),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
	      @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
	      @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	@PostMapping("/saveContacto")
	public Mono<Contacto> saveContacto(@Valid @RequestBody Contacto contacto){
		return contactoService.saveContacto(contacto);		
	}
	
	@ApiOperation(value="Metodo que busca un Contacto por su ID")
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Contacto obtenido fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al obtener contacto."),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
	      @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
	      @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	@GetMapping("/contacto/{getID}")
	public Mono<ResponseEntity<Contacto>> getContactoByID(@PathVariable(value="getID") String getID){
		return contactoService.getContactoByID(getID).map(
				saveContacto -> ResponseEntity.ok(saveContacto))
				.defaultIfEmpty(ResponseEntity.notFound().build());	
	}
	
	@ApiOperation(value="Metodo que elimina un Contacto por su ID")
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Contacto eliminado fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al eliminar contacto."),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
	      @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
	      @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	@DeleteMapping("/deleteContacto/{getID}")
	public Mono<ResponseEntity<Void>> deleteContactoByID(@PathVariable(value="getID") String getID){
		return contactoService.getContactoByID(getID).flatMap(
					existingContacto -> 
						contactoService.deleteContactoByID(getID)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
				).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));		
	}	
	
}
