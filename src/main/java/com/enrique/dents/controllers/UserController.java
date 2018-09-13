package com.enrique.dents.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.dents.entity.User;
import com.enrique.dents.services.UserService;
import com.enrique.dents.utils.enums.Messages;
import com.enrique.dents.utils.enums.Status;
import com.enrique.dents.utils.request.UserLoginReq;
import com.enrique.dents.utils.request.UserRegisterReq;
import com.enrique.dents.utils.response.GenericResp;
import com.enrique.dents.utils.response.GenericSuccesResp;
import com.enrique.dents.utils.response.UserList;

/**
 * CONTROLADOR RESPONSABLE DE PROCESOS RELACIONADOS A USUARIOS COMO LOGIN,
 * REGISTRO, LISTADOS, ETC.
 * 
 * @author Jose Enrique Vergara
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public List<UserList> index() {
		List<UserList> list = new ArrayList<>();
		for (User item : this.userService.findAll()) {
			list.add(new UserList(item.getUserName(), item.getPassword()));
		}
		return list;
	}

	/**
	 * END-POINT DONDE SE REGISTRA UN NUEVO USUARIO.
	 * 
	 * @param userRegisterReq - MODELO PARA REGISTRAR: { "user_name":
	 *                        "correo@correo.com", "password": "********",
	 *                        "consulting_room_id": 1, "profile_id": 1,
	 *                        "type_user_id": 1, "level": 1 }
	 * @return - RETORNA POJO QUE CONTIENEUN STATUS Y MENSAJE:{ "status": "SUCCESS",
	 *         "message": "SAVED" }
	 */
	@PostMapping("/register")
	public GenericSuccesResp register(@RequestBody UserRegisterReq userRegisterReq) {
		if (userRegisterReq.okData()) {
			return new GenericSuccesResp(Messages._MISSING_PARAMS_STATUS.getDescripcion(),
					Messages._MISSING_PARAMS_MSG.getDescripcion());
		} else {
			User user = new User(userRegisterReq.getUser_name(), userRegisterReq.getPassword());
			String response = this.userService.register(user, userRegisterReq.getConsulting_room_id(),
					userRegisterReq.getProfile_id(), userRegisterReq.getType_user_id(), userRegisterReq.getLevel());
			if (response == Status._SUCCESS.getDescripcion()) {
				return new GenericSuccesResp(Messages._SUCCESS_STATUS.getDescripcion(),
						Messages._SAVED_MSG.getDescripcion());
			} else {
				return new GenericSuccesResp(Messages._UNREGISTERED_USER.getDescripcion(), response);
			}
		}
	}

	/**
	 * END-POINT PARA INICIO DE SESIÓN DE LOS USUARIOS.
	 * 
	 * @param userLoginReq - TODOS LOS CAMPOS SON REQUERIDOS: {
	 *                     "user_name":"correo@correo.com",
	 *                     "password":"**************" }
	 * @return	-	RETORNA RESPUESTA ESTANDAR DE LA APP DONDE EL ATRIBUTO DATA PUEDE SER NULLO CUANDO NO SE LLEVA EL INICIO DE SESION CORRECTAMENTE
	 */
	@PostMapping("/login")
	public GenericResp login(@RequestBody UserLoginReq userLoginReq) {
		return this.userService.login(userLoginReq.getUser_name(), userLoginReq.getPassword());
	}

}
