package com.zh;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/5/1 20:48
 * @version: 1.0
 * @modified By:
 */
public class PersonSet {
    //帮手群
    private ArrayList<Person> people = new ArrayList<>();

    public PersonSet(){

    }

    public PersonSet(ArrayList<Person> people) {
        this.people = people;
    }

    public Person get(String id){
        Person person = null;
        for (Person item: people
             ) {
            if(id.equals(item.getId())){
                person = item;
                break;
            }
        }
        return person;
    }
    //帮手死去则需要从帮手群中移除掉
    public void remove(String id){
        Iterator<Person> it = people.iterator();
        while (it.hasNext()){
            Person value = it.next();
            if(value.equals(get(id))){
                it.remove();
            }
        }
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
