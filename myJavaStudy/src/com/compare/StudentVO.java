package com.compare;
//hua
public class StudentVO {

	private String name;
	private String grade;
	private Integer age;
	private double score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentVO{" +
				"name='" + name + '\'' +
				", grade='" + grade + '\'' +
				", age=" + age +
				", score=" + score +
				'}';
	}
}
