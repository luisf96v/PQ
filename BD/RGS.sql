-- ----------------------------------------------------------------
-- *  PRQ PROYECT 
-- *   Made by: Luis Fernando Vasquez Quiros 
-- *      - Github: luisf96v
-- *      - Email  : luis96v@gmail.com 
-- ----------------------------------------------------------------

-- TABLE

CREATE TABLE IF NOT EXISTS PRQ . RGS (
  ID	INT NOT NULL AUTO_INCREMENT,
  MAT	VARCHAR(10) NOT NULL,
  TP	INT NOT NULL,
  IH	DATETIME DEFAULT CURRENT_TIMESTAMP,
  OH 	DATETIME,
  TTL	INT,
  FAC   VARCHAR(4),
  PRIMARY KEY (ID)
) ENGINE = InnoDB;


-- ----------------------------------------------------------------

-- PROCEDURES INSERTS

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
        SELECT RGS.IH FROM RGS WHERE ID = LAST_INSERT_ID();
	END IF;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
-- SET REGISTER
CREATE PROCEDURE PRQ . OUT_RGS (
	IN XMAT	VARCHAR(10),
    IN XOH 	DATETIME,
    IN XTTL INT,
    IN XFAC VARCHAR(4)
) BEGIN	
	IF EXISTS (SELECT ID FROM RGS WHERE RGS.MAT = XMAT AND DATE(RGS.IH) = CURDATE() LIMIT 1)
		THEN
			UPDATE RGS SET 
				OH = XOH,
                TTL = XTTL,
                FAC = XFAC
                WHERE RGS.MAT = XMAT AND DATE(RGS.IH) = CURDATE() LIMIT 1;
		ELSE
        	SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'No hay registro de dicha matricula.';
	END IF;
END$$
DELIMITER ;

-- ----------------------------------------------------------------

-- PROCEDURES SELECT

DELIMITER $$
USE PRQ $$
-- SELECT RGS WHERE OH ARE NULL 
CREATE PROCEDURE PRQ . RGS_OH_NULL () 
BEGIN
	SELECT 	RGS.MAT, RGS.FAC, RGS.TP, RGS.IH, RGS.ID
    FROM 	PRQ.RGS
    WHERE 	DATE(RGS.IH) = CURDATE()
    AND 	RGS.OH IS NULL;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
-- SELECT RGS WHERE MAT = XMT && OH ARE NULL 
CREATE PROCEDURE PRQ . FIND_RGS (
	IN XMAT VARCHAR(10)
) 
BEGIN
	SELECT 	RGS.MAT, RGS.FAC, RGS.TP, RGS.IH, RGS.ID
    FROM 	PRQ.RGS
    WHERE 	RGS.MAT = XMAT
    AND 	RGS.OH IS NULL;
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

DELIMITER $$
USE PRQ $$
-- REGISTERS BETWEEN DATES
CREATE PROCEDURE PRQ . UPDATE_RGS (
	IN AID 	INT,
	IN XNEW	VARCHAR(10)
) BEGIN
	UPDATE 	RGS
    SET MAT = XNEW
    WHERE RGS.ID = AID;
END$$
DELIMITER ;

DELIMITER $$
USE PRQ $$
-- REGISTERS BETWEEN DATES
CREATE PROCEDURE PRQ . DELETE_RGS (
	IN AID 	INT
) BEGIN
	DELETE FROM	RGS
    WHERE RGS.ID = AID;
END$$
DELIMITER ;
-- ----------------------------------------------------------------