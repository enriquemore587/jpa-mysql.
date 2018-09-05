package com.enrique.dents.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.entity.CivilStatus;
import com.enrique.dents.services.CivilStatusService;
import com.enrique.dents.utils.enums.StatusMessages;
import com.enrique.dents.utils.request.CivilStatusSaveReq;
import com.enrique.dents.utils.request.CivilStatusUpdateReq;
import com.enrique.dents.utils.response.CivilStatusList;
import com.enrique.dents.utils.response.GenericSuccesResp;

/**
 * @author Jose Enrique Vergara
 *
 */
@RestController
@RequestMapping("civilStatus")
public class CivilStatusController {

	@Autowired
	private CivilStatusService civilStatusService;

	@GetMapping("/list")
	public List<CivilStatusList> index() {
		List<CivilStatusList> list = new ArrayList<>();
		for (CivilStatus item : this.civilStatusService.findAll()) {
			list.add(new CivilStatusList(item.getId(), item.getDescription()));
		}
		return list;
	}

	@PostMapping("/save")
	public GenericSuccesResp save(@RequestBody CivilStatusSaveReq civilStatusSaveReq) {
		if (civilStatusSaveReq.okData()) {
			return new GenericSuccesResp(StatusMessages._MISSING_PARAMS_STATUS.getDescripcion(),
					StatusMessages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			this.civilStatusService.save(new CivilStatus(civilStatusSaveReq.getDescription()));
			return new GenericSuccesResp(StatusMessages._SUCCESS_STATUS.getDescripcion(),
					StatusMessages._SAVED_MSG.getDescripcion());
		}
	}
	
	@PostMapping("/update")
	public GenericSuccesResp update(@RequestBody CivilStatusUpdateReq civilStatusUpdateReq) {
		if (civilStatusUpdateReq.okData()) {
			return new GenericSuccesResp(StatusMessages._MISSING_PARAMS_STATUS.getDescripcion(),
					StatusMessages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			CivilStatus civilStatus = new CivilStatus(civilStatusUpdateReq.getDescription());
			civilStatus.setId(civilStatusUpdateReq.getId());
			this.civilStatusService.save(civilStatus);
			return new GenericSuccesResp(StatusMessages._SUCCESS_STATUS.getDescripcion(),
					StatusMessages._UPDATED_MSG.getDescripcion());
		}
	}
}
