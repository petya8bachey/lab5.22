
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.floor;

public class MyList {
    public int M = 1000;
    public float C = 0.00000000097F;
    public int collision = 0;
    public ArrayList<Basket> list = new ArrayList<>(M);
    public MyList(int M) {
        this.M = M;
        list = new ArrayList<>(M);
        clear();
    }
    public MyList() {
        clear();
    }
    public void clear() {
        for (int i = 0; i < M; i++) {
            list.add(null);
        }
    }

    public void add(long value) {
        int key = hash(value);
        Basket element = list.get(key);
        if (element == null) {
            list.set(key, new Basket(value));
        } else {
            while (element.next != null) {
                element = element.next;
            }
            collision++;
            element.next = new Basket(value);
        }
    }
    public String toString() {
        return Arrays.deepToString(new ArrayList[]{list});
    }
    public void delete(long value) {
        Basket basket = list.get(hash(value));
        if(basket != null) {
            basket.delete(value);
        }
    }
    public Basket search(long value) {
        return list.get(hash(value)).search(value);
    }

    public int hash(long phone) {
        return (int) floor((float) M * ((C * phone) % 1));
    }
    public static class Basket {
        public long value;
        public Basket next = null;
        Basket(long value) {
            this.value = value;
        }
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Basket iterator = this;
            while (iterator != null) {
                builder.append(iterator.value);
                iterator = iterator.next;
                if (iterator != null) {
                    builder.append(", ");
                }
            }
            builder.append("]\n");
            return builder.toString();
        }
        public Basket search(long value) {
            Basket iterator = this;
            while (iterator != null) {
                if (iterator.value == value) {
                    return iterator;
                }
                iterator = iterator.next;
            }
            return null;
        }
        public void delete(long value) {
            Basket iterator = this;
            while (iterator != null && iterator.next != null) {
                if (iterator.next.value == value) {
                    iterator.next = iterator.next.next;
                }
                iterator = iterator.next;
            }
        }
    }

}
