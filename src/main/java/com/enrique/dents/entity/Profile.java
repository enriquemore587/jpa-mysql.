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
 * ENTIDAD CREADA PARA IDENTIFICAR EL PERFIL DEL USUARIO
 * 1.- DOCTORES
 * 3.- PACIENTES
 * @author Jose Enrique Vergara
 *
 */
@Entity
@Table(name = "profiles")
public class Profile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	@OneToMany(mappedBy = "profile")
	private List<User> userList;

	public Profile() {
	}

	public Profile(String description) {
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
		return "Profile [id=" + id + ", description=" + description + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5384254073162498739L;
}