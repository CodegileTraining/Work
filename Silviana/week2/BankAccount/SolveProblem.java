package accounts;

import java.util.ArrayList;

public class SolveProblem {
	public static void main(String[] args) {

		Bank inst = Bank.getInstance();
		inst.readClients();
		inst.printClients();
		ArrayList<Account> accounts = inst.getAccounts();
		
		try {
			accounts.get(0).addDeposit(300);
		} catch (InvalidSumOfMoneyException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			accounts.get(1).addExtraction(400);
		} catch (InvalidSumOfMoneyException ex1) {
			System.err.println(ex1.getMessage());
		} catch (DueDayViolationException ex2) {
			System.err.println(ex2.getMessage());
		}
		
		try {
			accounts.get(2).addDeposit(100);
		} catch (InvalidSumOfMoneyException ex) {
			System.err.println(ex.getMessage());
		}
		
		try {
			accounts.get(3).addExtraction(100);
		} catch (InvalidSumOfMoneyException ex3) {
			System.err.println(ex3.getMessage());
		} catch (DueDayViolationException ex4) {
			System.err.println(ex4.getMessage());
		}
		
		inst.printClients();

	}

}
