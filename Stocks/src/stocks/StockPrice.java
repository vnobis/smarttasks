package stocks;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/21/14
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class StockPrice {
    private int dayNumber;
    private double price;

    public StockPrice(int dayNumber, double price) {
        this.dayNumber = dayNumber;
        this.price = price;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
