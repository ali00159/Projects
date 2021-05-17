

public interface IntSorter
{
    /**
     * Will sort the int array "integers" in ascending order.
     * Arrays are passed by reference, so it does not return anything.
     * @param integers an array of unsorted integers
     */
    void sortAscending(int[] integers);

    /**
     * Will sort the int array "integers" in descending order.
     * Arrays are passed by reference, so it does not return anything.
     * @param integers an array of unsorted integers
     */
    void sortDescending(int[] integers);
}