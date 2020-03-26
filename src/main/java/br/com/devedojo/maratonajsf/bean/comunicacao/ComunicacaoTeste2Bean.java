package br.com.devedojo.maratonajsf.bean.comunicacao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Param;

@Named
@ViewScoped
public class ComunicacaoTeste2Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject @Param(name = "nome")
	private String nome;
	@Inject @Param(name = "sobrenome")
	private String sobrenome;
	
	@PostConstruct
	public void init() {
		//Map<String, String> paramsMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//System.out.println(paramsMap.get("nome"));
		//System.out.println(paramsMap.get("sobrenome"));
		System.out.println(nome);
		System.out.println(sobrenome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	

}
