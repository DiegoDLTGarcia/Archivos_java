-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2013 a las 19:04:27
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE IF NOT EXISTS `trabajadores` (
  `id_jugador` varchar(20) NOT NULL,
  `nombre_jugador` varchar(30) NOT NULL,
  `horasjugadas` int(11) NOT NULL,
  `pagoporhora` double NOT NULL,
  `sueldo_jugador` double NOT NULL,
  `rebaja` double NOT NULL,
  `caridad` double NOT NULL,
  `total` double NOT NULL,
  `formapago` varchar(20) NOT NULL,
  `articulo` double NOT NULL,
  PRIMARY KEY (`id_jugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`id_jugador`, `nombre_jugador`, `horasjugadas`,  `pagoporhora`, `sueldo_jugador`, `rebaja`, `caridad`, `total`, `formapago`, `articulo`) VALUES
('1', 'diego garcia', 134, 16, 12, 23, 1, 176, 'adidas', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
