package pl.edu.pw.ee.aisd2023zlab3;

import pl.edu.pw.ee.aisd2023zlab3.exceptions.NotImplementedException;
import pl.edu.pw.ee.aisd2023zlab3.services.HashTable;

public abstract class HashOpenAdressing<T extends Comparable<T>> implements HashTable<T> {

    Comparable<T> beginRemoveValue = new Comparable<T>() {
        @Override
        public int compareTo(T o) {
            return o == this ? 0 : -1;
        }
    };

    private final T deleteValue = (T) beginRemoveValue;
    private final T nil = null;
    private int size;
    private int nElems;
    private T[] hashElems;
    private final double correctLoadFactor;

    HashOpenAdressing() {
        this(2039); // initial size as random prime number
    }

    HashOpenAdressing(int size) {
        validateHashInitSize(size);

        this.size = size;
        this.hashElems = createTable(this.size);
        this.correctLoadFactor = 0.75;
    }

    @Override
    public void put(T newElem) {
        validateInputElem(newElem);
        resizeIfNeeded();

        int key = newElem.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);

        while (hashElems[hashId] != nil && hashElems[hashId].compareTo(newElem) != 0 && deleteValue.compareTo(hashElems[hashId]) != 0) {
            if (i + 1 == size) {
                doubleResize();
                i = -1;
            }
            i = (i + 1) % size;
            hashId = hashFunc(key, i);
        }
        if (hashElems[hashId] != nil && hashElems[hashId].compareTo(newElem) == 0) {
            hashElems[hashId] = newElem;
        } else {
            hashElems[hashId] = newElem;
            nElems++;
        }
    }


    @Override
    public T get(T elem) {
        validateInputElem(elem);
        validateNumOfElems();

        int key = elem.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);

        while (hashElems[hashId] != nil && hashElems[hashId].compareTo(elem) != 0) {
            if (i + 1 == size) {
                doubleResize();
                i = -1;
            }

            i = (i + 1) % size;
            hashId = hashFunc(key, i);

        }

        if (hashElems[hashId] == nil) {
            throw new IllegalArgumentException("Element does not exist in the hash table!");
        }

        return hashElems[hashId];
    }

    @Override
    public void delete(T elem) {
        validateInputElem(elem);
        validateNumOfElems();

        int key = elem.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);

        while (hashElems[hashId] != nil && hashElems[hashId].compareTo(elem) != 0) {
            if (i + 1 == size) {
                throw new IllegalArgumentException("Elem does not exist in hash table!");
            }

            i = (i + 1) % size;
            hashId = hashFunc(key, i);
        }

        if (hashElems[hashId] == nil) {
            throw new IllegalArgumentException("Elem does not exist in hash table!");
        }else{
            hashElems[hashId] = (T) deleteValue;
            nElems--;
        }
    }

    private void validateHashInitSize(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("Initial size of hash table cannot be lower than 1!");
        }
    }

    private void validateInputElem(T newElem) {
        if (newElem == null) {
            throw new IllegalArgumentException("Input elem cannot be null!");
        }
    }

    private void validateNumOfElems() {
        if (nElems == 0) {
            throw new IllegalStateException("Hash Table is empty!");
        }
    }


    abstract int hashFunc(int key, int i);

    int getSize() {
        return size;
    }

    private T[] createTable(int size) {
        return (T[]) new Comparable[size];
    }

    private void resizeIfNeeded() {
        double loadFactor = countLoadFactor();

        if (loadFactor >= correctLoadFactor) {
            doubleResize();
        }
    }

    private double countLoadFactor() {
        return (double) nElems / size;
    }

    private void doubleResize() {
        this.size *= 2;

        T[] oldElems = hashElems;
        hashElems = createTable(size);
        nElems = 0;

        T currentElem;
        for (int i = 0; i < oldElems.length; i++) {
            currentElem = oldElems[i];

            if (currentElem != nil) {
                put(currentElem);
                oldElems[i] = nil;
            }
        }
    }
}
