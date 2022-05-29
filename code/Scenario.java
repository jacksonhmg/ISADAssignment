//package code;

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
        String pInputString = "";
        boolean checker = true;
        boolean enterChecker = true;
        boolean belowZeroChecker = true;
        double pInputDoub = 0;
        double[] valArray = new double[1];
        switch(input){
            case 1: case 2: case 4:
                sc.nextLine();
                System.out.println("Enter your string: ");
                pInputString = sc.nextLine();
            break;
            case 5: case 6:
                sc.nextLine();
                System.out.println("Enter 'true' if you would like to enter your own value to convert or 'false' if you would like to convert the given csv file");
                enterChecker = sc.nextBoolean();
                if(enterChecker == true){
                    while(belowZeroChecker == true){
                        System.out.println("Enter your double: ");
                        pInputDoub = sc.nextDouble();
                        if(pInputDoub < 0.0){
                            System.out.println("Cannot enter a measurement below zero, try again");
                        }
                        else{
                            belowZeroChecker = false;
                        }
                    }
                }
                else{
                    valArray = readFile("values.csv");
                }
            break;
        }
        switch(input){
            case 1:
                System.out.println("Enter 'true' to convert to uppercase or 'false' to convert to lower case");
                checker = sc.nextBoolean();
                if(checker == true){
                    pInputString = stringUpper(pInputString);
                }
                else if(checker == false){
                    pInputString = stringLower(pInputString);
                }
                
                System.out.println(pInputString);
            break;
            case 2:
                int counter = numericFilter(pInputString);
                System.out.println("There are " + counter + " digits in your given string");
            break;
            case 3:
                try{
                    sc.nextLine();
                    System.out.println("Enter your string: ");
                    pInputString = sc.nextLine();
                    double x = numberChecker(pInputString);
                    System.out.println(x + " is a valid number!");
                } catch(NumberFormatException errorDetails){
                    System.out.println("Nope! This is not a valid number. See here: " + errorDetails.getMessage());
                }
            break;
            case 4:
                System.out.println("Enter 'true' to convert to uppercase or 'false' to convert to lower case");
                checker = sc.nextBoolean();
                pInputString = removeNConvert(pInputString, checker);
                System.out.println(pInputString);
            break;
            case 5:
                System.out.println("Enter 'true' to convert meters to feet or 'false' to convert feet to meters");
                checker = sc.nextBoolean();
                if(enterChecker == true){
                    if(checker == true){
                        pInputDoub = metersToFeet(pInputDoub);
                    }
                    else if(checker == false){
                        pInputDoub = feetToMeters(pInputDoub);
                    }
                    
                    System.out.println(pInputDoub);
                    valArray[0] = pInputDoub;
                }
                else{
                    for(int i = 0; i < valArray.length; i++){
                        if(checker == true){
                            valArray[i] = metersToFeet(valArray[i]);
                        }
                        else if(checker == false){
                            valArray[i] = feetToMeters(valArray[i]);
                        }
                        
                        if(valArray[i] < 0){
                            valArray[i] = 0;
                        }
                    System.out.println(valArray[i]);    
                    }
                }
                writeOneRow("OutputFile.csv", valArray);
            break;
            case 6:
                System.out.println("Enter 'true' to convert centimeters to inches or 'false' to convert inches to centimeters");
                checker = sc.nextBoolean();
                if(enterChecker == true){
                    if(checker == true){
                        pInputDoub = centiToInches(pInputDoub);
                    }
                    else if(checker == false){
                        pInputDoub = inchesToCenti(pInputDoub);
                    }
                    System.out.println(pInputDoub);
                    valArray[0] = pInputDoub;
                }
                else{
                    for(int i = 0; i < valArray.length; i++){
                        if(checker == true){
                            valArray[i] = centiToInches(valArray[i]);
                        }
                        else if(checker == false){
                            valArray[i] = inchesToCenti(valArray[i]);
                        }
                        
                        if(valArray[i] < 0){
                            valArray[i] = 0;
                        }
                    System.out.println(valArray[i]);
                    }
                    
                }
                writeOneRow("OutputFile.csv", valArray);
            break;
            default:

            break;
        }

        sc.close();
    }


    public static String stringUpper(String pInputString){
        pInputString = pInputString.toUpperCase();
        
        return pInputString;
    }

    public static String stringLower(String pInputString){
        pInputString = pInputString.toLowerCase();
        
        return pInputString;
    }


    public static int numericFilter(String pInputString){
        char[] charArray = pInputString.toCharArray();
        int counter = 0;
        for(int i = 0; i < charArray.length; i++){
            if(Character.isDigit(charArray[i])){
                counter ++;
            }
        }
        return counter;
    }


    public static double numberChecker(String pInputString){
        double x = Double.parseDouble(pInputString);
        return x;
    }

    public static String removeNConvert(String pInputString, boolean checker){
        String result = "";
        char[] charArray = pInputString.toCharArray();
        String newString;
        for(int i = 0; i < charArray.length; i++){
            if(!(Character.isDigit(charArray[i]))){
                result += charArray[i];
            }
        }
        if(checker == true){
            newString = stringUpper(String.valueOf(result));
        }
        else{
            newString = stringLower(String.valueOf(result));
        }
        

        return newString;
    }


    public static double feetToMeters(double pInputDoub){
        double result;
        result = (pInputDoub / 3.281);
        if(result < 0){
            result = 0;
        }
        return result;
    }


    public static double metersToFeet(double pInputDoub){
        double result;
        result = (pInputDoub * 3.281); 
        if(result < 0){
            result = 0;
        }
        return result;
    }


    public static double centiToInches(double pInputDoub){
        double result;
        result = (pInputDoub / 2.54);
        if(result < 0){
            result = 0;
        }
        return result;
    }


    public static double inchesToCenti(double pInputDoub){
        double result;
        result = (pInputDoub * 2.54);
        if(result < 0){
            result = 0;
        }
        return result;
    }


    public static double[] readFile(String pFileName){
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;
        String[] splitLine;
        double[] valArray = new double[1];
        try{
            fileStream = new FileInputStream(pFileName);
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            line = bufRdr.readLine();
            splitLine = line.split(" ");
            valArray = new double[splitLine.length];
            for(int i=0; i<splitLine.length; i++){
                valArray[i] = Double.parseDouble(splitLine[i]);
            }
        }catch(IOException errorDetails){
            if(fileStream != null){
                try{
                    fileStream.close();
                }catch(IOException ex2){

                }
            }
            System.out.println("An error! " + errorDetails.getMessage());
        }

    return valArray;
    }

    public static void writeOneRow(String pFilename, double[] pValArray){
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try {
            fileStrm = new FileOutputStream(pFilename);
            pw = new PrintWriter(fileStrm);
            for(int i = 0 ;i < pValArray.length; i ++){
                pw.println(pValArray[i] + " ");
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error in writing to file" + e.getMessage());
        }
    }
}
