import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerThread(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Включаем автоматическое выталкивание:
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                .getOutputStream())), true);
        // Если любой из вышеприведенных вызовов приведет к
        // возникновению исключения, то вызывающий отвечает за
        // закрытие сокета. В противном случае, нить
        // закроет его.
    }

    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str.equals("Bue"))
                    break;
                System.out.println("Echoing: " + str);
                out.println(str);
            }
            System.out.println("closing...");
        }
        catch (IOException e) {
            System.err.println("IO Exception");
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}

