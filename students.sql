-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.0.37-community-nt - MySQL Community Edition (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table sms.students: ~9 rows (approximately)
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`id`, `first_name`, `last_name`, `sex`, `dob`, `gpa`, `email`, `phone_number`) VALUES
	('SP/R/2304', 'Muhammad S', 'Ali', 'male', '1985-01-15', 3.48, 'ms.ali@fud.edu.ng', '08025368224'),
	('FCP/CCS/19/1025', 'Ibrahim Bala', 'Supo', 'male', '2000-05-21', 3.58, 'sufo@fud.edu.ng', '08025312512'),
	('SP/R/1003', 'Fatima', 'Mansur', 'female', '1989-10-11', 4.51, 'ftmansur@gmail.com', '08036254112'),
	('FCP/CSC/18/0023', 'Ibrahim', 'Muhammad', 'male', '1999-03-19', 4.98, 'getme@gmailc.com', '08145869852'),
	('FCP/CSC/18/1002', 'Sumayya', 'Idris', 'female', '2001-02-06', 4.21, 'summy@yahoo.com', '08025635421'),
	('FCP/CCS/19/1032', 'Zainab', 'Muhammad', 'female', '2015-06-10', 4.99, 'zain@hotmail.co.uk', '07037510021'),
	('SP/R/2314', 'Fadila', 'Sulaiman', 'female', '1985-11-15', 2.75, 'fadils@fud.edu.ng', '07035421546'),
	('SP/R/1234', 'Hassan', 'Garba', 'male', '1981-09-11', 4.23, NULL, '08035263540'),
	('SP/R/1012', 'Radiya', 'Ahmad', 'female', '1996-11-12', 3.56, 'radiyahky@gmail.com', '07069362541');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
