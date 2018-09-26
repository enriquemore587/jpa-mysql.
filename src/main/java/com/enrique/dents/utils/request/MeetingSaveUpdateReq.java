package com.enrique.dents.utils.request;

public class MeetingSaveUpdateReq {
	
	private Long meetingId;

	private String date_meeting;

	private String start_meeting;

	private String end_meeting;

	private Boolean is_important;

	private Float cost;

	private Boolean meeting_done;

	private Boolean paid;

	private Float debt;

	private Long doctorId;

	private Long patientId;

	private Long typeMeetingsId;

	private Long meetingCategoryId;

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public String getDate_meeting() {
		return date_meeting;
	}

	public void setDate_meeting(String date_meeting) {
		this.date_meeting = date_meeting;
	}

	public String getStart_meeting() {
		return start_meeting;
	}

	public void setStart_meeting(String start_meeting) {
		this.start_meeting = start_meeting;
	}

	public String getEnd_meeting() {
		return end_meeting;
	}

	public void setEnd_meeting(String end_meeting) {
		this.end_meeting = end_meeting;
	}

	public Boolean getIs_important() {
		return is_important;
	}

	public void setIs_important(Boolean is_important) {
		this.is_important = is_important;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Boolean getMeeting_done() {
		return meeting_done;
	}

	public void setMeeting_done(Boolean meeting_done) {
		this.meeting_done = meeting_done;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Float getDebt() {
		return debt;
	}

	public void setDebt(Float debt) {
		this.debt = debt;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getTypeMeetingsId() {
		return typeMeetingsId;
	}

	public void setTypeMeetingsId(Long typeMeetingsId) {
		this.typeMeetingsId = typeMeetingsId;
	}

	public Long getMeetingCategoryId() {
		return meetingCategoryId;
	}

	public void setMeetingCategoryId(Long meetingCategoryId) {
		this.meetingCategoryId = meetingCategoryId;
	}

	@Override
	public String toString() {
		return "MeetingSaveUpdateReq [meetingId=" + meetingId + ", date_meeting=" + date_meeting + ", start_meeting="
				+ start_meeting + ", end_meeting=" + end_meeting + ", is_important=" + is_important + ", cost=" + cost
				+ ", meeting_done=" + meeting_done + ", paid=" + paid + ", debt=" + debt + ", doctorId=" + doctorId
				+ ", patientId=" + patientId + ", typeMeetingsId=" + typeMeetingsId + ", meetingCategoryId="
				+ meetingCategoryId + "]";
	}

}
