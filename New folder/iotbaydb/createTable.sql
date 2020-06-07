/* Shipment_Details Table */
CREATE TABLE Shipment_Details 
(shipmentDetailsID int NOT NULL 
    GENERATED ALWAYS AS IDENTITY 
    (START WITH 1, INCREMENT BY 1),
streetAddress varchar(50),
suburb varchar(20),
postcode int,
state char(3),
int userAccountID,
PRIMARY KEY (shipmentDetailsID),
FOREIGN KEY (userAccountID)
);


/* Shipment Table */
CREATE Table Shipment
(
shipmentID int NOT NULL
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
courierName varchar (20),
shipmentStatus varchar(20),
trackingNumber varchar (20),
shipmentDate varchar(10),
shipmentDetailsID int,
orderID int,
PRIMARY KEY (shipmentID),
FOREIGN KEY (shipmentDetailsID) REFERENCES Shipment_Details(shipmentDetailsID),
FOREIGN KEY (orderID) REFERENCES Order (orderID)
);

/* Order Table */

/* Other Tables */
