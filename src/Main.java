import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.floor;

public class Main {

    public static void main(String[] args) {
        // Номер телефона
        // функция умножения
        // Метод цепочек
        // Реализовать алгоритмы поиска, вставки, удаления элементов таблицы и распечатки таблицы и метод ре-хэширования таблицы при увеличении размера данных
        /*
        Для мультипликативного хеширования используется следующая хеш - функция
        h(K)= {m* ((C • K) mod 1) }
        Здесь умножается неотрицательный целый ключ на некую константу C, лежащую в интервале [0..1].
        После этого берется дробная часть этого выражения и умножается на некоторую константу m (размер хеш-таблицы),
        выбранную таким образом, чтобы результат не вышел за границы хеш-таблицы. Оператор {} возвращает наибольшее целое, которое меньше аргумента. floor()
         */

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