package br.com.zup.treinocasadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.treinocasadocodigo.config.validacao.CPFouCNPJ;
import br.com.zup.treinocasadocodigo.config.validacao.CustomExistingValue;
import br.com.zup.treinocasadocodigo.config.validacao.CustomUniqueValue;
import br.com.zup.treinocasadocodigo.estado.Estado;
import br.com.zup.treinocasadocodigo.pais.Pais;

public class ClienteForm {
	
	@NotBlank @Email @CustomUniqueValue(dataClass = Cliente.class, field = "email", message = "Email já cadastrado no sistema.")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@CPFouCNPJ @CustomUniqueValue(dataClass = Cliente.class, field = "documento", message = "Documento já cadastrado no sistema.")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull @CustomExistingValue(dataClass = Pais.class, field = "id", message = "País inexistente.")
	private Long idPais;
	@CustomExistingValue(dataClass = Estado.class, field = "id", message = "Estado inexistente.")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;	

	public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long idPais, Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, idPais);
		Estado estado = entityManager.find(Estado.class, idEstado);
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade,
				pais, estado, telefone, cep);
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}		

}
