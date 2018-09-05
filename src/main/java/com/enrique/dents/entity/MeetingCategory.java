package com.enrique.dents.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Jose Enrique Vergara
 *
 */
@Entity
@Table(name = "meeting_category")
public class MeetingCategory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String description;

	@OneToMany(mappedBy = "meetingCategory")
	List<Meetings> meetingsList;

	public MeetingCategory() {
		// TODO Auto-generated constructor stub
	}

	public MeetingCategory(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Meetings> getMeetingsList() {
		return meetingsList;
	}

	public void setMeetingsList(List<Meetings> meetingsList) {
		this.meetingsList = meetingsList;
	}

	@Override
	public String toString() {
		return "MeetingCategory [id=" + id + ", description=" + description + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 447405912890920644L;

}
