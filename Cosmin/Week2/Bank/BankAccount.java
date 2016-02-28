package Week2.Bank;

import java.time.LocalDate;

/*
 * Sa se scrie un proiect inc are sa se implementeze logica unei banci.Softul
 * bancar trebuie sa permita crearea unui depozit de cont la termen.(Contul la
 * termen permite retragerea doar dupa o data scadenta,care va fi retinuta
 * intr-un camp final)De asemenea se permite crearea unui cont curent.Extragerea
 * dintr-un cont curent este limitata la o anumita suma care va fi din nou
 * retinuta ca un atribut final.Conturile curente si depozitele au anumite
 * similaritati si anumite deosebire. Designul claselor trebuie treb sa e
 * reflecte.De asemenea treb sa permitem adaugarea la orice moment a altor
 * tipuri de conturi.In rest banca are mai multi clienti care au mai multe
 * conturi indiferent de tip Indicatie: Clasa de baza abstracta cu cel putin 2
 * metode depunere,extragere. Sa se genereze niste rapoarte cu privire la
 * situatia clientilor.
 */
public abstract class BankAccount {

	private Customer customer;
	private double money;
	private LocalDate date;

	public BankAccount(Customer customer, double money, LocalDate date2) {
		this.setCustomer(customer);
		this.money = money;
		this.date = date2;
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract String checkDeposit(LocalDate date);

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public LocalDate getDate() {
		return date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BankAccount [customer=" + customer + ", money=" + money + ", date=" + date + "]";
	}

}
