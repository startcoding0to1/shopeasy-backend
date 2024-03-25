--Create products table
CREATE TABLE products (
    product_id NUMBER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) PRIMARY KEY,--column value will be automatically generated by the system in a sequential manner
    product_name VARCHAR2(100) NOT NULL,
    prod_category VARCHAR2(50) NOT NULL,
    prod_price NUMBER NOT NULL,
    quantity NUMBER NOT NULL,
    product_desc VARCHAR2(500),
    manufacturer VARCHAR2(100),
    image_url VARCHAR2(255),
    video_url VARCHAR2(255),
    manufacturer_date DATE,
    expiry_date DATE,
    brand VARCHAR2(100),
    color VARCHAR2(50),
    product_size VARCHAR2(50),
    weight NUMBER,
    dimensions VARCHAR2(100),
    material VARCHAR2(100),
    sku VARCHAR2(50) UNIQUE,
    barcode VARCHAR2(50) UNIQUE,
    regular_price NUMBER,
    discount_price NUMBER,
    currency VARCHAR2(10) DEFAULT 'INR',
    prod_availability VARCHAR2(20) DEFAULT 'Available',
    reorder_point NUMBER,
    warehouse_location VARCHAR2(100),
    created_date DATE DEFAULT SYSDATE,
    last_updated_date DATE DEFAULT SYSDATE,
    rating NUMBER CHECK (rating >= 0 AND rating <= 5),
    total_reviews NUMBER DEFAULT 0,
    featured_product CHAR(1) CHECK (featured_product IN ('Y', 'N')),
    CONSTRAINT price_check CHECK (prod_price >= 0),
    CONSTRAINT quantity_check CHECK (quantity >= 0)
);

ALTER TABLE products MODIFY product_id DROP IDENTITY;

ALTER TABLE products MODIFY product_id VARCHAR2(20);

--Create a sequence to generate unique numbers for the primary key 
CREATE SEQUENCE product_id_seq START WITH 1 INCREMENT BY 1;

--Create a trigger that fires before inserting a new row into the products table and assigns the product_id with the generated value from the sequence prefixed with 'Prod_'
CREATE OR REPLACE TRIGGER product_id_trigger
BEFORE INSERT ON products
FOR EACH ROW
BEGIN
    :NEW.product_id := 'P_' || product_id_seq.NEXTVAL;
END;
/

--FYI
--select * from products;
--drop table products;
--Alter table products rename column prodt_category to prod_category;
--INSERT INTO products (product_name, prod_category, prod_price, quantity, product_desc, manufacturer, image_url, video_url, manufacturer_date, expiry_date, brand, color, product_size, weight, dimensions, material, sku, barcode, regular_price, discount_price, currency, prod_availability, reorder_point, warehouse_location, created_date, last_updated_date, rating, total_reviews, featured_product)
--VALUES 
--('Product 1', 'Category 1', 10.99, 100, 'Description of Product 1', 'Manufacturer A', 'image1.jpg', 'video1.mp4', TO_DATE('2024-03-23', 'YYYY-MM-DD'), TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'Brand X', 'Red', 'L', 1.5, '10x20x30', 'Cotton', 'SKU001', '1234567890123', 15.99, 12.99, 'USD', 'Available', 10, 'Location A', SYSDATE, SYSDATE, 4, 50, 'Y');
--
--INSERT INTO products (product_name, prod_category, prod_price, quantity, product_desc, manufacturer, image_url, video_url, manufacturer_date, expiry_date, brand, color, product_size, weight, dimensions, material, sku, barcode, regular_price, discount_price, currency, prod_availability, reorder_point, warehouse_location, created_date, last_updated_date, rating, total_reviews, featured_product)
--VALUES 
--('Product 2', 'Category 2', 19.99, 50, 'Description of Product 2', 'Manufacturer B', 'image2.jpg', 'video2.mp4', TO_DATE('2024-03-23', 'YYYY-MM-DD'), TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'Brand Y', 'Blue', 'M', 1.2, '15x25x35', 'Polyester', 'SKU002', '2345678901234', 25.99, 20.99, 'USD', 'Available', 20, 'Location B', SYSDATE, SYSDATE, 4, 30, 'N');
--   
--truncate table products;