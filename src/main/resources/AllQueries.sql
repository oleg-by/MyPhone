USE mobilestore;

INSERT INTO `users` (`username`, `email`, `password`, `account_type`, `birth`) 
VALUES ("olezha", "allbuk@mail.ru", "asdf1234", "admin", "1990-07-20");
INSERT INTO `users` (`username`, `email`, `password`, `account_type`, `birth`) 
VALUES ("vadik", "xxx100@gmail.com", "qwerty", "user", "1999-01-13");
INSERT INTO `users` (`username`, `email`, `password`, `account_type`, `birth`) 
VALUES ("zhanna", "zanna1@mail.ru", "12345678", "user", "2000-02-10");
INSERT INTO `users` (`username`, `email`, `password`, `account_type`, `birth`) 
VALUES ("pupsik111", "valera@mail.ru", "qwerty1", "user", "1985-10-14");
INSERT INTO `users` (`username`, `email`, `password`, `account_type`, `birth`) 
VALUES ("zubr", "zubr@gmail.com", "111222333", "user", "1991-12-29");
INSERT INTO `users` (`username`, `email`, `password`, `account_type`, `birth`) 
VALUES ("firegirl", "firegirl@gmail.com", "123456789", "user", "1998-02-28");
INSERT INTO `users` (`username`, `email`, `password`, `account_type`, `birth`) 
VALUES ("kesha", "kesha-x1x1@gmail.com", "987456321", "user", "1985-01-01");

INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `entrance`, `apt`, `floor`)
VALUES ("Belarus", "Minsk", "Bratskaya St.", 4, 1, 111, 10);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `entrance`, `apt`, `floor`)
VALUES ("Belarus", "Minsk", "Nyamiga St.", 5, 1, 12, 1);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `entrance`, `apt`, `floor`)
VALUES ("Belarus", "Minsk", "Mogilevskaya St.", 1, 1, 14, 1);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`)
VALUES ("USA", "Cupertino", " Infinite Loop", 1);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`)
VALUES ("South Korea", "Suwon", "Maetan 3-Dong", 416);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`)
VALUES ("China", "Beijing", "Xierqi Middle Road", 33);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`)
VALUES ("Belarus", "Minsk", "Denisovskaya St.", 8);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`)
VALUES ("Belarus", "Minsk", "Umanskaya St.", 54);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`)
VALUES ("Belarus", "Minsk", "Mayakovkogo St.", 154);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `apt`)
VALUES ("Belarus", "Minsk", "Machinostroiteley St.", 29, 20);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `apt`)
VALUES ("Belarus", "Minsk", "M. Bognanovicha St.", 155, 301);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `corp`, `entrance`, `apt`, `floor`)
VALUES ("Belarus", "Gomel", "Lenina St.", 5, 2, 4, 105, 5);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `apt`, `floor`)
VALUES ("Belarus", "Brest", "Lenina St.", 7, 90, 7);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `apt`, `floor`)
VALUES ("Belarus", "Mogilev", "Central St.", 55, 18, 3);
INSERT INTO `addresses` (`country`, `city`, `street`, `building_number`, `apt`, `floor`)
VALUES ("Belarus", "Bobruisk", "Krasnaya St.", 10, 99, 5);

INSERT INTO `categories` (`name`) VALUES ("Mobile phones");

INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`, `id_address_c`, `email`, `id_user`)
VALUES ("Vadim", "Ivanov", 291113323, 2, "xxx100@gmail.com", 2);
INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`, `id_address_c`, `email`, `id_user`)
VALUES ("Zhanna", "Aguzarova", 447114323, 3, "xxx100@gmail.com", 3);
INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`, `id_address_c`, `email`, `id_user`)
VALUES ("Valery", "Leontiev", 2365478, 1, "valera@mail.ru", 4);
INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`, `id_address_c`, `email`, `id_user`)
VALUES ("Anton", "Zubr", 1051112, 12, "zubr@gmail.com", 5);
INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`, `id_address_c`, `id_user`)
VALUES ("Oleg", "Bukatich", 293868619, 13, 1);
INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`, `id_address_c`, `id_user`)
VALUES ("Oksana", "Ogonek", 441301118, 14, 6);
INSERT INTO `customers` (`first_name`, `last_name`, `phone_number`, `id_address_c`, `id_user`)
VALUES ("Inokentiy", "Smoktunovskiy", 256589966, 15, 8);

INSERT INTO `deliveries` (`name`, `days`)
VALUES ("City delivery", 1);
INSERT INTO `deliveries` (`name`, `days`)
VALUES ("Country delivery", 5);
INSERT INTO `deliveries` (`name`, `days`)
VALUES ("Pickup from pickup point", 1);
INSERT INTO `deliveries` (`name`, `days`)
VALUES ("Postal delivery", 1);
INSERT INTO `deliveries` (`name`, `days`)
VALUES ("PONY EXPRESS delivery", 2);

INSERT INTO `manufacturers` (`name`, `id_address_m`)
VALUES ("Apple Inc.", 4);
INSERT INTO `manufacturers` (`name`, `id_address_m`)
VALUES ("Samsung Electronics Co., Ltd.", 5);
INSERT INTO `manufacturers` (`name`, `id_address_m`)
VALUES ("Xiaomi Corporation", 6);

INSERT INTO `screens` (`name_technology`, `size`, `resolution`)
VALUES ("OLED (Super Retina XDR)", 6.7, "1284x2778");
INSERT INTO `screens` (`name_technology`, `size`, `resolution`)
VALUES ("AMOLED (Dynamic AMOLED 2X)", 6.8, "1440x3088");
INSERT INTO `screens` (`name_technology`, `size`, `resolution`)
VALUES ("AMOLED", 6.67, "1080x2400");
INSERT INTO `screens` (`name_technology`, `size`, `resolution`)
VALUES ("IPS", 6.6, "1228 x 2700");

INSERT INTO `descriptions` (`brand`, `model`, `year`, `operating_system`, `id_screen`, `CPU`, `RAM`, `memory`, `camera`, `battery`, `id_manufacturer`)
VALUES ("Apple", "iPhone 13 Pro Max 1TB", 2022, "Apple iOS 15", 1, "Apple A15 Bionic", 6, 1024, "12 MP", "4352 mAh", 1);
INSERT INTO `descriptions` (`brand`, `model`, `year`, `operating_system`, `id_screen`, `CPU`, `RAM`, `memory`, `camera`, `battery`, `id_manufacturer`)
VALUES ("Samsung", "Galaxy S22 Ultra 5G", 2022, "Android 12  (One UI 4.1)", 2, "Exynos 2200", 12, 1024, "40 MP", "5000 mAh", 2);
INSERT INTO `descriptions` (`brand`, `model`, `year`, `operating_system`, `id_screen`, `CPU`, `RAM`, `memory`, `camera`, `battery`, `id_manufacturer`)
VALUES ("Xiaomi", "Mi Mix 4", 2021, "Android 11 ", 3, "Qualcomm Snapdragon 888+", 12, 512, "108 MP", "4500 mAh", 3);
INSERT INTO `descriptions` (`brand`, `model`, `year`, `operating_system`, `id_screen`, `CPU`, `RAM`, `memory`, `camera`, `battery`)
VALUES ("Huawei", "P50 PRO", 2021, "HarmonyOS", 4, "Qualcomm Snapdragon 888", 12, 512, "50 MP", "4360 mAh");

INSERT INTO `products` (`id_category`, `name`, `price`, `id_description`)
VALUES (1, "Apple iPhone 13 Pro Max 1TB", 2400.00, 1);
INSERT INTO `products` (`id_category`, `name`, `price`, `id_description`)
VALUES (1, "Samsung Galaxy S22 Ultra 5G 12GB/1TB", 2900.00, 2);
INSERT INTO `products` (`id_category`, `name`, `price`, `id_description`)
VALUES (1, "Xiaomi Mi Mix 4 12GB/512GB", 1500.00, 3);
INSERT INTO `products` (`id_category`, `name`, `price`, `id_description`)
VALUES (1, "Xiaomi Mi Mix 4", 0.00, 3);

INSERT INTO `payments` (`name`) VALUES ("online payment");
INSERT INTO `payments` (`name`) VALUES ("cash on delivery");
INSERT INTO `payments` (`name`) VALUES ("payment on delivery by card");
INSERT INTO `payments` (`name`) VALUES ("COD");

INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `order_amount`, `id_delivery`, `id_payment`)
VALUES (4, 2, 1, 2900.00, 1, 1);
INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `order_amount`, `id_delivery`, `id_payment`)
VALUES (2, 1, 1, 2400.00, 3, 3);
INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `order_amount`, `id_delivery`, `id_payment`)
VALUES (3, 3, 1, 1500.00, 2, 2);

INSERT INTO `stores` (`name`, `id_address_s`) VALUES ("5 element", 7);
INSERT INTO `stores` (`name`, `id_address_s`) VALUES ("Electrosila", 8);
INSERT INTO `stores` (`name`, `id_address_s`) VALUES ("Technosila", 9);

INSERT INTO `suppliers` (`name`, `id_address_sup`) VALUES ("ASBIS", 10);
INSERT INTO `suppliers` (`name`, `id_address_sup`) VALUES ("Novotrend", 11);

INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (1, 27, 1);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (2, 15, 1);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (3, 11, 1);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (1, 19, 2);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (2, 40, 2);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (3, 31, 2);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (1, 5, 3);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (2, 4, 3);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (3, 3, 3);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (1, 0, 1);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (2, 0, 2);
INSERT INTO `warehouse` (`id_product_w`, `quantity`, `id_store`) VALUES (3, 0, 3);

INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (1, 1);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (2, 1);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (3, 2);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (4, 1);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (5, 1);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (6, 2);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (7, 1);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (8, 1);
INSERT INTO `warehouse_suppliers` (`id_warehouse`, `id_supplier`) VALUES (9, 2);

UPDATE `addresses` SET `street` = 'Infinite Loop' WHERE `id` = '4';
    
UPDATE `customers` SET `phone_number` = '332365478' WHERE `id` = '4';
    
UPDATE `customers` SET `phone_number` = '291051112' WHERE `id` = '1';
    
UPDATE `customers` SET `email` = (SELECT `email` FROM `users` WHERE `id` = '3') WHERE `id` = '3';

UPDATE `descriptions` SET `operating_system` = 'Android 12' WHERE `id` = '2';

UPDATE `warehouse` SET `quantity` = 39 WHERE `id` = '5';

UPDATE `warehouse` SET `quantity` = 30 WHERE `id` = '6';

UPDATE `addresses` 
SET `city` = 'Grodno',
    `street` = 'Lenina St.',
    `building_number` = '6',
    `corp` = '2',
    `apt` = '10',
    `floor` = '2'
WHERE `id` = '1';

UPDATE `addresses` SET `floor` = '1' WHERE `floor` IS NULL;

UPDATE `products` SET `price` = `price` * 1.15 WHERE `price` < 2000;

ALTER TABLE `users` 
ADD COLUMN `age` INT NULL AFTER `birth`;

UPDATE `users` 
SET 
    `age` = ((YEAR(CURRENT_DATE) - YEAR(`birth`)) - (DATE_FORMAT(CURRENT_DATE, '%m%d') < DATE_FORMAT(`birth`, '%m%d')))
WHERE
    `age` IS NULL;

ALTER TABLE `customers`
DROP COLUMN `email`;

ALTER TABLE `addresses`
DROP COLUMN `entrance`;

ALTER TABLE `orders` 
ADD COLUMN `unit_price` FLOAT NULL AFTER `count`;

UPDATE `orders` 
SET 
    `unit_price` = (SELECT 
            `price`
        FROM
            `products`
        WHERE
            id_product = id);

ALTER TABLE `orders`
DROP COLUMN `order_amount`;

ALTER TABLE `orders` 
ADD COLUMN `order_amount` FLOAT 
GENERATED ALWAYS AS (`unit_price` * `count`) STORED
NULL AFTER `unit_price`;

INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `unit_price`, `id_delivery`, `id_payment`)
VALUES (1, 1, 3, 2400, 1, 1);
INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `unit_price`, `id_delivery`, `id_payment`)
VALUES (6, 2, 2, 2900, 2, 1);
INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `unit_price`, `id_delivery`, `id_payment`)
VALUES (7, 3, 3, 1725, 3, 2);
INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `unit_price`, `id_delivery`, `id_payment`)
VALUES (5, 3, 1, 1725, 4, 3);
INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `unit_price`, `id_delivery`, `id_payment`)
VALUES (7, 2, 1, 2900, 2, 2);
INSERT INTO `orders` (`id_customer`, `id_product`, `count`, `unit_price`, `id_delivery`, `id_payment`)
VALUES (1, 1, 2, 2400, 2, 1);

UPDATE `orders` 
SET 
    `count` = 2
WHERE
    `unit_price` < 2000;
    
DELETE FROM `users` 
WHERE
    `create_time` >= '2022-05-04 16:00:00'
    AND `create_time` < '2022-05-05 00:00:00';

DELETE FROM `deliveries` 
WHERE
    `name` = 'PONY EXPRESS delivery';

DELETE FROM `payments` 
WHERE
    `name` = 'COD';

DELETE FROM `products` 
WHERE
    `price` = 0;

DELETE FROM `warehouse` 
WHERE
    `quantity` = 0;
    
SELECT AVG(orders.order_amount) AS `Average order amount`
FROM orders;

SELECT AVG(users.age) AS `Average user age`
FROM users;

SELECT customers.id, customers.first_name, customers.last_name, orders.order_amount, SUM(orders.order_amount)
FROM orders JOIN customers ON orders.id_customer = customers.id
GROUP BY customers.id;

SELECT MAX(order_amount) AS `MAX order amount`
FROM orders;

SELECT MIN(order_amount) AS `MIN order amount`
FROM orders;

SELECT 
    id, username, MAX(age) AS `MAX user age`
FROM
    users
GROUP BY id
HAVING MAX(age) >= ALL (SELECT 
        MAX(age)
    FROM
        users
    GROUP BY id);
    
SELECT 
    id, id_customer, MAX(order_amount) AS `MAX order amount`
FROM
    orders
GROUP BY id_customer
HAVING MAX(order_amount) >= ALL (SELECT 
        MAX(order_amount)
    FROM
        orders
    GROUP BY id_customer);
    
SELECT customers.id, customers.first_name, customers.last_name, count(orders.id)
FROM orders JOIN customers ON orders.id_customer = customers.id
GROUP BY customers.id;

SELECT products.name, SUM(quantity)
FROM warehouse JOIN products ON warehouse.id_product_w = products.id
GROUP BY id_product_w;

SELECT stores.name, SUM(quantity)
FROM warehouse JOIN stores ON warehouse.id_store = stores.id
GROUP BY id_store;

SELECT customers.id, customers.first_name, customers.last_name, count(orders.id)
FROM orders JOIN customers ON orders.id_customer = customers.id
GROUP BY customers.id
HAVING count(orders.id) > 1;

SELECT count(id)
FROM users
WHERE email LIKE '%gmail.com';

SELECT 
    first_name, last_name, order_amount
FROM
    customers
        RIGHT JOIN
    orders ON customers.id = orders.id_customer
ORDER BY order_amount DESC;

SELECT 
    orders.id,
    customers.first_name,
    customers.last_name,
    orders.count,
    orders.order_amount,
    products.name
FROM
    ((orders
    INNER JOIN customers ON customers.id = orders.id_customer)
    INNER JOIN products ON orders.id_product = products.id)
ORDER BY customers.last_name ASC;

SELECT 
    products.id,
    products.name,
    products.price,
    descriptions.brand,
    descriptions.model,
    descriptions.year,
    descriptions.operating_system,
    screens.name_technology,
    screens.size,
    screens.resolution,
    descriptions.CPU,
    descriptions.RAM,
    descriptions.memory,
    descriptions.camera,
    descriptions.battery
FROM
    ((products
    INNER JOIN descriptions ON products.id_description = descriptions.id)
    INNER JOIN screens ON screens.id = descriptions.id_screen)
ORDER BY products.name ASC;
    
SELECT 
    stores.name,
    addresses.city,
    addresses.street,
    addresses.building_number,
    addresses.corp,
    addresses.apt
FROM
    stores
        LEFT JOIN
    addresses ON addresses.id = stores.id
ORDER BY stores.name ASC;

-- Select users who haven't made any order. Using FULL OUTER JOIN 
SELECT 
    customers.first_name,
    customers.last_name, 
    users.username
FROM
    customers
		LEFT OUTER JOIN
    users ON customers.id_user = users.id
UNION
SELECT 
    customers.first_name,
    customers.last_name, 
    users.username
FROM
    customers
		RIGHT OUTER JOIN
    users ON customers.id_user = users.id
WHERE users.id IS NULL;

-- Big statement
SELECT 
    orders.id AS 'Order ID',
    customers.first_name AS 'First Name',
    customers.last_name AS 'Last Name',
    customers.phone_number AS 'Phone Number',
    users.username AS 'Username',
    users.email AS 'E-mail',
    users.age AS 'Age',
    addresses.country AS 'Country',
    addresses.city AS 'City',
    addresses.street AS 'Street',
    addresses.building_number AS 'Building Number',
    addresses.corp AS 'Corp.',
    addresses.apt AS 'Apt.',
    categories.name AS 'Category',
    products.name AS 'Product Name',
    descriptions.brand AS 'Brand',
    descriptions.model AS 'Model',
    descriptions.year AS 'Year',
    descriptions.operating_system AS 'OS',
    screens.name_technology AS 'Display',
    screens.size AS 'Size, inch.',
    screens.resolution AS 'Resolution',
    descriptions.CPU,
    descriptions.RAM AS 'RAM, Gb',
    descriptions.memory AS 'Memory, Gb',
    descriptions.camera AS 'Camera',
    descriptions.battery AS 'Battery',
    manufacturers.name AS 'Manufacturer',
    orders.count AS 'Quantity',
    orders.unit_price AS 'Unit Price, USD',
    orders.order_amount  AS 'Total, $',
    deliveries.name AS 'Delivery',
    deliveries.days AS 'Days',
    payments.name AS 'Payment'
FROM
    orders
    JOIN customers ON orders.id_customer = customers.id
    JOIN users ON customers.id_user = users.id
    JOIN addresses ON customers.id_address_c = addresses.id
    JOIN products ON orders.id_product = products.id
    JOIN categories ON categories.id = products.id_category
    JOIN descriptions ON products.id_description = descriptions.id
    JOIN screens ON screens.id = descriptions.id_screen
    JOIN manufacturers ON descriptions.id_manufacturer = manufacturers.id
    JOIN deliveries ON orders.id_delivery = deliveries.id
    JOIN payments ON orders.id_payment = payments.id
ORDER BY orders.id ASC;