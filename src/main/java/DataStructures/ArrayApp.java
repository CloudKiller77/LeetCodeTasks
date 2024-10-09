package DataStructures;

import java.time.LocalDateTime;

public class ArrayApp {
    public static void main(String[] args) {
        long[] arr; // Ссылка на массив
        arr = new long[100]; // Создание массива
        int nElem = 0; // Колличество элементов
        int i; // Счетчик цикла
        long searchKey; // Ключи искомого элемента

        long time1;
        long time2;
        long end;

        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 88;
        arr[3] = 44;
        arr[4] = 55;
        arr[5] = 66;
        arr[6] = 11;
        arr[7] = 0;
        arr[8] = 33;
        arr[9] = 22;
        nElem = 10;

        // Перебор элементов
        time1 = LocalDateTime.now().getNano();
        for (i = 0; i < nElem; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        time2 = LocalDateTime.now().getNano();
        end = time1 - time2;
        System.out.println("Time: " + end);

        time1 = LocalDateTime.now().getNano();
        searchKey = 66; // Поиск элемента с ключом 66
        for (i = 0; i < nElem; i++) {
            if (arr[i] == searchKey) {
                break;
            }
        }
        if (i == nElem)
            System.out.println("Can't find " + searchKey);
        else
            System.out.println("Found " + searchKey);
        time2 = LocalDateTime.now().getNano();
        end = time1 - time2;
        System.out.println("Time: " + end);
        System.out.println("");

        time1 = LocalDateTime.now().getNano();
        searchKey = 55; // Удаление элемента
        for (i = 0; i < nElem; i++) {
            if (arr[i] == searchKey) {
                break;
            }
        }
        for (int j=i; j < nElem; j++) {
            arr[j] = arr[j + 1];
        }
        // if (nElem - i >=0) System.arraycopy(arr, i + 1, arr, i, nElem - i);
        nElem--;
        time2 = LocalDateTime.now().getNano();
        end = time1 - time2;
        System.out.println("Time: " + end);
        System.out.println("");

        for (i = 0; i < nElem; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
