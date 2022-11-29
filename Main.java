import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        char action;
        String[] data;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        }else{
            throw new Exception("Некорректно введено выражение");
        }
        String first1 = data[0];
        String second = data[1];
        if (first1.length() > 12) {
            throw new Exception("Некорректно введено выражение");
        }
        String first2 = first1.replaceFirst("\"", "");

        if (!first2.contains("\"")   )  throw new Exception("Некорректно введено выражение");
        String first3 = first2.replaceFirst("\"", "");
        if (action == '*' || action == '/') {
            if (second.contains("\"")) throw new Exception("Некорректно введено выражение");

            if (action == '*' || action == '/') {
                if ((Integer.parseInt(second) < 1) || ((Integer.parseInt(second)) > 10))
                {
                    throw new Exception("Некорректно введено выражение");
            } }
            }

        if (action == '+' || action == '-') {
             second = second.replaceFirst("\"", "");

        }
        if (action == '+' || action == '-') {
             second = second.replaceFirst("\"", "");
        }
        if (action == '+') {
            printInQuotes(first3 + second);
        } else if (action == '*') {
            int number = Integer.parseInt(second);
            String result = "";
            for (int i = 0; i < number; i++) {
                result+=first3;
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = first3.indexOf(second);
            if(index == -1){
                printInQuotes(first3);
            }else{
                String result = first3.substring(0, index);
                result+=first3.substring(index+second.length());
                printInQuotes(result);
            }
        }else{
            int newLen = first3.length()/Integer.parseInt(second);
            String result = first3.substring(0,newLen);
            printInQuotes(result);
        }


    }

    static void printInQuotes(String text) {

        if (text.length() > 40) {
            String text1 = text.substring(0, 40);
            System.out.print(text1);
            System.out.print("...");
        } else {
            System.out.println(text);
        }
    }
}
