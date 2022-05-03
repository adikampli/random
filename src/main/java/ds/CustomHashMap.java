package ds;

public class CustomHashMap<K, V> {

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;
    }

    private final Entry<K, V>[] entries;
    private int capacity;
    private int size = 0;
    private final float loadFactor = 0.75f;

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        entries = (Entry<K, V>[]) new Entry<?, ?>[capacity];
        this.capacity = capacity;
    }

    public void resizeAndHash() {
        for (Entry<K, V> e : entries) {
            if (e != null) size++;
        }
        if (size > capacity * loadFactor) {
            @SuppressWarnings("unchecked")
            Entry<K, V>[] newEntries = (Entry<K, V>[]) new Entry<?, ?>[capacity * 2];
            System.arraycopy(entries, 0, newEntries, 0, capacity);

            capacity = capacity * 2;
        }
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % capacity;

        Entry<K, V> entry = new Entry<>();
        entry.key = key;
        entry.value = value;
        if (entries[hash] == null) {
            entries[hash] = entry;
        } else {
            Entry<K, V> curr = entries[hash];
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = entry;
        }
    }

    public V get(K key) {
        int hash = key.hashCode() % capacity;

        Entry<K, V> curr = entries[hash];
        while (curr != null) {
            if (curr.key.equals(key))
                return curr.value;
            curr = curr.next;
        }
        return (V) "Not Fo";
    }

    public static void main(String[] args) {
        CustomHashMap<String, String> table = new CustomHashMap<>(10);

        table.put("asdas", "asd");
        table.put("fdgd", "ghf");
        table.put("dfg", "kjl");
        table.put("ee", "tyu");

        System.out.println(table.get("dfg"));
    }
}
