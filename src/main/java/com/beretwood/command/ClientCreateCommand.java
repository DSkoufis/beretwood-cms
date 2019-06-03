package com.beretwood.command;

import org.apache.commons.lang3.StringUtils;

public class ClientCreateCommand {

	private String email;
	private String name;
	private String surname;
	private String address1;
	private String address2;
	private String postCode;

	public ClientCreateCommand(String email, String postCode) {
		this.email = email;
		this.postCode = postCode;
	}

	public String getEmail() {
		return StringUtils.trimToNull(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return trim(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return trim(surname);
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress1() {
		return trim(address1);
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return trim(address2);
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostCode() {
		return StringUtils.trimToNull(postCode);
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	private static String trim(String string) {
		return StringUtils.trimToEmpty(string);
	}
}
