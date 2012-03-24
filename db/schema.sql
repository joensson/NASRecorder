DROP DATABASE IF EXISTS nas_recorder;

CREATE DATABASE IF NOT EXISTS nas_recorder;

USE nas_recorder;


CREATE TABLE IF NOT EXISTS hdhr_channel_map (
  id INT NOT NULL AUTO_INCREMENT,
  channel_map VARCHAR(20) NOT NULL,
  description VARCHAR(250),
  PRIMARY KEY (id)
) ENGINE=InnoDB COLLATE=utf8_bin;

/* Channel maps supported by HDHR-EU hardware ---- ( hdhomerun_config FFFFFFFF get /sys/features | grep channelmap )  */ 
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('au-bcast', 'Digital Antenna (Australia)');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('au-cable', 'Digital Cable (Australia)');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('eu-bcast', 'Digital Antenna (Europe)');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('eu-cable', 'Digital Cable (Europe)');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('tw-bcast', 'Digital Antenna (Taiwan)');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('tw-cable', 'Digital Cable (Taiwan)');

/* Channel maps supported by HDHR-US hardware */
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('us-bcast', 'Digital Antenna (ATSC)');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('us-cable', 'Digital Cable - Normal frequency layout');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('us-hrc', 'Digital Cable - HRC frequency layout');
INSERT INTO hdhr_channel_map (channel_map, description) VALUES ('us-irc', 'Digital Cable - IRC frequency layout');


/* ( hdhomerun_config FFFFFFFF get /sys/features | grep modulation ) */
CREATE TABLE IF NOT EXISTS hdhr_modulation (
  id INT NOT NULL AUTO_INCREMENT,
  channel_map_id INT,
  modulation VARCHAR(10) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (channel_map_id) REFERENCES hdhr_channel_map(id) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB COLLATE=utf8_bin;

INSERT INTO hdhr_modulation (modulation) VALUES ('t8qam64');
INSERT INTO hdhr_modulation (modulation) VALUES ('t8qam16');
INSERT INTO hdhr_modulation (modulation) VALUES ('t8qpsk');
INSERT INTO hdhr_modulation (modulation) VALUES ('t7qam64');
INSERT INTO hdhr_modulation (modulation) VALUES ('t7qam16');
INSERT INTO hdhr_modulation (modulation) VALUES ('t7qpsk');
INSERT INTO hdhr_modulation (modulation) VALUES ('t6qam64');
INSERT INTO hdhr_modulation (modulation) VALUES ('t6qam16');
INSERT INTO hdhr_modulation (modulation) VALUES ('t6qpsk');
INSERT INTO hdhr_modulation (modulation) VALUES ('a8qam256');
INSERT INTO hdhr_modulation (modulation) VALUES ('a8qam128');
INSERT INTO hdhr_modulation (modulation) VALUES ('a8qam64');
INSERT INTO hdhr_modulation (modulation) VALUES ('a7qam256');
INSERT INTO hdhr_modulation (modulation) VALUES ('a7qam128');
INSERT INTO hdhr_modulation (modulation) VALUES ('a7qam64');
INSERT INTO hdhr_modulation (modulation) VALUES ('a6qam256');
INSERT INTO hdhr_modulation (modulation) VALUES ('a6qam128');
INSERT INTO hdhr_modulation (modulation) VALUES ('a6qam64');
INSERT INTO hdhr_modulation (modulation) VALUES ('auto');
INSERT INTO hdhr_modulation (modulation) VALUES ('auto8t');
INSERT INTO hdhr_modulation (modulation) VALUES ('auto7t');
INSERT INTO hdhr_modulation (modulation) VALUES ('auto6t');
INSERT INTO hdhr_modulation (modulation) VALUES ('auto8c');
INSERT INTO hdhr_modulation (modulation) VALUES ('auto7c');
INSERT INTO hdhr_modulation (modulation) VALUES ('auto6c');



CREATE TABLE IF NOT EXISTS hdhr_channel_frequency (
  id INT NOT NULL AUTO_INCREMENT,
  channel_map_id INT, 
  modulation_id INT NOT NULL,
  freq INT NOT NULL,
  symbol_rate INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (channel_map_id) REFERENCES hdhr_channel_map(id) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (modulation_id) REFERENCES hdhr_modulation(id) ON DELETE CASCADE ON UPDATE CASCADE  
) ENGINE=InnoDB COLLATE=utf8_bin;



CREATE TABLE IF NOT EXISTS hdhr_program (
  id INT NOT NULL AUTO_INCREMENT,
  frequency_id INT,
  program INT NOT NULL,
  program_name VARCHAR(30),
  PRIMARY KEY (id),
  FOREIGN KEY (frequency_id) REFERENCES hdhr_channel_frequency(id) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB COLLATE=utf8_bin;



/* TV Guide related tables */

CREATE TABLE IF NOT EXISTS channel (
  id INT NOT NULL AUTO_INCREMENT,
  channel_id varchar(100),
  display_name VARCHAR(50),
  hdhr_program_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (hdhr_program_id) REFERENCES hdhr_program(id) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB COLLATE=utf8_bin;


CREATE TABLE IF NOT EXISTS category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(40),
  PRIMARY KEY (id)
) ENGINE=InnoDB COLLATE=utf8_bin;


CREATE TABLE IF NOT EXISTS programme (
  id INT NOT NULL AUTO_INCREMENT,
  channel_id INT NOT NULL,
  start_time DATETIME NOT NULL,
  end_time DATETIME NOT NULL,
  title VARCHAR(250) NOT NULL,
  sub_title VARCHAR(250) DEFAULT NULL,
  description TEXT,
  category_id INT,
  episode_num VARCHAR(10) DEFAULT NULL,
  icon VARCHAR(200),
  PRIMARY KEY (id),
  FOREIGN KEY (channel_id) REFERENCES channel(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB COLLATE=utf8_bin;


CREATE TABLE IF NOT EXISTS actor (
  id INT NOT NULL AUTO_INCREMENT,
  actor_name VARCHAR(100),
  character_name VARCHAR(100),
  PRIMARY KEY (id)
) ENGINE=InnoDB COLLATE=utf8_bin;


CREATE TABLE IF NOT EXISTS programme_credits (
  id INT NOT NULL AUTO_INCREMENT,
  programme_id INT,
  actor_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (programme_id) REFERENCES programme(id) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (actor_id) REFERENCES actor(id) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB COLLATE=utf8_bin;

