package com.fadesp.paymentsreceiverapi.dto;

import com.fadesp.paymentsreceiverapi.enums.PaymentStatusEnum;

public class PaymentRequestUpdate {

    private Long codigoDebito;
    private PaymentStatusEnum statusPagamento;

    public Long getCodigoDebito() {
        return codigoDebito;
    }

    public void setCodigoDebito(Long codigoDebito) {
        this.codigoDebito = codigoDebito;
    }

    public PaymentStatusEnum getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(PaymentStatusEnum statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}
