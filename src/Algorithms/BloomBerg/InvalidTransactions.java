package Algorithms.BloomBerg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Transaction {
    String name;
    int time;
    int amount;
    String city;
    int id;

    public Transaction(String name, int time, int amount, String city, int id) {
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.city = city;
        this.id = id;
    }
}

public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        ArrayList<String> transactionsResult = new ArrayList<>();
        HashMap<String, ArrayList<Transaction>> map = new HashMap<>();
        HashSet<Integer> ids = new HashSet<>();
        ArrayList<Transaction> masterList = new ArrayList<>();
        HashMap<Integer, Transaction> mastermap = new HashMap<>();
        int tId = 0;
        for(String transaction: transactions) {
            String[] t = transaction.split(",");

            Transaction tObj = new Transaction(t[0],Integer.parseInt(t[1]),Integer.parseInt(t[2]),t[3], tId++);
            ArrayList<Transaction> list = map.getOrDefault(tObj.name, new ArrayList<>());
            list.add(tObj);
            map.put(tObj.name, list);
            masterList.add(tObj);
        }

        for(Transaction transaction: masterList) {
            ArrayList<Transaction> list = map.get(transaction.name);

            for(Transaction taction: list) {
                if(Math.abs(transaction.time - taction.time) <= 60 && !transaction.city.equals(taction.city)) {
                    ids.add(taction.id);
                    mastermap.put(taction.id, taction);
                    ids.add(transaction.id);
                    mastermap.put(transaction.id, transaction);
                }
            }

            if(transaction.amount > 1000) {
                ids.add(transaction.id);
                mastermap.put(transaction.id, transaction);
            }
        }


        // print results
        for(int id: ids) {
            Transaction t = mastermap.get(id);
            transactionsResult.add(t.name+ "," + t.time + "," + t.amount + "," + t.city);
        }

        return transactionsResult;
    }
}
