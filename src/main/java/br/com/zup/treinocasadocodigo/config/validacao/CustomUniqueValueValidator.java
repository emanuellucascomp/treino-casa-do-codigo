package br.com.zup.treinocasadocodigo.config.validacao;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.treinocasadocodigo.autor.Autor;
import br.com.zup.treinocasadocodigo.autor.AutorRepository;

public class CustomUniqueValueValidator implements ConstraintValidator<CustomUniqueValue, String> {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<Autor> autor = autorRepository.findByEmail(value);
		if(autor.isPresent()) {
			return false;
		}
		return true;
	}
}
