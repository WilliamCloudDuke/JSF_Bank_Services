package cs545.bank.service;

public abstract interface ICurrencyConverter {
	public double euroToDollars(double amount);

	public double dollarsToEuros(double amount);
}
