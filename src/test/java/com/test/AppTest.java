package com.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.test.exceptions.ConversionException;
import com.test.service.NumbertoWordService;
import org.junit.Assert;
import org.junit.Test;


public class AppTest {

    @Test
    public void testSuccessScenario() {
        NumbertoWordService numbertoWordService = new NumbertoWordService();
        String result = null;
        try {
            result = numbertoWordService.convert("10");
        } catch (Exception e) {
            System.out.println("Test Failed");
            fail();
        }

        Assert.assertTrue(result != null);
        Assert.assertTrue(result.equalsIgnoreCase("Ten"));

    }


    @Test
    public void testInvalidInputScenario() {
        NumbertoWordService numbertoWordService = new NumbertoWordService();
        String result = null;
        try {
            result = numbertoWordService.convert("abc");
        } catch (ConversionException e) {
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Input is not a valid number"));
        }
    }

    @Test
    public void testBlankInputScenario() {
        NumbertoWordService numbertoWordService = new NumbertoWordService();
        String result = null;
        try {
            result = numbertoWordService.convert("");
        } catch (ConversionException e) {

            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Input Cannot be blank or Null"));
        }
    }

    @Test
    public void testNullInputScenario() {
        NumbertoWordService numbertoWordService = new NumbertoWordService();
        String result = null;
        try {
            result = numbertoWordService.convert(null);
        } catch (ConversionException e) {

            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Input Cannot be blank or Null"));
        }
    }
}
