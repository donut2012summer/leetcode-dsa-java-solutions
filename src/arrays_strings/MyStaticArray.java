package arrays_strings;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Implement a static Array
 */
public class MyStaticArray {

    private int size;

    private Object[] arrayCapacity;

    public MyStaticArray(int capacity) {
        size = 0;
        arrayCapacity = new Object[capacity];
    }

    // push
    void push(Object element) {

        if (size >= arrayCapacity.length) {
            System.out.println("Oops ! Array is full");
            return;
        }

        arrayCapacity[size] = element;
        size++;
    }


    // remove element in the tail
    void pop(){

        if (size >= arrayCapacity.length) {
            System.out.println("Oops ! Array is full");
            return;
        }

        arrayCapacity[--size] = null;
    }

    void insert(int idx, Object element) {

        if (size >= arrayCapacity.length) {
            System.out.println("Oops ! Array is full");
            return;
        }

        if (idx < 0 || idx > size) {
            System.out.println("Invalid index");
            return;
        }

        for (int i = size - 1; i >= idx; i--) {
            arrayCapacity[i + 1] = arrayCapacity[i];
        }

        arrayCapacity[idx] = element;
        size++;

    }

    void delete(int idx){

        int currentLastIdx = size - 1;

        if(size <= 0){
            System.out.println("Oops ! Array is empty");
            return;
        }

        if(idx < 0 || idx > currentLastIdx){
            System.out.println("Invalid index");
            return;
        }

        for (int i = idx; i < currentLastIdx; i++) {
            arrayCapacity[i] = arrayCapacity[i + 1];
        }

        arrayCapacity[currentLastIdx] = null;
        size--;

    }

    @Override
    public String toString() {
        return Arrays.stream(arrayCapacity, 0, size)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    // test
    public static void main(String[] args) {
        MyStaticArray myStaticArray = new MyStaticArray(10);

        myStaticArray.push(1);
        myStaticArray.push(2);
        myStaticArray.push(3);
        System.out.println(myStaticArray); // 1, 2, 3

        myStaticArray.pop();
        System.out.println(myStaticArray); // 1, 2

        myStaticArray.insert(1, 4);
        System.out.println(myStaticArray); // 1, 4, 2

        myStaticArray.insert(3, 5);
        System.out.println(myStaticArray); // 1, 4, 2, 5 , insert in the tail

        myStaticArray.delete(0);
        System.out.println(myStaticArray); // 4, 2, 5

        myStaticArray.delete(-1);
        System.out.println(myStaticArray); // 4, 2, 5

    }



}
