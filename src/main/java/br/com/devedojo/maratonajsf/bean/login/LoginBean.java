package br.com.devedojo.maratonajsf.bean.login;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String senha;
	private Estudante estudante;
	private List<Locale> localeList = Arrays.asList(new Locale("en"), new Locale("pt"));
	private String language;
	private int qtdMensagens;
	
	public String logar() {
		//faz busca no banco
		if (nome.equals("g") && senha.equals("1")) {
			estudante = new Estudante();
			qtdMensagens++;
			return "/restricted/iniciosistema.xhtml?faces-redirect=true";
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario e/ou senha invalidos",""));
		return null;
	}
	public String logout() {
		System.out.println("Entrou no logout");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		setEstudante(null);
		return "/login2?faces-redirect=true";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	public List<Locale> getLocaleList() {
		return localeList;
	}
	public void setLocaleList(List<Locale> localeList) {
		this.localeList = localeList;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getQtdMensagens() {
		return qtdMensagens;
	}
	public void setQtdMensagens(int qtdMensagens) {
		this.qtdMensagens = qtdMensagens;
	}

}
