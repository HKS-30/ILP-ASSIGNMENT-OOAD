package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsAccount;
import com.ilp.entity.Service;

public class ProductConfiguration {

	public static ArrayList<Service> createServices() {
		ArrayList<Service> serviceList = new ArrayList<Service>();
		Scanner scanner = new Scanner(System.in);
		char goToMainMenu;
		System.out.println("\n******Services List*******\n");
		do {

			System.out.println("Enter service code");
			String serviceCode = scanner.nextLine();
			System.out.println("Enter service name");
			String serviceName = scanner.nextLine();
			System.out.println("Enter service rate");
			double serviceRate = scanner.nextDouble();
			serviceList.add(new Service(serviceCode, serviceName, serviceRate));
			System.out.println("Do you want to add more services (y/n)");
			goToMainMenu = scanner.next().charAt(0);
			scanner.nextLine();
		} while (goToMainMenu == 'y');
		return serviceList;
	}

	public static ArrayList<Product> createProducts(ArrayList<Service> serviceList) {
		ArrayList<Product> productList = new ArrayList<Product>();
		Scanner scanner = new Scanner(System.in);
		char goToMainMenu;
		do {
			System.out.println("1. Savings Account\n2. Current Account\n3. Loan Account");
			int choiceOfAccount = scanner.nextInt();
			switch (choiceOfAccount) {
			case 1:
				productList.add(createSavingsAccount(serviceList));
				break;
			case 2:
				productList.add(createCurrentAccount(serviceList));
				break;
			case 3:
				productList.add(createLoanAccount(serviceList));
				break;
			default:
				System.out.println("Invalid Option!!!");
			}
			System.out.println("Do you want to add more products (y/n)");
			goToMainMenu = scanner.next().charAt(0);
			scanner.nextLine();
		} while (goToMainMenu == 'y');
		return productList;
	}

	private static CurrentAccount createCurrentAccount(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product code");
		String productCode = scanner.nextLine();

		String productName = "Current Account";
		System.out.println("Product name" + productName);
		System.out.println("You may add the below services to your product");
		System.out.println("Service Code" + "\t\t" + "Service Name" + "\t\t" + "Service Rate");

		for (Service service : serviceList) {
			System.out.println(
					service.getServiceCode() + "\t\t\t" + service.getServiceName() + "\t\t\t" + service.getRate());
		}

		ArrayList<Service> chosenServiceList = new ArrayList<Service>();
		char serviceMenu;

		do {
			System.out.println("Enter the service code you want to add to the product");
			String serviceCodeChoice = scanner.nextLine();

			for (Service service : serviceList) {
				if (service.getServiceCode().equalsIgnoreCase(serviceCodeChoice)) {
					chosenServiceList.add(service);
					break; 
				}
			}

			System.out.println("Do you want to add more services to the product (y/n)");
			serviceMenu = scanner.next().charAt(0);
			scanner.nextLine(); 

		} while (serviceMenu == 'y');
		return new CurrentAccount(productCode, productName, chosenServiceList);
	}

	private static LoanAccount createLoanAccount(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product code");
		String productCode = scanner.nextLine();
		String productName = "Loan Account";
		System.out.println("Product name" + productName);
		System.out.println("You may add the below services to your product");
		System.out.println("Service Code" + "\t\t" + "Service Name" + "\t\t" + "Service Rate");

		for (Service service : serviceList) {
			System.out.println(
					service.getServiceCode() + "\t\t\t" + service.getServiceName() + "\t\t\t" + service.getRate());
		}

		ArrayList<Service> chosenServiceList = new ArrayList<Service>();
		char serviceMenu;

		do {
			System.out.println("Enter the service code you want to add to the product");
			String serviceCodeChoice = scanner.nextLine();

			for (Service service : serviceList) {
				if (service.getServiceCode().equalsIgnoreCase(serviceCodeChoice)) {
					chosenServiceList.add(service);
					break; 
				}
			}

			System.out.println("Do you want to add more services to the product (y/n)");
			serviceMenu = scanner.next().charAt(0);
			scanner.nextLine(); 

		} while (serviceMenu == 'y');
		return new LoanAccount(productCode, productName, chosenServiceList, 0.03);
	}

	private static SavingsAccount createSavingsAccount(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product code");
		String productCode = scanner.nextLine();
		String productName = "Savings Account";
		System.out.println("Product name" + productName);
		System.out.println("You may add the below services to your product");
		System.out.println("Service Code" + "\t\t" + "Service Name" + "\t\t" + "Service Rate");

		for (Service service : serviceList) {
			System.out.println(
					service.getServiceCode() + "\t\t\t" + service.getServiceName() + "\t\t\t" + service.getRate());
		}

		ArrayList<Service> chosenServiceList = new ArrayList<Service>();
		char serviceMenu;

		do {
			System.out.println("Enter the service code you want to add to the product");
			String serviceCodeChoice = scanner.nextLine();

			for (Service service : serviceList) {
				if (service.getServiceCode().equalsIgnoreCase(serviceCodeChoice)) {
					chosenServiceList.add(service);
					break; 
				}
			}

			System.out.println("Do you want to add more services to the product (y/n)");
			serviceMenu = scanner.next().charAt(0);
			scanner.nextLine(); 

		} while (serviceMenu == 'y');
		double amount = 20000;
		return new SavingsAccount(productCode, productName, chosenServiceList, amount);
	}
}
