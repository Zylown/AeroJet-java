-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-07-2023 a las 03:22:25
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aerojet-java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeropuerto`
--

CREATE TABLE `aeropuerto` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Ciudad` varchar(100) DEFAULT NULL,
  `Pais` varchar(100) DEFAULT NULL,
  `CodigoIATA` varchar(3) DEFAULT NULL,
  `CodigoICAO` varchar(4) DEFAULT NULL,
  `Latitud` decimal(10,6) DEFAULT NULL,
  `Longitud` decimal(10,6) DEFAULT NULL,
  `ZonaHoraria` varchar(50) DEFAULT NULL,
  `TipoAeropuerto` varchar(50) DEFAULT NULL,
  `Terminal` varchar(50) DEFAULT NULL,
  `Capacidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aeropuerto`
--

INSERT INTO `aeropuerto` (`ID`, `Nombre`, `Ciudad`, `Pais`, `CodigoIATA`, `CodigoICAO`, `Latitud`, `Longitud`, `ZonaHoraria`, `TipoAeropuerto`, `Terminal`, `Capacidad`) VALUES
(1, 'Aeropuerto Internacional Alfredo Rodríguez Ballón', 'Arequipa', 'Perú', 'AQP', 'SPQU', '-16.344299', '-71.568187', 'GMT-5', 'Aeropuerto Civiles', 'Alfredo Rodríguez Ballón', 1990820),
(2, 'Aeropuerto Internacional Coronel FAP Alfredo Mendívil Duarte', 'Ayacucho', 'Perú', 'AYP', 'SPHO', '-13.154819', '-74.204417', 'GMT-5', 'Aeropuerto Civil', 'Coronel FAP Alfredo Mendívil Duarte', 180000),
(3, 'Aeropuerto Internacional Mayor General FAP Armando Revoredo Iglesias', 'Cajamarca', 'Perú', 'CJA', 'SPJR', '-7.134567', '-78.489324', 'GMT-5', 'Aeropuerto Civil', 'Mayor General FAP Armando Revoredo Iglesias', 200000),
(4, 'Aeropuerto Internacional Capitán FAP José A. Quiñones González', 'Chiclayo', 'Perú', 'CIX', 'SPHI', '-6.787475', '-79.828114', 'GMT-5', 'Aeropuerto Civil', 'Capitán FAP José A. Quiñones González', 900000),
(5, 'Aeropuerto Internacional Alejandro Velasco Astete', 'Cusco', 'Perú', 'CUZ', 'SPZO', '-13.535722', '-71.938781', 'GMT-5', 'Aeropuerto Civil', 'Alejandro Velasco Astete', 4206960),
(6, 'Aeropuerto Internacional Alférez FAP David Figueroa Fernandini', 'Huánuco', 'Perú', 'HUU', 'SPNC', '-9.878808', '-76.204797', 'GMT-5', 'Aeropuerto Civil', 'lférez FAP David Figueroa Fernandini', 130000),
(7, 'Aeropuerto Internacional Coronel FAP Carlos Ciriani Santa Rosa', 'Ilo', 'Perú', 'ILQ', 'SPLO', '-17.695036', '-71.339650', 'GMT-5', 'Aeropuerto Civil', 'Coronel FAP Carlos Ciriani Santa Rosa', 300000),
(8, 'Aeropuerto Internacional Coronel FAP Francisco Secada Vignetta', 'Iquitos', 'Perú', 'IQT', 'SPQT', '-3.785756', '-73.308805', 'GMT-5', 'Aeropuerto Civil', 'Coronel FAP Francisco Secada Vignetta', 300000),
(9, 'Aeropuerto Internacional Inca Manco Cápac', 'Juliaca', 'Perú', 'JUL', 'SPJL', '-15.466175', '-70.159858', 'GMT-5', 'Aeropuerto Civil', 'Inca Manco Cápac', 680000),
(10, 'Aeropuerto Internacional Jorge Chávez', 'Lima', 'Perú', 'LIM', 'SPJC', '-12.023016', '-77.108017', 'GMT-5', 'Aeropuerto Civiles', 'Jorge Chavez', 10000000),
(11, 'Aeropuerto Internacional Capitán FAP Guillermo Concha Iberico', 'Piura', 'Perú', 'PIU', 'SPUR', '-5.201917', '-80.613208', 'GMT-5', 'Aeropuerto Civil', 'Capitán FAP Guillermo Concha Iberico', 1300000),
(12, 'Aeropuerto Internacional Capitán David Abensur Rengifo', 'Pucallpa', 'Perú', 'PCL', 'SPCL', '-8.377959', '-74.574817', 'GMT-5', 'Aeropuerto Civil', 'Capitán David Abensur Rengifo', 460000),
(13, 'Aeropuerto Internacional Padre Aldamiz', 'Puerto Maldonado', 'Perú', 'PEM', 'SPTU', '-12.613611', '-69.229722', 'GMT-5', 'Aeropuerto Civil', 'Padre Aldamiz', 200000),
(14, 'Aeropuerto Internacional Coronel FAP Carlos Ciriani Santa Rosa', 'Tacna', 'Perú', 'TCQ', 'SPTN', '-18.053075', '-70.275830', 'GMT-5', 'Aeropuerto Civil', 'Coronel FAP Carlos Ciriani Santa Rosa', 200000),
(15, 'Aeropuerto Internacional Capitán FAP Víctor Montes Arias', 'Talara', 'Perú', 'TYL', 'SPYL', '-4.576388', '-81.254167', 'GMT-5', 'Aeropuerto Civil', 'Capitán FAP Víctor Montes Arias', 450000),
(16, 'Aeropuerto Internacional Capitán FAP Guillermo del Castillo Paredes', 'Tarapoto', 'Perú', 'TPP', 'SPST', '-6.508878', '-76.373228', 'GMT-5', 'Aeropuerto Civil', 'Capitán FAP Guillermo del Castillo Paredes', 800000),
(17, 'Aeropuerto Internacional Capitán FAP Carlos Martínez de Pinillos', 'Trujillo', 'Perú', 'TRU', 'SPRU', '-8.081721', '-79.108761', 'GMT-5', 'Aeropuerto Civil', 'Capitán FAP Carlos Martínez de Pinillos', 1000000),
(18, 'Aeropuerto Internacional Capitán FAP Pedro Canga Rodríguez', 'Tumbes', 'Perú', 'TBP', 'SPME', '-3.549525', '-80.381406', 'GMT-5', 'Aeropuerto Civil', 'Capitán FAP Pedro Canga Rodríguez', 500000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asientos`
--

CREATE TABLE `asientos` (
  `ID` int(11) NOT NULL,
  `Avion_ID` int(11) DEFAULT NULL,
  `Vuelo_ID` int(11) DEFAULT NULL,
  `Numero` int(11) DEFAULT NULL,
  `Estado` tinyint(1) DEFAULT NULL,
  `Ubicacion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asientos`
--

INSERT INTO `asientos` (`ID`, `Avion_ID`, `Vuelo_ID`, `Numero`, `Estado`, `Ubicacion`) VALUES
(1, 1, 1, 1, 0, 'Rojo'),
(2, 1, 1, 2, 0, 'Rojo'),
(3, 1, 1, 3, 1, 'Rojo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE `aviones` (
  `ID` int(11) NOT NULL,
  `Modelo` varchar(50) DEFAULT NULL,
  `Capacidad` int(11) DEFAULT NULL,
  `Estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`ID`, `Modelo`, `Capacidad`, `Estado`) VALUES
(1, 'Airbus A321', 186, 'Operativo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boletos`
--

CREATE TABLE `boletos` (
  `ID` int(11) NOT NULL,
  `Vuelo_ID` int(11) NOT NULL,
  `Tarifa_ID` int(11) DEFAULT NULL,
  `Asiento_ID` int(11) NOT NULL,
  `tipo_vuelo` varchar(50) DEFAULT NULL,
  `numero_boleto` varchar(50) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Clase` varchar(50) NOT NULL,
  `fecha_emision` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `boletos`
--

INSERT INTO `boletos` (`ID`, `Vuelo_ID`, `Tarifa_ID`, `Asiento_ID`, `tipo_vuelo`, `numero_boleto`, `Precio`, `Clase`, `fecha_emision`) VALUES
(1, 1, 1, 1, 'ida', 'AERLXP', '200.00', 'Clase Económica', '2023-08-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Genero` varchar(50) DEFAULT NULL,
  `Fecha_Nacimiento` date DEFAULT NULL,
  `Nacionalidad` varchar(100) DEFAULT NULL,
  `CorreoElectronico` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID`, `Nombre`, `Apellido`, `DNI`, `Telefono`, `Genero`, `Fecha_Nacimiento`, `Nacionalidad`, `CorreoElectronico`) VALUES
(1, 'SEVASTIAN', 'CABALLERO', 72615920, 987654321, 'Masculino', '2002-04-20', 'Peruana', 'sevasxd@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `ID` int(11) NOT NULL,
  `Cliente_ID` int(11) DEFAULT NULL,
  `Comentario` text DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `Vuelo_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `ID` int(11) NOT NULL,
  `Fecha_Compra` date NOT NULL,
  `TotalCompra` decimal(10,0) NOT NULL,
  `NumComfirmacion` varchar(50) NOT NULL,
  `Usuario_ID` int(11) DEFAULT NULL,
  `Vuelo_ID` int(11) DEFAULT NULL,
  `Tarifa_ID` int(11) DEFAULT NULL,
  `Asiento_ID` int(11) DEFAULT NULL,
  `TipoPago_ID` int(11) DEFAULT NULL,
  `ID_boleto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escalas`
--

CREATE TABLE `escalas` (
  `ID` int(11) NOT NULL,
  `Vuelo_ID` int(11) NOT NULL,
  `Ciudad` varchar(50) NOT NULL,
  `Duracion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `ID` int(11) NOT NULL,
  `punto_origen` varchar(50) DEFAULT NULL,
  `punto_destino` varchar(50) DEFAULT NULL,
  `Distancia` decimal(10,2) DEFAULT NULL,
  `duracion_estimada` int(11) DEFAULT NULL,
  `aeropuerto_origen_ID` int(11) DEFAULT NULL,
  `aeropuerto_destino_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`ID`, `punto_origen`, `punto_destino`, `Distancia`, `duracion_estimada`, `aeropuerto_origen_ID`, `aeropuerto_destino_ID`) VALUES
(1, 'Arequipa', 'Lima', '1015.50', 57, 1, 10),
(2, 'Ayacucho', 'Lima', '155.00', 30, 2, 10),
(3, 'Cajamarca', 'Lima', '560.74', 88, 3, 10),
(4, 'Chiclayo', 'Lima', '664.00', 85, 4, 10),
(5, 'Cusco', 'Lima', '575.00', 88, 5, 10),
(6, 'Huanuco', 'Lima', '251.00', 39, 6, 10),
(7, 'Ilo', 'Lima', '266.25', 60, 7, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

CREATE TABLE `tarifas` (
  `ID` int(11) NOT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  `Descripcion` text DEFAULT NULL,
  `Promocion` tinyint(1) DEFAULT NULL,
  `FechaInicio` date DEFAULT NULL,
  `FechaFin` date DEFAULT NULL,
  `MontoCargoAdicional` decimal(10,2) DEFAULT NULL,
  `Boleto_ID` int(11) DEFAULT NULL,
  `Vuelo_ID` int(11) DEFAULT NULL,
  `Asiento_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tarifas`
--

INSERT INTO `tarifas` (`ID`, `Precio`, `Descripcion`, `Promocion`, `FechaInicio`, `FechaFin`, `MontoCargoAdicional`, `Boleto_ID`, `Vuelo_ID`, `Asiento_ID`) VALUES
(1, '49.99', 'De Arequipa a Lima', 0, '2023-07-20', '2023-08-01', '0.00', 1, 1, 1),
(2, '50.00', 'De Lima a Arequipa', 0, '2023-07-23', '2023-08-02', '0.00', NULL, NULL, NULL),
(3, '200.00', 'De Chiclayo a Lima', 0, '2023-07-17', '2023-07-18', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pago`
--

CREATE TABLE `tipo_pago` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `numero_transaccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL,
  `nombre_usuario` varchar(255) DEFAULT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `nombre_usuario`, `contraseña`, `email`) VALUES
(1, 'admin', 'pass', 'admin@correo.com'),
(2, 'sevas', 'sevas', 'sevas@correo.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `ID` int(11) NOT NULL,
  `fecha_salida` date DEFAULT NULL,
  `hora_salida` time(6) DEFAULT NULL,
  `fecha_llegada` date DEFAULT NULL,
  `hora_llegada` time(6) DEFAULT NULL,
  `fecha_reprogramacion` date DEFAULT NULL,
  `estado` enum('disponible','en_curso','suspendido','') DEFAULT NULL,
  `Avion_ID` int(11) DEFAULT NULL,
  `Compra_ID` int(11) DEFAULT NULL,
  `Ruta_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`ID`, `fecha_salida`, `hora_salida`, `fecha_llegada`, `hora_llegada`, `fecha_reprogramacion`, `estado`, `Avion_ID`, `Compra_ID`, `Ruta_ID`) VALUES
(1, '2023-08-01', '09:00:00.000000', '2023-08-01', '10:00:00.000000', NULL, 'disponible', 1, NULL, 1),
(2, '2023-08-01', '10:00:00.000000', '2023-08-01', '11:00:00.000000', NULL, 'disponible', 1, NULL, 2),
(3, '2023-07-24', '08:00:00.000000', '2023-07-24', '09:00:00.000000', NULL, 'disponible', 1, NULL, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `asientos`
--
ALTER TABLE `asientos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Avion_ID` (`Avion_ID`),
  ADD KEY `Vuelo_ID` (`Vuelo_ID`);

--
-- Indices de la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Capacidad` (`Capacidad`);

--
-- Indices de la tabla `boletos`
--
ALTER TABLE `boletos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Boletos_Vuelos` (`Vuelo_ID`),
  ADD KEY `FK_Boletos_Tarifas` (`Tarifa_ID`),
  ADD KEY `FK_Boletos_Asientos` (`Asiento_ID`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Cliente_ID` (`Cliente_ID`),
  ADD KEY `Vuelo_ID` (`Vuelo_ID`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Vuelo_ID` (`Vuelo_ID`),
  ADD KEY `Tarifa_ID` (`Tarifa_ID`),
  ADD KEY `FK_Compras_Asientos` (`Asiento_ID`),
  ADD KEY `FK_Compras_Cliente` (`Usuario_ID`),
  ADD KEY `FK_Compras_TipoPago` (`TipoPago_ID`),
  ADD KEY `FK_Compras_Boletos` (`ID_boleto`);

--
-- Indices de la tabla `escalas`
--
ALTER TABLE `escalas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Escalas_Vuelos` (`Vuelo_ID`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Rutas_AeropuertosOrigen` (`aeropuerto_origen_ID`),
  ADD KEY `FK_Rutas_AeropuertosDestino` (`aeropuerto_destino_ID`);

--
-- Indices de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Compra_ID` (`Boleto_ID`),
  ADD KEY `Vuelo_ID` (`Vuelo_ID`),
  ADD KEY `Asiento_ID` (`Asiento_ID`);

--
-- Indices de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `email_unico` (`email`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Avion_ID` (`Avion_ID`),
  ADD KEY `Compra_ID` (`Compra_ID`),
  ADD KEY `FK_Vuelos_Rutas` (`Ruta_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `boletos`
--
ALTER TABLE `boletos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `escalas`
--
ALTER TABLE `escalas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asientos`
--
ALTER TABLE `asientos`
  ADD CONSTRAINT `asientos_ibfk_1` FOREIGN KEY (`Avion_ID`) REFERENCES `aviones` (`ID`),
  ADD CONSTRAINT `asientos_ibfk_2` FOREIGN KEY (`Vuelo_ID`) REFERENCES `vuelos` (`ID`);

--
-- Filtros para la tabla `boletos`
--
ALTER TABLE `boletos`
  ADD CONSTRAINT `FK_Boletos_Asientos` FOREIGN KEY (`Asiento_ID`) REFERENCES `asientos` (`ID`),
  ADD CONSTRAINT `FK_Boletos_Tarifas` FOREIGN KEY (`Tarifa_ID`) REFERENCES `tarifas` (`ID`),
  ADD CONSTRAINT `FK_Boletos_Vuelos` FOREIGN KEY (`Vuelo_ID`) REFERENCES `vuelos` (`ID`);

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`Cliente_ID`) REFERENCES `cliente` (`ID`);

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `FK_Compras_Asientos` FOREIGN KEY (`Asiento_ID`) REFERENCES `asientos` (`ID`),
  ADD CONSTRAINT `FK_Compras_Boletos` FOREIGN KEY (`ID_boleto`) REFERENCES `boletos` (`ID`),
  ADD CONSTRAINT `FK_Compras_Cliente` FOREIGN KEY (`Usuario_ID`) REFERENCES `cliente` (`ID`),
  ADD CONSTRAINT `FK_Compras_TipoPago` FOREIGN KEY (`TipoPago_ID`) REFERENCES `tipo_pago` (`ID`),
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`Vuelo_ID`) REFERENCES `vuelos` (`ID`),
  ADD CONSTRAINT `compras_ibfk_3` FOREIGN KEY (`Tarifa_ID`) REFERENCES `tarifas` (`ID`);

--
-- Filtros para la tabla `escalas`
--
ALTER TABLE `escalas`
  ADD CONSTRAINT `FK_Escalas_Vuelos` FOREIGN KEY (`Vuelo_ID`) REFERENCES `vuelos` (`ID`);

--
-- Filtros para la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD CONSTRAINT `FK_Rutas_AeropuertosDestino` FOREIGN KEY (`aeropuerto_destino_ID`) REFERENCES `aeropuerto` (`ID`),
  ADD CONSTRAINT `FK_Rutas_AeropuertosOrigen` FOREIGN KEY (`aeropuerto_origen_ID`) REFERENCES `aeropuerto` (`ID`);

--
-- Filtros para la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD CONSTRAINT `tarifas_ibfk_1` FOREIGN KEY (`Boleto_ID`) REFERENCES `boletos` (`ID`),
  ADD CONSTRAINT `tarifas_ibfk_3` FOREIGN KEY (`Vuelo_ID`) REFERENCES `vuelos` (`ID`),
  ADD CONSTRAINT `tarifas_ibfk_4` FOREIGN KEY (`Asiento_ID`) REFERENCES `asientos` (`ID`);

--
-- Filtros para la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD CONSTRAINT `FK_Vuelos_Rutas` FOREIGN KEY (`Ruta_ID`) REFERENCES `rutas` (`ID`),
  ADD CONSTRAINT `vuelos_ibfk_1` FOREIGN KEY (`Avion_ID`) REFERENCES `aviones` (`ID`),
  ADD CONSTRAINT `vuelos_ibfk_2` FOREIGN KEY (`Compra_ID`) REFERENCES `compras` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
