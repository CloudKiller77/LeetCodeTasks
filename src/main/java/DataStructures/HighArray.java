package DataStructures;

import java.util.Arrays;

public class HighArray {
    private long[] arr;
    private int count;

    public HighArray(int size) {
        arr = new long[size];
        count = 0;
    }

    public void insert(int index, long value) {
        arr[index] = value;
        count++;
    }

    public long getElement(int value) {
        int i;
        for (i = 0; i < count; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        throw new NullPointerException(String.format("Element with [value == %s] not found", value));
    }

    public boolean find(int value) {
        int i;
        for (i = 0; i < count; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        throw new NullPointerException(String.format("Element with [value == %s] not found", value));
    }

    public boolean delete(long value) {
        int i;
        for (i = 0; i < count; i++) {
            if (arr[i] == value) {
                break;
            }
        }
        for (int k = i; k < count; k++) {
                arr[k] = arr[k+1];
            }
        count--;
        return true;
    }

    public String getString() {
        int i;
        StringBuilder build = new StringBuilder();
        build.append("[");

        for (i = 0; i < arr.length; i++) {
            build.append(arr[i]);

            if (i == arr.length-1)
                return  build.append("]").toString();
            build.append(", ");
        }
        return null;
    }

    @Override
    public String toString() {
        return "HighArray{" +
                "arr=" + Arrays.toString(arr) +
                ", count=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }
}
