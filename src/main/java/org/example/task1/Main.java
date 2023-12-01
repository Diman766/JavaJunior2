package org.example.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = {new Cat("Barsic", 6, "Black"),
                new Dog("Barboss", 7, "StaffordshireTerrier")};


        for (Animal animal : animals) {
            analyzeClass(animal);
            System.out.println();
        }

        for (Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            try {
                Method displayInfoMethod = clazz.getDeclaredMethod("makeSound");
                displayInfoMethod.invoke(animal);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                System.out.print("У класса " + clazz + " нет такого метода\n");
            }
        }
    }


    public static void analyzeClass(Object o) {
        Class<?> clazz = o.getClass();
        System.out.println("Имя класса: " + clazz.getSimpleName());

        System.out.println("Поля класса: ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t" + field.getName());
        }
        System.out.println("Родительский класс: " + clazz.getSuperclass().getSimpleName());

        System.out.println("Методы класса: ");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("\t" + method.getName());
        }

        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));
    }
}