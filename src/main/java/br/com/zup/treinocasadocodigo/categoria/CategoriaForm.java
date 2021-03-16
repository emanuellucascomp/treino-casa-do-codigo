package br.com.zup.treinocasadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.treinocasadocodigo.config.validacao.CustomUniqueValue;

public class CategoriaForm {
	
	@NotBlank @CustomUniqueValue(dataClass = Categoria.class, field = "nome" , message = "Nome já cadastrado no sistema.")
	private String nome;
	
	@JsonCreator
	public CategoriaForm(@NotBlank @JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}
}
