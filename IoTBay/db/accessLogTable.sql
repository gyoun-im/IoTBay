CREATE TABLE ACCESS_LOG 
(
ACCESSLOGID INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1  
NOT NULL GENERATED ALWAYS AS IDENTITY, 
USERACCOUNTID INTEGER, 
"DATE" VARCHAR(20), 
"TIME" VARCHAR(20), 
PRIMARY KEY (ACCESSLOGID)
);