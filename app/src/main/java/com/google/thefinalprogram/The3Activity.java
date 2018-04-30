package com.google.thefinalprogram;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class The3Activity extends AppCompatActivity {
    private Stack<Player> player=The2Activity.players;
    public static List<Player> players=new ArrayList<Player> ();
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_the3);
        getSupportActionBar().hide();


         final Button roll = (Button) findViewById (R.id.rull);
         final TextView playername = (TextView) findViewById (R.id.theplayername);
         final Button next=(Button) findViewById (R.id.next);
         index=0 ;
        final int[] urplace = new int[1];
        final Random rnd = new Random ();


        /////////////////////////////////////////////////////////////////////////////////
        makinglist ();
        playername.setText (players.get (index).GetN ());
        next.setVisibility (View.INVISIBLE);

        roll.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                    urplace[0] =rnd.nextInt (6)+1;
                    SetImage (urplace[0]);
                    players.get (index).SetPlace (urplace[0]);
                    roll.setVisibility (View.INVISIBLE);
                    next.setVisibility (View.VISIBLE);
                Toast.makeText(The3Activity.this, "press next please", Toast.LENGTH_SHORT).show();
                index++;


            }
        });

        next.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if(index !=players.size () ) {
                    playername.setText (players.get (index).GetN ());
                    roll.setVisibility (View.VISIBLE);
                    next.setVisibility (View.INVISIBLE);
                    Toast.makeText(The3Activity.this, "press roll please", Toast.LENGTH_SHORT).show();

                }
                else{
                    maketurn ();
                    Intent Game = new Intent (The3Activity.this, chosebot.class);
                    finish ();
                    startActivity (Game);

                }
            }
        });



    }// end the main function




    private void SetImage(int i )
    {
        ImageView thepic = (ImageView) findViewById (R.id.thepic);

        switch (i)
        {
            case 1 :{
                thepic.setImageDrawable (getDrawable (R.mipmap.dice1));
                break;
            }
            case 2:{
                thepic.setImageDrawable (getDrawable (R.mipmap.dice2));
                break;
            }
            case 3:{
                thepic.setImageDrawable (getDrawable (R.mipmap.dice3));
                break;
            }
            case 4:{
                thepic.setImageDrawable (getDrawable (R.mipmap.dice4));
                break;
            }
            case 5:{
                thepic.setImageDrawable (getDrawable (R.mipmap.dice5));
                break;
            }
            case 6:{
                thepic.setImageDrawable (getDrawable (R.mipmap.dice6));
                break;
            }
        }
    }// end function

    private void maketurn( )
    {
        List<Player> temp = new ArrayList<Player> ();
        int maxindex,lenght=players.size (),i=0;
        for(;i<lenght;i++)
        {
            temp.add (GettheBig (players));
        }
        players=temp;
    }// end function

    private Player GettheBig(List<Player> aa)
    {
        int i = 0 , maxindex=0;
        for(;i<aa.size ();i++)
        {
            if(aa.get (i).GetPlace ()>aa.get (maxindex).GetPlace ())
            {
                maxindex=i;
            }
        }
        return aa.remove (maxindex);
    }




    private void makinglist()
    {
        while(!player.isEmpty ()) {
            players.add (player.pop ());
        }

    }// end function

}// end class
