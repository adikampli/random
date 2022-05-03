package ds;

import java.util.AbstractList;

public class CustomArrayList<E> extends AbstractList<E> {
    E[] arr;
    int size = 0, capacity = 10;

    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        this.arr = (E[]) new Object[capacity];
    }

    @Override
    public E get(int index) {
        return arr[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E ele) {
        if (size < capacity) {
            arr[size++] = ele;
            return true;
        }

        @SuppressWarnings("unchecked")
        E[] newArr = (E[]) new Object[size / 2];

        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
        newArr[size++] = ele;
        return true;
    }

    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        list.forEach(System.out::println);
    }
}