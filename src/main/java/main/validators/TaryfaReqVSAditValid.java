package main.validators;


import main.entity.Liczydlo;
import main.entity.Taryfa;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

public class TaryfaReqVSAditValid implements ConstraintValidator<TaryfaReqVSAdit, Taryfa> {
    @Override
    public void initialize(TaryfaReqVSAdit constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Taryfa taryfa, ConstraintValidatorContext constraintValidatorContext) {
        ArrayList<Liczydlo> liczydlaReq = taryfa.getLiczydlaReq();
        ArrayList<Liczydlo> liczydlaAdit = taryfa.getLiczydlaAdit();
        if (liczydlaAdit.size() == 0){
            return true;
        }
        for (Liczydlo liczydlo: liczydlaReq) {
            for (Liczydlo liczydloAdit: liczydlaAdit) {
                if (liczydloAdit.getName().equals(liczydlo.getName())){
                    return false;
                }
            }
        }
        return true;
    }
}
