package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        1 Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> sol1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("Solution1: " + sol1);

//        2 What are all the unique cities where the traders work?

        List<String> sol2 = transactions.stream()
                .map(t -> t.getTrader().getCity()).distinct().toList();
        System.out.println("Solution2: " + sol2);

//        3 Find all traders from Cambridge and sort them by name.

        List<Trader> sol3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println(sol3);

//        4 Return a string of all traders’ names sorted alphabetically.

        List<Trader> sol4 = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(sol4);
//        5 Are any traders based in Milan?

        boolean sol5 = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> t.getCity().equals("Milan"));
        System.out.println(sol5);
//        6 Print the values of all transactions from the traders living in Cambridge.

        List<Integer> sol6 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println(sol6);
//        7 What’s the highest value of all the transactions?

        Optional<Transaction> sol7 = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue));
        System.out.println(sol7.orElse(null));
//        8 Find the transaction with the smallest value.
        Optional<Transaction> sol8 = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
        System.out.println(sol8.orElse(null));

    }
}

class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}