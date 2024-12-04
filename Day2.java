import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2.txt");
        System.out.println(getAnswer(fileData));

    }

    public static Integer getAnswer(ArrayList<String> fileData) {
        int safe = 0;

        //for each line of filedata, we need to convert that to an integer list
        for (String line : fileData) {

            ArrayList<Integer> temporaryLineList = new ArrayList<Integer>();

            //makes string array of A LINE
            String[] stringSplitLineList = line.split(" ");

            //makes temporaryLineList
            for (String s : stringSplitLineList) {
                int eachLineNumber = Integer.parseInt(s);
                temporaryLineList.add(eachLineNumber);
            }

            //check if line good
            if (isSafe(temporaryLineList)) {
                safe++;
            }

        }



        //part 1
        return safe;


    }






    public static boolean isSafe(ArrayList<Integer> temporaryLineList) {

        //used Mr.Das strat of checking if all is negative or positive
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        //for each difference in the list, I have to check if it was like before, -1 because it could be odd
        for (int i = 0; i < temporaryLineList.size() - 1; i++) {
            int diff = temporaryLineList.get(i + 1) - temporaryLineList.get(i);

            //if the difference is out of range, no good, automatically gone
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            //if a positive difference shows, it cant be decreasing
            if (diff > 0) {
                isDecreasing = false;
            }

            //if a negative difference shows, it cant be increasing
            if (diff < 0) {
                isIncreasing = false;
            }

            // FOR EVERY TEST, IT SHOULD ONLY CONSISTTENLY KEEP ONE BEING FALSE, IF BOTH FALSE, THEN NO.
        }

        //return true only if  all increasing or all decreasing
        return isIncreasing || isDecreasing;
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
