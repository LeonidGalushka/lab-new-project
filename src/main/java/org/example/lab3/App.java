package org.example.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //String[] strings = new String[1000];

        ArrayList<String> strings = new ArrayList<>();

        while (true) {
            String text = scanner.nextLine();

            if (text.equals("ext")) {
                break;
            }

            strings.add(text);
        }

        for (int i = strings.size() - 1; i >= 0; i--) {

            String reversStr = new StringBuilder(strings.get(i)).reverse().toString();
            System.out.println(reversStr);
        }

        // System.out.println(strings);


//        boolean exit = false;
//
//        while (!exit) {
//            String text = scanner.nextLine();
//            if (text.equals("ext")) {
//                exit = true;
//            }
//        }


    }
}
