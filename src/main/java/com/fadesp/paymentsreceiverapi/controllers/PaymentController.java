package com.fadesp.paymentsreceiverapi.controllers;

import java.net.URI;
import java.util.List;

import com.fadesp.paymentsreceiverapi.dto.PaymentRequestUpdate;
import com.fadesp.paymentsreceiverapi.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fadesp.paymentsreceiverapi.dto.PaymentRequest;
import com.fadesp.paymentsreceiverapi.services.PaymentService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.ws.Response;

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
    public ResponseEntity<PaymentResponse> insert(@RequestBody @Valid PaymentRequest payment) {
        PaymentResponse newPayment = service.insert(payment);
        return ResponseEntity.ok().body(newPayment);
    }

    @PutMapping("/{codigoDebito}")
    public ResponseEntity<PaymentResponse> update(@PathVariable Long codigoDebito, @RequestBody PaymentRequestUpdate payment) {
        PaymentResponse paymentUpdated = service.update(codigoDebito, payment);
        return ResponseEntity.ok().body(paymentUpdated);
    }

    @DeleteMapping("/{codigoDebito}")
    public ResponseEntity<Void> remove(@PathVariable Long codigoDebito) {
        service.remove(codigoDebito);
        return ResponseEntity.noContent().build();
    }
}
