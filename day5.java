import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5.txt");
        System.out.println(getAnswer1(fileData));
    }

    public static int getAnswer1(ArrayList<String> fileData) {
        // the input looks like 2d arrays so I have to make 2d arrays and not just one array
        List<int[]> ruleList = new ArrayList<>();
        List<int[]> unsortedPageList = new ArrayList<>();

        int position = 0;

        //while every line has | in it
        while (fileData.get(position).contains("|")) {
            String[] stringSplitLineList = fileData.get(position).split("\\|");

            //every rule is now a 2d array spot
            int[] rule = new int[]{Integer.parseInt(stringSplitLineList[0]), Integer.parseInt(stringSplitLineList[1])};
            //add it to the rule list
            ruleList.add(rule);
            position++;
        }



        // while every line has a comma in it, add each row with an array of nummbers in it THIS IS AFTER THE POSITION IS FINALIZED
        for (int i = position; i < fileData.size(); i++) {

            //each row is now array
            String[] stringSplitLineList = fileData.get(i).split(",");
            //array update now is a line length
            int[] update = new int[stringSplitLineList.length];
            //for each row I now have to put a spot from that line into update line spot
            for (int j = 0; j < stringSplitLineList.length; j++) {
                update[j] = Integer.parseInt(stringSplitLineList[j]);
            }
            unsortedPageList.add(update);
        }








    //get the middle of each line, it is odd
    public static int findMiddlePage(int[] update) {
        return update[update.length / 2];
    }










    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.add(line);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return fileData;
    }
}
