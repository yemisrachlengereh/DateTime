package com.company;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //Get the current time
        LocalDateTime rightNow = LocalDateTime.now();
        //Date from the user
        LocalDate userDate = null;

        //Set up formatters so that you can use them later
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");


        //Time formatter (time only)
        DateTimeFormatter hr24 = DateTimeFormatter.ofPattern("kk:m");

        //Output today's date in formats that have been preset
        System.out.println("The current date is: " + rightNow.format(longFormat));
        System.out.println("This is the current date and time unformatted: " + rightNow);

        //Output the current time in formats that have been preset
        System.out.println("This is the current system time: " + LocalTime.now());
        System.out.println("This is the current system time (24 h format): " + LocalTime.now().format(hr24));


        do {
            System.out.println("Enter a date in the past(dd/mm/yyyy)");
            try {
                userDate = LocalDate.parse(keyboard.nextLine(), dTF);

                if (userDate.isAfter(LocalDate.now()) && userDate != null) {
                    System.out.println("The date must be in the past");
                    userDate = null;
                }

            } catch (Exception e) {

                System.out.println("Unable to convert the string you entered to date. Please try again!");


            }

        } while (userDate == null);

        //Display the date entered
        System.out.println( userDate.format(shortMonthFormat));

        System.out.println( userDate.format(dTF));

        System.out.println(userDate.format(longFormat));


    }
}