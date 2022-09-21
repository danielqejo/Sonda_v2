CREATE TABLE probes (
	"name" varchar NOT NULL PRIMARY KEY,
	plateau_name varchar NOT NULL,
	direction char(1) NOT NULL,
	position_x smallint NOT NULL,
	position_y smallint NOT NULL,
	CONSTRAINT probes_fk FOREIGN KEY (plateau_name) REFERENCES plateaus("name")
);
