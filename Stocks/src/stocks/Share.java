package stocks;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/21/14
 * Time: 1:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Share {
    private double initialPrice;


    public Share(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getInitialPrice() {
        return initialPrice;
    }
}
