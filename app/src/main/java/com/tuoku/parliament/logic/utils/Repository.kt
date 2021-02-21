package com.tuoku.parliament.logic.utils

import com.tuoku.parliament.logic.models.ParliamentMember

object Repository {

        fun randomMember(): ParliamentMember {
            return members.random()
        }

        val members = listOf(
            ParliamentMember(
                hetekaId = 1467,
                seatNumber = 64,
                lastname = "Huru",
                firstname = "Petri",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Huru-Petri-web-v0003-1467.jpg"
            ),
            ParliamentMember(
                hetekaId = 1415,
                seatNumber = 168,
                lastname = "Kemppi",
                firstname = "Hilkka",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kemppi-Hilkka-web-v6614-1415.JPG"
            ),
            ParliamentMember(
                hetekaId = 1394,
                seatNumber = 197,
                lastname = "Keto-Huovinen",
                firstname = "Pihla",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Keto-Huovinen-Pihla-web-v7487-1394.JPG"
            ),
            ParliamentMember(
                hetekaId = 464,
                seatNumber = 20,
                lastname = "Kiljunen",
                firstname = "Kimbe",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kiljunen-Kimmo-web-v7760-464.JPG"
            ),
            ParliamentMember(
                hetekaId = 791,
                seatNumber = 21,
                lastname = "Kiljunen",
                firstname = "Anneli",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kiljunen-Anneli-web-v8182-791.JPG"
            ),
            ParliamentMember(
                hetekaId = 1432,
                seatNumber = 199,
                lastname = "Kilpi",
                firstname = "Marko",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kilpi-Marko-web-v7341-1432.JPG"
            ),
            ParliamentMember(
                hetekaId = 1453,
                seatNumber = 140,
                lastname = "Kinnunen",
                firstname = "Mikko",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kinnunen-Mikko-web-v6707-1453.JPG"
            ),
            ParliamentMember(
                hetekaId = 1137,
                seatNumber = 85,
                lastname = "Kiuru",
                firstname = "Pale",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kiuru-Pauli-web-v8122-1137.JPG"
            ),
            ParliamentMember(
                hetekaId = 1384,
                seatNumber = 128,
                lastname = "Kivelä",
                firstname = "Mai",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kivela-Mai-web-v7260-1384.JPG"
            ),
            ParliamentMember(
                hetekaId = 1340,
                seatNumber = 108,
                lastname = "Kulmuni",
                firstname = "Katri",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kulmuni-Katri-web-v7250-1340.JPG"
            ),
            ParliamentMember(
                hetekaId = 963,
                seatNumber = 39,
                lastname = "Kyllönen",
                firstname = "Mertzi",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kyllonen-Merja-web-v6956-963.JPG"
            ),
            ParliamentMember(
                hetekaId = 1144,
                seatNumber = 70,
                lastname = "Kymäläinen",
                firstname = "Suna",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kymalainen-Suna-web-v8219-1144.JPG"
            ),
            ParliamentMember(
                hetekaId = 1348,
                seatNumber = 111,
                lastname = "Kärnä",
                firstname = "Mikko",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Karna-Mikko-web-v6604-1348.JPG"
            ),
            ParliamentMember(
                hetekaId = 1446,
                seatNumber = 189,
                lastname = "Könttä",
                firstname = "Joonas",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kontta-Joonas-web-v6927-1446.JPG"
            ),
            ParliamentMember(
                hetekaId = 1426,
                seatNumber = 122,
                lastname = "Laakso",
                firstname = "Sheikki",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Laakso-Kristian-Sheikki-web-v7803-1426.JPG"
            ),
            ParliamentMember(
                hetekaId = 1379,
                seatNumber = 177,
                lastname = "Laiho",
                firstname = "Mia",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Laiho-Mia-web-v8407-1379.JPG"
            ),
            ParliamentMember(
                hetekaId = 1343,
                seatNumber = 115,
                lastname = "Laukkanen",
                firstname = "Antzu",
                party = "kd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Laukkanen-Antero-web-v6584-1343.jpg"
            ),
            ParliamentMember(
                hetekaId = 1344,
                seatNumber = 63,
                lastname = "Lehto",
                firstname = "Rami",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Lehto-Rami-web-v6756-1344.JPG"
            ),
            ParliamentMember(
                hetekaId = 1279,
                seatNumber = 149,
                lastname = "Lepomäki",
                firstname = "Ellu",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Lepomaki-Elina-web-v8095-1279.JPG"
            ),
            ParliamentMember(
                hetekaId = 1306,
                seatNumber = 83,
                lastname = "Adlercreutz",
                firstname = "Anders",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Adlercreutz-Anders-web-v7972-1306.JPG"
            ),
            ParliamentMember(
                hetekaId = 1452,
                seatNumber = 167,
                lastname = "Aittakumpu",
                firstname = "Pekka",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Aittakumpu-Pekka-web-v7125-1452.JPG"
            ),
            ParliamentMember(
                hetekaId = 914,
                seatNumber = 24,
                lastname = "Alanko-Kahiluoto",
                firstname = "Outza",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Alanko-Kahiluoto-Outi-web-v7158-914.JPG"
            ),
            ParliamentMember(
                hetekaId = 1310,
                seatNumber = 66,
                lastname = "Andersson",
                firstname = "Li",
                party = "vas",
                minister = true,
                pictureUrl = "attachment/member/pictures/Andersson-Li-web-v8045-1310.JPG"
            ),
            ParliamentMember(
                hetekaId = 1434,
                seatNumber = 151,
                lastname = "Antikainen",
                firstname = "Sanna",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Antikainen-Sanna-web-v6546-1434.JPG"
            ),
            ParliamentMember(
                hetekaId = 917,
                seatNumber = 2,
                lastname = "Arhinmäki",
                firstname = "Pave",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Arhinmaki-Paavo-web-v7598-917.JPG"
            ),
            ParliamentMember(
                hetekaId = 1089,
                seatNumber = 174,
                lastname = "Autto",
                firstname = "Heikki",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Autto-Heikki-web-v8381-1089.JPG"
            ),
            ParliamentMember(
                hetekaId = 1406,
                seatNumber = 144,
                lastname = "Bergqvist",
                firstname = "Sandra",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Bergqvist-Sandra-web-v7186-1406.JPG"
            ),
            ParliamentMember(
                hetekaId = 351,
                seatNumber = 10,
                lastname = "Biaudet",
                firstname = "Eva",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Biaudet-Eva-web-v7586-351.JPG"
            ),
            ParliamentMember(
                hetekaId = 923,
                seatNumber = 53,
                lastname = "Blomqvist",
                firstname = "Thomas",
                party = "r",
                minister = true,
                pictureUrl = "attachment/member/pictures/Blomqvist-Thomas-web-v7897-923.JPG"
            ),
            ParliamentMember(
                hetekaId = 1093,
                seatNumber = 14,
                lastname = "Eerola",
                firstname = "Juho",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Eerola-Juho-web-v8160-1093.JPG"
            ),
            ParliamentMember(
                hetekaId = 1094,
                seatNumber = 31,
                lastname = "Eestilä",
                firstname = "Markku",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Eestila-Markku-web-v7396-1094.JPG"
            ),
            ParliamentMember(
                hetekaId = 1401,
                seatNumber = 76,
                lastname = "Elo",
                firstname = "Tiina",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Elo-Tiina-web-v7107-1401.jpg"
            ),
            ParliamentMember(
                hetekaId = 1096,
                seatNumber = 16,
                lastname = "Elomaa",
                firstname = "Ritu",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Elomaa-Ritva-web-v7770-1096.JPG"
            ),
            ParliamentMember(
                hetekaId = 1430,
                seatNumber = 130,
                lastname = "Eskelinen",
                firstname = "Sepi",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Eskelinen-Seppo-web-v8003-1430.JPG"
            ),
            ParliamentMember(
                hetekaId = 778,
                seatNumber = 54,
                lastname = "Essayah",
                firstname = "Sartsa",
                party = "kd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Essayah-Sari-web-v8260-778.JPG"
            ),
            ParliamentMember(
                hetekaId = 451,
                seatNumber = 3,
                lastname = "Filatov",
                firstname = "Tarde",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Filatov-Tarja-web-v7788-451.JPG"
            ),
            ParliamentMember(
                hetekaId = 1445,
                seatNumber = 105,
                lastname = "Forsgrén",
                firstname = "Bella",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Forsgren-Bella-web-v7225-1445.JPG"
            ),
            ParliamentMember(
                hetekaId = 1100,
                seatNumber = 88,
                lastname = "Grahn-Laasonen",
                firstname = "Sanni",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Grahn-Laasonen-Sanni-web-v8106-1100.JPG"
            ),
            ParliamentMember(
                hetekaId = 116,
                seatNumber = 4,
                lastname = "Gustafsson",
                firstname = "Juki",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Gustafsson-Jukka-web-v7715-116.JPG"
            ),
            ParliamentMember(
                hetekaId = 926,
                seatNumber = 46,
                lastname = "Guzenina",
                firstname = "Maria",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Guzenina-Maria-web-v7746-926.JPG"
            ),
            ParliamentMember(
                hetekaId = 118,
                seatNumber = 6,
                lastname = "Haavisto",
                firstname = "Peksu",
                party = "vihr",
                minister = true,
                pictureUrl = "attachment/member/pictures/Haavisto-Pekka-web-v7627-118.JPG"
            ),
            ParliamentMember(
                hetekaId = 1109,
                seatNumber = 60,
                lastname = "Halla-aho",
                firstname = "Jussi",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Halla-aho-Jussi-web-v7607-1109.JPG"
            ),
            ParliamentMember(
                hetekaId = 1326,
                seatNumber = 101,
                lastname = "Harakka",
                firstname = "Timbe",
                party = "sd",
                minister = true,
                pictureUrl = "attachment/member/pictures/Harakka-Timo-web-v7755-1326.jpg"
            ),
            ParliamentMember(
                hetekaId = 1385,
                seatNumber = 106,
                lastname = "Harjanne",
                firstname = "Atte",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Harjanne-Atte-web-v7646-1385.JPG"
            ),
            ParliamentMember(
                hetekaId = 1328,
                seatNumber = 190,
                lastname = "Harkimo",
                firstname = "Harry",
                party = "liik",
                minister = false,
                pictureUrl = "attachment/member/pictures/Harkimo-Harry-web-v7222-1328.jpg"
            ),
            ParliamentMember(
                hetekaId = 363,
                seatNumber = 7,
                lastname = "Hassi",
                firstname = "Satu",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Hassi-Satu-web-v7696-363.jpg"
            ),
            ParliamentMember(
                hetekaId = 938,
                seatNumber = 52,
                lastname = "Heikkinen",
                firstname = "Hannakaisa",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Heikkinen-Hannakaisa-web-v8270-938.JPG"
            ),
            ParliamentMember(
                hetekaId = 1454,
                seatNumber = 192,
                lastname = "Heikkinen",
                firstname = "Janne",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Heikkinen-Janne-web-v7284-1454.JPG"
            ),
            ParliamentMember(
                hetekaId = 967,
                seatNumber = 55,
                lastname = "Heinonen",
                firstname = "Timo",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Heinonen-Timo-web-v7279-967.JPG"
            ),
            ParliamentMember(
                hetekaId = 1390,
                seatNumber = 159,
                lastname = "Heinäluoma",
                firstname = "Eveliina",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Heinaluoma-Eveliina-web-v6915-1390.JPG"
            ),
            ParliamentMember(
                hetekaId = 941,
                seatNumber = 29,
                lastname = "Henriksson",
                firstname = "Anna-Maja",
                party = "r",
                minister = true,
                pictureUrl = "attachment/member/pictures/Henriksson-Anna-Maja-web-v8298-941.JPG"
            ),
            ParliamentMember(
                hetekaId = 1424,
                seatNumber = 107,
                lastname = "Holopainen",
                firstname = "Hanna",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Holopainen-Hanna-web-v6647-1424.JPG"
            ),
            ParliamentMember(
                hetekaId = 1386,
                seatNumber = 135,
                lastname = "Holopainen",
                firstname = "Mari",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Holopainen-Mari-web-v1581-1386.jpg"
            ),
            ParliamentMember(
                hetekaId = 1383,
                seatNumber = 97,
                lastname = "Honkasalo",
                firstname = "Veronika",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Honkasalo-Veronika-web-v7460-1383.JPG"
            ),
            ParliamentMember(
                hetekaId = 1331,
                seatNumber = 112,
                lastname = "Honkonen",
                firstname = "Petri",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Honkonen-Petri-web-v7089-1331.JPG"
            ),
            ParliamentMember(
                hetekaId = 1402,
                seatNumber = 136,
                lastname = "Hopsu",
                firstname = "Inka",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Hopsu-Inka-web-v7147-1402.JPG"
            ),
            ParliamentMember(
                hetekaId = 1433,
                seatNumber = 142,
                lastname = "Huttunen",
                firstname = "Hanna",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Huttunen-Hanna-web-v6967-1433.JPG"
            ),
            ParliamentMember(
                hetekaId = 1403,
                seatNumber = 137,
                lastname = "Hyrkkö",
                firstname = "Saara",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Hyrkko-Saara-web-v7074-1403.JPG"
            ),
            ParliamentMember(
                hetekaId = 1334,
                seatNumber = 175,
                lastname = "Häkkänen",
                firstname = "Antti",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Hakkanen-Antti-web-v8170-1334.JPG"
            ),
            ParliamentMember(
                hetekaId = 1276,
                seatNumber = 67,
                lastname = "Hänninen",
                firstname = "Katja",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Hanninen-Katja-web-v7706-1276.JPG"
            ),
            ParliamentMember(
                hetekaId = 1421,
                seatNumber = 195,
                lastname = "Ikonen",
                firstname = "Anna-Kaisa",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Ikonen-Anna-Kaisa-web-v7294-1421.JPG"
            ),
            ParliamentMember(
                hetekaId = 1122,
                seatNumber = 37,
                lastname = "Immonen",
                firstname = "Olli",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Immonen-Olli-web-v7393-1122.JPG"
            ),
            ParliamentMember(
                hetekaId = 1056,
                seatNumber = 58,
                lastname = "Jokinen",
                firstname = "Kalle",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Jokinen-Kalle-web-v7995-1056.JPG"
            ),
            ParliamentMember(
                hetekaId = 1409,
                seatNumber = 154,
                lastname = "Junnila",
                firstname = "Vilhelm",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Junnila-Vilhelm-web-v7455-1409.JPG"
            ),
            ParliamentMember(
                hetekaId = 1455,
                seatNumber = 90,
                lastname = "Juuso",
                firstname = "Kaisa",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Juuso-Kaisa-web-v7197-1455.JPG"
            ),
            ParliamentMember(
                hetekaId = 1129,
                seatNumber = 59,
                lastname = "Juvonen",
                firstname = "Arja",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Juvonen-Arja-web-v7378-1129.JPG"
            ),
            ParliamentMember(
                hetekaId = 930,
                seatNumber = 25,
                lastname = "Järvinen",
                firstname = "Heli",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Jarvinen-Heli-web-v1527-930.jpg"
            ),
            ParliamentMember(
                hetekaId = 772,
                seatNumber = 50,
                lastname = "Kaikkonen",
                firstname = "Antti",
                party = "kesk",
                minister = true,
                pictureUrl = "attachment/member/pictures/Kaikkonen-Antti-web-v7924-772.JPG"
            ),
            ParliamentMember(
                hetekaId = 1412,
                seatNumber = 141,
                lastname = "Kalli",
                firstname = "Eeva",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kalli-Eeva-web-v6778-1412.JPG"
            ),
            ParliamentMember(
                hetekaId = 953,
                seatNumber = 49,
                lastname = "Kalmari",
                firstname = "Anne",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kalmari-Anne-web-v8152-953.JPG"
            ),
            ParliamentMember(
                hetekaId = 170,
                seatNumber = 12,
                lastname = "Kanerva",
                firstname = "Ile",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kanerva-Ilkka-web-v8029-170.JPG"
            ),
            ParliamentMember(
                hetekaId = 175,
                seatNumber = 15,
                lastname = "Kankaanniemi",
                firstname = "Toimi",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kankaanniemi_Toimi_web-v0747-175.jpg"
            ),
            ParliamentMember(
                hetekaId = 1133,
                seatNumber = 71,
                lastname = "Kari",
                firstname = "Mika",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kari-Mika-web-v8424-1133.JPG"
            ),
            ParliamentMember(
                hetekaId = 1336,
                seatNumber = 75,
                lastname = "Kari",
                firstname = "Emma",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kari-Emma-web-v7100-1336.JPG"
            ),
            ParliamentMember(
                hetekaId = 1135,
                seatNumber = 116,
                lastname = "Kauma",
                firstname = "Pia",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kauma-Pia-web-v7723-1135.JPG"
            ),
            ParliamentMember(
                hetekaId = 1425,
                seatNumber = 194,
                lastname = "Kaunisto",
                firstname = "Ville",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kaunisto-Ville-web-v7437-1425.JPG"
            ),
            ParliamentMember(
                hetekaId = 1444,
                seatNumber = 129,
                lastname = "Kautto",
                firstname = "Juho",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kautto-Juho-web-v7334-1444.JPG"
            ),
            ParliamentMember(
                hetekaId = 779,
                seatNumber = 26,
                lastname = "Kiviranta",
                firstname = "Esko",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kiviranta-Esko-web-v8054-779.JPG"
            ),
            ParliamentMember(
                hetekaId = 1155,
                seatNumber = 17,
                lastname = "Kontula",
                firstname = "Anna",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kontula-Anna-web-v8081-1155.JPG"
            ),
            ParliamentMember(
                hetekaId = 1341,
                seatNumber = 51,
                lastname = "Kurvinen",
                firstname = "Antti",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kurvinen-Antti-web-v8282-1341.JPG"
            ),
            ParliamentMember(
                hetekaId = 1398,
                seatNumber = 158,
                lastname = "Kvarnström",
                firstname = "Johan",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kvarnstrom-Johan-web-v7810-1398.JPG"
            ),
            ParliamentMember(
                hetekaId = 582,
                seatNumber = 9,
                lastname = "Leppä",
                firstname = "Jari",
                party = "kesk",
                minister = true,
                pictureUrl = "attachment/member/pictures/Leppa-Jari-web-v7179-582.JPG"
            ),
            ParliamentMember(
                hetekaId = 1408,
                seatNumber = 134,
                lastname = "Lindén",
                firstname = "Aki",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Linden-Aki-web-v7816-1408.JPG"
            ),
            ParliamentMember(
                hetekaId = 1147,
                seatNumber = 44,
                lastname = "Lindtman",
                firstname = "Antti",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Lindtman-Antti-web-v7880-1147.JPG"
            ),
            ParliamentMember(
                hetekaId = 583,
                seatNumber = 27,
                lastname = "Lintilä",
                firstname = "Mika",
                party = "kesk",
                minister = true,
                pictureUrl = "attachment/member/pictures/Lintila-Mika-web-v7201-583.JPG"
            ),
            ParliamentMember(
                hetekaId = 1149,
                seatNumber = 80,
                lastname = "Lohi",
                firstname = "Markus",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Lohi-Markus-web-v6627-1149.JPG"
            ),
            ParliamentMember(
                hetekaId = 1399,
                seatNumber = 127,
                lastname = "Lohikoski",
                firstname = "Pia",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Lohikoski-Pia-web-v8359-1399.JPG"
            ),
            ParliamentMember(
                hetekaId = 1410,
                seatNumber = 153,
                lastname = "Lundén",
                firstname = "Mikko",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Lunden-Mikko-web-v6636-1410.JPG"
            ),
            ParliamentMember(
                hetekaId = 1428,
                seatNumber = 160,
                lastname = "Malm",
                firstname = "Niina",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Malm-Niina-web-v8361-1428.JPG"
            ),
            ParliamentMember(
                hetekaId = 1297,
                seatNumber = 100,
                lastname = "Marin",
                firstname = "Sanna",
                party = "sd",
                minister = true,
                pictureUrl = "attachment/member/pictures/Marin-Sanna-web-v8134-1297.JPG"
            ),
            ParliamentMember(
                hetekaId = 1397,
                seatNumber = 162,
                lastname = "al-Taee",
                firstname = "Hussein",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/al-Taee-Hussein-web-v7834-1397.JPG"
            ),
            ParliamentMember(
                hetekaId = 970,
                seatNumber = 102,
                lastname = "Asell",
                firstname = "Marko",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Asell-Marko-web-v7546-970.JPG"
            ),
            ParliamentMember(
                hetekaId = 1443,
                seatNumber = 131,
                lastname = "Berg",
                firstname = "Kim",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Berg-Kim-web-v7560-1443.JPG"
            ),
            ParliamentMember(
                hetekaId = 1099,
                seatNumber = 72,
                lastname = "Eloranta",
                firstname = "Eeva-Johanna",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Eloranta-Eeva-Johanna-web-v6995-1099.JPG"
            ),
            ParliamentMember(
                hetekaId = 538,
                seatNumber = 19,
                lastname = "Haatainen",
                firstname = "Tuula",
                party = "sd",
                minister = true,
                pictureUrl = "attachment/member/pictures/Haatainen-Tuula-web-v7638-538.JPG"
            ),
            ParliamentMember(
                hetekaId = 797,
                seatNumber = 28,
                lastname = "Hoskonen",
                firstname = "Hannu",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Hoskonen-Hannu-web-v7063-797.JPG"
            ),
            ParliamentMember(
                hetekaId = 1468,
                seatNumber = 166,
                lastname = "Kettunen",
                firstname = "Tuomas",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kettunen-Tuomas-web-v1012-1468.jpg"
            ),
            ParliamentMember(
                hetekaId = 960,
                seatNumber = 42,
                lastname = "Kiuru",
                firstname = "Krista",
                party = "sd",
                minister = true,
                pictureUrl = "attachment/member/pictures/Kiuru-Krista-web-v7944-960.JPG"
            ),
            ParliamentMember(
                hetekaId = 1442,
                seatNumber = 138,
                lastname = "Kivisaari",
                firstname = "Pasi",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kivisaari-Pasi-web-v6729-1442.JPG"
            ),
            ParliamentMember(
                hetekaId = 1391,
                seatNumber = 152,
                lastname = "Koponen",
                firstname = "Ari",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Koponen-Ari-web-v6691-1391.JPG"
            ),
            ParliamentMember(
                hetekaId = 1404,
                seatNumber = 163,
                lastname = "Koponen",
                firstname = "Noora",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Koponen-Noora-web-v5744-1404.jpg"
            ),
            ParliamentMember(
                hetekaId = 1142,
                seatNumber = 87,
                lastname = "Kopra",
                firstname = "Jukka",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kopra-Jukka-web-v8188-1142.JPG"
            ),
            ParliamentMember(
                hetekaId = 1413,
                seatNumber = 94,
                lastname = "Koskela",
                firstname = "Jari",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Koskela-Jari-web-v6878-1413.JPG"
            ),
            ParliamentMember(
                hetekaId = 358,
                seatNumber = 23,
                lastname = "Koskinen",
                firstname = "Johannes",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Koskinen-Johannes-web-v6839-358.JPG"
            ),
            ParliamentMember(
                hetekaId = 1338,
                seatNumber = 110,
                lastname = "Kosonen",
                firstname = "Hanna",
                party = "kesk",
                minister = true,
                pictureUrl = "attachment/member/pictures/Kosonen-Hanna-web-v6940-1338.JPG"
            ),
            ParliamentMember(
                hetekaId = 1448,
                seatNumber = 96,
                lastname = "Kotiaho",
                firstname = "Jouni",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Kotiaho-Jouni-web-v6885-1448.JPG"
            ),
            ParliamentMember(
                hetekaId = 1389,
                seatNumber = 198,
                lastname = "Koulumies",
                firstname = "Terhi",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Koulumies-Terhi-web-v7670-1389.JPG"
            ),
            ParliamentMember(
                hetekaId = 1345,
                seatNumber = 82,
                lastname = "Löfström",
                firstname = "Mats",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Lofstrom-Mats-web-v7242-1345.JPG"
            ),
            ParliamentMember(
                hetekaId = 1265,
                seatNumber = 191,
                lastname = "Marttinen",
                firstname = "Matias",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Marttinen-Matias-web-v7302-1265.JPG"
            ),
            ParliamentMember(
                hetekaId = 1382,
                seatNumber = 139,
                lastname = "Mattila",
                firstname = "Hanna-Leena",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Mattila-Hanna-Leena-web-v6714-1382.JPG"
            ),
            ParliamentMember(
                hetekaId = 1349,
                seatNumber = 89,
                lastname = "Meri",
                firstname = "Leena",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Meri-Leena-web-v6944-1349.jpg"
            ),
            ParliamentMember(
                hetekaId = 1298,
                seatNumber = 47,
                lastname = "Mikkonen",
                firstname = "Krista",
                party = "vihr",
                minister = true,
                pictureUrl = "attachment/member/pictures/Mikkonen-Krista-web-v8248-1298.JPG"
            ),
            ParliamentMember(
                hetekaId = 1299,
                seatNumber = 145,
                lastname = "Multala",
                firstname = "Sari",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Multala-Sari-web-v7954-1299.JPG"
            ),
            ParliamentMember(
                hetekaId = 802,
                seatNumber = 1,
                lastname = "Mustajärvi",
                firstname = "Markus",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Mustajarvi-Markus-web-v6810-802.JPG"
            ),
            ParliamentMember(
                hetekaId = 1300,
                seatNumber = 147,
                lastname = "Mykkänen",
                firstname = "Kai",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Mykkanen-Kai-web-v7916-1300.JPG"
            ),
            ParliamentMember(
                hetekaId = 1154,
                seatNumber = 18,
                lastname = "Myllykoski",
                firstname = "Jari",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Myllykoski-Jari-web-v8061-1154.JPG"
            ),
            ParliamentMember(
                hetekaId = 1437,
                seatNumber = 93,
                lastname = "Mäenpää",
                firstname = "Juha",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Maenpaa-Juha-web-v6990-1437.JPG"
            ),
            ParliamentMember(
                hetekaId = 1301,
                seatNumber = 62,
                lastname = "Mäkelä",
                firstname = "Jani",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Makela-Jani-web-v7966-1301.JPG"
            ),
            ParliamentMember(
                hetekaId = 1380,
                seatNumber = 132,
                lastname = "Mäkinen",
                firstname = "Riitta",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Makinen-Riitta-web-v7982-1380.JPG"
            ),
            ParliamentMember(
                hetekaId = 1087,
                seatNumber = 69,
                lastname = "Mäkisalo-Ropponen",
                firstname = "Merja",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Makisalo-Ropponen-Merja-web-v6908-1087.JPG"
            ),
            ParliamentMember(
                hetekaId = 1438,
                seatNumber = 150,
                lastname = "Mäkynen",
                firstname = "Jukka",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Makynen-Jukka-web-v6663-1438.JPG"
            ),
            ParliamentMember(
                hetekaId = 1469,
                seatNumber = 184,
                lastname = "Mäkynen",
                firstname = "Matias",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Makynen-Matias-web-v1248-1469.jpg"
            ),
            ParliamentMember(
                hetekaId = 1418,
                seatNumber = 95,
                lastname = "Niemi",
                firstname = "Veijo",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Niemi-Veijo-web-v6558-1418.JPG"
            ),
            ParliamentMember(
                hetekaId = 1092,
                seatNumber = 34,
                lastname = "Niikko",
                firstname = "Mika",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Niikko-Mika-web-v7871-1092.JPG"
            ),
            ParliamentMember(
                hetekaId = 1440,
                seatNumber = 171,
                lastname = "Norrback",
                firstname = "Anders",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Norrback-Anders-web-v6980-1440.JPG"
            ),
            ParliamentMember(
                hetekaId = 1302,
                seatNumber = 99,
                lastname = "Nurminen",
                firstname = "Ilmari",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Nurminen-Ilmari-web-v7270-1302.JPG"
            ),
            ParliamentMember(
                hetekaId = 1387,
                seatNumber = 164,
                lastname = "Ohisalo",
                firstname = "Maria",
                party = "vihr",
                minister = true,
                pictureUrl = "attachment/member/pictures/Ohisalo-Maria-web-v6852-1387.JPG"
            ),
            ParliamentMember(
                hetekaId = 971,
                seatNumber = 41,
                lastname = "Ojala-Niemelä",
                firstname = "Johanna",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Ojala-Niemela-Johanna-web-v8206-971.jpg"
            ),
            ParliamentMember(
                hetekaId = 1441,
                seatNumber = 170,
                lastname = "Ollikainen",
                firstname = "Mikko",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Ollikainen-Mikko-web-v6769-1441.JPG"
            ),
            ParliamentMember(
                hetekaId = 947,
                seatNumber = 57,
                lastname = "Orpo",
                firstname = "Petteri",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Orpo-Petteri-web-v8073-947.JPG"
            ),
            ParliamentMember(
                hetekaId = 1422,
                seatNumber = 169,
                lastname = "Ovaska",
                firstname = "Jouni",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Ovaska-Jouni-web-v7015-1422.jpg"
            ),
            ParliamentMember(
                hetekaId = 887,
                seatNumber = 43,
                lastname = "Paatero",
                firstname = "Sirpa",
                party = "sd",
                minister = true,
                pictureUrl = "attachment/member/pictures/Paatero-Sirpa-web-v8230-887.JPG"
            ),
            ParliamentMember(
                hetekaId = 1095,
                seatNumber = 178,
                lastname = "Packalén",
                firstname = "Tom",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Packalen-Tom-web-v7423-1095.JPG"
            ),
            ParliamentMember(
                hetekaId = 1097,
                seatNumber = 40,
                lastname = "Pekonen",
                firstname = "Aino-Kaisa",
                party = "vas",
                minister = true,
                pictureUrl = "attachment/member/pictures/Pekonen-Aino-Kaisa-web-v7026-1097.JPG"
            ),
            ParliamentMember(
                hetekaId = 1098,
                seatNumber = 118,
                lastname = "Pelkonen",
                firstname = "Jaana",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Pelkonen-Jaana-web-v7353-1098.JPG"
            ),
            ParliamentMember(
                hetekaId = 1439,
                seatNumber = 181,
                lastname = "Peltokangas",
                firstname = "Mauri",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Peltokangas-Mauri-web-v6822-1439.JPG"
            ),
            ParliamentMember(
                hetekaId = 1405,
                seatNumber = 165,
                lastname = "Petelius",
                firstname = "Pirkka-Pekka",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Petelius-Pirkka-Pekka-web-v7525-1405.JPG"
            ),
            ParliamentMember(
                hetekaId = 1051,
                seatNumber = 103,
                lastname = "Piirainen",
                firstname = "Raimo",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Piirainen-Raimo-web-v7927-1051.JPG"
            ),
            ParliamentMember(
                hetekaId = 1101,
                seatNumber = 79,
                lastname = "Pirttilahti",
                firstname = "Arto",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Pirttilahti-Arto-web-v7217-1101.JPG"
            ),
            ParliamentMember(
                hetekaId = 1449,
                seatNumber = 188,
                lastname = "Pitko",
                firstname = "Jenni",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Pitko-Jenni-web-v7085-1449.JPG"
            ),
            ParliamentMember(
                hetekaId = 1419,
                seatNumber = 125,
                lastname = "Puisto",
                firstname = "Sakari",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Puisto-Sakari-web-v6738-1419.JPG"
            ),
            ParliamentMember(
                hetekaId = 1392,
                seatNumber = 120,
                lastname = "Purra",
                firstname = "Riikka",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Purra-Riikka-web-v7509-1392.JPG"
            ),
            ParliamentMember(
                hetekaId = 1305,
                seatNumber = 109,
                lastname = "Pylväs",
                firstname = "Juha",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Pylvas-Juha-web-v7045-1305.JPG"
            ),
            ParliamentMember(
                hetekaId = 1417,
                seatNumber = 124,
                lastname = "Ranne",
                firstname = "Lulu",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Ranne-Lulu-web-v4001-1417.jpg"
            ),
            ParliamentMember(
                hetekaId = 1388,
                seatNumber = 92,
                lastname = "Rantanen",
                firstname = "Mari",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Rantanen-Mari-web-v6565-1388.JPG"
            ),
            ParliamentMember(
                hetekaId = 1447,
                seatNumber = 161,
                lastname = "Rantanen",
                firstname = "Piritta",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Rantanen-Piritta-web-v7010-1447.JPG"
            ),
            ParliamentMember(
                hetekaId = 1374,
                seatNumber = 143,
                lastname = "Rehn-Kivi",
                firstname = "Veronica",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Rehn-Kivi-Veronica-web-v7238-1374.JPG"
            ),
            ParliamentMember(
                hetekaId = 1435,
                seatNumber = 91,
                lastname = "Reijonen",
                firstname = "Minna",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Reijonen-Minna-web-v6684-1435.JPG"
            ),
            ParliamentMember(
                hetekaId = 1274,
                seatNumber = 45,
                lastname = "Rinne",
                firstname = "Antti",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Rinne-Antti-web-v7738-1274.JPG"
            ),
            ParliamentMember(
                hetekaId = 809,
                seatNumber = 11,
                lastname = "Risikko",
                firstname = "Paula",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Risikko-Paula-web-v8023-809.JPG"
            ),
            ParliamentMember(
                hetekaId = 1308,
                seatNumber = 38,
                lastname = "Ronkainen",
                firstname = "Jari",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Ronkainen-Jari-web-v7440-1308.JPG"
            ),
            ParliamentMember(
                hetekaId = 1282,
                seatNumber = 173,
                lastname = "Rydman",
                firstname = "Wille",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Rydman-Wille-web-v7654-1282.JPG"
            ),
            ParliamentMember(
                hetekaId = 499,
                seatNumber = 30,
                lastname = "Räsänen",
                firstname = "Päivi",
                party = "kd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Rasanen-Paivi-web-v7313-499.JPG"
            ),
            ParliamentMember(
                hetekaId = 1157,
                seatNumber = 77,
                lastname = "Saarikko",
                firstname = "Annika",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Saarikko-Annika-web-v8398-1157.JPG"
            ),
            ParliamentMember(
                hetekaId = 1102,
                seatNumber = 68,
                lastname = "Salonen",
                firstname = "Kristiina",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Salonen-Kristiina-web-v7940-1102.JPG"
            ),
            ParliamentMember(
                hetekaId = 1105,
                seatNumber = 146,
                lastname = "Sankelo",
                firstname = "Janne",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Sankelo-Janne-web-v7407-1105.JPG"
            ),
            ParliamentMember(
                hetekaId = 1400,
                seatNumber = 157,
                lastname = "Saramo",
                firstname = "Jussi",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Saramo-Jussi-web-v6898-1400.JPG"
            ),
            ParliamentMember(
                hetekaId = 1312,
                seatNumber = 65,
                lastname = "Sarkkinen",
                firstname = "Hanna",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Sarkkinen-Hanna-web-v7035-1312.JPG"
            ),
            ParliamentMember(
                hetekaId = 612,
                seatNumber = 32,
                lastname = "Sarkomaa",
                firstname = "Sari",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Sarkomaa-Sari-web-v7589-612.JPG"
            ),
            ParliamentMember(
                hetekaId = 784,
                seatNumber = 13,
                lastname = "Satonen",
                firstname = "Arto",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Satonen-Arto-web-v7571-784.JPG"
            ),
            ParliamentMember(
                hetekaId = 1314,
                seatNumber = 36,
                lastname = "Savio",
                firstname = "Sami",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Savio-Sami-web-v8201-1314.JPG"
            ),
            ParliamentMember(
                hetekaId = 1106,
                seatNumber = 81,
                lastname = "Savola",
                firstname = "Mikko",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Savola-Mikko-web-v7212-1106.JPG"
            ),
            ParliamentMember(
                hetekaId = 1315,
                seatNumber = 98,
                lastname = "Semi",
                firstname = "Matti",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Semi-Matti-web-v7319-1315.JPG"
            ),
            ParliamentMember(
                hetekaId = 1450,
                seatNumber = 155,
                lastname = "Simula",
                firstname = "Jenna",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Simula-Jenna-web-v8321-1450.JPG"
            ),
            ParliamentMember(
                hetekaId = 1108,
                seatNumber = 78,
                lastname = "Sipilä",
                firstname = "Juha",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Sipila-Juha-web-v8346-1108.JPG"
            ),
            ParliamentMember(
                hetekaId = 1219,
                seatNumber = 172,
                lastname = "Sirén",
                firstname = "Saara-Sofia",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Siren-Saara-Sofia-web-v8034-1219.JPG"
            ),
            ParliamentMember(
                hetekaId = 1395,
                seatNumber = 196,
                lastname = "Sjöblom",
                firstname = "Ruut",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Sjoblom-Ruut-web-v7842-1395.JPG"
            ),
            ParliamentMember(
                hetekaId = 1316,
                seatNumber = 133,
                lastname = "Skinnari",
                firstname = "Ville",
                party = "sd",
                minister = true,
                pictureUrl = "attachment/member/pictures/Skinnari-Ville-web-v8115-1316.JPG"
            ),
            ParliamentMember(
                hetekaId = 1393,
                seatNumber = 123,
                lastname = "Slunga-Poutsalo",
                firstname = "Riikka",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Slunga-Poutsalo-Riikka-web-v6591-1393.JPG"
            ),
            ParliamentMember(
                hetekaId = 1416,
                seatNumber = 185,
                lastname = "Soinikoski",
                firstname = "Mirka",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Soinikoski-Mirka-web-v7505-1416.jpg"
            ),
            ParliamentMember(
                hetekaId = 1318,
                seatNumber = 113,
                lastname = "Strand",
                firstname = "Joakim",
                party = "r",
                minister = false,
                pictureUrl = "attachment/member/pictures/Strand-Joakim-web-v7474-1318.JPG"
            ),
            ParliamentMember(
                hetekaId = 1423,
                seatNumber = 186,
                lastname = "Suomela",
                firstname = "Iiris",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Suomela-Iiris-web-v7058-1423.JPG"
            ),
            ParliamentMember(
                hetekaId = 952,
                seatNumber = 74,
                lastname = "Taimela",
                firstname = "Katja",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Taimela-Katja-web-v7890-952.JPG"
            ),
            ParliamentMember(
                hetekaId = 1323,
                seatNumber = 176,
                lastname = "Talvitie",
                firstname = "Mari-Leena",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Talvitie-Mari-Leena-web-v8307-1323.JPG"
            ),
            ParliamentMember(
                hetekaId = 1325,
                seatNumber = 114,
                lastname = "Tanus",
                firstname = "Sari",
                party = "kd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Tanus-Sari-web-v8139-1325.JPG"
            ),
            ParliamentMember(
                hetekaId = 1327,
                seatNumber = 61,
                lastname = "Tavio",
                firstname = "Ville",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Tavio-Ville-web-v6791-1327.JPG"
            ),
            ParliamentMember(
                hetekaId = 1118,
                seatNumber = 86,
                lastname = "Tolvanen",
                firstname = "Kari",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Tolvanen-Kari-web-v7852-1118.JPG"
            ),
            ParliamentMember(
                hetekaId = 1120,
                seatNumber = 48,
                lastname = "Torniainen",
                firstname = "Ari",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Torniainen-Ari-web-v7141-1120.JPG"
            ),
            ParliamentMember(
                hetekaId = 357,
                seatNumber = 5,
                lastname = "Tuomioja",
                firstname = "Erkki",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Tuomioja-Erkki-web-v7682-357.JPG"
            ),
            ParliamentMember(
                hetekaId = 1126,
                seatNumber = 104,
                lastname = "Tuppurainen",
                firstname = "Tytti",
                party = "sd",
                minister = true,
                pictureUrl = "attachment/member/pictures/Tuppurainen-Tytti-web-v7780-1126.jpg"
            ),
            ParliamentMember(
                hetekaId = 1427,
                seatNumber = 179,
                lastname = "Turtiainen",
                firstname = "Ano",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Turtiainen-Ano-web-v0279-1427.jpg"
            ),
            ParliamentMember(
                hetekaId = 1451,
                seatNumber = 126,
                lastname = "Tynkkynen",
                firstname = "Sebastian",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Tynkkynen-Sebastian-web-v6751-1451.JPG"
            ),
            ParliamentMember(
                hetekaId = 1420,
                seatNumber = 180,
                lastname = "Vallin",
                firstname = "Veikko",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Vallin-Veikko-web-v6801-1420.JPG"
            ),
            ParliamentMember(
                hetekaId = 1131,
                seatNumber = 119,
                lastname = "Wallinheimo",
                firstname = "Sinuhe",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Wallinheimo-Sinuhe-web-v7517-1131.JPG"
            ),
            ParliamentMember(
                hetekaId = 414,
                seatNumber = 8,
                lastname = "Vanhanen",
                firstname = "Matti",
                party = "kesk",
                minister = true,
                pictureUrl = "attachment/member/pictures/Vanhanen-Matti-web-v7828-414.JPG"
            ),
            ParliamentMember(
                hetekaId = 1330,
                seatNumber = 148,
                lastname = "Vartiainen",
                firstname = "Juhana",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Vartiainen-Juhana-web-v7327-1330.JPG"
            ),
            ParliamentMember(
                hetekaId = 508,
                seatNumber = 0,
                lastname = "Vehviläinen",
                firstname = "Anu",
                party = "kesk",
                minister = false,
                pictureUrl = "attachment/member/pictures/Vehvilainen-Anu-web-v8263-508.JPG"
            ),
            ParliamentMember(
                hetekaId = 1429,
                seatNumber = 183,
                lastname = "Werning",
                firstname = "Paula",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Werning-Paula-web-v8235-1429.JPG"
            ),
            ParliamentMember(
                hetekaId = 1396,
                seatNumber = 193,
                lastname = "Vestman",
                firstname = "Heikki",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Vestman-Heikki-web-v7365-1396.JPG"
            ),
            ParliamentMember(
                hetekaId = 1436,
                seatNumber = 121,
                lastname = "Wihonen",
                firstname = "Jussi",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Wihonen-Jussi-web-v6580-1436.JPG"
            ),
            ParliamentMember(
                hetekaId = 511,
                seatNumber = 22,
                lastname = "Viitanen",
                firstname = "Pia",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Viitanen-Pia-web-v7116-511.JPG"
            ),
            ParliamentMember(
                hetekaId = 1134,
                seatNumber = 117,
                lastname = "Vikman",
                firstname = "Sofia",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Vikman-Sofia-web-v1234-1134.jpg"
            ),
            ParliamentMember(
                hetekaId = 1414,
                seatNumber = 182,
                lastname = "Viljanen",
                firstname = "Heidi",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Viljanen-Heidi-web-v7713-1414.JPG"
            ),
            ParliamentMember(
                hetekaId = 948,
                seatNumber = 33,
                lastname = "Virolainen",
                firstname = "Anne-Mari",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Virolainen-Anne-Mari-web-v8007-948.JPG"
            ),
            ParliamentMember(
                hetekaId = 1411,
                seatNumber = 187,
                lastname = "Virta",
                firstname = "Sofia",
                party = "vihr",
                minister = false,
                pictureUrl = "attachment/member/pictures/Virta-Sofia-web-v7624-1411.JPG"
            ),
            ParliamentMember(
                hetekaId = 1136,
                seatNumber = 35,
                lastname = "Vähämäki",
                firstname = "Ville",
                party = "ps",
                minister = false,
                pictureUrl = "attachment/member/pictures/Vahamaki-Ville-web-v8334-1136.JPG"
            ),
            ParliamentMember(
                hetekaId = 794,
                seatNumber = 73,
                lastname = "Väätäinen",
                firstname = "Tuula",
                party = "sd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Vaatainen-Tuula-web-v6831-794.JPG"
            ),
            ParliamentMember(
                hetekaId = 1407,
                seatNumber = 156,
                lastname = "Yrttiaho",
                firstname = "Johannes",
                party = "vas",
                minister = false,
                pictureUrl = "attachment/member/pictures/Yrttiaho-Johannes-web-v7543-1407.JPG"
            ),
            ParliamentMember(
                hetekaId = 301,
                seatNumber = 56,
                lastname = "Zyskowicz",
                firstname = "Benkku",
                party = "kok",
                minister = false,
                pictureUrl = "attachment/member/pictures/Zyskowicz-Ben-web-v7674-301.JPG"
            ),
            ParliamentMember(
                hetekaId = 1141,
                seatNumber = 84,
                lastname = "Östman",
                firstname = "Peter",
                party = "kd",
                minister = false,
                pictureUrl = "attachment/member/pictures/Ostman-Peter-web-v8290-1141.JPG"
            ),
        )
    }