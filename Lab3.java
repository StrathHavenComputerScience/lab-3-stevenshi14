public class Lab3 extends Robot
{
    public static void testLightCandles1()
    {
        Robot.load("candles1.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles2()
    {
        Robot.load("candles2.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void lightCandles()
    {
        //insert instructions below
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();

    }

    //Run this method to test completeRoom on map room1.txt
    public static void testCompleteRoom1()
    {
        Robot.load("room1.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    //Run this method to test completeRoom on map room2.txt
    public static void testCompleteRoom2()
    {
        Robot.load("room2.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    //Complete this method.  You will need to write additional helper methods.
    public static void completeRoom()
    {
        //insert instructions below
        fillBorderRight();
        turnRight();
        fillBorderRight();
        turnRight();
        fillBorderRight();
        turnRight();
        fillBorderRight();

    }

    //Run this method to test swapAll on map swap1.txt
    public static void testSwapAll1()
    {
        Robot.load("swap1.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Run this method to test swapAll on map swap2.txt
    public static void testSwapAll2()
    {
        Robot.load("swap2.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Complete this method.  You will need to write additional helper methods.
    public static void swapAll()
    {
        //insert instructions below
        swapRow();
        move();
        swapRow();
        move();
        swapRow();
        move();
        swapRow();
        move();
        swapRow();
        move();
        swapRow();
        move();
        swapRow();
        move();
        swapRow();
        move();
        swapRow();
        move();
        swapRow();

    }
    //Don't run these. I will!
    public static void testLightCandles3()
    {
        Robot.load("candles3.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles4()
    {
        Robot.load("candles4.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testCompleteRoom3()
    {
        Robot.load("room3.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testCompleteRoom4()
    {
        Robot.load("room4.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testSwapAll3()
    {
        Robot.load("swap3.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Run this method to test swapAll on map swap2.txt
    public static void testSwapAll4()
    {
        Robot.load("swap4.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    public static void turnRight(){
        //precon: robot is facing anydirection
        //postcon: robot is facing 90 deg clockwise from original direction
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public static void strafeUpRight(){
        //precon: facing right, cell is clear up
        //post cond: facing right, up on cell above it before
        turnLeft();
        move();
        turnRight();
    }

    public static void checkCandleHeight(){
        //precon: facing bottom of candle stick to the right
        //postcon: "lights" candle, ends at top facing right
        strafeUpRight();
        if (frontIsClear()){
            move();
            makeDark();
        } else{
            strafeUpRight();
            move();
            makeDark();
        }
    }

    public static void moveEnd(){
        //precon: facing any direction 
        //postcon: facing the same direction before, all the way to the end of cells it was facing
        while (frontIsClear()){
            move();
        }
    }

    public static void moveCandleBottom(){
        //precon: on candlestick flame
        //postcon: on bottom of candle right
        move();
        turnRight();
        moveEnd();
        turnLeft();
    }

    public static void lightCandle(){
        //precon: facing bottom of candle stick to the right
        //postcon: on bottom of candle right
        checkCandleHeight();
        moveCandleBottom();
    }

    public static void checkBorderRight(){
        //precon: is facing any direction
        //postcon: stil on original cell, if there was a cell next to it, it is dark. If not, nothing changes
        turnLeft();
        if(frontIsClear()){
            move();
            if(onDark()){
                //lol nothing
            } else{
                makeDark();
            }
            turnLeft();
            turnLeft();
            move();
            turnLeft();
        } else{
            turnRight();
        }
    }

    public static void fillBorderRight(){
        //precon: robot is facing 4 open cells, with a right border
        //postcon: robot is on 4th cell (end), with right border filled
        checkBorderRight();
        move();
        checkBorderRight();
        move();
        checkBorderRight();
        move();
        checkBorderRight();
        move();
        checkBorderRight();
    }

    public static void turnAround(){
        //precon: robot is facing any direction
        //postcon: robot is facing opposite direction 
        turnLeft();
        turnLeft();
    }

    public static void swapRight(){
        //precon: robot has two cells on both sides of it
        //postcon: robot is on cell that is on its left, facing left. two cells that were beside it in precon has colors swapped
        turnLeft();
        move();
        if(onDark()){
            turnAround();
            move();
            move();
            if(onDark()){
                swapLeftDark();
            } else{
                makeDark();
                swapLeftLight();
            } 
        } else{
            turnAround();
            move();
            move();
            if(onDark()){
                makeLight();
                swapLeftDark();
            } else{
                swapLeftLight();
            }
        }
    }

    public static void swapLeftLight(){
        //precon: robot is facing right, with 2 cells behind it
        //postcon: robot is facing left, on 2nd cell that was behind it, 2nd cell is light
        turnAround();
        move();
        move();
        if(onDark()){
            makeLight();
        }
    }

    public static void swapLeftDark(){
        //precon: robot is facing right, with 2 cells behind it
        //postcon: robot is facing left, on 2nd cell that was behind it, 2nd cell is dark
        turnAround();
        move();
        move();
        if(onDark()){
            //nothing lol
        } else{
            makeDark();
        }
    }

    public static void swapRow(){
        //precon: robot has two cells beside it
        //postcon: robot is at origin pos, two cell's colors are swapped
        swapRight();
        turnAround();
        move();
        turnLeft();
    }
}
