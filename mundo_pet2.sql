-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Set-2022 às 01:30
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mundo pet`
--

--
-- Estrutura da tabela `usuario`
--
CREATE DATABASE IF NOT EXISTS `mundo pet`;
USE `mundo pet`;
DROP TABLE IF EXISTS `agenda`;
DROP TABLE IF EXISTS `consulta`;
DROP TABLE IF EXISTS `animal`;
DROP TABLE IF EXISTS `usuario`;
DROP TABLE IF EXISTS `login`;
DROP TABLE IF EXISTS `veterinario`;
DROP TABLE IF EXISTS `endereco`;





CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `data_Nasc` date NOT NULL,
  `email` varchar(100) NOT NULL UNIQUE,
  `CPF` char(15) NOT NULL UNIQUE,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nome`, `data_Nasc`, `email`, `CPF`, `senha`) VALUES
(1, 'Vinícius', '2025-04-03', 'aaaaa@gmail.com', '123.456.671-54', 'senha123'),
(2, 'Ericlecio', '2019-03-02', 'ericlecio@gmail.com', '123.454.378-57', 'ericlecio8978'),
(3, 'Lucas', '2022-10-05', 'lucas@gmail.com', '123.675.475-84', 'lucas343');


-- --------------------------------------------------------


-- --------------------------------------------------------
--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `email` varchar(100) NOT NULL UNIQUE,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`email`, `senha`) VALUES
('Ericlecio', 'ericlecio8978'),
('Lucas', 'lucas343'),
('vinicius', 'senha123');

--
-- Estrutura da tabela `veterinario`
--

CREATE TABLE `veterinario` (
  `idveterinario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `data_Nasc` date NOT NULL,
  `email` varchar(100) NOT NULL UNIQUE,
  `CPF` char(15) NOT NULL UNIQUE,
  `CRMV` char(10) NOT NULL UNIQUE,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`idveterinario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `veterinario`
--

INSERT INTO `veterinario` (`idveterinario`, `nome`, `data_Nasc`, `email`, `CPF`, `Crmv`, `senha`) VALUES
(1, 'luiz arnaldo', '1313-01-21', 'luizarnaldo@gmail.com', '212.132.313-21', 12345678, '26ba6f14cce701b9b14e935702e3195c'),
(2, 'Ana lucia', '1321-01-12', 'analucia@gmail.com', '232.132.132-13', 21890340, 'dd8f27ad538d421c15cf7fb568a5856c'),
(3, 'Joao Miguel', '2000-01-23', 'JoaoMiguel@gmail.com', '213.213.213-21', 45332178, '5bc748daa0afd1ed71133b44258ac52d');


--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idendereco` int(50) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `Bairro` varchar(50) NOT NULL,
  `Rua` varchar(150) NOT NULL,
  `Cidade` varchar(50) NOT NULL,
  `Numero` int(11) NOT NULL,
  `UF` varchar(2) NOT NULL,
  PRIMARY KEY (`idendereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idendereco`, `idusuario`, `Bairro`, `Rua`, `Cidade`, `Numero`, `UF`) VALUES
(1, 1, 'newton', 'rua quinze', 'palmares', 222, 'PE'),
(2, 2, 'Cohab', 'rua dom pedro I', 'Palmares', 330, 'PE'),
(3, 3, 'Quilombo', 'rua 87', 'Joaquim Nabuco', 75, 'PE');

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE `animal` (
  `idanimal` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `raça` varchar(100) NOT NULL,
  `idade` int(2) NOT NULL,
  `sexo` char(1) NOT NULL,
  PRIMARY KEY (`idanimal`),
  CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`idanimal`, `idusuario`, `Nome`, `raça`, `idade`, `sexo`) VALUES
(1, 1, 'thor', 'viralata', 2, 'M'),
(2, 3, 'Pipoca', 'Poodle', 2, 'M'),
(3, 2, 'Rex', 'Vira-Lata', 1, 'F');

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `idconsulta` int(11) NOT NULL AUTO_INCREMENT,
  `idveterinario` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `idanimal` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `data_consulta` date NOT NULL,
  `horario` int(4) NOT NULL,
  PRIMARY KEY (`idconsulta`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idveterinario`),
  CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `consulta_ibfk_3` FOREIGN KEY (`idanimal`) REFERENCES `animal` (`idanimal`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`idconsulta`, `idveterinario`, `idusuario`, `idanimal`,`nome`, `data_consulta`, `horario`) VALUES
(1, 1, 2, 2, 'thor', '2023-04-04', 13);

-- --------------------------------------------------------


--
-- Estrutura da tabela `agenda`
--

CREATE TABLE `agenda` (
  `idagenda` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `data_consulta` date NOT NULL,
  `horario` int(4) NOT NULL,
  `idveterinario` int(11) NOT NULL,
  `idconsulta` int(11) NOT NULL,
  PRIMARY KEY (`idagenda`),
  CONSTRAINT `agenda_ibfk_1` FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idveterinario`),
  CONSTRAINT `agenda_ibfk_2` FOREIGN KEY (`idconsulta`) REFERENCES `consulta` (`idconsulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------



COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
