--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2019-05-27 13:41:18 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 3242 (class 0 OID 699868)
-- Dependencies: 207
-- Data for Name: auteur; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (1, 'Rabelais', 'Auteur français né en 1483 à Chinon. Il est décédé le 9 avril 1553 à Paris.', 'https://www.senscritique.com/contact/Francois_Rabelais/136510');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (8, 'George Orwell', 'Auteur et scénariste britannique né le 25 juin 1903 à Motihari. Il est décédé le 21 janvier 1950 à Londres', 'https://fr.wikipedia.org/wiki/George_Orwell');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (2, 'Moore', 'Auteur britannique né le 7 février 1478 à London.', 'https://www.senscritique.com/contact/Thomas_More/506339');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (10, 'Alfred de Musset', 'Auteur, traducteur et illustrateur.', 'https://fr.wikipedia.org/wiki/Alfred_de_Musset');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (3, 'Du Bellay', 'Joachim du Bellay ou Joachim Du Bellay est un poète français né vers 1522 à Liré en Anjou et mort le 1 janvier 1560 .', 'https://fr.wikipedia.org/wiki/Joachim_du_Bellay');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (12, 'Ken Follett', 'Auteur, créateur et producteur britannique né le 5 juin 1949 à Cardiff.', 'https://fr.wikipedia.org/wiki/Ken_Follett');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (11, 'Harlan Coben', 'Auteur, scénariste, créateur, producteur et acteur américain né le 4 janvier 1962 à Newark.', 'https://www.senscritique.com/contact/Harlan_Coben/92279');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (4, 'Montesquieu', 'Auteur français né le 18 janvier 1689 à La Brède. Il est décédé le 10 février 1755 à Paris.', 'https://fr.wikipedia.org/wiki/Montesquieu');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (7, 'Maupassant', 'Auteur et scénariste français de France. Il est décédé à Passy.', 'https://fr.wikipedia.org/wiki/Guy_de_Maupassant');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (9, 'Choderlos de Laclos', 'Auteur et scénariste.', 'https://fr.wikipedia.org/wiki/Pierre_Choderlos_de_Laclos');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (5, 'Baudelaire', 'Auteur et traducteur français né le 9 avril 1821 à Paris. Il est décédé le 31 août 1867 à Paris.', 'https://fr.wikipedia.org/wiki/Charles_Baudelaire');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (13, 'Stephen king', 'genre simpas', 'http://www.stephenking.com/');
INSERT INTO auteur (id, intitule_auteur, description_auteur, lienweb) VALUES (6, 'Victor Hugo', 'Auteur, scénariste et réalisateur français né le 26 février 1802 à Besançon. Il est décédé le 22 mai 1885 à Paris', 'https://fr.wikipedia.org/wiki/Victor_Hugo');


--
-- TOC entry 3244 (class 0 OID 699879)
-- Dependencies: 209
-- Data for Name: bibliotheque; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO bibliotheque (id, intitulebibliotheque, adresse, codepostal, ville, telephone) VALUES (1, 'Librairie des Acacias', '14 rue des Tilleuls', '33145', 'Bordeaux CX', '0456443322');
INSERT INTO bibliotheque (id, intitulebibliotheque, adresse, codepostal, ville, telephone) VALUES (2, 'Librairie de Bosquets', '34 rue des auffes', '33122', 'Bordeaux CX', '0433223333');
INSERT INTO bibliotheque (id, intitulebibliotheque, adresse, codepostal, ville, telephone) VALUES (3, 'Librairie des hallebardes', '12 rue du chemin', '33123', 'Bordeaux CX', '0422112234');


--
-- TOC entry 3232 (class 0 OID 699816)
-- Dependencies: 197
-- Data for Name: lecteur; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (3, 'ayaa', 'Remann', 'Henri', 'R44E3', '2018-10-23', '1987-10-11', NULL);
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (4, 'cosakE', 'Favert', 'Roger', 'Fav764', '2018-10-11', '1985-10-13', NULL);
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (7, 'vienvien', 'Esteban', 'Vivien', '3423', '2018-05-11', '1980-06-09', NULL);
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (10, 'altavisattaa', 'xiam', 'Francis', '34ER443', '2012-11-11', '1988-11-11', NULL);
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (1, 'gold43', 'Robert', 'Andre', '$2a$10$a482wLfG8D/VEnkY64FXPuD/U0zQ0A77jtPlTN8vwUKCxx7xCp.Q2', '2018-11-11', '1987-11-11', NULL);
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (9, 'cave23', 'vlaria', 'Rachid', '23ETB3432', NULL, NULL, 'TR432FDS');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (6, 'toutamoi', 'bernardidi', 'Francois', '$2a$10$vQmi/9WSyljeutBkYt5dWuICvr074jjs3L20G0KGGWpR4ZU9uMQjW', '2019-03-25', '2019-03-25', 'jkljlk');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (5, 'papaoute', 'cetal', 'Eric', '$2a$10$1JzL3YM/zP6MxNaoB9JsYOAoLR4aX1gplFNpcYrEqSh3XVGtnL3DS', '2019-03-25', '2019-03-25', 'jkljlk');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (8, 'Eretra12', 'mira', 'Didier', '$2a$10$9rMI3m1JRDh7Jkm5K3kBjOk9EzqwxWA6VsRzDGcX4birBe3tlPWGO', '2019-03-25', '2019-03-25', 'jkljlk');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (2, 'bon12', 'Kov', 'Serge', '$2a$10$2L0VasmC7HJEBQQNm/LF1uypuRTmH24gPBOn7G/SMGolBJGrDGaG6', '2019-03-29', '2019-03-29', 'jkljlk');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (6091, 'resal34', 'ginest', 'sandrine', '$2a$10$PUp.d7gmbxKgS.2xEVVmP.Ox73jWC6eQLP6VxTBSbAa28YNko/0W2', '2019-04-08', NULL, '34333232');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (6092, 'fono12', 'barab', 'elise', '$2a$10$50itJ1fStaBPFIGQxoFTz.mo5SmcAaWwTf9z/v6mSdhVgP8y7a0Q6', '2019-04-08', NULL, '34333232');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (6093, 'gto2', 'marika', 'claude', '$2a$10$QQ/jDahLmEsuaDCs3HeYFOuLeF6FrkyCcFZ7RvZX4Muzalj7vooPK', '2019-04-09', NULL, '34333232');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (6094, 'oliv23', 'falck', 'olivier', '$2a$10$1tyyBEpRAA/tHuHnVIIoAuHUTW1bIfgXu08qYHv8AuuIqezjXc4ge', '2019-04-10', NULL, '34333232');
INSERT INTO lecteur (id, identifiant, nom, prenom, motdepasse, date_inscription, date_de_naissance, num_cni) VALUES (6095, 'RS32', 'bernard', 'robert', '$2a$10$I7BRGzwuAW/qz0zuptOMqe7Tpxde42vr7buoDQqZ7vZRusRS1cF6m', '2019-05-13', NULL, '34333232');


--
-- TOC entry 3236 (class 0 OID 699838)
-- Dependencies: 201
-- Data for Name: coordonnees; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (291, 'VILLA 4, 7 IMPASSE LES JARDINS OCCITANS', '31450', 'POMPERTUZAT', '0678835444', 'aurelien.mimouni@gmail.com', 6091);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (292, '43 rue des ir', '32444', 'plur', '0544334433', 'rgo@gro.com', 6093);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (7, 'avenue de la paie', '31232', 'Toulouse', '053433212', 'ole@gmail.com', 8);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (3, 'rue des acacias', '31233', 'toulouse', '054333342', 'monmail@gmail.com', 3);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (2, 'rue des roseaux', '31332', 'Toulouse', '0543334432', 'la@hotmail.fr', 2);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (4, 'rue breteuil', '33123', 'Toulouse', '054333344', 'lebon@yahoo.fr', 4);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (8, 'allee francoiis mitterand', '31234', 'toulouse', '056433456', 'lke@gmail.com', 7);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (293, 'VILLA 4, 7 IMPASSE LES JARDINS OCCITANS', '31450', 'POMPERTUZAT', '0678835444', 'aurelien.mimouni@gmail.com', 6094);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (1, 'rue des tilleurs', '31344', 'Blagnac', '0565455533', 'monmail@gmail.com', 1);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (5, 'rue de la graviere', '32122', 'toulouse', '0545223311', 'oloe@gmail.com', 5);
INSERT INTO coordonnees (id, rue, code_postale, ville, telephone, email, lecteurid) VALUES (6, 'rue des champs', '31234', 'toulouse', '0565443344', 'apl@gmail.Com', 6);


--
-- TOC entry 3240 (class 0 OID 699860)
-- Dependencies: 205
-- Data for Name: editeur; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO editeur (id, intitule_editeur, lienweb) VALUES (1, 'France Loisir', 'http://www.franceloisirs.com/');
INSERT INTO editeur (id, intitule_editeur, lienweb) VALUES (2, 'Hachette', 'https://www.hachette.com/fr/accueil/');
INSERT INTO editeur (id, intitule_editeur, lienweb) VALUES (3, 'Actes Sud', 'https://www.actes-sud.fr/');
INSERT INTO editeur (id, intitule_editeur, lienweb) VALUES (4, 'ENI', 'https://www.editions-eni.fr/');
INSERT INTO editeur (id, intitule_editeur, lienweb) VALUES (5, 'Micro Application', 'https://microapp.com/');
INSERT INTO editeur (id, intitule_editeur, lienweb) VALUES (6, 'Gallimard', 'http://www.gallimard.fr/');
INSERT INTO editeur (id, intitule_editeur, lienweb) VALUES (7, 'Folio', 'http://www.folio-lesite.fr/');


--
-- TOC entry 3234 (class 0 OID 699827)
-- Dependencies: 199
-- Data for Name: ouvrage; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (3, 'Oeuvres complètes                                                                                                                                                                                                                                              ', 'Ce volume comprend les poésies y parues de 1551 à 1553 évangélique dans les Œuvres de l invention de l auteur', NULL, '9788074840425', 3);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (7, 'Bel ami                                                                                                                                                                                                                                                        ', 'Le roman retrace l ascension de Georges Duroy, un homme ambitieux et séducteur parvenu au sommet de la pyramide sociale grâce à ses maîtresses.', NULL, '9782013949871', 7);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (12, 'les raisins de la colere                                                                                                                                                                                                                                       ', 'livre roman qui se passe dans les annexe 1950', '', 'REF454ERE', 10);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (11, 'Le Troisième Jumeau                                                                                                                                                                                                                                            ', 'Comment deux vrais jumeaux, dotés du même code ADN, peuvent-ils être nés de parents différents, à des dates différentes ? C est pourtant ce qui arrive à Steve, brillant étudiant en droit, et à Dennis qui purge une peine de prison à vie.', 'Le_Troisieme_Jumeau.jpg', '9782221132432', 12);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (9, 'Ne le dis à personne                                                                                                                                                                                                                                           ', 'Votre femme a été tuée par un serial killer. Huit ans plus tard, vous recevez son visage, filmé en temps réel au milieu d une foule.', 'Ne_le_dis_a_personne.jpg', '9782266207709', 11);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (4, 'Les Lettres Persanes                                                                                                                                                                                                                                           ', 'Usbek entreprend avec Rica un long voyage en Europe jusqu à Paris. il dépeint d’un œil faussement naïf une civilisation lointaine.', 'Lettres_Persanes.jpg', '9782218997568', 4);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (1, 'Gargantua                                                                                                                                                                                                                                                      ', 'Le géant Gargantua, fils de Grandgousier et de Gargamelle, naît de l oreille de celle-ci alors qu elle s est livrée à des excès de table et de boisson. Laissé libre de vivre selon ses désirs jusqu à cinq ans, Gargantua est ensuite confié à Thubal Holoferne', 'Gargantua.jpg', '9782020300322', 1);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (2, 'Utopia                                                                                                                                                                                                                                                         ', 'Dans le livre L Utopie, Thomas More est toujours à la recherche de l idéal en défendant l ouverture d’esprit, l aptitude à lexpérimentation et la discussion pour améliorer la société. Il rêve de créer un État libéral qui permet de satisfaire les besoins de chacun et de faire respecter les droits de chacun. Mais comment faire pour avoir une société égalitaire, juste et heureuse ', 'Utopia.jpg', '9782290170267', 2);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (8, '1984                                                                                                                                                                                                                                                           ', 'De tous les carrefours importants, lBig brother vous regardesser place à d obscurs desseins. Le foncté sur ce livre ', '1984.jpg', '9782070368228', 10);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (6, 'Les Misérables                                                                                                                                                                                                                                                 ', 'Cosette et Marius sont 2 âmes disposées à s aimer. Mais Jean Valjean veille, lui, l ancien bagnard dont Cosette est devenue la seule raison de vivre.', 'Les_Miserables.jpg', '9782010008995', 6);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (10, 'Les Piliers de la Terre                                                                                                                                                                                                                                        ', 'L action se situe dans l Angleterre du XIIème siècle et tourne autour de la construction d une cathédrale par le prieur du village de Kingsbridge', 'Les_Pilliers_de_la_Terre.jpg', '9782253059530', 12);
INSERT INTO ouvrage (id, intitule_ouvrage, description, photo, num_isbn, auteurid) VALUES (5, 'Les Fleurs du mal                                                                                                                                                                                                                                              ', 'Une oeuvre sous forme de recueil de poèmes divisé en six parties : Spleen et idéal, Tableaux parisiens, le Vin, les Fleurs du mal, Révolte et la Mort.  ', 'Les_Fleurs_du_mal.jpg', '9782253007102', 5);


--
-- TOC entry 3248 (class 0 OID 699901)
-- Dependencies: 213
-- Data for Name: edition_ouvrage; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (6, 1, '2018-01-01');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (5, 2, '2010-01-01');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (4, 4, '2011-01-01');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (2, 3, '2019-04-09');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (1, 5, '2019-04-23');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (3, 2, '2019-04-23');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (7, 2, '2019-04-16');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (8, 4, '2019-04-22');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (9, 4, '2014-04-12');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (10, 5, '2019-04-23');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (11, 1, '2019-04-16');
INSERT INTO edition_ouvrage (ouvrageid, editeurid, annee_editions) VALUES (12, 3, '2014-04-16');


--
-- TOC entry 3252 (class 0 OID 699916)
-- Dependencies: 217
-- Data for Name: exemplaire; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (7, 'VIC34RTE22', 2, 1, NULL);
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (2, 'VIC34RTEBG', 1, 1, '1');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (8, 'VICxsE22', 2, 1, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (3, 'VIC34RTE4', 1, 2, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (4, 'VICTGFE22', 1, 1, NULL);
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (5, 'V23DRTE22', 2, 1, '1');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (1, 'VIC34RTEBZ', 1, 1, NULL);
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (6, 'VIFREFTE22', 2, 1, NULL);
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (16, 'POFFFRRFR', 6, 1, '');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (11, 'FIFDSDREZER', 3, 3, '1');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (18, 'VFEVFV', 7, 3, NULL);
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (19, 'IVFVVFFVF', 8, 3, '');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (9, 'VICFEZRRTE22', 3, 1, NULL);
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (15, 'VIFRFF', 5, 2, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (12, 'FIROTGEER', 4, 2, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (20, 'IFDFGDFGFDGFDFDG', 9, 2, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (17, 'BONFFHREI', 6, 2, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (10, 'VICDEZDEZ', 3, 2, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (14, 'LGFOGRER', 5, 3, '99');
INSERT INTO exemplaire (id, referenceinterne, ouvrageid, bibliothequeid, status) VALUES (13, 'MERIDDZ', 4, 2, '99');


--
-- TOC entry 3246 (class 0 OID 699890)
-- Dependencies: 211
-- Data for Name: situation_emprunt; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO situation_emprunt (id, situation) VALUES (1, 'Rendu');
INSERT INTO situation_emprunt (id, situation) VALUES (2, 'En cours');
INSERT INTO situation_emprunt (id, situation) VALUES (3, 'Prolongés');
INSERT INTO situation_emprunt (id, situation) VALUES (4, 'Non rendus à temps');
INSERT INTO situation_emprunt (id, situation) VALUES (99, 'Non dispo');


--
-- TOC entry 3250 (class 0 OID 699908)
-- Dependencies: 215
-- Data for Name: emprunt; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (7, '2018-12-12', '2019-01-21', NULL, '0', 4, 8, 8);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (56, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 9, 3);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (55, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 7, 2);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (18, '2018-12-12', '2019-01-21', NULL, '0', 3, 17, 2);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (54, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 18, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (5, '2018-12-12', '2019-01-21', '2019-01-21', '0', 1, 7, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (47, '2019-05-06', '2019-06-15', '2019-06-16', '1', 1, 16, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (28, '2018-12-12', '2019-01-21', '2019-06-21', '1', 3, 20, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (17, '2018-12-12', '2019-01-21', '2019-06-21', '1', 3, 8, 6);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (9, '2018-12-12', '2019-01-21', '2019-06-21', '1', 3, 6, 2);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (6, '2018-12-12', '2019-01-21', NULL, '1', 4, 9, 9);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (14, '2018-12-12', '2019-01-21', '2019-06-21', '1', 3, 2, 7);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (31, '2018-12-12', '2019-01-21', NULL, '0', 4, 4, 7);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (57, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 1, 4);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (26, '2018-12-12', '2019-01-21', NULL, '0', 4, 9, 3);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (50, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 1, 8);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (61, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 2, 9);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (62, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 4, 9);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (59, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 1, 6);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (32, '2018-12-12', '2019-01-21', NULL, '0', 1, 5, 9);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (58, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 2, 2);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (2, '2018-01-01', '2018-02-01', '2018-03-01', '1', 3, 12, 3);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (48, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 2, 10);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (24, '2018-12-12', '2019-01-21', NULL, '0', 4, 10, 10);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (20, '2018-12-12', '2019-01-21', NULL, '0', 4, 3, 5);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (49, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 12, 3);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (53, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 2, 6);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (1, '2019-02-05', '2019-02-21', '2019-03-21', '0', 1, 4, 10);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (21, '2018-12-12', '2019-01-21', NULL, '0', 4, 8, 7);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (4, '2018-12-12', '2019-01-21', '2019-01-21', '0', 1, 4, 8);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (8, '2018-12-12', '2019-01-21', NULL, '1', 4, 7, 5);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (60, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 2, 3);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (33, '2018-12-12', '2019-01-21', NULL, '0', 3, 6, 3);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (30, '2018-12-12', '2019-01-21', NULL, '0', 4, 11, 7);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (19, '2018-12-12', '2019-01-21', NULL, '0', 4, 6, 4);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (3, '2018-12-12', '2019-01-21', NULL, '1', 4, 3, 7);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (11, '2018-12-01', '2018-01-31', NULL, '0', 1, 2, 4);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (13, '2018-12-12', '2019-01-21', NULL, '1', 3, 1, 5);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (52, '2019-05-06', '2019-06-15', '2019-06-15', '1', 2, 1, 7);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (12, '2019-12-01', '2019-01-28', '2019-01-28', '0', 1, 3, 6);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (70, '2019-05-13', '2019-06-22', '2019-06-22', '0', 2, 4, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (71, '2019-05-13', '2019-06-22', '2019-06-22', '0', 2, 18, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (72, '2019-05-13', '2019-06-22', '2019-06-22', '0', 2, 20, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (73, '2019-05-13', '2019-06-22', '2019-06-22', '0', 2, 4, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (74, '2019-05-13', '2019-06-22', '2019-06-22', '0', 2, 1, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (75, '2019-05-13', '2019-06-22', '2019-06-22', '0', 2, 12, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (76, '2019-05-13', '2019-06-22', '2019-06-22', '0', 2, 20, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (69, '2019-05-13', '2019-06-22', '2019-06-22', '1', 4, 14, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (67, '2019-05-13', '2019-06-22', '2019-06-24', '1', 4, 2, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (77, '2019-05-20', '2019-06-29', '2019-06-29', '0', 2, 17, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (78, '2019-05-21', '2019-06-30', '2019-06-30', '0', 2, 10, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (79, '2019-05-21', '2019-06-30', '2019-06-30', '0', 2, 14, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (80, '2019-06-30', '2019-06-30', '2019-06-30', '0', 2, 13, 1);
INSERT INTO emprunt (id, date_debut, date_fin, date_retour_effectif, renouvellement, situation_empruntid, exemplaireid, lecteurid) VALUES (68, '2019-05-13', '2019-06-22', '2019-07-06', '1', 4, 4, 1);


--
-- TOC entry 3238 (class 0 OID 699849)
-- Dependencies: 203
-- Data for Name: genre; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO genre (id, intitule_genre, description_genre, webographie) VALUES (1, 'Renaissance', ' occidentale durant la Renaissance artistique.La Renaissance est une période de l époque moderne associée à la redécouverte de la littérature, de la philosophie et des sciences de l Antiquité,', 'https://en.wikipedia.org/wiki/Renaissance');
INSERT INTO genre (id, intitule_genre, description_genre, webographie) VALUES (2, 'Distopie', 'Une dystopie est un récit de fiction dépeignant une société imaginaire organisée de telle façon qu elle empêche ses membres d atteindre le bonheur.', 'https://fr.wikipedia.org/wiki/Dystopie');
INSERT INTO genre (id, intitule_genre, description_genre, webographie) VALUES (3, 'Poesie', ' Manuscrit du poème Les Assis d’Arthur Rimbaud recopié par Paul Verlaine. La poésie est un genre littéraire très ancien aux formes variées, écrites généralement en vers mais qui admettent aussi la prose, et qui privilégient l expressivité de la forme, ', 'https://fr.wikipedia.org/wiki/Po%C3%A9sie');
INSERT INTO genre (id, intitule_genre, description_genre, webographie) VALUES (4, 'Roman', 'genre littéraire produisant des œuvres d imagination', 'https://fr.wikipedia.org/wiki/Roman#Oeuvre_litt%C3%A9raire');
INSERT INTO genre (id, intitule_genre, description_genre, webographie) VALUES (5, 'Théatre', 'Il s agit de spectacles dans lesquels des comédiens, mis dans les circonstances et les situations créées par un texte', 'https://fr.wikipedia.org/wiki/Th%C3%A9%C3%A2tre');


--
-- TOC entry 3247 (class 0 OID 699896)
-- Dependencies: 212
-- Data for Name: ouvrage_genre; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO ouvrage_genre (ouvrageid, genreid) VALUES (1, 4);
INSERT INTO ouvrage_genre (ouvrageid, genreid) VALUES (2, 4);
INSERT INTO ouvrage_genre (ouvrageid, genreid) VALUES (5, 3);
INSERT INTO ouvrage_genre (ouvrageid, genreid) VALUES (6, 5);
INSERT INTO ouvrage_genre (ouvrageid, genreid) VALUES (6, 1);
INSERT INTO ouvrage_genre (ouvrageid, genreid) VALUES (12, 4);
INSERT INTO ouvrage_genre (ouvrageid, genreid) VALUES (12, 2);


--
-- TOC entry 3257 (class 0 OID 0)
-- Dependencies: 206
-- Name: auteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('auteur_id_seq', 14, true);


--
-- TOC entry 3258 (class 0 OID 0)
-- Dependencies: 208
-- Name: bibliotheque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('bibliotheque_id_seq', 3, true);


--
-- TOC entry 3259 (class 0 OID 0)
-- Dependencies: 200
-- Name: coordonnees_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('coordonnees_id_seq', 293, true);


--
-- TOC entry 3260 (class 0 OID 0)
-- Dependencies: 204
-- Name: editeur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('editeur_id_seq', 7, true);


--
-- TOC entry 3261 (class 0 OID 0)
-- Dependencies: 214
-- Name: emprunt_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('emprunt_id_seq', 80, true);


--
-- TOC entry 3262 (class 0 OID 0)
-- Dependencies: 216
-- Name: exemplaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('exemplaire_id_seq', 20, true);


--
-- TOC entry 3263 (class 0 OID 0)
-- Dependencies: 202
-- Name: genre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('genre_id_seq', 5, true);


--
-- TOC entry 3264 (class 0 OID 0)
-- Dependencies: 196
-- Name: lecteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('lecteur_id_seq', 6095, true);


--
-- TOC entry 3265 (class 0 OID 0)
-- Dependencies: 198
-- Name: ouvrage_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('ouvrage_id_seq', 13, true);


--
-- TOC entry 3266 (class 0 OID 0)
-- Dependencies: 210
-- Name: situation_emprunt_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('situation_emprunt_id_seq', 4, true);


-- Completed on 2019-05-27 13:41:18 CEST

--
-- PostgreSQL database dump complete
--

