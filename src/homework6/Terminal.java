package homework6;

import homework6.terminal.TerminalController;
import homework6.terminal.TerminalModel;
import homework6.terminal.TerminalView;

/**
 * Created by zhabenya on 14.12.15.
 */
public class Terminal {

    private TerminalController controller;
    private TerminalView view;
    private TerminalModel model;

    public Terminal() {
        model = new TerminalModel();
        controller = new TerminalController(model);
        view = new TerminalView(controller);
    }

    public Terminal(String username) {
        model = new TerminalModel(username);
        controller = new TerminalController(model);
        view = new TerminalView(controller);
    }

    public void start(){
        view.start();
    }
}
