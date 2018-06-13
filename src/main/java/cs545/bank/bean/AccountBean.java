package cs545.bank.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.bank.domain.Account;
import cs545.bank.service.IAccountService;

@Named
@SessionScoped
public class AccountBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private IAccountService accountService;

	private String message;

	private long acctNumber;

	private String customer;

	private double balance;

	private double txAmount;

	// Default constructor
	public AccountBean() {
		super();
	}

	@Inject
	public AccountBean(IAccountService accountService) {
		this.accountService = accountService;
	}

	public void init() {
		message = "";
		txAmount = 0;
		Account acct = accountService.getAccount(acctNumber);
		if (null != acct) {
			acctNumber = acct.getAccountnumber();
			customer = acct.getCustomer().getName();
			balance = acct.getBalance();
		}
	}

	public void deposit() {
		Account acct = accountService.getAccount(acctNumber);
		if (null != acct && txAmount > 0) {
			acct.deposit(txAmount);
			balance = acct.getBalance();
		}
	}

	public void withdraw() {
		Account acct = accountService.getAccount(acctNumber);
		if (null != acct && txAmount > 0) {
			acct.withdraw(txAmount);
			balance = acct.getBalance();
		}
	}

	public IAccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(long acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}

}
