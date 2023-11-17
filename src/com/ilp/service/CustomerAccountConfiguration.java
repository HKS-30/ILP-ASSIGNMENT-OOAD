package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;

public class CustomerAccountConfiguration {

	public static Customer createCustomer(ArrayList<Product> productList) {
		char goToMainMenu;
		char addAccountMenu;
		ArrayList<Account> accountList = new ArrayList<Account>();
		Scanner scanner = new Scanner(System.in);
		String customerCode, customerName;

		System.out.println("\n********Create Customer********\n");

		System.out.println("Enter customer code");
		customerCode = scanner.nextLine();
		System.out.println("Enter customer name");
		customerName = scanner.nextLine();

		System.out.println("You may add the below products to your account");
		System.out.println("Product Code" + "\t\t" + "Product Name");

		for (Product product : productList) {
			System.out.println(product.getProductCode() + "\t\t\t" + product.getProductName());
		}
		do {
			accountList.add(CustomerAccountConfiguration.createAccount(productList));
			System.out.println("Do you want to create another account (y/n)");
			goToMainMenu = scanner.next().charAt(0);
			scanner.nextLine();
		} while (goToMainMenu == 'y');

		return new Customer(customerCode, customerName, accountList);
	}

	private static Account createAccount(ArrayList<Product> productList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product code to add to your account");
		String productChoice = scanner.nextLine();
		System.out.println("Enter account number");
		String accountNo = scanner.nextLine();
		System.out.println("Enter account balance");
		double accountBalance = scanner.nextDouble();
		Product productChosen = null;
		for (Product product : productList) {
			if (product.getProductCode().equalsIgnoreCase(productChoice)) {
				productChosen = product;
				break;
			}
		}
		if (productChosen == null) {
			System.out.println("Product not choosed");
		}
		return new Account(accountNo, accountBalance, productChosen);
	}

	public static void displayAccount(Customer customer) {
		System.out.println("Customer Account Details");
		System.out.println("Customer Code\t\tCustomerName");
		System.out.print(customer.getCustomerCode() + "\t\t" + customer.getCustomerName());
		System.out.println("Account\t\tBalance");
		for (Account account : customer.getAccountList()) {
			Product product = account.getProduct();
			if (product != null) {
				System.out.println(product.getProductName() + "\t\t" + account.getBalance());
			} 
		}
	}

	public static void transactionsBill(Customer customer) {
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

        System.out.println("Services available for the selected account:");
        int serviceIndex = 1;
        for (Service service : customer.getAccountList().get(chooseAccount - 1).getProduct().getServiceList()) {
            System.out.println(
                    serviceIndex + "\t" + service.getServiceCode() + "\t" + service.getServiceName() + "\t" + service.getRate());
            serviceIndex++;
        }

        System.out.print("Choose the service (enter the service number): ");
        int chooseService = scanner.nextInt();

        if (chooseService < 1 || chooseService > customer.getAccountList().get(chooseAccount - 1).getProduct().getServiceList().size()) {
            System.out.println("Invalid service number");
            return;
        }

        System.out.print("Enter the number of transactions: ");
        int noOfTransactions = scanner.nextInt();

        double rate = customer.getAccountList().get(chooseAccount - 1).getProduct().getServiceList().get(chooseService - 1).getRate();
        double totalBill = noOfTransactions * rate;

        System.out.println("Bill: " + totalBill);
    }
}
