package com.esamejava;

import java.util.HashSet;

public class Replyer
{
    ReplyerType type;
    int bonus;
    HashSet<String> skills;
    int posX;
    int posY;


    public Replyer(ReplyerType type, int bonus, HashSet<String> skills) {
        this.type = type;
        this.skills = skills;
        this.bonus = bonus;
    }


}
