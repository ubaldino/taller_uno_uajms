-- drop table personal;
-- drop table usuarios;
-- drop table datos;
-- drop table menus;
-- drop table procesos;
-- drop table mepro;
-- drop table roles;
-- drop table rolme;
-- drop table usurol;
-- drop table items;
-- drop table materias;
-- drop table itemat;
-- drop table paralelos;
-- drop table modalidad;
-- drop table dmodalidad;

create sequence personal_codp_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table personal (
    codp bigint primary key default nextval('personal_codp_seq'::regclass),
    nombre varchar(40) not null,
    ap varchar(40),
    am varchar(40),
    estado int not null,
    fnac date not null,
    ecivil varchar(1) not null,
    genero varchar(1) not null,
    direc varchar(100),
    telf varchar(20),
    tipo varchar(1) not null,
    foto varchar(128)
);
alter sequence personal_codp_seq OWNED BY personal.codp;
comment on column personal.nombre IS 'Nombre del a Persona';
comment on column personal.ap IS 'Apellido Paterno';
comment on column personal.am IS 'Apellido Materno';
comment on column personal.estado IS 'Estado 1=activo, 0=nulo';
comment on column personal.fnac IS 'Fecha de nacimiento';
comment on column personal.ecivil IS 'Estado civil';
comment on column personal.genero IS 'Género Masculino o Femenino';
comment on column personal.direc IS 'Dirección';
comment on column personal.telf IS 'Teléfono';
comment on column personal.codp IS 'codigo persona';
comment on column personal.tipo IS 'E=Estudiante, P=profesor';
comment on column personal.foto IS 'foto personal';


insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Saida', 'Urquieta', 'Tapia', 1, '2005/11/12', 'S', 'F', 'C. España, 645', '28390772', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Renán', 'Alfaro', 'Quiroga', 1, '1965/03/12', 'C', 'M', 'C. Gral Trigo, 832', '63438831', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Fernanda', 'Sotomayor', '', 1, '2005/11/19', 'S', 'F', 'Las Panosas', '24995828', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Martha', 'Ribadeneira', 'Soliz', 1, '1958/11/21', 'V', 'F', 'Av. La Paz 234', '87482864', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ana', 'Paz', '', 1, '1977/12/02', 'C', 'F', 'La Madrid N 234', '74828831', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Aida','Salinas','Salinas', 1, '2005/04/17', 'S', 'F', 'C. Cochabamba, 23 ', '69898323', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ivonne Ana','Cabero','Miranda', 1, '2001/04/12', 'S', 'F', 'C. Daniel Campos, 922', '74923878', 'E',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María Magdalena', '', 'Pino', 1, '1963/07/02', 'S', 'F', 'C. Cochabamba 2344', '73092938', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Jhonny', 'Mendez', 'Albino', 1, '1975/06/15', 'S', 'M', 'C. Bolivar 323', '79397724', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Remberto', 'Calizaya', 'Tamayo', 0, '1983/08/12', 'S', 'M', 'C. Litoral, 2344', '70839471', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pedro', 'Ramirez', 'Nieto', 1, '1977/05/29', 'S', 'M', 'Av. Victor Paz 2345', '70482617', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Luis Miguel', 'Benito', 'Arias', 1, '1990/03/31', 'S', 'M', 'C. Santa Cruz, 1344', '72840032', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juana', 'de las Fuentes', 'Jaimes', 1, '1995/10/14', 'S', 'F', 'Av. H. Arce, Nro 234', '70699482', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Mirtha', 'Molina', 'Prima', 1, '1983/09/09', 'S', 'F', 'C. Salta, 234', '62940283', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Marisel', 'Miramar', 'Sartre', 1, '1979/08/04', 'S', 'F', 'C. Oruro, 9023', '69492785', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Antonio', 'del Valle', 'Toluca', 1, '1984/03/21', 'S', 'M', 'C. Miraflores, 234', '62890384', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values(  'Carlos Cristian', 'Romero', 'Perez', 0, '2000/08/24', 'S', 'M', 'B. Guadalquivir, C Sanjinez', '71239402', 'P',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ana María', '', 'Palluca', 0, '2005/10/30', 'S', 'F', 'Av. Mejillones, 949', '63829167', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Karina', 'Tejerina', 'Tapia', 1, '2005/06/09', 'S', 'F', 'C. Colón, 393', '62939542', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Peter', 'Tejerina', 'Tapia', 1, '2005/08/30', 'S', 'M', 'San Andrés, s/n', '72039599', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Segundina', 'Lazo', 'Pelaez', 1, '2006/04/15', 'S', 'F', 'C. Montero, 444', '27275173', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María', 'Paniagua', 'Mendez', 1, '1978/10/25', 'C', 'F', 'Calle Santa Cruz, Nro 234', '74828831', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Mario', 'Berbeja', 'Marquez', 1, '2006/02/22', 'S', 'M', 'C. Tejerina, 943', '74892055', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Benjamín', 'Rios', 'Laguna', 1, '2006/05/13', 'S', 'M', 'C. Arduz, S/N', '72792304', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Andrés', 'Ballesteros', 'Rueda', 1, '2005/06/30', 'S', 'M', 'B. Florida', '62122782', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Selena', 'Arteaga', 'Posadas', 0, '2006/02/04', 'S', 'F', '', '62900523', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María de los Angeles', 'Velazquez', 'Terrazas', 1, '2006/07/13', 'S', 'F', 'C. Luis Vargas, 854', '72342223', 'E',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Mirna Moira', '', 'Valenzuela', 1, '2004/11/16', 'S', 'F', 'C. Méndez, 0034', '702394234', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juan José', 'Andrade', 'Siqueira', 1, '2004/10/14', 'S', 'M', 'C. Suipacha, 234', '768929334', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Saturnina', 'Pinaya', '', 1, '2004/08/02', 'S', 'F', 'C. Bermejo, 043', '799303482', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juán','Panique','Mendoza', 1, '2005/05/16', 'S', 'M', 'C. Villamontes, 048', '792299032', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Filomena Segunda','Rios','Mendieta', 1, '2005/01/05', 'S', 'F', 'Av. Santa Cruz, 634', '62893938', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Antonia','Suarez','Calizaya', 1, '2004/08/03', 'S', 'F', 'C. Litoral, 234', '72833893', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pedro','Calizaya','Medina', 1, '2003/07/14', 'S', 'M', 'C. Arce, 003', '720344832', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Renán','Fuertes','Peralta', 1, '2004/09/25', 'S', 'M', 'C. Molino, 034', '623952334', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'José Antonio', 'Camcho', 'Ortiz', 1, '1978/05/08', 'S', 'M', 'Colon, 138', '22762442', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Facunda Soraya','Nieves','Paz', 1, '2004/09/27', 'S', 'F', 'C. Villavista, 233', '69289342', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juán','Peralta','Méndez', 1, '2004/10/14', 'S', 'M', 'B. Andaluz', '62300403', 'E',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ivanka','Pelaez','Soliz', 0, '2001/02/03', 'S', 'F', 'C. Ingavi, 456', '61293523', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Arturo','Fuertes','Peralta', 1, '2000/09/20', 'S', 'M', 'C. Campero, 93', '62983789', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Filomena Soledad','Flor de Caliz','Quiroga', 1, '2000/10/1', 'S', 'F', 'C. Ballivián, 541', '72302752', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pedro Juan', 'Saldías', 'Monje', 1, '1968/03/11', 'S', 'M', 'B. Las Panosas, s/n', '75625212', 'P',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Antonio','Quisbert','Manta', 1, '2000/11/29', 'S', 'M', 'C. Avila, 933', '72390422', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María','Velasquez','Tonka', 1, '2000/08/23', 'S', 'F', 'C. América, 344', '623498234', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Johanna','Piza','Miranda', 1, '2001/04/29', 'S', 'F', 'C. Ingavi, 238', '608903892', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Vito','Soliz','Soliz', 1, '2000/08/02', 'S', 'M', 'C. Virgino Lema, 382', '72308952', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Rita', 'Ruiz', 'Rodas', 1, '2000/02/09', 'S', 'F', 'C. Flores, 843', '62372322', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Rosaura', 'Sanchez', 'Vilte', 1, '2000/11/30', 'S', 'F', 'C. Arduz, 893', '62397894', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pascual', 'Terán', 'Tejerina', 1, '2000/12/29', 'S', 'M', 'C. Pinaya, 878', '72302090', 'E',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Saul', 'Pérez', '', 1, '2000/03/27', 'S', 'M', 'B. Lourdes', '74893897', 'E',NULL);



create table usuarios (
    codp bigint references personal(codp) on update cascade on delete cascade,
    login varchar(10) not null ,
    estado int not null default 1,
    password varchar(200) not null,
    primary key(codp),
    unique(login)
);
comment on column usuarios.login IS 'Login o nombre del usuario';
comment on column usuarios.estado IS 'Estado 1=activo, 0=nulo';
comment on column usuarios.password IS 'Clave o password';
comment on column usuarios.codp IS 'REF::PERSONAL';

insert into usuarios values(  1, 'maria', 1, 'asdf');
insert into usuarios values(  2, 'renan', 1, 'asdf');
insert into usuarios values(  3, 'jose', 1, 'asdf');
insert into usuarios values(  4, 'martha', 1, 'asdf');
insert into usuarios values(  5, 'ana', 1, 'asdf');
insert into usuarios values(  6, 'pedro', 1, 'asdf');
insert into usuarios values(  7, 'magdalena', 1, 'asdf');
insert into usuarios values(  8, 'jhonny', 1, 'asdf');
insert into usuarios values(  9, 'remberto', 1, 'asdf');
insert into usuarios values( 10, 'rpedro', 1, 'asdf');
insert into usuarios values( 11, 'luis', 1, 'asdf');
insert into usuarios values( 12, 'juana', 1, 'asdf');
insert into usuarios values( 13, 'mirtha', 1, 'asdf');
insert into usuarios values( 14, 'marisel', 1, 'asdf');
insert into usuarios values( 15, 'antonio', 1, 'asdf');


create table datos (
    codp bigint references personal(codp) on update cascade on delete cascade,
    cedula varchar(10),
    primary key(codp,cedula)
);
comment on column datos.codp IS 'REF.:ROLES';
comment on column datos.cedula IS '  
REF.:USUARIOS
REF.:USUARIOS';

create sequence menus_codm_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table menus (
    codm bigint primary key default nextval('menus_codm_seq'::regclass),
    nombre varchar(40) not null,
    estado int not null default 1
);
alter sequence menus_codm_seq OWNED BY menus.codm;
comment on column menus.codm IS 'Código Menu';
comment on column menus.nombre IS 'Nombre del menú';
comment on column menus.estado IS 'Estado 1=activo, 0=nulo';

insert into menus(nombre) values( 'gestion de usuario' );
insert into menus(nombre) values( 'gestion de estudiantes' );
insert into menus(nombre) values( 'gestion de materias' );
insert into menus(nombre) values( 'gestión de paralelos' );
insert into menus(nombre) values( 'gestión de menus' );
insert into menus(nombre) values( 'gestión de roles' );
insert into menus(nombre) values( 'gestión de items' );
insert into menus(nombre) values( 'gestión de modalidades' );
insert into menus(nombre) values( 'gestión de profesores' );

create sequence procesos_codp_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table procesos (
    codp bigint primary key default nextval('procesos_codp_seq'::regclass),
    nombre varchar(40) not null,
    enlace varchar(40) not null,
    ayuda varchar(50),
    estado int not null default 1
);
alter sequence procesos_codp_seq OWNED BY procesos.codp;
comment on column procesos.codp IS 'Código de Proceso';
comment on column procesos.nombre IS 'Nombre del proceso';
comment on column procesos.enlace IS 'Enlace o Link';
comment on column procesos.ayuda IS 'Texto ayuda de la opción';
comment on column procesos.estado IS 'Estado 1=activo, 0=nulo';

insert into procesos(nombre,enlace,ayuda) values( 'agregar usuario', 'link', 'añadir datos de un usuario' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar usuario', 'link', 'modificar datos de un usuario' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar usuario', 'link', 'eliminar datos de un usuario' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar estudiante', 'link', 'añadir datos de un estudiante' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar estudiante', 'link', 'modificar datos de un estudiantes' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar estudiante', 'link', 'eliminar datos de un estudiante' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar materia', 'link', 'añadir datos de una materia' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar materia', 'link', 'modificar datos de una materia' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar materia', 'link', 'eliminar datos de una materia' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar paralelo', 'link', 'añadir datos de un paralelo' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar paralelo', 'link', 'modificar datos de un paralelo' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar paralelo', 'link', 'eliminar datos de un paralelo' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar menu', 'link', 'añadir datos de un menu' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar menu', 'link', 'modificar datos de un menú' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar menu', 'link', 'eliminar datos de un menú' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar rol', 'link', 'añadir datos de un rol' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar rol', 'link', 'modificar datos de un rol' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar rol', 'link', 'eliminar datos de un rol' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar item', 'link', 'añadir datos de un ítem' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar item', 'link', 'modificar datos de un ítem' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar item', 'link', 'eliminar datos de un ítem' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar modalidad', 'link', 'añadir datos de un modalidad' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar modalidad', 'link', 'modificar datos de un modalidad' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar modalidad', 'link', 'eliminar datos de un modalidad' );

create table mepro (
    codm bigint references menus(codm),
    codp bigint references procesos(codp),
    primary key(codm,codp)  
);
comment on column mepro.codm IS 'REF.:MENUS';
comment on column mepro.codp IS 'REF.:PROCESOS';
insert into mepro values(1, 1);
insert into mepro values(1, 2);
insert into mepro values(1, 3);
insert into mepro values(2, 4);
insert into mepro values(2, 5);
insert into mepro values(2, 6);
insert into mepro values(3, 7);
insert into mepro values(3, 8);
insert into mepro values(3, 9);
insert into mepro values(4, 10);
insert into mepro values(4, 11);
insert into mepro values(4, 12);
insert into mepro values(5, 13);
insert into mepro values(5, 14);
insert into mepro values(5, 15);
insert into mepro values(6, 16);
insert into mepro values(6, 17);
insert into mepro values(6, 18);
insert into mepro values(7, 19);
insert into mepro values(7, 20);
insert into mepro values(7, 21);
insert into mepro values(8, 22);
insert into mepro values(8, 23);
insert into mepro values(8, 24);




create sequence roles_codr_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table roles (
    codr bigint primary key default nextval('roles_codr_seq'::regclass),
    nombre varchar(40) not null,
    estado int not null default 1
);
comment on column roles.codr IS 'Código Rol';
comment on column roles.nombre IS 'Nombre del rol';
comment on column roles.estado IS 'Estado 1=activo, 0=nulo';
alter sequence roles_codr_seq OWNED BY roles.codr;

insert into roles(nombre) values( 'Administrador' );
insert into roles(nombre) values( 'Director' );
insert into roles(nombre) values( 'Secretario' );
insert into roles(nombre) values( 'Profesor' );
insert into roles(nombre) values( 'Auxiliar' );

create table rolme (
    codr bigint references roles(codr),
    codm bigint references menus(codm),
    primary key(codr,codm)
);
comment on column rolme.codr IS 'REF.:ROLES';
comment on column rolme.codm IS 'REF.:MENUS';
insert into rolme values(1, 1);
insert into rolme values(1, 2);
insert into rolme values(1, 3);
insert into rolme values(1, 4);
insert into rolme values(1, 5);
insert into rolme values(1, 6);
insert into rolme values(1, 7);
insert into rolme values(1, 8);
insert into rolme values(2, 1);
insert into rolme values(2, 3);
insert into rolme values(2, 4);
insert into rolme values(2, 5);
insert into rolme values(2, 6);
insert into rolme values(2, 7);
insert into rolme values(2, 8);
insert into rolme values(2, 9);
insert into rolme values(3, 1);
insert into rolme values(3, 2);
insert into rolme values(3, 3);
insert into rolme values(3, 4);
insert into rolme values(3, 9);
insert into rolme values(4, 2);
insert into rolme values(5, 3);
insert into rolme values(5, 4);


create table usurol (
    codp bigint references usuarios(codp),
    codr bigint references roles(codr),
    primary key(codp,codr) 
);
comment on column usurol.codp IS 'REF.:USUARIOS';
comment on column usurol.codr IS 'REF.:ROLES';

insert into usurol values( 1, 1 );
insert into usurol values( 2, 2 );
insert into usurol values( 3, 3 );
insert into usurol values( 4, 5 );
insert into usurol values( 5, 4 );
insert into usurol values( 6, 4 );
insert into usurol values( 7, 4 );
insert into usurol values( 8, 4 );
insert into usurol values( 9, 4 );
insert into usurol values( 10, 4 );
insert into usurol values( 11, 4 );
insert into usurol values( 12, 4 );
insert into usurol values( 13, 4 );
insert into usurol values( 14, 2 );
insert into usurol values( 15, 5 );



-- 3 de noviembre
create sequence items_codi_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table items (
    codi bigint primary key default nextval('items_codi_seq'::regclass),
    nombre varchar(40) not null,
    estado int not null default 1 
);
comment on column items.codi IS 'Código del Item';
comment on column items.nombre IS 'Nombre del Item';
comment on column items.estado IS 'Estado 1=activo, 0=nulo';
alter sequence items_codi_seq OWNED BY items.codi;

insert into items values(1, 'Ser', 1 );
insert into items values(2, 'Saber', 1 );
insert into items values(3, 'Hacer', 1 );
insert into items values(4, 'Decidir', 1 );
insert into items values(5, 'Ser', 1 );
insert into items values(6, 'Saber', 1 );
insert into items values(7, 'Hacer', 1 );
insert into items values(8, 'Decidir', 1 );

create sequence materias_codm_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table materias (
    codm bigint primary key default nextval('materias_codm_seq'::regclass),
    codigo varchar(15) not null,
    nombre varchar(30) not null,
    estado int default 1 not null
);
comment on column materias.nombre IS 'Nombre de la materia';
comment on column materias.estado IS 'Estado 1=activo, 0=nulo';
comment on column materias.codigo IS 'Código de la materia';
alter sequence materias_codm_seq OWNED BY materias.codm;

insert into materias(codigo, estado, nombre) values( 'M1' ,'Ciencias Naturales 1ro', 1 );
insert into materias(codigo, estado, nombre) values( 'M2' ,'Ciencias Naturales 2do', 1 );
insert into materias(codigo, estado, nombre) values( 'M3' ,'Ciencias Naturales 3ro', 1 );
insert into materias(codigo, estado, nombre) values( 'M4' ,'Ciencias Naturales 4to', 1 );
insert into materias(codigo, estado, nombre) values( 'M5' ,'Ciencias Naturales 5to', 1 );
insert into materias(codigo, estado, nombre) values( 'M6' ,'Ciencias Naturales 6to', 1 );
insert into materias(codigo, estado, nombre) values( 'M7' ,'Biología 1ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M8' ,'Biología 2do', 2 );
insert into materias(codigo, estado, nombre) values( 'M9' ,'Biología 3ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M10' ,'Biología 4to', 2 );
insert into materias(codigo, estado, nombre) values( 'M11' ,'Biología 5to', 2 );
insert into materias(codigo, estado, nombre) values( 'M12' ,'Biología 6to', 2 );
insert into materias(codigo, estado, nombre) values( 'M13' ,'Geografía 1ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M14' ,'Geografía 2do', 2 );
insert into materias(codigo, estado, nombre) values( 'M15' ,'Geografía 3ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M16' ,'Geografía 4to', 2 );
insert into materias(codigo, estado, nombre) values( 'M17' ,'Geografía 5to', 2 );
insert into materias(codigo, estado, nombre) values( 'M18' ,'Geografía 6to', 2 );
insert into materias(codigo, estado, nombre) values( 'M19' ,'Física 3ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M20' ,'Física 4to', 2 );
insert into materias(codigo, estado, nombre) values( 'M21' ,'Física 5to', 2 );
insert into materias(codigo, estado, nombre) values( 'M22' ,'Física 6to', 2 );
insert into materias(codigo, estado, nombre) values( 'M23' ,'Química 3ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M24' ,'Química 4to', 2 );
insert into materias(codigo, estado, nombre) values( 'M25' ,'Química 5to', 2 );
insert into materias(codigo, estado, nombre) values( 'M26' ,'Química 6to', 2 );
insert into materias(codigo, estado, nombre) values( 'M27' ,'Química 6to', 2 );
insert into materias(codigo, estado, nombre) values( 'M28' ,'Matemática 1ro', 1 );
insert into materias(codigo, estado, nombre) values( 'M29' ,'Matemática 2do', 1 );
insert into materias(codigo, estado, nombre) values( 'M30' ,'Matemática 3ro', 1 );
insert into materias(codigo, estado, nombre) values( 'M31' ,'Matemática 4to', 1 );
insert into materias(codigo, estado, nombre) values( 'M32' ,'Matemática 5to', 1 );
insert into materias(codigo, estado, nombre) values( 'M33' ,'Matemática 6to', 1 );
insert into materias(codigo, estado, nombre) values( 'M34' ,'Matemática 1ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M35' ,'Matemática 2do', 2 );
insert into materias(codigo, estado, nombre) values( 'M36' ,'Matemática 3ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M37' ,'Matemática 4to', 2 );
insert into materias(codigo, estado, nombre) values( 'M38' ,'Matemática 5to', 2 );
insert into materias(codigo, estado, nombre) values( 'M39' ,'Matemática 6to', 2 );
insert into materias(codigo, estado, nombre) values( 'M40' ,'Ciencias Sociales 1ro', 1 );
insert into materias(codigo, estado, nombre) values( 'M41' ,'Ciencias Sociales 2do', 1 );
insert into materias(codigo, estado, nombre) values( 'M42' ,'Ciencias Sociales 3ro', 1 );
insert into materias(codigo, estado, nombre) values( 'M43' ,'Ciencias Sociales 4to', 1 );
insert into materias(codigo, estado, nombre) values( 'M44' ,'Ciencias Sociales 5to', 1 );
insert into materias(codigo, estado, nombre) values( 'M45' ,'Ciencias Sociales 6to', 1 );
insert into materias(codigo, estado, nombre) values( 'M46' ,'Ciencias Sociales 1ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M47' ,'Ciencias Sociales 2do', 2 );
insert into materias(codigo, estado, nombre) values( 'M48' ,'Ciencias Sociales 3ro', 2 );
insert into materias(codigo, estado, nombre) values( 'M49' ,'Ciencias Sociales 4to', 2 );
insert into materias(codigo, estado, nombre) values( 'M50' ,'Ciencias Sociales 5to', 2 );
insert into materias(codigo, estado, nombre) values( 'M51' ,'Ciencias Sociales 6to', 2 );

create table itemat (
    codm bigint references materias(codm),
    codi bigint references items(codi),
    estado int not null default 1,
    gestion bigint ,
    ponderacion int not null,
    primary key(codm,codi,gestion) 
);
comment on column itemat.codi IS 'REF.:ITEMS';
comment on column itemat.estado IS 'Estado 1=activo, 0=nulo';
comment on column itemat.gestion IS 'Gestión definido';
comment on column itemat.codm IS 'REF.:MATERIAS';
comment on column itemat.ponderacion IS 'Ponderación Item (100%)';

insert into itemat values(6, 1, 1, 2017, 51);
insert into itemat values(6, 2, 1, 2017, 51);
insert into itemat values(6, 3, 1, 2017, 51);
insert into itemat values(6, 4, 1, 2017, 51);
insert into itemat values(33, 5, 1, 2017, 51);
insert into itemat values(33, 6, 1, 2017, 51);
insert into itemat values(33, 7, 1, 2017, 51);
insert into itemat values(33, 8, 1, 2017, 51);
insert into itemat values(34, 5, 1, 2017, 51);
insert into itemat values(34, 6, 1, 2017, 51);
insert into itemat values(34, 7, 1, 2017, 51);
insert into itemat values(34, 8, 1, 2017, 51);
insert into itemat values(38, 5, 1, 2017, 51);
insert into itemat values(38, 6, 1, 2017, 51);
insert into itemat values(38, 7, 1, 2017, 51);
insert into itemat values(38, 8, 1, 2017, 51);
insert into itemat values(45, 1, 1, 2017, 51);
insert into itemat values(45, 2, 1, 2017, 51);
insert into itemat values(45, 3, 1, 2017, 51);
insert into itemat values(45, 4, 1, 2017, 51);
insert into itemat values(46, 1, 1, 2017, 51);
insert into itemat values(46, 2, 1, 2017, 51);
insert into itemat values(46, 3, 1, 2017, 51);
insert into itemat values(46, 4, 1, 2017, 51);
insert into itemat values(50, 1, 1, 2017, 51);
insert into itemat values(50, 2, 1, 2017, 51);
insert into itemat values(50, 3, 1, 2017, 51);
insert into itemat values(50, 4, 1, 2017, 51);
insert into itemat values(7, 5, 1, 2017, 51);
insert into itemat values(7, 6, 1, 2017, 51);
insert into itemat values(7, 7, 1, 2017, 51);
insert into itemat values(7, 8, 1, 2017, 51);
insert into itemat values(11, 5, 1, 2017, 51);
insert into itemat values(11, 6, 1, 2017, 51);
insert into itemat values(11, 7, 1, 2017, 51);
insert into itemat values(11, 8, 1, 2017, 51);
insert into itemat values(13, 1, 1, 2017, 51);
insert into itemat values(13, 2, 1, 2017, 51);
insert into itemat values(13, 3, 1, 2017, 51);
insert into itemat values(13, 4, 1, 2017, 51);
insert into itemat values(17, 1, 1, 2017, 51);
insert into itemat values(17, 2, 1, 2017, 51);
insert into itemat values(17, 3, 1, 2017, 51);
insert into itemat values(17, 4, 1, 2017, 51);
insert into itemat values(21, 5, 1, 2017, 51);
insert into itemat values(21, 6, 1, 2017, 51);
insert into itemat values(21, 7, 1, 2017, 51);
insert into itemat values(21, 8, 1, 2017, 51);
insert into itemat values(25, 5, 1, 2017, 51);
insert into itemat values(25, 6, 1, 2017, 51);
insert into itemat values(25, 7, 1, 2017, 51);
insert into itemat values(25, 8, 1, 2017, 51);

create sequence paralelos_codp_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table paralelos (
    codp bigint primary key default nextval('paralelos_codp_seq'::regclass),
    nombre varchar(30) not null,
    estado int not null
);
comment on column paralelos.codp IS 'Código paralelo';
comment on column paralelos.nombre IS 'Nombre del paralelo';
comment on column paralelos.estado IS 'Estado 1=activo, 0=nulo';
alter sequence paralelos_codp_seq OWNED BY paralelos.codp;

insert into paralelos values(1, 'Paralelo 1', 1);
insert into paralelos values(2, 'Paralelo 2', 1);
insert into paralelos values(3, 'Paralelo 3', 1);
insert into paralelos values(4, 'Paralelo 4', 1);
insert into paralelos values(5, 'Paralelo 5', 0);

create sequence modalidad_codm_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table modalidad(
    codm bigint primary key default nextval('modalidad_codm_seq'::regclass),
    nombre varchar(40),
    estado int not null default 1
);
alter sequence modalidad_codm_seq OWNED BY modalidad.codm;

create table dmodalidad(
    coddm bigint primary key,
    nombre varchar(40) not null,
    estado int not null,
    codm bigint not null references modalidad(codm)
);

create table mapa(
    codmat bigint references materias(codm),
    codp bigint not null references paralelos(codp),
    estado int not null,
    gestion bigint not null,
    primary key(codp,codmat,gestion)
);

create sequence general_codg_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
create table general(
    codg bigint primary key default nextval('general_codg_seq'::regclass),
    gestion int not null,
    codp bigint not null references usuarios(codp)
);




