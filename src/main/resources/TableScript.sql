--Products Table
CREATE TABLE products (
    product_id VARCHAR2(200) PRIMARY KEY,
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

--Sequence for generate custom product Id
CREATE SEQUENCE product_id_seq START WITH 1 INCREMENT BY 1;

--For Your Information
--DDL
DROP table products;
drop sequence product_id_seq;
truncate table products;
--TCL
rollback;
commit;
--DML
INSERT INTO products (product_name, prod_category, prod_price, quantity, product_desc, manufacturer, image_url, video_url, manufacturer_date, expiry_date, brand, color, product_size, weight, dimensions, material, sku, barcode, regular_price, discount_price, currency, prod_availability, reorder_point, warehouse_location, created_date, last_updated_date, rating, total_reviews, featured_product)
VALUES 
('Product 1', 'Category 1', 10.99, 100, 'Description of Product 1', 'Manufacturer A', 'image1.jpg', 'video1.mp4', TO_DATE('2024-03-23', 'YYYY-MM-DD'), TO_DATE('2024-12-31', 'YYYY-MM-DD'), 'Brand X', 'Red', 'L', 1.5, '10x20x30', 'Cotton', 'SKU0012', '12345678901235', 15.99, 12.99, 'USD', 'Available', 10, 'Location A', SYSDATE, SYSDATE, 4, 50, 'Y');
delete from products where product_id='Prod_69';
--DQL 
select * from products;
select product_id_seq.NEXTVAL from dual;