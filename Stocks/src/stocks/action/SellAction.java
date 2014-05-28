package stocks.action;

import stocks.Action;
import stocks.ActionType;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/21/14
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SellAction extends Action {
    private double profit;

    public SellAction(int day, double profit) {
        this.type = ActionType.SELL;
        this.dayNumber = day;
        this.profit = profit;
    }


    public String getDetails() {
        return "+" + String.valueOf(profit);
    }
}
