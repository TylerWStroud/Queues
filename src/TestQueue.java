// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 4B

public class TestQueue {
    public static void main(String[] args){
        // scanner, Queue (int) declaration
        java.util.Scanner scan = new java.util.Scanner(System.in);
        Queue<Integer> intQueue = new Queue<>();

        // MAIN MENU
        int input = 0;
        while(input != 7)
        {
            try{
                System.out.print("""
                        
                        --------MAIN MENU--------
                        1 – Enqueue element
                        2 – Dequeue element
                        3 – Get front element
                        4 – get queue size
                        5 – Is Empty queue?
                        6 - Print queue
                        7 - Exit program
                        
                        Enter option number:\s""");
                input = Integer.parseInt(scan.nextLine());

                // in case user inputs a choice not on the menu
                if(input < 1 || input > 7)
                    System.out.println("Invalid menu option. Please choose between options 1-7.");


                // Menu functions
                switch(input){
                    /* enqueue element */
                    case 1:
                        int intElement = 0;
                        boolean isInteger = false;

                        // try/catch in case user inputs a non-integer value
                        while( !isInteger ){
                            System.out.print("\nEnter the (Integer) element you want to add to the queue: ");
                            String newElement = scan.nextLine();
                            try {
                                intElement = Integer.parseInt(newElement);
                                isInteger = true;
                            } catch (NumberFormatException e) {
                                System.out.print("\n** Error: That is not an Integer **");
                            }
                        }

                        // displaying results
                        System.out.print("\nMethod enqueue()\n" +
                                         "Queue before enqueuing "+intElement+":");
                        intQueue.printQueue();
                        intQueue.enqueue(intElement);
                        System.out.print("\nQueue after enqueuing "+intElement+": ");
                        intQueue.printQueue();
                        System.out.println();
                        break;

                    /* dequeue element */
                    case 2:
                        int dequeueElement = intQueue.front();
                        System.out.print("\nMethod dequeue()\n" +
                                         "Queue before dequeuing "+dequeueElement+":");
                        intQueue.printQueue();
                        intQueue.dequeue();
                        System.out.print("\nQueue after dequeuing "+dequeueElement+": ");
                        intQueue.printQueue();
                        System.out.println();
                        break;

                    /* get front element */
                    case 3:
                        System.out.println("\nMethod front()\nThe front element is: "+intQueue.front());
                        break;

                    /* get queue size */
                    case 4:
                        System.out.println("\nMethod size()\nThe queue size is "+intQueue.size());
                        break;

                    /* empty queue check */
                    case 5:
                        System.out.println("\nMethod isEmpty()");
                        if(intQueue.isEmpty())
                            System.out.println("The queue is empty.");
                        else {
                            System.out.println("The queue is not empty.");
                        }
                        break;

                    /* print queue */
                    case 6:
                        System.out.print("\nMethod printQueue()\nHere is your queue: ");
                        intQueue.printQueue();
                        System.out.println();
                        break;
                }

            }catch(NumberFormatException e){
                System.out.println("Invalid menu option. Please choose between options 1-7.");
            }
        }
        System.out.println("Exiting...");
    }
}
