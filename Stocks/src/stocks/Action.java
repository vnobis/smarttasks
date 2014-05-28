package stocks;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/21/14
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Action {

    protected ActionType type;
    protected int dayNumber;

    public String getActionName() {
        return type.toString();
    }

    public String getDetails() {
        return null;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public ActionType getType() {
        return type;
    }

}
