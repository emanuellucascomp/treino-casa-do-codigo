package br.com.zup.treinocasadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zup.treinocasadocodigo.autor.Autor;
import br.com.zup.treinocasadocodigo.categoria.Categoria;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	@Column(unique = true)
	private String isbn;
	private LocalDate dataPublicacao;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {}
	
	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
			LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

}
