/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itst.taller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author yuls
 */
public class AlumnoDomain {
    
    @JsonProperty
    private int id;
    @JsonProperty
    private String uuid;
    @JsonProperty
    private String nombre;
    @JsonProperty
    private String matricula;
    @JsonProperty
    private String carrera;
    @JsonProperty
    private String message;

    public int getId() {
        return id;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
}
