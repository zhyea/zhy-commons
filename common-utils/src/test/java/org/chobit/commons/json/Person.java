package org.chobit.commons.json;

import org.chobit.commons.json.annotation.CodeDescSerialize;

public class Person {

    @CodeDescSerialize(showDesc = true)
    private Gender gender;

    private int age;


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
