import java.util.AbstractList;

public class ArrayList extends AbstractList<String> {
    String[] arr;
    int size = 0, capacity = 10;

    public ArrayList() {
        this.arr = new String[capacity];
    }

    @Override
    public String get(int index) {
        return arr[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(String ele) {
        if (size < capacity) {
            arr[size++] = ele;
            return true;
        }
        String[] newArr = new String[size * (1 / 2)];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
        newArr[size++] = ele;
        return true;
    }
}

class TestAL {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("thress");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}