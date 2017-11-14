package cc.somkiat.basicunittesting.validation;

import android.util.Patterns;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.RuleException;

/**
 * Created by Amoeba on 11/15/2017.
 */

public class EmailValidation {

    private String email;
    public EmailValidation(String email){
        this.email = email;
    }

    public boolean validate() throws RuleException{
        emailIsNotEmpty();
        emailFormat();
        return true;
    }

    public boolean emailIsNotEmpty() throws RuleException{
        if(!email.isEmpty())
            return true;
        throw new RuleException("Email is empty");

    }

    public boolean emailFormat() throws RuleException {
        if(!Patterns.EMAIL_ADDRESS.matcher(this.email).matches())
            throw new RuleException("Email is incorrect");
        return true;
    }


}
