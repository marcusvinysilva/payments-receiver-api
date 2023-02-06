package com.fadesp.paymentsreceiverapi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.fadesp.paymentsreceiverapi.dto.PaymentResponse;
import com.fadesp.paymentsreceiverapi.entities.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadesp.paymentsreceiverapi.dto.PaymentRequest;
import com.fadesp.paymentsreceiverapi.entities.Payment;
import com.fadesp.paymentsreceiverapi.repositories.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional(readOnly = true)
    public List<PaymentResponse> findAll() {
        List<Payment> list = repository.findAll();
        return list.stream().map(paymentMapper::responseToDto).collect(Collectors.toList());
    }

    @Transactional
    public PaymentResponse insert(PaymentRequest payment) {
        Payment newPayment = paymentMapper.requestToEntity(payment);
        return paymentMapper.responseToDto(repository.save(newPayment));
    }
}
