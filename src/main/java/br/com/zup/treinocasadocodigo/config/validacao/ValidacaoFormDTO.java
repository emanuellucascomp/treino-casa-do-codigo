package br.com.zup.treinocasadocodigo.config.validacao;

public class ValidacaoFormDTO {
	
	private String campo;
	private String erro;
	
	public ValidacaoFormDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
