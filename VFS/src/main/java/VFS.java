import java.io.FileNotFoundException;
import java.util.*;

public interface VFS {

    boolean isExists(String path);

    boolean isDirectory(String path);

    String getAbsolutePath(String file);

    byte[] getBytes(String file);

    String getUTF8Text(String file) throws FileNotFoundException;

    Iterator<String> getIterator(String starDir);
}
