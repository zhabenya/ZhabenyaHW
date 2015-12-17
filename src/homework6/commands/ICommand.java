package homework6.commands;

/**
 * Created by zhabenya on 17.12.15.
 */
public interface ICommand {

    boolean validateOptions();
    boolean validateArgs();
    String execute();

}
