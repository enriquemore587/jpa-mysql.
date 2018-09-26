package com.enrique.dents.services;

import com.enrique.dents.utils.request.MeetingSaveUpdateReq;

public interface MeetingsService {
	public String findByDoctor(Long userId);
	
	public String saveUpdate(MeetingSaveUpdateReq meetingSaveUpdateReq);
}
