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

import com.enrique.dents.entity.ConsultingRooms;
import com.enrique.dents.services.ConsultingRoomsService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.request.ConsultingRoomsSaveReq;
import com.enrique.dents.utils.request.ConsultingRoomsUpdateReq;
import com.enrique.dents.utils.response.ConsultingRoomsList;
import com.enrique.dents.utils.response.GenericSuccesResp;

/**
 * @author Jose Enrique Vergara
 *
 */
@CrossOrigin
@RestController
@RequestMapping("consultingRooms")
public class ConsultingRoomsController {

	@Autowired
	private ConsultingRoomsService consultingRoomsService;

	@GetMapping("/list")
	public List<ConsultingRoomsList> index() {
		List<ConsultingRoomsList> list = new ArrayList<>();
		for (ConsultingRooms item : this.consultingRoomsService.findAll()) {
			list.add(new ConsultingRoomsList(item.getId(), item.getDescription()));
		}
		return list;
	}

	@PostMapping("/save")
	public GenericSuccesResp save(@RequestBody ConsultingRoomsSaveReq consultingRoomsSaveReq) {
		if (consultingRoomsSaveReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			this.consultingRoomsService.save(new ConsultingRooms(consultingRoomsSaveReq.getDescription()));
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._SAVED_MSG.getDescripcion());
		}
	}

	@PostMapping("/update")
	public GenericSuccesResp update(@RequestBody ConsultingRoomsUpdateReq consultingRoomsUpdateReq) {
		if (consultingRoomsUpdateReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			ConsultingRooms consultingRooms = new ConsultingRooms(consultingRoomsUpdateReq.getDescription());
			consultingRooms.setId(consultingRoomsUpdateReq.getId());
			this.consultingRoomsService.save(consultingRooms);
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._UPDATED_MSG.getDescripcion());
		}
	}
}
