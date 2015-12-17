package homework6.terminal;

import homework6.commands.Ls;
import homework6.commands.Rm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhabenya on 14.12.15.
 */
public class CommandParser {

    private TerminalController controller;
    private List<String> commandArgs;
    private List<String> options;
    private List<String> arguments;
    private String command;

    public CommandParser(TerminalController controller) {
        this.controller = controller;
    }

    public void processCommand(String command){
        parseCommand(command);
    }

    private void parseCommand(String input){
        input = input.trim();
        String[] commandSplit = input.split(" ");
        commandArgs = new ArrayList<>(Arrays.asList(commandSplit));
        command = commandArgs.get(0);
        commandArgs.remove(0);

        if (input.endsWith("--help")){
            controller.getCommandHelp(command);

        } else if (command.equals("pwd")){
            controller.printWorkingDirectory();

        } else if (command.equals("ls")){
            options = getOptions(commandArgs);
            if (validateOptions(options, new Ls().getValidOptions())) {
                controller.listFiles(options);
            }

        } else if (command.equals("cd")){
            arguments = getArguments(commandArgs);
            if (arguments.size() > 0)
                controller.changeDirectory(arguments.get(0));

        } else if (command.equals("touch")){
            if (parseOperand(commandArgs))
                controller.createFile(getArguments(commandArgs));

        } else if (command.equals("mkdir")){
            if (parseOperand(commandArgs))
                controller.createDirectory(getArguments(commandArgs));

        } else if (command.equals("rm")){
            options = getOptions(commandArgs);
            arguments = getArguments(commandArgs);
            if (options.isEmpty())
                controller.removeFile(arguments);
            else if (parseOperand(commandArgs) && validateOptions(options, new Rm().getValidOptions()))
                controller.removeDir(arguments);

        } else {
            System.out.println("Command not found");
        }
    }

    private boolean parseOperand(List<String> commandArgs) {
        if (commandArgs.size() == 0) {
            System.out.println(command + ": missing file operand\n" +
                               "Try '" + command + " --help' for more information.");
            return false;
        }
        return true;
    }

    private boolean validateOptions(List<String> inputOptions, List<String>  validOptions){
        for (String option : inputOptions) {
            if (!validOptions.contains(option)) {
                System.out.println(command + ": invalid option -- '" + option + "'.\n" +
                                   "Try '" + command + " --help' for more information.");
                return false;
            }
        }
        return true;
    }

    private List<String> getOptions(List<String> commandArgs){
        options = new ArrayList<>();
        for (int i = 0; i < commandArgs.size(); i++) {
            String arg = commandArgs.get(i);
            if (arg.startsWith("-"))
                options.add(arg.substring(1));
        }
        return options;
    }

    private List<String> getArguments(List<String> commandArgs){
        arguments = new ArrayList<>();
        for (String arg : commandArgs) {
            if (!arg.startsWith("-"))
                arguments.add(arg);
        }
        return arguments;
    }

}
