package com.zh;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:19
 * @version: 1.0
 * @modified By:
 */
public class WeaponDagger extends Weapon {

    public WeaponDagger(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    @Override
    public void useArticle(Creature enemyCreature, Scene scene) {
        enemyCreature.setHpValue(enemyCreature.getHpValue()+this.getDamagePoints());
    }



}
