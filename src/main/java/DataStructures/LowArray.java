package DataStructures;

public class LowArray {
    private final long[] arr;

    public LowArray(int size) {
        this.arr = new long[size];
    }

    public void setElement(int index, long value) {
        arr[index] = value;
    }

    public long getElement(int index) {
        return arr[index];
    }
}
