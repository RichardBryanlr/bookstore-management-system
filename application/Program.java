package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Random random = new Random();
		List<Product> list = new ArrayList<>();
		List<Product> soldList = new ArrayList<>();
		Product product = new Product();

		int response, optionToEdit, numberIdToCheck, bookId, quantityInStock, newQuantityInStock, paymentMethod,
				numberOfInstallments, confirmPayment;
		double bookPrice, newBookPrice;
		String bookTitle, bookAuthor, newBookTitle, newBookAuthor;

		boolean idExist, existingID, isDuplicate;

		System.out.println("Enter a number of the option:");

		do {
			System.out.println("\n1. Add a new book in stock");
			System.out.println("2. Sell some book from stock");
			System.out.println("3. Update a product data");
			System.out.println("4. Show stock");
			System.out.println("5. List all sold books");
			System.out.println("6. Exit\n");

			response = sc.nextInt();

			switch (response) {
			case 1:
				System.out.println("\n=== Add a new book in stock ===\n");

				do {
					existingID = false;
					bookId = 100000 + random.nextInt(900000);

					for (Product p : list) {
						if (p.getBookId() == bookId) {
							existingID = true;
							break;
						}
					}
				} while (existingID);

				System.out.println("Book ID: " + bookId);
				sc.nextLine();

				System.out.print("Book title: ");
				bookTitle = sc.nextLine();

				System.out.print("Book author: ");
				bookAuthor = sc.nextLine();

				System.out.print("Price: R$ ");
				bookPrice = sc.nextDouble();

				System.out.print("Quantity in stock: ");
				quantityInStock = sc.nextInt();

				isDuplicate = false;

				for (Product p : list) {
					if (p.getBookTitle().equals(bookTitle) && p.getBookAuthor().equals(bookAuthor)
							&& p.getBookPrice() == bookPrice) {
						isDuplicate = true;
					}
				}

				if (isDuplicate == true) {
					System.out.print("\nThis product already exist in ID: ");
					for (Product p : list) {
						System.out.println(p.getBookId());
					}

				} else {
					list.add(new Product(bookId, bookTitle, bookAuthor, bookPrice, quantityInStock));
				}

				System.out.println("\n=================================");
				break;

			case 2:
				if (list.isEmpty()) {
					System.out.println("\nThe stock is empty!");
				} else {
					System.out.println("\n=== Sell some book from stock ===\n");

					System.out.println("Enter the product ID that will be sold:\n");

					do {
						idExist = false;

						System.out.print("ID: ");
						numberIdToCheck = sc.nextInt();
						
						for (Product p : list) {
							if (numberIdToCheck != p.getBookId()) {
								System.out.println("\nThis ID does not exist. Try again:");
							} else if (p.getQuantityInStock() <= 0) {
								System.out.println("Sold out!");
							} else {
								idExist = true;
								
								if (p.getQuantityInStock() <= 5) {
									System.out.println("⚠ Just " + p.getQuantityInStock() + " last on stock!");
								}

								System.out.println("\nQuantity in stock: " + p.getQuantityInStock());

								System.out.println("\nBook title: " + p.getBookTitle());
								System.out.println("Book author: " + p.getBookAuthor());
								System.out.println("Book price: R$ " + p.getBookPrice());
								
								System.out.println("\nPayment method:\n");
								
								do {
									System.out.println("1. Credit");
									System.out.println("2. Debit");
									System.out.println("3. Money");
									System.out.println("4. Pix\n");

									paymentMethod = sc.nextInt();
									
									switch (paymentMethod) {
										case 1:
											System.out.println("\nCredit: R$" + p.getBookPrice() + "\n");
											
											System.out.print("Enter the number of installments: x");
											numberOfInstallments = sc.nextInt();
											
											if(numberOfInstallments <= 0) {
												do {
													System.out.println("\nThere's not a valid option! Try again");
													System.out.print("Enter the number of installments: x");
													numberOfInstallments = sc.nextInt();
												} while(numberOfInstallments <= 0);
											}										
											break;
											
										case 2:
											System.out.println("\nDebit: R$" + p.getBookPrice());
											break;
											
										case 3:
											System.out.println("\nMoney: R$" + p.getBookPrice());
											break;
											
										case 4:
											System.out.println("\nPix: R$" + p.getBookPrice());
											break;
										default: 
											System.out.println("\nThere's not a valid option! Try again");
											break;
									}

									do {
										System.out.println("\nWould you like to confirm the payment?\n");

										System.out.println("1. Yes");
										System.out.println("2. No");
										System.out.println("3. Change payment method\n");

										confirmPayment = sc.nextInt();
										
										switch (confirmPayment) {
										case 1:
											System.out.println("\n✔ The payment has been successfully!");
											
											soldList.add(p);
											p.removeProduct();
											p.soldProduct();
											break;
										case 2:
											System.out.println("\n❌ Operation has been canceled!");
											break;
										case 3:
											System.out.println("\nNew payment method:\n");
											break;
										default:
											System.out.println("\nThere's not a valid option! Try again");
											break;
										}
									} while (confirmPayment <= 0 || confirmPayment > 3);
								} while (confirmPayment == 3);
							}
						}
					} while (idExist == false);

					System.out.println("\n=================================");
				}
				break;

			case 3:
				if (list.isEmpty()) {
					System.out.println("\nThe stock is empty!");
				} else {
					System.out.println("\n=== Update a product data ===\n");

					System.out.println("Enter the product ID to edit:\n");

					do {
						System.out.print("ID: ");
						numberIdToCheck = sc.nextInt();

						idExist = false;

						for (Product p : list) {
							if (numberIdToCheck == p.getBookId()) {
								idExist = true;
							}
						}

						if (idExist == true) {
							do {
								System.out.println("\n1. Book title: " + product.getBookTitle());
								System.out.println("2. Book author: " + product.getBookAuthor());
								System.out.println("3. Book price R$ " + product.getBookPrice());
								System.out.println("4. Quantity in stock: " + product.getQuantityInStock());
								System.out.println("5. Finalizar:\n");

								optionToEdit = sc.nextInt();

								Product bookData = null;

								switch (optionToEdit) {
								case 1:
									sc.nextLine();
									System.out.print("\nNew book title: ");
									newBookTitle = sc.nextLine();

									for (Product p : list) {
										if (p.getBookId() == numberIdToCheck) {
											bookData = p;
											break;
										}
									}

									bookData.setBookTitle(newBookTitle);
									break;

								case 2:
									sc.nextLine();
									System.out.print("\nNew book author: ");
									newBookAuthor = sc.nextLine();

									for (Product p : list) {
										if (p.getBookId() == numberIdToCheck) {
											bookData = p;
											break;
										}
									}

									bookData.setBookAuthor(newBookAuthor);
									break;

								case 3:
									System.out.print("\nNew book price: R$ ");
									newBookPrice = sc.nextDouble();

									if (newBookPrice < 0) {
										System.out.println("\nThe price can not be '" + newBookPrice + "'!");
									} else {
										for (Product p : list) {
											if (p.getBookId() == numberIdToCheck) {
												bookData = p;
												break;
											}
										}

										bookData.setBookPrice(newBookPrice);
									}

									break;

								case 4:
									System.out.print("\nUpdate quantity in stock: ");
									newQuantityInStock = sc.nextInt();

									if (newQuantityInStock < 0) {
										System.out.println("\nThe quantity can not be '" + newQuantityInStock + "'!");
									} else {
										for (Product p : list) {
											if (p.getBookId() == numberIdToCheck) {
												bookData = p;
												break;
											}
										}

										bookData.setQuantityInStock(newQuantityInStock);
									}
									break;

								case 5:
									System.out.println("\nSaving...");
									break;

								default:
									System.out.println("\nThere's not a valid option! Try again: \n");
									break;
								}

							} while (optionToEdit != 5);

						} else {
							System.out.println("\nThis ID does not exist. Try again:");
						}
					} while (idExist == false);
				}

				System.out.println("\n=================================");
				break;

			case 4:
				if (list.isEmpty()) {
					System.out.println("\nThe stock is empty!");
				} else {
					System.out.println("\n=== Stock ===\n");

					for (Product p : list) {
						if (p.getQuantityInStock() <= 0) {
							System.out.println("Sold out!");
							System.out.println("❌ " + p);
							System.out.println("----------------------");
						} else if (p.getQuantityInStock() <= 5) {
							System.out.println("Just " + p.getQuantityInStock() + " last on stock!");
							System.out.println("⚠ " + p);
							System.out.println("----------------------");
						} else {
							System.out.println(p);
							System.out.println("----------------------");
						}
					}
				}

				System.out.println("\n=================================");
				break;

			case 5:				
				if (soldList.isEmpty()) {
					System.out.println("\nAny book sold yet!");
				} else {
					System.out.println("\n=== Sold books ===\n");
					for (Product p : soldList) {
						System.out.println(p.toStringSoldList());
						System.out.println("----------------------");
					}
				}
				
				System.out.println("\n=================================");
				break;

			case 6:
				System.out.println("\nExiting...");
				break;

			default:
				System.out.println("\nThere's not a valid option! Try again:");
				break;
			}

		} while (response != 6);
		sc.close();
	}
}