CREATE TABLE Category (
    id INT NOT NULL AUTO_INCREMENT
  , name VARCHAR(200) NOT NULL
  , PRIMARY KEY (id)
  , CONSTRAINT UQ_NAME UNIQUE (name)
);

CREATE TABLE Product (
    id INT NOT NULL AUTO_INCREMENT
  , name VARCHAR(45) NOT NULL
  , description VARCHAR(100)
  , category_id INT NOT NULL
  , price_buy DOUBLE NOT NULL
  , PRIMARY KEY (id)
  , FOREIGN KEY (category_id) REFERENCES Category(id)
);

CREATE TABLE Client (
    id INT NOT NULL AUTO_INCREMENT
  , first_name VARCHAR(20) NOT NULL
  , last_name VARCHAR(20) NOT NULL
  , phone VARCHAR(10) NOT NULL
  , PRIMARY KEY (id)
);

CREATE TABLE Employee (
    id INT NOT NULL AUTO_INCREMENT
  , first_name VARCHAR(20) NOT NULL
  , last_name VARCHAR(20) NOT NULL
  , phone VARCHAR(10) NOT NULL
  , position VARCHAR(20) NOT NULL
  , rate INT NOT NULL
  , start_work DATE NOT NULL
  , end_work DATE
  , PRIMARY KEY (id)
);
