/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplecrud.controller;

import com.examplecrud.model.Usuario;
import com.examplecrud.service.UsuarioService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nahum
 */
@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("/")
    public String setupForm(Map<String, Object> map){
        Usuario usuario = new Usuario();
        map.put("usuario", usuario);
        map.put("usuarioList", usuarioService.getAllUsuarios());
        return "usuario";
    }
    
    @RequestMapping(value="/usuario.do", method=RequestMethod.POST)
    public String doActions(@ModelAttribute Usuario usuario, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Usuario usuarioResult = new Usuario();
        switch (action.toLowerCase()) {	
            case "agregar":
                usuarioService.add(usuario);
                usuarioResult = usuario;
                break;
            case "editar":
                usuarioService.edit(usuario);
                usuarioResult = usuario;
                break;
            case "eliminar":
                usuarioService.delete(usuario.getId());
                usuarioResult = new Usuario();
                break;
            case "buscar":
                Usuario searchedUsuario = usuarioService.getUsuario(usuario.getId());
                usuarioResult = searchedUsuario != null ? searchedUsuario : new Usuario();
                break;
        }
        map.put("usuario", usuarioResult);
        map.put("usuarioList", usuarioService.getAllUsuarios());
        return "usuario";
    }
}
