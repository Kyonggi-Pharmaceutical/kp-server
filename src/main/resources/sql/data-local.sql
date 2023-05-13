insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, user_answer) values (0, '홍길동!!!', '길동', '홍', 'test@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTJ', 'HEALTH', 0,
                                                                                                                                                                                                                                  false, false, '2023-01-01T00:00:00',
                                                                                                                                                                                                                                  '2023-01-01T00:00:00', 'NORMAL');
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at) values (-1, '김영희!!!', '영희', '김', 'test2@test.com', '', 'FEMALE', '2023-01-01', 160, 50, 'ESFP', 'STRESS', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00');

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

insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti,
                  stress_point, is_smoking, is_alcohol, created_at, updated_at, user_answer)
values
       (-10, '이정은!!', '이정은', '컴퓨터공학부', 'lje4624@kyonggi.ac.kr', '', 'MALE', '1990-01-01', 180, 75,
        'ISTJ',  4, true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'NORMAL'),
       (-11, 'Jane!!', 'Jane', 'Doe', 'jane.doe@gmail.com', 'https://example.com/profiles/jane.jpg', 'FEMALE', '1995-05-05', 165,
        55, 'ENFP',  6, false, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EASY'),
       (-12, 'Mike!!', 'Mike', 'Smith', 'mike.smith@gmail.com', 'https://example.com/profiles/mike.jpg', 'MALE', '1985-08-08', 175,
        70, 'INTP',  2, false, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'NORMAL'),
       (-13, 'Lisa!!', 'Lisa', 'Kim', 'lisa.kim@gmail.com', 'https://example.com/profiles/lisa.jpg', 'FEMALE', '1992-12-12', 160,
        50, 'ISTJ',  8, true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EASY'),
       (-14, 'David!!', 'David', 'Lee', 'david.lee@gmail.com', 'https://example.com/profiles/david.jpg', 'MALE', '1988-06-06', 185,
        80, 'ENTJ',  5, false, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'NORMAL'),
       (-15, 'Emily!!', 'Emily', 'Wong', 'emily.wong@gmail.com', 'https://example.com/profiles/emily.jpg', 'FEMALE', '1999-09-09',
        170, 60, 'INFP',  3, false, true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EASY');





INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-10, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISFP', 6.0, 'Jogging', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-11, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'INFJ', 8.0, 'Yoga', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-12, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ENTP', 5.0, 'Swimming', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-13, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISTJ', 6.0, 'Biking', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-14, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ENFJ', 7.0, 'Pilates', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-15, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ESTJ', 4.0, 'Walking', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-16, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISFJ', 3.0, 'Dancing', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-17, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'INTP', 5.0, 'Jumping rope', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-18, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ESFJ', 7.0, 'Hiking', 'CARDIO');
INSERT INTO EXERCISEs (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE)
VALUES (-19, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 'ISTP', 4.0, 'Push-ups', 'CARDIO');
insert into exercises (ID, CREATED_AT, UPDATED_AT, MBTI, MET, NAME, TYPE) VALUES (-20, '2023-05-01', '2023-05-01', 'ISTP, ENTP, INFP', 5.5, 'RUNNING', 'CARDIO'), (0, '2023-05-02', '2023-05-02',
                                                                                                                                                                  'ISTP, ENTP, INFP', 5.5,
                                                                                                                                                                  'hiking', 'CARDIO'),
                                                                                 (-21, '2023-05-01', '2023-05-01','ISTJ,ISFJ,INFJ', 4.3,
                                                                                  'Weightlifting', 'WEIGHT'),
                                                                                 (-22, '2023-05-01', '2023-05-01','INFJ', 5.5, 'Running',
                                                                                  'CARDIO'),
                                                                                 (-23,'2023-05-01', '2023-05-01', 'ISTJ', 3.8, 'Yoga',
                                                                                  'CARDIO');
insert into user_exercises(ID, CAL, DATE, EXERCISE_ID, USER_ID) values (0, 33.3, '2023-05-05', -10, -10);

insert into activities(id, name, symptom) values (1, 'TEST_ACTIVITY_1', 'LETHARGIC');
insert into activities(id, name, symptom) values (2, 'TEST_ACTIVITY_2', 'LETHARGIC');
insert into activities(id, name, symptom) values (3, 'TEST_ACTIVITY_3', 'LETHARGIC');
insert into activities(id, name, symptom) values (4, 'TEST_ACTIVITY_4', 'LETHARGIC');
insert into activities(id, name, symptom) values (5, 'TEST_ACTIVITY_5', 'LETHARGIC');
insert into activities(id, name, symptom) values (6, 'TEST_ACTIVITY_6', 'LETHARGIC');
insert into activities(id, name, symptom) values (7, 'TEST_ACTIVITY_7', 'LETHARGIC');
insert into activities(id, name, symptom) values (8, 'TEST_ACTIVITY_8', 'LETHARGIC');
insert into activities(id, name, symptom) values (9, 'TEST_ACTIVITY_9', 'LETHARGIC');
insert into activities(id, name, symptom) values (10, 'TEST_ACTIVITY_10', 'LETHARGIC');

insert into activity_mbti(id, mbti, activity_id) values (1, 'INTJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (2, 'INFJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (3, 'INTP', 1);
insert into activity_mbti(id, mbti, activity_id) values (4, 'INTJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (5, 'INFJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (6, 'INTP', 2);
insert into activity_mbti(id, mbti, activity_id) values (7, 'INTJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (8, 'INFJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (9, 'INTP', 3);
insert into activity_mbti(id, mbti, activity_id) values (10, 'INTJ', 4);
insert into activity_mbti(id, mbti, activity_id) values (11, 'INFJ', 4);
insert into activity_mbti(id, mbti, activity_id) values (12, 'INTP', 4);
insert into activity_mbti(id, mbti, activity_id) values (13, 'INTJ', 5);
insert into activity_mbti(id, mbti, activity_id) values (14, 'INFJ', 5);
insert into activity_mbti(id, mbti, activity_id) values (15, 'INTP', 5);
insert into activity_mbti(id, mbti, activity_id) values (16, 'ESTJ', 6);
insert into activity_mbti(id, mbti, activity_id) values (17, 'ESFJ', 6);
insert into activity_mbti(id, mbti, activity_id) values (18, 'ESTP', 6);
insert into activity_mbti(id, mbti, activity_id) values (19, 'ESTJ', 7);
insert into activity_mbti(id, mbti, activity_id) values (20, 'ESFJ', 7);
insert into activity_mbti(id, mbti, activity_id) values (21, 'ESTP', 7);
insert into activity_mbti(id, mbti, activity_id) values (22, 'ESTJ', 8);
insert into activity_mbti(id, mbti, activity_id) values (23, 'ESFJ', 8);
insert into activity_mbti(id, mbti, activity_id) values (24, 'ESTP', 8);
insert into activity_mbti(id, mbti, activity_id) values (25, 'ESTJ', 9);
insert into activity_mbti(id, mbti, activity_id) values (26, 'ESFJ', 9);
insert into activity_mbti(id, mbti, activity_id) values (27, 'ESTP', 9);
insert into activity_mbti(id, mbti, activity_id) values (28, 'ESTJ', 10);
insert into activity_mbti(id, mbti, activity_id) values (29, 'ESFJ', 10);
insert into activity_mbti(id, mbti, activity_id) values (30, 'ESTP', 10);
insert into activity_mbti(id, mbti, activity_id) values (31, 'ESFP', 1);
insert into activity_mbti(id, mbti, activity_id) values (32, 'ESFP', 2);
insert into activity_mbti(id, mbti, activity_id) values (33, 'ESFP', 3);
insert into activity_mbti(id, mbti, activity_id) values (34, 'ESFP', 4);
insert into activity_mbti(id, mbti, activity_id) values (35, 'ESFP', 5);
insert into activity_mbti(id, mbti, activity_id) values (36, 'ESFP', 6);
insert into activity_mbti(id, mbti, activity_id) values (37, 'ESFP', 7);
insert into activity_mbti(id, mbti, activity_id) values (38, 'ESFP', 8);
insert into activity_mbti(id, mbti, activity_id) values (39, 'ESFP', 9);
insert into activity_mbti(id, mbti, activity_id) values (40, 'ESFP', 10);

insert into user_activities(id, user_id, activity_id) values (0, -1, 1);
insert into stress_goals(id, accomplish_rate, start_at, end_at) values (0, 0.0, '2023-04-01T00:00:00', '2023-04-30T23:59:59');
update users set stress_goal_id = 0 where id = -1;

insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-1, true, null, 0, -1, '2023-04-01T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-2, true, null, 0, -1, '2023-04-02T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-3, true, null, 0, -1, '2023-04-03T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-4, false, null, 0, -1, '2023-04-04T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-5, true, null, 0, -1, '2023-04-05T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-6, true, null, 0, -1, '2023-04-06T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-7, false, null, 0, -1, '2023-04-07T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at) values (-8, true, null, 0, -1, '2023-04-08T19:00:00');

-- 랭킹 전용 더미 데이터
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-101, '2023-04-01', 0.0, 71.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-102, '2023-04-02', 20.0, 72.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-103, '2023-04-03', 40.0, 73.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-104, '2023-04-04', 60.0, 74.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-105, '2023-04-05', 80.0, 75.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-106, '2023-04-06', 0.0, 41.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-107, '2023-04-07', 20.0, 42.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-108, '2023-04-08', 40.0, 43.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-109, '2023-04-09', 60.0, 44.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal) values (-110, '2023-04-10', 80.0, 45.0);

insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-101, 'USER-101', 'USER-101', 'USER-101', 'user-101@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTJ', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-101);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-102, 'USER-102', 'USER-102', 'USER-102', 'user-102@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTJ', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-102);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-103, 'USER-103', 'USER-103', 'USER-103', 'user-103@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTJ', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-103);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-104, 'USER-104', 'USER-104', 'USER-104', 'user-104@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTP', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-104);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-105, 'USER-105', 'USER-105', 'USER-105', 'user-105@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTP', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-105);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-106, 'USER-106', 'USER-106', 'USER-106', 'user-106@test.com', '', 'FEMALE', '2023-01-01', 160, 50, 'INTP', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-106);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-107, 'USER-107', 'USER-107', 'USER-107', 'user-107@test.com', '', 'FEMALE', '2023-01-01', 160, 50, 'INTP', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-107);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-108, 'USER-108', 'USER-108', 'USER-108', 'user-108@test.com', '', 'FEMALE', '2023-01-01', 160, 50, 'ESFP', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-108);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-109, 'USER-109', 'USER-109', 'USER-109', 'user-109@test.com', '', 'FEMALE', '2023-01-01', 160, 50, 'ESFP', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-109);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, health_goal_id) values (-110, 'USER-110', 'USER-110', 'USER-110', 'user-110@test.com', '', 'FEMALE', '2023-01-01', 160, 50, 'ESFP', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00',-110);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-01T12:00:00',true, '2023-04-01', -101, -101);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-02T12:00:00',true, '2023-04-02', -101, -101);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-03T12:00:00',true, '2023-04-03', -101, -101);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-04T12:00:00',true, '2023-04-04', -101, -101);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-05T12:00:00',true, '2023-04-05', -101, -101);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-02T12:00:00',true, '2023-04-02', -102, -102);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-03T12:00:00',false, '2023-04-03', -102, -102);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-04T12:00:00',false, '2023-04-04', -102, -102);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-05T12:00:00',false, '2023-04-05', -102, -102);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, '2023-04-06', -102, -102);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-03T12:00:00',true, '2023-04-03', -103, -103);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-04T12:00:00',true, '2023-04-04', -103, -103);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-05T12:00:00',false, '2023-04-05', -103, -103);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-06T12:00:00',false, '2023-04-06', -103, -103);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, '2023-04-07', -103, -103);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-04T12:00:00',true, '2023-04-04', -104, -104);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-05T12:00:00',true, '2023-04-05', -104, -104);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, '2023-04-06', -104, -104);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, '2023-04-07', -104, -104);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-08T12:00:00',false, '2023-04-08', -104, -104);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-05T12:00:00',false, '2023-04-05', -105, -105);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, '2023-04-06', -105, -105);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, '2023-04-07', -105, -105);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-08T12:00:00',true, '2023-04-08', -105, -105);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, '2023-04-09', -105, -105);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, '2023-04-06', -106, -106);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-07T12:00:00',false, '2023-04-07', -106, -106);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-08T12:00:00',true, '2023-04-08', -106, -106);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, '2023-04-09', -106, -106);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, '2023-04-10', -106, -106);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, '2023-04-07', -107, -107);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-08T12:00:00',true, '2023-04-08', -107, -107);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-09T12:00:00',false, '2023-04-09', -107, -107);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, '2023-04-10', -107, -107);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-11T12:00:00',false, '2023-04-11', -107, -107);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-08T12:00:00',false, '2023-04-08', -108, -108);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, '2023-04-09', -108, -108);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, '2023-04-10', -108, -108);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-11T12:00:00',true, '2023-04-11', -108, -108);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-12T12:00:00',false, '2023-04-12', -108, -108);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, '2023-04-09', -109, -109);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, '2023-04-10', -109, -109);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-11T12:00:00',true, '2023-04-11', -109, -109);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-12T12:00:00',true, '2023-04-12', -109, -109);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-13T12:00:00',true, '2023-04-13', -109, -109);

insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-10T12:00:00',false, '2023-04-10', -110, -110);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-11T12:00:00',false, '2023-04-11', -110, -110);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-12T12:00:00',true, '2023-04-12', -110, -110);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-13T12:00:00',false, '2023-04-13', -110, -110);
insert into daily_progresses(created_at, is_check, date, health_goal_id, user_id) values ('2023-04-14T12:00:00',false, '2023-04-14', -110, -110);
