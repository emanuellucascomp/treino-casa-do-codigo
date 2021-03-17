package br.com.zup.treinocasadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zup.treinocasadocodigo.estado.Estado;
import br.com.zup.treinocasadocodigo.pais.Pais;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String nome;
	private String sobrenome;
	@Column(unique = true)
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	private String telefone;
	private String cep;	
	
	@Deprecated
	public Cliente() {}
	
	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Pais pais, Estado estado, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

}
