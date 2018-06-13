package cs545.bank.domain;

import java.io.Serializable;

import javax.inject.Named;

@Named("customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
