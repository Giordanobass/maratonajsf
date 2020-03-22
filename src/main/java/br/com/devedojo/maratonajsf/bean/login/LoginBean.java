package br.com.devedojo.maratonajsf.bean.login;

import java.io.Serializable;

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
	
	public String logar() {
		//faz busca no banco
		if (nome.equals("g") && senha.equals("1")) {
			setEstudante(new Estudante());
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

}
