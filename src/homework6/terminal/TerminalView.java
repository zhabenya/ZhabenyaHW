package homework6.terminal;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zhabenya on 14.12.15.
 */
public class TerminalView {

    private Scanner scanner = new Scanner(System.in);
    private TerminalController controller;
    private CommandParser parser;

    public TerminalView(TerminalController controller) {
        this.controller = controller;
        parser = new CommandParser(controller);
    }

    public void start(){
        while (true) {
            System.out.print(controller.model.getStartLine());
            String command = scanner.nextLine();
            if (command.equals("exit")){
                System.out.println("Good bye!");
                break;
            } else {
                parser.processCommand(command);
            }
        }
    }
}
