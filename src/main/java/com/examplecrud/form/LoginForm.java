/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplecrud.form;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
public class LoginForm {
	@NotEmpty
	@Size(min = 1, max = 15)
	private String cuenta;
	@NotEmpty
	@Size(min = 1, max = 8)
	private String clave;

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getClave() {
		return clave;
	}
}
