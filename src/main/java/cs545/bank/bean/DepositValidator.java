package cs545.bank.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("depositAmountValidator")
@ApplicationScoped
public class DepositValidator implements Validator {

	private static final String ERROR_MESSAGE = "Deposit amount must be greater than 50 usd";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		boolean valid = false;
		double deposit = 0.0d;
		if (null != value) {
			try {
				deposit = Double.parseDouble(value.toString());
			} catch (NumberFormatException e) {
				FacesMessage msg = new FacesMessage("Format Error, the deposit vale must be a number");
				context.addMessage("", msg);
				throw new ValidatorException(msg);
			}
			if (deposit > 50) {
				valid = true;
			}

			if (!valid) {
				FacesMessage msg = new FacesMessage(ERROR_MESSAGE);
				context.addMessage("", msg);
				throw new ValidatorException(msg);
			}
		}
	}
}
