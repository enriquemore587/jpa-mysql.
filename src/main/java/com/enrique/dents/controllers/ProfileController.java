package com.enrique.dents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.entity.Profile;
import com.enrique.dents.services.ProfileService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.request.ProfileSaveReq;
import com.enrique.dents.utils.request.ProfileUpdateReq;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.ProfileList;

/**
 * @author Jose Enrique Vergara
 *
 */
@CrossOrigin
@RestController
@RequestMapping("profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/list")
	public List<ProfileList> index() {
		return this.profileService.findAll();
	}

	@PostMapping("/save")
	public GenericSuccesResp save(@RequestBody ProfileSaveReq profileSaveReq) {
		if (profileSaveReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			this.profileService.save(new Profile(profileSaveReq.getDescription()));
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._SAVED_MSG.getDescripcion());
		}
	}

	@PostMapping("/update")
	public GenericSuccesResp update(@RequestBody ProfileUpdateReq profileUpdateReq) {
		if (profileUpdateReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			Profile profile = new Profile(profileUpdateReq.getDescription());
			profile.setId(profileUpdateReq.getId());
			this.profileService.save(profile);
			return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
					Messages._UPDATED_MSG.getDescripcion());
		}
	}

}
