package ru.avalon.java.dev.ocpjp.labs;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

public class Main {

    public static void main(String[] args) throws IOException {
        final Collection<Commodity> commodities = Commodity.random(10);

        /*
         * TODO(Студент): С использованием Java Stream API выполнить задачи из списка:
         * 1. Выполнить поиск самого дорого товара
         * 2. Найти товары с минимальным остатком
         * 3. Найти товары с остатком меньшим 5 и вывести в консоль их названия
         * 4. Подсчитать общую стоимость товаров с учётом их остатка
         * 5. Найти товар, с самым длинным названием и вывести его на экран
         * 6. Выполнить сортировку коллекции commodities
         * 7. Найти среднюю стоимость товаров
         * 8. Найти моду (медиану) стоимости товаров
         */
        /**
         * 1/8. Поиск самого дорогого товара
         */
        double maxPrice = commodities.stream()
                                     .mapToDouble(Commodity::getPrice)
                                     .max()
                                     .getAsDouble();
        
        List<Commodity> maxPriceCommodities = commodities.stream()
                                                         .filter(x -> (x.getPrice() == maxPrice))
                                                         .collect(Collectors.toList());
        
        /**
         * 2/8. Поиск товаров с минимальным значением остатка
         */
        int minStock = commodities.stream()
                                  .mapToInt(Commodity::getResidue)
                                  .min()
                                  .getAsInt();
        
        List<Commodity> minStockCommodities = commodities.stream()
                                                         .filter(x -> (x.getResidue() == minStock))
                                                         .collect(Collectors.toList());
        
        /**
         * 3/8. Поиск товаров с остатком менее 5 
         */
        List<Commodity> lessThanFive = commodities.stream()
                                              .filter(x -> (x.getResidue() < 5))
                                              .collect(Collectors.toList());
        
        System.out.println("Товары с остатком менее 5");
        lessThanFive.forEach(System.out::println);
        
        /**
         * 4/8. Подсчет общей стоимости товаров с учетом остатков
         */
        double balance = commodities.stream()
                                    .mapToDouble(x -> (x.getPrice() * x.getResidue()))
                                    .sum();
        
        /**
         * 5/8. Поиск товара с самым длинным названием
         */
        String longestName = commodities.stream()
                                        .map(Commodity::getName)
                                        .max(Comparator.comparingInt(String::length))
                                        .get();
        
        /**
         * 6/8. Сортировка коллекции
         */
        List<String> sorted = commodities.stream()
                                         .map(Commodity::getName)
                                         .sorted()
                                         .collect(Collectors.toList());
        
        /**
         * 7/8. Поиск средней стоимости товаров
         */
        double average = commodities.stream()
                                    .mapToDouble(Commodity::getPrice)
                                    .average()
                                    .getAsDouble();
        
        /**
         * 8/8. Поиск медианной стоимости товаров
         */
        double[] sortedArray = commodities.stream()
                                          .mapToDouble(Commodity::getPrice)
                                          .sorted()
                                          .toArray();
        
        double median = findMedian(sortedArray);
    }
    
        static double findMedian(double[] arr) {
            return arr.length % 2 == 0? ((arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2) : arr.length/2;
        }
    
}
