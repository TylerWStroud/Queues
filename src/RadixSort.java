// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 4B

public class RadixSort {
    /** Radix-related methods **/
    public static int ExtractDigit(int num, int tensPlace){
        int modulus = 10;
        int divisor = 1;

        // scales the modulus and divisor values by what 'tens place' is requested for digit extraction
        for(int i = 1; i < tensPlace+1; i++){
            modulus *= 10;
            divisor *= 10;
        }
        return (num%modulus)/divisor;
    }

    public static int CountDigits(int num){
        int count = 0;

        // counts each iteration of dividing by 10 until there's nothing left
        while(num != 0){
            count++;
            num /= 10;
        }
        return count;
    }

    /** Main **/
    public static void main(String[] args) {
        // scanner, inputs array, and Queue set declarations
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int[] inputs = new int[0];
        Queue<Integer>[] Q0_to_Q9 = new Queue[10];

        // populating the queue set with empty queues
        for(int i = 0 ; i < Q0_to_Q9.length; i++)
        {
            Q0_to_Q9[i] = new Queue<>();
        }

        int arraySize = 0;


        // MAIN MENU
        int input = 0;
        while (input != 4) {
            try {
                System.out.print("""
                        
                        ---------------MAIN MENU---------------
                        1 – Read array size
                        2 – Read array values
                        3 – Run Radix Sort and print outputs
                        4 – Exit program
                        
                        Enter option number:\s""");
                input = Integer.parseInt(scan.nextLine());
                System.out.println();

                // in case user inputs a choice not on the menu
                if (input < 1 || input > 4)
                    System.out.println("Invalid menu input. Please choose between options 1-4.");

                // Menu functions
                switch (input) {
                    /* set array size */
                    case 1:
                        boolean isPositive = false;
                        while (!isPositive) {
                            System.out.print("Enter an array size: ");
                            arraySize = Integer.parseInt(scan.nextLine());

                            // checks for a valid array size
                            if (arraySize < 0)
                                System.out.println("\nThat is not a valid array size.\nPlease provide a positive integer for your array size.\n");
                            else {
                                inputs = new int[arraySize];
                                isPositive = true;
                            }
                        }
                        break;

                    /* read user inputs for array elements */
                    case 2:
                        // in case user hasn't specified an array size yet
                        if (arraySize == 0)
                        {
                            System.out.println("Your array is size 0. It cannot hold any elements.");
                            break;
                        }
                        // user inputs elements
                        else {
                            for (int i = 0; i < arraySize; i++) {
                                boolean isPosInteger = false;
                                while (!isPosInteger) {
                                    System.out.print("Enter the positive <Integer> value of element " + (i+1) + ": ");
                                    String newElement = scan.nextLine();

                                    // reads element. throws exception if not a positive integer
                                    try {
                                        int intElement = Integer.parseInt(newElement);
                                        if (intElement < 0)
                                            throw new NumberFormatException();
                                        else {
                                            inputs[i] = intElement;
                                            isPosInteger = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("** Error: That is not a positive Integer **");
                                    }
                                }
                            }
                        }
                        // prints array elements
                        System.out.println("\nHere is your array: " + java.util.Arrays.toString(inputs));
                        break;

                    /* radix sort. print outputs */
                    case 3:
                        System.out.println("*** Radix Sort ***\nOld array: "+ java.util.Arrays.toString(inputs));

                        // prevents unnecessary calculation
                        if(arraySize == 0 || arraySize == 1){
                            System.out.println("There are not enough elements to sort.");
                            break;
                        }

                        // finding the largest number size by digit count comparisons
                        int max = 0;
                        for (Integer element : inputs) {
                            if (CountDigits(element) > max)
                                max = CountDigits(element);
                        }

                        // radix sort
                        for(int i = 0; i < max; i++)  // parsing by max digit count size
                        {
                            for (int j = 0; j < inputs.length; j++)  // parsing input array left to right
                            {
                                int element = inputs[j];
                                // setting key to extracted digit (specified by i)
                                int key = ExtractDigit(element, i);
                                // enqueues element into queue set (index specified by 'key')
                                Q0_to_Q9[key].enqueue(element);
                            }
                            // parsing queue set
                            int index = 0;
                            for(int j = 0; j < 10; j++){
                                while(!Q0_to_Q9[j].isEmpty()){
                                    // dequeues entire non-empty queue into 'inputs' array (FIFO)
                                    inputs[index++] = Q0_to_Q9[j].dequeue();
                                }
                            }
                        }
                        // returns sorted array
                        System.out.println("New array: "+java.util.Arrays.toString(inputs));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid menu input. Please choose between options 1-4.");
            }
        }
        System.out.println("Exiting...");
    }


}
