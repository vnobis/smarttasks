package stocks.action;

import stocks.Action;
import stocks.ActionType;
import stocks.Share;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/21/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuyAction extends Action {
    private Share share;

    public BuyAction(int day, Share share) {
        this.type = ActionType.BUY;
        this.dayNumber = day;
        this.share = share;
    }


    public String getDetails() {
        return "-" + String.valueOf(share.getInitialPrice());
    }
}
