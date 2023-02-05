package com.fadesp.paymentsreceiverapi.enums;

public enum PaymentMethodEnum {

	TICKET("boleto"),
	PIX("pix"),
	CREDIT_CARD("cartao_credito"),
	DEBIT_CARD("cartao_debito");
	
	private String value;
	
	private PaymentMethodEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
