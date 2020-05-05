package com.zh;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:17
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolfSet {
    //怪兽堆
    private ArrayList<MonsterWolf> monsterWolves = new ArrayList<>();

    public MonsterWolfSet(){

    }

    public MonsterWolfSet(ArrayList<MonsterWolf> monsterWolves) {
        this.monsterWolves = monsterWolves;
    }


    public MonsterWolf get(String id){
        MonsterWolf monsterWolf = null;
        for (MonsterWolf item:monsterWolves
             ) {
            if(id.equals(item.getId())){
                monsterWolf = item;
                break;
            }
        }
        return monsterWolf;
    }
    //怪兽死去需要从怪兽堆中移除
    public void remove(String id){
                Iterator<MonsterWolf> it = monsterWolves.iterator();
                while(it.hasNext()) {
                    MonsterWolf value = it.next();
                    if(value.equals(get(id)) ) {
                        it.remove();
                    }
                }

    }

    public ArrayList<MonsterWolf> getMonsterWolves() {
        return monsterWolves;
    }

    public void setMonsterWolves(ArrayList<MonsterWolf> monsterWolves) {
        this.monsterWolves = monsterWolves;
    }



}
