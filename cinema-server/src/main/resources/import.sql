
-- the password hash is generated by BCrypt Calculator Generator(https://www.dailycred.com/article/bcrypt-calculator)
-- username : user
-- password : user

-- username : admin
-- password : user

INSERT INTO user (id, username, password, email, is_smoke_driver, is_music_driver, is_talk_driver, is_smoke_passenger, is_music_passenger, is_talk_passenger) VALUES (1, 'user', '$2a$04$u621Nu4PgrGGd730QPcXEO0b.hrlaDEBNav1LSjt6R/xMbYzYNEa.', 'test@test.com', false, false, false, false, false, false);
INSERT INTO user (id, username, password, email, is_smoke_driver, is_music_driver, is_talk_driver, is_smoke_passenger, is_music_passenger, is_talk_passenger) VALUES (2, 'admin', '$2a$04$u621Nu4PgrGGd730QPcXEO0b.hrlaDEBNav1LSjt6R/xMbYzYNEa.', 'admin@admin.com', false, false, false, false, false, false);

INSERT INTO authority (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);

-- INSERT INTO location (address, lat, lng) VALUES('Place du Capitole, 31000 Toulouse, France', 43.6044292,1.4438121000000592);
-- INSERT INTO location (address, lat, lng) VALUES('Barrière de Paris, 31200 Toulouse, France',43.63342919999999,1.428973400000018);
-- INSERT INTO location (address, lat, lng) VALUES('Barrière de Paris, 31200 Toulouse, France',43.63342919999999,1.428973400000018);
-- INSERT INTO location (address, lat, lng) VALUES('Place du Capitole, 31000 Toulouse, France', 43.6044292,1.4438121000000592);
	  
-- INSERT INTO trajet (driver_id, passengers_id, is_completed, date_departure, max_places, start_location_id, stop_location_id, path_back, hour_departure) VALUES (1, '1', true, CURRENT_TIMESTAMP, 4, 1, 2, false, '8:00');
-- INSERT INTO trajet (driver_id, passengers_id, is_completed, date_departure, max_places, start_location_id, stop_location_id, path_back, hour_departure) VALUES (2, '1', true, CURRENT_TIMESTAMP, 4, 3, 4, false, '8:00');

-- INSERT INTO contact (trajet_id, receiver_id, sender_id, message, date_sent) VALUES (1, 2, 1, 'bonjour', SYSDATE);
-- INSERT INTO contact (trajet_id, receiver_id, sender_id, message, date_sent) VALUES (2, 1, 2, 'bonjour', SYSDATE);
