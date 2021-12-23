package com.sun.bean;

public class CreditBill {

	private String accountId;
	private String name;
	private double amount;
	private String data;
	private String address;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CreditBill [accountId=" + accountId + ", name=" + name + ", amount=" + amount + ", data=" + data
				+ ", address=" + address + "]";
	}
	
	
}
