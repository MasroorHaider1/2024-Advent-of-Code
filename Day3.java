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