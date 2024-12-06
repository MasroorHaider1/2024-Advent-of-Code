import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day3 {
    public static void main(String[] args) {




        ArrayList<String> fileData = getFileData("src/Day3.txt");
        System.out.println(getAnswer1(fileData));
        System.out.println(getAnswer2(fileData));


    }



    public static Integer getAnswer1(ArrayList<String> fileData) {
        // Combine all data from arraylist into single string for the "for"loop
        String fileDataInAString = "";
        for (String line : fileData) {
            fileDataInAString += line; // Combine all lines into a string to use .append
        }

        // store all matches to collect specific nums through a for loop
        ArrayList<String> matches = new ArrayList<>();

        // PATTERN NEEDED   USED MR DAS SOLITION, THINK THIS SPECIFIED FROM 1-3 DIGIT NUMS
        String goodPart = "mul\\(\\d{1,3},\\d{1,3}\\)";
        Matcher m = Pattern.compile(goodPart).matcher(fileDataInAString);

        //copy whatever example gave
        while (m.find()) {
            matches.add(m.group()); // Add all matches to the list
        }

        //total from all good matche
        int totalSum = 0;

        // Loop through the matches to get the nums
        for (String match : matches) {
            //get the numbers
            int startOfGoodPart = match.indexOf('(') + 1; // after '('
            int endOfGoodPart = match.indexOf(')');       // where  ')' is
            String numbers = match.substring(startOfGoodPart, endOfGoodPart); // get the num,num2 THIS IS A STRING, USED YESTERDAYS

            //this string still has , so split and make into ints.
            String[] parts = numbers.split(",");
            int firstNum = Integer.parseInt(parts[0]); // First number
            int secondNum = Integer.parseInt(parts[1]); // Second number

            // Multiply the numbers and add to the total
            totalSum += firstNum * secondNum;
        }

        return totalSum;
    }

    public static Integer getAnswer2(ArrayList<String> fileData) {
        // Combine all data from arraylist into single string for the "for"loop
        String fileDataInAString = "";
        for (String line : fileData) {
            fileDataInAString += line; // Combine all lines into a single string
        }

        // get all instances of do,do not, and the mull part thing USED MR DAS'S PART, NOT SURE WHAT THESE REGEX SYNTAX IS
        String regexPartTwo = "mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)";
        Matcher matcher = Pattern.compile(regexPartTwo).matcher(fileDataInAString);


        //use yesterday's code.
        ArrayList<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group());
        }






        int totalSum = 0;
        boolean process = true; // Start with processing enabled, should be guranteed, the txt file is good

        // Loop through all matches and handle operations
        for (String match : matches) {
            if (match.equals("do()")) {
                process = true; //good to keep
            } else if (match.equals("don't()")) {
                process = false; //don't keep
            } else if (process && match.startsWith("mul")) {

                int startOfGoodPart = match.indexOf('(') + 1; // After '('
                int endOfGoodPart = match.indexOf(')');       // Before ')'
                String numbers = match.substring(startOfGoodPart, endOfGoodPart); // Get the "x,y"

                //USE METHOD FROM PART 1
                String[] parts = numbers.split(",");
                int firstNum = Integer.parseInt(parts[0]); // First number
                int secondNum = Integer.parseInt(parts[1]); // Second number

                // Multiply and add to total
                totalSum += firstNum * secondNum;
            }
        }

        return totalSum; // Return the total sum of valid multiplications
    }













    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }

    }
}