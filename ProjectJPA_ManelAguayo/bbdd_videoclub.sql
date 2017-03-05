CREATE TABLE actor
(
    id_actor integer NOT NULL,
    nombre varchar(30),
    nacionalidad varchar(30),
    CONSTRAINT pk_actor PRIMARY KEY (id_actor)

);


CREATE TABLE genero
(
    id_genero integer NOT NULL,
    descripcion varchar(30),
    CONSTRAINT pk_genero PRIMARY KEY (id_genero)
    
);


CREATE TABLE pelicula
(
    id_pelicula integer NOT NULL,
    titulo varchar(30),
    genero integer,
    CONSTRAINT pk_pelicula PRIMARY KEY (id_pelicula),
    CONSTRAINT fk_pel_genero FOREIGN KEY (genero) REFERENCES genero (id_genero)

);


CREATE TABLE actuacion
(
    actor integer NOT NULL,
    pelicula integer NOT NULL,
    personaje varchar(30) NOT NULL,
    CONSTRAINT pk_actuacion PRIMARY KEY (actor, pelicula, personaje),
    CONSTRAINT fk_act_actor FOREIGN KEY (actor) REFERENCES actor (id_actor),
    CONSTRAINT fk_act_pelicula FOREIGN KEY (pelicula) REFERENCES pelicula (id_pelicula)

);


CREATE TABLE cliente
(
    id_cliente varchar(30) NOT NULL,
    nombre varchar(30),
    CONSTRAINT pk_cliente PRIMARY KEY (id_cliente)

);

CREATE TABLE visualizacion
(
    cliente varchar(30) NOT NULL,
    pelicula integer NOT NULL,
    fecha date NOT NULL,
    CONSTRAINT pk_visualizacion PRIMARY KEY (cliente, pelicula, fecha),
    CONSTRAINT fk_vis_cliente FOREIGN KEY (cliente) REFERENCES cliente (id_cliente),
    CONSTRAINT fk_vis_pelicula FOREIGN KEY (pelicula) REFERENCES pelicula (id_pelicula)
    
);
