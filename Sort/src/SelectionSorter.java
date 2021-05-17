

import javax.swing.*;

/**
 * this is a method that is getting implements for intsorter using selectionsorter
 */

public class SelectionSorter implements IntSorter {

    /**
     * this is a method that checks if the list is ascending using a selection sort
     * @param integers
     */
    public void sortAscending(int[] integers) {

        // for loop to iterate thru list until the second to last item

        for (int i = 0; i < (integers.length - 1); i++) {

            // set smallest val to the the index that i is at and create a second for loop to follow the value next to i

            int smallestVal = i;
            for (int y = i + 1; y < integers.length; y++) {

                // if the item at index y is smaller than the item at index smallestVal set the smallestVal index equal
                // to y and sway the to items

                if (integers[y] < integers[smallestVal]) {
                    smallestVal = y;
                }
            }

            // the swap of items

            int temp = integers[smallestVal];
            integers[smallestVal] = integers[i];
            integers[i] = temp;
        }
    }

    /**
     * this is a method that checks if the list is descending using selection sort
     * @param integers an array of unsorted integers
     */
    public void sortDescending(int[] integers) {

        // for loop to iterate thru list until the second to last item

        for (int i = 0; i < (integers.length - 1); i++) {

            // set greatest val to the the index that i is at and create a second for loop to follow the value next to i

            int greatestVal = i;
            for (int y = i + 1; y < integers.length; y++){

                // if the item at index y is greater than the item at index greatestVal set the greatestVal index equal
                // to y and sway the to items

                if (integers[y] > integers[greatestVal]) {
                    greatestVal = y;
                }
            }

            // the swap of items

            int temp = integers[greatestVal];
            integers[greatestVal] = integers[i];
            integers[i] = temp;
        }
    }
}

