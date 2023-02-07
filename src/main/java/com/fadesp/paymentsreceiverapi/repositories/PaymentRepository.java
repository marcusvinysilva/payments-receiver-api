package com.fadesp.paymentsreceiverapi.repositories;

import com.fadesp.paymentsreceiverapi.entities.Payment;
import com.fadesp.paymentsreceiverapi.enums.PaymentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    public List<Payment> findByStatusPagamento(PaymentStatusEnum status);

    public List<Payment> findByCpfCnpj(String cpfCnpj);

}
