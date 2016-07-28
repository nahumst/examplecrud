/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplecrud.service.impl;

import com.examplecrud.dao.UsuarioDAO;
import com.examplecrud.model.Usuario;
import com.examplecrud.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author nahum
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Transactional
    public void add(Usuario usuario) {
        usuarioDAO.add(usuario);
    }

    @Transactional
    public void edit(Usuario usuario) {
        usuarioDAO.edit(usuario);
    }

    @Transactional
    public void delete(int id) {
        usuarioDAO.delete(id);
    }

    @Transactional
    public Usuario getUsuario(int id) {
        return usuarioDAO.getUsuario(id);
    }

    @Transactional
    public List getAllUsuarios() {
        return usuarioDAO.getAllUsuarios();
    }
    @Transactional
    public boolean checkLogin(String cuenta, String clave){
        return usuarioDAO.checkLogin(cuenta, clave);
    }
    
}
