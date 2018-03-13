-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 13 Mars 2018 à 13:23
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `servicecomptable`
--

-- --------------------------------------------------------

--
-- Structure de la table `item_transaction`
--

CREATE TABLE `item_transaction` (
  `ID` int(11) NOT NULL,
  `CODE` varchar(255) CHARACTER SET latin1 NOT NULL,
  `ID_TRANSACTION` int(11) NOT NULL,
  `QUANTITE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `item_transaction`
--

INSERT INTO `item_transaction` (`ID`, `CODE`, `ID_TRANSACTION`, `QUANTITE`) VALUES
(1, 'FOO-CEB765', 3, 5),
(2, 'FOO-ZZO907', 2, 3),
(3, 'FOO-YRZ635', 2, 3),
(4, 'FOO-UHI798', 5, 1),
(5, 'FOO-HVN963', 2, 1),
(6, 'FOO-YIA820', 4, 1),
(7, 'FOO-QZJ604', 4, 4),
(8, 'FOO-FJC959', 4, 2),
(9, 'FOO-VEC380', 5, 2),
(10, 'FOO-PWZ483', 3, 2),
(11, 'FOO-DPT222', 3, 4),
(12, 'FOO-XKV650', 1, 5),
(13, 'FOO-ULH291', 3, 4),
(14, 'FOO-ABT196', 3, 4),
(15, 'FOO-GDP659', 2, 5),
(16, 'FOO-VSC482', 3, 3),
(17, 'FOO-OXW525', 4, 5),
(18, 'FOO-PSC463', 3, 5),
(19, 'FOO-TEG154', 5, 5),
(20, 'FOO-YFX398', 1, 3),
(21, 'FOO-XKV650', 1, 5),
(22, 'FOO-YFX398', 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `ID_TRANSACTION` int(11) NOT NULL,
  `ID_SUCCURSALE` int(11) NOT NULL,
  `ID_CLIENT` int(11) NOT NULL,
  `DATE_TRANSACTION` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `SOUS_TOTAL` double NOT NULL,
  `POURBOIRE_COURSIER` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `transaction`
--

INSERT INTO `transaction` (`ID_TRANSACTION`, `ID_SUCCURSALE`, `ID_CLIENT`, `DATE_TRANSACTION`, `SOUS_TOTAL`, `POURBOIRE_COURSIER`) VALUES
(1, 1, 1, '2018-03-05 02:02:03', 25.6, 2),
(2, 290, 94, '2017-09-22 06:01:48', 12.6, 3.78),
(3, 138, 100, '2017-11-10 20:43:06', 99.23, 3.77),
(4, 156, 76, '2017-09-17 07:42:19', 11.12, 2.03),
(5, 263, 86, '2018-02-04 18:07:10', 46.17, 2.57),
(6, 272, 94, '2017-05-30 09:14:00', 38.81, 4.04),
(7, 218, 60, '2017-10-01 08:21:48', 99.2, 3.6),
(8, 292, 73, '2017-05-06 19:06:18', 55.74, 3.8),
(9, 222, 78, '2018-02-08 08:35:42', 79.56, 2.14),
(10, 209, 91, '2018-02-05 01:22:24', 61.38, 2.16),
(11, 151, 67, '2017-08-16 07:54:02', 20.17, 3.98),
(12, 267, 86, '2018-01-07 11:59:25', 24.02, 0.35),
(13, 248, 83, '2017-06-05 18:27:29', 71.16, 1.43),
(14, 288, 62, '2017-10-03 21:52:07', 57.05, 0.96),
(15, 283, 52, '2017-05-08 13:37:58', 31.1, 4.02),
(16, 231, 75, '2017-09-07 20:01:49', 87.9, 1.41),
(17, 292, 100, '2017-05-26 15:10:12', 79.69, 3.67),
(18, 242, 54, '2017-05-29 01:29:40', 81.22, 2.13),
(19, 270, 93, '2017-03-13 05:36:21', 14.08, 2.63),
(20, 238, 71, '2017-06-08 07:38:50', 11.72, 1.15),
(21, 224, 63, '2017-04-24 15:59:14', 42.98, 3.95),
(22, 101, 96, '2017-10-28 17:10:13', 24.94, 3.26),
(23, 200, 85, '2018-02-22 07:17:38', 29.92, 0.98),
(24, 177, 79, '2017-11-06 05:11:06', 35.35, 2.21),
(25, 180, 80, '2017-10-17 18:54:20', 25.09, 2.54),
(26, 238, 55, '2017-08-15 14:26:53', 32.12, 0.51),
(27, 253, 71, '2017-03-06 17:46:39', 37.79, 4.42),
(28, 284, 64, '2017-08-02 01:55:34', 55.37, 4.08),
(29, 257, 93, '2017-10-23 07:42:00', 67.66, 0.42),
(30, 240, 63, '2017-03-15 03:22:10', 76.71, 3.66),
(31, 287, 75, '2017-07-06 03:13:21', 66.51, 2.79),
(32, 235, 95, '2018-01-06 22:24:34', 74.9, 0.48),
(33, 175, 68, '2017-07-16 21:30:37', 59.08, 2.33),
(34, 140, 80, '2018-01-24 19:58:13', 20.64, 0.1),
(35, 299, 71, '2017-08-11 03:32:02', 26.41, 3.33),
(36, 138, 82, '2017-03-12 09:59:02', 80.07, 1.37),
(37, 159, 61, '2017-10-24 00:36:59', 25.88, 4.98),
(38, 113, 69, '2017-10-24 03:20:54', 63.86, 4.88),
(39, 114, 97, '2017-10-16 21:41:52', 67.6, 0.22),
(40, 129, 97, '2017-11-20 20:10:24', 26.94, 3.49),
(41, 173, 76, '2017-06-24 10:39:09', 45.66, 0.34),
(42, 1, 1, '2018-03-13 01:21:07', 25.6, 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `item_transaction`
--
ALTER TABLE `item_transaction`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_TRANSACTION_ITEM` (`ID_TRANSACTION`);

--
-- Index pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`ID_TRANSACTION`),
  ADD KEY `ID_SUCCURASALE` (`ID_SUCCURSALE`,`ID_CLIENT`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `item_transaction`
--
ALTER TABLE `item_transaction`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `ID_TRANSACTION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `item_transaction`
--
ALTER TABLE `item_transaction`
  ADD CONSTRAINT `TRANSC_FK_ID_TRANSC` FOREIGN KEY (`ID_TRANSACTION`) REFERENCES `transaction` (`ID_TRANSACTION`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
