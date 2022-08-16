use paymybuddy;

LOCK TABLES client WRITE;
INSERT INTO client VALUES (1,'john'     ,'john@mail.ml'     , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (2,'tim'      ,'tim@mail.ml'      , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (3,'tom'      ,'tom@mail.ml'      , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
INSERT INTO client VALUES (4,'georges'  ,'georges@mail.ml'  , '$2a$12$iaZaVXJ1Ovq4FemW0SwZMeJVa2NSoM/25QrbimNEM7xEAfn7s0gPu');
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
INSERT INTO role VALUES (1,2);
INSERT INTO role VALUES (2,2);
INSERT INTO role VALUES (3,2);
INSERT INTO role VALUES (4,2);
UNLOCK TABLES;


LOCK TABLES account WRITE;
INSERT INTO account VALUES (1,1,1000);
INSERT INTO account VALUES (2,2,2000);
INSERT INTO account VALUES (3,3,3000);
INSERT INTO account VALUES (4,4,4000);
UNLOCK TABLES;


LOCK TABLES transaction WRITE;
INSERT INTO transaction VALUES (1,40,1,2,'restaurant');
INSERT INTO transaction VALUES (1,20,4,3,'movie');
UNLOCK TABLES;