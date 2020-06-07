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
   "DATE" TIMESTAMP default CURRENT_TIMESTAMP,
   "STATUS" VARCHAR(50),
   "USERID" VARCHAR(50),
   "DEVICEID" INTEGER,
   "QUANTITY" INTEGER,
   "NOTES" VARCHAR(500)
);

INSERT INTO "ORDER" ("TOTAL", "DATE", "STATUS", "USERID", "DEVICEID", "QUANTITY", "NOTES") 
VALUES(1499.0, TIMESTAMP('2020-02-01 21:03:20'), 'Unpaid', '1', 1, 1, 'Do not forget my order.'), 
(899.0, TIMESTAMP('2020-01-01 21:03:20'), 'Finished', '1', 1, 1, 'Thank you!'),
(677.0, TIMESTAMP('2020-05-06 21:03:20'), 'Unpaid', '1', 1, 1, 'Be Quick.'),
(599.0, TIMESTAMP('2020-02-10 10:09:20'), 'Finished', '1', 2, 2, 'Please fulfill the shipment ASAP.');
