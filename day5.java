import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5.txt");
        System.out.println(getAnswer1(fileData));
    }

    public static int getAnswer1(ArrayList<String> fileData) {
        // the input looks like 2d arrays so I have to make 2d arrays and not just one array
        ArrayList<int[]> ruleList = new ArrayList<>();
        ArrayList<int[]> unsortedPageList = new ArrayList<>();
        ArrayList<int[]> passedRulePageList = new ArrayList<>();

        int position = 0;


        //[[x,y],[x2,y2]
        //while every line has | in it
        while (fileData.get(position).contains("|")) {
            String[] stringSplitLineList = fileData.get(position).split("\\|");

            //every rule is now a 2d array spot
            int[] rule = new int[]{Integer.parseInt(stringSplitLineList[0]), Integer.parseInt(stringSplitLineList[1])};
            //add it to the rule list
            ruleList.add(rule);
            position++;
        }


        //[[a,b,c,d],[a2,b2,c2,d2]]
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








        //check if it passes the rule check,NO NEED TO SORT IT OUT:

        // check every unsortedRuleList
        for(int i=0;i<unsortedPageList.size();i++ ){

            //inital state of being true
            boolean listPassed=true;

            //for every list, we need to check each spot
            for (int x=0; x < (unsortedPageList.get(i)).length ;x++){
                //now I have to check each rule, and confirm it. if it is not then no add, or else add

                //loop through each rule list:
                for(int y=0;y<ruleList.size();y++){
                    //make temporary variables
                    int lessThanPlaceInList=ruleList.get(y)[0];
                    int greaterThanPlaceInList=ruleList.get(y)[1];
                    int  currentSpot=unsortedPageList.get(i)[x];
                    if(currentSpot!=lessThanPlaceInList||currentSpot!=greaterThanPlaceInList){
                        continue;
                    }else{

                        //NOW ACTUALLY CHECK THE RULE
                        if(currentSpot==(lessThanPlaceInList) && !listPassed){
                            //if statement if the current spot is a greaterThan placelist and check if it is grater then the lessthan place list, or else false
                            if(unsortedPageList.indexOf(currentSpot)<unsortedPageList.indexOf(greaterThanPlaceInList)){
                                listPassed=true;
                            }else{
                                listPassed=false;
                                continue;
                            }
                        }else{
                            //if statement is a less than spot, check if it is less than the grater spot, or else false
                            if(unsortedPageList.indexOf(currentSpot)>unsortedPageList.indexOf(lessThanPlaceInList)&&listPassed==false){
                                listPassed=true;
                            }else{
                                listPassed=false;
                                continue;
                            }
                        }
                    }
                    if(listPassed==true){
                        passedRulePageList.add(unsortedPageList.get(i));
                    }
                }

            }

        }



        int middleValues=0;
        for(int i=0;i<passedRulePageList.size();i++){
            middleValues+=  passedRulePageList.get(i)[(passedRulePageList.get(i).length)/2];
        }
        return middleValues;
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