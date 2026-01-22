drop table if exists joueur;

create table joueur
( jno int primary key,
  pseudo text,
  email text,
  pwd text,
  elo int);

insert into joueur values
(100,'julie','julie@gmail.com','aaaa',2882),
(125,'paul','paul@gmail.com','zzz',2875),
(150,'farid','farid@gmail.com','bbbb',2850),
(180,'louise','louise@gmail.com','yyyy',2825),
(200,'gabriel','gabriel@gmail.com','cccc',2825),
(230,'leo','leo@gmail.com','xxxx',2770),
(240,'jade','jade@gmail.com','ddddd',2750),
(250,'lucas','lucas@gmail.com','wwwww',2740),
(270,'arthur','arthur@gmail.com','eeee',2740),
(280,'manon','manon@gmail.com','vvvvv',2730),
(290,'tom','tom@gmail.com','ffff',2720),
(300,'mathilde','mathilde@gmail.com','uuuu',2700),
(310,'nathan','nathan@gmail.com','ggggg',2682),
(320,'chloe','chloe@gmail.com','tttt',2675),
(340,'sophie','sophie@gmail.com','hhhhh',2650),
(350,'antoine','antoine@gmail.com','sssss',2625),
(370,'sacha','sacha@gmail.com','iiiii',2625),
(390,'mathis','mathis@gmail.com','rrrr',2600),
(400,'simon','simon@gmail.com','jjjj',2570),
(430,'romane','romane@gmail.com','qqqq',2550),
(440,'anna','anna@gmail.com','kkkk',2540),
(470,'eva','eva@gmail.com','ppppp',2540),
(490,'liam','liam@gmail.com','llll',2530),
(500,'axel','axel@gmail.com','oooo',2520),
(520,'alice','alice@gmail.com','mmmm',2500)
;


