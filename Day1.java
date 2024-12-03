import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        System.out.println(getAnswer(fileData));

    }

    public static String getAnswer(ArrayList<String> fileData) {
        ArrayList<String> LeftList = new ArrayList<>();
        ArrayList<String> RightList = new ArrayList<>();
        ArrayList<Integer> LeftIntList = new ArrayList<>();
        ArrayList<Integer> RightIntList = new ArrayList<>();

        // Put the data NOT CONVERTED INTO EACH DATA LIST
        for (String numberUnsorted : fileData) {
            String[] splitNumberUnsorted = numberUnsorted.split("   ");
            LeftList.add(splitNumberUnsorted[0]);
            RightList.add(splitNumberUnsorted[1]);
        }

        // Convert to int
        for (int i = 0; i < LeftList.size(); i++) {
            int Leftnumber = Integer.parseInt(LeftList.get(i));
            int Rightnumber = Integer.parseInt(RightList.get(i));
            LeftIntList.add(Leftnumber);
            RightIntList.add(Rightnumber);
        }

        // Sort each list
        Collections.sort(LeftIntList);
        Collections.sort(RightIntList);

        // Part 1
        int totalPart1 = 0;
        for (int i = 0; i < LeftIntList.size(); i++) {
            totalPart1 += Math.abs(LeftIntList.get(i) - RightIntList.get(i));
        }

        // Part 2
        int similarityTotal = 0;

        //for each left num in the left int list
        for (int leftNum : LeftIntList) {
            //check for how many times for each left int
            int timesForLeftNum = 0;
            //go through every time it happens in right num
            for (int rightNum : RightIntList) {
                //if it equals then do plus 1
                if (leftNum == rightNum) {
                    timesForLeftNum++;
                }
            }
            similarityTotal += leftNum * timesForLeftNum;
            //resets after this whole thing is done, and go on to the second num in left list
        }

        // Return results as a single string
        return "Answer for part 1 (absolute differences): " + totalPart1 +
                "\nAnswer for part 2 (similarity score): " + similarityTotal;
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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }




}