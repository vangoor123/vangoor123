package com.assignment.entity;

public enum Status {

	CREATED(0), INPORGRESS(1), DELIVERED(2), CANCELLED(3);

	private int value;

	private Status(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
