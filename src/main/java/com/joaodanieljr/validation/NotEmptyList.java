package com.joaodanieljr.validation;

import com.joaodanieljr.validation.constrainvalidation.NotEmptyListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//VERIFICADO EM TEMPO DE EXECUCAO
@Target(ElementType.FIELD)//ONDE POSSO COLOCAR ESSA ANNOTATION
@Constraint(validatedBy = NotEmptyListValidator.class)//QUAL CLASSE IRA VALIDAR
public @interface NotEmptyList {

    String message() default "A lista nao pode ser vazia";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
