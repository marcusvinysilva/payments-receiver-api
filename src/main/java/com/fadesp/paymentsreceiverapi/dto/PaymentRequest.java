package com.fadesp.paymentsreceiverapi.dto;

import com.fadesp.paymentsreceiverapi.entities.Payment;
import com.fadesp.paymentsreceiverapi.enums.PaymentMethodEnum;
import com.fadesp.paymentsreceiverapi.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaymentRequest {

	@JsonIgnore
	private Long codigoDebito;
	@NotEmpty
	private String cpfCnpj;
	@NotNull
	private PaymentMethodEnum metodoPagamento;
	private String numeroCartao;
	@NotNull
	private Double valorPagamento;

	public Long getCodigoDebito() {
		return codigoDebito;
	}

	public void setCodigoDebito(Long codigoDebito) {
		this.codigoDebito = codigoDebito;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public PaymentMethodEnum getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(PaymentMethodEnum metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
}
