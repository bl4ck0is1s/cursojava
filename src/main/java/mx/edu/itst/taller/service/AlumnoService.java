/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itst.taller.service;

import java.util.Map;
import java.util.Optional;

import mx.edu.itst.taller.dao.impl.AlumnoDAOImpl;
import mx.edu.itst.taller.domain.AlumnoDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yuls
 */

@Service
public class AlumnoService {
    
	@Autowired
	AlumnoDAOImpl alumnosDAO;
	
	public Optional<AlumnoDomain> save(Map<String, Object> input ) {
		AlumnoDomain alumnoDomain = new AlumnoDomain();
		try {
			String nombre  = input.get("nombre").toString();
			if (nombre.equals("")) {
				alumnoDomain.setMessage("el nombre es obligatorio");
				return Optional.of(alumnoDomain);
			} else{
				alumnoDomain.setNombre(nombre);
			}
			
			String carrera  = input.get("carrera").toString();
			if (carrera.equals("")) {
				alumnoDomain.setMessage("el carrera es obligatorio");
				return Optional.of(alumnoDomain);
			} else {
				alumnoDomain.setCarrera(carrera);
			}
			
			String matricula  = input.get("matricula").toString();
			if (matricula.equals("")) {
				alumnoDomain.setMessage("el matricula es obligatorio");
				return Optional.of(alumnoDomain);
			} else {
				alumnoDomain.setMatricula(matricula);
			}
			
			return alumnosDAO.save(alumnoDomain);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return null;
	}
}
