// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 4B

public class Queue<E>
{
    public Node<E> QueueName;

    public Queue()
    {
        QueueName = null;
    }

    // adds new element to back of queue (FIFO)
    public void enqueue(E data){
        if (QueueName == null)
            QueueName = new Node<>(data); // one node list
        else
        {
            Node<E> temp = QueueName;
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = new Node<>(data); // link new node as last node
        }
    }

    // returns front generic element, removes from queue
    public E dequeue(){
        Node<E> temp = QueueName;
        if(QueueName.next != null)
            QueueName = QueueName.next;
        else{
            QueueName = null;
        }

        return temp.data;
    }

    // returns front element of queue
    public E front(){
        if(isEmpty())
            return null;
        else {
            return QueueName.data;
        }
    }

    // returns integer count of queued elements
    public int size() {
        int queueSize = 0;
        // check nullity
        if(isEmpty())
            return queueSize;
        // traversal count
        else
        {
            Node<E> temp = QueueName;
            queueSize++;
            while(temp.next != null)
            {
                queueSize++;
                temp = temp.next;
            }
        }
        return queueSize;
    }

    // checks queue nullity
    public boolean isEmpty() {
        return QueueName == null;
    }

    // prints queue in sequential order (left-to-right, newest-to-oldest)
    public void printQueue() {
        Node<E> temp = QueueName;
        System.out.print(String.format("%-2s"," "));
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    // class to create nodes as generic objects
    private class Node<E>
    {
        private E data;  //data field
        private Node<E> next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}
