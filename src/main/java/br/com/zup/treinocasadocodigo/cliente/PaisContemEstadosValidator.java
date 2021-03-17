package br.com.zup.treinocasadocodigo.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.treinocasadocodigo.pais.Pais;

@Component
public class PaisContemEstadosValidator implements Validator {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ClienteForm clienteForm = (ClienteForm) target;
		if(errors.hasErrors() || clienteForm.getIdEstado() != null) {
			return;
		}
		
		Pais pais = entityManager.find(Pais.class, clienteForm.getIdPais());
		
		Query query = entityManager.createQuery("SELECT e FROM Estado e WHERE e.pais = :value");
		query.setParameter("value", pais);
		List<?> resultList = query.getResultList();
		
		if(resultList.size() > 0) {
            errors.rejectValue("idEstado", null, "Estado é obrigatório.");
        }	
		
	}

}
