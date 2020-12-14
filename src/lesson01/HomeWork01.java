package lesson01;

public class HomeWork01 {
    public static void main(String[] args){
        int a = -10;
        int b = 20;
        int c = 25;
        int d = 3;
        String name = "Адель";
        int year = 400;
        System.out.println("Ответ на первую задачу: " + firstPart(a, b, c, d));
        System.out.println("Ответ на вторую задачу: " + secondPart(a, b));
        System.out.println("Ответ на треью задачу: " + thirdPart(a));
        System.out.println("Ответ на четвертую задачу: " + fourthPart(name));
        System.out.println(fifthPart(year));
    }

    public static double firstPart(double a, double b,
                                   double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean secondPart(int a, int b){

        return (10 <= (a + b) && (a + b) <= 20);
    }

    public static String thirdPart(int a){
        return (a >= 0) ? "Число а положительное" : "Число а отрицательное";
        //        String answer3;
//        if (a >= 0){
//            answer3 = "Число а положительное";
//        } else answer3 = "Число а отрицательное";
//        return answer3;
    }


    public static String fourthPart (String name){
        return "Привет, " + name + "!";
    }

    public static String fifthPart(int year){
        String answer5;
        if (year % 4 == 0 && year % 100 !=0) answer5 = "Год " + year + " високосный";
        else if(year % 400 == 0) answer5 = "Год " + year + " високосный";
        else answer5 = "Год " + year + " обычный";
        return answer5;
    }
}
//public static void fifthPart(){
//        int year = 1;
//        String leapYear = "";
//        if (year % 4 == 0){
//            leapYear += Integer.toString(year)+", ";
//            year++;
//        } else year++;

//        leapYear = Integer.toString (year);
//        System.out.println(leapYear);
//        leapYear += leapYear;
//        System.out.println(leapYear);