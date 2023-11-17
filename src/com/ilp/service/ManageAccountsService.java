package com.ilp.service;

import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;

public class ManageAccountsService {

	public static void manageAccounts(Customer customer) {
		Scanner scanner = new Scanner(System.in);		
        System.out.println("Account Number\t\tAccount Balance\t\tAccount Type");
        int accountIndex = 1;
        for (Account account : customer.getAccountList()) {
            System.out.println(accountIndex + "\t" + account.getAccountNo() + "\t" + account.getBalance() + "\t"
                    + account.getProduct().getProductName());
            accountIndex++;
        }

        System.out.print("Choose the account (enter the account number): ");
        int chooseAccount = scanner.nextInt();

        if (chooseAccount < 1 || chooseAccount > customer.getAccountList().size()) {
            System.out.println("Invalid account number");
            return;
        }
        Account selectedAccount = customer.getAccountList().get(chooseAccount - 1);
        System.out.println("1. Deposit Money\n2. Withdraw Money\n 3. Show Balance");
        int choice = scanner.nextInt();
        switch(choice) {
        case 1:
        	depositMoney(selectedAccount);
        	break;
        case 2:
        	withdrawMoney(selectedAccount);
        	break;
        case 3:
        	showBalance(selectedAccount);
        	break;
        default:
        	System.out.println("Invalid Option!!!");
        }
	}

	private static void showBalance(Account account) {
	    System.out.println("Current Balance: " + account.getBalance());
	}

	public static void withdrawMoney(Account account) {
		Product product = account.getProduct();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to  withdraw");
		double withdrawalAmount = scanner.nextDouble();
		Double remainingBalance = account.getBalance() - withdrawalAmount;
		if (product instanceof SavingsAccount) {
			product = (SavingsAccount) product;

			if (remainingBalance >= 1000) {
				account.setBalance(remainingBalance);
			} else {
				System.out.println("Cannot withdraw money");
			}

		} else {
			if (remainingBalance >= 0) {
				account.setBalance(remainingBalance);
			} else {
				System.out.println("Cannot withdraw money");
			}
		}

	}

	public static void depositMoney(Account account) {
		Product product = account.getProduct();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to deposit");
		double depositAmount = scanner.nextDouble();
		System.out.println("do you prefer cheque deposit (y/n)");
		char checkDeposit = scanner.next().charAt(0);
		if (Character.toLowerCase(checkDeposit) == 'y' && product instanceof LoanAccount) {
			account.setBalance(account.getBalance() + (0.97 * depositAmount));
		} else
			account.setBalance(account.getBalance() + depositAmount);
	}
}
