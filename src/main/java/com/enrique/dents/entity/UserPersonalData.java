package com.enrique.dents.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Jose Enrique Vergara
 *
 */
@Entity
@Table(name = "user_personal_data")
public class UserPersonalData implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(unique=true, nullable=false)
//	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(value="user", name = "property") )
	private Long id;

	private String name;
	private String last_name;
	private String last_name2;
	private String phone_number;
	private String mobile_phone_number;
	private String gender;

	@Temporal(TemporalType.DATE)
	private Date birthdate;
	private String important_note;

	@ManyToOne
	@JoinColumn(name = "civil_status_id")
	private CivilStatus civilStatus;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public UserPersonalData() {
	}

	public UserPersonalData(Long id, String name, String last_name, String last_name2, String phone_number,
			String mobile_phone_number, String gender, Date birthdate, String important_note) {
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.last_name2 = last_name2;
		this.phone_number = phone_number;
		this.mobile_phone_number = mobile_phone_number;
		this.gender = gender;
		this.birthdate = birthdate;
		this.important_note = important_note;
	}
	
	public UserPersonalData(String name, String last_name, String last_name2, String phone_number,
			String mobile_phone_number, String gender, Date birthdate, String important_note) {
		this.name = name;
		this.last_name = last_name;
		this.last_name2 = last_name2;
		this.phone_number = phone_number;
		this.mobile_phone_number = mobile_phone_number;
		this.gender = gender;
		this.birthdate = birthdate;
		this.important_note = important_note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLast_name2() {
		return last_name2;
	}

	public void setLast_name2(String last_name2) {
		this.last_name2 = last_name2;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMobile_phone_number() {
		return mobile_phone_number;
	}

	public void setMobile_phone_number(String mobile_phone_number) {
		this.mobile_phone_number = mobile_phone_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getImportant_note() {
		return important_note;
	}

	public void setImportant_note(String important_note) {
		this.important_note = important_note;
	}

	public CivilStatus getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPersonalData [id=" + id + ", name=" + name + ", last_name=" + last_name + ", last_name2="
				+ last_name2 + ", phone_number=" + phone_number + ", mobile_phone_number=" + mobile_phone_number
				+ ", gender=" + gender + ", birthdate=" + birthdate + ", important_note=" + important_note + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2107092155209282016L;
}
