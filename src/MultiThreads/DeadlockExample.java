package MultiThreads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    public static void main(String[] args) throws InterruptedException {
        TransferBetweenAccounts transferBetweenAccounts = new TransferBetweenAccounts();
        transferBetweenAccounts.startTransfer();
    }
}

class TransferBetweenAccounts{
    BankAccount first, second;
    Lock lockOnFirst, lockOnSecond;
    Random random;

    public void startTransfer() throws InterruptedException {

        first = new BankAccount(10000);
        second = new BankAccount(10000);
        lockOnFirst = new ReentrantLock();
        lockOnSecond = new ReentrantLock();
        random = new Random();

        Thread fromFirstToSecond = new Thread(this::transferFirst);
        Thread fromSecondToFirst = new Thread(this::transferSecond);

        fromFirstToSecond.start();
        fromSecondToFirst.start();

        fromFirstToSecond.join();
        fromSecondToFirst.join();

        System.out.println(first);
        System.out.println(second);
    }

    private void takeLocks(Lock firstLock, Lock secondLock){
        boolean lockOnFirstIsTaken = false;
        boolean lockOnSecondIsTaken = false;
        while(true) {
            try {
                lockOnFirstIsTaken = firstLock.tryLock();
                lockOnSecondIsTaken = secondLock.tryLock();
            } finally {
                if (lockOnFirstIsTaken && lockOnSecondIsTaken)
                    return;
                if (lockOnFirstIsTaken)
                    firstLock.unlock();
                if (lockOnSecondIsTaken)
                    secondLock.unlock();
            }
        }
    }

    private void transferFirst(){
        for (int i = 0; i < 2000; i++){
            takeLocks(lockOnFirst, lockOnSecond);
            try{
                first.transfer(second, random.nextInt(50));
            } finally {
                lockOnFirst.unlock();
                lockOnSecond.unlock();
            }

        }
    }

    private void transferSecond(){
        for (int i = 0; i < 2000; i++){
            takeLocks(lockOnSecond, lockOnFirst);
            try{
                second.transfer(first, random.nextInt(50));
            } finally {
                lockOnFirst.unlock();
                lockOnSecond.unlock();
            }
        }
    }
}

interface BankOperations{
    void deposit(int amount);
    void withdraw(int amount);
    void transfer(ClientInvestments transferTo, int amount);
}

abstract class ClientInvestments{
    protected int balance;

    public ClientInvestments(int balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean negativeBalanceAfterWithdraw(int amount) {
        return balance < amount;
    }
}

class BankAccount extends ClientInvestments implements BankOperations{

    public BankAccount(int deposit){
        super(deposit);
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (negativeBalanceAfterWithdraw(amount))
            System.out.println("Failed: can't withdraw more than balance.");
        else
            balance -= amount;
    }

    @Override
    public void transfer(ClientInvestments transferTo, int amount) {
        if (negativeBalanceAfterWithdraw(amount))
            System.out.println("Failed: can't transfer more than balance.");
        else{
            transferTo.balance += amount;
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Current balance of this account: " + balance;
    }
}
