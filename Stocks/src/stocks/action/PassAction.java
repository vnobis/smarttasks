package stocks.action;

import stocks.Action;
import stocks.ActionType;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/21/14
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PassAction extends Action {

    public PassAction(int day) {
        this.type = ActionType.PASS;
        this.dayNumber = day;
    }


    public String getDetails() {
        return "Pass";
    }
}