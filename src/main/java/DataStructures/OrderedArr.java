package DataStructures;

public class OrderedArr {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray ordArray = new OrdArray(maxSize);

//        for (int i=0; i < maxSize; i++) {
//
//        }

        ordArray.insert(10);
        ordArray.insert(2);
        ordArray.insert(12);
        ordArray.insert(23);
        ordArray.insert(43);
        ordArray.insert(9);
        ordArray.insert(44);
        ordArray.insert(55);
        ordArray.insert(60);
        ordArray.insert(70);
        ordArray.insert(88);

        ordArray.display();

        int searchElem = 2;
        if (ordArray.findBinary(searchElem) == ordArray.size()) {
            System.out.println("Элемент не найден: " + searchElem);
        } else {
            System.out.println("Элемент найден: " + searchElem);
        }
    }
}
