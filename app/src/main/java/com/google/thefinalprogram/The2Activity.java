package com.google.thefinalprogram;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class The2Activity extends AppCompatActivity {

    private CircleMenu circleMenu;
    public  static Stack<Player> players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.the2activity);
        getSupportActionBar().hide();
        ////////////////////////////////////write your code down////////////////
        players=new Stack<Player> ();
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#AAAAAA"), R.mipmap.monopoly, R.mipmap.monopoly);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.icon1)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.icon2)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon3)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.icon4)
                .addSubMenu(Color.parseColor("#7A5230"), R.mipmap.icon5)
                .addSubMenu(Color.parseColor("#FA8072"), R.mipmap.icon6);
        Button Next= (Button)findViewById (R.id.get3);
        players.push(new Player (0));
        players.push(new Player (1));
        players.push(new Player (2));
        players.push(new Player (3));
        players.push(new Player (4));
        players.push(new Player (5));
        //////////////////////////////////////////////////////////////////////////////////////////////////////תכונות למעלה



        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener () {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             if(ISIN (0)){
                                                                    MakeMasgee (0).show ();

                                                             }
                                                             else{
                                                                 Toast.makeText(The2Activity.this, R.string.enterd_name, Toast.LENGTH_SHORT).show();
                                                             }
                                                             break;
                                                         case 1:
                                                             if(ISIN (1)){
                                                                 MakeMasgee (1).show ();}
                                                             else{
                                                                 Toast.makeText(The2Activity.this, R.string.enterd_name, Toast.LENGTH_SHORT).show();
                                                             }
                                                             break;
                                                         case 2:
                                                             if(ISIN (2)){
                                                                 MakeMasgee (2).show ();}
                                                             else{
                                                                 Toast.makeText(The2Activity.this, R.string.enterd_name, Toast.LENGTH_SHORT).show();
                                                             }
                                                             break;
                                                         case 3:
                                                             if(ISIN (3)){
                                                                 MakeMasgee (3).show ();}
                                                             else{
                                                                 Toast.makeText(The2Activity.this, R.string.enterd_name, Toast.LENGTH_SHORT).show();
                                                             }
                                                             break;
                                                         case 4:
                                                             if(ISIN (4)){
                                                                 MakeMasgee (4).show ();}
                                                             else{
                                                                 Toast.makeText(The2Activity.this, R.string.enterd_name, Toast.LENGTH_SHORT).show();
                                                             }
                                                             break;
                                                         case 5:
                                                             if(ISIN (5)){
                                                                 MakeMasgee (5).show ();}
                                                             else{
                                                                 Toast.makeText(The2Activity.this, R.string.enterd_name, Toast.LENGTH_SHORT).show();
                                                             }
                                                             break;
                                                     }// end switch
                                                 }
                                             }

        );// end circle menu click listnier


        Next.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
             makefinalstacck ();

                if(players.size ()>=2&& players.size ()<=6)
                {
                    Intent Game = new Intent (The2Activity.this, The3Activity.class);
                    finish ();
                    startActivity (Game);
                }
                else {
                    Toast.makeText(The2Activity.this, "this game made for 2-6 players,sorry!", Toast.LENGTH_SHORT).show();

                }


            }
        });



        findViewById (R.id.button).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder aa=new AlertDialog.Builder (The2Activity.this);
                makefinalstacck ();
                aa.setMessage (allnames ());
                aa.create ();
                aa.show ();
            }
        });




    }// end main




    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened ())
            circleMenu.closeMenu ();
        else
            finish ();
    }


    public AlertDialog.Builder MakeMasgee(final int x )
    {
        AlertDialog.Builder enterN = new AlertDialog.Builder(this);
        enterN.setTitle ("You'r name:");
        enterN.setIcon (getDrawable (R.drawable.monopoly));
        final EditText input = new EditText(this);
        enterN.setView(input);
        enterN.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Pushname (x,input.getText().toString());
                dialog.cancel();
            }
        });
        enterN.create ();
        return enterN;

    }// end function




    private boolean ISIN(int x)
    {
        boolean flag= false;
        int i = 0 ,size=players.size ();
        Stack<Player> temp = new Stack<Player> ();
        for(;i<size;i++) {


            if (players.peek ().GetID () == x) {
                if (players.peek ().GetN () == null||players.peek ().GetN ().isEmpty ()) {
                    flag = true;
                }
            }
            temp.push(players.pop());
        }
        size=temp.size ();
        for(i=0;i<size;i++)
        {
            players.push (temp.pop ());
        }
        return flag;


    }// end function --------- check if somebuuton enter his name by the id



    private void Pushname(int x , String name)
    {
        int i ,size=players.size ();
        Stack<Player> temp=new Stack<Player> ();
        for(i=0;i<size;i++)
        {
            if(this.players.peek ().GetID ()==x)
            {
                this.players.peek ().SetN (name);
            }
            temp.push(this.players.pop ());
        }
        size=temp.size ();
        for(i=0;i<size;i++)
        {
            this.players.push(temp.pop());
        }

    }// end function


    private int howMuschplayers()
    {
        int i  , size=players.size (),count=0;
        Stack<Player> temp=new Stack<Player> ();
        for(i=0;i<size;i++)
        {
            if(players.peek ().GetN ()!=null)
            {
                count++;
            }
            temp.push(players.pop ());
        }
        size=temp.size();
        for(i=0;i<size;i++)
        {
            players.push(temp.pop ());
        }
        return count ;
    }


    private String allnames()
    {
        Stack<Player> temp = new Stack<Player> ();
        String st="";
        int i ,size=players.size ();
        for(i=0;i<size;i++)
        {
            st=st+i+":"+players.peek ().GetN ()+"\n";
            temp.push (players.pop ());
        }
        size=temp.size ();
        for(i=0;i<size;i++)
        {
            players.push(temp.pop ());
        }
        return st;

    }// end function ----------- return all the names of the players

    private void makefinalstacck()
    {
        int i,size=this.players.size ();
        Stack<Player> temp=new Stack<Player> (),temp1=new Stack<Player> ();

        for(i=0;i<size;i++)
        {
            if(this.players.peek ().GetN ()!=null ){
                temp.push (players.pop ());
            }else {
                temp1.push (players.pop ());
            }
        }
        size=temp.size ();
        for(i=0;i<size;i++){
            players.push(temp.pop ());
        }

    }// end function




}// end class
