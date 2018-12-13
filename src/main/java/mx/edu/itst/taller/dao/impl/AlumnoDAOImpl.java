/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itst.taller.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import mx.edu.itst.taller.dao.AlumnoDAO;
import mx.edu.itst.taller.domain.AlumnoDomain;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author yuls
 */

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	JdbcTemplate jsbc = new JdbcTemplate();
	
	
	
    @Override
    public Optional<AlumnoDomain> save(AlumnoDomain alumno) {
        try {
			String uuid = UUID.randomUUID().toString();
			String sql = "INSERT INTO alumno "
					+ "(uuid, nombre, carrera, matricula)"
					+ "values (?,?,?,?)";
			int succeded = jdbcTemplate.update(sql,
					new Object[]{uuid, alumno.getNombre(),
					alumno.getCarrera(), alumno.getMatricula()});
			
			if (succeded == 1) {
				System.out.println("Registro Agregado correctamente");
				alumno.setMessage("Registro guardado");
			}
			
			return Optional.of(alumno);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    @Override
    public void edit(AlumnoDomain alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AlumnoDomain> getAll() {
        String sql = "select * from alumno";
        try {
			List<AlumnoDomain> lstAlumnos = jdbcTemplate.query(sql, 
					new BeanPropertyRowMapper<AlumnoDomain>(AlumnoDomain.class));
			
			return lstAlumnos;
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;
    }

    @Override
    public AlumnoDomain getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
