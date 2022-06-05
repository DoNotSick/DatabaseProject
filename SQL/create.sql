create database DB2022Team04;
USE DB2022Team04;

# 테이블 생성
# 전염병- 김정원 작성
CREATE TABLE DB2022_Epidemic(
	ID VARCHAR(20),
	R0 FLOAT,
	fatality_rate FLOAT,
	quarantine_period INT,
	PRIMARY KEY(ID)
);
DESCRIBE DB2022_Epidemic;

# 지역- 김서현 작성
CREATE TABLE DB2022_Area(
	area VARCHAR(30),
             medical_center_count INT not null,
      	patient_Ebola INT,
	patient_Corona INT,
	patient_Mers INT,
	patient_SARS INT,
	PRIMARY KEY(area)
);
DESCRIBE DB2022_Area;

# 의료소 - 이승연 작성
CREATE TABLE DB2022_MedicalCenter(
	ID VARCHAR(70),
	kind VARCHAR(30),
	location VARCHAR(30),
	tel VARCHAR(20),
	open TIME, 
	close TIME,
	wait INT,
	PRIMARY KEY (ID),
	FOREIGN KEY (location) REFERENCES DB2022_Area(area)
);
DESCRIBE DB2022_MedicalCenter;

# 지역별 검사소 정보 - 서동은 작성
CREATE TABLE DB2022_RegionalCenter
(
	ID INT AUTO_INCREMENT,
	name VARCHAR (30),
	area VARCHAR(30),
	contact VARCHAR(20),
	open TIME,
	close TIME,
	PRIMARY KEY (ID),
	FOREIGN KEY (area) REFERENCES DB2022_Area(area)
);
DESCRIBE DB2022_RegionalCenter;

# 확진자 - 양한나, 주민영 작성
CREATE TABLE DB2022_InfectedPerson( 
	ID INT AUTO_INCREMENT,
	name VARCHAR(20),
	disease VARCHAR(20),
	age INT,
	underlying_disease CHAR(1),
	Infected DATE,
	residential_area VARCHAR(30),
	PRIMARY KEY (ID),
	FOREIGN KEY (disease) REFERENCES DB2022_Epidemic(ID),
	FOREIGN KEY (residential_area) REFERENCES DB2022_Area(area)
);
DESCRIBE DB2022_InfectedPerson;

# 데이터 입력
# 지역 - 김서현 작성
INSERT INTO DB2022_Area (area, medical_center_count, patient_Ebola, patient_Corona, patient_Mers, patient_SARS) VALUES
("Seodaemun-gu", 2, 1, 0, 1, 1),
("Gwanak-gu", 2, 0, 0, 0, 0),
("Eunpyeong-gu", 1, 0, 1, 0, 0),
("Mapo-gu", 1, 0, 2, 0, 0),
("Nowon-gu", 1, 0, 0, 0, 1),
("Jungnang-gu", 1, 0, 1, 0, 0),
("Dongdaemun-gu", 1, 1, 0, 1, 0),
("Gangseo-gu", 1, 0, 0, 0, 0),
("Gangbuk-gu", 0, 0, 0, 0, 0),
("Jung-gu", 0, 0, 0, 0, 0);
SELECT * FROM DB2022_Area;


# 전염병 - 김정원 작성
INSERT INTO DB2022_Epidemic 
VALUES   ('Ebola', 0.00032, 0.53, 21),
	('Corona', 0.000589, 0.034, 14),
	('Mers', 0.000225, 0.205, 14),
	('SARS', 0.000167, 0.1, 10);
SELECT * FROM DB2022_Epidemic;


# 의료소 - 이승연 작성
INSERT INTO DB2022_MedicalCenter (ID, kind, location, tel, open, close, wait)
VALUES
("Sinchon Severance Hospital", "hospital", "Seodaemun-gu", "02-1599-1004", "09:00:00", "16:00:00", 128),
("Jang Jin Ho Clinic", "clinic", "Seodaemun-gu", "02-391-6336", "09:20:00", "18:35:00", 4),
("CAU Hospital", "hospital", "Gwanak-gu", "02-1800-1114", "09:00:00", "17:00:00", 56),
("Gwanak Su Clinic", "clinic", "Gwanak-gu", "02-1800-1114", "10:30:00", "19:20:00", 5),
("The Catholic University of Korea Eunpyeong St. Mary's Hospital", "hospital", "Eunpyeong-gu", "02-1811-7755", "09:00:00", "17:00:00", 312),
("Namsan Clinic", "clinic", "Mapo-gu", "02-715-6951", "08:20:00", "18:50:00", 12),
("Nowon Woori Clinic", "clinic", "Nowon-gu", "070-4288-0771", "09:10:00", "19:30:00", 6),
("Jungnang Jeil Clinic", "clinic", "Jungnang-gu", "02-437-7587", "09:20:00", "17:00:00", 27),
("Mirae Clinic", "clinic", "Dongdaemun-gu", "02-929-3200", "08:30:00", "17:20:00", 19),
("Ewha Womans University Seoul Hospital", "hospital", "Gangseo-gu", "02-1522-7000", "09:00:00", "18:00:00", 253);
SELECT * FROM DB2022_MedicalCenter;


# 지역별 검사소 정보 - 서동은 작성
ALTER TABLE DB2022_RegionalCenter AUTO_INCREMENT = 1;
INSERT INTO DB2022_RegionalCenter (name, area, contact, open, close) VALUES
("Sinchon Train Station", "Seodaemun-gu", "02-330-1806", "10:00:00", "17:00:00"),
("Seoul Station Plaza","Jung-gu","02-3396-5181","9:00:00","13:00:00"),
("Nakseong Grand Park","Gwanak-gu","02-879-7054","10:00:00","18:00:00"),
("Gupabal Station","Eunpyeong-gu","02-351-8640","09:00:00","14:00:00"),
("Cheongnyangni Station","Dongdaemun-gu","02-2127-4283","09:00:00","18:00:00"),
("Hongik Culture Plaza","Mapo-gu","02-3153-8656","09:30:00","17:00:00"),
("Nowon-gu People Hall","Nowon-gu","02-2116-3000","09:00:00","17:00:00"),
("Myeonmok Station Square","Jungnang-gu","02-2094-0800","09:00:00","18:00:00"),
("Jung-gog Health Office","Gwanak-gu","02-450-7090","09:00:00","18:00:00"),
("Sogang Uni. Station","Mapo-gu","02-3153-8656","09:30:00","17:00:00");
SELECT * FROM DB2022_RegionalCenter;


# 확진자 - 양한나, 주민영 작성
ALTER TABLE DB2022_InfectedPerson AUTO_INCREMENT = 1;
INSERT INTO DB2022_InfectedPerson (name, disease, age, underlying_disease, Infected, residential_area)
VALUES ("Hannah Yang", "Mers", 25, "O", "2022-04-25", "Seodaemun-gu"),
	("Yuna Jo", "Ebola", 28, "X", "2022-04-28", "Seodaemun-gu"),
	("Myeonghun Jeong", "SARS", 21, "X", "2022-05-01", "Seodaemun-gu"),
	("Namjun Baek", "Corona", 36, "X", "2022-05-08", "Eunpyeong-gu"),
	("Hyeonseo Ko", "Corona", 23, "O", "2022-05-05", "Mapo-gu"),
	("Heedo Na", "Corona", 18, "O", "2022-04-24", "Mapo-gu"),
	("Lee Jin Baek", "SARS", 22, "X", "2022-05-05", "Nowon-gu"),
	("Urim Ko", "Corona", 60, "O", "2022-04-30", "Jungnang-gu"),
	("Seungwan Ji", "Mers", 45, "X", "2022-05-08", "Dongdaemun-gu"),
	("Jiung Moon", "Ebola", 33, "O", "2022-04-29", "Dongdaemun-gu");
SELECT * FROM DB2022_InfectedPerson;



#############################################################################

# 뷰 생성 - 양한나, 김정원 작성

CREATE VIEW DB2022_AreaRank AS
SELECT residential_area, COUNT(residential_area) AS total_patient
FROM DB2022_InfectedPerson
GROUP BY residential_area
ORDER BY total_patient DESC;

SELECT * FROM DB2022_AreaRank;


CREATE VIEW DB2022_EpidemicRank AS
SELECT DISTINCT area, patient_Ebola AS Ebola, patient_Corona AS Corona, patient_Mers AS Mers, patient_Sars AS Sars, total_patient
FROM DB2022_Area NATURAL JOIN DB2022_AreaRank
WHERE area = residential_area
ORDER BY total_patient DESC;

SELECT * FROM DB2022_EpidemicRank;


#############################################################################

# 인덱스 생성 - 양한나 작성

CREATE INDEX AreaIdx On DB2022_Area (area);
CREATE INDEX WaitIdx On DB2022_MedicalCenter (wait);
CREATE INDEX EpidemicIdx On DB2022_Epidemic (ID);
CREATE INDEX IDIdx On DB2022_InfectedPerson (name);

##############################################################################

# Describe

DESCRIBE DB2022_Epidemic;
DESCRIBE DB2022_Area;
DESCRIBE DB2022_MedicalCenter;
DESCRIBE DB2022_RegionalCenter;
DESCRIBE DB2022_InfectedPerson;



