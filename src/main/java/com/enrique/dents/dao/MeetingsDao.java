package com.enrique.dents.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.enrique.dents.entity.Meetings;
import com.enrique.dents.entity.User;

public interface MeetingsDao extends CrudRepository<Meetings, Long> {
	public List<Meetings> findByDoctor(User user);
}
