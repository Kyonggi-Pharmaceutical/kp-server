insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight,
                  mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at, user_answer)
values (0, '홍길동!!!', '길동', '홍', 'test@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTJ', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00', null);
insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight,
                  mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at)
values (-1, '김영희!!!', '영희', '김', 'test2@test.com', '', 'FEMALE', '2023-01-01', 160, 50, 'ESFP', 'STRESS', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00');

insert into daily_health_messages(id, type, personality, content)
values (1, 'EXERCISE', 'INTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (2, 'EXERCISE', 'EXTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (3, 'EXERCISE', 'ALL', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (4, 'STRESS', 'INTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (5, 'STRESS', 'EXTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (6, 'STRESS', 'ALL', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (7, 'HEALTH_GOAL', 'INTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (8, 'HEALTH_GOAL', 'EXTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (9, 'HEALTH_GOAL', 'ALL', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (10, 'PROGRESS', 'INTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (11, 'PROGRESS', 'EXTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (12, 'PROGRESS', 'ALL', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (13, 'FOOD', 'INTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (14, 'FOOD', 'EXTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (15, 'FOOD', 'ALL', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (16, 'LIFE_STYLE', 'INTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (17, 'LIFE_STYLE', 'EXTROVERSION', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');
insert into daily_health_messages(id, type, personality, content)
values (18, 'LIFE_STYLE', 'ALL', '지금의 노력이 결국 당신의 건강과 행복으로 이어질 거예요. 힘내세요!');

insert into exercises (ID, CREATED_AT, UPDATED_AT, MET, NAME, TYPE)
values (1, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 7.0, '싸이클', 'CARDIO');
insert into exercises (ID, CREATED_AT, UPDATED_AT, MET, NAME, TYPE)
values (2, '2023-05-02 00:00:00', '2023-05-02 00:00:00', 2.5, '요가', 'CARDIO');

insert into exercise_mbti(id, mbti, exercise_id) values (11, 'INTJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (12, 'INFJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (13, 'INTP', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (14, 'INFP', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (15, 'ISTJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (16, 'ISFJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (17, 'ISTP', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (18, 'ISFP', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (19, 'ENTJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (110, 'ENFJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (111, 'ENTP', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (112, 'ENFP', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (113, 'ESTJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (114, 'ESFJ', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (115, 'ESTP', 1);
insert into exercise_mbti(id, mbti, exercise_id) values (116, 'ESFP', 1);

insert into exercise_mbti(id, mbti, exercise_id) values (21, 'INTJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (22, 'INFJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (23, 'INTP', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (24, 'INFP', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (25, 'ISTJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (26, 'ISFJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (27, 'ISTP', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (28, 'ISFP', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (29, 'ENTJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (210, 'ENFJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (211, 'ENTP', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (212, 'ENFP', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (213, 'ESTJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (214, 'ESFJ', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (215, 'ESTP', 2);
insert into exercise_mbti(id, mbti, exercise_id) values (216, 'ESFP', 2);


insert into activities(id, name, symptom, problem) values (1, '자신과 대화 하며 현재 기분을 적어보기', 'LETHARGIC', '문제중심대처');
insert into activities(id, name, symptom, problem) values (2, '편안하고 잔잔한 음악 듣기', 'LETHARGIC', '소망적 사고');
insert into activities(id, name, symptom, problem) values (3, '오늘 하루에 대한 일기 써보기', 'LETHARGIC', '정서적 대처');

insert into activity_mbti(id, mbti, activity_id) values (11, 'INTJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (12, 'INFJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (13, 'INTP', 1);
insert into activity_mbti(id, mbti, activity_id) values (14, 'INFP', 1);
insert into activity_mbti(id, mbti, activity_id) values (15, 'ISTJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (16, 'ISFJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (17, 'ISTP', 1);
insert into activity_mbti(id, mbti, activity_id) values (18, 'ISFP', 1);
insert into activity_mbti(id, mbti, activity_id) values (19, 'ENTJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (110, 'ENFJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (111, 'ENTP', 1);
insert into activity_mbti(id, mbti, activity_id) values (112, 'ENFP', 1);
insert into activity_mbti(id, mbti, activity_id) values (113, 'ESTJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (114, 'ESFJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (115, 'ESTP', 1);
insert into activity_mbti(id, mbti, activity_id) values (116, 'ESFP', 1);

insert into activity_mbti(id, mbti, activity_id) values (21, 'INTJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (22, 'INFJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (23, 'INTP', 2);
insert into activity_mbti(id, mbti, activity_id) values (24, 'INFP', 2);
insert into activity_mbti(id, mbti, activity_id) values (25, 'ISTJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (26, 'ISFJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (27, 'ISTP', 2);
insert into activity_mbti(id, mbti, activity_id) values (28, 'ISFP', 2);
insert into activity_mbti(id, mbti, activity_id) values (29, 'ENTJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (210, 'ENFJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (211, 'ENTP', 2);
insert into activity_mbti(id, mbti, activity_id) values (212, 'ENFP', 2);
insert into activity_mbti(id, mbti, activity_id) values (213, 'ESTJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (214, 'ESFJ', 2);
insert into activity_mbti(id, mbti, activity_id) values (215, 'ESTP', 2);
insert into activity_mbti(id, mbti, activity_id) values (216, 'ESFP', 2);

insert into activity_mbti(id, mbti, activity_id) values (31, 'INTJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (32, 'INFJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (33, 'INTP', 3);
insert into activity_mbti(id, mbti, activity_id) values (34, 'INFP', 3);
insert into activity_mbti(id, mbti, activity_id) values (35, 'ISTJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (36, 'ISFJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (37, 'ISTP', 3);
insert into activity_mbti(id, mbti, activity_id) values (38, 'ISFP', 3);
insert into activity_mbti(id, mbti, activity_id) values (39, 'ENTJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (310, 'ENFJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (311, 'ENTP', 3);
insert into activity_mbti(id, mbti, activity_id) values (312, 'ENFP', 3);
insert into activity_mbti(id, mbti, activity_id) values (313, 'ESTJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (314, 'ESFJ', 3);
insert into activity_mbti(id, mbti, activity_id) values (315, 'ESTP', 3);
insert into activity_mbti(id, mbti, activity_id) values (316, 'ESFP', 3);


insert into stress_goals(id, accomplish_rate, start_at, end_at)
values (0, 0.0, '2023-04-01T00:00:00', '2023-04-30T23:59:59');
update users
set stress_goal_id = 0
where id = -1;

insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-1, true, null, 0, -1, '2023-04-01T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-2, true, null, 0, -1, '2023-04-02T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-3, true, null, 0, -1, '2023-04-03T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-4, false, null, 0, -1, '2023-04-04T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-5, true, null, 0, -1, '2023-04-05T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-6, true, null, 0, -1, '2023-04-06T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-7, false, null, 0, -1, '2023-04-07T19:00:00');
insert into daily_progresses(id, is_check, health_goal_id, stress_goal_id, user_id, created_at)
values (-8, true, null, 0, -1, '2023-04-08T19:00:00');

-- 랭킹 전용 더미 데이터
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-101, '2023-04-01', 0.0, 71.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-102, '2023-04-02', 20.0, 72.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-103, '2023-04-03', 40.0, 73.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-104, '2023-04-04', 60.0, 74.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-105, '2023-04-05', 80.0, 75.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-106, '2023-04-06', 0.0, 41.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-107, '2023-04-07', 20.0, 42.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-108, '2023-04-08', 40.0, 43.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-109, '2023-04-09', 60.0, 44.0);
insert into health_goals (id, start_at, accomplish_rate, weight_goal)
values (-110, '2023-04-10', 80.0, 45.0);

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

insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-01T12:00:00',true, -101, -101);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-02T12:00:00',true, -101, -101);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-03T12:00:00',true, -101, -101);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-04T12:00:00',true, -101, -101);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-05T12:00:00',true, -101, -101);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-02T12:00:00',true, -102, -102);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-03T12:00:00',false, -102, -102);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-04T12:00:00',false, -102, -102);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-05T12:00:00',false, -102, -102);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, -102, -102);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-03T12:00:00',true, -103, -103);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-04T12:00:00',true, -103, -103);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-05T12:00:00',false, -103, -103);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-06T12:00:00',false, -103, -103);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, -103, -103);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-04T12:00:00',true, -104, -104);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-05T12:00:00',true, -104, -104);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, -104, -104);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, -104, -104);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-08T12:00:00',false, -104, -104);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-05T12:00:00',false, -105, -105);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, -105, -105);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, -105, -105);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-08T12:00:00',true, -105, -105);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, -105, -105);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-06T12:00:00',true, -106, -106);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-07T12:00:00',false, -106, -106);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-08T12:00:00',true, -106, -106);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, -106, -106);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, -106, -106);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-07T12:00:00',true, -107, -107);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-08T12:00:00',true, -107, -107);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-09T12:00:00',false, -107, -107);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, -107, -107);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-11T12:00:00',false, -107, -107);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-08T12:00:00',false, -108, -108);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, -108, -108);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, -108, -108);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-11T12:00:00',true, -108, -108);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-12T12:00:00',false, -108, -108);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-09T12:00:00',true, -109, -109);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-10T12:00:00',true, -109, -109);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-11T12:00:00',true, -109, -109);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-12T12:00:00',true, -109, -109);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-13T12:00:00',true, -109, -109);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-10T12:00:00',false, -110, -110);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-11T12:00:00',false, -110, -110);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-12T12:00:00',true, -110, -110);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-13T12:00:00',false, -110, -110);
insert into daily_progresses(created_at, is_check, health_goal_id, user_id) values ('2023-04-14T12:00:00',false, -110, -110);

insert into boards(id, category) values (0, 'HEALTH'), (1, 'STRESS');

INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '홍길동', 100, 1, 2);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '박준영', 90.5, 2, 5);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '김영호', 85.5, 3, 11);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '최성민', 80.5, 4, 6);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '정기범', 75.5, 5, 7);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '강현우', 70.5, 6, 8);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '장동욱', 65.5, 7, 9);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '이민재', 60.5, 8, 10);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '박지은', 55.5, 9, 12);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', '김수진', 50.5, 10, 13);

INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '박지은', 95.5, 1, 12);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '홍길동', 95, 2, 2);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '박준영', 90, 3, 5);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '김영호', 85, 4, 11);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '최성민', 80, 5, 6);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '정기범', 75, 6, 7);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '강현우', 70, 7, 8);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '장동욱', 65, 8, 9);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '이민재', 60, 9, 10);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-06-12 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', '박지은', 55, 10, 12);

INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '김태현', 89.5, 1, 4);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '홍길동', 89, 2, 2);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '박준영', 79, 3, 5);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '김영호', 69, 4, 11);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '최성민', 59, 5, 6);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '정기범', 49, 6, 7);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '강현우', 39, 7, 8);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '장동욱', 29, 8, 9);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '이민재', 19, 9, 10);
INSERT INTO all_ranking (created_at, updated_at, period, target_date, type, nickname, progress_rate, rank_score, user_id) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', '박지은', 9, 10, 12);

INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'ISTJ', 100, 1);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'ENFP', 90.5, 2);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'ISFP', 85.5, 3);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'INTP', 80.5, 4);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'ESTJ', 75.5, 5);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'INFJ', 70.5, 6);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'ENTP', 65.5, 7);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'ISTP', 60.5, 8);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'INTJ', 55.5, 9);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_DAILY', '2023-06-13', 'MOST_PARTICIPATE', 'ESFJ', 50.5, 10);


INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'ESFP', 95.5, 1);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'ENFJ', 95, 2);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'INFP', 90, 3);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'ENTJ', 85, 4);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'ISTJ', 80, 5);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'ESTP', 75, 6);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'ISFJ', 70, 7);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'INTJ', 65, 8);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'ENTP', 60, 9);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_WEEKLY', '2023-06-05', 'MOST_PARTICIPATE', 'INFJ', 55, 10);


INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'ISTP', 89.5, 1);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'ESTJ', 89, 2);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'ENFP', 79, 3);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'ISFP', 69, 4);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'INTJ', 59, 5);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'INTP', 49, 6);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'ESFJ', 39, 7);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'INFJ', 29, 8);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'ENTP', 19, 9);
INSERT INTO mbti_ranking (created_at, updated_at, period, target_date, type, mbti, progress_rate, rank_score) VALUES ('2023-05-29 00:00:00.000000', '2023-05-29 00:00:00.000000', 'BEFORE_MONTHLY', '2023-05-01', 'MOST_PARTICIPATE', 'ESTP', 9, 10);
