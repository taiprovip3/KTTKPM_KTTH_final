package com.se.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name= "student")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -22043366112204362L;
	
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private long id;
	private String name;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="mentorId", nullable = false)
	private Mentor mentor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Student() {
		super();
	}

	public Student(long id, String name, int age, Mentor mentor) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mentor = mentor;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mentor=" + mentor + "]";
	}
	
	
	
	
	
}
