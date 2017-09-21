package pl.mareksowa;

import pl.mareksowa.impl.MineSweeperImpl;

public class AppStarter {

    public static void main(String[] args) {

        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        //Example mine-field string (as input to setMineField()): "*...\n..*.\n...."
        /*
            *---
            --*-
            ----

            *211
            12*1
            0111
        */

        //1st test
        String mineField = "*...\n..*.\n....";
        String hintField = null;
            mineSweeper.setMineField(mineField);
            hintField = mineSweeper.getHintField();
                System.out.println("Created 1st mine-field: \n" + mineField + "\n");
                System.out.println("created 1st hint-field: \n" + hintField + "\n\n");

        //2nd test
        String mineField2 = "..*...*\n...*..*\n*..*..*\n*..*..*\n*..*..*";
        String hintField2 = null;
            mineSweeper.setMineField(mineField2);
            hintField2 = mineSweeper.getHintField();
                System.out.println("Created 2nd mine-field: \n" + mineField2 + "\n");
                System.out.println("created 2nd hint-field: \n" + hintField2 + "\n\n");

        //3rd test
        String mineField3 = "..*..........*\n...*..........";
        String hintField3 = null;
            mineSweeper.setMineField(mineField3);
            hintField3 = mineSweeper.getHintField();
                System.out.println("Created 3rd mine-field: \n" + mineField3 + "\n");
                System.out.println("created 3rd hint-field: \n" + hintField3 + "\n\n");

    }
}
