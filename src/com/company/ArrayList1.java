package com.company;

import java.util.Iterator;

public class ArrayList1 implements List1, Iterable<String> {

    private String[] array;
    private int listSize = 0;

    public ArrayList1() {
        this.array = new String[10];
    }

    /**
     * @param size - the size is entered by the user
     */
    public ArrayList1(int size) {
        this.array = new String[size];
    }

    /**
     * @param data - the data is entered by the user;
     */
    @Override
    public void add(String data) {
        if (listSize == array.length) {
            createNewArray();
        }
        array[listSize] = data;
        listSize++;
    }

    /**
     * @param index - who needs remove;
     */
    @Override
    public void remove(int index) {
        for (int i = index; i < listSize; i++) {
            array[index] = array[index + 1];
            index++;
        }
        if (listSize * 2 < array.length) {
            decreaseArray();
        }
        listSize--;
    }

    /**
     * @param index - the index is entered by the user.
     * @return - inside in the index.
     */
    @Override
    public String get(int index) {
        return array[index];
    }

    /**
     * @return - number of filled elements;
     */
    @Override
    public int size() {
        return listSize;
    }

    /**
     * @param index - the index to be changed
     * @param data  - the element to be replaced;
     */
    @Override
    public void set(int index, String data) {
        array[index] = data;
    }

    private void createNewArray() {
        String[] temp = array;
        this.array = new String[temp.length * 2];
        System.arraycopy(temp, 0, array, 0, temp.length);
    }

    public void decreaseArray() {
        String[] temp = array;
        this.array = new String[array.length - 10];
        System.arraycopy(temp, 0, array, 0, array.length);
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> iterator = new Iterator<String>() {
            private int current = 0;
            private int currentHas = 0;
            @Override
            public boolean hasNext() {
                if (array[currentHas] != null) {
                    currentHas++;
                    return true;
                }
                currentHas = 0;
                current = 0;
                return false;
            }

            @Override
            public String next() {
                return array[current++];
            }

            @Override
            public void remove() {
                for (int i = currentHas - 1; i < listSize; i++) {
                    if (array[currentHas] != null) {
                        array[currentHas - 1] = array[currentHas];
                        currentHas++;
                    } else {
                        array[currentHas - 1] = null;
                    }
                }
            }
        };
        return iterator;
    }
}
