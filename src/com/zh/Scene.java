package com.zh;

import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:23
 * @version: 1.0
 * @modified By:
 */
public class Scene {
    private Person person = new Person();//初始化主角

    private MonsterWolf wolf1 = new MonsterWolf();//初始化怪物集合
    private MonsterWolf wolf2 = new MonsterWolf();
    private MonsterWolf wolf3 = new MonsterWolf();
    private MonsterWolfSet monsterWolfSet = new MonsterWolfSet();

    private Person person2 = new Person();//初始化帮手集合
    private Person person3 = new Person();
    private PersonSet personSet = new PersonSet();
    Ui ui = new Ui();

    public void initScene(){
            initPerson();
            initMonster();
            initPersonSet();
    }

    public void initPerson(){
            person.setId("201902225");
            person.setDescription("小张");
            person.setHpValue(300);
            person.setCurrentWeapon(new WeaponSword("pw1","罗遇剑",-50));
    }

    public void initMonster(){
            wolf1.setId("wolf1");
            wolf1.setDescription("狼1");
            wolf1.setHpValue(100);
            wolf1.setCurrentWeapon(new WeaponKnife("mw1","截天刀",-30));

            wolf2.setId("wolf2");
            wolf2.setDescription("狼2");
            wolf2.setHpValue(100);
            wolf2.setCurrentWeapon(new WeaponKnife("mw2","凤羽刀",-150));

            wolf3.setId("wolf3");
            wolf3.setDescription("狼3");
            wolf3.setHpValue(100);
            wolf3.setCurrentWeapon(new WeaponKnife("mw3","雨落刀",-49));

            monsterWolfSet.getMonsterWolves().add(wolf1);
            monsterWolfSet.getMonsterWolves().add(wolf2);
            monsterWolfSet.getMonsterWolves().add(wolf3);

    }

    public void initPersonSet(){
        person2.setId("person2");
        person2.setHpValue(100);
        person2.setDescription("帮手2");
        person2.setCurrentWeapon(new WeaponDagger("pw2","水起匕",-10));
        person3.setId("person3");
        person3.setDescription("帮手3");
        person3.setHpValue(80);
        person3.setCurrentWeapon(new WeaponKnife("pw3","万月刀",-5));

        personSet.getPeople().add(person2);
        personSet.getPeople().add(person3);
    }

    public void play(){
//            System.out.println(wolf1.getHpValue());
//            person.useArticle(person.getCurrentWeapon(),wolf1);
//            System.out.println(wolf1.getHpValue());
//
//            System.out.println(person.getHpValue());
//            wolf1.useArticle(wolf1.getCurrentWeapon(),person);
//            System.out.println(person.getHpValue());

        ui.displayStatus(this);//输出基本信息
        Scanner in = new Scanner(System.in);
        while (true){
            String command = in.nextLine();
            String[] cmdLineItems = command.split(" ");//空格必须打起，不然不管输入多少字符都没有效果。
            if(cmdLineItems[0].equals("bye")){
                ui.displayBye();
                System.exit(0);
            }else if(cmdLineItems[0].equals("help")){
                ui.displayHelpMsg();
            }else if(cmdLineItems[0].equals("chop")){
                //其他帮手的攻击，帮手跟随主角的攻击。
                for (Person item: this.getPersonSet().getPeople()
                ) {
                    if(1==Utils.randomMonsterChop()){
                        ui.displayDamageMsg(item,this.getMonsterWolfSet().get(cmdLineItems[1]));//先输出伤害
                        item.useArticle(item.getCurrentWeapon(),this.getMonsterWolfSet().get(cmdLineItems[1]),this);
                    }
                }
                //主角的攻击
                 ui.displayDamageMsg(this.getPerson(),this.getMonsterWolfSet().get(cmdLineItems[1]));//先输出伤害
                 this.getPerson().useArticle(this.getPerson().getCurrentWeapon(),
                         this.getMonsterWolfSet().get(cmdLineItems[1]),this);

                //怪兽的攻击
                for (MonsterWolf item: this.getMonsterWolfSet().getMonsterWolves()
                     ) {
                    if(1==Utils.randomMonsterChop()){
                        ui.displayDamageMsg(item,this.getPerson());//先输出伤害
                        item.useArticle(item.getCurrentWeapon(),this.getPerson(),this);
                    }
                    else if(this.getPersonSet().getPeople().size()!=0){
                            ui.displayDamageMsg(item,this.getPersonSet().getPeople().get(0));//先输出伤害
                            item.useArticle(item.getCurrentWeapon(),this.getPersonSet().getPeople().get(0),this);
                    }
                }
            }else {
                ui.displayErrorCmdMsg();
                ui.displayHelpMsg();
            }
            ui.displayStatus(this);//再次输出基本信息
        }

    }

    public void judgeSuccess(){
        //怪兽死完了
        if(this.getMonsterWolfSet().getMonsterWolves().size()==0){
            System.out.println("You win！");
            System.exit(0);
        }

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MonsterWolfSet getMonsterWolfSet() {
        return monsterWolfSet;
    }

    public void setMonsterWolfSet(MonsterWolfSet monsterWolfSet) {
        this.monsterWolfSet = monsterWolfSet;
    }

    public PersonSet getPersonSet() {
        return personSet;
    }
}
