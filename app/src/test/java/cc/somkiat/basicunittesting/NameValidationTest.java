package cc.somkiat.basicunittesting;

import junit.framework.Assert;

import org.junit.Test;

import cc.somkiat.basicunittesting.exception.RuleException;
import cc.somkiat.basicunittesting.validation.NameValidation;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Amoeba on 11/10/2017.
 */

public class NameValidationTest {

    @Test
    public void NameIsNotEmpty() throws RuleException {
        NameValidation nameValidation = new NameValidation("Viriya");
        assertTrue("Name is empty", nameValidation.nameIsNotEmpty());
    }

    @Test(expected = RuleException.class)
    public void NameIsEmpty() throws RuleException{
        NameValidation nameValidation = new NameValidation("");
        nameValidation.nameIsNotEmpty();
    }



}
