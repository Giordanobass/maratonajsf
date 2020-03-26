package br.com.devedojo.maratonajsf.converters;

import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.devedojo.maratonajsf.model.Estudante;

@FacesConverter(value = "estudanteConverter")
public class EstudanteConverter implements Converter {
	
	private List<Estudante> estudanteList = Estudante.estudanteList();
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if(value == null || !value.matches("\\d+")) {
			return null;
		}
		/*
		 * Estudante estudante = new Estudante();
		 * estudante.setId(Integer.parseInt(value)); int index =
		 * estudanteList.indexOf(estudante); return estudanteList.get(index);
		 */
		return this.getAttributesFrom(uiComponent).get(value);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if(value != null && !value.equals("")) {
			Estudante estudante = (Estudante) value;
			if(estudante.getId()!=null) {
				this.addAttribute(uiComponent, estudante);
				return estudante.getId().toString();
			}
		}
		return null;
	}
	
	private Map<String, Object> getAttributesFrom(UIComponent uiComponent){
		return uiComponent.getAttributes();
	}
	
	private void addAttribute(UIComponent uiComponent, Estudante estudante) {
		this.getAttributesFrom(uiComponent).put(estudante.getId().toString(), estudante);
	}
}
