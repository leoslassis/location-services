CREATE TABLE IF NOT EXISTS location
(
	    id int,
        street  varchar(255),
        district varchar(255),
        city varchar(255),
        state varchar(255),
        postal_code varchar(9),
        PRIMARY KEY (id)
);