package com.ihscode.hibernate.d.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// create constructors
	
	// generate getters/setters methods
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	 
	@Column(name="youtube_channel")
	private String youTubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	// add new field for instructor (also add getters/setters)
	
	// add @OneToOne annotation
	
	@OneToOne(mappedBy="instructorDetail",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
					CascadeType.REFRESH})
	private Instructor instructor;
		
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public InstructorDetail() {
		
	}

	public InstructorDetail(String youTubeChannel, String hobby) {
		this.youTubeChannel = youTubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYouTubeChannel() {
		return youTubeChannel;
	}

	public void setYouTubeChannel(String youTubeChannel) {
		this.youTubeChannel = youTubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youTubeChannel=" + youTubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
}
