package ds;

public class Hashtable {

    private class HashEntry {
        private String key;
        private String value;
        private HashEntry next;
    }

    private final HashEntry[] entries;
    private int capacity;
    private int size = 0;
    private float loadFactor = 0.75f;

    public Hashtable(int capacity) {
        entries = new HashEntry[capacity];
        this.capacity = capacity;
    }

    public void resizeAndHash() {
        for (HashEntry e : entries) {
            if (e != null) size++;
        }
        if (size > capacity * loadFactor) {
            HashEntry[] newEntries = new HashEntry[capacity * 2];
            System.arraycopy(entries, 0, newEntries, 0, capacity);
            capacity = capacity * 2;
        }

    }

    public void put(String key, String value) {
        int hash = key.hashCode() % capacity;

        HashEntry entry = new HashEntry();
        entry.key = key;
        entry.value = value;
        if (entries[hash] == null) {
            entries[hash] = entry;
        } else {
            HashEntry curr = entries[hash];
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = entry;
        }
    }

    public String get(String key) {
        int hash = key.hashCode() % capacity;

        HashEntry curr = entries[hash];
        while (curr != null) {
            if (curr.key.equals(key))
                return curr.value;
            curr = curr.next;
        }
        return "Not Fo";
    }

    public static void main(String[] args) {
        Hashtable table = new Hashtable(10);

        table.put("asdas", "asd");
        table.put("fdgd", "ghf");
        table.put("dfg", "kjl");
        table.put("ee", "tyu");

        System.out.println(table.get("df1"));
    }
}
