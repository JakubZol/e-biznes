/* DROP TABLE "category";
DROP TABLE "product";
DROP TABLE "user";
DROP TABLE "ball";
DROP TABLE "sweatband";
DROP TABLE "shirt";
DROP TABLE "trousers";
DROP TABLE "shoes";
DROP TABLE "helmet";
DROP TABLE "gloves";*/


CREATE TABLE "category" (
                            "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                            "name" VARCHAR NOT NULL
);

CREATE TABLE "product" (
                           "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                           "name" VARCHAR NOT NULL,
                           "description" TEXT NOT NULL,
                           "category" INT NOT NULL,
                           FOREIGN KEY(category) references category(id)
);

CREATE TABLE "ball"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL
);

CREATE TABLE "shirt"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL,
    "size" VARCHAR NOT NULL
);

CREATE TABLE "shoes"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL,
    "size" NUMERIC NOT NULL
);

CREATE TABLE "sweatband"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL
);

CREATE TABLE "helmet"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL,
    "size" VARCHAR NOT NULL
);

CREATE TABLE "hat"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL
);

CREATE TABLE "gloves"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL,
    "size" VARCHAR NOT NULL
);

CREATE TABLE "trousers"
(
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "price" NUMERIC NOT NULL,
    "brand" VARCHAR NOT NULL,
    "size" NUMERIC NOT NULL
);


