import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.function.*;
import account.Account;
import static account.Account.filter;

/**
 * @author vsasaeva
 */
public class Main {

    public static void main(String arg[]) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);
        System.out.println(evenNumbers);

        Account a1=new Account(100L,"1111",false);
        Account a2=new Account(100000000L,"2222",false);
        Account a3=new Account(100L,"3333",false);
        Account a4=new Account(0L,"4444",false);
        Account a5=new Account(0L,"5555",false);
        Account a6=new Account(0L,"6666",false);

        List<Account> accs = Arrays.asList(a1, a2, a3, a4, a5, a6);

        List<Account> nonEmptyAccounts= filter(accs, acc -> acc.getBalance()>0);
        List<Account> accountsWithTooMuchMoney= filter(accs, acc -> acc.getBalance() >= 100000000 && acc.isLocked()==false);

        System.out.println(nonEmptyAccounts);
        System.out.println(accountsWithTooMuchMoney);

    }
}


