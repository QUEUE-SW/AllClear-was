INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (1, 'GENERAL', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 1, 'ALL', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES (1, 40, 'GENERAL', '1333', 1, 'E21_115', '대학생활설계', 'NARAM_YOON', 1),
       (2, 40, 'GENERAL', '1334', 1, 'E21_323', '대학생활설계', 'EUNHEE_PARK', 1),
       (3, 40, 'GENERAL', '1335', 1, 'E21_114', '대학생활설계', 'NARAM_YOON', 1),
       (4, 40, 'GENERAL', '1336', 1, 'E21_323', '대학생활설계', 'SEYOUNG_JANG', 1),
       (5, 40, 'GENERAL', '1337', 1, 'E21_114', '대학생활설계', 'SEONGHO_PARK', 1),
       (6, 40, 'GENERAL', '1338', 1, 'E21_323', '대학생활설계', 'EUNHEE_PARK', 1),
       (7, 40, 'GENERAL', '1332', 1, 'E21_323', '대학생활설계', 'SEYOUNG_JANG', 1),
       (8, 40, 'GENERAL', '1339', 3, 'F04_205', '소프트웨어와인공지능', 'GIBAESUNG', 1),
       (9, 40, 'GENERAL', '1340', 3, 'E21_220', '소프트웨어와인공지능', 'YOUNGDEOK_PARK', 1),
       (10, 40, 'GENERAL', '1341', 3, 'E21_109', '소프트웨어와인공지능', 'SUNGWON_KIM', 1),
       (11, 40, 'GENERAL', '1342', 3, 'E21_109', '소프트웨어와인공지능', 'SUNGWON_KIM', 1),
       (12, 40, 'GENERAL', '1343', 3, 'E21_220', '소프트웨어와인공지능', 'HAENGRAE_CHO', 1),
       (13, 40, 'GENERAL', '1344', 3, 'F04_104', '소프트웨어와인공지능', 'DONGIN_LEE', 1),
       (14, 40, 'GENERAL', '1345', 3, 'C02_320', '실용영어', 'TED_MITCHELL', 1),
       (15, 40, 'GENERAL', '1347', 3, 'C02_323', '실용영어', 'WILL_YAMAGIO', 1),
       (16, 40, 'GENERAL', '1349', 3, 'C02_316', '실용영어', 'TAD_HOON', 1),
       (17, 40, 'GENERAL', '1351', 3, 'C02_321', '실용영어', 'JASON_FERNANDES', 1),
       (18, 40, 'GENERAL', '1353', 3, 'C02_320', '실용영어', 'TED_MITCHELL', 1),
       (19, 40, 'GENERAL', '1355', 3, 'B02_257', '실용영어', 'WONJOO_LEE', 1),
       (20, 40, 'GENERAL', '1346', 3, 'B02_257', '실용영어', 'IMMI_KIM', 1),
       (21, 40, 'GENERAL', '1348', 3, 'C02_321', '실용영어', 'THOMAS_DUBERNEY', 1),
       (22, 40, 'GENERAL', '1350', 3, 'C02_318', '실용영어', 'NICHOLAS_PERITO', 1),
       (23, 40, 'GENERAL', '1352', 3, 'B02_257', '실용영어', 'JISUK_SHIN', 1),
       (24, 40, 'GENERAL', '1354', 3, 'B02_257', '실용영어', 'JUNGSEON_KIM', 1),
       (25, 40, 'GENERAL', '1356', 3, 'C02_317', '실용영어', 'HABBY_WILKERSON', 1),
       (26, 40, 'GENERAL', '1357', 3, 'E21_117', '행렬및행렬식', 'YOONHEE_CHOI', 1),
       (27, 40, 'GENERAL', '1359', 3, 'E21_115', '행렬및행렬식', 'JIHYUN_SEO', 1),
       (28, 40, 'GENERAL', '1361', 3, 'E21_115', '행렬및행렬식', 'YOUNGSU_KWON', 1),
       (29, 40, 'GENERAL', '1358', 3, 'E21_124', '행렬및행렬식', 'SEJUNG_BANG', 1),
       (30, 40, 'GENERAL', '1360', 3, 'E21_112', '행렬및행렬식', 'JIHYUN_SEO', 1);

INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES (1, 'THURSDAY', '09:00:00', '09:50:00', 1),
       (2, 'TUESDAY', '09:00:00', '09:50:00', 2),
       (3, 'WEDNESDAY', '09:00:00', '09:50:00', 3),
       (4, 'WEDNESDAY', '09:00:00', '09:50:00', 4),
       (5, 'THURSDAY', '09:00:00', '09:50:00', 5),
       (6, 'MONDAY', '09:00:00', '09:50:00', 6),
       (7, 'FRIDAY', '09:00:00', '09:50:00', 7),
       (8, 'MONDAY', '10:30:00', '11:50:00', 8),
       (9, 'MONDAY', '15:00:00', '16:20:00', 9),
       (10, 'MONDAY', '16:30:00', '17:50:00', 10),
       (11, 'WEDNESDAY', '16:30:00', '17:50:00', 11),
       (12, 'FRIDAY', '10:30:00', '11:50:00', 12),
       (13, 'MONDAY', '13:30:00', '14:50:00', 13),
       (14, 'WEDNESDAY', '13:30:00', '14:45:00', 14),
       (15, 'FRIDAY', '13:30:00', '14:45:00', 14),
       (16, 'WEDNESDAY', '15:00:00', '16:15:00', 15),
       (17, 'FRIDAY', '15:00:00', '16:15:00', 15),
       (18, 'WEDNESDAY', '13:30:00', '14:45:00', 16),
       (19, 'FRIDAY', '13:30:00', '14:45:00', 16),
       (20, 'WEDNESDAY', '15:00:00', '16:15:00', 17),
       (21, 'FRIDAY', '15:00:00', '16:15:00', 17),
       (22, 'WEDNESDAY', '15:00:00', '16:15:00', 18),
       (23, 'FRIDAY', '15:00:00', '16:15:00', 18),
       (24, 'TUESDAY', '10:30:00', '11:45:00', 19),
       (25, 'THURSDAY', '09:00:00', '10:15:00', 19),
       (26, 'TUESDAY', '15:00:00', '16:15:00', 20),
       (27, 'THURSDAY', '15:00:00', '16:15:00', 20),
       (28, 'WEDNESDAY', '13:30:00', '14:45:00', 21),
       (29, 'FRIDAY', '13:30:00', '14:45:00', 21),
       (30, 'MONDAY', '15:00:00', '16:15:00', 22),
       (31, 'THURSDAY', '10:30:00', '11:45:00', 22),
       (32, 'MONDAY', '12:00:00', '13:15:00', 23),
       (33, 'THURSDAY', '13:30:00', '14:45:00', 23),
       (34, 'WEDNESDAY', '15:00:00', '16:15:00', 24),
       (35, 'THURSDAY', '10:30:00', '11:45:00', 24),
       (36, 'TUESDAY', '09:00:00', '10:15:00', 25),
       (37, 'THURSDAY', '10:30:00', '11:45:00', 25),
       (38, 'MONDAY', '09:00:00', '10:15:00', 26),
       (39, 'WEDNESDAY', '10:30:00', '11:45:00', 26),
       (40, 'TUESDAY', '13:30:00', '14:45:00', 27),
       (41, 'FRIDAY', '12:00:00', '13:15:00', 27),
       (42, 'MONDAY', '12:00:00', '13:15:00', 28),
       (43, 'THURSDAY', '13:30:00', '14:45:00', 28),
       (44, 'MONDAY', '13:30:00', '14:45:00', 29),
       (45, 'THURSDAY', '12:00:00', '13:15:00', 29),
       (46, 'TUESDAY', '15:00:00', '16:15:00', 30),
       (47, 'THURSDAY', '15:00:00', '16:15:00', 30);


--2학년 1학기 컴공

INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (2, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 2, 'CSE', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (31, 40, 'MAJOR', '1362', 3, 'E21_115', '논리회로', 'YOUNGHO_SON', 2),
    (32, 40, 'MAJOR', '1363', 3, 'E21_115', '논리회로', 'YOUNGHO_SON', 2),
    (33, 40, 'MAJOR', '1364', 3, 'E21_115', '논리회로', 'YOUNGHO_SON', 2),
    (34, 40, 'MAJOR', '1365', 1, 'E21_214', '논리회로실험', 'CHANHEUM_PARK', 2),
    (35, 40, 'MAJOR', '1366', 1, 'E21_214', '논리회로실험', 'CHANHEUM_PARK', 2),
    (36, 40, 'MAJOR', '1367', 1, 'E21_214', '논리회로실험', 'HYUNKWAN_HAN', 2),
    (37, 40, 'MAJOR', '1368', 1, 'E21_214', '논리회로실험', 'HYUNKWAN_HAN', 2),
    (38, 40, 'MAJOR', '1369', 2, 'F04_104', '오픈소스SW의이해', 'YEONGSEOK_SEO', 2),
    (39, 40, 'MAJOR', '1370', 2, 'F04_104', '오픈소스SW의이해', 'YEONGSEOK_SEO', 2),
    (40, 40, 'MAJOR', '1371', 2, 'E21_113', '오픈소스SW의이해', 'YEONGSEOK_SEO', 2),
    (41, 40, 'MAJOR', '1372', 3, 'E21_220', '프로그래밍언어', 'JONGHEE_YOON', 2),
    (42, 40, 'MAJOR', '1373', 3, 'E21_220', '프로그래밍언어', 'JONGHEE_YOON', 2),
    (43, 40, 'MAJOR', '1374', 3, 'E21_219', '프로그래밍언어', 'YONGHOON_JANG', 2),
    (44, 40, 'MAJOR', '1375', 3, 'E21_219', '프로그래밍언어', 'SEJONG_LEE', 2),
    (45, 40, 'MAJOR', '3558', 3, 'E21_219', '프로그래밍언어', 'SEJONG_LEE', 2),
    (46, 40, 'MAJOR', '1376', 2, 'E21_123', '공학입문설계', 'BYOUNGCHEOL_AN', 2),
    (47, 40, 'MAJOR', '1377', 2, 'E21_124', '공학입문설계', 'BYOUNGCHEOL_AN', 2),
    (48, 40, 'MAJOR', '1378', 3, 'E21_115', '이산수학', 'CHANGHYUN_PARK', 2),
    (49, 40, 'MAJOR', '1379', 3, 'E21_114', '이산수학', 'CHANGHYUN_PARK', 2);

INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (48, 'TUESDAY', '16:30:00', '17:45:00', 31),
    (49, 'THURSDAY', '16:30:00', '17:45:00', 31),
    (50, 'TUESDAY', '15:00:00', '16:15:00', 32),
    (51, 'THURSDAY', '15:00:00', '16:15:00', 32),
    (52, 'MONDAY', '09:00:00', '10:15:00', 33),
    (53, 'TUESDAY', '10:30:00', '11:45:00', 33),
    (54, 'TUESDAY', '18:00:00', '19:35:00', 34),
    (55, 'THURSDAY', '18:00:00', '19:35:00', 35),
    (56, 'MONDAY', '18:00:00', '19:35:00', 36),
    (57, 'WEDNESDAY', '18:00:00', '19:35:00', 37),
    (58, 'MONDAY', '16:00:00', '17:50:00', 38),
    (59, 'WEDNESDAY', '15:30:00', '17:20:00', 39),
    (60, 'MONDAY', '14:00:00', '15:50:00', 40),
    (61, 'WEDNESDAY', '15:00:00', '16:50:00', 41),
    (62, 'THURSDAY', '14:30:00', '16:20:00', 41),
    (63, 'MONDAY', '12:00:00', '13:50:00', 42),
    (64, 'THURSDAY', '11:00:00', '12:50:00', 42),
    (65, 'TUESDAY', '10:00:00', '11:50:00', 43),
    (66, 'FRIDAY', '09:00:00', '10:50:00', 43),
    (67, 'THURSDAY', '09:00:00', '10:50:00', 44),
    (68, 'FRIDAY', '11:00:00', '12:50:00', 44),
    (69, 'WEDNESDAY', '13:00:00', '14:50:00', 45),
    (70, 'FRIDAY', '13:00:00', '14:50:00', 45),
    (71, 'TUESDAY', '12:30:00', '14:20:00', 46),
    (72, 'TUESDAY', '14:30:00', '16:20:00', 47),
    (73, 'WEDNESDAY', '13:30:00', '14:45:00', 48),
    (74, 'FRIDAY',    '13:30:00', '14:45:00', 48),
    (75, 'TUESDAY',   '16:30:00', '17:45:00', 49),
    (76, 'THURSDAY',  '16:30:00', '17:45:00', 49);

-- 2학년 1학기 정통
INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (3, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 2, 'ICE', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (50, 40, 'MAJOR', '1380', 3, 'E21_113', '공업수학(1)', 'HOYEOL_JUNG', 3),
    (51, 40, 'MAJOR', '3442', 3, 'E21_113', '공업수학(1)', 'HOYEOL_JUNG', 3),
    (52, 40, 'MAJOR', '1382', 3, 'E21_116', '논리회로', 'SUNGWON_KIM', 3),
    (53, 40, 'MAJOR', '1383', 3, 'E21_116', '논리회로', 'SUNGWON_KIM', 3),
    (54, 40, 'MAJOR', '1384', 3, 'E21_319', '프로그래밍언어', 'YOUNGTAK_KIM', 3),
    (55, 40, 'MAJOR', '1385', 3, 'E21_319', '프로그래밍언어', 'YOUNGTAK_KIM', 3),
    (56, 40, 'MAJOR', '1386', 1, 'E21_322', '회로실험(1)', 'SUNGWON_KIM', 3),
    (57, 40, 'MAJOR', '1387', 1, 'E21_322', '회로실험(1)', 'SUNGWON_KIM', 3),
    (58, 40, 'MAJOR', '1388', 3, 'E21_116', '회로이론', 'JINGU_CHOI', 3),
    (59, 40, 'MAJOR', '1389', 3, 'E21_116', '회로이론', 'JINGU_CHOI', 3),
    (60, 40, 'MAJOR', '1390', 2, 'F04_104', '공학입문설계', 'JINGU_CHOI', 3),
    (61, 40, 'MAJOR', '1408', 2, 'F04_104', '공학입문설계', 'JINGU_CHOI', 3);


INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (77, 'MONDAY', '09:00:00', '10:15:00', 50),
    (78, 'WEDNESDAY', '10:30:00', '11:45:00', 50),
    (79, 'MONDAY', '10:30:00', '11:45:00', 51),
    (80, 'WEDNESDAY', '09:00:00', '10:15:00', 51),
    (81, 'TUESDAY', '15:00:00', '16:15:00', 52),
    (82, 'SATURDAY', '09:00:00', '10:15:00', 52),
    (83, 'TUESDAY', '16:30:00', '17:45:00', 53),
    (84, 'SATURDAY', '10:30:00', '11:45:00', 53),
    (85, 'MONDAY', '16:00:00', '17:50:00', 54),
    (86, 'FRIDAY', '10:00:00', '11:50:00', 54),
    (87, 'WEDNESDAY', '16:00:00', '17:50:00', 55),
    (88, 'FRIDAY', '15:00:00', '16:50:00', 55),
    (89, 'MONDAY', '13:30:00', '15:20:00', 56),
    (90, 'WEDNESDAY', '13:30:00', '15:20:00', 57),
    (91, 'MONDAY', '12:00:00', '13:15:00', 58),
    (92, 'THURSDAY', '13:30:00', '14:45:00', 58),
    (93, 'MONDAY', '13:30:00', '14:45:00', 59),
    (94, 'THURSDAY', '12:00:00', '13:15:00', 59),
    (95, 'WEDNESDAY', '13:00:00', '14:50:00', 60),
    (96, 'FRIDAY', '13:00:00', '14:50:00', 61);

-- 2학년 1학기 소융
INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (4, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 2, 'SC', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (62, 40, 'MAJOR', '1406', 3, 'E21_124', '보안기초', 'SEUNGYEOB_NAM', 4),
    (63, 40, 'MAJOR', '1407', 3, 'E21_106', '자바프로그래밍및실습', 'WOOGIL_PARK', 4),
    (64, 40, 'MAJOR', '1390', 2, 'F04_104', '공학입문설계', 'JINGU_CHOI', 4),
    (65, 40, 'MAJOR', '1408', 2, 'F04_104', '공학입문설계', 'JINGU_CHOI', 4),
    (66, 40, 'MAJOR', '1409', 3, 'E21_124', '논리회로', 'SUNGWON_KIM', 4),
    (67, 40, 'MAJOR', '1410', 3, 'E21_124', '이산수학', 'GWONHYOU_CHOI', 4),
    (68, 40, 'MAJOR', '1411', 3, 'E21_112', '통계분석및모델링', 'GONGYOON_SA', 4);

INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (97, 'TUESDAY', '09:00:00', '10:15:00', 62),
    (98, 'FRIDAY', '10:30:00', '11:45:00', 62),
    (99, 'MONDAY', '10:00:00', '11:50:00', 63),
    (100, 'WEDNESDAY', '15:00:00', '16:50:00', 63),
    (101, 'WEDNESDAY', '13:00:00', '14:50:00', 64),
    (102, 'FRIDAY', '13:00:00', '14:50:00', 65),
    (103, 'THURSDAY', '15:00:00', '16:15:00', 66),
    (104, 'SATURDAY', '12:00:00', '13:15:00', 66),
    (105, 'WEDNESDAY', '10:30:00', '11:45:00', 67),
    (106, 'SATURDAY', '10:30:00', '11:45:00', 67),
    (107, 'MONDAY', '15:00:00', '16:15:00', 68),
    (108, 'THURSDAY', '10:30:00', '11:45:00', 68);

-- 3학년 1학기 컴공
INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (5, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 3, 'CSE', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (69, 40, 'MAJOR', '1245', 3, 'E21_221', 'IoT와임베디드소프트웨어', 'SEJONG_LEE', 5),
    (70, 40, 'MAJOR', '1246', 3, 'E21_117', 'IoT와임베디드소프트웨어', 'KYUNGMIN_KIM', 5),
    (71, 40, 'MAJOR', '3397', 3, 'E21_221', 'IoT와임베디드소프트웨어', 'SEJONG_LEE', 5),
    (72, 40, 'MAJOR', '3398', 3, 'E21_117', 'IoT와임베디드소프트웨어', 'KYUNGMIN_KIM', 5),
    (73, 40, 'MAJOR', '1248', 3, 'E21_115', '알고리즘', 'HAENGRAE_CHO', 5),
    (74, 40, 'MAJOR', '1249', 3, 'E21_114', '알고리즘', 'HAENGRAE_CHO', 5),
    (76, 40, 'MAJOR', '1250', 2, 'E21_114', '오픈소스SW설계', 'YEONGSEOK_SEO', 5),
    (77, 40, 'MAJOR', '1251', 2, 'E21_114', '오픈소스SW설계', 'YEONGSEOK_SEO', 5),
    (78, 40, 'MAJOR', '1253', 3, 'E21_117', '운영체제', 'JONGWOOK_KWAK', 5),
    (79, 40, 'MAJOR', '1254', 3, 'E21_117', '운영체제', 'JONGWOOK_KWAK', 5),
    (80, 40, 'MAJOR', '1252', 3, 'E21_109', '운영체제', 'JONGWOOK_KWAK', 5),
    (81, 40, 'MAJOR', '1255', 3, 'E21_109', '컴퓨터네트워크', 'YOUNGDEOK_PARK', 5),
    (82, 40, 'MAJOR', '1256', 3, 'E21_219', '컴퓨터네트워크', 'YOUNGDEOK_PARK', 5),
    (83, 40, 'MAJOR', '1257', 3, 'E21_117', '컴퓨터네트워크', 'YOUNGDEOK_PARK', 5),
    (84, 40, 'MAJOR', '1258', 3, 'E21_220', '컴퓨터네트워크', 'YOUNGDEOK_PARK', 5);

INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (109, 'MONDAY', '18:00:00', '19:35:00', 69),
    (110, 'TUESDAY', '09:00:00', '10:50:00', 69),
    (111, 'TUESDAY', '11:00:00', '12:50:00', 70),
    (112, 'TUESDAY', '18:00:00', '19:35:00', 70),
    (113, 'TUESDAY', '09:00:00', '10:50:00', 71),
    (114, 'WEDNESDAY', '18:00:00', '19:35:00', 71),
    (115, 'TUESDAY', '11:00:00', '12:50:00', 72),
    (116, 'THURSDAY', '18:00:00', '19:35:00', 72),
    (117, 'MONDAY', '08:30:00', '11:45:00', 73),
    (118, 'WEDNESDAY', '09:00:00', '10:15:00', 73),
    (119, 'MONDAY', '16:30:00', '17:45:00', 74),
    (120, 'WEDNESDAY', '16:30:00', '17:45:00', 74),
    (123, 'TUESDAY', '14:30:00', '16:20:00', 76),
    (124, 'THURSDAY', '14:30:00', '16:20:00', 77),
    (125, 'MONDAY', '13:30:00', '14:45:00', 78),
    (126, 'THURSDAY', '12:00:00', '13:15:00', 78),
    (127, 'WEDNESDAY', '13:30:00', '14:45:00', 79),
    (128, 'FRIDAY', '13:00:00', '14:15:00', 79),
    (129, 'TUESDAY', '15:00:00', '16:15:00', 80),
    (130, 'THURSDAY', '15:00:00', '16:15:00', 80),
    (131, 'WEDNESDAY', '13:00:00', '14:50:00', 81),
    (132, 'THURSDAY', '16:00:00', '17:50:00', 81),
    (133, 'WEDNESDAY', '16:00:00', '17:50:00', 82),
    (134, 'FRIDAY', '13:00:00', '15:20:00', 82),
    (135, 'TUESDAY', '13:00:00', '14:50:00', 83),
    (136, 'FRIDAY', '10:30:00', '12:20:00', 83),
    (137, 'TUESDAY', '15:00:00', '16:50:00', 84),
    (138, 'FRIDAY', '11:30:00', '13:20:00', 84);

-- 3학년 1학기 정통
INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (6, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 3, 'ICE', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (85, 40, 'MAJOR', '1392', 3, 'E21_319', '데이터통신및실습', 'SEUNGYEOB_NAM', 6),
    (86, 40, 'MAJOR', '1393', 3, 'E21_319', '데이터통신및실습', 'SEUNGYEOB_NAM', 6),
    (87, 40, 'MAJOR', '1394', 3, 'E21_116', '디지털신호처리', 'GUKYEOL_YOO', 6),
    (88, 40, 'MAJOR', '1395', 3, 'E21_116', '디지털신호처리', 'GUKYEOL_YOO', 6),
    (89, 40, 'MAJOR', '1396', 2, 'E21_113', '오픈소스SW설계', 'SEUNGHOON_JU', 6),
    (90, 40, 'MAJOR', '3512', 3, 'E21_319', '통신시스템', 'GWONHYOU_CHOI', 6),
    (91, 40, 'MAJOR', '3513', 3, 'E21_319', '통신시스템', 'GWONHYOU_CHOI', 6),
    (92, 40, 'MAJOR', '1397', 3, 'E21_116', '알고리즘', 'WOOGIL_PARK', 6),
    (93, 40, 'MAJOR', '1398', 3, 'E21_116', '알고리즘', 'WOOGIL_PARK', 6),
    (94, 40, 'MAJOR', '1399', 3, 'E21_113', '운영체제', 'GYUSANG_CHOI', 6),
    (95, 40, 'MAJOR', '3650', 3, 'E21_114', '운영체제', 'GYUSANG_CHOI', 6);

INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (139, 'TUESDAY', '13:00:00', '14:50:00', 85),
    (140, 'WEDNESDAY', '13:00:00', '14:50:00', 85),
    (141, 'TUESDAY', '15:00:00', '16:50:00', 86),
    (142, 'FRIDAY', '13:00:00', '14:50:00', 86),
    (143, 'MONDAY', '09:00:00', '10:15:00', 87),
    (144, 'WEDNESDAY', '10:30:00', '11:45:00', 87),
    (145, 'MONDAY', '10:30:00', '11:45:00', 88),
    (146, 'WEDNESDAY', '09:00:00', '10:15:00', 88),
    (147, 'FRIDAY', '15:30:00', '17:20:00', 89),
    (148, 'MONDAY', '13:00:00', '14:50:00', 90),
    (149, 'WEDNESDAY', '15:00:00', '16:50:00', 90),
    (150, 'TUESDAY', '13:00:00', '14:50:00', 91),
    (151, 'WEDNESDAY', '13:00:00', '14:50:00', 91),
    (152, 'MONDAY', '15:00:00', '16:15:00', 92),
    (153, 'SATURDAY', '12:00:00', '13:15:00', 92),
    (154, 'THURSDAY', '10:30:00', '11:45:00', 93),
    (155, 'SATURDAY', '13:30:00', '14:45:00', 93),
    (156, 'TUESDAY', '09:00:00', '10:15:00', 94),
    (157, 'SATURDAY', '09:00:00', '10:15:00', 94),
    (158, 'MONDAY', '10:30:00', '11:45:00', 95),
    (159, 'SATURDAY', '10:30:00', '11:45:00', 95);


-- 3학년 1학기 소융
INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (7, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 3, 'SC', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (96, 40, 'MAJOR', '1412', 3, 'E21_124', '딥러닝', 'GWONHYOU_CHOI', 7),
    (97, 40, 'MAJOR', '1247', 3, 'E21_114', '알고리즘', 'HAENGRAE_CHO', 7),
    (98, 40, 'MAJOR', '1252', 3, 'E21_109', '운영체제', 'JONGWOOK_KWAK', 7),
    (99, 40, 'MAJOR', '1414', 3, 'E21_106', '인공지능과컴퓨터비전', 'GUKYEOL_YOO', 7),
    (100, 40, 'MAJOR', '1415', 3, 'E21_109', '빅데이터개론', 'GYUSANG_CHOI', 7),
    (101, 40, 'MAJOR', '1416', 3, 'E21_124', '웹프로그래밍', 'YOUNGTAK_KIM', 7);

INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (160, 'THURSDAY', '13:30:00', '14:45:00', 96),
    (161, 'SATURDAY', '09:00:00', '10:15:00', 96),
    (162, 'MONDAY', '15:00:00', '16:15:00', 97),
    (163, 'THURSDAY', '10:30:00', '11:45:00', 97),
    (164, 'TUESDAY', '15:00:00', '16:15:00', 98),
    (165, 'THURSDAY', '15:00:00', '16:15:00', 98),
    (166, 'TUESDAY', '10:30:00', '11:45:00', 99),
    (167, 'THURSDAY', '09:00:00', '10:15:00', 99),
    (168, 'MONDAY', '09:00:00', '10:15:00', 100),
    (169, 'WEDNESDAY', '10:30:00', '11:45:00', 100),
    (170, 'MONDAY', '10:30:00', '11:45:00', 101),
    (171, 'WEDNESDAY', '09:00:00', '10:15:00', 101);


-- 4학년 1학기 컴공
INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (8, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 4, 'CSE', 'FIRST');


INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (102, 40, 'MAJOR', '1259', 2, 'E21_114', 'MIDAS종합설계(1)', 'JONGHEE_YOON', 8),
    (103, 40, 'MAJOR', '1260', 2, 'E21_114', 'MIDAS종합설계(1)', 'JONGHEE_YOON', 8),
    (104, 40, 'MAJOR', '1261', 2, 'E21_111', 'MIDAS종합설계(1)', 'JONGHEE_YOON', 8),
    (105, 40, 'MAJOR', '1262', 2, 'E21_114', '네트워크보안과블록체인', 'HAENGRAE_CHO', 8),
    (106, 40, 'MAJOR', '1263', 3, 'E21_220', '산업체요구문제연구', 'CHANGHYUN_PARK', 8),
    (107, 40, 'MAJOR', '1769', 3, 'B02_152', '상업정보교재연구및지도법', 'SANGHEUM_YOON', 8),
    (108, 40, 'MAJOR', '1264', 2, 'E21_219', '웹프로그래밍', 'JONGHEE_YOON', 8),
    (109, 40, 'MAJOR', '1265', 2, 'E21_220', '웹프로그래밍', 'JONGHEE_YOON', 8),
    (110, 40, 'MAJOR', '1266', 3, 'E21_109', '인공지능', 'CHANGHYUN_PARK', 8),
    (111, 40, 'MAJOR', '3630', 3, 'E21_114', '인공지능', 'SEJONG_LEE', 8);


INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (172, 'TUESDAY', '18:00:00', '19:35:00', 102),
    (173, 'FRIDAY', '18:00:00', '19:35:00', 103),
    (174, 'SATURDAY', '13:30:00', '15:20:00', 104),
    (175, 'THURSDAY', '18:00:00', '19:35:00', 105),
    (176, 'MONDAY', '18:00:00', '20:25:00', 106),
    (177, 'WEDNESDAY', '18:50:00', '22:05:00', 107),
    (178, 'MONDAY', '14:30:00', '16:20:00', 108),
    (179, 'WEDNESDAY', '13:00:00', '14:50:00', 109),
    (180, 'WEDNESDAY', '15:00:00', '16:15:00', 110),
    (181, 'FRIDAY', '15:00:00', '16:15:00', 110),
    (182, 'MONDAY', '09:00:00', '10:15:00', 111),
    (183, 'WEDNESDAY', '10:30:00', '11:45:00', 111);

-- 4학년 1학기 정통
INSERT INTO course_info (course_info_id, category, college, department, grade, major, semester)
VALUES (9, 'MAJOR', 'DIGITAL_CONVERGENCE', 'COMPUTER_SCIENCE_AND_ENGINEERING', 4, 'ICE', 'FIRST');

INSERT INTO course (course_id, capacity, category, course_code, credit, location, name, professor, course_info_id)
VALUES
    (112, 40, 'MAJOR', '1400', 2, 'E21_113', 'MIDAS종합설계(1)', 'DONGIN_LEE', 9),
    (113, 40, 'MAJOR', '3390', 2, 'E21_116', 'MIDAS종합설계(1)', 'DONGIN_LEE', 9),
    (114, 40, 'MAJOR', '1011', 3, 'E29_254', '공업교육론', 'TAEHWAN_OH', 9),
    (115, 40, 'MAJOR', '1401', 2, 'E21_116', '네트워크보안', 'WOOGIL_PARK', 9),
    (116, 40, 'MAJOR', '3523', 2, 'E21_112', '모바일통신', 'SUJEONG_HEO', 9),
    (117, 40, 'MAJOR', '1402', 2, 'F04_104', '빅데이터응용', 'GYUSANG_CHOI', 9),
    (118, 40, 'MAJOR', '1403', 2, 'E21_106', '인공지능응용', 'GUKYEOL_YOO', 9),
    (119, 40, 'MAJOR', '1404', 2, 'E21_106', '인공지능응용', 'GUKYEOL_YOO', 9),
    (120, 40, 'MAJOR', '1405', 3, 'E21_113', '컴퓨터비전', 'HOYEOL_JUNG', 9);

INSERT INTO course_time (course_time_id, day_of_week, start_time, end_time, course_id)
VALUES
    (184, 'WEDNESDAY', '13:00:00', '14:50:00', 112),
    (185, 'WEDNESDAY', '15:00:00', '16:50:00', 113),
    (186, 'TUESDAY', '18:00:00', '21:15:00', 114),
    (187, 'TUESDAY', '13:00:00', '14:50:00', 115),
    (188, 'TUESDAY', '10:00:00', '11:50:00', 116),
    (189, 'FRIDAY', '09:30:00', '10:20:00', 117),
    (190, 'SATURDAY', '13:00:00', '13:50:00', 117),
    (191, 'MONDAY', '13:30:00', '15:20:00', 118),
    (192, 'MONDAY', '15:30:00', '17:20:00', 119),
    (193, 'TUESDAY', '15:00:00', '16:15:00', 120),
    (194, 'THURSDAY', '15:00:00', '16:15:00', 120);