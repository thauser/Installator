package controllers;

import controllers.exceptions.ValidationException;

/**
 * Created by eunderhi on 27/11/15.
 */
public abstract class Validator {

    public abstract void validate() throws ValidationException;

}
