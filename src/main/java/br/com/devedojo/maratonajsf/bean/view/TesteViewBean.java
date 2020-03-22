package br.com.devedojo.maratonajsf.bean.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.bean.dependent.TesteDependentBean;
import br.com.devedojo.maratonajsf.bean.session.TesteSessionBean;

@Named
@ViewScoped
public class TesteViewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> personagens;
	private List<String> personagemSelecionado = new ArrayList<>();
	private TesteDependentBean dependenteBean;
	private final TesteSessionBean sessionBean;
	
	@Inject
	public TesteViewBean (TesteDependentBean dependenteBean, TesteSessionBean sessionBean) {
		this.sessionBean = sessionBean;
		this.dependenteBean = dependenteBean;
	}

	@PostConstruct
	public void init() {
		System.out.println("Entrou no PostConstruct ViewScoped");
		personagens = Arrays.asList("Naruto", "Hinata", "Yondaime");
	}

	public void selesionarPersonagem() {
		System.out.println(sessionBean.getEstudante().getNome());
		if (sessionBean.getEstudante().getNome().equals("giordano")) {
		int index = ThreadLocalRandom.current().nextInt(3);
		String personagem = personagens.get(index);
		personagemSelecionado.add(personagem);
		dependenteBean.getPersonagemSelecionado().add(personagem);
		}
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

	public TesteDependentBean getDependenteBean() {
		return dependenteBean;
	}

	public void setDependenteBean(TesteDependentBean dependenteBean) {
		this.dependenteBean = dependenteBean;
	}

	public TesteSessionBean getSessionBean() {
		return sessionBean;
	}

}
