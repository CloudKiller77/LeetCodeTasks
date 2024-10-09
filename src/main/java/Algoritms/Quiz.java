package Algoritms;

public class Quiz {
    private final String privet;

    public Quiz(String privet) {
        this.privet = privet;
    }

    public String getPrivet() {
        return privet;
    }

    public static void main(String[] args) {
        byte b1 = 5, b2 = 2;
        //byte b = b1 % b2;
        System.out.println();
        //-----------------------------------------
        int i = 5, j = 2;
        System.out.println( i % j );
        //-----------------------------------------
        float f = (float) 10.2;
        double d = 10.2;

        if(f == d)
            System.out.println("Same");
        else
            System.out.println("Not same");
        //-------------------------------------------

        boolean a1 = true;
        boolean a2 = true;

        if(a1 == a2){
            System.out.print("==");
        }

//        if(a1.equals(a2)){
//            System.out.print("equals");
//        }
        //------------------------------------------
    }
}
