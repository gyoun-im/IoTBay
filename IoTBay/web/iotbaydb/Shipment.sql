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



INSERT INTO SHIPMENT (COURIERNAME, SHIPMENTSTATUS, TRACKINGNUMBER, SHIPMENTDETAILSID, ORDERID)
VALUES
('UPS', 'Delivered', 'UPS3201312309','22/03/2020', 1, 1001),
('FedEx', 'Dispatched', 'FE11230943', '22/03/2020',2, 1002),
('AusPost', 'In Warehouse', 'AP301312309','22/03/2020', 3, 1003),
('StarTrack', 'In Transit', 'ST3201122309','22/03/2020', 2, 1004),
('DHL', 'Pending', 'DHL9271312309','22/03/2020', 4, 1005),
('FedEx', 'Dispatched', 'FE5932658', '22/03/2020',5, 1006);
('StarTrack', 'In Transit', 'ST3231122309','23/03/2020', 2, 1007),
('DHL', 'Pending', 'DHL9921312309','23/03/2020', 4, 1008),
('FedEx', 'Dispatched', 'FE5234658', '24/03/2020',5, 1009);
('StarTrack', 'In Transit', 'ST326122309','24/03/2020', 2, 1010),
('DHL', 'Pending', 'DHL925312309','25/03/2020', 4, 1011),
('FedEx', Delivered ', 'FE51204658', '26/03/2020',5, 1012);
('StarTrack', 'In Transit', 'ST7841122309','27/03/2020', 2, 1013),
('DHL', ' Delivered ', 'DHL945642309','28/03/2020', 4, 1014),
('FedEx', 'Dispatched', 'FE5922456458', '29/03/2020',5, 1015);
('StarTrack', 'In Transit', 'ST325462309','30/03/2020', 2, 1016),
('DHL', 'Pending', 'DHL95461312309','30/03/2020', 4, 1017),
('FedEx', ' Delivered ', 'FE59204658', '30/03/2020',5, 1006);
('AusPost', 'In Warehouse', 'AP301312309','30/03/2020', 3, 1003)
