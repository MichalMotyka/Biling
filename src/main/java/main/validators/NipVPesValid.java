package main.validators;

import main.entity.kontrahent;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NipVPesValid implements ConstraintValidator<NipVPesel, kontrahent> {


    @Override
    public void initialize(NipVPesel constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(kontrahent s, ConstraintValidatorContext constraintValidatorContext) {
        if(!s.getNIP().equals("") || !s.getPesel().equals("")){
            if(s.getNIP().equals("") && !s.getPesel().equals("")){
                return true;
            }
            if(!s.getNIP().equals("") && s.getPesel().equals("")){
                return true;
            }
            if (s.getNIP().equals("") && s.getPesel().equals("")){
                return false;
            }
        }
        return false;
    }
}
