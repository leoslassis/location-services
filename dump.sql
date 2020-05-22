USE challenge;

CREATE TABLE location (
    id int,
    street  varchar(255),
    district varchar(255),
    city varchar(255),
    state varchar(255),
    postalCode varchar(9),
    PRIMARY KEY (id)
);


INSERT INTO location (id, street, district, city, state, postalCode)
VALUES (1, 'Rua A', 'Bairro A', 'Cidade A', 'Estado A', '08290740');

INSERT INTO location (id, street, district, city, state, postalCode)
VALUES (2, 'Rua B', 'Bairro B', 'Cidade B', 'Estado B', '08290100');

INSERT INTO location (id, street, district, city, state, postalCode)
VALUES (3, 'Rua C', 'Bairro C', 'Cidade C', 'Estado C', '08270010');

INSERT INTO location (id, street, district, city, state, postalCode)
VALUES (4, 'Rua D', 'Bairro D', 'Cidade D', 'Estado D', '08295789');

INSERT INTO location (id, street, district, city, state, postalCode)
VALUES (5, 'Rua E', 'Bairro E', 'Cidade E', 'Estado E', '08295123');

COMMIT;
