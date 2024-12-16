import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5.txt");
        System.out.println(getAnswer1(fileData));
    }

    public static int getAnswer1(ArrayList<String> fileData) {
        ArrayList<int[]> ruleList = new ArrayList<>();
        ArrayList<int[]> unsortedPageList = new ArrayList<>();
        ArrayList<int[]> passedRulePageList = new ArrayList<>();
        ArrayList<int[]> notPassedRulePageList=new ArrayList<>();

        int position = 0;

        // add the page ordering rules
        while (fileData.get(position).contains("|")) {
            String[] stringSplitLineList = fileData.get(position).split("\\|");

            // Each rule is represented as an array [X, Y]
            int[] rule = new int[]{Integer.parseInt(stringSplitLineList[0]), Integer.parseInt(stringSplitLineList[1])};
            ruleList.add(rule);
            position++;
        }

        // add the update pages
        for (int i = position; i < fileData.size(); i++) {
            String[] stringSplitLineList = fileData.get(i).split(",");
            int[] update = new int[stringSplitLineList.length];

            for (int j = 0; j < stringSplitLineList.length; j++) {
                update[j] = Integer.parseInt(stringSplitLineList[j]);
            }
            unsortedPageList.add(update);
        }




        // Check if each update follows the rules
        for (int i = 0; i < unsortedPageList.size(); i++) {
            boolean listPassed = true;
            int[] currentUpdate = unsortedPageList.get(i);

            for (int j = 0; j < currentUpdate.length; j++) {
                for (int k = 0; k < ruleList.size(); k++) {
                    int lessThan = ruleList.get(k)[0];
                    int greaterThan = ruleList.get(k)[1];

                    // Check if the current page violates any rules and add it to not passed list
                    if (containsPages(currentUpdate, lessThan, greaterThan) && !isValidOrder(currentUpdate, lessThan, greaterThan)) {
                        listPassed = false;
                        notPassedRulePageList.add(currentUpdate);
                        break;
                    }
                }
                if (!listPassed) break;
            }

            // If the update passed all rules, add it to the passed list
            if (listPassed) {
                passedRulePageList.add(currentUpdate);
            }
        }

        // Calculate the middle values
        int middleValues = 0;
        for (int[] passedUpdate : passedRulePageList) {
            middleValues += passedUpdate[passedUpdate.length / 2];
        }

        return middleValues;
    }



    //get the incorrect lists sorted and then add the middle values:

    //if the greater than place is less than the actual, just swap places.




    // Check if the array contains both page
    public static boolean containsPages(int[] array, int lessThan, int greaterThan) {
        boolean foundLessThan = false;
        boolean foundGreaterThan = false;
        for (int value : array) {
            if (value == lessThan) {
                foundLessThan = true;
            }
            if (value == greaterThan){
                foundGreaterThan = true;
            }
            if (foundLessThan && foundGreaterThan){
                return true;
            }
        }
        return false;
    }

    // Check if the order is valid
    public static boolean isValidOrder(int[] array, int lessThan, int greaterThan) {
        int indexLessThan = -1;
        int indexGreaterThan = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lessThan){
                indexLessThan = i;
            }
            if (array[i] == greaterThan) {
                indexGreaterThan = i;
            }
        }
        return indexLessThan < indexGreaterThan;
    }


    // Check if the order is valid and fix the list
    public static void isValidOrderFromWrongList(int[] array, int lessThan, int greaterThan) {
        int indexLessThan = -1;
        int indexGreaterThan = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lessThan){
                indexLessThan = i;
            }
            if (array[i] == greaterThan) {
                indexGreaterThan = i;
            }
        }
        boolean status=indexLessThan > indexGreaterThan;

        if(status){
            //NOW SWITCH PLACES

            Collections.swap(array, array.//(indexLessThan), array.//(indexGreaterThan));

        }

    }








    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty()) fileData.add(line);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return fileData;
    }
}