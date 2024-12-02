import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        System.out.println(getAnswer(fileData));

    }

    public static int getAnswer(ArrayList<String> fileData) {
        String numberLeft="";
        String numberRight="";
        ArrayList<String> LeftList=new ArrayList<>();
        ArrayList<String> RightList=new ArrayList<>();
        ArrayList<Integer> LeftIntList=new ArrayList<>();
        ArrayList<Integer> RightIntList=new ArrayList<>();


        //put the data NOT CONVERTED INTO EACH DATA LIST
        for (int i = 0; i < fileData.size(); i++) {
                String numberUnsorted =fileData.get(i);
                String [] splitNumberUnsorted=numberUnsorted.split("   ");
                numberLeft=splitNumberUnsorted[0];
                numberRight=splitNumberUnsorted[1];
                LeftList.add(numberLeft);
                RightList.add(numberRight);
        }
        return -1;

        //convert to int
        for( int i=0; i < LeftList.size(); i++){
            int Leftnumber = Integer.parseInt(LeftList.get(i));
            int Rightnumber= Integer.parseInt(RightList.get(i));
            LeftIntList.add(Leftnumber);
            RightIntList.add(Rightnumber);

        }


        //sort each list





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