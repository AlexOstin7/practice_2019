CREATE TABLE IF NOT EXISTS organization (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(50) NOT NULL,
    full_name   VARCHAR(250) NOT NULL,
    inn         VARCHAR(12)  NOT NULL,
    kpp         VARCHAR(9)  NOT NULL,
    address     VARCHAR(250) NOT NULL,
    phone       VARCHAR(20),
    is_active   BOOLEAN,
    CONSTRAINT inn UNIQUE (inn)
);

CREATE TABLE IF NOT EXISTS office (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name       VARCHAR(50),
    address    VARCHAR(250),
    phone      VARCHAR(50),
    is_active   BOOLEAN,
    org_id      INTEGER,
CONSTRAINT Organization_FKEY FOREIGN KEY(org_id) REFERENCES PUBLIC.Organization (id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS doc (
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    code        INTEGER  NOT NULL,
    name        VARCHAR(250)  NOT NULL,
    CONSTRAINT PK_DOC_ID PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country (
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    code        INTEGER  NOT NULL,
    name        VARCHAR(50)  NOT NULL,
    CONSTRAINT PK_COUNTRY_ID PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country_doc (
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    country_id  INTEGER  NOT NULL,
    doc_id      INTEGER  NOT NULL,
    CONSTRAINT FK_COUNTRY_ID FOREIGN KEY (country_id)
    REFERENCES country (id),
    CONSTRAINT FK_DOC_ID FOREIGN KEY (doc_id)
    REFERENCES doc (id)
);

CREATE TABLE IF NOT EXISTS user (
  id               INTEGER  PRIMARY KEY AUTO_INCREMENT,
  version          INTEGER NOT NULL,
  first_name       VARCHAR(50) NOT NULL,
  middle_name      VARCHAR(50),
  second_name      VARCHAR(100),
  possition        VARCHAR(50) NOT NULL,
  doc_number       VARCHAR(20),
  doc_date         DATE,
  phone            VARCHAR(20),
  is_identified    BOOLEAN,
  office_id        INTEGER     NOT NULL,
  doc_id           INTEGER     NOT NULL,
  CONSTRAINT office_FKEY FOREIGN KEY(office_id) REFERENCES PUBLIC.office (id),
  CONSTRAINT doc_FKEY FOREIGN KEY(doc_id) REFERENCES PUBLIC.doc (id)
);
