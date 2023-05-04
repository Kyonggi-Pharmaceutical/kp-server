insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, user_answer) values (0, '홍길동!!!', '길동', '홍', 'test@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTJ', 'HEALTH', 0,
                                                                                                                                                                                                                                  false, false, '2023-01-01T00:00:00',
                                                                                                                                                                                                                                  '2023-01-01T00:00:00', 'NORMAL');

insert into daily_health_messages(id, type, personality, content) values(1, 'EXERCISE', 'INTROVERSION', 'EXERCISE INTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(2, 'EXERCISE', 'EXTROVERSION', 'EXERCISE EXTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(3, 'EXERCISE', 'ALL', 'EXERCISE ALL message');
insert into daily_health_messages(id, type, personality, content) values(4, 'STRESS', 'INTROVERSION', 'STRESS INTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(5, 'STRESS', 'EXTROVERSION', 'STRESS EXTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(6, 'STRESS', 'ALL', 'STRESS ALL message');
insert into daily_health_messages(id, type, personality, content) values(7, 'HEALTH_GOAL', 'INTROVERSION', 'HEALTH_GOAL INTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(8, 'HEALTH_GOAL', 'EXTROVERSION', 'HEALTH_GOAL EXTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(9, 'HEALTH_GOAL', 'ALL', 'HEALTH_GOAL ALL message');
insert into daily_health_messages(id, type, personality, content) values(10, 'PROGRESS', 'INTROVERSION', 'PROGRESS INTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(11, 'PROGRESS', 'EXTROVERSION', 'PROGRESS EXTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(12, 'PROGRESS', 'ALL', 'PROGRESS ALL message');
insert into daily_health_messages(id, type, personality, content) values(13, 'FOOD', 'INTROVERSION', 'FOOD INTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(14, 'FOOD', 'EXTROVERSION', 'FOOD EXTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(15, 'FOOD', 'ALL', 'FOOD ALL message');
insert into daily_health_messages(id, type, personality, content) values(16, 'LIFE_STYLE', 'INTROVERSION', 'LIFE_STYLE INTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(17, 'LIFE_STYLE', 'EXTROVERSION', 'LIFE_STYLE EXTROVERSION message');
insert into daily_health_messages(id, type, personality, content) values(18, 'LIFE_STYLE', 'ALL', 'LIFE_STYLE ALL message');

insert into users(id, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti,
                  stress_point, is_smoking, is_alcohol, created_at, updated_at, user_answer)
values
       (1, '이정은', '컴퓨터공학부', 'lje4624@kyonggi.ac.kr', '', 'MALE', '1990-01-01', 180, 75,
        'ISTJ',  4, true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'NORMAL'),
       (2, 'Jane', 'Doe', 'jane.doe@gmail.com', 'https://example.com/profiles/jane.jpg', 'FEMALE', '1995-05-05', 165,
        55, 'ENFP',  6, false, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EASY'),
       (3, 'Mike', 'Smith', 'mike.smith@gmail.com', 'https://example.com/profiles/mike.jpg', 'MALE', '1985-08-08', 175,
        70, 'INTP',  2, false, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'NORMAL'),
       (4, 'Lisa', 'Kim', 'lisa.kim@gmail.com', 'https://example.com/profiles/lisa.jpg', 'FEMALE', '1992-12-12', 160,
        50, 'ISTJ',  8, true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EASY'),
       (5, 'David', 'Lee', 'david.lee@gmail.com', 'https://example.com/profiles/david.jpg', 'MALE', '1988-06-06', 185,
        80, 'ENTJ',  5, false, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'NORMAL'),
       (6, 'Emily', 'Wong', 'emily.wong@gmail.com', 'https://example.com/profiles/emily.jpg', 'FEMALE', '1999-09-09',
        170, 60, 'INFP',  3, false, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EASY');





INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (1, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISFP', 6.0, 'Jogging', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (2, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'INFJ', 8.0, 'Yoga', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (3, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ENTP', 5.0, 'Swimming', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (4, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISTJ', 6.0, 'Biking', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (5, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ENFJ', 7.0, 'Pilates', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (6, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ESTJ', 4.0, 'Walking', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (7, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISFJ', 3.0, 'Dancing', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (8, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'INTP', 5.0, 'Jumping rope', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (9, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ESFJ', 7.0, 'Hiking', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (10, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISTP', 4.0, 'Push-ups', 'CARDIO');
insert into exercises (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE) VALUES (11, '2023-05-01', '2023-05-01', 'ISTP, ENTP, INFP', 5.5, 'RUNNING', 'CARDIO'), (0, '2023-05-02', '2023-05-02',
                                                                                                                                                                  'ISTP, ENTP, INFP', 5.5,
                                                                                                                                                                  'hiking', 'CARDIO'),
                                                                                 (12, '2023-05-01', '2023-05-01','ISTJ,ISFJ,INFJ', 4.3,
                                                                                  'Weightlifting', 'WEIGHT'),
                                                                                 (13, '2023-05-01', '2023-05-01','INFJ', 5.5, 'Running',
                                                                                  'CARDIO'),
                                                                                 (14,'2023-05-01', '2023-05-01', 'ISTJ', 3.8, 'Yoga',
                                                                                  'CARDIO');
insert into user_exercises(ID, CAL, DATE, EXERCISE_ID, USER_ID) values (0, 33.3, '2023-05-05', 0, 1);
