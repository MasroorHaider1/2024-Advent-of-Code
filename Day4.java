import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day4 {
    public static void main(String[] args) {




        ArrayList<String> fileData = getFileData("src/Day4.txt");
        System.out.println(getAnswer1(fileData));
        System.out.println(getAnswer2(fileData));


    }



    public static Integer getAnswer1(ArrayList<String> fileData) {

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




        int goodCount=0;

        for (int row = 0; row < allCharactersSeperated.length; row++) {
            //go down each column spot per row
            for (int column = 0; column < allCharactersSeperated[0].length; column++) {
                //I HAVE TO CHECK UP,DOWN,LEFT,RIGHT,UPLEFT,UPRIGHT,DOWNLEFT,DOWNRIGHT



                //CHECK UP
                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row-1][column];
                    String thirdLetter = allCharactersSeperated[row-2][column];
                    String fourthLetter = allCharactersSeperated[row-3][column];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }


                //CHECK DOWN

                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row+1][column];
                    String thirdLetter = allCharactersSeperated[row+2][column];
                    String fourthLetter = allCharactersSeperated[row+3][column];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }

                //CHECK LEFT


                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row][column-1];
                    String thirdLetter = allCharactersSeperated[row][column-2];
                    String fourthLetter = allCharactersSeperated[row][column-3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }




                //CHECK RIGHT

                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row][column+1];
                    String thirdLetter = allCharactersSeperated[row][column+2];
                    String fourthLetter = allCharactersSeperated[row][column+3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                }
                catch (Exception e) {
                    goodCount+=0;
                }


                // CHECK UP-RIGHT
                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row - 1][column + 1];
                    String thirdLetter = allCharactersSeperated[row - 2][column + 2];
                    String fourthLetter = allCharactersSeperated[row - 3][column + 3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                } catch (Exception e) {
                    goodCount += 0;
                }

                // CHECK DOWN-RIGHT
                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row + 1][column + 1];
                    String thirdLetter = allCharactersSeperated[row + 2][column + 2];
                    String fourthLetter = allCharactersSeperated[row + 3][column + 3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                } catch (Exception e) {
                    goodCount += 0;
                }

                // CHECK UP-LEFT
                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row - 1][column - 1];
                    String thirdLetter = allCharactersSeperated[row - 2][column - 2];
                    String fourthLetter = allCharactersSeperated[row - 3][column - 3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                } catch (Exception e) {
                    goodCount += 0;
                }

                // CHECK DOWN-LEFT
                try {
                    String firstLetter = allCharactersSeperated[row][column];
                    String secondLetter = allCharactersSeperated[row + 1][column - 1];
                    String thirdLetter = allCharactersSeperated[row + 2][column - 2];
                    String fourthLetter = allCharactersSeperated[row + 3][column - 3];
                    String word = firstLetter + secondLetter + thirdLetter + fourthLetter;
                    if (word.equals("XMAS"))
                        goodCount++;
                } catch (Exception e) {
                    goodCount += 0;
                }












            }
        }




















        return goodCount;







    }




    public static Integer getAnswer2(ArrayList<String> fileData) {
        int totalSum = 0;

        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] allCharactersSeperated = new String[rows][columns];

        // fill grid in like last time
        for (int row = 0; row < allCharactersSeperated.length; row++) {
            for (int column = 0; column < allCharactersSeperated[0].length; column++) {
                allCharactersSeperated[row][column] = fileData.get(row).substring(column, column + 1);
            }
        }

        // Check  X patten
        for (int row = 1; row < allCharactersSeperated.length - 1; row++) {
            for (int column = 1; column < allCharactersSeperated[0].length - 1; column++) {
                try {
                    // check if center is a
                    if (!allCharactersSeperated[row][column].equals("A")) {
                        continue;
                    }

                    //check the "\" part of x
                    String upLeft = allCharactersSeperated[row - 1][column - 1];
                    String downRight = allCharactersSeperated[row + 1][column + 1];
                    String firstDiagonal = upLeft + "A" + downRight;



                    // Check the "/" part of x
                    String upRight = allCharactersSeperated[row - 1][column + 1];
                    String downLeft = allCharactersSeperated[row + 1][column - 1];
                    String secondDiagonal = upRight + "A" + downLeft;

                    // check both scenarios
                    if ((firstDiagonal.equals("MAS") || firstDiagonal.equals("SAM")) &&
                            (secondDiagonal.equals("MAS") || secondDiagonal.equals("SAM"))) {
                        totalSum++;
                    }


                } catch (Exception e) {
                    // skip
                }
            }
        }

        return totalSum; //return total
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