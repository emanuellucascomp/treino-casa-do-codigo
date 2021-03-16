package br.com.zup.treinocasadocodigo.livro;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public Page<LivroDTO> listar(@RequestParam(required = false) String titulo, 
			@PageableDefault(
				sort = "id",
				direction = Direction.ASC,
				page = 0,
				size = 5
			) Pageable paginacao){
		if(titulo != null) {
			Page<Livro> livros = livroRepository.findByTituloContaining(titulo, paginacao);
			return LivroDTO.toModel(livros);
		}
		Page<Livro> livros = livroRepository.findAll(paginacao);
		return LivroDTO.toModel(livros);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm livroForm){
		Livro livro = livroForm.toModel(entityManager);
		entityManager.persist(livro);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroDTO> detalhar(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent()) {
			return ResponseEntity.ok(new DetalheLivroDTO(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
