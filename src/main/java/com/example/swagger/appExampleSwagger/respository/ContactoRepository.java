package com.example.swagger.appExampleSwagger.respository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.swagger.appExampleSwagger.bean.Contacto;



@Repository
public interface ContactoRepository extends ReactiveMongoRepository<Contacto, String>{

}
