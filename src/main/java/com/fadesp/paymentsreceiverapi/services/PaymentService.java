package com.fadesp.paymentsreceiverapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fadesp.paymentsreceiverapi.dto.PaymentDTO;
import com.fadesp.paymentsreceiverapi.entities.Payment;
import com.fadesp.paymentsreceiverapi.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	@Transactional(readOnly = true)
	public List<PaymentDTO> findAll() {
		List<Payment> list = repository.findAll();
		return list.stream().map(x -> new PaymentDTO(x)).collect(Collectors.toList());
	}

}
