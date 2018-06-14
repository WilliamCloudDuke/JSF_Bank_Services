package cs545.bank.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named("promotionCodeConverter")
@ApplicationScoped
public class PromotionCodeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("PromotionCodeConverter - Converter");
		if (null != value) {
			int idx = value.toString().lastIndexOf("-");
		}
		return new Integer(0);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("PromotionCodeConverter - getAsString");
		return "promo-" + value;
	}

}
