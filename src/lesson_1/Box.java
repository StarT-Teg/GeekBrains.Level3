package lesson_1;

/*
Класс Box в который можно складывать фрукты
коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можете использовать ArrayList;


*/

import lesson_1.fruits.Fruit;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> fruits;
    private float weight = 0.0f;

    public Box (){
        fruits = new ArrayList<>();
    }

    public Box (ArrayList<T> list){
        fruits = new ArrayList<T>();
        addFruitToBox(list);
    }


    public void addFruitToBox (ArrayList<T> list){

        for (T t : list) {
            fruits.add(t);
            weight += t.getWeight();
        }
    }

    public void addFruitToBox (T fruit){

            fruits.add(fruit);
            weight += fruit.getWeight();

    }

    // Сделать метод getWeight() который высчитывает вес коробки,
    // зная количество фруктов и вес одного фрукта
    // (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    public float getWeight() {
        return weight;
    }

    // Внутри класса коробка сделать метод compare,
    // метод позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра,
    // true - если их веса равны,
    // false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    public boolean compare (Box<?> anotherBox){

        return (this.getWeight() - anotherBox.getWeight()) < 0.001;

    }

    // Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
    // (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами)
    // В текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;

    public void putIn (Box<T> anotherBox){

        if (anotherBox != this){
            anotherBox.addFruitToBox(this.fruits);
            this.fruits.clear();
            this.weight = 0.0f;
        }
        else {
            System.out.println("В контейнерах разные фрукты! Не могу пересыпать");
        }

    }


}
