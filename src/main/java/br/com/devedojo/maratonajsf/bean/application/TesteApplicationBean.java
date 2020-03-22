package br.com.devedojo.maratonajsf.bean.application;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.bean.dependent.TesteDependentBean;
import br.com.devedojo.maratonajsf.bean.session.TesteSessionBean;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> categoriaList;	
	private final TesteDependentBean dependenteBean;
	private final TesteSessionBean sessionBean;
	
	@Inject
	public TesteApplicationBean (TesteDependentBean dependenteBean, TesteSessionBean sessionBean) {
		this.sessionBean = sessionBean;
		this.dependenteBean=dependenteBean;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Entrou no postconstruct do application");
		setCategoriaList(Arrays.asList("RPG", "Sci-Fi", "Terror"));
		dependenteBean.getCategoriasList().addAll(Arrays.asList("Comedia", "Romance", "Terror"));
		sessionBean.selesionarPersonagem();
	}

	public List<String> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<String> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public TesteDependentBean getDependenteBean() {
		return dependenteBean;
	}

	public TesteSessionBean getSessionBean() {
		return sessionBean;
	}

	
}
