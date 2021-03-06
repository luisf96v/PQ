-- ----------------------------------------------------------------
-- *  PRQ PROYECT 
-- *   Made by: Luis Fernando Vasquez Quiros 
-- *      - Github: luisf96v
-- *      - Email  : luis96v@gmail.com 
-- ----------------------------------------------------------------
 
DROP SCHEMA IF EXISTS PRQ;
CREATE SCHEMA IF NOT EXISTS PRQ DEFAULT CHARACTER SET UTF8 ;
USE PRQ;

-- USERS
CREATE TABLE IF NOT EXISTS PRQ . USR (
  USR	VARCHAR(20) NOT NULL,
  PASS	VARCHAR(45) NOT NULL,
  PRM 	INT NOT NULL,
  PROF	VARCHAR(45) NULL,
  PRIMARY KEY (USR)
) ENGINE = InnoDB;


-- KEY WORD
CREATE TABLE IF NOT EXISTS PRQ . KEY_WORD (
  ID 	INT NOT NULL AUTO_INCREMENT,
  KEYW 	VARCHAR(25) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE = InnoDB;


-- KEY VALUES
CREATE TABLE IF NOT EXISTS PRQ . KEY_VALUE (
  ID 		INT NOT NULL AUTO_INCREMENT,
  DESCR 	VARCHAR(45) NOT NULL,
  KEY_ID 	INT NOT NULL,
  PRIMARY KEY (ID, KEY_ID),
  CONSTRAINT KEYID FOREIGN KEY (KEY_ID) REFERENCES KEY_WORD (ID)
) ENGINE = InnoDB;

-- ----------------------------------------------------------------
-- PROCEDURES
-- ----------------------------------------------------------------

DELIMITER $$
USE PRQ $$
CREATE PROCEDURE PRQ . FIND_USER (
	IN XUSR	VARCHAR(20),
    IN XPAS	VARCHAR(20)
) BEGIN
	SELECT PROF FROM USR WHERE USR = LOWER(XUSR) AND PASS = XPAS LIMIT 1;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
CREATE PROCEDURE PRQ . NEW_USER (
	IN XUSR	VARCHAR(20),
	IN XPAS	VARCHAR(45),
	IN XPRO	VARCHAR(45),
    IN XPRM INT
)
BEGIN
	INSERT INTO PRQ . USR VALUES (XUSR, XPAS, XPRM, XPRO);
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
CREATE PROCEDURE PRQ . FIND_KEYVALUES (
	IN XKEYW VARCHAR(25)
)
BEGIN
	SELECT * FROM KEY_VALUE WHERE KEY_ID = (SELECT ID FROM KEY_WORD WHERE KEYW = XKEYW);
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
CREATE PROCEDURE PRQ . UPDATE_KEY (
	IN XKEYW VARCHAR(25),
    IN XDES VARCHAR(45)
)
BEGIN
	UPDATE KEY_VALUE 
    SET KEY_VALUE.DESCR =  XDES
	WHERE KEY_ID = (SELECT ID FROM KEY_WORD WHERE KEYW = XKEYW);
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
CREATE PROCEDURE PRQ . UPDATE_KEY_ID (
	IN KID INT,
    IN XDES VARCHAR(45)
)
BEGIN
	UPDATE KEY_VALUE 
    SET KEY_VALUE.DESCR =  XDES
	WHERE ID = KID;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
CREATE PROCEDURE PRQ . GET_BILL ()
BEGIN
	SELECT KEY_VALUE.DESCR FROM KEY_VALUE WHERE KEY_ID = 1;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
CREATE PROCEDURE PRQ . UPDATE_BILL (
	IN XDES VARCHAR(10)
)
BEGIN
	UPDATE KEY_VALUE 
    SET KEY_VALUE.DESCR =  XDES
	WHERE KEY_VALUE.ID = 1;
END$$
DELIMITER ;

-- ----------------------------------------------------------------
-- TRIGGERS
-- ----------------------------------------------------------------

DELIMITER $$
USE PRQ $$
CREATE DEFINER = CURRENT_USER TRIGGER PRQ . USR_SET 
BEFORE INSERT ON USR FOR EACH ROW
BEGIN
	SET NEW.USR = LOWER(NEW.USR);
END$$
DELIMITER ;

-- -----------------------------------------------------
-- SCHEMA PRQ
-- -----------------------------------------------------

GRANT USAGE ON *.* TO admin;
DROP USER admin;
CREATE USER 'admin' IDENTIFIED BY 'Wireless.VQLF12';
GRANT ALL ON PRQ.* TO 'admin';

GRANT USAGE ON *.* TO emp;
DROP USER emp;
CREATE USER 'emp' IDENTIFIED BY 'emp2017';
GRANT EXECUTE ON PRQ.* TO 'emp';

-- -----------------------------------------------------
-- SCHEMA PRQ
-- -----------------------------------------------------
INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (1, 'BILL');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (1, 'A - 001', 1);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (5, 'TEL');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (5, '8395-0739', 5);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (6, 'NAME');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (6, 'Parqueo Clinica de San Pablo', 6);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (7, 'CED');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (7, '11645-0845', 7);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (8, 'DAYS');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (8, 'Lunes - Viernes', 8);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (9, 'HHR');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (9, '6:30 a.m. a 4:15 p.m.', 9);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (10, 'ONSPC');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (10, 'false', 10);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (11, 'DAYSS');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (11, 'Domingo', 11);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (12, 'HHRS');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (12, '1:00 p.m. a 5:00 p.m.', 12);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (13, 'CAMPOS');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (13, '10', 13);
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (14, '12', 13);
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (15, '5', 13);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (14, 'VALOR');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (16, '150', 14);
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (17, '300', 14);
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (18, '350', 14);
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (19, '700', 14);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (15, 'PRINTER');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (20, 'POS-80C', 15);

INSERT INTO PRQ.KEY_WORD (ID, KEYW) VALUES (16, 'CASH');
INSERT INTO PRQ.KEY_VALUE(ID, DESCR, KEY_ID) VALUES (21, '300000', 16);




INSERT INTO PRQ . USR VALUES ("Admin", "admin", 1, "Administrador");