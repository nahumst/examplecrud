/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplecrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nahum
 */

@Entity(name="usuarios")
public class Usuario {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int id;
    @Column
    private String cuenta;
    @Column
    private String clave;
    @Column
    private String nombre;
    
    public Usuario(){};
    public Usuario(int id, String cuenta, String clave, String nombre) {
        this.id = id;
        this.cuenta = cuenta;
        this.clave = clave;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
    
}
