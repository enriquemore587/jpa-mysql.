package com.enrique.dents.utils.response;

public class UserAddressResp {
	private Long id;

	private String cp;
	private Integer state;
	private Integer municipality;
	private String colony;
	private String street;
	private String num_ext;
	private String num_int;
		
	public UserAddressResp(Long id) {
		this.id = id;
	}
	public UserAddressResp(Long id, String cp, Integer state, Integer municipality, String colony, String street,
			String num_ext, String num_int) {
		
		this.id = id;
		this.cp = cp;
		this.state = state;
		this.municipality = municipality;
		this.colony = colony;
		this.street = street;
		this.num_ext = num_ext;
		this.num_int = num_int;

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getMunicipality() {
		return municipality;
	}
	public void setMunicipality(Integer municipality) {
		this.municipality = municipality;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNum_ext() {
		return num_ext;
	}
	public void setNum_ext(String num_ext) {
		this.num_ext = num_ext;
	}
	public String getNum_int() {
		return num_int;
	}
	public void setNum_int(String num_int) {
		this.num_int = num_int;
	}
}
