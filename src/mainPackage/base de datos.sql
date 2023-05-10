create database if not exists BDDbatalla;

use BDDbatalla;

create table if not exists weapons(
	weapon_id			int				PRIMARY KEY AUTO_INCREMENT,
    weapon_name			varchar(100)	NOT NULL,
    weapon_image_path	varchar(100) 	NOT NULL,
    weapon_power		int				NOT NULL,
    weapon_speed		int				NOT NULL
);

create table if not exists warriors(
	warrior_id			int				PRIMARY KEY AUTO_INCREMENT,
    warrior_name		varchar(100)	NOT NULL,
    warrior_image_path	varchar(100) 	NOT NULL
);

create table if not exists players(
	player_id			int				PRIMARY KEY AUTO_INCREMENT,
    player_name			varchar(100)	NOT NULL
);

create table if not exists weapons_available(
	weapon_id			int,
    warrior_id			int,
    FOREIGN KEY	(warrior_id)	REFERENCES	warriors	(warrior_id),
    FOREIGN KEY	(weapon_id)		REFERENCES	weapons		(weapon_id)
);

create table if not exists battle(
	battle_id			int				PRIMARY KEY AUTO_INCREMENT,
    player_id			int,
    warrior_id			int,
    warrior_weapon_id	int,
    opponent_id			int,
    opponent_weapon_id 	int,
    injuries_caused		int,
    injuries_suffered	int,
    battle_points		int,
    FOREIGN KEY	(warrior_weapon_id)		REFERENCES	weapons		(weapon_id),
    FOREIGN KEY	(warrior_id)			REFERENCES	warriors	(warrior_id),
    FOREIGN KEY	(player_id)				REFERENCES	players		(player_id),
    FOREIGN KEY	(opponent_id)			REFERENCES	players		(player_id),
    FOREIGN KEY	(opponent_weapon_id)	REFERENCES	weapons		(weapon_id)
);
