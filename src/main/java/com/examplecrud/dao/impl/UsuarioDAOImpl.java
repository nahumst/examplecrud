/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplecrud.dao.impl;

import com.examplecrud.dao.UsuarioDAO;
import com.examplecrud.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nahum
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
    @Autowired
    private SessionFactory session;

    @Override
    public void add(Usuario usuario) {
        session.getCurrentSession().save(usuario);
        
    }

    @Override
    public void edit(Usuario usuario) {
        session.getCurrentSession().update(usuario);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getUsuario(id));
    }

    @Override
    public Usuario getUsuario(int id) {
        return (Usuario) session.getCurrentSession().get(Usuario.class, id);
    }

    @Override
    public List getAllUsuarios() {
        return session.getCurrentSession().createQuery("from usuarios").list();
    }

    @Override
    public boolean checkLogin(String cuenta, String clave) {
	boolean userFound = false;
	//Query using Hibernate Query Language
	String SQL_QUERY =" from usuarios as o where o.cuenta=? and o.clave=?";
	Query query = session.getCurrentSession().createQuery(SQL_QUERY);
	query.setParameter(0,cuenta);
	query.setParameter(1,clave);
	List list = query.list();
        if ((list != null) && (list.size() > 0)) {
            userFound= true;
	}
        //session.close();
	return userFound;              
    }
    
}
