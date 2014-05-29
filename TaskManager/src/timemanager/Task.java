package timemanager;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/29/14
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task {
    private Date start;
    private Date end;

    public Task(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
