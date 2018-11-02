package account;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author vsasaeva
 */
public class Account {
    Long balance;
    String number;
    boolean isLocked;

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Account()
    {

    }

    public Account(Long balance,String number, boolean isLocked){
        this.balance=balance;
        this.number=number;
        this.isLocked=isLocked;
    }

    public static <T> List<T> filter(List<T> inputList, Predicate<T> condition) {
        return inputList.stream().filter(condition).collect(Collectors.toList());
    }
}
