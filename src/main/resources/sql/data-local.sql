insert into users(id, nickname, first_name, last_name, email, profile_image_url, gender, date_of_birth, height, weight, mbti, healthcare_type, stress_point, is_smoking, is_alcohol, created_at, updated_at) values (0, '홍길동!!!', '길동', '홍', 'test@test.com', '', 'MALE', '2023-01-01', 180, 70, 'INTJ', 'HEALTH', 0, false, false, '2023-01-01T00:00:00', '2023-01-01T00:00:00');

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

insert into activities(id, name, symptom) values (1, 'TEST_ACTIVITY', 'LETHARGIC');
insert into activity_mbti(id, mbti, activity_id) values (1, 'INTJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (2, 'INFJ', 1);
insert into activity_mbti(id, mbti, activity_id) values (3, 'INTP', 1);
