package com.fadesp.paymentsreceiverapi.services;

import com.fadesp.paymentsreceiverapi.dto.PaymentRequest;
import com.fadesp.paymentsreceiverapi.dto.PaymentRequestUpdate;
import com.fadesp.paymentsreceiverapi.dto.PaymentResponse;
import com.fadesp.paymentsreceiverapi.entities.Payment;
import com.fadesp.paymentsreceiverapi.entities.mapper.PaymentMapper;
import com.fadesp.paymentsreceiverapi.enums.PaymentStatusEnum;
import com.fadesp.paymentsreceiverapi.exceptions.BadRequestException;
import com.fadesp.paymentsreceiverapi.exceptions.NotFoundException;
import com.fadesp.paymentsreceiverapi.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private PaymentMapper paymentMapper;

    public List<PaymentResponse> findAll() {
        List<Payment> list = repository.findAll();
        if (list.size() == 0) {
            throw new NotFoundException("Não existem pagamentos registados.");
        }
        return list.stream().map(paymentMapper::responseToDto).collect(Collectors.toList());
    }

    public PaymentResponse insert(PaymentRequest payment) {
        Payment newPayment = paymentMapper.requestToEntity(payment);
        return paymentMapper.responseToDto(repository.save(newPayment));
    }

    public PaymentResponse update(Long codigoDebito, PaymentRequestUpdate payment) {
        Payment oldPayment = repository.findById(codigoDebito).orElseThrow(() -> new NotFoundException("Débito com o código " + codigoDebito + " não encontrado. Informe um código existente."));
        if (oldPayment.getStatusPagamento() == PaymentStatusEnum.SUCESSO) {
            throw new BadRequestException("Esse pagamento já foi processado com sucesso e seu status não pode ser alterado.");
        } else if (oldPayment.getStatusPagamento() == PaymentStatusEnum.PENDENTE && payment.getStatusPagamento() == PaymentStatusEnum.PENDENTE) {
            throw new BadRequestException(("Esse pagamento está pendente de processamento e só pode ser alterado para o status de processado com sucesso ou processado com falha."));
        } else if (oldPayment.getStatusPagamento() == PaymentStatusEnum.FALHA && payment.getStatusPagamento() != PaymentStatusEnum.PENDENTE) {
            throw new BadRequestException("Esse pagamento foi processado com falha e só pode ser alterado para o status de pendente de processamento.");
        }

        try {
            oldPayment.setStatusPagamento(payment.getStatusPagamento());
            return paymentMapper.responseToDto(repository.save(oldPayment));
        } catch (Exception e) {
            oldPayment.setStatusPagamento(PaymentStatusEnum.FALHA);
            throw new BadRequestException("Esse pagamento foi processado com falha.");
        }
    }

    public void remove(Long codigoDebito) {
        Payment payment = repository.findById(codigoDebito).orElseThrow(() -> new NotFoundException("Débito com o código " + codigoDebito + " não encontrado. Informe um código existente."));
        if (payment.getStatusPagamento() != PaymentStatusEnum.PENDENTE) {
            throw new BadRequestException("Não é possível deletar pagamentos com status de processados com sucesso ou falha.");
        }
        repository.deleteById(codigoDebito);
    }

    public List<PaymentResponse> findByStatus(PaymentStatusEnum status) {
        List<Payment> list = repository.findByStatusPagamento(status);
        return list.stream().map(paymentMapper::responseToDto).collect(Collectors.toList());
    }

    public List<PaymentResponse> findByCpfCnpj(String cpfCnpj) {
        List<Payment> list = repository.findByCpfCnpj(cpfCnpj);
        return list.stream().map(paymentMapper::responseToDto).collect(Collectors.toList());
    }

    public PaymentResponse findByCodigoDebito(Long codigoDebito) {
        Payment payment = repository.findById(codigoDebito).orElseThrow(() -> new NotFoundException("Débito com o código " + codigoDebito + " não encontrado. Informe um código existente."));
        return paymentMapper.responseToDto(payment);
    }
}
