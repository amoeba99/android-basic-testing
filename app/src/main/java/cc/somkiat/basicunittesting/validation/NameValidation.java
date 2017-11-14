package cc.somkiat.basicunittesting.validation;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.RuleException;

/**
 * Created by Amoeba on 11/10/2017.
 */

public class NameValidation {

    public String name;

    public NameValidation(String text){
        this.name = text;
    }

    public boolean validate() throws RuleException{
        nameIsNotEmpty();
        nameFormat();
        return true;
    }

    public boolean nameIsNotEmpty() throws RuleException {
        if(!this.name.isEmpty())
            return true;
        throw new RuleException("Name is empty please enter name");
    }

    public boolean nameFormat() throws RuleException {
        if(!Pattern.matches("^[a-zA-Z]+$", this.name)){
            throw new RuleException("Name is incorrect format");
        }
        return true;
    }

}
