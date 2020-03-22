package br.com.devedojo.maratonajsf.bean.estudante;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estudante estudante = new Estudante();

	private String[] nomesArray = { "DeveDojo", "eh", "foda" };
	private List<String> nomesList = Arrays.asList(" William ", " Wildnei ", " Brenon ", " samanta ");
	private Set<String> nomesSet = new HashSet<>(Arrays.asList(" Ruffy ", " Goku ", " Naruto ", " Jiraya "));
	private Map<String, String> nomesMap = new HashMap<>();
	private boolean mostrarNotas;

	{
		nomesMap.put("Goku", "O mais Forte");
		nomesMap.put("Ruffy", "O mais Longo");
		nomesMap.put("Naruto", "O mais Lenga Lenga");

		for (String nome : nomesSet) {
			System.out.println(nome);
		}
	}

	public void executar(String param) {
		System.out.println(estudante.getNome());
		System.out.println("Fazendo uma busca no BD");
		System.out.println("Processando os dados");
		System.out.println("Exibindo os dados");
	}

	public Map<String, String> getNomesMap() {
		return nomesMap;
	}

	public void setNomesMap(Map<String, String> nomesMap) {
		this.nomesMap = nomesMap;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public String[] getNomesArray() {
		return nomesArray;
	}

	public void setNomesArray(String[] nomesArray) {
		this.nomesArray = nomesArray;
	}

	public List<String> getNomesList() {
		return nomesList;
	}

	public void setNomesList(List<String> nomesList) {
		this.nomesList = nomesList;
	}

	public Set<String> getNomesSet() {
		return nomesSet;
	}

	public void setNomesSet(Set<String> nomesSet) {
		this.nomesSet = nomesSet;
	}
	
	public void exibirNotas() {
		this.mostrarNotas = true;
		System.out.println(this.mostrarNotas);
		
	}
	
	public void esconderNotas() {
		this.mostrarNotas = false;
		
	}

	public boolean isMostrarNotas() {
		return mostrarNotas;
	}
	
	public void calcularCubo(LambdaExpression le, long value) {
		long result = (long)le.invoke(FacesContext.getCurrentInstance()
				.getELContext(), value);
		System.out.println(result);
	}

	public void setMostrarNotas(boolean mostrarNotas) {
		this.mostrarNotas = mostrarNotas;
	}

}
