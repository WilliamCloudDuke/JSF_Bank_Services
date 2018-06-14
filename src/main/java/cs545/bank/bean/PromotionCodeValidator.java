package cs545.bank.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("promotionCodeValidator")
@ApplicationScoped
public class PromotionCodeValidator implements Validator {
	private final String ERROR_MESSAGE = "Promotion code must have at most 5 digits ";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		System.out.println("AccountNumValidator - validate");
		boolean valid = false;

		if (null == value) {// the field is not mandatory
			System.out.println("value is null");
			valid = false;
		} else {
			System.out.println("value is not null" + value);
			int promotionCode = Integer.parseInt(value.toString());
			if (promotionCode >= 0 && promotionCode <= 10000) {
				valid = true;
			}
		}
		if (!valid) {
			FacesMessage facesMessage = new FacesMessage(ERROR_MESSAGE);
			context.addMessage("", facesMessage);
			throw new ValidatorException(facesMessage);
		}
	}

}
