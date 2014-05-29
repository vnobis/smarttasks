package timemanager;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/29/14
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskToPointConverter {

    public static Collection<Point> createPoint1(Collection<Task> tasks) { // complexity O(n^2)
        TreeSet<Date> possiblePointDates = new TreeSet<Date>();
        for (Task task : tasks) {   // complexity O(n)
            possiblePointDates.add(task.getStart());
            possiblePointDates.add(task.getEnd());
        }

        List<Point> points = new ArrayList<Point>();

        int previousCount = -1;
        for (Date possiblePointDate : possiblePointDates) {  // complexity O(n^2)
            int countOfTasks = coutOfTasks(possiblePointDate, tasks);
            if (previousCount != countOfTasks) {
                points.add(new Point(possiblePointDate, countOfTasks));
                previousCount = countOfTasks;
            }
        }

        return points;
    }

    private static int coutOfTasks(Date date, Collection<Task> tasks) { // complexity O(n)
        int i = 0;
        for (Task task : tasks) {
            if ((task.getStart().equals(date) || task.getStart().before(date))
                    && task.getEnd().after(date)) {
                i++;
            }
        }
        return i;
    }


    public static Collection<Point> createPoint2(Collection<Task> tasks) { // complexity O(n*log_n)
        TreeMap<Date, Integer> points = new TreeMap<Date, Integer>();
        for (Task task : tasks) {   // complexity O(n*log_n)
            Date startDate = task.getStart();
            Object count = points.get(startDate);
            if (count != null) {
                points.put(startDate, new Integer((Integer) count + 1));
            } else {
                points.put(startDate, new Integer(1));
            }

            Date endDate = task.getEnd();
            count = points.get(endDate);
            if (count != null) {
                points.put(endDate, new Integer((Integer) count - 1));
            } else {
                points.put(endDate, new Integer(-1));
            }
        }

        List<Point> result = new ArrayList<Point>();

        int previousCount = 0;
        for (Date date : points.keySet()) {  // complexity O(n)
            previousCount += points.get(date);
            result.add(new Point(date, previousCount));
        }

        return result;
    }
}
