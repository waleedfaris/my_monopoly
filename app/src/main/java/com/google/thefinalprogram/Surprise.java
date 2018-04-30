package com.google.thefinalprogram;

/**
 * Created by Waleed on 07/03/2018.
 */

public class Surprise {
    int money ;
    String the_content;
    int exit_from_preson ; //1 - > get exit ,0 -> stay at the preson
    int if_command;// if 1-> תחליף לכרטיס פקודה  if 0 -> nothing


    public Surprise (int money , String con,int preson ,int com)
    {
        this.money=money;
        this.the_content=con;
        this.exit_from_preson=preson;
        this.if_command=com;
    }

    public int Getmoney()
    {
        return this.money;
    }

    public String getCotent()
    {
        return this.the_content;
    }


}
