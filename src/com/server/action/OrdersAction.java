package com.server.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.server.entity.Orders;

public class OrdersAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, ModelDriven<Orders>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Orders order;

	HttpServletRequest request = null;
	HttpServletResponse response = null;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void push() {
		System.out.println(order.getTheme());
	}
	
	public void get() {
		String pId = (String) request.getAttribute("pId");
		
		System.out.println("get:" + pId);
	}
	
	public void find() {
		String pId = (String) request.getAttribute("pId");
		int type = (int) request.getAttribute("type");
		int dataIndex = (int) request.getAttribute("dataIndex");
		
		System.out.println("find:" + pId);
		System.out.println("find:" + type);
		System.out.println("find:" + dataIndex);
	}

	@Override
	public Orders getModel() {
		if (order == null)
			order = new Orders();
		return order;
	}
}
