 
CREATE TABLE datos (
    codp bigint NOT NULL,
    cedula character varying(10) NOT NULL
);
COMMENT ON COLUMN datos.codp IS 'REF.:ROLES';
COMMENT ON COLUMN datos.cedula IS '  
REF.:USUARIOS
REF.:USUARIOS';

CREATE SEQUENCE menus_codm_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE menus (
    codm bigint NOT NULL DEFAULT nextval('menus_codm_seq'::regclass),
    nombre character varying(40) NOT NULL,
    estado integer NOT NULL DEFAULT 1
);
ALTER SEQUENCE menus_codm_seq OWNED BY menus.codm;
COMMENT ON COLUMN menus.codm IS 'Código Menu';
COMMENT ON COLUMN menus.nombre IS 'Nombre del menú';
COMMENT ON COLUMN menus.estado IS 'Estado 1=activo, 0=nulo';

insert into menus(nombre) values( 'gestion de usuario' );
insert into menus(nombre) values( 'gestion de estudiantes' );
insert into menus(nombre) values( 'gestion de materias' );
insert into menus(nombre) values( 'gestión de paralelos' );
insert into menus(nombre) values( 'gestión de menus' );
insert into menus(nombre) values( 'gestión de roles' );
insert into menus(nombre) values( 'gestión de items' );
insert into menus(nombre) values( 'gestión de modalidades' );
insert into menus(nombre) values( 'gestión de profesores' );



CREATE TABLE mepro (
    codm bigint NOT NULL,
    codp bigint NOT NULL
);
COMMENT ON COLUMN mepro.codm IS 'REF.:MENUS';
COMMENT ON COLUMN mepro.codp IS 'REF.:PROCESOS';
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


CREATE SEQUENCE personal_codp_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE personal (
    codp bigint NOT NULL DEFAULT nextval('personal_codp_seq'::regclass),
    nombre character varying(40) NOT NULL,
    ap character varying(40),
    am character varying(40),
    estado integer NOT NULL,
    fnac date NOT NULL,
    ecivil character varying(1) NOT NULL,
    genero character varying(1) NOT NULL,
    direc character varying(50),
    telf character varying(20),
    tipo character varying(1) NOT NULL,
    foto character varying(30)
);
ALTER SEQUENCE personal_codp_seq OWNED BY personal.codp;
COMMENT ON COLUMN personal.nombre IS 'Nombre del a Persona';
COMMENT ON COLUMN personal.ap IS 'Apellido Paterno';
COMMENT ON COLUMN personal.am IS 'Apellido Materno';
COMMENT ON COLUMN personal.estado IS 'Estado 1=activo, 0=nulo';
COMMENT ON COLUMN personal.fnac IS 'Fecha de nacimiento';
COMMENT ON COLUMN personal.ecivil IS 'Estado civil';
COMMENT ON COLUMN personal.genero IS 'Género Masculino o Femenino';
COMMENT ON COLUMN personal.direc IS 'Dirección';
COMMENT ON COLUMN personal.telf IS 'Teléfono';
COMMENT ON COLUMN personal.codp IS 'codigo persona';
COMMENT ON COLUMN personal.tipo IS 'E=Estudiante, P=profesor';
COMMENT ON COLUMN personal.foto IS 'foto personal';


insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María', 'Paniagua', 'Mendez', 1, '1978/10/25', 'C', 'F', 'Calle Santa Cruz, Nro 234', '74828831', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Renán', 'Alfaro', 'Quiroga', 1, '1965/03/12', 'C', 'M', 'C. Gral Trigo, 832', '63438831', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'José Antonio', 'Camcho', 'Ortiz', 1, '1978/05/08', 'S', 'M', 'Colon, 138', '22762442', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Martha', 'Ribadeneira', 'Soliz', 1, '1958/11/21', 'V', 'F', 'Av. La Paz 234', '87482864', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ana', 'Paz', '', 1, '1977/12/02', 'C', 'F', 'La Madrid N 234', '74828831', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pedro Juan', 'Saldías', 'Monje', 1, '1968/03/11', 'S', 'M', 'B. Las Panosas, s/n', '75625212', 'U',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María Magdalena', '', 'Pino', 1, '1963/07/02', 'S', 'F', 'C. Cochabamba 2344', '73092938', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Jhonny', 'Mendez', 'Albino', 1, '1975/06/15', 'S', 'M', 'C. Bolivar 323', '79397724', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Remberto', 'Calizaya', 'Tamayo', 0, '1983/08/12', 'S', 'M', 'C. Litoral, 2344', '70839471', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pedro', 'Ramirez', 'Nieto', 1, '1977/05/29', 'S', 'M', 'Av. Victor Paz 2345', '70482617', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Luis Miguel', 'Benito', 'Arias', 1, '1990/03/31', 'S', 'M', 'C. Santa Cruz, 1344', '72840032', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juana', 'de las Fuentes', 'Jaimes', 1, '1995/10/14', 'S', 'F', 'Av. H. Arce, Nro 234', '70699482', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Mirtha', 'Molina', 'Prima', 1, '1983/09/09', 'S', 'F', 'C. Salta, 234', '62940283', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Marisel', 'Miramar', 'Sartre', 1, '1979/08/04', 'S', 'F', 'C. Oruro, 9023', '69492785', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Antonio', 'del Valle', 'Toluca', 1, '1984/03/21', 'S', 'M', 'C. Miraflores, 234', '62890384', 'U',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values(  'Carlos Cristian', 'Romero', 'Perez', 0, '2000/08/24', 'S', 'M', 'B. Guadalquivir, C Sanjinez', '71239402', 'U',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Fernanda', 'Sotomayor', '', 1, '2005/11/19', 'S', 'F', 'Las Panosas', '24995828', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ana María', '', 'Palluca', 0, '2005/10/30', 'S', 'F', 'Av. Mejillones, 949', '63829167', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Karina', 'Tejerina', 'Tapia', 1, '2005/06/09', 'S', 'F', 'C. Colón, 393', '62939542', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Peter', 'Tejerina', 'Tapia', 1, '2005/08/30', 'S', 'M', 'San Andrés, s/n', '72039599', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Saida', 'Urquieta', 'Tapia', 1, '2005/11/12', 'S', 'F', 'C. España, 645', '28390772', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Segundina', 'Lazo', 'Pelaez', 1, '2006/04/15', 'S', 'F', 'C. Montero, 444', '27275173', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Mario', 'Berbeja', 'Marquez', 1, '2006/02/22', 'S', 'M', 'C. Tejerina, 943', '74892055', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Benjamín', 'Rios', 'Laguna', 1, '2006/05/13', 'S', 'M', 'C. Arduz, S/N', '72792304', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Andrés', 'Ballesteros', 'Rueda', 1, '2005/06/30', 'S', 'M', 'B. Florida', '62122782', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Selena', 'Arteaga', 'Posadas', 0, '2006/02/04', 'S', 'F', '', '62900523', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María de los Angeles', 'Velazquez', 'Terrazas', 1, '2006/07/13', 'S', 'F', 'C. Luis Vargas, 854', '72342223', 'A',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Mirna Moira', '', 'Valenzuela', 1, '2004/11/16', 'S', 'F', 'C. Méndez, 0034', '702394234', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juan José', 'Andrade', 'Siqueira', 1, '2004/10/14', 'S', 'M', 'C. Suipacha, 234', '768929334', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Saturnina', 'Pinaya', '', 1, '2004/08/02', 'S', 'F', 'C. Bermejo, 043', '799303482', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juán','Panique','Mendoza', 1, '2005/05/16', 'S', 'M', 'C. Villamontes, 048', '792299032', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Filomena Segunda','Rios','Mendieta', 1, '2005/01/05', 'S', 'F', 'Av. Santa Cruz, 634', '62893938', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Antonia','Suarez','Calizaya', 1, '2004/08/03', 'S', 'F', 'C. Litoral, 234', '72833893', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pedro','Calizaya','Medina', 1, '2003/07/14', 'S', 'M', 'C. Arce, 003', '720344832', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Renán','Fuertes','Peralta', 1, '2004/09/25', 'S', 'M', 'C. Molino, 034', '623952334', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Facunda Soraya','Nieves','Paz', 1, '2004/09/27', 'S', 'F', 'C. Villavista, 233', '69289342', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Juán','Peralta','Méndez', 1, '2004/10/14', 'S', 'M', 'B. Andaluz', '62300403', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Aida','Salinas','Salinas', 1, '2005/04/17', 'S', 'F', 'C. Cochabamba, 23 ', '69898323', 'A',NULL);

insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ivanka','Pelaez','Soliz', 0, '2001/02/03', 'S', 'F', 'C. Ingavi, 456', '61293523', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Ivonne Ana','Cabero','Miranda', 1, '2001/04/12', 'S', 'F', 'C. Daniel Campos, 922', '74923878', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Arturo','Fuertes','Peralta', 1, '2000/09/20', 'S', 'M', 'C. Campero, 93', '62983789', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Filomena Soledad','Flor de Caliz','Quiroga', 1, '2000/10/1', 'S', 'F', 'C. Ballivián, 541', '72302752', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Antonio','Quisbert','Manta', 1, '2000/11/29', 'S', 'M', 'C. Avila, 933', '72390422', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'María','Velasquez','Tonka', 1, '2000/08/23', 'S', 'F', 'C. América, 344', '623498234', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Johanna','Piza','Miranda', 1, '2001/04/29', 'S', 'F', 'C. Ingavi, 238', '608903892', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Vito','Soliz','Soliz', 1, '2000/08/02', 'S', 'M', 'C. Virgino Lema, 382', '72308952', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Rita', 'Ruiz', 'Rodas', 1, '2000/02/09', 'S', 'F', 'C. Flores, 843', '62372322', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Rosaura', 'Sanchez', 'Vilte', 1, '2000/11/30', 'S', 'F', 'C. Arduz, 893', '62397894', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Pascual', 'Terán', 'Tejerina', 1, '2000/12/29', 'S', 'M', 'C. Pinaya, 878', '72302090', 'A',NULL);
insert into personal(nombre,ap,am,estado,fnac,ecivil,genero,direc,telf,tipo,foto) values( 'Saul', 'Pérez', '', 1, '2000/03/27', 'S', 'M', 'B. Lourdes', '74893897', 'A',NULL);



CREATE SEQUENCE procesos_codp_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE procesos (
    codp bigint NOT NULL DEFAULT nextval('procesos_codp_seq'::regclass),
    nombre character varying(40) NOT NULL,
    enlace character varying(40) NOT NULL,
    ayuda character varying(50),
    estado integer NOT NULL DEFAULT 1
);
ALTER SEQUENCE procesos_codp_seq OWNED BY procesos.codp;
COMMENT ON COLUMN procesos.codp IS 'Código de Proceso';
COMMENT ON COLUMN procesos.nombre IS 'Nombre del proceso';
COMMENT ON COLUMN procesos.enlace IS 'Enlace o Link';
COMMENT ON COLUMN procesos.ayuda IS 'Texto ayuda de la opción';
COMMENT ON COLUMN procesos.estado IS 'Estado 1=activo, 0=nulo';

insert into procesos(nombre,enlace,ayuda) values( 'agregar usuario', '', 'añadir datos de un usuario' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar usuario', '', 'modificar datos de un usuario' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar usuario', '', 'eliminar datos de un usuario' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar estudiante', '', 'añadir datos de un estudiante' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar estudiante', '', 'modificar datos de un estudiantes' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar estudiante', '', 'eliminar datos de un estudiante' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar materia', '', 'añadir datos de una materia' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar materia', '', 'modificar datos de una materia' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar materia', '', 'eliminar datos de una materia' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar paralelo', '', 'añadir datos de un paralelo' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar paralelo', '', 'modificar datos de un paralelo' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar paralelo', '', 'eliminar datos de un paralelo' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar menu', '', 'añadir datos de un menu' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar menu', '', 'modificar datos de un menú' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar menu', '', 'eliminar datos de un menú' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar rol', '', 'añadir datos de un rol' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar rol', '', 'modificar datos de un rol' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar rol', '', 'eliminar datos de un rol' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar item', '', 'añadir datos de un ítem' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar item', '', 'modificar datos de un ítem' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar item', '', 'eliminar datos de un ítem' );
insert into procesos(nombre,enlace,ayuda) values( 'agregar modalidad', '', 'añadir datos de un modalidad' );
insert into procesos(nombre,enlace,ayuda) values( 'modificar modalidad', '', 'modificar datos de un modalidad' );
insert into procesos(nombre,enlace,ayuda) values( 'borrar modalidad', '', 'eliminar datos de un modalidad' );




CREATE SEQUENCE roles_codr_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE roles (
    codr bigint NOT NULL DEFAULT nextval('roles_codr_seq'::regclass),
    nombre character varying(40) NOT NULL,
    estado integer NOT NULL DEFAULT 1
);
COMMENT ON COLUMN roles.codr IS 'Código Rol';
COMMENT ON COLUMN roles.nombre IS 'Nombre del rol';
COMMENT ON COLUMN roles.estado IS 'Estado 1=activo, 0=nulo';
ALTER SEQUENCE roles_codr_seq OWNED BY roles.codr;

insert into roles(nombre) values( 'Administrador' );
insert into roles(nombre) values( 'Director' );
insert into roles(nombre) values( 'Secretario' );
insert into roles(nombre) values( 'Profesor' );
insert into roles(nombre) values( 'Auxiliar' );





CREATE TABLE rolme (
    codr bigint NOT NULL,
    codm bigint NOT NULL
);
COMMENT ON COLUMN rolme.codr IS 'REF.:ROLES';
COMMENT ON COLUMN rolme.codm IS 'REF.:MENUS';
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


CREATE TABLE usuarios (
    codp bigint NOT NULL,
    login character varying(10) NOT NULL,
    estado integer NOT NULL DEFAULT 1,
    password character varying(200) NOT NULL
);
COMMENT ON COLUMN usuarios.login IS 'Login o nombre del usuario';
COMMENT ON COLUMN usuarios.estado IS 'Estado 1=activo, 0=nulo';
COMMENT ON COLUMN usuarios.password IS 'Clave o password';
COMMENT ON COLUMN usuarios.codp IS 'REF::PERSONAL';

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



CREATE TABLE usurol (
    codp bigint NOT NULL,
    codr bigint NOT NULL
);
COMMENT ON COLUMN usurol.codp IS 'REF.:USUARIOS';
COMMENT ON COLUMN usurol.codr IS 'REF.:ROLES';

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




ALTER TABLE ONLY datos ADD CONSTRAINT datos_pkey PRIMARY KEY (codp, cedula);
ALTER TABLE ONLY menus ADD CONSTRAINT menus_pkey PRIMARY KEY (codm);
ALTER TABLE ONLY mepro ADD CONSTRAINT mepro_pkey PRIMARY KEY (codm, codp);
ALTER TABLE ONLY personal ADD CONSTRAINT personal_pkey PRIMARY KEY (codp);
ALTER TABLE ONLY procesos ADD CONSTRAINT procesos_pkey PRIMARY KEY (codp);
ALTER TABLE ONLY roles ADD CONSTRAINT roles_pkey PRIMARY KEY (codr);
ALTER TABLE ONLY rolme ADD CONSTRAINT rolme_pkey PRIMARY KEY (codr, codm);
ALTER TABLE ONLY usuarios ADD CONSTRAINT unique_login_usuarios UNIQUE (login);
ALTER TABLE ONLY datos ADD CONSTRAINT unique_datos_codp UNIQUE (codp);
ALTER TABLE ONLY usuarios ADD CONSTRAINT usuarios_pkey PRIMARY KEY (codp);
ALTER TABLE ONLY usurol ADD CONSTRAINT usurol_pkey PRIMARY KEY (codp,codr);
ALTER TABLE ONLY datos ADD CONSTRAINT fk_datos_personal_1 FOREIGN KEY (codp) REFERENCES personal(codp) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY mepro ADD CONSTRAINT fk_mepro_menus_1 FOREIGN KEY (codm) REFERENCES menus(codm);
ALTER TABLE ONLY mepro ADD CONSTRAINT fk_mepro_procesos_1 FOREIGN KEY (codp) REFERENCES procesos(codp);
ALTER TABLE ONLY rolme ADD CONSTRAINT fk_rolme_menus_1 FOREIGN KEY (codm) REFERENCES menus(codm);
ALTER TABLE ONLY rolme ADD CONSTRAINT fk_rolme_roles_1 FOREIGN KEY (codr) REFERENCES roles(codr);
ALTER TABLE ONLY usuarios ADD CONSTRAINT fk_usuarios_personal_1 FOREIGN KEY (codp) REFERENCES personal(codp) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY usurol ADD CONSTRAINT fk_usurol_roles_1 FOREIGN KEY (codr) REFERENCES roles(codr);
ALTER TABLE ONLY usurol ADD CONSTRAINT fk_usurol_usuarios_1 FOREIGN KEY (codp) REFERENCES usuarios(codp);
