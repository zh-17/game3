package com.zh;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:18
 * @version: 1.0
 * @modified By:
 */
public abstract class Weapon {
    private String id;
    private String description;
    private int damagePoints;
    public abstract void useArticle( Creature enemyCreature, Scene scene);

    public Weapon() {

    }

    public Weapon(String id, String description, int damagePoints) {
        this.id = id;
        this.description = description;
        this.damagePoints = damagePoints;
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

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }
}
