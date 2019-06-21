INSERT INTO author (authorid, firstname, lastname) VALUES (1, 'John', 'Mitchell');
INSERT INTO author (authorid, firstname, lastname) VALUES (2, 'Dan', 'Brown');
INSERT INTO author (authorid, firstname, lastname) VALUES (3, 'Jerry', 'Poe');
INSERT INTO author (authorid, firstname, lastname) VALUES (4, 'Wells', 'Teague');
INSERT INTO author (authorid, firstname, lastname) VALUES (5, 'George', 'Gallinger');
INSERT INTO author (authorid, firstname, lastname) VALUES (6, 'Ian', 'Stewart');

INSERT INTO book (bookid, booktitle, ISBN, copy) VALUES (11, 'Flatterland', '9780738206752', 2001);
INSERT INTO book (bookid, booktitle, ISBN, copy) VALUES (12, 'Digital Fortess', '9788489367012', 2007);
INSERT INTO book (bookid, booktitle, ISBN, copy) VALUES (13, 'The Da Vinci Code', '9780307474278', 2009);
INSERT INTO book (bookid, booktitle, ISBN, copy) VALUES (14, 'Essentials of Finance', '1314241651234', 2000);
INSERT INTO book (bookid, booktitle, ISBN, copy) VALUES (15, 'Calling Texas Home', '1885171382134', 2000);

INSERT INTO wrote (bookid, authorid) VALUES (11, 6);
INSERT INTO wrote (bookid, authorid) VALUES (12, 2);
INSERT INTO wrote (bookid, authorid) VALUES (13, 2);
INSERT INTO wrote (bookid, authorid) VALUES (14, 5);
INSERT INTO wrote (bookid, authorid) VALUES (14, 3);
INSERT INTO wrote (bookid, authorid) VALUES (15, 4);

alter sequence hibernate_sequence restart with 25;
