package DataStructures;

public class LowArrayApp {
    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(100);
        int searchKey;
        int nElems;
        int i;

        arr.setElement(0, 77);
        arr.setElement(1, 99);
        arr.setElement(2, 88);
        arr.setElement(3, 44);
        arr.setElement(4, 55);
        arr.setElement(5, 66);
        arr.setElement(6, 0);
        arr.setElement(7, 33);
        arr.setElement(8, 22);
        arr.setElement(9, 11);
        nElems = 10;

        for (i = 0; i < nElems; i++) {
            System.out.print(arr.getElement(i) + " ");
        }
        System.out.println();

        searchKey = 11;
        for (i = 0; i < nElems; i++) {
            if (arr.getElement(i) == searchKey) {
                break;
            }
        }
        if (i == nElems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        searchKey = 0;
        for (i = 0; i < nElems; i++) {
            if (arr.getElement(i) == searchKey) {
                break;
            }
        }
        for (int j = i; j < nElems; j++) {
            arr.setElement( j, arr.getElement(j + 1));
        }
        nElems--;

        for (i = 0; i < nElems; i++) {
            System.out.print(arr.getElement(i) + " ");
        }
        System.out.println();
    }
}
