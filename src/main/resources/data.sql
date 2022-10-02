CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
DELETE FROM position;
DELETE FROM player;
INSERT INTO position VALUES (uuid_generate_v1(), 'GK'),
                            (uuid_generate_v1(), 'DEF'),
                            (uuid_generate_v1(), 'MID'),
                            (uuid_generate_v1(), 'FW')
;


INSERT INTO match_type(id, value)
VALUES
(uuid_generate_v1(), 'CASUAL'),
(uuid_generate_v1(), 'FRIENDLY'),
(uuid_generate_v1(), 'LEAGUE')
;
INSERT INTO venue_type(id, value)
VALUES
       ( uuid_generate_v1(), 'INDOOR'),
       ( uuid_generate_v1(), 'OUTDOOR')
;
INSERT INTO uniform_color(id, value)
VALUES
( uuid_generate_v1(), 'BLACK'),
( uuid_generate_v1(), 'WHITE'),
( uuid_generate_v1(), 'RED')
;
INSERT INTO nationality(id, value)
VALUES
( uuid_generate_v1(), 'IRAQ'),
( uuid_generate_v1(), 'LIBYA'),
( uuid_generate_v1(), 'IRAN'),
( uuid_generate_v1(), 'SAUDI_ARABIA'),
( uuid_generate_v1(), 'PALESTINE'),
( uuid_generate_v1(), 'SUDAN')
;

INSERT INTO venue(id,name, address, venue_type)
VALUES
(
 uuid_generate_v1(),
 'South Run RECenter',
 '7500 Reservation Drive, Springfield, VA',
 (select id from venue_type where value = 'INDOOR')
);
INSERT INTO venue(id,name, address, venue_type)
VALUES
(
    uuid_generate_v1(),
    'Dulles Sportsplex',
    '21610 Atlantic Blvd, Sterling, VA',
    (select id from venue_type where value = 'INDOOR')
);
INSERT INTO venue(id,name, address, venue_type)
VALUES
(
    uuid_generate_v1(),
    'NZone',
    '14550 Lee Rd, Chantilly, VA',
    (select id from venue_type where value = 'INDOOR')
);

INSERT INTO player (first_name, last_name,id, defense, dribble, gk, head, iq, pass, shoot, speed, stamina, team, dob, position,nationality_id, picture) VALUES

(
 'Yousif', 'Basrawi',
 uuid_generate_v1() ,5,5,8,7,5,5,6,5,5,7, NULL,
 (select id from position where value = 'GK')  ,
 (select id from nationality where value ='IRAQ'),NULL
),
(
    'Hussam', 'Ibrahim',
    uuid_generate_v1() ,5,1,5,4,4,4,4,3,4,5, NULL,
    (select id from position where value = 'GK')  ,
    (select id from nationality where value ='IRAQ'),NULL
),
(
 'Ahmed', 'Khalid', uuid_generate_v1(),
 7,7,4,4,8,8,4,5,5,8, '09/26/1985',
 (select id from position where value = 'MF'),
 (select id from nationality where value = 'IRAQ'), NULL
),
(
    'Hashim', 'Talib', uuid_generate_v1(),
    8,6,3,6,7,4,6,5,5,8, '01/01/1986',
    (select id from position where value = 'DF'),
    (select id from nationality where value = 'IRAQ'), NULL
),
(
    'Sufian', 'alAni', uuid_generate_v1(),
    9,7,5,7,7,7,7,7,5,8, '01/01/1984',
    (select id from position where value = 'DF'),
    (select id from nationality where value = 'IRAQ'), NULL
),
(
    'Abdulwahab', 'alHeeti', uuid_generate_v1(),
    8,6,4,6,7,7,7,6,5,8, '01/01/1980',
    (select id from position where value = 'DF'),
    (select id from nationality where value = 'IRAQ'), NULL
),
(
    'Ibraheem', 'alAni', uuid_generate_v1(),
    4,8,5,5,4,4,8,8,6,4, '01/01/2000',
    (select id from position where value = 'FW'),
    (select id from nationality where value = 'IRAQ'), NULL
),
(
    'Maysara', 'alJumaily', uuid_generate_v1(),
    4,8,5,5,4,4,8,8,6,4, '01/01/2000',
    (select id from position where value = 'FW'),
    (select id from nationality where value = 'IRAQ'), NULL
),
(
    'Aziz', 'Saudi', uuid_generate_v1(),
    4,8,5,5,4,4,8,8,6,4, NULL,
    (select id from position where value = 'FW'),
    (select id from nationality where value = 'SAUDI ARABIA'), NULL
)
;

/*
c0d42c07-1e18-42e8-b343-fe9b06f7fcba,3,2,2,3,2,2,DEF,2,3,3,3,NULL,Rami,Shamout,NULL

9d1b3573-c2ce-494b-b37f-1793d4f1ffb8,4,3,2,2,3,3,DEF,2,3,2,4,NULL,Ahmed,Khalid,NULL
ab4d439b-217a-444e-ba72-6ac79d302ad9,3,2,5,3,3,3,GK,2,2,2,3,NULL,Yousif,Basrawi,NULL
abcf5813-24a4-45cb-8fe2-e8b56019e8eb,5,3,3,4,3,3,DEF,4,3,3,3,NULL,Sufian,alAni,NULL
d26969df-9eb2-4b99-b892-2071849bbde7,1,2,2,2,3,3,FW,3,1,2,3,NULL,Mustafa,alKenani,NULL
a630a853-b21c-4415-a1c2-90991ff97bd8,3,4,2,2,2,2,GK,4,5,4,2,NULL,Ibraheem,alAni,NULL
62582792-b9d5-4580-8796-23091351a525,5,3,2,3,3,3,DEF,3,3,3,4,NULL,Abdulwahab,alHeeti,NULL
3720b728-1e89-447e-bd0f-b083d3bfe203,4,2,2,3,2,3,GK,2,2,2,3,NULL,Parham,Tabibi,NULL

62048c40-3461-4cf5-acd6-f5c3bd2b648f,3,4,3,2,2,2,MID,3,2,1,3,NULL,Maysara,alJumaily,NULL
d1466f07-fa13-4eaa-be11-792eeffb61ce,2,4,3,2,3,3,GK,4,4,3,2,NULL,Ali,Fouladi,NULL
40cd083a-653c-418b-826e-cd18cd10d92f,3,3,2,2,2,3,GK,3,3,3,3,NULL,Yousif,alTuraihy,NULL
ff10ac7f-7b32-4d10-a8ba-d38644cda2d8,3,2,2,3,1,2,GK,3,3,4,3,NULL,Bahaa,alTuraihy,NULL
a2406809-fd40-48fe-8611-7c90728d11dd,2,3,3,3,3,3,FW,4,3,3,3,NULL,Hussam,Karmah,NULL
a051073c-98b7-4b10-8786-c1bcbe0a497d,3,3,2,3,2,2,GK,4,4,3,2,NULL,Michael,Zoidze,NULL
b53d4f67-8e3f-4fde-b8bc-01db32711eb2,3,4,4,3,3,3,MID,3,4,4,3,NULL,Osama,Shamout,NULL
bcf4c42b-d01d-4a8e-857e-e60d8cd76600,2,4,2,3,3,3,FW,3,1,2,3,NULL,Zaid,Hillawi,NULL

6269c397-0adf-4677-abea-db5b7073a65b,3,2,4,3,2,2,FW,4,4,3,2,NULL,Ali,alDubaisi,NULL
d0a628af-5c21-44df-a63b-0e202ee81184,3,2,4,3,2,2,GK,2,2,2,3,NULL,Taif,Allawi,NULL
581e2b64-1c46-4a7e-bdc5-a8dac9b4ad43,2,4,3,3,3,3,MID,3,3,2,3,NULL,Sherif,alSafty,NULL
 */