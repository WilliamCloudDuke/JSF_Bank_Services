package cs545.bank.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("accountNumValidator")
@ApplicationScoped // As long as the application is alive up this bean-validator will be alive
public class AccountNumValidator implements Validator {
	private final String ERROR_MESSAGE = "Account number must have at least 5 digits";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		System.out.println("AccountNumValidator - validate");
		boolean valid = false;

		long account = Long.parseLong(value.toString());
		if (account > 10000) {
			valid = true;
		}

		if (!valid) {
			FacesMessage facesMessage = new FacesMessage(ERROR_MESSAGE);
			context.addMessage("", facesMessage);
			throw new ValidatorException(facesMessage);
		}

	}

}
