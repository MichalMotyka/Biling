package main.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TaryfaReqVSAditValid.class)
@Documented
public @interface TaryfaReqVSAdit {
    String message() default "Składniki wymagane nie mogą pokrywać się z dodatkowymi";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

