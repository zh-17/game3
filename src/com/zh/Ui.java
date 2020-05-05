package com.zh;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:17
 * @version: 1.0
 * @modified By:
 */
public class Ui {
        //输出基本信息
        public void displayStatus(Scene scene){
                System.out.println("-------------------------------");
                System.out.println(scene.getPerson().getId()+"("+scene.getPerson().getDescription()+")"+
                        ":"+scene.getPerson().getHpValue());
                for (Person item: scene.getPersonSet().getPeople()
                     ) {
                        System.out.println(item.getId()+"("+item.getDescription()+")"+":"+item.getHpValue()+" ");
                }
                for (MonsterWolf item:scene.getMonsterWolfSet().getMonsterWolves()
                     ) {
                        System.out.print(item.getId()+"("+item.getDescription()+")"+":"+item.getHpValue()+" ");
                }
                System.out.println();
                System.out.println("-------------------------------");
        }

        public void displayHelpMsg(){
                System.out.println("------chop( chop wolf1) , help , bye ,-------");
        }

        public void displayBye(){
                System.out.println("Bye Bye!");
        }

        public void displayErrorCmdMsg(){
                System.out.println("您输入了非法命令。");
        }

        public void displayDamageMsg(Creature attackCreature,Creature targetCreature){
                System.out.println(attackCreature.getDescription()+"对"+targetCreature.getDescription()+
                        "照成"+attackCreature.getCurrentWeapon().getDamagePoints()+"伤害。");
        }
}
