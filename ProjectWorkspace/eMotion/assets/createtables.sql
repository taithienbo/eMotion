CREATE TABLE Pictures (
	id				INTEGER			PRIMARY KEY	AUTOINCREMENT,
	title			TEXT			NOT NULL,
	pic				BLOB			NOT NULL,
	favorited		INTEGER			NOT NULL
);

CREATE TABLE Jokes (
	id				INTEGER			PRIMARY KEY	AUTOINCREMENT,
	title			TEXT			NOT NULL,
	joke			TEXT			NOT NULL,
	favorited		INTEGER			NOT NULL	
);

CREATE TABLE Quotes (
	id				INTEGER			PRIMARY KEY	AUTOINCREMENT,
	author			TEXT			NOT NULL,
	quote			TEXT			NOT NULL,
	favorited		INTEGER			NOT NULL
);