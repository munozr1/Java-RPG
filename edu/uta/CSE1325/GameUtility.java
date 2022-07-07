package edu.uta.CSE1325;
import java.util.Random;
/**
 * Contains usefull utility functions the the main game. 
 * This class only provides static methods
 */
public class GameUtility {


    /**
     * Rolls a virtual dice an x amount of times and returns the value
     * @param input A string value with format [NUMDICE]d[DICETYPE]
     * @return An integer which represents the sum of the die rolled
     */
    public static int rollDice(String input)
    {
        String[] tokens = input.split("d");
        Random generator = new Random();
        int numDice = Integer.parseInt(tokens[0]);
        int diceType  = Integer.parseInt(tokens[0]);
        int result = 0;
        for(int i = 0; i < numDice; i++)
        {
            result += generator.nextInt(diceType) +1;
        }
        return result;
    }
}
