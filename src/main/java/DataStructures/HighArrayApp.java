package DataStructures;

public class HighArrayApp {
    public static void main(String[] args) {
        HighArray highArray;
        highArray = new HighArray(12);

        highArray.insert(0, 77);
        highArray.insert(1, 99);
        highArray.insert(2, 88);
        highArray.insert(3, 44);
        highArray.insert(4, 55);
        highArray.insert(5, 66);
        highArray.insert(6, 0);
        highArray.insert(7, 33);
        highArray.insert(8, 22);
        highArray.insert(9, 11);

        System.out.println(highArray.getString());
        System.out.println(highArray.getElement(22));

        highArray.delete(0);
        highArray.delete(11);
        highArray.delete(77);

        System.out.println(highArray.getString());
    }
}
