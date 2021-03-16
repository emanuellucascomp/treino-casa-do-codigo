package br.com.zup.treinocasadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.treinocasadocodigo.autor.Autor;
import br.com.zup.treinocasadocodigo.categoria.Categoria;
import br.com.zup.treinocasadocodigo.config.validacao.CustomExistingValue;
import br.com.zup.treinocasadocodigo.config.validacao.CustomUniqueValue;

public class LivroForm {
	
	@NotBlank @CustomUniqueValue(dataClass = Livro.class, field = "titulo" , message = "Título já cadastrado no sistema.")
	private String titulo;
	@NotBlank @Size(max = 500)
	private String resumo;
	private String sumario;
	@NotNull @Min(20)
	private BigDecimal preco;
	@NotNull @Min(100)
	private Integer paginas;
	@NotBlank @CustomUniqueValue(dataClass = Livro.class, field = "isbn" , message = "ISBN já cadastrado no sistema.")
	private String isbn;
	@Future
	private LocalDate dataPublicacao;
	@NotNull @CustomExistingValue(dataClass = Categoria.class, field = "id", message = "Categoria inexistente")
	private Long idCategoria;
	@NotNull @CustomExistingValue(dataClass = Autor.class, field = "id", message = "Autor inexistente")
	private Long idAutor;
	
	public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer paginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
	
	public Livro toModel(EntityManager entityManager) {
		Autor autor = entityManager.find(Autor.class, idAutor);
		Categoria categoria = entityManager.find(Categoria.class, idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, categoria, autor);
	}

}
