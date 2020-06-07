/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Bryan Guntoro
 * Created: May 19, 2020
 */

CREATE TABLE Shipment_Details 
(
shipmentDetailsID int NOT NULL 
    GENERATED ALWAYS AS IDENTITY 
    (START WITH 1, INCREMENT BY 1),
streetAddress varchar(50),
suburb varchar(20),
postcode int,
state char(3),
userAccountID int ,
PRIMARY KEY (shipmentDetailsID),
FOREIGN KEY (userAccountID)

)