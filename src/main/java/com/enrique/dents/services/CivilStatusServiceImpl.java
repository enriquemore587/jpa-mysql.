package com.enrique.dents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enrique.dents.dao.CivilStatusDao;
import com.enrique.dents.entity.CivilStatus;

/**
 * @author Jose Enrique Vergara
 *
 */
@Service
public class CivilStatusServiceImpl implements CivilStatusService {

	@Autowired
	private CivilStatusDao civilStatusDao;

	@Override
	@Transactional(readOnly = true)
	public List<CivilStatus> findAll() {
		return (List<CivilStatus>) this.civilStatusDao.findAll();
	}

	@Override
	public void save(CivilStatus civilStatus) {
		this.civilStatusDao.save(civilStatus);
	}

}
