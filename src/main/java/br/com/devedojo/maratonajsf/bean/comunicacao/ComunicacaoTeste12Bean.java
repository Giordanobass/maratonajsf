package br.com.devedojo.maratonajsf.bean.comunicacao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;
import br.com.devedojo.maratonajsf.util.ApplicationMapUtil;

@Named
@RequestScoped
public class ComunicacaoTeste12Bean implements Serializable {
	
	private Estudante estudante;
	private Estudante estudante2 = new Estudante();
	
	public void init() {
		estudante = (Estudante) ApplicationMapUtil.getValueFromApplicationMap("estudante");
	}
	
	public String voltar() {
		System.out.println(estudante2.getNome());
		System.out.println(estudante2.getSobrenome());
		return "comunicacao11?faces-redirect=true";
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Estudante getEstudante2() {
		return estudante2;
	}

	public void setEstudante2(Estudante estudante2) {
		this.estudante2 = estudante2;
	}
	
}
