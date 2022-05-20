package code;

import java.util.*;
import java.io.*;

public class Scenario{
    

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("> 1 = Convert a string to upper or lower case");
        System.out.println("> 2 = Identify whether numeric values are in a given string");
        System.out.println("> 3 = Identify whether a given string is a valid number or not");
        System.out.println("> 4 = Remove any numeric values in a given string and convert the string to upper or lower case");
        System.out.println("> 5 = Convert meters to feet and vice versa");
        System.out.println("> 6 = Convert centimeters to inches and vice versa");

        int input = sc.nextInt();
        while((input != 1) && (input != 2) && (input != 3) && (input != 4) && (input != 5) && (input != 6)){
            System.out.println("Not a valid input. Try again");
            input = sc.nextInt();
        }
        String pInputString;
        boolean checker;
        double pInputDoub;
        switch(input){
            case 1:
                sc.nextLine();
                System.out.println("Enter your string: ");
                pInputString = sc.nextLine();
                System.out.println("Enter 'true' to convert to uppercase or 'false' to convert to lower case");
                checker = sc.nextBoolean();
                pInputString = convertString(pInputString, checker);
                System.out.println(pInputString);
            break;
            case 2:
                sc.nextLine();
                System.out.println("Enter your string: ");
                pInputString = sc.nextLine();
                numericFilter(pInputString);
            break;
            case 3:
                try{
                    sc.nextLine();
                    System.out.println("Enter your string: ");
                    pInputString = sc.nextLine();
                    numberChecker(pInputString);
                } catch(NumberFormatException errorDetails){
                    System.out.println("Nope! This is not a valid number. See here: " + errorDetails.getMessage());
                }

            break;
            case 4:
                sc.nextLine();
                System.out.println("Enter your string: ");
                pInputString = sc.nextLine();
                System.out.println("Enter 'true' to convert to uppercase or 'false' to convert to lower case");
                checker = sc.nextBoolean();
                pInputString = removeNConvert(pInputString, checker);
                System.out.println(pInputString);
            break;
            case 5:
                sc.nextLine();
                System.out.println("Enter your double: ");
                pInputDoub = sc.nextDouble();
                System.out.println("Enter 'true' to convert meters to feet or 'false' to convert feet to meters");
                checker = sc.nextBoolean();
                pInputDoub = metersNFeet(pInputDoub, checker);
                System.out.println(pInputDoub);
            break;
            case 6:
                sc.nextLine();
                System.out.println("Enter your double: ");
                pInputDoub = sc.nextDouble();
                System.out.println("Enter 'true' to convert centimeters to inches or 'false' to convert inches to centimeters");
                checker = sc.nextBoolean();
                pInputDoub = centiNInches(pInputDoub, checker);
                System.out.println(pInputDoub);
            break;
            default:

            break;
        }

    }


    public static String convertString(String pInputString, boolean checker){
        if(checker == true){
            pInputString = pInputString.toUpperCase();
        }
        else{
            pInputString = pInputString.toLowerCase();
        }
        
        return pInputString;
    }

    public static void numericFilter(String pInputString){
        char[] charArray = pInputString.toCharArray();
        int counter = 0;
        for(int i = 0; i < charArray.length; i++){
            if(Character.isDigit(charArray[i])){
                counter ++;
            }
        }

        System.out.println("There are " + counter + " digits in your given string");
    }


    public static void numberChecker(String pInputString){
        double x = Double.parseDouble(pInputString);
        System.out.println(x + " is a valid number!");
        
    }

    public static String removeNConvert(String pInputString, boolean checker){
        String result = "";
        char[] charArray = pInputString.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(!(Character.isDigit(charArray[i]))){
                result += charArray[i];
            }
        }
        String newString = convertString(String.valueOf(result), checker);

        return newString;
    }


    public static double metersNFeet(double pInputDoub, boolean checker){
        double result = 0;
        if(checker == true){ //meters to feet
            result = (pInputDoub * 3.281);
        }
        else{
            result = (pInputDoub / 3.281);
        }
        
        return result;
    }

    public static double centiNInches(double pInputDoub, boolean checker){
        double result = 0;
        
        if(checker == true){ //centimeters to inches
            result = (pInputDoub / 2.54);
        }
        else{
            result = (pInputDoub * 2.54);
        }

        return result;
    }
}

