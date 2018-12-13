/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itst.taller.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import mx.edu.itst.taller.domain.AlumnoDomain;
import mx.edu.itst.taller.service.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yuls
 */
@RestController
@RequestMapping(value = "/v1/")
public class AlumnoController {
    
	@Autowired
	AlumnoService alumnosService;
	
    @RequestMapping(value = "alumno/save", method = RequestMethod.POST, produces = "application/json")
    public AlumnoDomain save(HttpServletResponse response, @RequestBody Map<String, Object> input
                        ){
    	
    	return 	alumnosService.save(input).get();

    }
}
