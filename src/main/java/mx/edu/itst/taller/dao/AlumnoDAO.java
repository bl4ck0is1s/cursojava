/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itst.taller.dao;

import java.util.List;
import java.util.Optional;

import mx.edu.itst.taller.domain.AlumnoDomain;

/**
 *
 * @author yuls
 */
public interface AlumnoDAO {
    
    public Optional<AlumnoDomain> save(AlumnoDomain alumno);
    
    public void edit(AlumnoDomain alumno);
    
    public void delete(int id);
    
    public List<AlumnoDomain> getAll();
    
    public AlumnoDomain getById(int id);
    
}
