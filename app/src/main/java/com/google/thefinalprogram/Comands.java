package com.google.thefinalprogram;

/**
 * Created by Waleed on 07/03/2018.
 */

public class Comands {

            String the_com_content;
            int money;

            public Comands(String com,int money)
            {
                this.money=money;
                this.the_com_content=com;
            }

            public String getcomand()
            {
                return this.the_com_content;
            }

            public int getmoney()
            {
                return this.money;
            }
}
