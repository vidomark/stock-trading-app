package com.codecool.stockApp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides a command line interface for stock trading.
 **/
public class TradingApp {
	public static void main(String[] args) {
	    TradingApp app = new TradingApp();
		Logger logger = new Logger();
		Trader trader = new Trader(logger);
	    app.start(trader, logger);
	}

	public void start(Trader trader, Logger logger) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a stock symbol (for example aapl):");
		String symbol = keyboard.nextLine();
		System.out.println("Enter the maximum price you are willing to pay: ");
		double price;
		try {
			price = keyboard.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Enter a number");
			return;
		}

		try {
			boolean purchased = trader.buy(symbol, price);
			if (purchased) {
				/*Logger.getInstance().log("Purchased stock!");*/
				logger.log("Purchased stock!");
			}
			else {
				/*Logger.getInstance().log("Couldn't buy the stock at that price.");*/
				logger.log("Couldn't buy the stock at that price.");
			}
		} catch (Exception e) {
			/*Logger.getInstance().log("There was an error while attempting to buy the stock: " + e.getMessage());*/
			logger.log("There was an error while attempting to buy the stock: " + e.getMessage());
		}
	}
}