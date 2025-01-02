package Model;

import java.util.LinkedList;

// The QueueOfCustomers class to maintain all the queue of customers.
public class QueueofCustomers {
    private LinkedList<Customer> queue;

    public QueueofCustomers() {
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    public Customer getNextCustomer() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public LinkedList<Customer> getQueue() {
        return queue;
    }
}
