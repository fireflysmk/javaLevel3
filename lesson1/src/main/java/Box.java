import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {

    /*
   Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
Не забываем про метод добавления фрукта в коробку.
     */
    private ArrayList<T> fruitList;
    private T fruit;

    public Box() {
        this.fruitList = new ArrayList<T>();
    }

    public Box(T fruit) {
        this();
        this.fruitList.add(fruit);

    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public double getWeight () {

        double boxWeight = 0;

        for (T item : fruitList){
            boxWeight+= item.getWeight();
        }
        System.out.println("Вес коробки: " + boxWeight);

        return boxWeight;
    }

    public void addFruit (T fruit){
        this.fruitList.add(fruit);
    }

    /*
    Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
    которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
    Можно сравнивать коробки с яблоками и апельсинами;
     */

    public boolean compareBoxes(T anotherBox) {

        double currentBoxWeight = getWeight();
        double anotherBoxWeight = anotherBox.getWeight();

        return Math.abs(currentBoxWeight - anotherBoxWeight) < 0.0001;

    }
    /*
    Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     */




    public void moveFruitsToAnotherBox(Box<? extends Fruit> destBox) {

        for (T item : this.fruitList) {
            destBox.addFruit(item);  // - почему это не работет?  Required type: capture of ? extends Fruit      Provided:  T
                                     // ведь тип T является фруктом или его наследником: public class Box <T extends Fruit>
        }
        this.fruitList.clear();

    }


}
