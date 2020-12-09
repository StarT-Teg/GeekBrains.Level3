package lesson_1;

import lesson_1.fruits.Apple;
import lesson_1.fruits.Orange;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList <String> list = new ArrayList<>();
        list.add("wewet");
        list.add("reyhrey");
        list.add("reheryhery");

        System.out.println(list);

        firstToLast(list);

        System.out.println(list);

        String[] array = {"wewet", "reyhrey", "reheryhery"};

        ArrayList<String> newArrayList = arrayToArrayList (array);

        System.out.println(newArrayList);

        Box <Apple> boxWithApples = new Box();
        Box <Orange> boxWithOranges = new Box();

      fillTheBox(boxWithApples, "Apple");
      fillTheBox(boxWithOranges, "Orange");


        System.out.println("Вес коробки с яблоками = " + boxWithApples.getWeight());
        System.out.println("Вес коробки с апельсинами = " + boxWithOranges.getWeight());

        System.out.println("Пробуем добавить яблоки в коробку с яблоками");

        boxWithApples.addFruitToBox(new Apple(1.1f));

        System.out.println("Новый вес коробки с яблоками = " + boxWithApples.getWeight());

        System.out.println("Пробуем добавить апельсины в коробку с яблоками");
        // Не даёт добавить апельсин
        // boxWithApples.addFruitToBox(new Orange(1.1f));

        System.out.println("Сравниваем вес двух ящиков. Ящик апельсинов тяжелей ящика с яблоками? " + boxWithApples.compare(boxWithOranges));

        Box <Apple> anotherBoxWithApples = new Box();
        fillTheBox(anotherBoxWithApples, "Apple");
        System.out.println("Вес новой коробки с яблоками = " + anotherBoxWithApples.getWeight());
        System.out.println("Пересыпаем яблоки");

        boxWithApples.putIn(anotherBoxWithApples);

        System.out.println("Вес новой коробки с яблоками = " + anotherBoxWithApples.getWeight());
        System.out.println("Вес старой коробки с яблоками = " + boxWithApples.getWeight());

    }

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static <T extends List> void firstToLast (T list ){

        Object obj1 = list.get(0);
        list.remove(0);
        list.add(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        list.add(obj1);

    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> arrayToArrayList (T[] array){

        ArrayList<T> arrayList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        return arrayList;
    }

    // Не решил проблему с ошибкой
    // Type parameter 'T' cannot be instantiated directly
    // СДелал через стрингу
    // public static <T extends Fruit>  void fillTheBox (Box box, T fruit ){
        public static void fillTheBox (Box box, String fruit ){

        if (fruit.equals("Orange")){
            ArrayList <Orange> fruits = new ArrayList<>();

            for (int i = 0; i < (int) (Math.random() * (10 - 1) + 1); i++) {
                fruits.add(new Orange ((float)(Math.random() * (10 - 1) + 1)));
            }

           box.addFruitToBox(fruits);

        }
        else if (fruit.equals("Apple")){
            ArrayList <Apple> fruits = new ArrayList<>();

            for (int i = 0; i < (int) (Math.random() * (10 - 1) + 1); i++) {

                fruits.add(new Apple ((float)(Math.random() * (10 - 1) + 1)));
            }

            box.addFruitToBox(fruits);;
        }

    }

}
