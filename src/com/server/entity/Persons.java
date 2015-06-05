package com.server.entity;

import java.util.HashSet;
import java.util.Set;

public class Persons {
	/**
	 * 人物ID
	 */
	private String id = "";
	
	/**
	 * 头像
	 */
	private String headImg = "";
	
	/**
	 * 账号名
	 */
	private String name = "";
	
	/**
	 * 手机/登陆账号
	 */
	private String phone = "";
	
	/**
	 * 密码
	 */
	private String passwd = "";
	
	/**
	 * 性别
	 */
	private int sex;
	
	/**
	 * 地点
	 */
	private String area;
	
	/**
	 * 身份证号
	 */
	private String pId = "";
	
	/**
	 * 姓名
	 */
	private String pName = "";
	
	private Set<String> pushOId = new HashSet<String>();
	
	private Set<String> getOID = new HashSet<String>();
	
	/**
	 * 荣誉值
	 */
	private long honourNum = 0L;
	
	private int dataIndex = 0;
	
	private int getDataIndex = 0;

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public long getHonourNum() {
		return honourNum;
	}

	public void setHonourNum(long honourNum) {
		this.honourNum = honourNum;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(int dataIndex) {
		this.dataIndex = dataIndex;
	}

	public int getGetDataIndex() {
		return getDataIndex;
	}

	public void setGetDataIndex(int getDataIndex) {
		this.getDataIndex = getDataIndex;
	}

	public Set<String> getPushOId() {
		return pushOId;
	}

	public void setPushOId(Set<String> pushOId) {
		this.pushOId = pushOId;
	}

	public Set<String> getGetOID() {
		return getOID;
	}

	public void setGetOID(Set<String> getOID) {
		this.getOID = getOID;
	}
}
