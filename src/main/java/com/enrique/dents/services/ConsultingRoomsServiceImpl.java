package com.enrique.dents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrique.dents.dao.ConsultingRoomsDao;
import com.enrique.dents.entity.ConsultingRooms;

@Service
public class ConsultingRoomsServiceImpl implements ConsultingRoomsService {
	
	@Autowired
	private ConsultingRoomsDao consultingRoomsDao;

	@Override
	public List<ConsultingRooms> findAll() {
		return (List<ConsultingRooms>) this.consultingRoomsDao.findAll();
	}

	@Override
	public void save(ConsultingRooms consultingRooms) {
		this.consultingRoomsDao.save(consultingRooms);
	}

}
