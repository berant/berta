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

