package br.com.devedojo.maratonajsf.bean.validator;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ValidatorTesteBean implements Serializable {
	
	Estudante estudante = new Estudante();
	
	public void save() {
		System.out.println("Salvando");
		System.out.println(estudante.getEmail());
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
}
