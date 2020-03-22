package br.com.devedojo.maratonajsf.bean.flow;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value = "registration")
public class TesteFlowBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	private String endereco;
	
	public String salvar() {
		
		System.out.println("Salvando no banco!");
		System.out.println(nome);
		System.out.println(sobrenome);
		System.out.println(endereco);
		return "exitToInicio";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
