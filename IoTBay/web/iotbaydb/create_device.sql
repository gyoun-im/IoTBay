/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  apple1
 * Created: 07/06/2020
 */

drop table DEVICE;
create table DEVICE
(
	ID INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	"NAME" VARCHAR(200) not null,
	"TYPE" VARCHAR(200),
	UNIT VARCHAR(100),
	PRICE DOUBLE default 0 not null,
	STOCK INTEGER default 0 not null
);

INSERT INTO DEVICE ("NAME", "TYPE", "UNIT", "PRICE", "STOCK") 
VALUES('iPhone', 'Electronic', 'each', 1499.0, 1000), ('iPad', 'Electronic', 'each', 499.0, 5000);
