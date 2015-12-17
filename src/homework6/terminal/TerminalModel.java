package homework6.terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

/**
 * Created by zhabenya on 14.12.15.
 */
public class TerminalModel {

    private String homeDirPath = "/home/tania/IdeaProjects/ZhabenyaHW/src/homework6/testdir";

    private String homeDirName = homeDirPath.substring(homeDirPath.lastIndexOf('/') + 1);
    private String helpDirPath = "/home/tania/IdeaProjects/ZhabenyaHW/src/homework6/helpers";
    private String username = "Zhabenya";
    protected File currDir = new File(homeDirPath);
    protected File helpDir = new File(helpDirPath);

    public TerminalModel() {
    }

    public TerminalModel(String username) {
        this.username = username;
    }

    public String getHomeDirPath() {
        return homeDirPath;
    }

    protected String getDirRelativePath(File dir){
        String path = dir.toString();
        return path.substring(path.lastIndexOf(homeDirName) + homeDirName.length());
    }

    public String getStartLine(){
        return String.format("%s@ ~%s $", username, getDirRelativePath(currDir));
    }

    protected String getFileRelativePath(File file){
        String path = file.toString();
        return path.substring(path.lastIndexOf("/") + 1);
    }

    protected boolean findInDirectory(String toFind, File dirToSearch){
        for (File current : dirToSearch.listFiles()) {
            if (toFind.equals(current.getName())){
                return true;
            }
        }
        return false;
    }

    public Date getCreationTime(File file) throws IOException {
        Path p = Paths.get(file.getAbsolutePath());
        BasicFileAttributes view
                = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
        return new Date(view.creationTime().toMillis());
    }
}
