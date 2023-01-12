INSERT INTO users (username, emailaddress, address, postalcode, phonenumber)
VALUES ('nickwelles', 'nick@welles.com', 'Jan met de korte achternaam straat', '5971PC', '0612345678');

INSERT INTO main_category (name, image) VALUES ('Gitaren', 'gitaren.png');
INSERT INTO main_category (name, image) VALUES ('Hoofdtelefoons', 'hoofdtelefoons.png');
INSERT INTO main_category (name, image) VALUES ('Microfoons', 'microfoons.png');
INSERT INTO main_category (name, image) VALUES ('Studio & Recording', 'studio.webp');

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Gitaar', 199.99, 'fazely.png', 'Een mooie gitaar met 6 snaren.', 'Full', 1, 1);

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Fender Gitaar', 849.99, 'fender_gitaar.jpg', 'Een mooie gitaar van Fender met 6 snaren.', 'Full', 1, 1);

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Les Paul Gitaar', 399.99, 'gitaar.webp', 'Een mooie gitaar van Les Paul met 7 snaren.', 'Full', 1, 1);

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Devine koptelefoon', 159.99, 'koptelefoon2.webp', 'Een mooie koptelefoon die je kunt gebruiken in de studio om bijvoorbeeld te mixen/masteren of om muziek op te luisteren.', 'Full', 2, 1);