import java.util.ArrayList;
import java.util.Scanner;


public class BinarySearch
{
    public static void main(String[] args)
    {

        // Initiate Array List to hold the selected file.
        ArrayList<Integer> file = new ArrayList<>();

        // Prompt user to choose a file and load selection.
        file = Operation.selectFile();

        // Check if the file is sorted.
        if(Operation.isSorted(file))
        {
            // If the file is sorted, carry out a binary search and document the steps.
            Operation.binarySearch(file);
        } else
        {
            // If the file is unsorted, inform the user and display options.
            System.out.println("File is not sorted");
            System.out.println("""
                               How would you like to proceed?
                               
                               1: Sequential search
                               2: Sort and binary search""");

            // Initiates variable to hold user choice.
            int choice = 0;

            // While loop ensures user selects a valid option.
            while(choice != 1 && choice != 2)
            {
                // Take in user input.
                Scanner scan = new Scanner(System.in);
                choice = scan.nextInt();scan.nextLine();

                // Carry out chosen operation.
                switch(choice)
                {
                    case 1 -> Operation.sequentialSearch(file);
                    case 2 -> {
                        file = Operation.sort(file);
                        Operation.binarySearch(file);
                    }
                    default -> System.out.println("Please enter 1 or 2");
                }


            }
        }
    }
}
