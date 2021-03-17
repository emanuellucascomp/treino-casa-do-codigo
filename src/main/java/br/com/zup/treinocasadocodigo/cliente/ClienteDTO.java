package br.com.zup.treinocasadocodigo.cliente;

public class ClienteDTO {
	
	private Long id;
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}

}
