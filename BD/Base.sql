-- ----------------------------------------------------------------
-- *  PRQ PROYECT 
-- *   Made by: Luis Fernando Vasquez Quiros 
-- *      - Github: luisf96v
-- *      - Email  : luis96v@gmail.com 
-- ----------------------------------------------------------------
 
DROP SCHEMA IF EXISTS PRQ;
CREATE SCHEMA IF NOT EXISTS PRQ DEFAULT CHARACTER SET UTF8 ;
USE PRQ;

-- ----------------------------------------------------------------
-- TABLAS
-- ----------------------------------------------------------------

-- REGISTERS
CREATE TABLE IF NOT EXISTS PRQ . RGS (
  ID	INT NOT NULL AUTO_INCREMENT,
  MAT	VARCHAR(10) NOT NULL,
  TP	INT NOT NULL,
  IH	DATETIME DEFAULT CURRENT_TIMESTAMP,
  OH 	DATETIME,
  TTL	DOUBLE,
  PRIMARY KEY (ID)
) ENGINE = InnoDB;

-- USERS
CREATE TABLE IF NOT EXISTS PRQ . USR (
  USR	VARCHAR(20) NOT NULL,
  PASS	VARCHAR(45) NOT NULL,
  PROF	VARCHAR(45) NULL,
  PRIMARY KEY (USR)
) ENGINE = InnoDB;

-- ----------------------------------------------------------------
-- PROCEDURES
-- ----------------------------------------------------------------

DELIMITER $$
USE PRQ $$ 
-- NEW REGISTER
CREATE PROCEDURE PRQ . IN_RGS (
	IN XMAT VARCHAR(10),
	IN XTP	INT 
) BEGIN
	IF EXISTS(SELECT MAT FROM RGS WHERE RGS.MAT = XMAT AND DATE(RGS.IH) = CURDATE() LIMIT 1)
    THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Ya existe esa matricula en los registros.';
    ELSE
		INSERT INTO PRQ . RGS (MAT, TP)  VALUES (XMAT, XTP);
		SELECT IH FROM RGS WHERE ID = LAST_INSERT_ID() LIMIT 1;
	END IF;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
-- SET REGISTER
CREATE PROCEDURE PRQ . OUT_RGS (
	IN XMAT	VARCHAR(10),
    IN XTTL DOUBLE 
) BEGIN	
	DECLARE XOH DATETIME DEFAULT NOW();
            
	IF EXISTS (SELECT ID FROM RGS WHERE RGS.MAT = XMAT AND DATE(RGS.IH) = CURDATE() LIMIT 1)
		THEN
			UPDATE RGS SET 
				OH = XOH,
                TTL = XTTL
                WHERE RGS.MAT = XMAT AND DATE(RGS.IH) = CURDATE() LIMIT 1;
			SELECT XOH AS 'OUT DATETIME';
		ELSE
        	SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'No hay registro de dicha matricula.';
	END IF;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
-- REGISTERS BETWEEN DATES
CREATE PROCEDURE PRQ . RGS_BTW_DATES (
	IN XSTART DATE,
	IN XEND	  DATE
) BEGIN
	SELECT 	RGS.TP, RGS.TTL
    FROM 	PQR.RGS
    WHERE 	RGS.IH BETWEEN XSTART AND XEND; 
END$$
DELIMITER ;

-- -----------------------------------------------------------------------------
-- USER PROCEDURES

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
	IN XPRO	VARCHAR(45)
)
BEGIN
	INSERT INTO PRQ . USR VALUES (XUSR, XPAS, XPRO);
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
GRANT SELECT ON PRQ.* TO 'emp';