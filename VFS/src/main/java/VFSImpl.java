import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class VFSImpl implements VFS {
    String root;

    public VFSImpl(String root) {
        this.root = root;
    }

    public boolean isExists(String path) {
        return new File(root + path).exists();
    }

    public boolean isDirectory(String path) {
        return new File(root + path).isDirectory();
    }

    public String getAbsolutePath(String file) {
        return new File(file).getAbsolutePath();
    }

    public byte[] getBytes(String file) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (FileInputStream in = new FileInputStream(new File(root + File.separator + file))) {
            byte[] buffer = new byte[4096];
            int read = 0;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public String getUTF8Text(String file) {

        StringBuilder sb = new StringBuilder();
        try (FileInputStream in = new FileInputStream(new File(root + File.separator + file))) {
            int c = 0;
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public Iterator<String> getIterator(String starDir) {
        FileIterator fileIterator = new FileIterator(starDir);
        return fileIterator;
    }
}
