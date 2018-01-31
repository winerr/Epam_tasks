DELIMITER //
CREATE TRIGGER BeforeInsertEmployee
BEFORE INSERT
  on employee for EACH ROW
  BEGIN
    IF NOT exists(SELECT * FROM post WHERE post = NEW.post)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'post not exist';
    END IF;

    IF NOT exists(SELECT * FROM pharmacy WHERE pharmacy.id = NEW.pharmacy_id) and NEW.pharmacy_id IS NOT NULL
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'pharmacy_id not exist';
    END IF;

    IF NEW.identity_number RLIKE '00$' THEN
      SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'identity can`t be like 00$';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateEmployee
BEFORE UPDATE
  on employee for EACH ROW
  BEGIN
    IF NOT exists(SELECT * FROM post WHERE post = NEW.post)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'post not exist';
    END IF;

    IF NOT exists(SELECT * FROM pharmacy WHERE pharmacy.id = NEW.pharmacy_id) and NEW.pharmacy_id IS NOT NULL
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'pharmacy_id not exist';
    END IF;

    IF NEW.identity_number RLIKE '00$' THEN
      SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'identity can`t be like 00$';
    END IF;
  END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER AfterDeletePost
  AFTER DELETE
  on post for EACH ROW
  BEGIN
    IF exists(SELECT * FROM employee WHERE employee.post = OLD.post)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this post';
    END IF;
  END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER AfterDeletePharmacy
  AFTER DELETE
  ON pharmacy FOR EACH ROW
  BEGIN
    UPDATE employee SET pharmacy_id = NULL WHERE pharmacy_id = OLD.id;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertMedicine
  BEFORE INSERT
  on medicine FOR EACH ROW
  BEGIN
    if NEW.ministry_code NOT RLIKE '[^mn][^mn]-[0-9][0-9][0-9]-[0-9][0-9]' THEN
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'wrong masc of minestry code';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateMedicine
  BEFORE UPDATE
  on medicine FOR EACH ROW
  BEGIN
    if NEW.ministry_code NOT RLIKE '[^mn][^mn]-[0-9][0-9][0-9]-[0-9][0-9]' THEN
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'wrong masc of minestry code';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertPharmacy
BEFORE INSERT
  on pharmacy for EACH ROW
  BEGIN
    IF NOT exists(SELECT * FROM street WHERE street.street = NEW.street)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'street not exist';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdatePharmacy
BEFORE UPDATE
  on pharmacy for EACH ROW
  BEGIN
    IF NOT exists(SELECT * FROM street WHERE street.street = NEW.street)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'street not exist';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER AfterDeleteStreet
  AFTER DELETE
  on street for EACH ROW
  BEGIN
    IF exists(SELECT * FROM street WHERE street = OLD.street)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertPharmacyMedicine
  BEFORE INSERT
  on pharmacy_medicine for EACH ROW
  BEGIN
    IF not exists(SELECT * FROM pharmacy WHERE id = NEW.pharmacy_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
    IF not exists(SELECT * FROM medicine WHERE id = NEW.medicine_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdatePharmacyMedicine
  BEFORE UPDATE
  on pharmacy_medicine for EACH ROW
  BEGIN
    IF not exists(SELECT * FROM pharmacy WHERE id = NEW.pharmacy_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
    IF not exists(SELECT * FROM medicine WHERE id = NEW.medicine_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
  END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER BeforeInsertMedicineZone
  BEFORE INSERT
  on medicine_zone for EACH ROW
  BEGIN
    IF not exists(SELECT * FROM zone WHERE id = NEW.zone_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
    IF not exists(SELECT * FROM medicine WHERE id = NEW.medicine_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
  END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateMedicineZone
  BEFORE UPDATE
  on medicine_zone for EACH ROW
  BEGIN
    IF not exists(SELECT * FROM zone WHERE id = NEW.zone_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
    IF not exists(SELECT * FROM medicine WHERE id = NEW.medicine_id)
      THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can`t delete this street';
    END IF;
  END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE insertInEmployer
  (
    in s VARCHAR(30),
    in n VARCHAR(30),
    in m VARCHAR(30),
    in i VARCHAR(10),
    in p VARCHAR(10),
    in e DECIMAL(10, 1),
    in b DATE,
    in po VARCHAR(15),
    in ph int(11)
  )
  BEGIN
    INSERT INTO employee (surname, name, midle_name, identity_number, passport, experience, birthday, post, pharmacy_id)
      VALUE (s, n, m, i, p, e, b, po, ph);
  END //
DELIMITER ;


DELIMITER //
CREATE FUNCTION min_expirience()
  RETURNS VARCHAR(10)
  BEGIN
    RETURN (SELECT min(experience) FROM employee);
  END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION pole(e_id int)
  RETURNS VARCHAR(30)
  BEGIN
    RETURN (SELECT concat(pharmacy.name, ' ', building_number) FROM pharmacy LEFT JOIN employee ON employee.pharmacy_id = pharmacy.id WHERE employee.id = e_id);
  END //
DELIMITER ;


select not exists(SELECT * FROM post WHERE post = 'not some post') ;

INSERT INTO employee
    VALUE (7, 'qqq', 'qqq', 'qqq', '1100', 'wwww', '4', '1999-01-01', 'some post', 1);

INSERT INTO post VALUE ('not some post');

DELETE FROM post WHERE post = 'not some post';

DELETE FROM pharmacy WHERE id = 1;


SELECT * FROM employee WHERE identity_number RLIKE '00$';

SELECT * FROM medicine WHERE ministry_code NOT RLIKE '[^mn][^mn]-[0-9][0-9][0-9]-[0-9][0-9]';

CALL insertInEmployer('qqq', 'qqq', 'qqq', '1103', 'wwww', '1', '1999-01-01', 'some post', 1);

SELECT min_expirience();

SELECT pole(1);


SELECT concat(pharmacy.name, ' ', building_number) FROM pharmacy LEFT JOIN employee ON employee.pharmacy_id = pharmacy.id WHERE employee.id = 1;