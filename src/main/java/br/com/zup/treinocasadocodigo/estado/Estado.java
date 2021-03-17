package br.com.zup.treinocasadocodigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zup.treinocasadocodigo.pais.Pais;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {}
	
	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Pais getPais() {
		return pais;
	}

}
