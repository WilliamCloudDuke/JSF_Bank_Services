package cs545.bank.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.bank.domain.Account;
import cs545.bank.service.IAccountService;

@Named
@ApplicationScoped
public class CreateAccountHelper {

	@Inject
	private IAccountService accountService;

	public String process(CreateAccountBean createAccountBean) {
		System.out.println("process");
		String response = "success";

		if (!createAccountBean.isAcctCreated()) {
			accountService.createAccount(createAccountBean.getAcctNumber(), createAccountBean.getCustomer());
			createAccountBean.setAcctCreated(true);
		}
		accountService.deposit(createAccountBean.getAcctNumber(), createAccountBean.getDeposit());
		Account newAccount = accountService.getAccount(createAccountBean.getAcctNumber());
		createAccountBean.setBalance(newAccount.getBalance());
		return response;
	}

}
