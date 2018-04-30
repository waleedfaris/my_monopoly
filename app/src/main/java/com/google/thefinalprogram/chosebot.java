package com.google.thefinalprogram;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//this activity for cose bot for every player

public class chosebot extends AppCompatActivity {
    public static List<Player> players=The3Activity.players;
    private int Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_chosebot);
        getSupportActionBar().hide();


        final Button m1=(Button) findViewById (R.id.img1);
        final Button m2=(Button) findViewById (R.id.img2);
        final Button m3 = (Button) findViewById (R.id.img3);
        final Button m4 = (Button) findViewById (R.id.img4);
        final Button m5=(Button) findViewById (R.id.img5);
        final Button m6=(Button) findViewById (R.id.img6);
        final Button Done=(Button) findViewById (R.id.ddd);
        final TextView name =(TextView)findViewById (R.id.textView3);
        /////////////////////////////////////////////////////////////////////////////////////////
        Done.setVisibility (View.INVISIBLE);
        Index=0;
        final String[] st = {""};


        name.setText (players.get (Index).GetN ());


        m1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                players.get (Index).SetBoot (R.drawable.avr1);
                m1.setVisibility (View.INVISIBLE);
                Index++;
                if(Index < players.size ())
                {
                    name.setText (players.get (Index).GetN ());
                }
                else {
                    Done.setVisibility (View.VISIBLE);
                    swapVispilty (m2);
                    swapVispilty (m3);
                    swapVispilty (m4);
                    swapVispilty (m6);
                    swapVispilty (m5);
                }

            }
        });




        m2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                players.get (Index).SetBoot (R.drawable.avr2);
                m2.setVisibility (View.INVISIBLE);

                Index++;
                if(Index < players.size ())
                {
                    name.setText (players.get (Index).GetN ());
                }
                else {
                    Done.setVisibility (View.VISIBLE);
                    swapVispilty (m1);
                    swapVispilty (m3);
                    swapVispilty (m4);
                    swapVispilty (m6);
                    swapVispilty (m5);
                }
            }
        });




        m3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                players.get (Index).SetBoot (R.drawable.avr3);
                m3.setVisibility (View.INVISIBLE);

                Index++;
                if(Index < players.size ())
                {
                    name.setText (players.get (Index).GetN ());
                }else {
                    Done.setVisibility (View.VISIBLE);
                    swapVispilty (m2);
                    swapVispilty (m1);
                    swapVispilty (m4);
                    swapVispilty (m6);
                    swapVispilty (m5);
                }


            }
        });



        m4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                players.get (Index).SetBoot (R.drawable.avr4);
                m4.setVisibility (View.INVISIBLE);

                Index++;
                if(Index <players.size ())
                {
                    name.setText (players.get (Index).GetN ());
                }else {
                    Done.setVisibility (View.VISIBLE);
                    swapVispilty (m2);
                    swapVispilty (m3);
                    swapVispilty (m1);
                    swapVispilty (m6);
                    swapVispilty (m5);
                }
            }
        });





        m5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                players.get (Index).SetBoot (R.drawable.avr5);
                m5.setVisibility (View.INVISIBLE);
                Index++;
                if(Index < players.size ())
                {
                    name.setText (players.get (Index).GetN ());
                }else {
                    Done.setVisibility (View.VISIBLE);
                    swapVispilty (m2);
                    swapVispilty (m3);
                    swapVispilty (m4);
                    swapVispilty (m6);
                    swapVispilty (m1);
                }


            }
        });




        m6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                players.get (Index).SetBoot (R.drawable.avr6);
                m6.setVisibility (View.INVISIBLE);

                Index++;
                if(Index < players.size ())
                {
                    name.setText (players.get (Index).GetN ());
                }else {
                    Done.setVisibility (View.VISIBLE);
                    swapVispilty (m2);
                    swapVispilty (m3);
                    swapVispilty (m4);
                    swapVispilty (m1);
                    swapVispilty (m5);
                }
            }
        });


        Done.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent Game = new Intent (chosebot.this, TheBoardActivity.class);
                finish ();
                startActivity (Game);
            }
        });


    }// end on creat



    private void swapVispilty(Button aa)
    {
        if(aa.VISIBLE==0)
        {
            aa.setVisibility (View.INVISIBLE);
        }

    }// end function



}// end calss
