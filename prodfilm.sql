create database prodfilm;

\c prodfilm;


create sequence acteur_seq;
CREATE TABLE Acteur (
    idacteur varchar(15) NOT NULL default 'ACE'||nextval('acteur_seq'),
    nom text NOT NULL,
    prenom text NOT NULL,
    datenaissance date NOT NULL,
    PRIMARY KEY (idacteur)
);


create sequence action_seq;
CREATE TABLE Action (
    idaction varchar(15) NOT NULL default 'ACI'||nextval('action_seq'),
    evenement text NOT NULL ,
    ordre int4 NOT NULL,
    idscene varchar(15) NOT NULL,
    idpersonnage varchar(15) NOT NULL,
    expression text,
    PRIMARY KEY (idaction)
);

create sequence film_seq;
CREATE TABLE Film (
    idfilm varchar(15) NOT NULL default 'FIL'||nextval('film_seq'),
    nomfilm text NOT NULL,
    PRIMARY KEY (idfilm)
);

create sequence personnage_seq;
CREATE TABLE Personnage (
    idpersonnage varchar(15) NOT NULL default 'PER'||nextval('personnage_seq'),
    nom text NOT NULL,
    prenom text NOT NULL,
    datenaissance date NOT NULL,
    idacteur varchar(15) NOT NULL,
    idfilm varchar(15) NOT NULL,
    PRIMARY KEY (idpersonnage)
);

CREATE TABLE Personnage_scene (
     id serial PRIMARY key,
    idpersonnage varchar(15) NOT NULL,
    idscene varchar(15) NOT NULL
);

create sequence plateau_seq;
CREATE TABLE Plateau (
    idplateau varchar(15) NOT NULL default 'PLA'||nextval('plateau_seq'),
    nomplateau text NOT NULL,
    description text NOT NULL,
    PRIMARY KEY (idplateau)
);

create sequence scene_seq;
CREATE TABLE Scene (
    idscene varchar(15) NOT NULL default 'SCE'||nextval('scene_seq'),
    idplateau varchar(15) NOT NULL,
    idfilm varchar(15) NOT NULL,
    nom text NOT NULL,
    duree interval not null,
    PRIMARY KEY (idscene)
);

create sequence horaire_seq;
create table horaire(
    idhoraire varchar(15) NOT NULL default 'HOR'||nextval('horaire_seq'),
    ouverture time not null,
    fermeture time not null
);

ALTER TABLE
    Scene
ADD
    CONSTRAINT FKScene395567 FOREIGN KEY (idplateau) REFERENCES Plateau (idplateau);

ALTER TABLE
    Action
ADD
    CONSTRAINT FKAction171294 FOREIGN KEY (idscene) REFERENCES Scene (idscene);

ALTER TABLE
    Action
ADD
    CONSTRAINT FKAction273176 FOREIGN KEY (idpersonnage) REFERENCES Personnage (idpersonnage);

ALTER TABLE
    Scene
ADD
    CONSTRAINT FKScene38548 FOREIGN KEY (idfilm) REFERENCES Film (idfilm);

ALTER TABLE
    Personnage
ADD
    CONSTRAINT FKPersonnage67471 FOREIGN KEY (idacteur) REFERENCES Acteur (idacteur);

ALTER TABLE
    Personnage
ADD
    CONSTRAINT FKPersonnage269256 FOREIGN KEY (idfilm) REFERENCES Film (idfilm);

ALTER TABLE
    Personnage_scene
ADD
    CONSTRAINT FKPersonnage894666 FOREIGN KEY (idscene) REFERENCES Scene (idscene);

ALTER TABLE
    Personnage_scene
ADD
    CONSTRAINT FKPersonnage996548 FOREIGN KEY (idpersonnage) REFERENCES Personnage (idpersonnage);

INSERT INTO acteur(nom,prenom,datenaissance) values
-- 
('Johnson','Dwayne','1987-01-12'),
('Hart','Kevin','1988-03-13'),
('Gillan','Karen','1978-11-10'),
('Jonas','Nick','1989-12-19'),
('Wolf','Alex','1979-06-23'),
('Turner','Morgan','1989-07-08'),
('Iseman','Turner','1990-10-12'),
('Glover','Danny','1995-06-10'),
('Hanks','Colin','1996-06-14')
-- 
;
insert into film(nomfilm) values
('Jumanji')
;

insert into Personnage(nom,prenom,datenaissance,idacteur,idfilm) values
('Bravestone','Smolder','1990-04-12','ACE1','FIL1'),
('Finbar','Mouse','1991-05-12','ACE2','FIL1'),
('Runhouse','Ruby','1993-06-12','ACE3','FIL1'),
('Rudes','Andre','1989-06-14','ACE4','FIL1'),
('Oberon','Sheldon','1979-05-18','ACE5','FIL1'),
('Gilpin','Spencer','1995-10-14','ACE6','FIL1'),
('Goble','Fridge','1995-02-02','ACE7','FIL1'),
('Cole','Braverman','1996-04-02','ACE8','FIL1'),
('Collins','Jack','1996-05-10','ACE9','FIL1')
;

insert into plateau(nomplateau,description) values
('Lycee Jefferson','Un lycee au beverly hills'),
('Salon','Le salon de spencer gilpin'),
('Aeroport de Californie','Dans l aeroport le plus grand de new york'),
('Dans la cuisine de Ruby','La petite cuisine chic de Ruby')
;

insert into horaire(ouverture,fermeture)values
('08:00:00','12:00:00')
;

insert into scene(idplateau,idfilm,nom,duree) values
('PLA1','FIL1','Travail de groupe en classe','3 minutes'),
('PLA2','FIL1','Jeu de video a la maison','4 minutes')
;

insert into personnage_scene(idpersonnage,idscene) values
('PER2','SCE1'),
('PER3','SCE1'),
('PER4','SCE1'),
('PER1','SCE2'),
('PER2','SCE2')
;

insert into action(evenement,ordre,idscene,idpersonnage,expression) values
('Mouse dit:Je suis genial',1,'SCE1','PER2','en riant'),
('Ruby dit:Peut-etre je ne suis pas sur',2,'SCE1','PER3','en rigolant'),
('Andre arrive tout sourire',3,'SCE1','PER4',null)
;

create or replace view perso_scene as 
select
personnage.idpersonnage,personnage.nom nompersonnage,datenaissance,prenom,idacteur,
scene.*
from personnage_scene
join personnage on personnage.idpersonnage=personnage_scene.idpersonnage
join scene on scene.idscene=personnage_scene.idscene
;

create view v_scene_optim as 
select personnage_scene.idscene,count(idpersonnage) as nbperso,duree from personnage_scene join scene on personnage_scene.idscene=scene.idscene group by duree, personnage_scene.idscene order by nbperso asc, duree asc;

create view scene_acteur as 
 select id, idscene, idacteur from personnage_scene join personnage on personnage_scene.idpersonnage=personnage.idpersonnage;

create view v_scene as select*from scene;
