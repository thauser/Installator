package views.ui.textinput;

import controllers.exceptions.ValidationException;

/**
 * Created by eunderhi on 07/12/15.
 */
public class ConsoleTextInputField extends TextInputField {

    private String prompt = "";

    @Override
    public void update() {
        display();
        String text = System.console().readLine();
        setText(text);
        notifyControllers();
    }

    @Override
    public void display() {
        System.out.print(prompt);
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    protected void onValidationFail(ValidationException e) {
        System.out.println(e.getMessage());
        update();
    }

    @Override
    protected void onValidationSuccess() {

    }

}
