package br.com.zup.treinocasadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.treinocasadocodigo.estado.Estado;
import br.com.zup.treinocasadocodigo.pais.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ClienteForm clienteForm = (ClienteForm) target;
		if(errors.hasErrors()) {
			return;
		}
		
		Pais pais = entityManager.find(Pais.class, clienteForm.getIdPais());
		
		if(clienteForm.getIdEstado() != null) {
			Estado estado = entityManager.find(Estado.class, clienteForm.getIdEstado());			
			if(!pais.equals(estado.getPais())) {
				errors.rejectValue("idEstado", null, "Estado não pertence ao país.");
			}	
			
		}
		
		
	}
}
