package homework6.terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;

/**
 * Created by zhabenya on 16.12.15.
 */
public class TestSpaceMethod {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/tania/IdeaProjects/ZhabenyaHW/src/homework6/helpers/cd.txt");
        System.out.println(file.length()); // get file size in bytes
        System.out.println(file.lastModified());
        System.out.println();

        FileTime fileTime = getCreationTime(file);
        System.out.println(new Date(fileTime.toMillis()));
    }

    public static FileTime getCreationTime(File file) throws IOException {
        Path p = Paths.get(file.getAbsolutePath());
        BasicFileAttributes view
                = Files.getFileAttributeView(p, BasicFileAttributeView.class)
                .readAttributes();
        FileTime fileTime=view.creationTime();
        return fileTime;
    }


}
