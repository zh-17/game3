package com.zh;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:17
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolf extends Creature {

    @Override
    public void useArticle(Weapon weapon, Creature targetCreature,Scene scene) {
        weapon.useArticle(targetCreature,scene);
    }
}
