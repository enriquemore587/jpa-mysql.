package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.MeetingCategory;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface MeetingCategoryService {

	public List<MeetingCategory> findAll();

	public void save(MeetingCategory meetingCategory);
	
}
