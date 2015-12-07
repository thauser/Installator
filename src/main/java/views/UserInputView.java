package views;

import controllers.Validator;

/**
 * Created by eunderhi on 27/11/15.
 */
public abstract class UserInputView extends UIComponent {

    public void addValidator(Validator validator) {
        validator.setUserInputView(this);
        addController(validator);
    }

}
