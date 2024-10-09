package DataStructures;

public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public Integer findBinary(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems;
        int centerIn;

        while(true) {
            centerIn = (lowerBound + upperBound) / 2;
            if (a[centerIn] == searchKey) {
                return centerIn;
            } else if (lowerBound > upperBound) {
                System.out.println("Элемент не найден");
                return nElems;
            } else {
                if (a[centerIn] < searchKey) {
                    lowerBound = centerIn + 1; // В верхней половине
                } else {
                    upperBound = centerIn - 1; // В нижней половине
                }
            }
        }
    }

    public int size() {
        return nElems;
    }

    public void insert(long value) {
        int i;
        for (i=0; i < nElems; i++) {
            if (a[i] > value) {
                break;
            }
        }
        for (int j=nElems; j>i; j--) {
            a[j] = a[j-1];
        }
        a[i] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int i = findBinary(value);
        if (i==nElems) {
            return false;
        } else {
            for (int j=i; j<nElems; j++) {
                a[j] = a[j+1];
            }
            nElems--;
        }
        return true;
    }

    public void display() {
        for (int i=0; i<nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
