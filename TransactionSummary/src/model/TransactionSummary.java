package model;

import java.util.ArrayList;
import java.util.List;

public class TransactionSummary {

    private String name;
    private List<Transaction> transactions;

    public TransactionSummary(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public int getNumTransactions() {
        return transactions.size();
    }

    // REQUIRES: t is not already within transactions
    // MODIFIES: this
    // EFFECTS: adds the given transaction t to the list of transactions
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: computes the average amount of money spent on a transaction
    public double averageTransactionCost() {

        double avg = 0;

        for (int i = 0; i < transactions.size(); i++){
            avg += transactions.get(i).getAmount();
        }

        return avg/transactions.size();
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS:  returns the average cost of all transactions of type specificType in this
    //           TransactionSummary
    public double specificTypeAverage(TransactionType specificType) {

        double avg = 0;
        int specificCount = 0;

        for (int i = 0; i < transactions.size(); i++){
            Transaction transaction = transactions.get(i);
            if (transaction.getType() == specificType){
                avg += transaction.getAmount();
                specificCount++;
            }
        }
        return avg/specificCount;
    }

    // REQUIRES: transactions is non-empty
    // EFFECTS: returns the largest transaction (in terms of cost) in this TransactionSummary
    public Transaction largestTransaction() {
        double max = 0;
        Transaction maxTrans = null;

        for (int i = 0; i < transactions.size(); i++){

            Transaction transaction = transactions.get(i);
            int amount = transaction.getAmount();

            if (amount > max){
                max = amount;
                maxTrans = transaction;
            }
        }

        return maxTrans;
    }

    // EFFECTS: returns true if the given transaction is contained within the list of transactions
    public boolean contains(Transaction t) {
        return transactions.contains(t);
    }


}
