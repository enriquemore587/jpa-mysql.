package com.enrique.dents.dao;

import org.springframework.data.repository.CrudRepository;

import com.enrique.dents.entity.Profile;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface ProfileDao extends CrudRepository<Profile, Long> {

}