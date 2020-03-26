package br.com.devedojo.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;
import br.com.devedojo.maratonajsf.util.ApplicationMapUtil;

@Named
@ViewScoped
public class ComunicacaoTeste11Bean implements Serializable {
	
	private List<Estudante> estudanteList = Estudante.estudanteList();
	
	public String editar(Estudante estudante) {
		ApplicationMapUtil.setValueApplicationMap("estudante", estudante);
		return "comunicacao12?faces-redirect=true";
	}

	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}

	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}
	
}
