package com.learn.testing.tutorialspoint.mock;

import lombok.Data;

import java.util.List;

@Data
public class Portfolio {
    private StockService stockService;
    private List<Stock> stocks;

    public double getMarketValue(){
        double marketValue = 0.0;

        for(Stock stock:stocks){
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
