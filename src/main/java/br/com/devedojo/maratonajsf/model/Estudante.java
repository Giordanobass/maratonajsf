package br.com.devedojo.maratonajsf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.devedojo.maratonajsf.model.enums.Turno;

public class Estudante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome = "giordano";
	private String sobrenome = "Nascimento";
	private double nota1 = 20;
	private double nota2;
	private double nota3 = 10;
	private Turno turno = Turno.MATUTINO;
	private String email;
	private transient boolean editing;
	
	public Estudante() {
	}
		
	public Estudante(String nome, String sobrenome, double nota1) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nota1 = nota1;
	}
	public Estudante(Integer id, String nome, String sobrenome, double nota1) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nota1 = nota1;
	}
	
	public static List<Estudante> estudanteList(){
		return new ArrayList<>(Arrays.asList(new Estudante(1," Ikki "," Fenix ",10),
				new Estudante(2," Shiryu "," Dragao ",10),
				new Estudante(3," Seiya "," Pegasus ",10)));
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
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + "]";
	}
	
}
