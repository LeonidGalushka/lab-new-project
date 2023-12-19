package org.example.lab4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите имя входного файла : ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        Path path = Path.of(fileName);
        List<String> resultFile = Files.readAllLines(path);

        ArrayList<String> resultWorldInFile = new ArrayList<>();

        for (int i = 0; i < resultFile.size(); i++) {
            List<String> list = Arrays.asList(resultFile.get(i).split(" "));
            resultWorldInFile.addAll(list);
        }

        // "to" -> 4
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < resultWorldInFile.size(); i++) {

            String currentElement = resultWorldInFile.get(i);

            if (currentElement.equals(" ") || currentElement.equals("")) {
                continue;
            }

            Integer resultElInMap = resultMap.get(currentElement);

            if (resultElInMap != null) {
                resultMap.put(currentElement, resultElInMap.intValue() + 1); // to -> 2
            } else {
                resultMap.put(currentElement, 1); // to -> 1
            }
        }

        System.out.println(resultMap);

        String outputResult = null;

        for (Map.Entry<String, Integer> elementMap : resultMap.entrySet()) {
            outputResult += elementMap.getKey() + " = " + elementMap.getValue() + "; \n";
        }

        System.out.println("Введите имя выходного файла : ");
        Scanner scanner1 = new Scanner(System.in);
        String outputFile = scanner1.nextLine();

        Files.write(Path.of(outputFile), outputResult.getBytes());
    }
}
