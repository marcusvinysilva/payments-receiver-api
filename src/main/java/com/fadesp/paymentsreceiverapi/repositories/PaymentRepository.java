package com.fadesp.paymentsreceiverapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fadesp.paymentsreceiverapi.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
