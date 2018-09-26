package com.enrique.dents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.services.MeetingsService;
import com.enrique.dents.utils.enums.Constants;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.MeetingSaveUpdateReq;
import com.enrique.dents.utils.response.GenericSuccesResp;

@CrossOrigin
@RestController
@RequestMapping("/meetings")
public class MeetingsController {

	@Autowired
	public MeetingsService meetingsService;

	@GetMapping("findByDoctor")
	public String findByDoctor(@RequestParam Long userId) {
		return this.meetingsService.findByDoctor(userId);
	}

	@PostMapping("saveUpdate")
	public GenericSuccesResp saveUpdate(@RequestBody MeetingSaveUpdateReq meetingSaveUpdateReq) {
		GenericSuccesResp resp = null;
		String respuesta = this.meetingsService.saveUpdate(meetingSaveUpdateReq);
		if (respuesta == Status._SUCCESS.getDescripcion() || respuesta == Status._UPDATED.getDescripcion()) {
			resp = new GenericSuccesResp(Status._SUCCESS.getDescripcion(), respuesta);
		} else {
			resp = new GenericSuccesResp(Constants._INFORMATION_NOT_STORED.getDescripcion(), respuesta);
		}
		return resp;
	}
}
