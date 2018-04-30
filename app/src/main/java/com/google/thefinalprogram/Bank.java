package com.google.thefinalprogram;

/**
 * Created by Waleed on 07/03/2018.
 */

public class Bank {
    public void Money_Transfer_players(Player a , Player b , int money) // trnasfer money from a to b ;
    {
        a.SetMoney(-money);
        b.SetMoney(money);
    }//end function


    public void Recieving_Money(Player a, int money)//recieving money from Bank
    {
        a.SetMoney(money);
    }// end function


    public  void Pay_Money(Player a , int money) //Pay money for Bank
    {
        a.SetMoney(-money);
    }// end functon
}
