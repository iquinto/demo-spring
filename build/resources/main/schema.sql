DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA public;

SET TRANSACTION READ WRITE;

SET datestyle = DMY;


CREATE TABLE MUSICIAN (
	id_musician SMALLINT,
	name VARCHAR(255) NOT NULL,
	birth DATE NOT NULL,
	year_death DATE,
	gender VARCHAR(255) NOT NULL,
	nationality VARCHAR(255) NOT NULL,
CONSTRAINT PK_MUSICIAN PRIMARY KEY(id_musician),
CONSTRAINT DATE_VALID CHECK (year_death IS NULL OR birth < year_death),
CONSTRAINT GENDER CHECK (gender IN ('M','F')));

CREATE TABLE BAND (
	id_band SMALLINT,
	name VARCHAR(255) NOT NULL,
	year_formed SMALLINT NOT NULL,
	year_dissolution SMALLINT,
	style VARCHAR(255) NOT NULL,
	origin VARCHAR(255) NOT NULL,
    num_awards SMALLINT DEFAULT 0,
CONSTRAINT PK_BAND PRIMARY KEY(id_band),
CONSTRAINT CHECK_NUM_AWARDS CHECK (num_awards >= 0),
CONSTRAINT CHECK_DISSOLUTION CHECK (year_dissolution IS NULL OR year_dissolution > year_formed),
CONSTRAINT CHECK_STYLE CHECK (style IN ('Blues', 'Country', 'Heavy', 'Jazz', 'Pop', 'Punk', 'Reggae', 'Rock', 'Soul', 'Thrash', 'Techno')));


CREATE TABLE ALBUM (
	id_album SMALLINT,
	title VARCHAR(255) NOT NULL,
	year SMALLINT NOT NULL,
	id_band SMALLINT NOT NULL,
	num_long_songs INTEGER DEFAULT 0,
	CONSTRAINT PK_ALBUM PRIMARY KEY(id_album),
	CONSTRAINT FK_BAND FOREIGN KEY (id_band) REFERENCES BAND(id_band));

CREATE TABLE SONG(
	id_song SMALLINT,
	title VARCHAR(255) NOT NULL,
	duration TIME NOT NULL,
	id_album SMALLINT NOT NULL,
	CONSTRAINT PK_SONG PRIMARY KEY(id_song),
    CONSTRAINT CHECK_DURATION CHECK (duration > '0:00'),
    CONSTRAINT FK_ALBUM FOREIGN KEY (id_album) REFERENCES ALBUM(id_album));

CREATE TABLE COMPOSER(
	id_musician SMALLINT,
	id_song SMALLINT,
CONSTRAINT PK_COMPOSER PRIMARY KEY(id_musician, id_song),
CONSTRAINT FK_MUSICIAN FOREIGN KEY (id_musician) REFERENCES MUSICIAN(id_musician) ON DELETE CASCADE,
CONSTRAINT FK_SONG FOREIGN KEY (id_song) REFERENCES SONG(id_song) ON DELETE CASCADE
);

CREATE TABLE MEMBER (
	id_musician SMALLINT, 
	id_band SMALLINT, 
	instrument VARCHAR(255),
	CONSTRAINT PK_MEMBER PRIMARY KEY(id_musician, id_band, instrument),
	CONSTRAINT FK_MUSICIAN FOREIGN KEY (id_musician) REFERENCES MUSICIAN(id_musician),
	CONSTRAINT FK_BAND FOREIGN KEY (id_band) REFERENCES BAND(id_band),
	CONSTRAINT CHECK_INSTRUMENT CHECK (instrument IN ('Bass', 'Drums', 'Guitar', 'Keyboard', 'Vocals', 'Trumpet', 'Clarinet', 'Oboe', 'Flute')));


CREATE TABLE REPORT_BAND (
	id_band INTEGER PRIMARY KEY,
	num_albums INTEGER,
	num_songs INTEGER,
	num_members INTEGER,
	name_oldest_alive VARCHAR(255)
);

CREATE TYPE report_band_type AS (
	t_id_band INTEGER,
	t_num_albums INTEGER,
	t_num_songs INTEGER,
	t_num_members INTEGER,
	t_name_oldest_alive VARCHAR(255)
);

