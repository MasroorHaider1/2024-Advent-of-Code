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
        int totalSum=0;


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


        // x shape search


        for (int row = 0; row < allCharactersSeperated.length; row++) {
            //go down each column spot per row
            for (int column = 0; column < allCharactersSeperated[0].length; column++) {
                //I HAVE TO CHECK NOT SURE, MAYBE 3 lines minimally needed

                try {
                    String centerLetter = allCharactersSeperated[row][column];


                    String firstLetterLeft = allCharactersSeperated[row-1][column-1];
                    String thirdLetterLeft = allCharactersSeperated[row+1][column+1];

                    String firstLetterRight = allCharactersSeperated[row+1][column-1];
                    String thirdLetterRight = allCharactersSeperated[row-1][column+1];






                   String wordRight=firstLetterRight+centerLetter+thirdLetterRight;
                   String wordLeft=firstLetterRight+centerLetter+thirdLetterLeft;




                    if (     (wordRight.equals("MAS")&& wordLeft.equals("MAS")) || (wordRight.equals("SAM")&& wordLeft.equals("SAM")) )
                        totalSum++;

                }
                catch (Exception e) {
                    totalSum+=0;
                }












            }
        }
        return totalSum; // Return the total sum of x shapes found
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