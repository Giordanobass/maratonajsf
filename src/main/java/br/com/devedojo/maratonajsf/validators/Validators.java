package br.com.devedojo.maratonajsf.validators;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.devedojo.maratonajsf.bean.login.LoginBean;

@Named
@RequestScoped
public class Validators implements Serializable{
	
private List<String> emailsDB = Arrays.asList("giordano.nascimento@devdojo.com.br");
	
	@Inject
	private LoginBean loginBean;

	public void validateDuplicatedEmail(FacesContext facesContext, UIComponent uiComponent, Object o) 
			throws ValidatorException {
		System.out.println(loginBean.getLanguage());
		String email = (String) o;
		if(emailsDB.contains(email)) {
			FacesMessage message = 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "O email já existe cadastro", "");
			throw new ValidatorException(message);
		}
		
	}

}
