package com.enrique.dents.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrique.dents.dao.MeetingCategoryDao;
import com.enrique.dents.dao.MeetingsDao;
import com.enrique.dents.dao.TypeMeetingsDao;
import com.enrique.dents.dao.UserDao;
import com.enrique.dents.entity.MeetingCategory;
import com.enrique.dents.entity.Meetings;
import com.enrique.dents.entity.TypeMeetings;
import com.enrique.dents.entity.User;
import com.enrique.dents.utils.enums.Constants;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.MeetingSaveUpdateReq;

@Service
public class MeetingsServiceImpl implements MeetingsService {

	@Autowired
	private MeetingsDao meetingsDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private MeetingCategoryDao meetingCategoryDao;

	@Autowired
	private TypeMeetingsDao typeMeetingsDao;

	@Override
	public String findByDoctor(Long userId) {
		List<Meetings> meetingList = null;
		String rsp = "";
		Optional<User> user = this.userDao.findById(userId);
		if (user.isPresent()) {
			meetingList = this.meetingsDao.findByDoctor(user.get());
		}
		rsp = meetingList.toString();
		return rsp;
	}

	@Override
	public String saveUpdate(MeetingSaveUpdateReq meetingSaveUpdateReq) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		Meetings meetings = new Meetings();
		try {
			Date date_meeting = format.parse(meetingSaveUpdateReq.getDate_meeting());
			Date end_meeting = format2.parse(meetingSaveUpdateReq.getEnd_meeting() + ":00");
			Date start_meeting = format2.parse(meetingSaveUpdateReq.getStart_meeting() + ":00");
			Optional<User> doctor = this.userDao.findById(meetingSaveUpdateReq.getDoctorId());

			if (!doctor.isPresent()) {
				return Status._DOCTOR_NOT_FOUND.getDescripcion();
			} else {
				Optional<MeetingCategory> meetingCategory = this.meetingCategoryDao
						.findById(meetingSaveUpdateReq.getMeetingCategoryId());
				if (!meetingCategory.isPresent()) {
					return Status._MEETING_CATEGORY_NOT_FOUND.getDescripcion();
				} else {
					Optional<User> patient = this.userDao.findById(meetingSaveUpdateReq.getPatientId());
					if (!patient.isPresent()) {
						return Status._PATIENT_NOT_FOUND.getDescripcion();
					} else {
						Optional<TypeMeetings> typeMeetings = this.typeMeetingsDao
								.findById(meetingSaveUpdateReq.getTypeMeetingsId());
						if (!typeMeetings.isPresent()) {
							return Status._TYPE_MEETINGS.getDescripcion();
						} else {
							meetings.setCost(meetingSaveUpdateReq.getCost());
							meetings.setDate_meeting(date_meeting);
							meetings.setDebt(meetingSaveUpdateReq.getDebt());
							meetings.setDoctor(doctor.get());
							meetings.setEnd_meeting(end_meeting);
							meetings.setIs_important(meetingSaveUpdateReq.getIs_important());
							meetings.setMeeting_done(meetingSaveUpdateReq.getMeeting_done());
							meetings.setMeetingCategory(meetingCategory.get());
							meetings.setPaid(meetingSaveUpdateReq.getPaid());
							meetings.setPatient(patient.get());
							meetings.setStart_meeting(start_meeting);
							meetings.setTypeMeetings(typeMeetings.get());
							if (meetingSaveUpdateReq.getMeetingId() != 0l) {
								meetings.setId(meetingSaveUpdateReq.getMeetingId());
							}
							this.meetingsDao.save(meetings);
							return Status._SUCCESS.getDescripcion();
						}
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return Constants._ERROR_DATE_FORMAT.getDescripcion();
		}
	}

}
