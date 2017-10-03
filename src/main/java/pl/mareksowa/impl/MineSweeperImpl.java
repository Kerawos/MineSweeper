package pl.mareksowa.impl;

public class MineSweeperImpl implements IMineSweeper {

    //declaring variables
    private int numberOfRows;
    private int rowLength;
    private String[][] multiMineFields;
    private int row;
    private int element;

//        Example mine-field string (as input to setMineField()): "*...\n..*.\n...."
//        * (a 3 x 4 mine-field of 12 squares, 2 of which are mines)

    //public method from interface
    public void setMineField(String mineField) throws IllegalArgumentException {
        //initialing variables
        numberOfRows = 0;
        rowLength = 0;
        multiMineFields = null;
        row = 0;
        element = 0;

        //check if mineFields contains rows
        if (!mineField.contains("\n")){
            throw new IllegalArgumentException("Entered Mine Field contains only one row");
        } else {
            //create multi dim array
            String[] mineFieldsRows = mineField.split("\n");
            rowLength = mineFieldsRows[0].length();
            for (String row : mineFieldsRows){
                numberOfRows++;
                if (!isFieldRowContainsCorrectedData(row)){
                    throw new IllegalArgumentException("Entered Mine Field contains illegal characters");
                }
                if (row.length() != rowLength){
                    throw new IllegalArgumentException("Mine Field is not square");
                }
            }
            multiMineFields = new String[numberOfRows][rowLength];
            for (int row = 0; row < numberOfRows; row++){
                //System.out.println("");
                for (int element = 0; element < rowLength; element++) {
                    multiMineFields[row][element] = String.valueOf(mineFieldsRows[row].charAt(element));
                    //System.out.print(multiMineFields[row][element]);
                }
            }
        }
        //System.out.println("\n\nnumberOfRows: " + numberOfRows + ",  rowLength: " + rowLength);
    }

//sample below
/*
    *---
    --*-
    ----

    *211
    12*1
    0111
*/
    //public method from interface
    public String getHintField() throws IllegalArgumentException {
        StringBuilder hintField = new StringBuilder();

        //first check filed
        if (multiMineFields==null){
            throw new IllegalArgumentException("Mine-field has not been initialised");
        }
        //checks
        for (int i = 0; i <numberOfRows; i++) {
            row = i;
            //add new line if necessary
            if (hintField.toString().length()>0){
                hintField.append("\n");
            }
            //create hint field
            for (int j = 0; j < rowLength ; j++) {
                element = j;
                //check if field contain mine
                if(multiMineFields[row][element].contains("*")){
                    hintField.append("*");
                } else{
                //check if around mine appear (8 fields around)
                    int nearestMines = 0;
                    nearestMines+=checkIfMineIsAdjacent(-1, -1);
                    nearestMines+=checkIfMineIsAdjacent(-1, 0);
                    nearestMines+=checkIfMineIsAdjacent(-1, +1);
                    nearestMines+=checkIfMineIsAdjacent(0, -1);
                    nearestMines+=checkIfMineIsAdjacent(0, +1);
                    nearestMines+=checkIfMineIsAdjacent(+1, -1);
                    nearestMines+=checkIfMineIsAdjacent(+1, 0);
                    nearestMines+=checkIfMineIsAdjacent(+1, +1);
                    hintField.append(String.valueOf(nearestMines));
                }
            }
        }
        return hintField.toString();
    }

    private boolean isFieldRowContainsCorrectedData(String singleFieldsRow){
        char[] array = singleFieldsRow.toCharArray();
        for (char element : array) {
            if (element!='.' && element!='*'){
                System.out.println(element);
                return false;
            }
        }
        return true;
    }

    private int checkIfMineIsAdjacent(int rowShift, int elementShift){
        //check if row are beyond bounds
        if ((row+rowShift) >= multiMineFields.length || (row+rowShift) < 0){
            //row index beyond array
            return 0;
        } else if ((element+elementShift) >= multiMineFields[(row)].length || (element+elementShift) < 0){
            //element index out of array
            return 0;
        } else {
            if (multiMineFields[row+rowShift][element+elementShift].equals("*")){
                return 1;
            }
        }
        return 0;
    }
}
