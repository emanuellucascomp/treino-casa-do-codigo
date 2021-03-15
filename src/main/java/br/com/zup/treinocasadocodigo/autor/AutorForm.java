package br.com.zup.treinocasadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.treinocasadocodigo.config.validacao.CustomUniqueValue;

public class AutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank @Email @CustomUniqueValue(message = "Email já cadastrado no sistema.")
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public AutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}	
	
	public Autor toModel() {
		return new Autor(nome, email, descricao);
	}
	
	public String getEmail() {
		return this.email;
	}
	

}
