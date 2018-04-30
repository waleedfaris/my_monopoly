package com.google.thefinalprogram;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class TheBoardActivity extends AppCompatActivity {
    public static List<Player> players = chosebot.players;
    private int Index;
    private Button[] BordButtons;
    private ImageView[] BordBoots;
    private int helpINbuttons=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_the_board);
        getSupportActionBar ().hide ();
        Index = -1;// אסור לשחק בו

        final Button Dice = (Button) findViewById (R.id.dice);

        final Player[] CurrentPlayer = {MakeTurn ()};

        ChangeData (CurrentPlayer[0]);

        Dice.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                MakeMasgee ().show ();
                Dice.setVisibility (View.INVISIBLE);
                CurrentPlayer[0] =MakeTurn ();
                ChangeData (CurrentPlayer[0]);
            }
        });

        final ImageView Imagee=(ImageView) findViewById (R.id.cardImageView);

       /*x.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if(helpINbuttons==0) {
                    Imagee.setVisibility (View.VISIBLE);
                    Imagee.setBackground (getDrawable (CountryImage));
                    helpINbuttons=1;
                }else
                {
                    Imagee.setVisibility (View.INVISIBLE);
                    helpINbuttons=0;
                }
            }
        });*/


    }// end  oncreate function

    //public void GiveEachOneA


    public void FillButtons()
    {
        BordButtons = new Button[40];
        BordButtons[0]=findViewById(R.id.b30);
        BordButtons[1]=findViewById(R.id.b28);
        BordButtons[2]=findViewById(R.id.b26);
        BordButtons[3]=findViewById(R.id.b24);
        BordButtons[4]=findViewById(R.id.b22);
        BordButtons[5]=findViewById(R.id.b20);
        BordButtons[6]=findViewById(R.id.b18);
        BordButtons[7]=findViewById(R.id.b16);
        BordButtons[8]=findViewById(R.id.b14);
        BordButtons[9]=findViewById(R.id.b12);
        BordButtons[10]=findViewById(R.id.b1);
        BordButtons[11]=findViewById(R.id.b2);
        BordButtons[12]=findViewById(R.id.b3);
        BordButtons[13]=findViewById(R.id.b4);
        BordButtons[14]=findViewById(R.id.b5);
        BordButtons[15]=findViewById(R.id.b6);
        BordButtons[16]=findViewById(R.id.b7);
        BordButtons[17]=findViewById(R.id.b8);
        BordButtons[18]=findViewById(R.id.b9);
        BordButtons[19]=findViewById(R.id.b10);
        BordButtons[20]=findViewById(R.id.b11);
        BordButtons[21]=findViewById(R.id.b13);
        BordButtons[22]=findViewById(R.id.b15);
        BordButtons[23]=findViewById(R.id.b17);
        BordButtons[24]=findViewById(R.id.b19);
        BordButtons[25]=findViewById(R.id.b21);
        BordButtons[26]=findViewById(R.id.b23);
        BordButtons[27]=findViewById(R.id.b25);
        BordButtons[28]=findViewById(R.id.b27);
        BordButtons[29]=findViewById(R.id.b29);
        BordButtons[30]=findViewById(R.id.b40);
        BordButtons[31]=findViewById(R.id.b39);
        BordButtons[32]=findViewById(R.id.b38);
        BordButtons[33]=findViewById(R.id.b37);
        BordButtons[34]=findViewById(R.id.b36);
        BordButtons[35]=findViewById(R.id.b35);
        BordButtons[36]=findViewById(R.id.b34);
        BordButtons[37]=findViewById(R.id.b33);
        BordButtons[38]=findViewById(R.id.b32);
        BordButtons[39]=findViewById(R.id.b31);
    }// End function



    public ArrayList<Integer> images()
    {
        ArrayList<Integer> images=new ArrayList<>();
        images.add(R.drawable.board300x300);
        return images;
    }

    public AlertDialog.Builder MakeMasgee( )
    {
        final int[] x = {0};
        String st = "Number of moves is";
         AlertDialog.Builder dice = new AlertDialog.Builder(this);
        dice.setIcon (getDrawable (R.drawable.monopoly));
        final Random rnd = new Random ();
        x[0]=rnd.nextInt (12)+1;
        st=st+" " +x[0];
        dice.setTitle (st);
        players.get (Index).SetLocation (x[0]);

        dice.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dice.create ();
        return dice;

    }// end function make masgee that return number of moves at masgee and update the location method
    // at every player

    public void ChangeData(Player aa  )
    {
         TextView playername;
        TextView playermoney;
         ImageView playerboot;
        playername=(TextView) findViewById (R.id.playername);
        playermoney=(TextView) findViewById (R.id.playermoney);
        playerboot=(ImageView) findViewById (R.id.playerboot);
        playername.setText (aa.GetN ());
        String st = "" + aa.GetMoney ()+"M $";
        playermoney.setText (st);
        playerboot.setImageDrawable (getDrawable (aa.GetBoot ()));
        Button Dice = (Button) findViewById (R.id.dice);
         Dice.setVisibility (View.VISIBLE);

    }// end function ChangeData that changes the data for every player



    private Player MakeTurn()
    {
        Index++;
        if(Index < players.size ())
        {
            return players.get (Index);
        }
        else{
            Index=0;
            return players.get (Index);
        }


    }// this function return the player according to the tor



    private void SetLocation (Player aa )
    {
        //getDrawable (aa.GetBoot ()).setLayoutDirection (BordButtons[aa.GetLocation ()].getLayoutDirection ());
        //getDrawable (aa.GetBoot ()).setHotspot (BordButtons[aa.GetLocation ()].getX (),BordButtons[aa.GetLocation ()].getY ());
        int left=BordButtons[aa.GetLocation ()].getLeft ();
        int right=BordButtons[aa.GetLocation ()].getRight ();
        int  x =BordButtons[aa.GetLocation ()].getTop ();
        int  y =BordButtons[aa.GetLocation ()].getBottom ();

        getDrawable (aa.GetBoot ()).setBounds (left,x,right,y);
        //getDrawable (aa.GetBoot ()).
    }// end function SetLocation that update the location of the player at the bord




   /* private void SetHideBoots()
    {
        BordBoots[0]= (ImageView) findViewById (R.id.mkoa);
        BordBoots[1]=(ImageView) findViewById (R.id.hat);
        BordBoots[2]=(ImageView) findViewById (R.id.car);
        BordBoots[3]=(ImageView) findViewById (R.id.klb);
        BordBoots[4]=(ImageView) findViewById (R.id.stl);
        BordBoots[5]=(ImageView) findViewById (R.id.ship);

        int i =0,j,flag ;// flag = 0 -> yes some player choose it ... flag = 1 -> no one choose it
        for ( ; i< 6 ;i++)
        {
            flag=1;
            for ( j=0; j<players.size ();j++)
            {
                if(BordBoots[i].getId ()== players.get (j).GetBoot ())
                {
                    flag=0;
                }
            }// end for j
            if (flag==1)
            {
                BordBoots[i].setVisibility (View.INVISIBLE);
            }

        }// end for i



    }// end function that charge of the visbity of the copy boots
*/





}// end class
