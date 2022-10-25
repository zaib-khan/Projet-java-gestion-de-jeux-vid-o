/*Table Etablissement*/
create table etablissement(
	Matricule int(10) primary key,
	Nom varchar(255) not null,
	Adresse varchar (255) not null,
	Telephone varchar (255) not null,
	Email varchar(255) not null,
	constraint MatriculeCk check (Matricule > 0));
	
insert into etablissement
values (1,"GameStop Mons","523 rue grande, Mons","0485/122364","GameStopMons@hotmail.com");

insert into etablissement
values (2,"GameStop Namur","24 rue Rogier, Namur","0486/781467","GameStopNamur@hotmail.com");

insert into etablissement
values (3,"GameStop Liège","12 chaussée de Louvain, Liège","0487245623","GameStopLiège@hotmail.com");

insert into etablissement
values (4,"GameStop Bruxelles","place de la Revolution, Bruxelles","0400636674","GameStopBruxelles@hotmail.com");

insert into etablissement
values (5,"GameStop Ostende","port maritime, Ostende","0472636614","GameStopOstende@hotmail.com");

insert into etablissement
values (6,"GameStop Arlon","rue de la liberation, Arlon","0400636674","GameStopArlon@hotmail.com");

insert into etablissement
values (7,"GameStop Genk","rue flamande, Genk","040063734","GameStopGenk@hotmail.com");


/*Table Client */

create table client(
	Identifiant varchar(255) primary key,
	EtablissementMatricule int(10) not null,
	Nom varchar(255) not null,
	Prenom varchar(255) not null,
	CodePostal varchar(255)not null,
	Ville varchar(255) not null,
	Rue varchar(255) not null,
	Numero varchar(255) not null,
	DateNaissance date not null,
	Telephone varchar(255),
	Email varchar(255),
	CarteFidelite bit(1) not null,
	TailleLunette double,
	TailleCeinture double,
	TailleVetement varchar(255),
	constraint EtablissementMatriculeClientCK foreign key (EtablissementMatricule)references etablissement (Matricule),
	constraint TailleLunetteCK check (TailleLunette >0),
	constraint TailleCeintureCK check (TailleCeinture >0));

insert into client
values("Theleboucrt",2,"Leboutte","Adrien","5523","Sommière","Rue Grande","52",str_to_date("25-02-1994","%d-%m-%Y"),"0456962372","adrien@hotmail.com",true,null,null,null);

insert into client
values("Shazaka",1,"Khan","Zaib","6000","Mons","chaussée de Namur","27",str_to_date("05-02-1996","%d-%m-%Y"),"0454725746","zaib@me.com",true,12.0,71.0,"L");

insert into client
values("Dekkax",2,"Delval","Antonin","5000","Namur","Rue Grande","3",str_to_date("13-10-1997","%d-%m-%Y"),"0455689733","dekkax@hotmail.com",false,10.3,70.0,"M");

insert into client
values("Wildman",4,"Herman","Xavier","1236","Bruxelles","place du Roi","1",str_to_date("23-08-1980","%d-%m-%Y"),"0456862488","wavier@hotmail.com",false,null,null,null);

insert into client
values("Mummak",5,"Hensen","Florent","3000","Rose","place de la ferme","1",str_to_date("14-07-1994","%d-%m-%Y"),null,"florent@hotmail.com",false,null,null,null);

insert into client
values("LiveBerniDJ",6,"Robinson","John","3000","Dinant","place de la cathedrale","1",str_to_date("13-04-1963","%d-%m-%Y"),null,null,false,null,null,null);

insert into client
values("Jewel",7,"Carlier","Noel","4231","Dilbeek","place monseu","4",str_to_date("14-07-1994","%d-%m-%Y"),"045686717",null,false,10.7,70.5,"XXL");

insert into client
values("Blanchette",3,"Wilmet","Justin","5000","Rosée","rue grande","29",str_to_date("11-09-1996","%d-%m-%Y"),"0486323698",null,true,10.0,70.0,"XS");

/*Table Vendeur*/

create table vendeur(
	NumIdentifiant int(10) primary key,
	EtablissementMatricule int(10) not null ,
	Nom varchar(255) not null,
	Prenom varchar(255) not null,
	DateNaissance date,
	constraint EtablissementMatriculeVendeurCK foreign key (EtablissementMatricule) references etablissement (Matricule)) ;
	
insert into vendeur
values(1000,2,"Gilson","Jean",null);

insert into vendeur
values(1001,1,"Besson","Hugues",str_to_date("23-08-1964","%d-%m-%Y"));

insert into vendeur
values(1002,4,"Posson","Michel",str_to_date("21-04-1969","%d-%m-%Y"));

insert into vendeur
values(1003,4,"Willem","Sophie",str_to_date("27-02-1985","%d-%m-%Y"));

insert into vendeur
values(1004,5,"Willems","Benoit",str_to_date("27-02-1981","%d-%m-%Y"));

insert into vendeur
values(1005,6,"Baudoin","Erix",str_to_date("11-09-1981","%d-%m-%Y"));

insert into vendeur
values(1006,7,"Legrand","John",str_to_date("31-12-1985","%d-%m-%Y"));

/*Table Facture*/

create table facture(
	Numero int(10) primary key,
	DateFacture date not null,
	VendeurNumIdentifiant int(10)not null,
	ClientIdentifiant varchar(255)not null,
	constraint VendeurNumIdentifiantCK foreign key (VendeurNumIdentifiant) references vendeur (NumIdentifiant),
	constraint ClientIdentifiantCK foreign key (ClientIdentifiant) references client (Identifiant));

insert into facture
values(1,str_to_date("23-02-2019","%d-%m-%Y"),1000,"Theleboucrt");
insert into facture
values(2,str_to_date("14-02-2016","%d-%m-%Y"),1000,"Theleboucrt");
insert into facture
values(3,str_to_date("03-11-2001","%d-%m-%Y"),1000,"Theleboucrt");
insert into facture
values(4,str_to_date("23-02-2000","%d-%m-%Y"),1000,"Theleboucrt");
insert into facture
values(5,str_to_date("30-01-2007","%d-%m-%Y"),1000,"Theleboucrt");
insert into facture
values(6,str_to_date("23-02-2014","%d-%m-%Y"),1000,"Theleboucrt");


insert into facture
values(7,str_to_date("01-02-2000","%d-%m-%Y"),1001,"Shazaka");
insert into facture
values(8,str_to_date("23-02-2014","%d-%m-%Y"),1001,"Shazaka");
insert into facture
values(9,str_to_date("23-12-2003","%d-%m-%Y"),1001,"Shazaka");
insert into facture
values(10,str_to_date("17-06-2012","%d-%m-%Y"),1001,"Shazaka");


insert into facture
values(11,str_to_date("17-06-2018","%d-%m-%Y"),1000,"Dekkax");
insert into facture
values(12,str_to_date("13-02-2002","%d-%m-%Y"),1000,"Dekkax");

insert into facture
values(13,str_to_date("17-07-2016","%d-%m-%Y"),1002,"Wildman");

insert into facture
values(14,str_to_date("11-07-1998","%d-%m-%Y"),1003,"Jewel");
insert into facture
values(15,str_to_date("15-09-1998","%d-%m-%Y"),1003,"Jewel");

insert into facture
values(16,str_to_date("11-07-2005","%d-%m-%Y"),1003,"LiveBerniDJ");

insert into facture
values(17,str_to_date("11-03-2012","%d-%m-%Y"),1003,"Mummak");

insert into facture
values(18,str_to_date("13-06-1999","%d-%m-%Y"),1005,"Blanchette");
insert into facture
values(19,str_to_date("28-11-2019","%d-%m-%Y"),1006,"Blanchette");


/*Table Goodie*/

create table goodie(
	Code int(10) primary key,
	Libelle varchar(255) not null,
	PrixBase double not null,
	typeGoodie varchar(255) not null,
	FactureNumero int(10),
	constraint FactureNumeroGoodieCK foreign key (FactureNumero) references facture(Numero));


insert into goodie
values(1,"Mug Star wars",15.5,"Objet",1);

insert into goodie
values(2,"T-shirt Star wars",30.0,"Vetement",4);

insert into goodie
values(3,"BD GOT",10.0,"BD",2);

insert into goodie
values(4,"Peluche winnie l'ourson",15.5,"Objet",null);

insert into goodie
values(5,"Radio LOTR",95.5,"radio",13);

insert into goodie
values(6,"Mug Marvel",15.5,"Objet",12);

insert into goodie
values(7,"Poster Star wars",45.5,"Objet",11);

insert into goodie
values(8,"Manette RE6",36.9,"Manette",10);

insert into goodie
values(9,"Poster roi lion",15.5,"Objet",9);

insert into goodie
values(10,"Mug Star wars 7",12.0,"Objet",null);

insert into goodie
values(11,"Poster Rick et Morty",15.5,"Objet",1);


insert into goodie
values(12,"Poster Rick et Morty",15.5,"Objet",14);

insert into goodie
values(13,"Poster LOTR",15.5,"Objet",15);

insert into goodie
values(14,"Mug Hello Kitty",33.5,"Objet",18);

insert into goodie
values(15,"T-shirt Batman",15.5,"Vetement",19);

insert into goodie
values(16,"T-shirt Batman",15.5,"Vetement",18);

insert into goodie
values(17,"T-shirt Batman",15.5,"Vetement",16);

/*Table Jeu*/
create table jeu(
	Code int(10) primary key,
	Titre varchar(255) not null,
	Genre varchar(255) not null,
	Theme varchar(255) not null,
	PrixBase double not null,
	LimiteAge int(10) not null,
	AnneeSortie int(10) not null,
	BaseDe	int(10),
	SuiteDe int(10),
	constraint BaseDeCK foreign key (BaseDe) references jeu (Code),
	constraint SuiteDeCK foreign key (SuiteDe) references jeu (Code),
	constraint	AnneeSortieCK check (AnneeSortie>1939),
	constraint LimiteAgeCK check (LimiteAge >0)
);

insert into jeu
values(1,"Call of Duty 1","FPS","Guerre",19.9,18,2004,null,null);
insert into jeu
values(2,"Call of Duty 2","FPS","Guerre",19.9,18,2005,1,1);
insert into jeu
values(3,"Call of Duty 3","FPS","Guerre",19.9,18,2006,1,2);
insert into jeu
values(4,"Call of Duty 4","FPS","Guerre",19.9,18,2007,null,null);
insert into jeu
values(5,"Call of Duty 5","FPS","Guerre",49.9,18,2009,1,null);

insert into jeu
values(6,"Age of Empire ","Strategie","Guerre / Civilisation",9.9,12,1998,null,null);
insert into jeu
values(7,"Age of Empire : The conqueror","Strategie","Guerre",49.9,18,2009,null,6);

insert into jeu
values(8,"Tetris","PuzzleGame","Puzzle",49.9,18,1989,null,null);

insert into jeu
values(9,"Batman Arkham : Asylum","Action","Super-Heros",69.9,18,2004,null,null);

insert into jeu
values(10,"Mario Party ","PartyGame","Mini-Jeux",79.9,7,1999,null,null);

/*Table Plateforme*/

create table plateforme(
	Libelle varchar(255) primary key);
	
insert into plateforme
values ("PC");	
insert into plateforme
values ("Commodore");

insert into plateforme
values ("PS4");
insert into plateforme
values ("PS3");
insert into plateforme
values ("PS2");
insert into plateforme
values ("PS1");

insert into plateforme
values ("XBOX");
insert into plateforme
values ("XBOX ONE");
insert into plateforme
values ("XBOX 360");

insert into plateforme
values ("NES");
insert into plateforme
values ("SNES");
insert into plateforme
values ("N64");
insert into plateforme
values ("Gamecube");
insert into plateforme
values ("Wii");
insert into plateforme
values ("Wii U");
insert into plateforme
values ("Switch");


/*Table Catalogue*/

create table catalogue(
	JeuCode int(10),
	PlateformeLibelle varchar(255),
	constraint PRIMARY KEY (JeuCode,PlateformeLibelle),
	constraint JeuCodeCatalogueCK foreign key (JeuCode) references jeu (Code),
	constraint PlateformeLibelleCK foreign key (PlateformeLibelle) references plateforme(libelle));
	
insert into catalogue
values(1,"PS2");
insert into catalogue
values(1,"XBOX");
insert into catalogue
values(1,"PC");
insert into catalogue
values(1,"Wii");


insert into catalogue
values(2,"PS2");
insert into catalogue
values(2,"XBOX");
insert into catalogue
values(2,"PC");

insert into catalogue
values(3,"PS2");
insert into catalogue
values(3,"XBOX");
insert into catalogue
values(3,"PC");


insert into catalogue
values(4,"XBOX 360");

insert into catalogue
values(5,"XBOX");

insert into catalogue
values(6,"PC");

insert into catalogue
values(7,"PC");

insert into catalogue
values(8,"NES");



/*Table Exemplaire*/

create table exemplaire(
	Numero int(10),
	JeuCode int(10),
	NumRayon int(10) not null,
	NumEtagere int(10) not null,
	Edition varchar(255) not null,
	FactureNumero int(10),
	constraint PRIMARY KEY (Numero,JeuCode),
	constraint JeuCodeExemplaireCK foreign key (JeuCode) references jeu (Code),
	constraint FactureNumeroExemplaireCK foreign key (FactureNumero) references facture(Numero));
	
insert into exemplaire
values (1,1,3,4,"Game of the year",1);

insert into exemplaire
values (2,2,3,8,"Collector deluxe",2);

insert into exemplaire
values (3,3,3,4,"Game of the year",3);

insert into exemplaire
values (4,4,3,4,"Game of the year",4);

insert into exemplaire
values (5,5,3,4,"Normal",5);

insert into exemplaire
values (6,6,3,4,"Deluxe",6);

insert into exemplaire
values (7,1,3,4,"Collector",7);

insert into exemplaire
values (8,7,3,4,"BOX",8);

insert into exemplaire
values (9,7,3,4,"BOX",8);

insert into exemplaire
values (10,8,3,4,"BOX",8);

insert into exemplaire
values (11,4,3,4,"Game of the year",null);

insert into exemplaire
values (12,8,3,4,"Deluxe",16);

insert into exemplaire
values (13,8,3,4,"Normal",17);

insert into exemplaire
values (14,9,3,4,"Normal",18);

insert into exemplaire
values (15,10,3,4,"Normal",19);

insert into exemplaire
values (16,10,3,4,"Normal",18);

insert into exemplaire
values (17,10,3,4,"Normal",17);

