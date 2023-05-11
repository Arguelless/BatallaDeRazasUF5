use BDDbatalla;

#Inserció  armes

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Dagger", "./src/Images/Dagger.jpg", 0, 3);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Sword", "./src/Images/Sword.jpg", 1, 1);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Axe", "./src/Images/Axe.jpg", 0, 3);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Double Swords", "./src/Images/Double Swords.jpg", 2, 2);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Scimitarr", "./src/Images/Scimitarr.jpg", 2, 1);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Bow", "./src/Images/Bow.jpg", 1, 5);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Katana", "./src/Images/Katana.jpg", 2, 3);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Dirk", "./src/Images/Dirk.jpg", 0, 4);

insert into weapons (weapon_name, weapon_image_path, weapon_power, weapon_speed) 
values ("Two handed axe", "./src/Images/Two handed axe.jpg", 5, 0);

#Race insertion

insert into races (race_name, health, power, defense, agility, speed)
values ("Elf", 40, 4, 2, 7, 7);

insert into races (race_name, health, power, defense, agility, speed)
values ("Human", 50, 5, 3, 6, 5);

insert into races (race_name, health, power, defense, agility, speed)
values ("Dwarf", 60, 6, 4, 5, 3);

#Inserció  guerrers

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Maedhros", "./src/Images/Elf1.jpg", 1);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Miriel", "./src/Images/Elf2.jpg", 1);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Feanor", "./src/Images/Elf3.jpg", 1);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Arthur", "./src/Images/Human1.jpg", 2);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Drogo", "./src/Images/Human2.jpg", 2);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Benedict", "./src/Images/Human3.jpg", 2);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Gregory", "./src/Images/Dwarf1.jpg", 3);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Haywood", "./src/Images/Dwarf2.jpg", 3);

insert into warriors (warrior_name, warrior_image_path, warrior_race) 
values ("Jeremiah", "./src/Images/Dwarf3.jpg", 3);

#Insert weapons by race

insert into weapons_available (weapon_id, warrior_id)
values (1, 4);

insert into weapons_available (weapon_id, warrior_id)
values (1, 5);

insert into weapons_available (weapon_id, warrior_id)
values (1, 6);

insert into weapons_available (weapon_id, warrior_id)
values (1, 1);

insert into weapons_available (weapon_id, warrior_id)
values (1, 2);

insert into weapons_available (weapon_id, warrior_id)
values (1, 3);

insert into weapons_available (weapon_id, warrior_id)
values (2, 1);

insert into weapons_available (weapon_id, warrior_id)
values (2, 2);

insert into weapons_available (weapon_id, warrior_id)
values (2, 3);

insert into weapons_available (weapon_id, warrior_id)
values (2, 4);

insert into weapons_available (weapon_id, warrior_id)
values (2, 5);

insert into weapons_available (weapon_id, warrior_id)
values (2, 6);

insert into weapons_available (weapon_id, warrior_id)
values (2, 7);

insert into weapons_available (weapon_id, warrior_id)
values (2, 8);

insert into weapons_available (weapon_id, warrior_id)
values (2, 9);

insert into weapons_available (weapon_id, warrior_id)
values (3, 4);

insert into weapons_available (weapon_id, warrior_id)
values (3, 5);

insert into weapons_available (weapon_id, warrior_id)
values (3, 6);

insert into weapons_available (weapon_id, warrior_id)
values (3, 7);

insert into weapons_available (weapon_id, warrior_id)
values (3, 8);

insert into weapons_available (weapon_id, warrior_id)
values (3, 9);

insert into weapons_available (weapon_id, warrior_id)
values (4, 1);

insert into weapons_available (weapon_id, warrior_id)
values (4, 2);

insert into weapons_available (weapon_id, warrior_id)
values (4, 3);

insert into weapons_available (weapon_id, warrior_id)
values (4, 4);

insert into weapons_available (weapon_id, warrior_id)
values (4, 5);

insert into weapons_available (weapon_id, warrior_id)
values (4, 6);

insert into weapons_available (weapon_id, warrior_id)
values (5, 1);

insert into weapons_available (weapon_id, warrior_id)
values (5, 2);

insert into weapons_available (weapon_id, warrior_id)
values (5, 3);

insert into weapons_available (weapon_id, warrior_id)
values (5, 4);

insert into weapons_available (weapon_id, warrior_id)
values (5, 5);

insert into weapons_available (weapon_id, warrior_id)
values (5, 6);

insert into weapons_available (weapon_id, warrior_id)
values (6, 1);

insert into weapons_available (weapon_id, warrior_id)
values (6, 2);

insert into weapons_available (weapon_id, warrior_id)
values (6, 3);

insert into weapons_available (weapon_id, warrior_id)
values (7, 4);

insert into weapons_available (weapon_id, warrior_id)
values (7, 5);

insert into weapons_available (weapon_id, warrior_id)
values (7, 6);

insert into weapons_available (weapon_id, warrior_id)
values (8, 1);

insert into weapons_available (weapon_id, warrior_id)
values (8, 2);

insert into weapons_available (weapon_id, warrior_id)
values (8, 3);

insert into weapons_available (weapon_id, warrior_id)
values (8, 4);

insert into weapons_available (weapon_id, warrior_id)
values (8, 5);

insert into weapons_available (weapon_id, warrior_id)
values (8, 6);

insert into weapons_available (weapon_id, warrior_id)
values (8, 7);

insert into weapons_available (weapon_id, warrior_id)
values (8, 8);

insert into weapons_available (weapon_id, warrior_id)
values (8, 9);

insert into weapons_available (weapon_id, warrior_id)
values (9, 7);

insert into weapons_available (weapon_id, warrior_id)
values (9, 8);

insert into weapons_available (weapon_id, warrior_id)
values (9, 9);