-- Create table for the product entity
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2)

);

-- Add any necessary data or initial values if required (optional)
-- For example, insert some sample products
--INSERT INTO product (name, description, price)
--VALUES ('Sample Product', 'This is a sample product description', 19.99);
