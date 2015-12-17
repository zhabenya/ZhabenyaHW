package homework6.commands;

import homework6.terminal.TerminalController;

/**
 * Created by zhabenya on 17.12.15.
 */
public class Pwd implements ICommand {

    private TerminalController controller;

    public Pwd(TerminalController controller) {
        this.controller = controller;
    }

    @Override
    public boolean validateOptions() {
        return false;
    }

    @Override
    public boolean validateArgs() {
        return false;
    }

    @Override
    public String execute() {
        return null;
    }
}
