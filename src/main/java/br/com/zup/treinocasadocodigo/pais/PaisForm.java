package br.com.zup.treinocasadocodigo.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.treinocasadocodigo.config.validacao.CustomUniqueValue;

public class PaisForm {
	
	@NotBlank @CustomUniqueValue(dataClass = Pais.class, field = "nome", message = "País já cadastrado.")
	private String nome;

	@JsonCreator
	public PaisForm(@NotBlank @JsonProperty("nome") String nome) {
		this.nome = nome;
	}
	
	public Pais toModel() {
		return new Pais(nome);
	}

}
