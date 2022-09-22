INSERT INTO table_category (name) VALUES ('Computadores');
INSERT INTO table_category (name) VALUES ('Notebooks');
INSERT INTO table_category (name) VALUES ('Tablets e Celulares');
INSERT INTO table_category (name) VALUES ('TV');
INSERT INTO table_category (name) VALUES ('Promoção');

INSERT INTO table_product (title, description, image, price) VALUES ('Computador Completo Fácil Intel 4GB SSD 120GB Monitor 19.', 'Nossos computadores são equipados com os mais recentes processadores de alta velocidade.', 'Caminho da imagem', 1729.50);
INSERT INTO table_product (title, description, image, price) VALUES ('Intel Core i5 8GB SSD 240GB Monitor 19.', 'Execute suas atividades de forma eficaz e com alto desempenho e baixo consumo de energia.', 'Caminho da imagem', 2066.10);
INSERT INTO table_product (title, description, image, price) VALUES ('Computador Pc Cpu Intel Core i3 Com Hdmi 4GB HD 500GB Windows 10.', 'Execute suas atividades de forma eficaz e com alto desempenho e baixo consumo de energia.', 'Caminho da imagem', 1423.90);
INSERT INTO table_product (title, description, image, price) VALUES ('Computador Desktop Intel Core i5 Com Bluetooth 8GB HD 500GB Hdmi Windows 10.', 'Este computador foi feito para atender todas as necessidades do seu cotidiano, proporcionando a você robustez, design moderno e rapidez.', 'Caminho da imagem', 1615.40);
INSERT INTO table_product (title, description, image, price) VALUES ('Computador Pc Cpu Intel Core i5 Com Hdmi 8GB HD 500GB Windows 10 Teclado Mouse Desktop.', 'Acompanhado dos processadores Intel da linha Core i5, este computador foi feito para atender todas as necessidades do seu cotidiano.', 'Caminho da imagem', 2250.70);

INSERT INTO table_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO table_product_category (product_id, category_id) VALUES (1, 5);
INSERT INTO table_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO table_product_category (product_id, category_id) VALUES (3, 1);
INSERT INTO table_product_category (product_id, category_id) VALUES (3, 5);
INSERT INTO table_product_category (product_id, category_id) VALUES (4, 1);
INSERT INTO table_product_category (product_id, category_id) VALUES (5, 1);
INSERT INTO table_product_category (product_id, category_id) VALUES (5, 5);