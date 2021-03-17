package br.com.zup.treinocasadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private PaisContemEstadosValidator paisValidator;
	@Autowired
	private EstadoPertenceAPaisValidator estadoValidator;
	
	@InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoValidator, paisValidator);
    }
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm clienteForm){
		Cliente cliente = clienteForm.toModel(entityManager);
		entityManager.persist(cliente);
		
		return ResponseEntity.ok(new ClienteDTO(cliente));
		
	}

}
