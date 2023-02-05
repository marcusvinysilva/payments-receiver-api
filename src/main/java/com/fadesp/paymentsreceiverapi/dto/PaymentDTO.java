package com.fadesp.paymentsreceiverapi.dto;

import com.fadesp.paymentsreceiverapi.entities.Payment;
import com.fadesp.paymentsreceiverapi.enums.PaymentMethodEnum;
import com.fadesp.paymentsreceiverapi.enums.PaymentStatus;

public class PaymentDTO {

	private Long codigoDebito;
	private String cpfCnpj;
	private PaymentMethodEnum metodoPagamento;
	private String numeroCartao;
	private Double valorPagamento;
	private PaymentStatus statusPagamento;

	public PaymentDTO() {
	}

	public PaymentDTO(Long codigoDebito, String cpfCnpj, PaymentMethodEnum metodoPagamento, String numeroCartao,
			Double valorPagamento, PaymentStatus statusPagamento) {
		this.codigoDebito = codigoDebito;
		this.cpfCnpj = cpfCnpj;
		this.metodoPagamento = metodoPagamento;
		this.numeroCartao = numeroCartao;
		this.valorPagamento = valorPagamento;
		this.statusPagamento = statusPagamento;
	}

	public PaymentDTO(Payment entity) {
		this.codigoDebito = entity.getCodigoDebito();
		this.cpfCnpj = entity.getCpfCnpj();
		this.metodoPagamento = entity.getMetodoPagamento();
		this.numeroCartao = entity.getNumeroCartao();
		this.valorPagamento = entity.getValorPagamento();
		this.statusPagamento = entity.getStatusPagamento();
	}

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

	public PaymentStatus getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(PaymentStatus statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

}
