package Calculator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Checking.get();
        } catch (IOException e) {

            System.out.println("Введены неверные числа или символы");
            System.exit(1);


        }
    }
}