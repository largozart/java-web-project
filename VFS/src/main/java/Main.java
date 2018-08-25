import java.io.*;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("ddddd");

        VFS vfs = new VFSImpl("C:\\Users\\Валерия\\Desktop\\VFS");
        System.out.println("Directory test : " + vfs.isDirectory("\\dir"));
        System.out.println("Exist test : " + vfs.isExists("\\testik.txt"));
        System.out.println("AbslutePath test : " + vfs.getAbsolutePath("testik.txt"));
        System.out.println("GetBytes test : " + vfs.getBytes("testik.txt"));
        System.out.println("GetUTF-8Test : " + vfs.getUTF8Text("testik.txt"));
        Iterator itr = vfs.getIterator("C:\\Users\\Валерия\\Desktop\\VFS");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        Iterator itr2 = vfs.getIterator("C:\\Users\\Валерия\\Desktop\\VFS\\dir");
        while (itr2.hasNext()) {
            itr2.remove();
        }

    }
}
