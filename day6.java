import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/day6.txt");
        System.out.println(getAnswer(fileData));

    }

    public static String getAnswer(ArrayList<String> fileData) {
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




    }



    public static Boolean canYouMoveOneSpot(String[][]testCase,Integer testplacex,Integer testplacey){

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