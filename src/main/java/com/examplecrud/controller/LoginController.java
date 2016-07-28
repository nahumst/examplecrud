/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplecrud.controller;

import com.examplecrud.form.LoginForm;
import com.examplecrud.service.UsuarioService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nahum
 */
@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
   
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showForm(Map model) {
        LoginForm loginForm = new LoginForm();
	model.put("login", loginForm);
	return "login";
    }
    
    @RequestMapping(value="login/login.do", method=RequestMethod.POST)
    public String doActions(@Valid LoginForm loginForm, BindingResult result,
			Map model) {
        boolean userExists = usuarioService.checkLogin(loginForm.getCuenta(),loginForm.getClave());
        if(userExists){
            model.put("login", loginForm);
            return "loginsuccess";
        }else{
            loginForm = new LoginForm();
            model.put("login", loginForm);
            return "login";
	}
    }
}
