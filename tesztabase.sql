-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2024. Máj 20. 11:38
-- Kiszolgáló verziója: 10.4.27-MariaDB
-- PHP verzió: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `tesztabase`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `teszta`
--

CREATE TABLE `teszta` (
  `id` int(11) NOT NULL,
  `ar` int(11) NOT NULL,
  `finom` bit(1) NOT NULL,
  `hany_tojasos` int(11) NOT NULL,
  `marka` varchar(255) DEFAULT NULL,
  `tipus` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `teszta`
--

INSERT INTO `teszta` (`id`, `ar`, `finom`, `hany_tojasos`, `marka`, `tipus`) VALUES
(1, 899, b'1', 9, 'COOP', 'csiga'),
(3, 1499, b'0', 1, 'Penny', 'húsleves'),
(4, 1499, b'0', 1, 'Penny', 'húsleves'),
(5, 1499, b'1', 1, 'Tesco ', 'húsleves');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `teszta`
--
ALTER TABLE `teszta`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `teszta`
--
ALTER TABLE `teszta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
