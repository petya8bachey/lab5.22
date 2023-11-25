import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Номер телефона
        // функция умножения
        // Метод цепочек
        // Реализовать алгоритмы поиска, вставки, удаления элементов таблицы и распечатки таблицы и метод ре-хэширования таблицы при увеличении размера данных
        MyList list = new MyList();
        File file = new File("src/text.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLong()) {
            list.add(scanner.nextLong());
        }

        System.out.println(list);
        System.out.println(list.search(2));
        list.rehash(10);
        System.out.println(list);
    }
    public static long randomPhone() {
        Random random = new Random();
        return Math.abs((random.nextLong(90_000_000_000L) + 10_000_000_000L) % 100_000_000_000L);
    }
}