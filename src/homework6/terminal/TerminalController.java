package homework6.terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by zhabenya on 14.12.15.
 */
public class TerminalController {

    public TerminalModel model;
    protected File currDir;

    public TerminalController(TerminalModel model) {
        this.model = model;
        currDir = model.currDir;
    }

    protected File getFileByPath(String path) {
        return new File(currDir.getAbsolutePath() + "/" + path);
    }

    protected String cat(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        String res = "";

        while (scanner.hasNextLine()) {
            res += scanner.nextLine() + "\n";
        }

        return res;
    }

    protected void printWorkingDirectory() {
        System.out.println(currDir.getAbsolutePath());
    }

    protected void getCommandHelp(String command) {
        try {
            String help = "";

            for (File fileName : model.helpDir.listFiles()) {
                if (fileName.getName().equals(command + ".txt")) {
                    help = cat(fileName.getAbsolutePath());
                }
            }
            System.out.println(help);

        } catch (FileNotFoundException e) {
            System.out.println(command + ": command not found");
        }
    }

    protected void listFiles(List<String> options) {
        File[] files = currDir.listFiles();

        for (File file : files) {
            String res = "";
            if (!file.getName().startsWith(".") || options.contains("a")) {
                Date dateCreated = null;
                try {
                    dateCreated = model.getCreationTime(file);
                } catch (IOException e) {}
                long size = file.length();

                res += file.getName();
                res += (options.contains("t")) ? "  " + dateCreated : "";
                res += (options.contains("s")) ? "  " + size : "";

                System.out.println(res);
            }
        }

    }

    protected void changeDirectory(String dirName) {

        if (dirName.equals("..")) {
            if (!(currDir.getPath().equals(model.getHomeDirPath()))) {
                model.currDir = new File(currDir.getParent());
            }

        } else if (model.findInDirectory(dirName, currDir)) {
            File dir = new File(currDir + "/" + dirName);
            if (dir.isDirectory()) {
                model.currDir = dir;
            } else {
                System.out.println(dirName + ": Not a directory");
            }

        } else System.out.println(dirName + ": No such file or directory");

        currDir = model.currDir;

    }

    protected void createFile(List<String> args) {
        for (String arg : args) {
            File newFile = getFileByPath(arg);

            if (!newFile.exists()) {
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("File " + arg + " not created");
                }
            }
        }
    }

    protected void createDirectory(List<String> args) {
        for (String arg : args) {
            File newFile = getFileByPath(arg);

            if (!newFile.exists())
                newFile.mkdir();
        }
    }

    protected void removeFile(List<String> args) {

        for (String arg : args) {
            File remFile = getFileByPath(arg);

            if (remFile.isFile()) {
                remFile.delete();

            } else if (remFile.isDirectory()) {
                    System.out.println("rm: cannot remove ‘" + remFile.getName() + "’: Is a directory");

            } else {
                System.out.println("rm: cannot remove ‘" + remFile.getName() + "’: No such file or directory");
            }
        }

    }

    protected void removeDir(List<String> args) {

        for (String arg : args) {
            File remFile = getFileByPath(arg);

            if (remFile.exists()) {

                for (File file : remFile.listFiles()) {
                    file.delete();
                }
                remFile.delete();

            } else {
                System.out.println("rm: cannot remove ‘" + remFile.getName() + "’: No such file or directory");
            }
        }

    }

    /*protected void copyFile(List<String> args) {
        int last = args.size() - 1;

        if (getFileByPath(args.get(last)).isDirectory()) {
            changeDirectory(args.get(last));
            args.remove(last);
            createFile(args);
        } else {
            if (args.size() > 2){
                System.out.println("cp: target ‘" + args.get(last) + "’ is not a directory");
            } else {
                if (model.findInDirectory(args.get(1), currDir))
                    getFileByPath(args.get(1)).delete();

                File newFile =
            }
        }*/


}







