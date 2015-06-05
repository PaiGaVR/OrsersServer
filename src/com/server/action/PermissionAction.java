package com.server.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
	
	public void login() {
		user = Control.getInstance().login(user);
		
		JSONObject jsonUser = JSONObject.fromObject(user);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(jsonUser);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != writer)
				writer.close();
		}
	}

	@Override
	public Persons getModel() {
		if (user == null)
			user = new Persons();
		return user;
	}
}
