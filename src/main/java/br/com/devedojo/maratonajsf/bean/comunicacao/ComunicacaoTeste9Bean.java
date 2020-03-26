package br.com.devedojo.maratonajsf.bean.comunicacao;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;

import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class ComunicacaoTeste9Bean implements Serializable {
	
	private String value;
	
	public void init() {
		value = Faces.getRequestCookie("nome");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
