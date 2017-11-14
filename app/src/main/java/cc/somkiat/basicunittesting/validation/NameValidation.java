package cc.somkiat.basicunittesting.validation;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.RuleException;

/**
 * Created by Amoeba on 11/10/2017.
 */

public class NameValidation {

    public String text;

    public NameValidation(String text){
        this.text = text;
    }

    public boolean validate() throws RuleException{
        nameIsEmpty();
        return true;
    }

    public boolean nameIsEmpty() throws RuleException {
        if(text.isEmpty())
            return true;
        throw new RuleException("Name is empty");
    }

}
