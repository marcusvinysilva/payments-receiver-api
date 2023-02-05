package com.fadesp.paymentsreceiverapi.enums;

public enum PaymentStatus {
	
	SUCESS("sucesso"),
	FAILURE("falha"),
	PENDING("pendente");
	
	private String value;

	private PaymentStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
