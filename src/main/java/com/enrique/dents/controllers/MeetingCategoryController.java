package com.enrique.dents.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.entity.MeetingCategory;
import com.enrique.dents.services.MeetingCategoryService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.request.MeetingCategorySaveReq;
import com.enrique.dents.utils.request.MeetingCategoryUpdateReq;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.MeetingCategoryList;

/**
 * @author Jose Enrique Vergara
 *
 */
@RestController
@RequestMapping("meetingCategory")
public class MeetingCategoryController {

	@Autowired
	private MeetingCategoryService meetingCategoryService;

	@GetMapping("/list")
	public List<MeetingCategoryList> index() {
		List<MeetingCategoryList> list = new ArrayList<>();
		for (MeetingCategory item : this.meetingCategoryService.findAll()) {
			list.add(new MeetingCategoryList(item.getId(), item.getDescription()));
		}
		return list;
	}

	@PostMapping("/save")
	public GenericSuccesResp save(@RequestBody MeetingCategorySaveReq meetingCategorySaveReq) {
		if (meetingCategorySaveReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			this.meetingCategoryService.save(new MeetingCategory(meetingCategorySaveReq.getDescription()));
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._SAVED_MSG.getDescripcion());
		}
	}

	@PostMapping("/update")
	public GenericSuccesResp update(@RequestBody MeetingCategoryUpdateReq meetingCategoryUpdateReq) {
		if (meetingCategoryUpdateReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			MeetingCategory meetingCategory = new MeetingCategory(meetingCategoryUpdateReq.getDescription());
			meetingCategory.setId(meetingCategoryUpdateReq.getId());
			this.meetingCategoryService.save(meetingCategory);
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._UPDATED_MSG.getDescripcion());
		}
	}
}
