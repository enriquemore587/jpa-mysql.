package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.TypeUser;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface TypeUserService {

	public List<TypeUser> findAll();

	public void save(TypeUser typeUser);
	
}
