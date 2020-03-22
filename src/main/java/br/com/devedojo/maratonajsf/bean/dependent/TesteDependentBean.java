package br.com.devedojo.maratonajsf.bean.dependent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@Dependent
public class TesteDependentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> personagens;
	private List<String> personagemSelecionado = new ArrayList<>();
	private List<String> categoriasList = new ArrayList<>();

	@PostConstruct
	public void init() {
		System.out.println("Entrou no PostConstruct Dependent");
		personagens = Arrays.asList("Yusuke", "Hiei", "kurama");
	}

	public void selesionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String personagem = personagens.get(index);
		personagemSelecionado.add(personagem);
	}

	public String logout() {
		System.out.println("Entrou no logout");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "session2?faces-redirect=true";
	}

	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}

	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}

	public List<String> getCategoriasList() {
		return categoriasList;
	}

	public void setCategoriasList(List<String> categoriasList) {
		this.categoriasList = categoriasList;
	}

}
