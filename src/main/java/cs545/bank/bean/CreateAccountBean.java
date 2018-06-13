package cs545.bank.bean;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped("createAccount")
public class CreateAccountBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String message;

	private long acctNumber;

	private String customer;

	private double balance;

	private boolean isAcctCreated;

	private int promotionCode;

	// Default - no argument constructor
	public CreateAccountBean() {
		super();
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

	public boolean isAcctCreated() {
		return isAcctCreated;
	}

	public void setAcctCreated(boolean isAcctCreated) {
		this.isAcctCreated = isAcctCreated;
	}

	public int getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(int promotionCode) {
		this.promotionCode = promotionCode;
	}

}
