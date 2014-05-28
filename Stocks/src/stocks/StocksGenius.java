package stocks;

import stocks.action.BuyAction;
import stocks.action.PassAction;
import stocks.action.SellAction;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/21/14
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class StocksGenius {
    private static class BuySellPeriod {
        private int periodStartDayNumber;
        private int periodEndDayNumber;
        private double maxSellPrice;


        private BuySellPeriod(int periodStartDayNumber, int periodEndDayNumber, double maxSellPrice) {
            assert periodStartDayNumber <= periodEndDayNumber;
            this.periodStartDayNumber = periodStartDayNumber;
            this.periodEndDayNumber = periodEndDayNumber;
            this.maxSellPrice = maxSellPrice;
        }

        public int getPeriodStartDayNumber() {
            return periodStartDayNumber;
        }

        public int getPeriodEndDayNumber() {
            return periodEndDayNumber;
        }

        public Collection<Action> generateActionsForPeriod(Collection<StockPrice> stockPrices) {
            Collection<Action> listOfActions = new LinkedList<Action>();
            if (periodStartDayNumber == periodEndDayNumber) {
                listOfActions.add(new PassAction(periodStartDayNumber));
                return listOfActions;
            }

            double income = 0;
            for (int i = periodStartDayNumber; i < periodEndDayNumber; i++) {
                StockPrice stockPrice = getStockPriceForDay(i, stockPrices);
                if (stockPrice != null) {
                    listOfActions.add(new BuyAction(i, new Share(stockPrice.getPrice())));
                    income += maxSellPrice;
                } else {
                    listOfActions.add(new PassAction(i));
                }
            }
            listOfActions.add(new SellAction(periodEndDayNumber, income));
            return listOfActions;
        }

        private StockPrice getStockPriceForDay(int day, Collection<StockPrice> stockPrices) {
            for (StockPrice stockPrice : stockPrices) {
                if (stockPrice.getDayNumber() == day) {
                    return stockPrice;
                }
            }
            return null;
        }
    }

    public static Collection<Action> getBestActions1(List<StockPrice> stockPrices) {

        Collection<BuySellPeriod> periods = getPeriods(stockPrices);
        Collection<Action> actions = new LinkedList<Action>();
        for (BuySellPeriod period : periods) {
            actions.addAll(period.generateActionsForPeriod(stockPrices));
        }
        return actions;
        //return getStub(stockPrices.size());
    }


    private static Collection<BuySellPeriod> getPeriods(List<StockPrice> stockPricesForPeriod) {
        Collection<BuySellPeriod> periods = new LinkedList<BuySellPeriod>();
        StockPrice maxStockPriceForPeriod;
        do {
            // First we are looking for max stock price for all available days.
            maxStockPriceForPeriod = getDayWithMaxStockPrice(stockPricesForPeriod);
            assert maxStockPriceForPeriod != null;
            // We may gain income if we will buy stocks from first day of period till day with max stock prices
            periods.add(new BuySellPeriod(
                    stockPricesForPeriod.get(0).getDayNumber(),
                    maxStockPriceForPeriod.getDayNumber(),
                    maxStockPriceForPeriod.getPrice()));

            stockPricesForPeriod = getNewPeriodStockPrices(stockPricesForPeriod, maxStockPriceForPeriod);
        }
        while (stockPricesForPeriod.size() != 0);


        return periods;
    }

    private static List<StockPrice> getNewPeriodStockPrices(List<StockPrice> stockPricesForPeriod, StockPrice maxStockPriceForPeriod) {
        // Cut data for [day 1, day with max price]
        List<StockPrice> stockPricesForNewPeriod = new LinkedList<StockPrice>(stockPricesForPeriod
                .subList(stockPricesForPeriod.indexOf(maxStockPriceForPeriod), stockPricesForPeriod.size()));

        //If new period starts with days with same price as maxStockPriceForPeriod.price, we can remove them
        while (stockPricesForNewPeriod.size() != 0
                && stockPricesForNewPeriod.get(0).getPrice() == maxStockPriceForPeriod.getPrice()) {
            stockPricesForNewPeriod.remove(0);
        }

        return stockPricesForNewPeriod;
    }

    private static StockPrice getDayWithMaxStockPrice(Collection<StockPrice> stockPrices) {
        assert stockPrices.size() != 0;
        StockPrice maxStockPrice = stockPrices.iterator().next(); // get first element

        for (StockPrice stockPrice : stockPrices) {
            if (maxStockPrice.getPrice() < stockPrice.getPrice()) {
                maxStockPrice = stockPrice;
            }
        }

        return maxStockPrice;
    }
}
