package br.com.devedojo.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicacaoTeste3Bean implements Serializable {
private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	private Date data;
	
	public void init() throws ParseException {
			System.out.println("Criou Comunicacao");
			System.out.println(nome);
			System.out.println(sobrenome);
	}
	public String save() {
		System.out.println("Salvando");
		return "resultado?faces-redirect=true&amp;includeViewParams=true";
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}