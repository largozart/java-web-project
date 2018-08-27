import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.io.FileUtils;

public class FileIterator implements Iterator <String>{

    private Queue<File> files  =new LinkedList<>();
    FileIterator()
    {
    }

    FileIterator(String starDir)
    {
        files.add(new File(starDir));
    }

    @Override
    public boolean hasNext() {
        return !files.isEmpty();
    }

    @Override
    public String next() {
        File file = files.peek();
        if (file.isDirectory()){
            for (File subfile: file.listFiles()) {
                files.add(subfile);
            }
        }
        return files.poll().getAbsolutePath();
    }

    /**
     * recursive use Util commom io
     */
    @Override
    public void remove() {
        File file = files.remove();

            if (file.isDirectory()) {
                deleteDir(file);
            } else {
                file.delete();
            }

        return;
    }


    void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDir(f);
            }
        }
        file.delete();
    }
}
