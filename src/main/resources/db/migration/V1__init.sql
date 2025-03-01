CREATE TABLE ecomproductservicedb.category
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255) NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    is_deleted    BIT(1) NOT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE ecomproductservicedb.product
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255) NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    is_deleted    BIT(1) NOT NULL,
    `description` VARCHAR(255) NULL,
    imageurl      VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE ecomproductservicedb.product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES ecomproductservicedb.category (id);