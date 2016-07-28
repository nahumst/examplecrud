/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplecrud.dao;

import com.examplecrud.model.Usuario;
import java.util.List;

/**
 *
 * @author nahum
 */
public interface UsuarioDAO {
    public void add(Usuario usuario);
    public void edit(Usuario usuario);
    public void delete(int id);
    public Usuario getUsuario(int id);
    public List getAllUsuarios();
    public boolean checkLogin(String cuenta, String clave);
}
