package com.learn.testing.tutorialspoint.mock;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Portfolio {
    private List<Stock> stocks;
    private StockService stockService;
    private double marketValue;
}
