package com.fadesp.paymentsreceiverapi.dto;

import com.fadesp.paymentsreceiverapi.enums.PaymentMethodEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PaymentRequest {

    @JsonIgnore
    private Long codigoDebito;
    @NotBlank(message = "CPF/CNPJ é obrigatório")
    private String cpfCnpj;
    @NotNull(message = "O método de pagamento é obrigatório")
    private PaymentMethodEnum metodoPagamento;
    private String numeroCartao;
    @Positive(message = "O valor de pagamento deve ser maior que zero")
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
