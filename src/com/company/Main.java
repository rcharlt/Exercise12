package com.company;
/*Rylee Charlton, 04/09/2019, Exercise 11
Implement a Queue generic type similar to the Stack type but with enqueue( ) and dequeue( ) methods.
The enqueue( ) method adds an element to the queue and the dequeue( ) method removes the first/oldest
element from the queue. Stacks are often described as being "last-in, first-out" whereas queues represent a
"first-in, first-out" behavior.
make sure to have a try-cache for q
*/
class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}


class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int indexTwo = 1;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element ) throws QueueFullException {
        if (index >= size) {
            throw new QueueFullException();
        }

        elements[index] = element;
        index++;
    }

    E dequeue () throws QueueEmptyException {
        if (index == 0) {
            throw new QueueEmptyException();
        }

        E returnElement = elements[indexTwo-1];
        indexTwo++;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] agrs) {
        Queue<String> strings = new Queue<>(2);
        try {
            strings.enqueue("Hello");
            strings.enqueue("World");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }

    }
}