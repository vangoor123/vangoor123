package com.assignment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_info")
public class Order {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "order_no")
	private String orderNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "total_Amount")
	private Double totalAmount;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "is_order_complete")
	private char isOrderComplete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public char getIsOrderComplete() {
		return isOrderComplete;
	}

	public void setIsOrderComplete(char isOrderComplete) {
		this.isOrderComplete = isOrderComplete;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", status=" + status + ", isOrderComplete=" + isOrderComplete + "]";
	}
	
	
	

}
