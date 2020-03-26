package br.com.devedojo.maratonajsf.bean.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ConverterTesteBean implements Serializable {
	
	private List<Estudante> estudanteList = Estudante.estudanteList();
	private Estudante estudante;
	
	public void save() {
		System.out.println("Salvando");
		System.out.println(estudante);
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}

	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}
}
