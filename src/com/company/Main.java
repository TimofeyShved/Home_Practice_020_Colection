package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// не совсем понимаю как он это понял, зачем ему писать всё в одном итераторе, через стек или рекурсию ( ┐(￣ヘ￣)┌ )
        // а вот что я понял:
        // - есть итератор строк, но не один, то есть у нас их несколько.
        // - и есть итератор по верх этих итераторов, который переклюсается между ними..
        // как-то так ( (￢_￢) )

        String[] strings_1 = {"text 11", "text 12", "text 13", "text 14", "text 15"};
        String[] strings_2 = {"text 21", "text 22", "text 23", "text 24", "text 25"};
        String[] strings_3 = {"text 31", "text 32", "text 33", "text 34", "text 35"};

        MyIterator<String> itr_1 = new MyIterator<String>(strings_1);
        MyIterator<String> itr_2 = new MyIterator<String>(strings_2);
        MyIterator<String> itr_3 = new MyIterator<String>(strings_3);



        Object[] o = {itr_1, itr_2, itr_3};
        MyFlatIterator<Object> itrO = new MyFlatIterator<Object>(o);

        for (int i = 0; i<15; i++){
            System.out.println(itrO.next());
        }


    }
}

// обычный итератор
class MyIterator <T> implements Iterator {

    private T[] array;
    private int index = 0;

    public MyIterator(T[] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (index < array.length){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (hasNext()){
            return array[index++];
        }
        index = 0;
        return array[index++];
    }

    @Override
    public void remove() {
        array[index] = null;
    }
}

// итератор с итераторами
class MyFlatIterator <T> implements Iterator {

    private T[] array;
    private int index = 0;

    public MyFlatIterator(T[] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (index < array.length){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (hasNext()){
            return array[index++];
        }
        index = 0;
        return array[index++];
    }

    @Override
    public void remove() {
        array[index] = null;
    }
}