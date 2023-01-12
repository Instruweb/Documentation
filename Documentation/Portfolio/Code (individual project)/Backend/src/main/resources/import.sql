INSERT INTO users (username, emailaddress, address, postalcode, phonenumber)
VALUES ('nickwelles', 'nick@welles.com', 'Jan met de korte achternaam straat', '5971PC', '0612345678');

INSERT INTO main_category (name, image) VALUES ('Gitaren', 'gitaren.png');
INSERT INTO main_category (name, image) VALUES ('Hoofdtelefoons', 'hoofdtelefoons.png');
INSERT INTO main_category (name, image) VALUES ('Microfoons', 'microfoons.png');
INSERT INTO main_category (name, image) VALUES ('Studio & Recording', 'studio.webp');

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Fazley Outlaw Series Sheriff Basic HH Green elektrische gitaar met gigbag', 128.99, 'fazely.png', 'De Fazley Sheriff Basic HH uit de Outlaw Series is een veelzijdige elektrische gitaar met een geheel eigen karakter. Zo is de elzenhouten solid body voorzien van een hand stained afwerking! Hierdoor ziet elk exemplaar er net even anders uit en krijg je een unieke gitaar voor in je collectie. Deze HH-versie is geladen met twee passieve humbuckers, waardoor je kunt rekenen op een krachtige en volle klank. Dit maakt de Fazley Sheriff Basic HH een goede keuze voor de liefhebbers van bijvoorbeeld pop, rock en het stevigere werk. Leuke bonus is dat er een handige gigbag wordt meegeleverd! Outlaw Series Sheriff Basic: Fijne speelervaring Fazley heeft gekozen voor een esdoornhouten hals met een comfortabel C-profiel. In combinatie met de bolle 9.5 inch toetsradius en de 22 medium frets levert dit een hoog speelgemak op. Je zult merken dat je de snaren makkelijk kunt opdrukken. De achterzijde van de hals heeft een fijne zijdeglans (satin) afwerking, waardoor de hals lekker snel aanvoelt. Andere opvallende details voor een gitaar in deze lage prijsklasse zijn de Graph Tech TUSQ topkam en de moderne 2-punts tremolo. Dit komt onder andere de intonatie en de stemvastheid ten goede.', 'Full', 1, 1);

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Fender Gitaar', 849.99, 'fender_gitaar.jpg', 'Een mooie gitaar van Fender met 6 snaren.', 'Full', 1, 1);

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Les Paul Gitaar', 399.99, 'gitaar.webp', 'Een mooie gitaar van Les Paul met 7 snaren.', 'Full', 1, 1);

INSERT INTO product (name, price, image, description, supply, main_categoryId, sub_categoryId)
VALUES ('Devine koptelefoon', 159.99, 'koptelefoon2.webp', 'Een mooie koptelefoon die je kunt gebruiken in de studio om bijvoorbeeld te mixen/masteren of om muziek op te luisteren.', 'Full', 2, 1);