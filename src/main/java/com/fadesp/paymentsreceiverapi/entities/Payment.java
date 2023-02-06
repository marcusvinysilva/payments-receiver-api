package com.fadesp.paymentsreceiverapi.entities;

import javax.persistence.*;

import com.fadesp.paymentsreceiverapi.enums.PaymentMethodEnum;
import com.fadesp.paymentsreceiverapi.enums.PaymentStatusEnum;

@Entity
@Table(name = "tb_payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_debito")
	private Long codigoDebito;

	@Column(name = "cpf_cnpj")
	private String cpfCnpj;

	@Column(name = "metodo_pagamento")
	@Enumerated(EnumType.STRING)
	private PaymentMethodEnum metodoPagamento;

	@Column(name = "numero_cartao")
	private String numeroCartao;

	@Column(name = "valor_pagamento")
	private Double valorPagamento;

	@Column(name = "status_pagamento")
	@Enumerated(EnumType.STRING)
	private PaymentStatusEnum statusPagamento;

	public Payment() {
	}

	public Payment(Long codigoDebito, String cpfCnpj, PaymentMethodEnum metodoPagamento, String numeroCartao,
			Double valorPagamento, PaymentStatusEnum statusPagamento) {
		this.codigoDebito = codigoDebito;
		this.cpfCnpj = cpfCnpj;
		this.metodoPagamento = metodoPagamento;
		this.numeroCartao = numeroCartao;
		this.valorPagamento = valorPagamento;
		this.statusPagamento = statusPagamento;
	}

	@PrePersist
	public void pendingStatus() {
		this.setStatusPagamento(PaymentStatusEnum.PENDENTE);
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

	public PaymentStatusEnum getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(PaymentStatusEnum statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

}
