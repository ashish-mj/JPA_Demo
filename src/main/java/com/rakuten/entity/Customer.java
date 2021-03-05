package com.rakuten.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//mandatory
@Table(name ="Customer_info")//optional
public class Customer {
	@Id//mandatory
private int custId;
	@Column(name="CUSTOMER_NAME")//optional
private String custName;
private String email;

public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}



}




