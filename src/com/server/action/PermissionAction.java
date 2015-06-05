package com.server.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.server.control.Control;
import com.server.entity.Persons;

public class PermissionAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, ModelDriven<Persons> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = null;
	HttpServletResponse response = null;

	private Persons user;

	public Persons getUser() {
		return user;
	}

	public void setUser(Persons user) {
		this.user = user;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void register() {
		Control.getInstance().register(user);
	}

	@Override
	public Persons getModel() {
		if (user == null)
			user = new Persons();
		return user;
	}
}
