import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day4 {
    public static void main(String[] args) {




        ArrayList<String> fileData = getFileData("src/Day4.txt");
        System.out.println(getAnswer1(fileData));
        System.out.println(getAnswer2(fileData));


    }



    public static Integer getAnswer1(ArrayList<String> fileData) {

        int rows=fileData.size();
        int columns=fileData.get(0).length();
        String[][]allCharactersSeperated=new String[rows][columns];

        //every row
        for (int row = 0; row < allCharactersSeperated.length; row++) {
            //go down each column spot per row
            for (int column = 0; column < allCharactersSeperated[0].length; column++) {

                //now each spot is a string char in the arrayList is in a spot
                allCharactersSeperated[row][column] = fileData.get(row).substring(column, column +1);
            }
        }

        int goodCount=0;

        for (int row = 0; row < allCharactersSeperated.length; row++) {
            //go down each column spot per row
            for (int column = 0; column < allCharactersSeperated[0].length; column++) {
               //I HAVE TO CHECK UP,DOWN,LEFT,RIGHT,UPLEFT,UPRIGHT,DOWNLEFT,DOWNRIGHT



                //CHECK UP
                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row-1][column];
                    String thirdLetter = allCharactersSeperated[row-2][column];
                    String fourthLetter = allCharactersSeperated[row-3][column];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }


                //CHECK DOWN

                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row+1][column];
                    String thirdLetter = allCharactersSeperated[row+2][column];
                    String fourthLetter = allCharactersSeperated[row+3][column];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }

                //CHECK LEFT


                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row][column-1];
                    String thirdLetter = allCharactersSeperated[row][column-2];
                    String fourthLetter = allCharactersSeperated[row][column-3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }




                //CHECK RIGHT

                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row][column+1];
                    String thirdLetter = allCharactersSeperated[row][column+2];
                    String fourthLetter = allCharactersSeperated[row][column+3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }











            }
        }







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
                String numbers = match.substring(startOfGoodPart, endOfGoodPart);

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