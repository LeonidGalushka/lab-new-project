package org.example.lab6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Wspp {

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

        for (int i = 0; i < resultWorldInFile.size(); i++) {
            String el = resultWorldInFile.get(i).toLowerCase();
            resultWorldInFile.add(i, el);
            resultWorldInFile.remove(i + 1);
        }

        // "to" -> {4, {1,5,7}}
        Map<String, InputElement> resultMap = new HashMap<>();

        for (int i = 0; i < resultWorldInFile.size(); i++) {

            String currentElement = resultWorldInFile.get(i);

            if (currentElement.equals(" ") || currentElement.equals("")) {
                continue;
            }

            InputElement resultElInMap = resultMap.get(currentElement);

            if (resultElInMap == null) {

                resultElInMap = new InputElement();
                resultElInMap.setCount(1);
                resultElInMap.addNewElByList(i + 1);
                resultElInMap.setSort(i);

                resultMap.put(currentElement, resultElInMap); // to -> {1, {i+1}}
            } else {
                Integer newCount = resultElInMap.getCount() + 1;
                resultElInMap.setCount(newCount);
                resultElInMap.addNewElByList(i + 1);

                resultMap.put(currentElement, resultElInMap); // to -> {2, {2, i+1}
            }
        }

        String outputResult = "";

        Comparator<? super Map.Entry<String, InputElement>> comparator = new Comparator<Map.Entry<String, InputElement>>() {
            @Override
            public int compare(Map.Entry<String, InputElement> o1, Map.Entry<String, InputElement> o2) {
                if (o1.getValue().getSort() < o2.getValue().getSort() ) {
                    return -1;
                }

                if (o1.getValue().getSort() > o2.getValue().getSort()) {
                    return 1;
                }
                return 0;
            }
        };

        var resultSet = resultMap.entrySet().stream().sorted(comparator).collect(Collectors.toCollection(LinkedHashSet::new));

        for (Map.Entry<String, InputElement> elementMap : resultSet) {
            InputElement resultElInMap = elementMap.getValue();

            Integer count = resultElInMap.getCount();

            List<Integer> inputs = resultElInMap.getInputs();

            outputResult += elementMap.getKey() + " = " + count + " " + inputs + " \n";
        }

        System.out.println("Введите имя выходного файла : ");
        Scanner scanner1 = new Scanner(System.in);
        String outputFile = scanner1.nextLine();

        Files.write(Path.of(outputFile), outputResult.getBytes());

//        InputElement inputElement = new InputElement();
//        inputElement.setCount(123);
//        System.out.println(inputElement.getCount());

    }

}
