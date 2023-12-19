package org.example.lab2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String[] texts = text.split(" ");

        System.out.println("Ваш введенный текст: " + text);

        int sum = 0;

        for (int i = 0; i < texts.length; i++) {
            sum += Integer.valueOf(texts[i]);
        }

        System.out.println(sum);
    }
}
