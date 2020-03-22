package br.com.devedojo.maratonajsf.bean.conversation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class TesteConversationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> personagens = Arrays.asList("Yusuke", "Hiei", "kurama");
	private List<String> personagemSelecionado = new ArrayList<>();
	
	@Inject
	private Conversation conversation;

	
	public void init() {
		System.out.println("Entrou no PostConstruct Conversation");
		personagens = Arrays.asList("Luffy", "Zoro", "Sanji");
		if (conversation.isTransient()) {
			conversation.begin();
			System.out.println("Iniciando Conversation Scoped, ID= " + conversation.getId());
		}
	}
	
	public String endConvesation() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "conversation?faces-redirect-true";
	}

	public void selesionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String personagem = personagens.get(index);
		personagemSelecionado.add(personagem);
	}

	public String logout() {
		System.out.println("Entrou no logout");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "conversation2?faces-redirect=true";
	}

	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}

	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}

}
