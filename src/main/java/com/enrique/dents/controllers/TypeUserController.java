package com.enrique.dents.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.entity.TypeUser;
import com.enrique.dents.services.TypeUserService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.request.TypeUserSaveReq;
import com.enrique.dents.utils.request.TypeUserUpdateReq;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.TypeUserList;

/**
 * @author Jose Enrique Vergara
 *
 */
@CrossOrigin
@RestController
@RequestMapping("typeUser")
public class TypeUserController {

	@Autowired
	private TypeUserService typeUserService;

	@GetMapping("/list")
	public List<TypeUserList> index() {
		List<TypeUserList> list = new ArrayList<>();
		for (TypeUser item : this.typeUserService.findAll()) {
			list.add(new TypeUserList(item.getId(), item.getDescription()));
		}
		return list;
	}

	@PostMapping("/save")
	public GenericSuccesResp save(@RequestBody TypeUserSaveReq typeUserSaveReq) {
		if (typeUserSaveReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			this.typeUserService.save(new TypeUser(typeUserSaveReq.getDescription()));
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._SAVED_MSG.getDescripcion());
		}
	}

	@PostMapping("/update")
	public GenericSuccesResp update(@RequestBody TypeUserUpdateReq typeUserUpdateReq) {
		if (typeUserUpdateReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			TypeUser typeUser = new TypeUser(typeUserUpdateReq.getDescription());
			typeUser.setId(typeUserUpdateReq.getId());
			this.typeUserService.save(typeUser);
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._UPDATED_MSG.getDescripcion());
		}
	}
}
