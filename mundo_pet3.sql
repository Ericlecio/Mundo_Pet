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

DROP TABLE IF EXISTS `animal`;
DROP TABLE IF EXISTS `endereco`;
DROP TABLE IF EXISTS `consulta`;
DROP TABLE IF EXISTS `login`;
DROP TABLE IF EXISTS `veterinario`;
DROP TABLE IF EXISTS `usuario`;




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
(1, 'Vinícius Arruda', '2002-04-25', 'vinicius@gmail.com', '123.456.671-54', 'arruda123'),
(2, 'Ericlecio Thiago', '2019-03-02', 'ericlecio@gmail.com', '123.454.378-57', 'ericlecio123'),
(3, 'Jose Aldo', '1982-10-05', 'josealdo@gmail.com', '123.675.475-84', 'aldo123'),
(4, 'maria eduarda', '2001-11-11', 'mariaeduarda@gmail.com', '121.678.999-09', 'maria123'),
(5, 'Ana Gabriela', '1999-08-02', 'anagabriela@gmail.com', '123.675.485-84', 'ana123');



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
('Ericlecio', 'senha123'),
('Lucas', 'senha123'),
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
(1, 'luiz arnaldo', '1998-01-21', 'luizarnaldo@gmail.com', '112.132.313-21', 12345678, '26ba6f14cce701b9b14e935702e3195c'),
(2, 'Ana lucia', '1981-01-12', 'analucia@gmail.com', '232.122.442-13', 21890340, 'dd8f27ad538d421c15cf7fb568a5856c'),
(3, 'Joao Miguel', '2000-01-23', 'JoaoMiguel@gmail.com', '513.213.213-21', 23332178, '5bc748daa0afd1ed71133b44258ac52d'),
(4, 'joao kleber', '2001-06-22', 'Joaokleber@gmail.com', '111.113.414-88', 11132178, '5bc748324233287ddsfdsfds7f87652d'),
(5, 'maria clara', '2004-01-12', 'mariaclara@gmail.com', '219.000.093-26', 97869178, '5bc748daa0afd1ed71133b442543243b');



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
  PRIMARY KEY (`idendereco`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idendereco`, `idusuario`, `Bairro`, `Rua`, `Cidade`, `Numero`, `UF`) VALUES
(1, 1, 'newton carneiro', 'rua quinze', 'Palmares', 222, 'PE'),
(2, 2, 'Cohab 1', 'rua dom pedro I', 'Palmares', 330, 'PE'),
(3, 3, 'Quilombo 1', 'rua 87', 'Palmares', 37, 'PE'),
(4, 4, 'Nova Palmares', 'rua 12', 'Palmares', 229, 'PE'),
(5, 5, 'Santa luzia', 'rua 1', 'Palmares', 102, 'PE');


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
(1, 1, 'Thor', 'Pit bull', 2, 'M'),
(2, 2, 'Pipoca', 'Poodle', 2, 'M'),
(3, 3, 'Rex', 'Poodle', 1, 'F'),
(4, 4, 'Bolinha', 'Vira-Lata', 3, 'M'),
(5, 5, 'Fera', 'Pastor alemão	', 2, 'F');



-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `idconsulta` int(11) NOT NULL AUTO_INCREMENT,
  `nomeVeterinario` varchar(100) NOT NULL,
  `nomeUsuario` varchar(100) NOT NULL,
  `nomeAnimal` int(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `data_consulta` date NOT NULL,
  `horario` varchar(5) NOT NULL,
  PRIMARY KEY (`idconsulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`idconsulta`, `nomeVeterinario`, `nomeUsuario`, `nomeAnimal`,`tipo`, `data_consulta`, `horario`) VALUES
(1,'Ana lucia', 'Vinícius Arruda','Thor', 'Vacinação Raiva', '2023-01-05', '13:00');

-- --------------------------------------------------------




COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
