package com.bsuir.agency.entity;

/**
 * Created by Олег Пятко on 31.05.2017.
 */
public enum RoleEnum {
    admin(0),
    hotelRepresentative(1),
    guideRepresentative(2),
    user(3),
    manager(4);

    private int levelId;

    RoleEnum(int levelId){
        this.levelId = levelId;
    }

    public int getValue(){
        return levelId;
    }
}
