package com.zh;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:19
 * @version: 1.0
 * @modified By:
 */
public class WeaponKnife extends Weapon {

    public WeaponKnife(String id, String description, int damagePoints) {
        super(id, description, damagePoints);
    }

    @Override    //默认怪兽都使用Knife
    public void useArticle(Creature enemyCreature,Scene scene) {
        enemyCreature.setHpValue(enemyCreature.getHpValue()+this.getDamagePoints());
        if(enemyCreature.getHpValue()<=0){
            if(enemyCreature.equals(scene.getPerson())){
                System.out.println("You lose!");
                System.exit(0);//主角死了，则游戏失败
            }else {
                scene.getPersonSet().remove(enemyCreature.getId());//帮手死了，继续游戏
            }

        }
    }
}
