package com.codecool.stockApp;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Stock price service that gets prices from Yahoo.
 **/
public class StockAPIService {

	private final String API_PATH = "https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=%s";
	private final RemoteURLReader remoteURLReader;

	protected StockAPIService() {
		this.remoteURLReader = new RemoteURLReader();
	}
	
	/** Get stock price from iex and return as a double
     *  @param symbol Stock symbol, for example "aapl"
     **/
	public double getPrice(String symbol) throws IOException {
        String url = String.format(API_PATH, symbol);
        String result = remoteURLReader.readFromUrl(url);
        JSONObject json = new JSONObject(result);
        String price = json.get("price").toString();
        return Double.parseDouble(price);
	}
	
	/** Buys a share of the given stock at the current price. Returns false if the purchase fails */
	public boolean buy() {
		// Stub. No need to implement this.
		return true;
	}
}
