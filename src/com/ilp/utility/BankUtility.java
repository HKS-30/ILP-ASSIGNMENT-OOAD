package com.ilp.utility;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.CustomerAccountConfiguration;
import com.ilp.service.ManageAccountsService;
import com.ilp.service.ProductConfiguration;

public class BankUtility {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList <Service> serviceList = new ArrayList<>();
		ArrayList <Product> productList = new ArrayList<>();
		Customer customer = null;
		char goToMainMenu;
		do {
			
			//Options available
			System.out.println("1. Create Service\n2. Create Product\n3. Create Customer\n4. Display Customer\n5. Transaction Bill\n6. Manage Transactions\n7. Exit");
			System.out.println("Enter your choice");
			int mainMenuChoice = scanner.nextInt();
			switch (mainMenuChoice) {
			case 1:
				serviceList = ProductConfiguration.createServices(); // Create all the services
				break;
			case 2:
				productList = ProductConfiguration.createProducts(serviceList); // Select particular services from the service list 
				break;
			case 3:
				customer = CustomerAccountConfiguration.createCustomer(productList);
				break;
			case 4:
				CustomerAccountConfiguration.displayAccount(customer);
				break;
			case 5:
				CustomerAccountConfiguration.transactionsBill(customer);
				break;
			case 6:
				ManageAccountsService.manageAccounts(customer);
				break;
			case 7:
				 System.exit(0);
			default:
				System.out.println("Option Invalid");
				
			}	
			System.out.println("Go back to main menu (y/n)");
			goToMainMenu = scanner.next().charAt(0);
		}
		while(goToMainMenu == 'y');
	}
}
