package com.enrique.dents.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Jose Enrique Vergara
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user_name", unique = true)
	private String userName;
	private String password;

	@ManyToOne
	@JoinColumn(name = "type_user_id")
	private TypeUser typeUser;

	@ManyToOne
	@JoinColumn(name = "consulting_room_id")
	private ConsultingRooms consultingRooms;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserAddress userAddress;

	@OneToOne(mappedBy = "user")
	private UserPersonalData userPersonalData;

	@OneToMany(mappedBy = "doctor")
	private List<Meetings> doctors = new ArrayList<Meetings>();

	@OneToMany(mappedBy = "patient")
	private List<Meetings> patients = new ArrayList<Meetings>();

	private Integer level;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date momentStartsSession;

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.createAt = new Date();
		this.momentStartsSession = new Date();
		this.level = 1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}

	public ConsultingRooms getConsultingRooms() {
		return consultingRooms;
	}

	public void setConsultingRooms(ConsultingRooms consultingRooms) {
		this.consultingRooms = consultingRooms;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public UserPersonalData getUserPersonalData() {
		return userPersonalData;
	}

	public void setUserPersonalData(UserPersonalData userPersonalData) {
		this.userPersonalData = userPersonalData;
	}

	public List<Meetings> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Meetings> doctors) {
		this.doctors = doctors;
	}

	public List<Meetings> getPatients() {
		return patients;
	}

	public void setPatients(List<Meetings> patients) {
		this.patients = patients;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getMomentStartsSession() {
		return momentStartsSession;
	}

	public void setMomentStartsSession(Date momentStartsSession) {
		this.momentStartsSession = momentStartsSession;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3102652220804526629L;

}
