package com.fadesp.paymentsreceiverapi.controllers;

import com.fadesp.paymentsreceiverapi.dto.PaymentRequest;
import com.fadesp.paymentsreceiverapi.dto.PaymentRequestUpdate;
import com.fadesp.paymentsreceiverapi.dto.PaymentResponse;
import com.fadesp.paymentsreceiverapi.enums.PaymentStatusEnum;
import com.fadesp.paymentsreceiverapi.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> findAll() {
        List<PaymentResponse> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> insert(@Valid @RequestBody PaymentRequest payment) {
        PaymentResponse newPayment = service.insert(payment);
        return ResponseEntity.ok().body(newPayment);
    }

    @PutMapping("/{codigoDebito}")
    public ResponseEntity<PaymentResponse> update(@PathVariable Long codigoDebito, @RequestBody @Valid PaymentRequestUpdate payment) {
        PaymentResponse paymentUpdated = service.update(codigoDebito, payment);
        return ResponseEntity.ok().body(paymentUpdated);
    }

    @DeleteMapping("/{codigoDebito}")
    public ResponseEntity<Void> remove(@PathVariable Long codigoDebito) {
        service.remove(codigoDebito);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/busca-status/{status}")
    public ResponseEntity<List<PaymentResponse>> findByStatus(@PathVariable PaymentStatusEnum status) {
        List<PaymentResponse> list = service.findByStatus(status);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/busca-cnpj/{cpfCnpj}")
    public ResponseEntity<List<PaymentResponse>> findByCnpj(@PathVariable String cpfCnpj) {
        List<PaymentResponse> list = service.findByCpfCnpj(cpfCnpj);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/codigo-debito/{codigoDebito}")
    public ResponseEntity<PaymentResponse> findByCodigoDebito(@PathVariable Long codigoDebito) {
        PaymentResponse payment = service.findByCodigoDebito(codigoDebito);
        return ResponseEntity.ok().body(payment);
    }
}
