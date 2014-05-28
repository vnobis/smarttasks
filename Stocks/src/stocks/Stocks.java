package stocks;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 Given a list of stock prices from the last N days return the maximum profit.
 Each day you can either: buy one share, sell any number of shares, or do nothing.

 For example:
 Example #1
 2  3  5  4  1     -> 5 (bought @ 2, bought @ 3 => total cost = $5, total earnings = $10, profit = $5)
 Buy Buy Sell Pass Pass
 2$ 3$ -> 1

 Example #2
 2, 3, 10, 4, 1, 7
 B  B   S  B  B  S   -> 15 + 9 = 24
 -2 -3 +20 -4 -1 +14
 */
public class Stocks {

    private static List<StockPrice> getStockPrices1() {
        List<StockPrice> stockPrices = new LinkedList<StockPrice>();

        stockPrices.add(new StockPrice(1, 2.0));
        stockPrices.add(new StockPrice(2, 3.0));
        stockPrices.add(new StockPrice(3, 5.0));
        stockPrices.add(new StockPrice(4, 4.0));
        stockPrices.add(new StockPrice(5, 1.0));

        return stockPrices;
    }

    private static List<StockPrice> getStockPrices2() {
        List<StockPrice> stockPrices = new LinkedList<StockPrice>();

        stockPrices.add(new StockPrice(1, 2.0));
        stockPrices.add(new StockPrice(2, 3.0));
        stockPrices.add(new StockPrice(3, 10.0));
        stockPrices.add(new StockPrice(4, 4.0));
        stockPrices.add(new StockPrice(5, 1.0));
        stockPrices.add(new StockPrice(6, 7.0));

        return stockPrices;
    }

    public static void main(String[] args) {
        List<StockPrice> stockPrices = getStockPrices1();

        Collection<Action> bestActions = StocksGenius.getBestActions1(stockPrices);

        print(stockPrices, bestActions);
    }

    private static void print(Collection<StockPrice> stockPrices, Collection<Action> bestActions) {

        assert stockPrices.size() == bestActions.size();
        assert stockPrices.size() != 0;

        Iterator<StockPrice> stockPriceIt = stockPrices.iterator();
        Iterator<Action> actionIt = bestActions.iterator();

        System.out.format("%-10s %-12s %-10S %-10S\n", "Day", "Stock Price", "Action", "Desc");
        do {
            StockPrice stockPrice = stockPriceIt.next();
            Action action = actionIt.next();

            System.out.format("%-10s %-12s %-10S %-10S\n", stockPrice.getDayNumber(), stockPrice.getPrice(), action.getActionName(), action.getDetails());
        }
        while (stockPriceIt.hasNext());
    }
}
