package Tilegame;

import java.util.Scanner;

public class Main {
    public static final int STARTSALDO = 1000;  // The money that every player starts with
    /*
    Start the game.
    First thing we do in our main is defining all our different objects
    we make a scanner
    We define what the 2 players name is
    We make a player objekt to both the players that contains both name and saldo
    We make 2 tur objects
    We make a tile list object
    And a language object that we use to get alle the text that we need to print out
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(Language.getWelcome_to_the_game_());
        System.out.println(Language.Getname1());
        String navn1 = scan.nextLine();
        Player player1 = new Player(navn1, STARTSALDO);     //Defining the first players object as player1
        System.out.println(Language.GetName2());
        String navn2 = scan.nextLine(); //
        Player player2 = new Player(navn2, STARTSALDO);     //Defining the second players object as player2
        System.out.println(Language.getWelcome_to_the_game_() + player1.toString() + Language.and() + player2.toString());
        Turn p1tur = new Turn();
        Turn p2tur = new Turn();
        TileList Tlmain = new TileList();   // Defining a tile list object where we can use our array
        Language Langmain = new Language();     // Defining a language object where we can call all the text
        /*
        We make a while loop that loops until one of the players reach 3000 or over in their saldo.
        Input enter is so the person can "start" the game
        We make a roll and gets a sum that we save in roll1
        We tell the player what they have rolled, what tile they have hit, what it does, what they lose or get.
        Then we add the amount to the players saldo and tell the player.
         */
        while (player1.GetSaldo() < 3000 && player2.GetSaldo() < 3000) {
            System.out.println(" ");
            System.out.println(Language.It_Is() + navn1 + Language.S_Turn_Press_Enter_To_Roll_The_Dice());
            Input.enter();
            int roll1 = p1tur.tur(); //rolls the dices and get an sum of the two dices.
            System.out.println(Language.getYouRolled() + roll1);
            System.out.println(Language.You_Landed_On_The_Tile() + Tlmain.getTitle(roll1));
            System.out.println(Tlmain.getFlavourText(roll1));
            System.out.println(Language.You_Have_Gained() + Tlmain.getValue(roll1) + Language.Points());
            player1.AddToSaldo(Tlmain.getValue(roll1));     //adds the ammount from the tile to the players saldo
            System.out.println(Language.Your_Total_Is_Now() + player1.GetSaldo() + Language.Points());
            /*
            We make an if roll for the 10th tile. in this tile you get an extra turn. That means you throw the dices again.
            Input enter is so the person can "start" the game
            We make a roll and gets a sum that we save in roll1
            We tell the player what they have rolled, what tile they have hit, what it does, what they lose or get.
            Then we add the amount to the players saldo and tell the player.
             */
            if (roll1 == 10) {
                System.out.println(" ");
                System.out.println(Langmain.extraturn());
                Input.enter();
                roll1 = p1tur.tur();
                System.out.println(Language.YOU_ROLLED + roll1);
                System.out.println(Language.You_Landed_On_The_Tile() + Tlmain.getTitle(roll1));
                System.out.println(Tlmain.getFlavourText(roll1));
                System.out.println(Language.You_Have_Gained() + Tlmain.getValue(roll1) + Language.Points());
                player1.AddToSaldo(Tlmain.getValue(roll1));
                System.out.println(Language.Your_Total_Is_Now() + player1.GetSaldo() + Language.Points());
            }
            /*
            Then it is the second players turn to roll some dices
            Input enter is so the person can "start" the game
            We make a roll and gets a sum that we save in roll2
            We tell the player what they have rolled, what tile they have hit, what it does, what they lose or get.
            Then we add the amount to the players saldo and tell the player.
             */
            System.out.println(" ");
            System.out.println(Language.It_Is() + navn2 + Language.S_Turn_Press_Enter_To_Roll_The_Dice());
            Input.enter();
            int roll2 = p2tur.tur();
            System.out.println(Language.YOU_ROLLED + roll2);
            System.out.println(Language.You_Landed_On_The_Tile() + Tlmain.getTitle(roll2));
            System.out.println(Tlmain.getFlavourText(roll2));
            System.out.println(Language.You_Have_Gained() + Tlmain.getValue(roll2) + Language.Points());
            player2.AddToSaldo(Tlmain.getValue(roll2));
            System.out.println(Language.Your_Total_Is_Now() + player2.GetSaldo() + Language.Points());
            /*
            We make an if roll for the 10th tile. in this tile you get an extra turn. That means you throw the dices again.
            Input enter is so the person can "start" the game
            We make a roll and gets a sum that we save in roll2
            We tell the player what they have rolled, what tile they have hit, what it does, what they lose or get.
            Then we add the amount to the players saldo and tell the player.
             */
            if (roll2 == 10) {
                System.out.println(" ");
                System.out.println(Langmain.extraturn());
                Input.enter();
                roll2 = p2tur.tur();
                System.out.println(Language.YOU_ROLLED + roll2);
                System.out.println(Language.You_Landed_On_The_Tile() + Tlmain.getTitle(roll2));
                System.out.println(Tlmain.getFlavourText(roll2));
                System.out.println(Language.You_Have_Gained() + Tlmain.getValue(roll2) + Language.Points());
                player2.AddToSaldo(Tlmain.getValue(roll2));
                System.out.println(Language.Your_Total_Is_Now() + player2.GetSaldo() + Language.Points());
            }
        }
        /*
        Now we have reached out of the while loop. So one of the players have reached over 3000 in their saldo.
        Then two things can happen. player1 wins and has more in the saldo then player2
        player2 wins and has more in the saldo the player1

        We tell the players who won. the we find the difference between the two players saldo.
        Then we tell them how much the player won with.
         */
        if (player1.GetSaldo() > player2.GetSaldo()) {
            System.out.println(Language.Congratulations() + navn1 + Language.You_Have_Won_The_Game());
            int difference = player1.GetSaldo() - player2.GetSaldo();
            System.out.println(Language.You_Won_With() + difference + Language.Points());
        }

        if (player2.GetSaldo() > player1.GetSaldo()) {
            System.out.println(Language.Congratulations() + navn2 + Language.You_Have_Won_The_Game());
            int difference = player2.GetSaldo() - player1.GetSaldo();
            System.out.println(Language.You_Won_With() + difference + Language.Points());
        }
        /*
        The end.
         */
    }

}