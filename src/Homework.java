import stanford.karel.SuperKarel;

public class Homework extends SuperKarel {
    private int width = 0;
    private int height = 0;
    private int moves = 0;
     int steps = 0;

    public void run() {
        width=0;
        height=0;
        moves=0;
        steps=0;
        setBeepersInBag(1000);
        calculateWidth();
        goBackToStart();
        calculateHeight();

        System.out.println("Width of the map: " + width);
        System.out.println("Height of the map: " + height);
        Divide();
        System.out.println("Number of moves: " + moves);
    }

    private void calculateWidth() {
        while (frontIsClear()) {
            move();
            width++;
            moves++;
        }
    }

    private void calculateHeight() {
        turnLeft();
        while (frontIsClear()) {
            move();
            height++;
            moves++;
        }
        turnAround();
        while (frontIsClear()) {
            move();
            moves++;
        }
        turnLeft();
    }

    private void goBackToStart() {
        turnAround();
        while (frontIsClear()) {
            move();
            moves++;
        }
        turnAround();
    }

    private void Divide() {

        if (width == 0 && height == 0 ||width == 1 && height == 1) {
            return;
        } else if (width == 0 || width==1) {
            divideSingleColumn();
        } else if (height == 0 || height==1) {
            divideSingleRow();
        } else {
            DivideIntoFour();
        }
    }

    private void DivideIntoFour() {
        if (width % 2 == 0 && height % 2 == 0) {
            Four(width,height);
        }
        else if(width % 2 == 0) {
            Four(width,height-1);
        }
        else if(height % 2 == 0) {
            Four(width-1,height);
        }
        else{
            Four(width-1,height-1);
        }
        /*
        while(steps+1>0)
        {
            move();
            steps--;
            moves++;

        }
        move();
        turnLeft();*/
    }

    private void Four(int x, int  y) {

        steps=x/2;

        while(steps>0)
        {
            move();
            steps--;
            moves++;
        }
        putBeeper();
        turnLeft();
        steps=y;
        while(steps>0)
        {
            move();
            putBeeper();
            steps--;
            moves++;
        }
        if (frontIsClear()) {
            move();
            putBeeper();
        }
        turnAround();
        steps=y/2;
        while(steps>0)
        {
            move();
            steps--;
            moves++;
        }
        turnLeft();
        steps=x/2;
        while(steps>0)
        {
            move();
            putBeeper();
            steps--;
            moves++;
        }
        if (frontIsClear()) {
            move();
            putBeeper();
        }
        turnAround();
        steps=x/2;
        while(steps>0)
        {
            move();
            steps--;
            moves++;
        }
        steps=x/2;
        move();
        while(steps>0)
        {
            if(frontIsClear()) {
                move();
                putBeeper();
                steps--;
                moves++;
            }
            else
            {
                putBeeper();
                steps--;
            }
        }
        turnAround();
        turnRight();

    }

    private void divideSingleColumn() {
        int counter = 2;
        if (height==2 ||height==3 )
        {
            turnLeft();
            int steps = height/2;

            while (steps > 0) {
                move();
                steps--;
            }
            putBeeper();
            turnRight();
            if(width==1)
            {
            move();
            putBeeper();
            }
        }
        else if(height>3&&width==1) {

            while(counter>0)
            {
                turnLeft();
                int steps = height/3;
                while (steps > 0) {

                    move();
                    steps--;

                }
                putBeeper();
                turnRight();
                move();
                putBeeper();
                turnLeft();
                move();
                turnRight();
                turnAround();
                move();
                turnAround();
                counter--;
            }
        }
        else if(height>3&&width==0){
            turnLeft();
            while (counter > 0) {
                int steps = height / 3;
                while (steps > 0) {

                    move();
                    steps--;

                }
                putBeeper();
                move();

                counter--;
            }
        }
        else{return;}
    }


    private void divideSingleRow() {
        int counter = 3;
        if (width == 2 || width == 3) {
            int steps = width / 2;

            while (steps > 0) {
                move();
                steps--;
            }
            putBeeper();
            turnLeft();
            if (height == 1) {
                move();
                putBeeper();
            }
        } else if (width > 3 && height == 1) {

            while (counter > 0) {
                int steps = width / 3;
                while (steps > 0) {

                    move();
                    steps--;

                }

                putBeeper();
                turnLeft();
                move();
                putBeeper();
                turnAround();
                move();
                //turnAround();
                turnLeft();
                if (frontIsClear())
                {
                move();
                }
                counter--;
            }
        } else if (width > 3 && height == 0) {
            while (counter > 0) {
                int steps = width / 3;
                if (frontIsClear()) {
                    while (steps > 0) {

                    move();
                    steps--;

                }

                    putBeeper();
                    move();
                }
                counter--;
            }
        } else {
            return;
        }
    }
}