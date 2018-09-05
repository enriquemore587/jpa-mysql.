package com.enrique.dents.services;

import java.util.List;

import com.enrique.dents.entity.CivilStatus;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface CivilStatusService {

	public List<CivilStatus> findAll();

	public void save(CivilStatus civilStatus);
	
}
