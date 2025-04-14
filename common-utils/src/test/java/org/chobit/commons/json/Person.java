package org.chobit.commons.json;

import org.chobit.commons.json.annotation.CodeDescSerialize;
import org.chobit.commons.json.annotation.CodeEnumDesc;

public class Person {

	@CodeDescSerialize(showDesc = true)
	private Gender gender;

	@CodeEnumDesc(Gender.class)
	private int genderCode;

	private int age;


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(int genderCode) {
		this.genderCode = genderCode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
