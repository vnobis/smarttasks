package timemanager;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/29/14
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    private Date time;
    private int count;

    public Point(Date time, int count) {
        this.time = time;
        this.count = count;
    }

    public Date getTime() {
        return time;
    }

    public int getCount() {
        return count;
    }
}
