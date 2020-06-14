package Calculator;

import java.io.IOException;
import java.util.Scanner;

public class Checking {


    public static int get() throws IOException {
        Scanner Calc = new Scanner(System.in);
        int result = 0;


        while (true) {

            System.out.println("Введите два числа (только арабские или только римские) с операцией (+,-,*,/):");

            String input = Calc.nextLine();

            String s = input.replaceAll("\\s+", "").toUpperCase();

            if (s.matches("(-|\\+)?(1|2|3|4|5|6|7|8|9|10)(\\*|/|-|\\+)?(1|2|3|4|5|6|7|8|9|10)")) {

                String[] arr = s.split("\\+|-|\\*|/");


                switch (arr.length) {
                    case (2):
                        int n1 = Integer.parseInt(arr[0]);
                        int n2 = Integer.parseInt(arr[1]);


                        for (int i = 1; i < s.length(); i++) {


                            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                                String op = Character.toString(s.charAt(i));


                                result = Calculation.calc(n1, n2, op);


                                System.out.println("Ответ: " + result);


                            }
                        }
                        break;

                    case (3):

                        int m1, m2;

                        if (s.charAt(0) == '-') {
                            m1 = -Integer.parseInt(arr[1]);
                            m2 = Integer.parseInt(arr[2]);
                        } else {

                            m1 = Integer.parseInt(arr[1]);
                            m2 = Integer.parseInt(arr[2]);
                        }


                        for (int i = 1; i < s.length(); i++) {


                            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                                String op = Character.toString(s.charAt(i));

                                result = Calculation.calc(m1, m2, op);

                                System.out.println("Ответ: " + result);

                            }

                        }

                        break;

                }


            } else if (s.matches("(-|\\+)?(I|II|III|IV|V|VI|VII|VII|IX|X)(\\*|/|-|\\+)?(I|II|III|IV|V|VI|VII|VII|IX|X)")) {

                String[] arr = s.split("\\+|-|\\*|/");

                switch (arr.length) {
                    case (2):

                        int r1 = Roman.valueOf(arr[0]).getValue();
                        int r2 = Roman.valueOf(arr[1]).getValue();


                        for (int i = 0; i < s.length(); i++) {


                            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                                String op = Character.toString(s.charAt(i));

                                result = Calculation.calc(r1, r2, op);

                            }
                        }
                        break;

                    case (3):

                        int t1, t2;

                        if (s.charAt(0) == '-') {
                            t1 = -Roman.valueOf(arr[1]).getValue();
                            t2 = Roman.valueOf(arr[2]).getValue();
                        } else {

                            t1 = Roman.valueOf(arr[1]).getValue();
                            t2 = Roman.valueOf(arr[2]).getValue();
                        }


                        for (int i = 1; i < s.length(); i++) {


                            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                                String op = Character.toString(s.charAt(i));

                                result = Calculation.calc(t1, t2, op);


                            }

                        }

                }

                if(result!=0) {
                    String str = Roman.expandedNumber(result);

                    String[] arr2 = str.split("\\+");

                    switch (arr2.length) {
                        case (1):
                            int a1 = Integer.parseInt(arr2[0]);

                            if (a1 < 0)
                                System.out.println("Ответ: " + "-" + Roman.getRoman(Math.abs(a1)));


                            else System.out.println("Ответ: " + Roman.getRoman(a1));

                            break;

                        case (2):

                            int a2 = Integer.parseInt(arr2[0]);
                            int b2 = Integer.parseInt(arr2[1]);

                            System.out.println("Ответ: " + Roman.getRoman(a2) + Roman.getRoman(b2));
                            break;
                    }
                } else System.out.println("Ответ: " +0);


            } else throw new IOException();
        }

    }
}

