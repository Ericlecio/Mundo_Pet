# Projeto-Mundo_Pet
CREATE TABLE `mundo pet`.`usuario`(
`idusuario` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`data_Nasc` INT(6) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`CPF` CHAR(11) NOT NULL,
`senha` VARCHAR(100) NOT NULL,
`Endereco` VARCHAR(100) NOT NULL,
PRIMARY KEY (`IdUsuario`)
)

CREATE TABLE `cadastro`(
`idcadastro` INT AUTO_INCREMENT,
`nome` VARCHAR(100) NULL DEFAULT NULL,
`data_Nasc` INT(6) NOT NULL,
`CPF` INT(11) NULL DEFAULT NULL,
`senha` CHAR(8) NOT NULL,
`email` VARCHAR (100) NOT NULL,
`Endereco` VARCHAR(100) NOT NULL,
`idusuario` INT NOT NULL,
PRIMARY KEY (`idcadastro`)
);



CREATE TABLE `mundo pet`.`login`(
`Idlogin` INT AUTO_INCREMENT,
`idcadastro` INT NOT NULL,
`Usuario` VARCHAR(80) NOT NULL,
`Senha` CHAR(8) NOT NULL,
PRIMARY KEY (`idlogin`)
)

CREATE TABLE `mundo pet`.`animal`(
`idanimal` INT AUTO_INCREMENT,
`idusuario` INT NOT NULL,
`Nome` VARCHAR(100) NOT NULL,
`raça` VARCHAR(100) NOT NULL,
`idade` INT(2) NOT NULL,
`sexo` CHAR(1) NOT NULL,
`sipo` VARCHAR(100) NOT NULL,
PRIMARY KEY (`idanimal`)
)

CREATE TABLE `mundo pet`.`consulta`(
`idconsulta` INT AUTO_INCREMENT,
`idveterinario` INT NOT NULL,
`nome` VARCHAR(100) NOT NULL,
`data_consulta` DATE NOT NULL,
`horario` INT(4) NOT NULL,
PRIMARY KEY (`idconsulta`)
)

CREATE TABLE `mundo pet`.`veterinario`(
`idveterinario` INT AUTO_INCREMENT,
`idconsulta` INT NOT NULL,
`idvacinacao` INT NOT NULL,
`nome` VARCHAR(100) NOT NULL,
`data_Nasc` INT(6) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`CPF` CHAR(11) NOT NULL,
`senha` VARCHAR(100) NOT NULL,
PRIMARY KEY (`idveterinario`)
)


CREATE TABLE `mundo pet`.`agenda`(
`idagenda` INT NOT NULL AUTO_INCREMENT,
`data_consulta` DATE NOT NULL,
`horario` INT(4) NOT NULL,
`idveterinario` INT NOT NULL,
`idconsulta` INT NOT NULL,
PRIMARY KEY (`idagenda`)
)

CREATE TABLE `mundo pet`.`vacinacao`(
`idvacinacao` INT AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`data_aplicacao` DATE NOT NULL,
`horario` INT(4) NOT NULL,
`idveterinario` INT NOT NULL,
`idconsulta` INT NOT NULL,
`idanimal` INT NOT NULL,
`idusuario` INT NOT NULL,
PRIMARY KEY (`idvacinacao`)
)

ALTER TABLE `cadastro` ADD FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);
ALTER TABLE `animal` ADD FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`);
ALTER TABLE `consulta` ADD FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idveterinario`);
ALTER TABLE `veterinario` ADD FOREIGN KEY (`idconsulta`) REFERENCES `consulta` (`idconsulta`);
ALTER TABLE `agenda` ADD FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idveterinario`);
ALTER TABLE `agenda` ADD FOREIGN KEY (`idconsulta`) REFERENCES `consulta` (`idconsulta`);

