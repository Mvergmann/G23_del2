package Tilegame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BalanceTest {
    @Test
    @DisplayName("Test for balance going negativ")
    void positivebalance(){
        /**Setup
         * Below are 4 variables that are used in the test
         * STARTSALDO is the int value of the Test players bank
         * navn1 is the  String that is set as "Test" in the scenario
         * fail is the tallys up the times the balance goes below 0
         * testamount counts how many times the test player has rolled the dice
         */
        int STARTSALDO = 1000;
        String navn1 = "Test";
        int fail = 0;
        int testamount = 0;
        /**
         * The following for loop runs a game turn a set amount of times in this case 50000
         * Run
         */
        for (int i = 0; i < 5000000;i++){

            /**
             * Here an instance of the classes Player, TileList, and Turn is created
             */
            var player1 = new Player(navn1, STARTSALDO);
            var Tlmain = new TileList();
            var p1tur = new Turn();


            /**
             * These two lines roll the dice and update the balance based on what space on the gameboard(array)
             * the player has landed on
             */
            int roll1 = p1tur.tur();
            int balance =  player1.AddToSaldo(Tlmain.getValue(roll1));

            /**Control
             * The if loop checks that the balance is still a postive int
             * if the balance < 0 the program will break from the for loop
             *
             */
            if(balance < 0){
                System.out.println("Error negativ balance");
                fail++;
                break;
            }
            /**
             * This incriments the testamount each time the loop finishes
             */
            testamount++;
        }
        /**
         * asserEquals checks the expected int of 0 failures where the balance goes below 0 and checks if it is equals
         * the amount of times the if (balance < 0) has occured
         */
        assertEquals(0,fail);

        /**
         * These lines merely print the amount of failures
         * and the testamount
         */
        System.out.println("Test has concluded " + fail + " fails");
        System.out.println("Testet over " + testamount);

    }


}
