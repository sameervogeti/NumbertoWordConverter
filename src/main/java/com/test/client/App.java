package com.test.client;


import com.test.exceptions.ConversionException;
import com.test.service.NumbertoWordService;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        NumbertoWordService obj = new NumbertoWordService();
        System.out.println("Enter the Number:");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        try {
            System.out.println("Result: "+obj.convert(n));
        } catch (ConversionException e) {
            System.out.println(e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
