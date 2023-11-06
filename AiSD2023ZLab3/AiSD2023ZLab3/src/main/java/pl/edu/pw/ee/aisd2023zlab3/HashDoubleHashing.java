package pl.edu.pw.ee.aisd2023zlab3;

public class HashDoubleHashing<T extends Comparable<T>> extends HashOpenAdressing<T> {

    public HashDoubleHashing() {
        super();
    }

    public HashDoubleHashing(int size) {
        super(size);
        validate(size);
    }
    @Override
    int hashFunc(int key, int i) {
        int m = getSize();

        key = key & Integer.MAX_VALUE;

        int firstFunc = key % m;
        int secondFunc = 1 + (key % (m - 1));

        int hash = (firstFunc + i * secondFunc) % m;

        return hash;
    }
    private void validate(int size) {
        if (size == 1) {
            throw new IllegalArgumentException("Dividing by zero. Size cannot be equal to 1");
        }
    }
}