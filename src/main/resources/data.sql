use paymybuddy;

LOCK TABLES client WRITE;
INSERT INTO client VALUES ( 1,'John'     ,'john@mail.ml'    , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 2,'Tim'      ,'tim@mail.ml'     , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 3,'Tom'      ,'tom@mail.ml'     , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 4,'Georges'  ,'georges@mail.ml' , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 5,'Haley'    ,'Haley@mail.ml'   , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 6,'Clara'    ,'Clara@mail.ml'   , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 7,'Smith'    ,'Smith@mail.ml'   , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 8,'Desmond'  ,'Desmond@mail.ml' , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES ( 9,'Molly'    ,'Molly@mail.ml'   , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (10,'Harry'   ,'Harry@mail.ml'    , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (11,'Mark'    ,'Mark@mail.ml'     , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (12,'William' ,'William@mail.ml'  , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (13,'Clarissa','Clarissa@mail.ml' , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (14,'Sally'   ,'Sally@mail.ml'    , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (15,'Jack'    ,'Jack@mail.ml'     , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
UNLOCK TABLES;


LOCK TABLES connection WRITE;
INSERT INTO connection VALUES (1,2);
INSERT INTO connection VALUES (1,3);
INSERT INTO connection VALUES (2,3);
INSERT INTO connection VALUES (2,4);
INSERT INTO connection VALUES (3,2);
INSERT INTO connection VALUES (4,1);
INSERT INTO connection VALUES (4,3);
UNLOCK TABLES;


LOCK TABLES authority WRITE;
INSERT INTO authority VALUES (1,'admin');
INSERT INTO authority VALUES (2,'client');
UNLOCK TABLES;


LOCK TABLES role WRITE;
INSERT INTO role VALUES (1,1);
INSERT INTO role VALUES (1,2);
INSERT INTO role VALUES (2,2);
INSERT INTO role VALUES (3,2);
INSERT INTO role VALUES (4,2);
INSERT INTO role VALUES (5,2);
INSERT INTO role VALUES (6,2);
INSERT INTO role VALUES (7,2);
INSERT INTO role VALUES (8,2);
INSERT INTO role VALUES (9,2);
INSERT INTO role VALUES (10,2);
INSERT INTO role VALUES (11,2);
INSERT INTO role VALUES (12,2);
INSERT INTO role VALUES (13,2);
INSERT INTO role VALUES (14,2);
INSERT INTO role VALUES (15,2);
UNLOCK TABLES;


LOCK TABLES account WRITE;
INSERT INTO account VALUES (1,1,1000);
INSERT INTO account VALUES (2,2,1000);
INSERT INTO account VALUES (3,3,1000);
INSERT INTO account VALUES (4,4,1000);
INSERT INTO account VALUES (5,5,1000);
INSERT INTO account VALUES (6,6,1000);
INSERT INTO account VALUES (7,7,1000);
INSERT INTO account VALUES (8,8,1000);
INSERT INTO account VALUES (9,9,1000);
INSERT INTO account VALUES (10,10,1000);
INSERT INTO account VALUES (11,11,1000);
INSERT INTO account VALUES (12,12,1000);
INSERT INTO account VALUES (13,13,1000);
INSERT INTO account VALUES (14,14,1000);
INSERT INTO account VALUES (15,15,1000);
UNLOCK TABLES;


LOCK TABLES transaction WRITE;
INSERT INTO transaction VALUES (1,NOW(),40,1,2,'restaurant');
INSERT INTO transaction VALUES (2,NOW(),20,3,1,'movie');
INSERT INTO transaction VALUES (3,NOW(),20,4,3,'theater');
UNLOCK TABLES;