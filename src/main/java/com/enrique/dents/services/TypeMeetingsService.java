package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.TypeMeetings;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface TypeMeetingsService {

	public List<TypeMeetings> findAll();

	public void save(TypeMeetings typeMeetings);
	
}
