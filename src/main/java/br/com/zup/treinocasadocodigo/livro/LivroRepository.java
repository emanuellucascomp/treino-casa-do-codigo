package br.com.zup.treinocasadocodigo.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	Page<Livro> findByTituloContaining(String titulo, Pageable paginacao);
}
