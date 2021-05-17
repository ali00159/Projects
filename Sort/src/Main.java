

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] integers;
        IntSorter sorter;

        sorter = new SelectionSorter();

        integers = new int[]{5, 2, 7, 5, 1, 3, 4, 6};
        sorter.sortAscending(integers);
        System.out.println("SelectionSorter ascending:  " + Arrays.toString(integers));

        integers = new int[]{5, 2, 7, 5, 1, 3, 4, 6};
        sorter.sortDescending(integers);
        System.out.println("SelectionSorter descending: " + Arrays.toString(integers));


        sorter = new InsertionSorter();

        integers = new int[]{5, 2, 7, 5, 1, 3, 4, 6};
        sorter.sortAscending(integers);
        System.out.println("InsertionSorter ascending:  " + Arrays.toString(integers));

        integers = new int[]{5, 2, 7, 5, 1, 3, 4, 6};
        sorter.sortDescending(integers);
        System.out.println("InsertionSorter descending: " + Arrays.toString(integers));
    }
}
