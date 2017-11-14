package cc.somkiat.basicunittesting;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import cc.somkiat.basicunittesting.exception.RuleException;
import cc.somkiat.basicunittesting.validation.EmailValidation;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Amoeba on 11/15/2017.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class EmailValidationTest {
    @Test
    public void EmailIsCorrect() throws RuleException{
        EmailValidation emailValidation = new EmailValidation("test@hotmail.com");
        assertTrue("email is incorrect", emailValidation.emailFormat());
    }

    @Test(expected = RuleException.class)
    public void EmailIsIncorrect() throws RuleException{
        EmailValidation emailValidation = new EmailValidation("765.346");
        emailValidation.emailFormat();
    }

    @Test
    public void EmailIsNotEmpty() throws RuleException{
        EmailValidation emailValidation = new EmailValidation("starlight");
        assertTrue("Email is empty", emailValidation.emailIsNotEmpty());
    }

    @Test(expected = RuleException.class)
    public void EmailIsEmpty() throws RuleException{
        EmailValidation emailValidation = new EmailValidation("");
        emailValidation.emailIsNotEmpty();
    }

}
