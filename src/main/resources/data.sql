-- Initialisation des tables
INSERT INTO Country(code, name) VALUES
    ('FR', 'France'), -- Les clés sont auto-générées
    ('UK', 'United Kingdom'),
    ('US', 'United States of America');

INSERT INTO City(name, population, country_id) VALUES
    ('Toulouse', 500000, SELECT id FROM Country WHERE code = 'FR'),
    ('Gréalou', 250, SELECT id FROM Country WHERE code = 'FR'),
    ('Londres', 18000000, SELECT id FROM Country WHERE code = 'UK'),
    ('Miami', 400000, SELECT id FROM Country WHERE code = 'US');

