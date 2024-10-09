package easyTasks;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EasyTasks {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> unique = new HashMap<>();
        // Arrays.stream(arr).map(s -> unique.put(s, unique.getOrDefault(s, 0) + 1)).close();
        for (int num: arr) {
            unique.put(num, unique.getOrDefault(num, 0) + 1);
        }
        System.out.println(unique);
        HashSet<Integer> result = new HashSet<>(unique.values());
        return unique.size() == result.size();
    }

    public boolean isPalindrome(int x) {
        // Долгое решение
        if (x == 0) {
            return true;
        } else if (x < 0) {
            return false;
        } else {
            ArrayList<Integer> array = new ArrayList<Integer>();
            do {
                array.add(x % 10);
                x /= 10;
            } while (x > 0);
            System.out.println(array);
            var number = IntStream.range(0, array.size())
                    .map(i -> (array.size() - 1 - i))
                    .mapToObj(array::get)
                    .collect(Collectors.toCollection(ArrayList::new));
            return array.equals(number);
        }
    }

    public boolean isPalindromeTwo(int x) {
        // Быстрое решение
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reversed_int = 0;
        while(x > reversed_int) {
            int y = x % 10;
            x /= 10;

            reversed_int = (reversed_int * 10) + y;
        }

        return x == reversed_int || x == reversed_int / 10;
    }

    public int convertRomanToInt(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int sum = 0;
        int point = 0;
        int fin = 0;
        //int point = convertRomanToInt(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int numberI = s.charAt(i);
                int numberJ = s.charAt(j);
                if (numberI < numberJ) {
                    point = numberJ - numberI;
                    fin = sum + point;
                } else {
                    point = numberI + numberJ;
                    fin = sum + point;
                }
                fin += point;
            }
        }

        return fin;

//            int number = s.charAt(i);
//
//            if (point < number) {
//               sum = number - point;
//            }
//            point = number;
//        }
//        sum += point;
//        return  sum;
//        HashMap<String, Integer> numbers = new HashMap<>();
//        numbers.put("M", 1000);
//        numbers.put("D", 500);
//        numbers.put("C", 100);
//        numbers.put("L", 50);
//        numbers.put("X", 10);
//        numbers.put("V", 5);
//        numbers.put("I", 1);

//        for (Map.Entry<String, Integer> item: numbers.entrySet()) {
//            if (s.contains(item.getKey())) {
//                int pop = item.getValue();
//                point = point +  pop;
//            }
//        }
    }

    // 1929
    public int[] getConcatenation(int[] nums) {
        int newSize = nums.length * 2;
        int[] newList = new int[newSize];
        int count = 0;
        System.arraycopy(nums, 0, newList, 0, nums.length);
        for (int i = newList.length/2; i < newList.length; i++) {
            newList[i] = nums[count];
            count++;
        }
        return newList;
    }

    // 1920
    public int[] buildArray(int[] nums) {
        int[] counts = new int[nums.length];
        if (1 <= nums.length && nums.length <= 1000) {
            for (int i = 0; i < nums.length; i++) {
                if (0 <= nums[i] && nums[i] < nums.length) {
                    counts[i] = nums[nums[i]];
                }
            }
        }
        return counts;
    }

    // 2769
    public int theMaximumAchievableX(int num, int t) {
        return num + (2 * t);
    }

    //1108
    public String defangIPaddr(String address) {
        return address.replaceAll("[.]", "[.]");
    }

    //739
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        int temp = 0;
        int count = 0;
        for (int i = 0; i < temperatures.length - 1; i++) {
            if (temperatures[i] < temperatures[i+1]) {
                days[i] = 1;
            }
        }
        for (int i = 0; i < days.length; i++) {
            if (days[i] == 0) {
                for (int j = days[i]; j < temperatures.length - 1; j++) {
                    if (temperatures[j] > temperatures[j+1]) {
                        count++;
                    }
                    days[i] = count;
                }
                count = 0;
            }
        }
        return days;
    }

    //2469
    public double[] convertTemperature(double celsius) {
        double[] nums = new double[2];
        double x = 273.15;
        double kelvin = celsius + x;
        double fahrenheit = celsius * 1.80 + 32.00;
        nums[0] = kelvin;
        nums[1] = fahrenheit;
        return nums;
    }

    //1512
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        int pair = 0;
        for (int num: nums) {
            pair += maps.getOrDefault(num, 0);
            maps.put(num, maps.getOrDefault(num, 0)+1);
        }
        return pair;
    }

    private int makeOperations(int num, String line) {
        switch (line) {
            case "--X" -> num -= 1;
            case "X--" -> num -= 1;
            case "X++" -> num += 1;
            case "++X" -> num += 1;
        }
        return num;
    }

    //2011
    public int finalValueAfterOperations(String[] operations) {
        // ["--X","X++","X++"]
        int x = 0;
        for (String l: operations) {
            x = makeOperations(x, l);
        }
//        for (String l: operations) {
//            if (l.equals("--X") || l.equals("X--")) {
//                x -= 1;
//            } else if (l.equals("++X") || l.equals("X++")) {
//                x += 1;
//            }
//        }
        return x;
    }

    //771
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    //1470
    public int[] shuffle(int[] nums, int n) {
        if (nums.length == 2*n) {
            int count = n;
            int count2 = 0;
            int[] temp = new int[nums.length];
            for (int i = 0; i < temp.length; i++) {
                if (i % 2 == 0) {
                    temp[i] = nums[count2];
                    count2++;
                } else {
                    temp[i] = nums[count];
                    count++;
                }
            }
            return temp;
        }
        return null;
    }

    //2942
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        String l = Character.toString(x);
        for(int i = 0; i < words.length; i++) {
            if(words[i].contains(l)) {
                list.add(i);
            }
        }
        return list;
    }

    //1637
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] temp = new int[points.length];
        int count = 0;
        int max = 0;
        for (int[] point : points) {
            for (int j = 0; j < 1; j++) {
                temp[count] = point[0];
                count++;
            }
        }
        temp = Arrays.stream(temp).sorted().toArray();
        for (int i = 0; i < temp.length-1; i++) {
            if (temp[i+1] - temp[i] > max) {
                max = temp[i+1] - temp[i];
            }
        }
        return max;
    }

    //2894
    public int differenceOfSums(int n, int m) {
        if (1 <= n && m <= 1000) {
            int x = 0;
            int y = 0;
            for(int i = 0; i <= n; i++) {
                if (i % m != 0) {
                    x += i;
                } else {
                    y += i;
                }
            }
            System.out.println(x + " - " + y);
            return x-y;
        }
        return 0;
    }

    //1672
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int temp = 0;
        for (int[] nums: accounts) {
            for (int i: nums) {
                temp += i;
            }
            if (temp > max) {
                max = temp;
                temp = 0;
            } else {
                temp = 0;
            }
        }
        return max;
    }

    public native int getArea(int x, int y);

    //2413
    public int smallestEvenMultiple(int n) {
        int i = 0;
        int max = n * 2;
        for (i = n; i <= max; i++ ) {
            if (i % n == 0 && i % 2 == 0) {
                break;
            }
        }
        return i;
    }

    //2798
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int num: hours) {
            if (num >= target) {
                count++;
            }
        }
        return count;
    }

    //387
//    public int firstUniqChar(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            boolean ifFirstSame = false;
//            for (int j = 0; j < s.length(); j++) {
//                if (s.charAt(i) == s.charAt(j) && i != j) {
//                    ifFirstSame = true;
//                    break;
//                }
//            }
//            if (!ifFirstSame) return i;
//        }
//        return -1;
//    }

    //387
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //1431
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = 0;
        max = Arrays.stream(candies).max().getAsInt();
//        for (int i = 0; i < candies.length; i++) {
//            if (candies[i] > max) {
//                max = candies[i];
//            }
//        }
        System.out.println(max);
        for (int i = 0; i < candies.length; i++) {
            if (candies[i]+extraCandies >= max) {
                list.add(i, true);
            } else {
                list.add(i, false);
            }
        }
        return list;
    }

    //1678
    public String interpret(String command) {
        //return command.replace("()", "o").replace("(al)", "al");
        StringBuilder build = new StringBuilder(command.length());
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                build.append("G");
            } else if (command.charAt(i) == '(' && command.charAt(i+1) == ')') {
                build.append("o");
                i++;
            } else {
                build.append("al");
                i = i + 3;
            }
        }
        return build.toString();
    }

    //2824
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            for (int j = 1; j < nums.size(); j++) {
                if (i < j && nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    //
    public int numSquares(int n) {
        int count = 0;
        int[] list = new int[n];
        int[] squareTwo = new int[n];
        for (int i = 0; i < squareTwo.length; i++) {
            squareTwo[i] = (int) Math.pow(2, i);
        }
        while (count != n) {
            for (int i = 0; i < squareTwo.length; i++) {
                if (count == n) {
                    break;
                } else {
                    if (squareTwo[i] % 2 == 0 || squareTwo[i] % 3 == 0) {
                        count += squareTwo[i];
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(squareTwo));
        return 0;
    }

    //1480
    public int[] runningSum(int[] nums) {
        int count  = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            nums[i] = count;
        }
        return nums;
    }

    //1365
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> hashMap = new TreeMap<>();

        for (int num: nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }

        int lessNumber = 0;
        for (int num: hashMap.keySet()) {
            int temp = hashMap.get(num);
            hashMap.put(num, lessNumber);
            lessNumber += temp;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = hashMap.get(nums[i]);
        }
        return nums;
    }

    private int recurseGetNum(int n, int x, int y) {
        if (n == 0) {
            return x - y;
        } else {
            int num = n % 10;
            return recurseGetNum(n/10, x*num, y+num);
        }
    }

    //1281
    public int subtractProductAndSum(int n) {
        return recurseGetNum(n, 1, 0);
//        int x = 10;
//        int y = 100;
//        int z = 1000;
//        int c = 10000;
//        int l = 100000;
//        int k = 1000000;
//        int sum;
//        sum = ((n / z) * (n / y % x) * (n / x % x) * (n % x)) - ((n / z) + (n / y % x) + (n / x % x) + (n % x));
    }

    //2114
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            if (sentence.split(" ").length > max) {
                max = Math.max(max, sentence.split(" ").length);
            }
        }
        return max;
    }

    //2859
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int binary = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                binary += nums.get(i);
            }
        }
        return binary;
    }

    //2160
    public int minimumSum(int num) {
        int count = 0;
        int[] digit = new int[4];
        while (num > 0) {
            digit[count++] = num % 10;
            num /= 10;
        }
        Arrays.sort(digit);
        int x = digit[0] * 10 + digit[2];
        int y = digit[1] * 10 + digit[3];
        return x + y;
    }

    //2108
    public String firstPalindrome(String[] words) {
        for (String str: words) {
            if (str.equals(new StringBuilder(str).reverse().toString())) {
                return str;
            }
        }
        return "";
    }

    //1720 Разобрать решение (Непонятно)!!!
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i+1] = encoded[i] ^ arr[i];
        }
        return arr;
    }

    //2574
    public int[] leftRightDifference(int[] nums) {
        if (nums.length == 1) {
            nums[0] = 0;
            return nums;
        }
        int[] start = new int[nums.length];
        int[] finish = new int[nums.length];
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        start[0] = nums[0];
        finish[0] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            start[i] = start[i-1] + nums[i];
            finish[i] = finish[i-1] + nums[nums.length-i-1];
        }
        for (int i = 0; i < nums.length-1; i++) {
            leftSum[i+1] = start[i];
            rightSum[i] = finish[finish.length-i-2];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return nums;
    }

    // 1688
    public int numberOfMatches(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                count += n / 2;
                n = n / 2;
            } else {
                count += (n - 1) / 2;
                n = ((n - 1) / 2) + 1;
            }
        }
        return count;
    }

    // 1221
    public int balancedStringSplit(String s) {
        int count = 0;
        AtomicInteger result = new AtomicInteger();
        String[] list = s.split("");
        for (String l: list) {
            if (l.equals("L")) {
                count++;
            } else if (l.equals("R")) {
                count--;
            }
            if (count == 0) {
                result.getAndIncrement();
            }
        }
        return result.get();
    }

    // 268
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] != 0) return 0;
        if (nums[n-1] != n) return n;
        for (int i = 1; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return 0;
    }

    // 2974
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] list = new int[nums.length];
        int x;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                x = nums[i];
                list[i+1] = x;
            } else {
                x = nums[i];
                list[i-1] = x;
            }
        }
        return list;
    }

    // 1389
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] arr = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    // 1313
    public int[] decompressRLElist(int[] nums) {
        if (nums.length % 2 == 0) {
            int l  = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (2*i < nums.length) {
                    int count = 0;
                    int temp = nums[2*i];
                    while (count < temp) {
                        list.add(l++, nums[2*i+1]);
                        count++;
                    }
                }
            }
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }
        return null;
    }

    // 1486
    public int xorOperation(int n, int start) {
        int count = start;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = count;
            count += 2;
        }
        count = start;
        for (int i = 1; i < arr.length; i++) {
            count ^= arr[i];
        }
        return count;
    }

    // 1662
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1.length == 1 && word2.length == 1) {
            return word1[0].equals(word2[0]);
        }
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        if (word1.length > 1 && word2.length == 1) {
            for (String l: word1) {
                builder.append(l);
            }
            return  builder.toString().equals(word2[0]);
        } else if (word2.length > 1 && word1.length == 1) {
            for (String l: word2) {
                builder2.append(l);
            }
            return  builder2.toString().equals(word1[0]);
        } else {
            for (String l: word1) {
                builder.append(l);
            }
            for (String l: word2) {
                builder2.append(l);
            }
            return builder.toString().equals(builder2.toString());
        }
    }

    private int findObject(List<List<String>> items, int index, String ruleValue) {
        int count = 0;
        for (List<String> list: items) {
            if (list.get(index).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }

    //1773
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        switch (ruleKey) {
            case "type":
                return findObject(items, 0, ruleValue);
            case "color":
                return findObject(items, 1, ruleValue);
            case "name":
                return findObject(items, 2, ruleValue);
        }
        return 0;
    }

    // 1528
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return String.valueOf(arr);
    }

    // 1816
    public String truncateSentence(String s, int k) {
        String[] list = s.split(" ");
        if (list.length == k) {
            return s;
        } else if (list.length > k) {
            StringBuilder build = new StringBuilder();
            for (int i = 0; i < list.length; i++) {
                if (i < k-1) {
                    build.append(list[i]).append(" ");
                }
                if (i == k-1) {
                    build.append(list[i]);
                }
            }
            return build.toString();
        }
        return null;
    }

    // 3065
    public int minOperations(int[] nums, int k) {
        int count = 0;
        if (k == 1) {
            return 0;
        } else {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        EasyTasks easyTasks = new EasyTasks();
        int[] numberList = {-3,0,1,-3,1,1,1,-3,10,0};
        int[] numberList2 = {73,74,75,71,69,72,76,73};
        String[] lines = {"abc","car","ada","racecar","cool"};
        int[] shuffle = {4,5,6,7,2,1,3};
        int[][] points = {{2,8,7},{7,1,3},{1,9,5}};
        List<Integer> list = List.of(5,10,1,5,2);

        //System.out.println(easyTasks.isPalindrome(-121));
        //System.out.println(easyTasks.uniqueOccurrences(numberList));
        //System.out.println(easyTasks.romanToInt("MCMXCIV"));
        //System.out.println(easyTasks.numJewelsInStones("z", "ZZ"));
        //System.out.println(Arrays.toString(easyTasks.shuffle(shuffle, 3)));
        //System.out.println(easyTasks.kidsWithCandies(shuffle, 4));
        //System.out.println(easyTasks.minOperations(shuffle, 7));
        FirstClass secondClass = new SecondClass();
        System.out.println(secondClass.word);
    }
}
