package com.test.service;


import com.test.exceptions.ConversionException;

public class NumbertoWordService {
    private static final String[] unitNames = {
            ""," thousand"," million"," billion"," trillion"," quadrillion",
            " quintillion"
    };

    private static final String[] tensplaceHolders = {
            ""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy",
            " eighty"," ninety"
    };

    private static final String[] numbers = {
            ""," one"," two"," three"," four"," five"," six"," seven"," eight",
            " nine"," ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen",
            " sixteen"," seventeen"," eighteen"," nineteen"
    };

    private boolean validInput(String input)
    {
        for (int i = 0; i < input.length(); i++)
            if (Character.isDigit(input.charAt(i))
                    == false)
                return false;

        return true;
    }

    private String convertLessThanOneThousand(Integer number) throws ConversionException {


                String current;
                if (number % 100 < 20){
                    current = numbers[number % 100];
                    number /= 100;
                }
                else {
                    current = numbers[Math.toIntExact(number % 10)];
                    number /= 10;
                    current = tensplaceHolders[number % 10] + current;
                    number /= 10;
                }
                if (number == 0) return current;
                return numbers[number] + " hundred and" + current;
            }



    public String convert(String input) throws ConversionException {
        if(input!=null && !input.isEmpty())
        {
            if(validInput(input))
            {
                Integer number = Integer.parseInt(input);
                if (number == 0) { return "zero"; }
                String prefix = "";
                if (number < 0) {
                    number = -number;
                    prefix = "negative";
                }

                String current = "";
                int place = 0;

                do {
                    int n = number % 1000;
                    if (n != 0){
                        String s = convertLessThanOneThousand(n);
                        current = s + unitNames[place] + current;
                    }
                    place++;
                    number /= 1000;
                }   while (number > 0);

                return (prefix + current).trim();
            }
            throw new ConversionException("Input is not a valid number");
        }
        throw new ConversionException("Input Cannot be blank or Null");


    }


}