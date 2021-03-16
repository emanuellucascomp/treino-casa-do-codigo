package br.com.zup.treinocasadocodigo.config.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { CustomExistingValueValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomExistingValue {
	
	String message() default "Entidade não existente";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String field();
	
	Class<?> dataClass();

}
