package com.fadesp.paymentsreceiverapi.dto;

import com.fadesp.paymentsreceiverapi.enums.PaymentMethodEnum;
import com.fadesp.paymentsreceiverapi.enums.PaymentStatusEnum;

public class PaymentResponse {
    private Long codigoDebito;
    private String cpfCnpj;
    private PaymentMethodEnum metodoPagamento;
    private String numeroCartao;
    private Double valorPagamento;
    private PaymentStatusEnum statusPagamento;

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
