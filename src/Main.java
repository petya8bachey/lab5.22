import java.util.Random;
public class Main {
    public static void main(String[] args) {
        // Номер телефона
        // функция умножения
        // Метод цепочек
        // Реализовать алгоритмы поиска, вставки, удаления элементов таблицы и распечатки таблицы и метод ре-хэширования таблицы при увеличении размера данных
        int size = 1000;
        MyList list = new MyList();
        long phone = 0;
        for (int i = 0; i < size; i++) {
            phone = randomPhone();
            list.add(phone);
        }
        System.out.println(list);
        System.out.println(list.collision);
        System.out.println(list.search(phone));
        list.delete(phone);
        System.out.println(list.search(phone));
    }
    public static long randomPhone() {
        Random random = new Random();
        return Math.abs((random.nextLong(90_000_000_000L) + 10_000_000_000L) % 100_000_000_000L);
    }
}