package br.com.zup.treinocasadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.treinocasadocodigo.config.validacao.CustomExistingValue;
import br.com.zup.treinocasadocodigo.config.validacao.CustomUniqueValue;
import br.com.zup.treinocasadocodigo.pais.Pais;

public class EstadoForm {
	
	@NotBlank @CustomUniqueValue(dataClass = Estado.class, field = "nome", message = "Estado já existe.")
	private String nome;
	@NotNull @CustomExistingValue(dataClass = Pais.class, field = "id", message = "País inexistente.")
	private Long idPais;
	
	public EstadoForm(@NotBlank String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, idPais);
		return new Estado(nome, pais);
	}
	
		

}
