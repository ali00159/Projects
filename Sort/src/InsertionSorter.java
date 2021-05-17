

/**
 * this is a method that is getting implements for intsorter using insetionsorter
 */

public class InsertionSorter implements IntSorter {
    /**
     * this is a method that checks if the list is ascending using a insertion sort
     * @param integers an array of unsorted integers
     */
    public void sortAscending(int[] integers) {

        // loop through all integers seeing if list is ascending

        for (int i = 1; i < integers.length; i++) {

            //setting i = 1 and checking if I is greater than length of list

            for (int j = i; j > 0; j--) {

                if (integers[j] < integers[j - 1]) {

                    //checking if the second value is greater than other values

                    int temp = integers[j];

                    // swapping index using a temp value

                    integers[j] = integers[j - 1];
                    integers[j - 1] = temp;
                }
            }
        }
    }

    /**
     * this is a method that checks if the list is descending using insertion sort
     * @param integers an array of unsorted integers
     */
    @Override
    public void sortDescending(int[] integers){

        //loop all integers seeing if list is descending

        for(int i = 1; i < integers.length; i++) {

            // setting i = 1 and checking if it is greater than the length of the other index

            for (int j = i; j > 0; j--) {

                //checking if j is equal to i and greater than index 0

                if (integers[j] > integers[j - 1]) {
                    int temp = integers[j];

                    //swapping index using the temp value

                    integers[j] = integers[j - 1];
                    integers[j - 1] = temp;
                }
            }
        }
    }
}


