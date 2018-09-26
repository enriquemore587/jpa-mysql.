-- INSERT TO civil_status
INSERT INTO civil_status ( description ) values("SOLTERO (A)");
INSERT INTO civil_status ( description ) values("CASADO (A)");

-- INSERT TO profiles
INSERT INTO profiles ( description ) values("PACIENTE");
INSERT INTO profiles ( description ) values("DOCTOR");
INSERT INTO profiles ( description ) values("MOBILE");

-- INSERT TO type_users
INSERT INTO type_users ( description ) values("MOBILE");
INSERT INTO type_users ( description ) values("WEB");
INSERT INTO type_users ( description ) values("MOBILE & WEB");

-- INSERT TO consulting_rooms
INSERT INTO consulting_rooms ( description ) values("VERGARA");
INSERT INTO consulting_rooms ( description ) values("VILLADENT");
INSERT INTO consulting_rooms ( description ) values("THE BEST DENT");

-- INSERT TO type_meetings
INSERT INTO type_meetings ( description ) values("PRESUPUESTO");
INSERT INTO type_meetings ( description ) values("NORMAL");

-- INSERT TO meeting_category
INSERT INTO meeting_category ( description ) values("LIMPIEZA");
INSERT INTO meeting_category ( description ) values("CIRUGIA");
INSERT INTO meeting_category ( description ) values("BRACKETS");

/*
INSERT INTO users (create_at, level, moment_starts_session, password , user_name, consulting_room_id, profile_id, type_user_id)
VALUES('2018-09-17 15:23:38',	1,	'2018-09-17 15:23:38',	'123',	'doctor@hotmail.com',	1,	1,	1);

INSERT INTO users (create_at, level, moment_starts_session, password , user_name, consulting_room_id, profile_id, type_user_id)
VALUES('2018-09-17 15:23:38',	1,	'2018-09-17 15:23:38',	'123',	'paciente1@hotmail.com',	1,	1,	1);
INSERT INTO users (create_at, level, moment_starts_session, password , user_name, consulting_room_id, profile_id, type_user_id)
VALUES('2018-09-17 15:23:38',	1,	'2018-09-17 15:23:38',	'123',	'paciente2@hotmail.com',	1,	1,	1);
INSERT INTO users (create_at, level, moment_starts_session, password , user_name, consulting_room_id, profile_id, type_user_id)
VALUES('2018-09-17 15:23:38',	1,	'2018-09-17 15:23:38',	'123',	'paciente3@hotmail.com',	1,	1,	1);

**/