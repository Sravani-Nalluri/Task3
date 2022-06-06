package com.assignment3;

/*import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Scanner;

public class KYC {
	
	public static void main(String[] args) throws ParseException 
	{
		
		LocalDate[] signUpDate= new LocalDate[5];
       // LocalDate signUpDate[]= new LocalDate[5];
        LocalDate currentDate[] = new LocalDate[5];

        inputTheDates(signUpDate, currentDate);
        printAllowableDateRange(signUpDate, currentDate);
    }

    public static void inputTheDates(LocalDate[] signUpDate, LocalDate[] currentDate) 
    {
        int numberOfInputs;

        Scanner keyboard = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Enter the number of inputs to be passed:");
        numberOfInputs = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Enter sign-up date and current date in the format [dd-MM-yyyy]:");
        for(int counter = 0; counter < numberOfInputs; counter++) 
        {
            signUpDate[counter] = LocalDate.parse(keyboard.next(), formatter);
            currentDate[counter] = LocalDate.parse(keyboard.next(), formatter);
        }
    }

    public static void printAllowableDateRange(LocalDate[] signUpDate, LocalDate[] currentDate) 
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for(int counter = 0; counter < signUpDate.length; counter++) 
        {
            LocalDate anniversary = signUpDate[counter].withYear(currentDate[counter].getYear());
            if (currentDate[counter].isBefore(anniversary.minusDays(30)) || signUpDate[counter].equals(anniversary)) 
            {
                System.out.println("No range");
            }
            else 
            {
                LocalDate fromRange = anniversary.minusDays(30);
                LocalDate toRange = anniversary.plusDays(30);
                if (currentDate[counter].isAfter(fromRange) && currentDate[counter].isBefore(toRange)) 
                {
                    System.out.println(fromRange.format(formatter) + "\t" + currentDate[counter].format(formatter));
                }
                else 
                {
                    System.out.println(fromRange.format(formatter) + "\t" + toRange.format(formatter));
                }
            
              }
          }
    }

}
