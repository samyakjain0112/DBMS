create database dbmscourse;
use dbmscourse;

-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('101', 'samyak', 'ROLE_CLIENT');
-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('3', 'seemajain', 'ROLE_CUSTOMER');
-- INSERT INTO `dbmscourse`.`Client` (`firstName`, `lastName`, `clientId`, `address`, `contact`, `loginId`) VALUES ('samyak', 'jain', '1', 'Shubh Labh Avenue', '9179144039', '101');
-- INSERT INTO `dbmscourse`.`Customer` (`name`, `customerId`, `contact`, `address`, `dob`, `loginId`) VALUES ('seema', '1', '9981562657', 'Indore', '2020-11-01', '3');
-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('102', 'Sapna', 'ROLE_STAFF');
-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('103', 'Komal', 'ROLE_STAFF');
-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('104', 'Ritu', 'ROLE_STAFF');
-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('105', 'Shalini', 'ROLE_STAFF');
-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('106', 'Riya', 'ROLE_STAFF');
-- INSERT INTO `dbmscourse`.`LoginAccount` (`loginId`, `password`, `role`) VALUES ('107', 'Anchal', 'ROLE_STAFF');
-- INSERT INTO `dbmscourse`.`StaffMember` (`name`, `staffId`, `salary`, `address`, `workingHours`, `contact`, `loginId`) VALUES ('Komal', '103', '3000', 'Mitra Bandhu Nagar', '10', '9876543215', '103');
-- INSERT INTO `dbmscourse`.`StaffMember` (`name`, `staffId`, `salary`, `address`, `workingHours`, `contact`, `loginId`) VALUES ('Shalini', '3', '5000', 'Kanadia Road', '10', '9876543217', '104');
-- INSERT INTO `dbmscourse`.`StaffMember` (`name`, `staffId`, `salary`, `address`, `workingHours`, `contact`, `loginId`) VALUES ('Ritu', '4', '3600', 'Mitra Bandhu Nagar', '10', '9876543218', '105');
-- INSERT INTO `dbmscourse`.`StaffMember` (`name`, `staffId`, `salary`, `address`, `workingHours`, `contact`, `loginId`) VALUES ('Riya', '5', '2500', 'Manavta Nagar', '10', '9876543219', '106');
-- INSERT INTO `dbmscourse`.`StaffMember` (`name`, `staffId`, `salary`, `address`, `workingHours`, `contact`, `loginId`) VALUES ('Anchal', '6', '4000', 'Kanadia Road', '10', '9876543212', '107');


-- UPDATE `dbmscourse`.`StaffMember` SET `staffId` = '1' WHERE (`staffId` = '102');
-- UPDATE `dbmscourse`.`StaffMember` SET `staffId` = '2' WHERE (`staffId` = '103');


-- INSERT INTO `dbmscourse`.`TreatmentAndFacilities` (`cost`, `timeRequired`, `name`, `treatmentId`, `staffId`) VALUES ('250', '1', 'Haircut', '1001', '1');
-- INSERT INTO `dbmscourse`.`TreatmentAndFacilities` (`cost`, `timeRequired`, `name`, `treatmentId`, `staffId`) VALUES ('650', '1', 'Facial', '1002', '2');
-- INSERT INTO `dbmscourse`.`TreatmentAndFacilities` (`cost`, `timeRequired`, `name`, `treatmentId`, `staffId`) VALUES ('450', '1', 'Spa', '1003', '3');
-- INSERT INTO `dbmscourse`.`TreatmentAndFacilities` (`cost`, `timeRequired`, `name`, `treatmentId`, `staffId`) VALUES ('200', '1', 'Waxing', '1004', '4');
-- INSERT INTO `dbmscourse`.`TreatmentAndFacilities` (`cost`, `timeRequired`, `name`, `treatmentId`, `staffId`) VALUES ('250', '1', 'Pedicure-Manicure', '1005', '5');
-- INSERT INTO `dbmscourse`.`TreatmentAndFacilities` (`cost`, `timeRequired`, `name`, `treatmentId`, `staffId`) VALUES ('20', '1', 'Eye-brows', '1006', '6');


select * from LoginAccount;
select * from Appointment;
select * from TreatmentAndFacilities;
select * from Customer;
-- select * from Client;
select * from StaffMember;
CREATE TABLE LoginAccount
(
  loginId INT NOT NULL,
  password VARCHAR(1000) NOT NULL,
  role VARCHAR(20) NOT NULL,
  PRIMARY KEY (loginId)
);

CREATE TABLE Distributer
(
  distributerId INT NOT NULL auto_increment,
  name VARCHAR(20) NOT NULL,
  contact CHAR(10) NOT NULL,
  PRIMARY KEY (distributerId)
);

CREATE TABLE Client
(
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  clientId INT NOT NULL auto_increment,
  address VARCHAR(20) NOT NULL,
  contact CHAR(10) NOT NULL,
  loginId INT NOT NULL,
  PRIMARY KEY (clientId),
  FOREIGN KEY (loginId) REFERENCES LoginAccount(loginId)
);

CREATE TABLE Customer
(
  name VARCHAR(20) NOT NULL,
  customerId INT NOT NULL auto_increment,
  contact CHAR(10) NOT NULL,
  address VARCHAR(20) NOT NULL,
  dob VARCHAR(20) NOT NULL,
  loginId INT NOT NULL,
  PRIMARY KEY (customerId),
  FOREIGN KEY (loginId) REFERENCES LoginAccount(loginId)
);

CREATE TABLE StaffMember
(
  name VARCHAR(20) NOT NULL,
  staffId INT NOT NULL auto_increment,
  salary INT NOT NULL,
  address VARCHAR(20) NOT NULL,
  workingHours INT NOT NULL,
  contact CHAR(10) NOT NULL,
  loginId INT NOT NULL,
  PRIMARY KEY (staffId),
  FOREIGN KEY (loginId) REFERENCES LoginAccount(loginId)
);

CREATE TABLE Product
(
  productId INT NOT NULL,
  mrp INT NOT NULL,
  discount INT NOT NULL,
  expiryDate DATE NOT NULL,
  companyName VARCHAR(20) NOT NULL,
  clientId INT NOT NULL,
  distributerId INT NOT NULL,
  customerId INT NOT NULL,
  PRIMARY KEY (productId),
  FOREIGN KEY (clientId) REFERENCES Client(clientId),
  FOREIGN KEY (distributerId) REFERENCES Distributer(distributerId),
  FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);

CREATE TABLE TreatmentAndFacilities
(
  cost INT NOT NULL,
  timeRequired INT NOT NULL,
  name VARCHAR(20)NOT NULL,
  treatmentId INT NOT NULL,
  staffId INT NOT NULL,
  PRIMARY KEY (treatmentId),
  FOREIGN KEY (staffId) REFERENCES StaffMember(staffId)
);

CREATE TABLE Appointment
(
  time INT NOT NULL,
  appointmentId INT NOT NULL auto_increment,
  customerId INT NOT NULL,
  clientId INT NOT NULL,
  treatmentId INT NOT NULL,
  PRIMARY KEY (appointmentId),
  FOREIGN KEY (customerId) REFERENCES Customer(customerId),
  FOREIGN KEY (clientId) REFERENCES Client(clientId),
  FOREIGN KEY (treatmentId) REFERENCES TreatmentAndFacilities(treatmentId)
);

CREATE TABLE Feedback
(
  feedbackId INT NOT NULL auto_increment,
  feedback VARCHAR(100) NOT NULL,
  customerId INT NOT NULL,
  PRIMARY KEY (feedbackId),
  FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);

CREATE TABLE Payment
(
  transactionId INT NOT NULL,
  amount INT NOT NULL,
  productId INT NOT NULL,
  loginId INT NOT NULL,
  clientId INT NOT NULL,
  PRIMARY KEY (transactionId),
  FOREIGN KEY (productId) REFERENCES Product(productId),
  FOREIGN KEY (loginId) REFERENCES LoginAccount(loginId),
  FOREIGN KEY (clientId) REFERENCES Client(clientId)
);
-- drop database dbmscourse;