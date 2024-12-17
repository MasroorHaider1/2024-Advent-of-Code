import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day5 {

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day5.txt");
        String result = getAnswers(fileData);
        System.out.println(result);
    }

    public static String getAnswers(ArrayList<String> fileData) {
        // Get the answers for Part 1 and Part 2
        int part1Answer = getAnswer1(fileData);
        int part2Answer = getAnswer2(fileData);

        // Combine the results into a single string
        return "Part 1: " + part1Answer + ", Part 2: " + part2Answer;
    }

    public static int getAnswer1(ArrayList<String> fileData) {
        ArrayList<int[]> ruleList = new ArrayList<>();
        ArrayList<int[]> unsortedPageList = new ArrayList<>();
        ArrayList<int[]> passedRulePageList = new ArrayList<>();

        int position = 0;

        // Add the page ordering rules
        while (fileData.get(position).contains("|")) {
            String[] stringSplitLineList = fileData.get(position).split("\\|");
            int[] rule = new int[]{Integer.parseInt(stringSplitLineList[0]), Integer.parseInt(stringSplitLineList[1])};
            ruleList.add(rule);
            position++;
        }

        // Add the update pages
        for (int i = position; i < fileData.size(); i++) {
            String[] stringSplitLineList = fileData.get(i).split(",");
            int[] update = new int[stringSplitLineList.length];
            for (int j = 0; j < stringSplitLineList.length; j++) {
                update[j] = Integer.parseInt(stringSplitLineList[j]);
            }
            unsortedPageList.add(update);
        }

        // Check if each update follows the rules
        for (int[] currentUpdate : unsortedPageList) {
            boolean listPassed = true;
            for (int[] rule : ruleList) {
                int lessThan = rule[0];
                int greaterThan = rule[1];

                // Check if the current page violates any rules
                if (containsPages(currentUpdate, lessThan, greaterThan) &&
                        !isValidOrder(currentUpdate, lessThan, greaterThan)) {
                    listPassed = false;
                    break;
                }
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

    public static int getAnswer2(ArrayList<String> fileData) {
        ArrayList<int[]> ruleList = new ArrayList<>();
        ArrayList<int[]> unsortedPageList = new ArrayList<>();
        ArrayList<int[]> notPassedRulePageList = new ArrayList<>();

        int position = 0;

        // Add the page ordering rules
        while (fileData.get(position).contains("|")) {
            String[] stringSplitLineList = fileData.get(position).split("\\|");
            int[] rule = new int[]{Integer.parseInt(stringSplitLineList[0]), Integer.parseInt(stringSplitLineList[1])};
            ruleList.add(rule);
            position++;
        }

        // Add the update pages
        for (int i = position; i < fileData.size(); i++) {
            String[] stringSplitLineList = fileData.get(i).split(",");
            int[] update = new int[stringSplitLineList.length];
            for (int j = 0; j < stringSplitLineList.length; j++) {
                update[j] = Integer.parseInt(stringSplitLineList[j]);
            }
            unsortedPageList.add(update);
        }

        // Check if each update does not follow the rules
        for (int[] currentUpdate : unsortedPageList) {
            boolean listPassed = true;
            for (int[] rule : ruleList) {
                int lessThan = rule[0];
                int greaterThan = rule[1];

                // Check if the current page violates any rules
                if (containsPages(currentUpdate, lessThan, greaterThan) &&
                        !isValidOrder(currentUpdate, lessThan, greaterThan)) {
                    listPassed = false;
                    notPassedRulePageList.add(currentUpdate);
                    break;
                }
            }
        }

        // Sort incorrectly ordered lists and calculate middle values
        int middleValuesSum = 0;
        for (int[] incorrectUpdate : notPassedRulePageList) {
            boolean swapped;
            do {
                swapped = false;
                for (int[] rule : ruleList) {
                    int lessThan = rule[0];
                    int greaterThan = rule[1];

                    // Find places of lessThan and greaterThan in the array
                    int indexLessThan = -1;
                    int indexGreaterThan = -1;

                    for (int i = 0; i < incorrectUpdate.length; i++) {
                        if (incorrectUpdate[i] == lessThan) {
                            indexLessThan = i;
                        }
                        if (incorrectUpdate[i] == greaterThan) {
                            indexGreaterThan = i;
                        }
                    }

                    // Swap if the order is incorrect
                    if (indexLessThan != -1 && indexGreaterThan != -1 && indexLessThan > indexGreaterThan) {
                        int temp = incorrectUpdate[indexLessThan];
                        incorrectUpdate[indexLessThan] = incorrectUpdate[indexGreaterThan];
                        incorrectUpdate[indexGreaterThan] = temp;
                        swapped = true; // Indicate a swap occurred
                    }
                }
            } while (swapped); // Repeat until no more swaps are needed

            // Add the middle value of the corrected list to the sum
            middleValuesSum += incorrectUpdate[incorrectUpdate.length / 2];
        }

        return middleValuesSum;
    }









    // Check if the array contains both pages
    public static boolean containsPages(int[] array, int lessThan, int greaterThan) {
        boolean foundLessThan = false;
        boolean foundGreaterThan = false;
        for (int value : array) {
            if (value == lessThan) foundLessThan = true;
            if (value == greaterThan) foundGreaterThan = true;
            if (foundLessThan && foundGreaterThan) return true;
        }
        return false;
    }


    // Check if the order is valid
    public static boolean isValidOrder(int[] array, int lessThan, int greaterThan) {
        int indexLessThan = -1;
        int indexGreaterThan = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lessThan) indexLessThan = i;
            if (array[i] == greaterThan) indexGreaterThan = i;
        }
        return indexLessThan < indexGreaterThan;
    }

    // Read file data
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
