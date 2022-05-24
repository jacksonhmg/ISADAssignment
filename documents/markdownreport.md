# ISE Final Assessment Report

By Jackson Mowatt Gok, 
20568818

Practical Class: Thursdays/8am-10am/Venue

## Introduction
In total I have 4 necessary files for my code. One of these is "Scenario.java" which is the main code that has the method creations inside, another is the test case file "ScenarioTestCases.java" that utilises JUnit and my main code, another is "values.csv" which is the example file I use for reading a file, and the last is "OutputFile.csv" which is the example file I use for writing to a file. Within the Scenario.java file, I have 9 separation methods/functions. These are my "main" method which controls the menu system, the next six methods address the problems addressed in "Category 1 and 2" in the assessment outline and my final two methods control reading and writing to a file. The code works so that there is a menu system which the user operates through by entering their choice into the system. They first, choose any of the operations specified in the "Categories" from the assessment outline, they then then enter an input or sometimes, depending on their choice, have the option to use a separate file with predetermined values and finally their input is then run through the operation of their choosing and the output is printed to the user and sometimes, depending on their choice, written to the "OutputFile.csv" file. Within each of these methods there is further functionality, which I'll discuss in later sections.

## Module Descriptions
module: converting string to upper or lower case  

    function name: convertString
    takes two parameters: pInputString (input by user) and a boolean checker to swap between upper or lower case
    returns pInputString in whatever chosen format determined by user (upper or lower case)


module: Identify whether numeric values are in a given string  

    function name: numericFilter
    takes one parameter: pInputString (input by user)
    turns the string into an array of characters
    loop through character array and add +1 to a counter if a character is a numeric value
    print out how many numeric values are in the array

module: Identify whether a given string is a valid number or not  

    function name: numberChecker
    takes one parameter: pInputString (input by user)
    parses an integer of the given string
    if its not an integer itll spit out an error
    if it is, itll print and tell you


module: remove any numeric values from a given array and then convert the string to upper or lower case  

    function name: removeNConvert
    takes two parameters: pInputString (input by user) and a boolean checker 
    takes pInputString and turns it into a character array
    loops through the array and whatever elements are not numeric values are added to a new array
    then that new array is converted back to string and plugged into convertString along with the boolean checker
    the newString is returned

module: converting meters to feet and vice versa  

    function name = metersNFeet
    takes two parameters: pInputDoub and boolean checker
    if the checker is true itll assume the double is in meters and will convert to feet (* 3.281)
    if the checker is false itll assume the double is in feet and will convert to meters (/ 3.281)
    return the result

module: converting centimeters to inches and vice versa  

    function name = centiNInches
    takes two parameters: pInputDoub and boolean checker
    if the checker is true itll assume the double is in centimeters and will convert to inches (/ 2.54)
    if the checker is false itll assume the double is in inches and will convert to centimeters (* 2.54)
    return the result



module: for reading files  

    function name = readFile
    takes one parameter: pFileName
    creates all necessary file reading variables: file stream, InputStreamReader, BufferedReader and something that reads the line of the BufferedReader
    splits the line using regex (.split)
    converts the strings from the line into doubles
    returns the doubles

module: for writing to files  

    function name = writeOneRow
    takes one parameter: pFileName, double array pValArray
    creates all necessary file writing variables: file stream, print writer
    for each value in the array, print that to the file, separated by a space
    close the print writer


module: for all menu control  

    function name: main
    outputs options of menu to user by printing to console
    takes input from user and uses that to do one of multiple options using the above functions
    prints the outcome of the users choice to the console

#### REVISED MODULE DESCRIPTIONS:

module: Identify whether numeric values are in a given string.  **See last line for revision**

    function name: numericFilter
    takes one parameter: pInputString (input by user)
    turns the string into an array of characters
    loop through character array and add +1 to a counter if a character is a numeric value
    return the counter value (the revision)

module: Identify whether a given string is a valid number or not. **See 3rd, 4th and 5th line for revision**
    function name: numberChecker
    takes one parameter: pInputString (input by user)
    parses an double (revision) of the given string
    if its not a double, itll return -1 (revision)
    if it is, itll return the valid number (revision)
    
    
#### Assumptions I made:
Whilst many of the methods have specific try catch statements, a lot of the time I assumed the user would be inputting the same variable type as they were asked for. For example, when asked to enter a double or a boolean to make their choices/inputs, I assumed the user would input a double or a boolean in their specific case. If they do not, the code will throw an error to the user.

## Modularity
#### Description on how to run my code
When you first open the code, you'll be prompted with the first menu: ![image](https://images2.imgbox.com/16/ca/JI19dGz1_o.png)
You are then prompted to enter your choice (as seen by the cursor underneath the options). To choose an option, enter the digit in front of the explanation. For example, if I wanted to convert a string to upper or lower case, I would enter 1.
In the first four options, you'll be asked to enter a string or for the last two options, you'll be asked to enter a double. Enter normally using the terminal line.
In some of the options where you can further choose between two options (i.e. convert a string to upper or lower case, convert centimeters to inches and vice versa), you will be prompted with another menu to ask what you want to be done with the value you have entered:
![image](https://images2.imgbox.com/4c/ad/po9bhyJ5_o.png)
In these scenarios, read the prompt carefully and make your choice accordingly. The "true" and "false" options can be entered in upper/lower or mixed case.
Finally, on the last two options on the first menu, you will be prompted with another menu asking if you want to enter your own values or use the given csv file:
![image](https://images2.imgbox.com/d5/b0/zfTDWBGS_o.png).
Similarly, read the prompt carefully and make your choice accordingly. In these scenarios, the "given csv file" is referring to using the values within the "values.csv" file. Furthermore, in these scenarios, the output, which is printed to the terminal, will also be printed/written to the "OutputFile.csv" file.
Which brings me to the final point; for all the options given within the menu, their final output/calculation will be printed to the terminal line.
Full example:
![image](https://images2.imgbox.com/3a/d3/U99H8ABR_o.png)

#### Discussion on different modularity concepts applied


    