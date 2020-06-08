CREATE TABLE USER_ACCOUNT 
(
"USERACCOUNTID" INT NOT NULL PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
USERNAME VARCHAR(100), 
PASSWORD VARCHAR(120), 
DATEOFBIRTH VARCHAR(10), 
GENDER VARCHAR(20), 
PROMOTIONALNEWSLETTER BOOLEAN, 
REWARDPOINTS INTEGER
);

INSERT INTO USER_ACCOUNT (USERNAME, PASSWORD, DATEOFBIRTH, GENDER)
VALUES
('123@gmail.com', '12345678', '07/07/1996', 'Male'),
('abc@gmail.com', '12345678', '07/07/1996', 'Male');