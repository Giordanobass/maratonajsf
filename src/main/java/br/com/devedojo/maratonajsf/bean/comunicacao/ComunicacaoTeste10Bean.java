package br.com.devedojo.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ComunicacaoTeste10Bean implements Serializable {
	
	private String password;
	private List<Estudante> estudanteList = Estudante.estudanteList();
	
	public void remover(Estudante estudante) {
		estudanteList.remove(estudante);
	}
	
	public void salvar() {
		System.out.println(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}

	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}
	
}
