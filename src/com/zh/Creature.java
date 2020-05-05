package com.zh;

import java.util.ArrayList;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:16
 * @version: 1.0
 * @modified By:
 */
public abstract class Creature {
    private String id;
    private String description;
    private int HpValue;
    private Weapon currentWeapon;
    //private ArrayList<Weapon> weapons = new ArrayList<>();
    public abstract void useArticle(Weapon weapon, Creature targetCreature,Scene scene);

    public Creature(String id, String description, int hpValue, Weapon currentWeapon) {
        this.id = id;
        this.description = description;
        this.HpValue = hpValue;
        this.currentWeapon = currentWeapon;
    }

    public Creature(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHpValue() {
        return HpValue;
    }

    public void setHpValue(int hpValue) {
        HpValue = hpValue;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

}
