package br.com.turorial.estudos.vendas.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ConstraintValidationList implements ConstraintValidator<NotEmptList, List> {

    @Override
    public void initialize(NotEmptList constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}
