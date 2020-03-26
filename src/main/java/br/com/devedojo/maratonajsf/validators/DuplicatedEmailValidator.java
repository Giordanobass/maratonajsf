package br.com.devedojo.maratonajsf.validators;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import br.com.devedojo.maratonajsf.bean.login.LoginBean;

@FacesValidator
public class DuplicatedEmailValidator implements Validator {
	
	private List<String> emailsDB = Arrays.asList("giordano.nascimento@devdojo.com.br");
	
	@Inject
	private LoginBean loginBean;

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) 
			throws ValidatorException {
		System.out.println(loginBean.getLanguage());
		String email = (String) o;
		if(emailsDB.contains(email)) {
			FacesMessage message = 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "O email já existe cadastro", "");
			throw new ValidatorException(message);
		}
		
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<String> getEmailsDB() {
		return emailsDB;
	}

	public void setEmailsDB(List<String> emailsDB) {
		this.emailsDB = emailsDB;
	}

}
