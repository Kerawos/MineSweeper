package pl.mareksowa.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MineSweeperImplTest {

    private static MineSweeperImpl mineSweeper;

    @BeforeClass
    public static void start(){
        mineSweeper = new MineSweeperImpl();
    }

    @AfterClass
    public static void stop(){
        mineSweeper = null;
    }

    @Test
    public void compareFieldWithHint_1() {
        //1st test
        String mineField = "*...\n..*.\n....";
        String hintFieldExpected = "*211\n12*1\n0111";
        String hintField = null;
        mineSweeper.setMineField(mineField);
        hintField = mineSweeper.getHintField();
        assertEquals(hintField, hintFieldExpected);
        //System.out.println("Created 1st mine-field: \n" + mineField + "\n");
        //System.out.println("created 1st hint-field: \n" + hintField + "\n\n");
    }

    @Test
    public void compareFieldWithHint_2() {
        //2nd test
        String mineField2 = "..*...*\n...*..*\n*..*..*\n*..*..*\n*..*..*";
        String hintField2Expected = "01*212*\n123*23*\n*23*33*\n*33*33*\n*22*22*";
        String hintField2 = null;
        mineSweeper.setMineField(mineField2);
        hintField2 = mineSweeper.getHintField();
        assertEquals(hintField2, hintField2Expected);
        //System.out.println("Created 2nd mine-field: \n" + mineField2 + "\n");
        //System.out.println("created 2nd hint-field: \n" + hintField2 + "\n\n");
    }

    @Test
    public void compareFieldWithHint_3() {
        //3rd test
        String mineField3 = "..*..........*\n...*..........";
        String hintField3Expected = "01*2100000001*\n012*1000000011";
        String hintField3 = null;
        mineSweeper.setMineField(mineField3);
        hintField3 = mineSweeper.getHintField();
        assertEquals(hintField3, hintField3Expected);
        //System.out.println("Created 3rd mine-field: \n" + mineField3 + "\n");
        //System.out.println("created 3rd hint-field: \n" + hintField3 + "\n\n");
    }

    @Test
    public void compareFieldWithHint_4() {
        //4th test - not corrected
        String mineField4 = "..*\n...";
        String hintField4Expected = "01*\n012"; // should be "01*\n011"
        String hintField4 = null;
        mineSweeper.setMineField(mineField4);
        hintField4 = mineSweeper.getHintField();
        assertEquals(hintField4, hintField4Expected);
    }

}