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

import com.enrique.dents.entity.TypeMeetings;
import com.enrique.dents.services.TypeMeetingsService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.request.TypeMeetingsSaveReq;
import com.enrique.dents.utils.request.TypeMeetingsUpdateReq;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.TypeUserList;

/**
 * @author Jose Enrique Vergara
 *
 */
@CrossOrigin
@RestController
@RequestMapping("typeMeetings")
public class TypeMeetingsController {

	@Autowired
	private TypeMeetingsService typeMeetingsService;

	@GetMapping("/list")
	public List<TypeUserList> index() {
		List<TypeUserList> list = new ArrayList<>();
		for (TypeMeetings item : this.typeMeetingsService.findAll()) {
			list.add(new TypeUserList(item.getId(), item.getDescription()));
		}
		return list;
	}

	@PostMapping("/save")
	public GenericSuccesResp save(@RequestBody TypeMeetingsSaveReq typeMeetingsSaveReq) {
		if (typeMeetingsSaveReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			this.typeMeetingsService.save(new TypeMeetings(typeMeetingsSaveReq.getDescription()));
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._SAVED_MSG.getDescripcion());
		}
	}

	@PostMapping("/update")
	public GenericSuccesResp update(@RequestBody TypeMeetingsUpdateReq typeMeetingsUpdateReq) {
		if (typeMeetingsUpdateReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			TypeMeetings typeMeetings = new TypeMeetings(typeMeetingsUpdateReq.getDescription());
			typeMeetings.setId(typeMeetingsUpdateReq.getId());
			this.typeMeetingsService.save(typeMeetings);
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._UPDATED_MSG.getDescripcion());
		}
	}
}
