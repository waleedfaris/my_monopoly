package com.google.thefinalprogram;

import java.util.Random;

/**
 * Created by Salman on 07/03/2018.
 */

public class Dice
{
    private int value;
    Random rnd=new Random();

    public void Roll()
    {
        value=rnd.nextInt(7);
    }

    public int GetValue()
    {
        return value;
    }
}
