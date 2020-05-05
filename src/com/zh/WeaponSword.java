package com.zh;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:18
 * @version: 1.0
 * @modified By:
 */
public class WeaponSword extends Weapon {

    public WeaponSword(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    @Override   //移除怪兽在这里进行，是因为每次攻击都是帮手先动手，然后主角再动手。
    public void useArticle(Creature enemyCreature,Scene scene) {
        enemyCreature.setHpValue(enemyCreature.getHpValue()+this.getDamagePoints());
        if(enemyCreature.getHpValue()<=0){
                scene.getMonsterWolfSet().remove(enemyCreature.getId());
                scene.judgeSuccess();
        }
    }
}
