package com.example.swagger.appExampleSwagger.bean;

import java.io.Serializable;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contacto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String names;
	private String lastnames;
	private String email;
	private String fono;
	
}
