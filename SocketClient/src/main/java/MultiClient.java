import java.io.IOException;
import java.net.InetAddress;

public class MultiClient {
    static final int MAX_THREADS = 3;

    public static void main(String[] args) throws IOException,
            InterruptedException {
        InetAddress addr = InetAddress.getByName(null);
        while (true) {
            if (SocketClientThread.threadCount() < MAX_THREADS)
                new SocketClientThread(addr);
            Thread.currentThread().sleep(100);
        }
    }
}
