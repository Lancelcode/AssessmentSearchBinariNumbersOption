import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Operation
{
    public static ArrayList loadData(String fileName)
    {
        ArrayList<Integer> numberData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            {
                // Loop through each line of the file and parse numbers.
                while ((line = br.readLine()) != null)
                {
                    String[] numbers = line.split(","); // Split each line by commas, into components.
                    for (String num : numbers) {numberData.add(Integer.valueOf(num.trim()));} // Parse and add each number to the array list.
                }
                System.out.println("\nNumbers loaded from file.");
            }
        } catch (IOException e)
        {
            // Handle file reading errors.
            System.out.println("Error reading file: " + fileName);
        } catch (NumberFormatException e)
        {
            // Handle errors related to incorrect number formatting.
            System.out.println("Error parsing number: " + e.getMessage());
        }

        return numberData;
    }


    public static boolean isSorted(ArrayList<Integer> array)
    {
        boolean isSorted = true;

        // Loop through the array and verify order.
        for (int index=0; index < array.size()-1; index++)
        {
            if(array.get(index+1) < array.get(index))
            {
                isSorted = false; // Return false if unsorted.
                break;
            }
        }

        return isSorted; // Return true if all elements are in order.
    }

    /**
     * Performs a sequential search for specific values in the given ArrayList.
     * Prints the position of each searched value or indicates if not found.
     *
     * @param array the ArrayList to search
     */
    public static void sequentialSearch(ArrayList<Integer> array)
    {
        // Demonstrates searching for various key positions and random numbers.
        System.out.print("\nFirst number in the array: ");
        sequentialSearch(array, array.get(0));

        System.out.print("\nSecond number in the array: ");
        sequentialSearch(array, array.get(1));

        System.out.print("\nLast number in the array: ");
        sequentialSearch(array, array.get(array.size() - 1));

        System.out.print("\nSecond last number in the array: ");
        sequentialSearch(array, array.get(array.size() - 2));

        System.out.print("\nMiddle number of the array: ");
        sequentialSearch(array, array.get(array.size() / 2));

        System.out.print("\nNumber left of the middle in the array: ");
        sequentialSearch(array, array.get((array.size() / 2) - 1));

        System.out.print("\nNumber right of the middle in the array: ");
        sequentialSearch(array, array.get((array.size() / 2) + 1));


        System.out.println("\nFive random numbers within the array:\n");
        sequentialSearch(array, 61);
        sequentialSearch(array, 199575);
        sequentialSearch(array, 148126);
        sequentialSearch(array, 44302);
        sequentialSearch(array, 103959);

        System.out.println("\nThree random numbers not in the array:\n");
        sequentialSearch(array, 123);
        sequentialSearch(array, 1000000000);
        sequentialSearch(array, 101010);
    }

    /**
     * Helper function for sequential search. Searches for a specific number in the array.
     * Prints the result, including the position or a message if not found.
     *
     * @param array the ArrayList to search
     * @param number the number to find
     */
    private static void sequentialSearch(ArrayList<Integer> array, int number)
    {
        int result = array.indexOf(number);

        if (result == -1)
        {
            System.out.println(number + " is not present in the file");
        } else
        {
            System.out.println(number + " present at position " + result);
        }
    }


    public static void binarySearch(ArrayList<Integer> array)
    {
        System.out.print("\nFirst number in the array: ");
        binarySearch(array, array.get(0));

        System.out.print("\nSecond number in the array: ");
        binarySearch(array, array.get(1));

        System.out.print("\nLast number in the array: ");
        binarySearch(array, array.get(array.size() - 1));

        System.out.print("\nSecond last number in the array: ");
        binarySearch(array, array.get(array.size() - 2));

        System.out.print("\nMiddle number of the array: ");
        binarySearch(array, array.get(array.size() / 2));

        System.out.print("\nNumber left of the middle in the array: ");
        binarySearch(array, array.get((array.size() / 2) - 1));

        System.out.print("\nNumber right of the middle in the array: ");
        binarySearch(array, array.get((array.size() / 2) + 1));


        System.out.println("\nFive random numbers within the array:\n");
        binarySearch(array, 61);
        binarySearch(array, 199575);
        binarySearch(array, 148126);
        binarySearch(array, 44302);
        binarySearch(array, 103959);

        System.out.println("\nThree random numbers not in the array:\n");
        binarySearch(array, 123);
        binarySearch(array, 1);
        binarySearch(array, 1111111111);
    }

    // Same as sequentialSearch, but uses binary search logic.
    private static void binarySearch(ArrayList<Integer> array , int number)
    {
        int count = 0;
        int result;

        int low = 0;
        int high = array.size() - 1;

        while (low <= high)
        {
            // Keeps count of the iterations.
            count++;

            // Calculates the mid point before each iteration.
            int mid = low + (high - low) / 2;

            // Prints current position, data at the position, and the target data.
            System.out.println("\nPosition: " + mid + " Data: " + array.get(mid) + " Target: " + number);

            // Check if number present at mid.
            if (array.get(mid) == number)
            {
                result = mid;
                System.out.println(number + " found at position: " + result + " after searching through: " + count + " iterations.\n");
                return;
            }

            // If number is greater, ignore left half.
            if (array.get(mid) < number)
            {
                low = mid + 1;
                System.out.println("Going right");
            }

            // If number is smaller, ignore right half.
            else
            {
                high = mid - 1;
                System.out.println("Going left");
            }
        }
        // Display message if number is not present.
        System.out.println(number + " not found after searching through: " + count + " iterations.\n");

    }

    @SuppressWarnings("rawtypes")
    public static ArrayList sort(ArrayList<Integer> array)
    {
        // Instantiate the comparator.
        Comparator<Integer> comparator = new IntegerComparator();

        // Use the comparator to sort the array.
        array.sort(comparator);

        // Return sorted array.
        return array;
    }


    public static ArrayList selectFile()
    {
        ArrayList<Integer> array = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Search Program\n-------------\n\nSelect '1' to search the file 'Binsearchone'\nSelect '2' to search the file 'Binsearchtwo'");

        while(array.isEmpty())
        {
            int input = scan.nextInt();scan.nextLine();
            switch(input)
            {
                case 1 -> array = loadData("Binsearchone.txt");
                case 2 -> array = loadData("Binsearchtwo.txt");
                default -> System.out.println("Please type 1 or 2."); // Handle invalid input.
            }
        }
        return array; // Return the loaded array.
    }
}