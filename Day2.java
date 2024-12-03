import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2.txt");
        System.out.println(getAnswer(fileData));

    }



    public static Integer getAnswer(ArrayList<String> fileData) {
       int safe=0;

       //for each line of filedata, we need to convert that to an integer list
        for(String line:fileData){


            ArrayList<Integer>temporaryLineList=new ArrayList<Integer>();


            //makes string array of A LINE
            String[] stringSplitLineList=line.split(" ");

            //makes temporaryLineList
            for (String s : stringSplitLineList) {
                int eachLineNumber = Integer.parseInt(s);
                temporaryLineList.add(eachLineNumber);
            }

            for(int i=0;i<temporaryLineList.size();i++){
                int firstNumber=temporaryLineList.get(i);
                if(i==temporaryLineList.size()-1){
                    int secondNumber=-1000;

                }else{
                    int secondNumber=temporaryLineList.get(i+1);
                }



            }









        }
        return safe;
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