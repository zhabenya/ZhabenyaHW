package homework6.commands;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhabenya on 17.12.15.
 */
public class Rm implements ICommand {

    private List<String> validOptions = Arrays.asList("r");

    public List<String> getValidOptions() {
        return validOptions;
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
