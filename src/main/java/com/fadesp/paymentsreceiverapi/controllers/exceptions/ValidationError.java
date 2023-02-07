package com.fadesp.paymentsreceiverapi.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(FieldMessage error) {
        errors.add(error);
    }

}
