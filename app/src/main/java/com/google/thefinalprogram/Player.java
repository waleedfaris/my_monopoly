package com.google.thefinalprogram;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waleed on 25/02/2018.
 */

public class Player {

    private String playername;
    private int id;
    private int place;
    private int Money;
    private List<card> Cards;
    private List<Company> Companys;
    private List<Surprise> SavedCard;
    private int  boot;
    private int location ;
    private String chracter;

    public Player(int Id)
    {
        SetID (Id);
        this.playername=null;
        this.Money=2000000;
        this.location=0;
    }

    public void SetMoney(int money)
    {
        this.Money=this.Money+money;
    }

    public String GetN()
    {
        return this.playername;
    }

    public void SetN(String N)
    {
        this.playername=N;
    }

    public int GetID()
    {
        return this.id;
    }

    public int GetMoney() {return this.Money;}

    public void SetID(int id)
    {
        this.id=id;
    }

    public ArrayList<card> GetCards()
    {
        return (ArrayList<card>) this.Cards;
    }





    public int GetPlace() {return this.place;}

    public void SetBoot(int  a)
    {
        this.boot=a;
    }


    public void SetPlace(int mo){this.place=mo;}


    public ArrayList<Surprise> GetSavedCard()
    {
        return (ArrayList<Surprise>) this.SavedCard;
    }

    public void SetCard(card c)
    {
        this.Cards.add(c);
    }

    public void SetSavedCard(Surprise s)
    {
        this.SavedCard.add(s);
    }

    public void SetCompany(Company company)
    {
        this.Companys.add(company);
    }

    public boolean Have_This_Card(card c)
    {
        for(int i=0;i<this.Cards.size();i++)
        {
            if(c.GetOwner()==this.id)
            {
                return true;
            }
        }
        return false;
    }

    public int GetBoot()
    {
        return this.boot;
    }

    public void SetLocation (int x )
    {
        location=(location+x)%40;
    }

    public int GetLocation ()
    {
        return this.location;
    }





}// end class
