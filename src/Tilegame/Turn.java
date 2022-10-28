package Tilegame;

import TerningeSpil.Die;

public class Turn {
    /**
     * Creates 2 die objects.
     */
    TerningeSpil.Die die1 = new TerningeSpil.Die();
    TerningeSpil.Die die2 = new Die();
    int sum;

    /**
     * Rolls 2 die and saves them in the variable sum.
     *
     * @return sum, returns the sum of the roll.
     */

    public int tur() {
        die1.roll();
        die2.roll();
        sum = die1.getFaceValue() + die2.getFaceValue();


        return sum;

    }
}
