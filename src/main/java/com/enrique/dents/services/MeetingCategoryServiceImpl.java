package com.enrique.dents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enrique.dents.dao.MeetingCategoryDao;
import com.enrique.dents.entity.MeetingCategory;

/**
 * @author Jose Enrique Vergara
 *
 */
@Service
public class MeetingCategoryServiceImpl implements MeetingCategoryService {

	@Autowired
	private MeetingCategoryDao deetingCategoryDao;

	@Override
	@Transactional(readOnly = true)
	public List<MeetingCategory> findAll() {
		return (List<MeetingCategory>) this.deetingCategoryDao.findAll();
	}

	@Override
	public void save(MeetingCategory meetingCategory) {
		this.deetingCategoryDao.save(meetingCategory);
	}

}
