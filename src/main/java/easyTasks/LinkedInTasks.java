package easyTasks;

public class LinkedInTasks {

    public String transformString(String text) {
        for (int i = 0; i < text.length(); i++) {

        }
        return null;
    }

    public static void changeString() {
        String myText = "AAABBXXXXXLLTTTFDR";
        StringBuilder newString = new StringBuilder();
        int count = 0;
        for (int i = 0; i < myText.length()-1; i++) {
            if (myText.charAt(i) == myText.charAt(i+1)) {
                count++;
            } else {
                if (count == 0) {
                    newString.append(myText.charAt(i));
                } else {
                    newString.append(myText.charAt(i)).append(count+1);
                }
                count = 0;
            }
        }

        System.out.println(newString); // A3B2X5L2T3FDR
    }

    public static void main(String[] args) {
        // Преобразовать строку с повторяющимеся буквами в строку со "свернутыми" буквами
        changeString();
	    System.out.println("My first steps in Vim :)))))");
    }
}
