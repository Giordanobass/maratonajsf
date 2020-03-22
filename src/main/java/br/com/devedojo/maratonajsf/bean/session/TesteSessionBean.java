package br.com.devedojo.maratonajsf.bean.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;

@Named
@SessionScoped
public class TesteSessionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> personagens;
	private List<String> personagemSelecionado = new ArrayList<>();
	private Estudante estudante;

	@PostConstruct
	public void init() {
		System.out.println("Entrou no PostConstruct Session");
		personagens = Arrays.asList("Goku", "vegeta", "Gohan");
		logar();
	}
	
	public void logar() {
		//fez consulta no banco esta ok
		estudante = new Estudante();
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

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

}
