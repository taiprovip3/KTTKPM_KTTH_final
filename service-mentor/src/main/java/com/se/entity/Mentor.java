package com.se.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name= "mentor")
public class Mentor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6291775749172114292L;
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private long id;
	private String name;
	private String address;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mentor")
	private Set<Student> students = new HashSet<>();
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Mentor() {
		super();
	}
	public Mentor(long id, String name, String address, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.students = students;
	}
	@Override
	public String toString() {
		return "Mentor [id=" + id + ", name=" + name + ", address=" + address + ", students=" + students + "]";
	}
	
	
}
