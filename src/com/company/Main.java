package com.company;


class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}


class Queue<E> {
private E[] elements;
private int index = 0;
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

        E returnElement = elements[index - 1];
        index--;
        return returnElement;
    }
}


    public class Main {
        public static void main(String[] args) {
            Queue<String> strings = new Queue<String>(2);
            try {
                strings.enqueue("World");
                strings.enqueue("Hello");
                System.out.println(strings.dequeue());
                System.out.println(strings.dequeue());
            } catch (QueueFullException e) {
                e.printStackTrace();
            } catch (QueueEmptyException e){
                e.printStackTrace();
            }

        }
    }



