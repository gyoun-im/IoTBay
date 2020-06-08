/* Insert SQL statement for Customer Table */

INSERT INTO CUSTOMER
(NAME, CONTACTNUMBER, EMAIL, BILLINGADDRESS, ISREGISTERED)
VALUES
('Susan Gretch', '0453216596', 'susangretch@gmail.com', '51 Car St Sydney 2000', True),
('Albert Prob', '0462237789', 'albertprob@gmail.com', '31 Maine St Sydney 2000', True),
('Anna Mel', '0456289635', 'annamel@gmail.com', '89 Red St Sydney 2000', True),
('Sarah Trumb', '0456874124', 'sarahtrumb@gmail.com', '21 Blue St Sydney 2000',True),
('Alex Treck', '0471498746', 'alextreck@gmail.com', '49 Truck St Sydney 2000', True),
('Tom Treb', '0478945123', 'tomtreb@gmail.com', '90 Table St Sydney 2000',True),
('Mallory Lurd', '0497189632', 'mallorylurd@gmail.com', '22 Chair St Sydney 2000',True),
('Lydia Shield', '0412123145', 'lydiashield@gmail.com', '33 Leaf St Sydney 2000',True),
('Philip Cruz', '0474158789', 'philipcruz@gmail.com', '63 Tree St Sydney 2000',True),
('Kylie Knows', '0465123789', 'kylieknows@gmail.com', '11 Sun St Sydney 2000',True),
('Peter Sands', '0462321789', 'petersands@gmail.com', '78 Mich St Sydney 2000',True),
('Daniel Malo', '0415971359', 'danielmaloy@gmail.com', '12 Car St Sydney 2000',True),
('Sophie Raven', '0462613317', 'sophieraven@gmail.com', '45 Car St Sydney 2000',True),
('Vicky Last', '0465231777', 'vickylast@gmail.com', '90 Maine St Sydney 2000',True),
('William High', '0455611237', 'williamhigh@gmail.com', '29 Blue St Sydney 2000',True),
('Ben Wallow', '0445112332', 'benwallow@gmail.com', '90 Chair St Sydney 2000',True),
('Man Tomb', '0465663326', 'mantomb@gmail.com', '13 Sun St Sydney 2000',True),
('Kennedy Frast', '0477982146', 'kennedyfrast@gmail.com', '67 Corner St Sydney 2000',True),
('Liz Lips', '0477988562', 'lizlips@gmail.com', '31 Pen St Sydney 2000',True),
('Shane Bran', '0451122333', 'shanebran@gmail.com', '66 Paper St Sydney 2000',True),
('Phil Branson', '0489888999', 'philbranson@gmail.com', '21 Glove St Sydney 2000',True);

/* Insert SQL statement for User_Account Table */

INSERT INTO USER_ACCOUNT
(USERNAME, PASSWORD, DATEOFBIRTH, GENDER, PROMOTIONALNEWSLETTER, REWARDPOINTS)
Values
('susangretch@gmail.com', 'hello', '31/12/1995', 'Female', false, 0),
('albertprob@gmail.com', 'wave', '15/02/1995', 'Male', true, 10),
('annamel@gmail.com', 'loppy', '16/08/1995', 'Female', false, 30),
('sarahtrumb@gmail.com', 'blue', '02/02/1997', 'Female', false, 50),
('alextreck@gmail.com', 'turtle', '03/01/1994', 'Male', false, 0),
('tomtreb@gmail.com', 'mountain', '26/06/1995', 'Male', true, 0),
('mallorylurd@gmail.com', 'forest', '14/08/1995', 'Male', false, 20),
('lydiashield@gmail.com', 'shield', '16/08/1989', 'Female', false, 0),
('philipcruz@gmail.com', 'pool', '13/07/1996', 'Male', true, 0),
('kylieknows@gmail.com', 'sunny', '08/08/1995', 'Female', true, 50),
('petersands@gmail.com', 'house', '28/02/1990', 'Male', true, 0),
('danielmaloy@gmail.com', 'grass', '12/09/1995', 'Male', false, 0),
('sophieraven@gmail.com', 'window', '17/07/1993', 'Female', true, 80),
('vickylast@gmail.com', 'shiny', '25/07/1995', 'Female', false, 80),
('williamhigh@gmail.com', 'class', '14/07/1995', 'Male', false, 0),
('benwallow@gmail.com', 'drawer', '06/06/1995', 'Male', true, 0),
('mantomb@gmail.com', 'container', '04/04/1990', 'Male', false, 10),
('kennedyfrast@gmail.com', 'roads', '05/05/1995', 'Male', true, 10),
('lizlips@gmail.com', 'boxes', '19/08/1995', 'Female', true, 0),
('shanebran@gmail.com', 'keys', '14/07/1996', 'Male', false, 0),
('philbranson@gmail.com', 'rakes', '15/08/1990', 'Female', false, 20),
('sarahgrant@gmail.com', 'leaves', '04/05/1985', 'Female', null, null),
('benmalik@gmail.com', 'hands', '26/07/1985', 'Male', null, null),
('philipsaw@gmail.com', 'heads', '09/08/1985', 'Male', null, null),
('marktrobe@gmail.com', 'garden', '06/05/1985', 'Male', null, null),
('davidso@gmail.com', 'grass', '13/07/1985', 'Male', null, null),
('analabel@gmail.com', 'yellow', '10/09/1985', 'Female', null, null),
('joycereyes@gmail.com', 'blue', '23/01/1985', 'Female', null, null),
('kiaradaves@gmail.com', 'trucks', '19/09/1985', 'Female', null, null),
('nickplays@gmail.com', 'office', '03/11/1985', 'Male', null, null),
('freyagold@gmail.com', 'drums', '4/05/1985', 'Female', null, null),
('amandarows@gmail.com', 'guitar', '23/01/1985', 'Female', null, null),
('darlenefurlow@gmail.com', 'trees1', '13/07/1985', 'Female', null, null),
('juliejoys@gmail.com', 'guitar1', '15/07/1985', 'Female', null, null),
('trevordavid@gmail.com', 'leaves1', '13/02/1985', 'Male', null, null),
('marygreen@gmail.com', 'gloves', '20/02/1985', 'Female', null, null),
('blakedark@gmail.com', 'paper', '23/07/1985', 'Male', null, null),
('stanproper@gmail.com', 'pens', '25/12/1985', 'Male', null, null),
('chrisstar@gmail.com', 'books', '13/04/1985', 'Male', null, null),
('nieldiamond@gmail.com', 'notepad', '16/04/1985', 'Male', null, null),
('aaronfrey@gmail.com', 'phones', '29/08/1985', 'Male', null, null),
('fionaal@gmail.com', 'tails', '23/11/1985', 'Female', null, null);

/* Insert SQL statement for Staff Table */

INSERT INTO STAFF
(NAME, EMAIL, PHONENUMBER, ADDRESS, STAFFTYPE, ACTIONHISTORY, USERACCOUNTID)
VALUES
('Sarah Grant'      , 'sarahgrant@gmail.com', '0478999656', '14 Mellow St Sydney 2000', 'Normal staff', NULL, 22),
('Ben Malik'        , 'benmalik@gmail.com', '0466332230', '26 Grange St Sydney 2000', 'Normal staff', NULL,23),
('Philip Saw'       , 'philipsaw@gmail.com', '0411232332', '28 Red St Sydney 2000', 'Normal staff', NULL,24),
('Mark Trobe'       ,'marktrobe@gmail.com', '0489988895', '23 Guard St Sydney 2000','Manager', NULL,25),
('David So'         , 'davidso@gmail.com', '0415323656', '56 Bright St Sydney 2000', 'Normal staff', NULL,26),
('Ana Label'        , 'analabel@gmail.com', '0478977888', '12 Light St Sydney 2000', 'Normal staff', NULL,27),
('Joyce Reyes'      , 'joycereyes@gmail.com', '0444111555', '10 Dark St Sydney 2000', 'Manager', NULL,28),
('Kiara Daves'      , 'kiaradaves@gmail.com', '0456332225', '12 Block St Sydney 2000', 'Normal staff', NULL,29),
('Nick Plays'       , 'nickplays@gmail.com', '0455623147', '15 Tick St Sydney 2000','Normal staff', NULL,30),
('Freya Gold'       , 'freyagold@gmail.com', '0453214987', '58 Screen St Sydney 2000', 'Manager', NULL,31),
('Amanada Rows'     , 'amandarows@gmail.com', '0411122369', '8 Boxes St Sydney 2000', 'Normal staff', NULL,32),
('Darlene Furlow'   , 'darlenefurlow@gmail.com', '0465789456', '9 Keys St Sydney 2000', 'Normal staff', NULL,33),
('Julie Joys'       , 'juliejoys@gmail.com', '0412123456', '56 Mellow St Sydney 2000', 'Normal staff', NULL,34),
('Trevor David'     , 'trevordavid@gmail.com', '0465741852', '90 Yellow St Sydney 2000', 'Manager', NULL,35),
('Mary Green'       , 'marygreen@gmail.com', '0496852963', '56 Dark St Sydney 2000', 'Normal staff', NULL,36),
('Blake Dark'       , 'blakedark@gmail.com', '0498654321', '10 Bright St Sydney 2000', 'Normal staff', NULL,37),
('Stan Proper'      , 'stanproper@gmail.com', '0478963123', '11 Soldier St Sydney 2000','Normal staff', NULL,38),
('Chris Star'       , 'chrisstar@gmail.com', '0456123789', '7 Table St Sydney 2000', 'Normal staff', NULL,39),
('Niel Diamond'     ,'nieldiamond@gmail.com', '0496159753', '1 Chair St Sydney 2000', 'Normal staff', NULL,40),
('Aaron Frey', 'aaronfrey@gmail.com', '0496946156', '10 Block St Sydney 2000', 'Normal staff', NULL,41),
('Fiona Al', 'fionaal@gmail.com', '0478753159', '63 Mellow St Sydney 2000', 'Normal staff', NULL,42);

/* Insert SQL statement for Customer_User Table */

INSERT INTO CUSTOMER_USER (USERACCOUNTID, CUSTOMERID)
VALUES
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(6, 5),
(7, 6),
(8, 7),
(9, 8),
(10, 9),
(11, 10),
(12, 11),
(13, 12),
(14, 13),
(15, 14),
(16, 15),
(17, 16),
(18, 17),
(19, 18),
(20, 19),
(21, 20),
(22, 21),
(23, 22);

/* Insert SQL statement for Access_Log Table */

INSERT INTO ACCESS_LOG (USERACCOUNTID, DATE, TIME, ACTION)
VALUES
(1, '11/05/2020', '6:05 pm', 'LOGOUT'),
(12, '11/05/2020', '7:25 am', 'LOGIN'),
(8, '11/05/2020', '5:13 pm', 'LOGOUT'),
(19, '12/05/2020', '11:17 pm', 'LOGOUT'),
(20, '12/05/2020', '3:35 pm', 'LOGOUT'),
(6, '15/05/2020', '1:45 am', 'LOGIN'),
(11, '15/05/2020', '1:42 am', 'LOGIN'),
(8, '16/05/2020', '5:32 pm', 'LOGIN'),
(6, '17/05/2020', '10:38 am', 'LOGOUT'),
(12, '18/05/2020', '11:19 pm', 'LOGIN'),
(17, '18/05/2020', '9:07 am', 'LOGOUT'),
(18, '18/05/2020', '7:06 am', 'LOGIN'),
(1, '20/05/2020', '1:17 pm', 'LOGOUT'),
(3, '20/05/2020', '12:44 am', 'LOGOUT'),
(14, '21/05/2020', '4:33 pm', 'LOGIN'),
(14, '22/05/2020', '4:22 am', 'LOGIN'),
(8, '23/05/2020', '4:11 pm', 'LOGOUT'),
(16, '23/05/2020', '6:37 am', 'LOGIN'),
(1, '25/05/2020', '8:39 am', 'LOGOUT'),
(17, '25/05/2020', '7:29 pm', 'LOGIN'),
(1, '26/05/2020', '7:28 pm', 'LOGOUT');