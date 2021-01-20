-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 20 Oca 2021, 22:16:13
-- Sunucu sürümü: 10.4.17-MariaDB
-- PHP Sürümü: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `pegamsys`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `lesson`
--

CREATE TABLE `lesson` (
  `id` int(11) NOT NULL,
  `explanation` varchar(500) COLLATE utf8_turkish_ci DEFAULT NULL,
  `lessoncode` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL,
  `lessonname` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `lesson`
--

INSERT INTO `lesson` (`id`, `explanation`, `lessoncode`, `lessonname`) VALUES
(1, 'Lorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolor', '110', 'physics'),
(2, 'Lorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolor', '111', 'maths'),
(3, 'Lorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolor', '113', 'chemistry'),
(4, 'Lorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolor', '115', 'biology');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `lesson_student`
--

CREATE TABLE `lesson_student` (
  `lesson_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `lesson_student`
--

INSERT INTO `lesson_student` (`lesson_id`, `student_id`) VALUES
(1, 2),
(3, 2),
(1, 3),
(4, 3),
(3, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `classroom` int(11) DEFAULT NULL,
  `explanation` varchar(500) COLLATE utf8_turkish_ci DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `surname` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `student`
--

INSERT INTO `student` (`id`, `classroom`, `explanation`, `name`, `number`, `surname`) VALUES
(1, 2, NULL, 'John', 1234, 'Keita'),
(2, 3, NULL, 'Smith', 1175, 'Donovan'),
(3, 5, 'Lorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolor', 'Jennifer', 1375, 'Fontona'),
(4, 6, 'Lorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolorLorem ipsum dolor', 'Steve', 375, 'Mc');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `student_lesson`
--

CREATE TABLE `student_lesson` (
  `student_id` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `student_lesson`
--

INSERT INTO `student_lesson` (`student_id`, `lesson_id`) VALUES
(2, 1),
(2, 3),
(3, 1),
(3, 3),
(3, 4),
(4, 3);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `lesson`
--
ALTER TABLE `lesson`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `lesson_student`
--
ALTER TABLE `lesson_student`
  ADD KEY `FKdkcwe8kn2g9p9olff5ojwlf18` (`student_id`),
  ADD KEY `FK4t9i0s6y9ir1nteoi84tir9rb` (`lesson_id`);

--
-- Tablo için indeksler `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `student_lesson`
--
ALTER TABLE `student_lesson`
  ADD KEY `FKa64mwri6gq3ai7jwih91gsmf7` (`lesson_id`),
  ADD KEY `FK2nmxs05vgk43xy1cko182p72p` (`student_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `lesson`
--
ALTER TABLE `lesson`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `lesson_student`
--
ALTER TABLE `lesson_student`
  ADD CONSTRAINT `FK4t9i0s6y9ir1nteoi84tir9rb` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`),
  ADD CONSTRAINT `FKdkcwe8kn2g9p9olff5ojwlf18` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Tablo kısıtlamaları `student_lesson`
--
ALTER TABLE `student_lesson`
  ADD CONSTRAINT `FK2nmxs05vgk43xy1cko182p72p` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `FKa64mwri6gq3ai7jwih91gsmf7` FOREIGN KEY (`lesson_id`) REFERENCES `lesson` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
