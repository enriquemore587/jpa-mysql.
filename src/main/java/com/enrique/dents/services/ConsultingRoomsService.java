package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.ConsultingRooms;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface ConsultingRoomsService {

	public List<ConsultingRooms> findAll();

	public void save(ConsultingRooms consultingRooms);
	
}
