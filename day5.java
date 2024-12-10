import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/day5.txt");
        System.out.println(getAnswer1(fileData));

    }

    public static String getAnswer1(ArrayList<String> fileData) {
        ArrayList<Integer> ruleList = new ArrayList<Integer>();
        ArrayList<Integer> unsortedPageList = new ArrayList<Integer>();


        //set position as 0 for now
        int position=0;
        //get data list of all rule orders, and do this until there is a gap in the data list
        do{

            //split each number in each line
            String[] stringSplitLineList = fileData.get(position).split("\\|");
            //in each temp array string thing
            for (String s : stringSplitLineList) {
                int eachLineNumber = Integer.parseInt(s);
                ruleList.add(eachLineNumber);
            }
            position++;

        }while(fileData.get(position).contains("|"));


        //MAKE WHATEVER THIS IS HAVE A 2D ARRAY

        //set position as 0 for now
        int position2=0;
        //get data list of all rule orders, and do this until there is a gap in the data list
        do{

            //split each number in each line
            String[] stringSplitLineList = fileData.get(position).split(",");
            //in each temp array string thing
            for (String s : stringSplitLineList) {
                int eachLineNumber = Integer.parseInt(s);
                ruleList.add(eachLineNumber);
            }
            position++;

        }while(fileData.get(position2).contains(","));















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