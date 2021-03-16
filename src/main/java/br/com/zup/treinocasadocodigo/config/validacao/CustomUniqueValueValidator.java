package br.com.zup.treinocasadocodigo.config.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomUniqueValueValidator implements ConstraintValidator<CustomUniqueValue, Object> {
	
	@PersistenceContext
	private EntityManager entityManager;
	private String field;
	private Class<?> dataClass;
	
	
	@Override
	public void initialize(CustomUniqueValue constraintAnnotation) {
		field = constraintAnnotation.field();
		dataClass = constraintAnnotation.dataClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("select 1 from " + dataClass.getName() + " where " + field + " =: value ");
		query.setParameter("value", value);
		List<?> resultList = query.getResultList();
		
		return resultList.isEmpty();
	}
}
