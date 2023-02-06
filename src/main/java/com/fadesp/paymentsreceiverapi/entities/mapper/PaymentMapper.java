package com.fadesp.paymentsreceiverapi.entities.mapper;

import com.fadesp.paymentsreceiverapi.dto.PaymentRequest;
import com.fadesp.paymentsreceiverapi.dto.PaymentResponse;
import com.fadesp.paymentsreceiverapi.entities.Payment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentMapper {
    PaymentResponse responseToDto(Payment payment);

    Payment requestToEntity(PaymentRequest request);
}
