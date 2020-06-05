/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Simon
 * Created: 2020年6月4日
 */
DROP TABLE "ORDER";
CREATE TABLE "ORDER"
(    
   "ID" INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),   
   "TOTAL" DOUBLE,     
   "DATE" TIMESTAMP,
   "STATUS" VARCHAR(50),
   "USERID" VARCHAR(50),
   "DEVICEID" INTEGER,
    "QUANTITY" INTEGER
);

INSERT INTO "ORDER" ("TOTAL", "DATE", "STATUS", "USERID", "DEVICEID", "QUANTITY") 
VALUES(1499.0, TIMESTAMP('2020-02-01 21:03:20'), 'Unpaid', '1', 1, 1), (599.0, TIMESTAMP('2020-02-10 10:09:20'), 'Finished', '1', 2, 2);