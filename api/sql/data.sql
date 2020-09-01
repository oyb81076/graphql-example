insert into author(id, name, type, created)
values (1, 'Author 1', 0, current_time),
       (2, 'Author 2', 1, current_time),
       (3, 'Author 3', 0, current_time),
       (4, 'Author 4', 1, current_time),
       (5, 'Author 5', 0, current_time),
       (6, 'Author 6', 1, current_time),
       (7, 'Author 7', 0, current_time),
       (8, 'Author 8', 1, current_time),
       (9, 'Author 9', 0, current_time),
       (10, 'Author 10', 0, current_time),
       (11, 'Author 11', 0, current_time),
       (12, 'Author 12', 0, current_time),
       (13, 'Author 13', 0, current_time)
;

insert into book(id, name, author_id, classify_id, created)
values (201, 'Book 1', 1, 0, current_time),
       (202, 'Book 1', 1, 1, current_time),
       (203, 'Book 1', 2, 0, current_time),
       (204, 'Book 1', 1, 0, current_time),
       (205, 'Book 1', 1, 0, current_time),
       (206, 'Book 1', 1, 2, current_time),
       (207, 'Book 1', 3, 0, current_time),
       (208, 'Book 1', 1, 0, current_time),
       (209, 'Book 1', 1, 1, current_time),
       (210, 'Book 1', 1, 0, current_time),
       (211, 'Book 1', 5, 0, current_time),
       (212, 'Book 1', 1, 0, current_time),
       (213, 'Book 1', 11, 0, current_time)
;

insert into book_classify(id, name)
values (300, 'classify 0'),
       (301, 'classify 1'),
       (302, 'classify 2');
