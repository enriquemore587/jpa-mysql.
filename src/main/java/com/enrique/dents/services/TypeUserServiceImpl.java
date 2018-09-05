package com.enrique.dents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enrique.dents.dao.TypeUserDao;
import com.enrique.dents.entity.TypeUser;

/**
 * @author Jose Enrique Vergara
 *
 */
@Service
public class TypeUserServiceImpl implements TypeUserService {

	@Autowired
	private TypeUserDao typeUserDao;

	@Override

	@Transactional(readOnly = true)
	public List<TypeUser> findAll() {
		return (List<TypeUser>) this.typeUserDao.findAll();
	}

	@Override
	public void save(TypeUser typeUser) {
		this.typeUserDao.save(typeUser);
	}

}
