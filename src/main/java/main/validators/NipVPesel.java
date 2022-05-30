package main.validators;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
    @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
            ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = NipVPesValid.class)
    @Documented
    public @interface NipVPesel {
        String message() default "Musi być wprowadzony Nip lub Pesel";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }

