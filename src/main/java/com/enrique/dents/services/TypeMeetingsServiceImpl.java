package com.enrique.dents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enrique.dents.dao.TypeMeetingsDao;
import com.enrique.dents.entity.TypeMeetings;


/**
 * @author Jose Enrique Vergara
 *
 */
@Service
public class TypeMeetingsServiceImpl implements TypeMeetingsService {

	@Autowired
	private TypeMeetingsDao typeMeetingsDao;

	@Override
	@Transactional(readOnly = true)
	public List<TypeMeetings> findAll() {
		return (List<TypeMeetings>) this.typeMeetingsDao.findAll();
	}

	@Override
	public void save(TypeMeetings typeMeetings) {
		this.typeMeetingsDao.save(typeMeetings);
	}

}
