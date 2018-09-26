package com.enrique.dents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.services.UserAddressService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.UserAddressSaveUpdateReq;
import com.enrique.dents.utils.response.GenericResp;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.UserAddressResp;

/**
 * @author Jose Enrique Vergara
 * END POINT PARA GUARDAR, ACTUALZIAR Y OBTENER INFORMACIÓN DE DMICILIO DE CUALQUIER USUARIO !
 */
@CrossOrigin
@RestController
@RequestMapping("userAddress")
public class UserAddressController {

	@Autowired
	private UserAddressService userAddressService;

	/**
	 * @param userId	-	id de usuario con el que se liga toda información personal
	 * @return	status success => all right (USER ADDRESS) or USER ADDRESS INCOMPLETE
	 */
	@GetMapping("findByUser")
	public GenericResp findByUser(@RequestParam Long userId) {
		UserAddressResp resp = this.userAddressService.findByUser(userId);
		if (resp == null) {
			return new GenericResp(Status._USER_NOT_FOUND.getDescripcion(),
					Messages._USER_ADDRESS_INCOMPLETE.getDescripcion(), resp);
		} else if (resp.getId() == 0l) {
			return new GenericResp(Status._SUCCESS.getDescripcion(), Messages._USER_ADDRESS_INCOMPLETE.getDescripcion(),
					resp);
		} else {
			return new GenericResp(Status._SUCCESS.getDescripcion(), Messages._USER_ADDRESS.getDescripcion(), resp);
		}
	}

	/**
	 * @param req	-	RECIBE TODOS LOS PARAMETROS, NINGUNO DEBE VENIR NULLO O VACIO
	 * @return	-	RESPONDE UNA RESPUES GENERICA SAVED O UPDATED
	 */
	@PostMapping("saveUpdate")
	public GenericSuccesResp saveUpdate(@RequestBody UserAddressSaveUpdateReq req) {
		if (req.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			String response = this.userAddressService.saveUpdate(req);
			return new GenericSuccesResp(Status._SUCCESS.getDescripcion(), response);
		}
	}
}
