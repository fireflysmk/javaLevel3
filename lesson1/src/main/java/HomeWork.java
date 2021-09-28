import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {

        HomeWork homeWork = new HomeWork();

        String [] strArr = {"vasya", "petya", "qqq", "ddd"};
        Integer [] intArr = {1,2,4,5,6,7,9};

        homeWork.swapArrayPositions(strArr, 1,3);
        homeWork.swapArrayPositions(intArr, 1,3);

        ArrayList<String> lstStr = homeWork.castArrToList(strArr);
        ArrayList<Integer> lstInt = homeWork.castArrToList(intArr);

        System.out.println(lstStr.getClass().getName());
        System.out.println(lstInt.getClass().getName());

        // тест фруктов
        Apple a1 = new Apple();
        Apple a2 = new Apple();

        Orange o1 = new Orange();
        Orange o2 = new Orange();

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(a1);
        appleBox.addFruit(a2);
        //appleBox.addFruit(o1); - ошибка, что и требовалось

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(o1);
        orangeBox.addFruit(o2);

        appleBox.getWeight(); // Вес коробки: 2.0
        orangeBox.getWeight(); // Вес коробки: 3.0

    }
     /*
     1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
     */

    public <T> T[] swapArrayPositions (T[] arrs, int pos1, int pos2) {

        T tempValue = arrs[pos1];

        arrs[pos1] = arrs[pos2];
        arrs[pos2] = tempValue;

        System.out.println(Arrays.toString(arrs));

        return arrs;
    }
    
    /*
    2. Написать метод, который преобразует массив в ArrayList;
     */
    public <T> ArrayList<T> castArrToList (T[] arrs) {
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arrs));
        return arrayList;
    }
    
}
