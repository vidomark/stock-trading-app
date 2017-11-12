package com.codecool.stockApp;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Stock price service that gets prices from Yahoo.
 **/
public class IexStockService {

	private static final String iexPath = "https://api.iextrading.com/1.0/stock/%s/quote";
	
	/** Get stock price from iex and return as a double
     *  @param symbol Stock symbol, for example "aapl"
     **/
	public double getPrice(String symbol) throws IOException {
        String url = String.format(iexPath, symbol);
        String result = RemoteURLReader.readFromUrl(url);
        JSONObject json = new JSONObject(result);
        String price = json.get("latestPrice").toString();
        return Double.parseDouble(price);
	}
	
	/** Buys a share of the given stock at the current price. Returns false if the purchase fails */
	public boolean buy(String symbol) {
		// Stub. No need to implement this.
		return true;
	}
}