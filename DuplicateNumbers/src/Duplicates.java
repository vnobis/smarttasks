import java.util.*;

// Write a method that returns the duplicates in a Collection of Integers. A code template is provided, along with some sample input.

// Prints:
// dupe = 1
// dupe = 2
// dupe = 8
// dupe = 43

public class Duplicates {
    public static Collection<Integer> findDuplicates(Collection<Integer> numbers) {

        List<Integer> duplicates = new LinkedList<Integer>();
        // Set<Integer> duplicates = new HashSet<Integer>(); // if we need same order as in example
        Set<Integer> processedValues = new HashSet<Integer>();

        for (Integer value : numbers) {
            if (processedValues.contains(value) && !duplicates.contains(value)) {
                duplicates.add(value);
            } else {
                processedValues.add(value);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(6, 1, 1, 2, 3, 4, 8, 43, 5, 8, 1, 43, 2, 2, 9);

        Collection<Integer> dupes = findDuplicates(numbers);
        for (int dupe : dupes) {
            System.out.println("dupe = " + dupe);
        }
    }
}
// My prints:
// dupe = 1
// dupe = 8
// dupe = 43
// dupe = 2
