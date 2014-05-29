package timemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vnob
 * Date: 5/29/14
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeManager {
    private static List<Task> getTestData() {
        List<Task> tasks = new ArrayList<Task>();

        Date startDate = new Date();
        Date endDate = new Date();

        startDate.setSeconds(0);
        endDate.setSeconds(0);

        startDate.setHours(12);
        startDate.setMinutes(0);
        endDate.setHours(13);
        endDate.setMinutes(40);
        tasks.add(new Task((Date) startDate.clone(), (Date) endDate.clone())); // task #1

        startDate.setHours(12);
        startDate.setMinutes(30);
        endDate.setHours(13);
        endDate.setMinutes(20);
        tasks.add(new Task((Date) startDate.clone(), (Date) endDate.clone())); // task #2

        startDate.setHours(13);
        startDate.setMinutes(0);
        endDate.setHours(13);
        endDate.setMinutes(40);
        tasks.add(new Task((Date) startDate.clone(), (Date) endDate.clone())); // task #3

        return tasks;
    }

    private static void printTasks(List<Task> tasks) {
        System.out.println("Tasks:");
        int i = 1;
        for (Task task : tasks) {
            System.out.format("%s: %02d:%02d - %02d:%02d\n", i++, task.getStart().getHours(), task.getStart().getMinutes(),
                    task.getEnd().getHours(), task.getEnd().getMinutes());
        }
    }

    private static void printPoints(Collection<Point> points) {
        System.out.println("Points:");
        int i = 1;
        for (Point point : points) {
            System.out.format("%s: %02d:%02d - %d\n", i++, point.getTime().getHours(), point.getTime().getMinutes(), point.getCount());
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = getTestData();

        printTasks(tasks);

        Collection<Point> points = TaskToPointConverter.createPoint1(tasks);
        printPoints(points);

        points = TaskToPointConverter.createPoint2(tasks);
        printPoints(points);
    }
}
