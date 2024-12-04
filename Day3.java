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



    public static String getAnswer1(ArrayList<String> fileData) {
        ArrayList<String> allMatchesFound = new ArrayList<String>();
        String fileDataInAString = "";
        for (String line : fileData) {
            fileDataInAString += line;
        }

        // the \\ escapes the argument?
        String goodPart= "mul\\([0-999],[0,999]\\)";
        Matcher m = Pattern.compile(goodPart).matcher(fileDataInAString);

        while (m.find()) {
            allMatchesFound.add(m.group());
        }

        for(int i=0;i<allMatchesFound.size();i++){
            System.out.println();
        }


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