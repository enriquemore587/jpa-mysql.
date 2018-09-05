package com.enrique.dents.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "consulting_rooms")
public class ConsultingRooms implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	@OneToMany(mappedBy = "consultingRooms", cascade = CascadeType.ALL)
	private List<User> userList;

	public ConsultingRooms() {
		// TODO Auto-generated constructor stub
	}

	public ConsultingRooms(String description) {
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "ConsultingRooms [id=" + id + ", description=" + description + "]";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 7947136898976517112L;

}
