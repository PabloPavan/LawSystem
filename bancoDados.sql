-- --------------------------------------------------------
-- Servidor:                     www.projetos.unijui.edu.br
-- Versão do servidor:           5.5.44-0+deb7u1-log - (Debian)
-- OS do Servidor:               debian-linux-gnu
-- HeidiSQL Versão:              9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para emodelo
CREATE DATABASE IF NOT EXISTS `emodelo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `emodelo`;

-- Copiando estrutura para tabela emodelo.modelo_tb_agenda
CREATE TABLE IF NOT EXISTS `modelo_tb_agenda` (
  `id_agenda` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `data_agenda` varchar(8) DEFAULT NULL,
  `hora_agenda` varchar(4) DEFAULT NULL,
  `atividade_agenda` varchar(255) DEFAULT NULL,
  `id_processo` int(5) unsigned zerofill DEFAULT NULL,
  `id_grupo` int(5) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id_agenda`),
  KEY `id_processo` (`id_processo`),
  KEY `id_grupo` (`id_grupo`),
  CONSTRAINT `modelo_tb_agenda_ibfk_1` FOREIGN KEY (`id_processo`) REFERENCES `modelo_tb_processo` (`id_processo`),
  CONSTRAINT `modelo_tb_agenda_ibfk_2` FOREIGN KEY (`id_grupo`) REFERENCES `modelo_tb_grupo` (`id_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_aluno
CREATE TABLE IF NOT EXISTS `modelo_tb_aluno` (
  `id_aluno` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(5) unsigned zerofill NOT NULL,
  `rg_aluno` int(6) DEFAULT NULL,
  `anoSemestre_aluno` varchar(7) DEFAULT NULL,
  `id_grupo` int(5) unsigned zerofill NOT NULL,
  `inativo_aluno` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_aluno`),
  KEY `id_pessoa` (`id_pessoa`),
  KEY `id_grupo` (`id_grupo`),
  CONSTRAINT `modelo_tb_aluno_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `modelo_tb_pessoa` (`id_pessoa`),
  CONSTRAINT `modelo_tb_aluno_ibfk_2` FOREIGN KEY (`id_grupo`) REFERENCES `modelo_tb_grupo` (`id_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_anexo
CREATE TABLE IF NOT EXISTS `modelo_tb_anexo` (
  `id_anexo` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nome_anexo` varchar(20) DEFAULT NULL,
  `caminho_anexo` varchar(20) DEFAULT NULL,
  `id_relatorio` int(5) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id_anexo`),
  KEY `id_relatorio` (`id_relatorio`),
  CONSTRAINT `modelo_tb_anexo_ibfk_1` FOREIGN KEY (`id_relatorio`) REFERENCES `modelo_tb_relatorio` (`id_relatorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_cliente
CREATE TABLE IF NOT EXISTS `modelo_tb_cliente` (
  `id_cliente` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(5) unsigned zerofill NOT NULL,
  `numero_cliente` varchar(20) DEFAULT NULL,
  `filhos_cliente` tinyint(4) DEFAULT NULL,
  `conjugeNome_cliente` varchar(20) DEFAULT NULL,
  `conjugeSalario_cliente` decimal(10,2) DEFAULT NULL,
  `profisao_cliente` varchar(20) DEFAULT NULL,
  `localTrabalho_cliente` varchar(20) DEFAULT NULL,
  `requerenteSalario_cliente` decimal(10,2) DEFAULT NULL,
  `relacaoBens_cliente` varchar(255) DEFAULT NULL,
  `dataRegistro_cliente` varchar(10) DEFAULT NULL,
  `defere_cliente` tinyint(1) DEFAULT NULL,
  `inativo_cliente` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `id_pessoa` (`id_pessoa`),
  CONSTRAINT `modelo_tb_cliente_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `modelo_tb_pessoa` (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_grupo
CREATE TABLE IF NOT EXISTS `modelo_tb_grupo` (
  `id_grupo` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nome_grupo` varchar(20) DEFAULT NULL,
  `id_usuario` int(5) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id_grupo`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `modelo_tb_grupo_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `modelo_tb_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_pessoa
CREATE TABLE IF NOT EXISTS `modelo_tb_pessoa` (
  `id_pessoa` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nome_pessoa` varchar(50) DEFAULT NULL,
  `sobrenome_pessoa` varchar(50) DEFAULT NULL,
  `cpf_pessoa` varchar(14) DEFAULT NULL,
  `rg_pessoa` varchar(10) DEFAULT NULL,
  `sexo_pessoa` varchar(1) DEFAULT NULL,
  `dataNascimento_pessoa` varchar(10) DEFAULT NULL,
  `estadoCivil_pessoa` varchar(20) DEFAULT NULL,
  `rua_pessoa` varchar(20) DEFAULT NULL,
  `numero_pessoa` int(11) DEFAULT NULL,
  `complemento_pessoa` varchar(20) DEFAULT NULL,
  `bairro_pessoa` varchar(20) DEFAULT NULL,
  `cep_pessoa` varchar(10) DEFAULT NULL,
  `cidade_pessoa` varchar(20) DEFAULT NULL,
  `estado_pessoa` varchar(2) DEFAULT NULL,
  `telefone_pessoa` varchar(11) DEFAULT NULL,
  `email_pessoa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_peticoesIniciais
CREATE TABLE IF NOT EXISTS `modelo_tb_peticoesIniciais` (
  `id_peticoesIniciais` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `data_peticoesIniciais` varchar(10) DEFAULT NULL,
  `id_cliente` int(5) unsigned zerofill NOT NULL,
  `id_processo` int(5) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id_peticoesIniciais`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_processo` (`id_processo`),
  CONSTRAINT `modelo_tb_peticoesIniciaisFBK1` FOREIGN KEY (`id_cliente`) REFERENCES `modelo_tb_cliente` (`id_cliente`),
  CONSTRAINT `modelo_tb_peticoesIniciaisFBK2` FOREIGN KEY (`id_processo`) REFERENCES `modelo_tb_processo` (`id_processo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_peticoesSimples
CREATE TABLE IF NOT EXISTS `modelo_tb_peticoesSimples` (
  `id_relacoes` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `data_relacoes` varchar(10) DEFAULT NULL,
  `id_cliente` int(5) unsigned zerofill NOT NULL,
  `id_processo` int(5) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id_relacoes`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_processo` (`id_processo`),
  CONSTRAINT `modelo_tb_peticoesSimplesFBK1` FOREIGN KEY (`id_cliente`) REFERENCES `modelo_tb_cliente` (`id_cliente`),
  CONSTRAINT `modelo_tb_peticoesSimplesBK2` FOREIGN KEY (`id_processo`) REFERENCES `modelo_tb_processo` (`id_processo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_processo
CREATE TABLE IF NOT EXISTS `modelo_tb_processo` (
  `id_processo` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nome_processo` varchar(100) DEFAULT '0',
  `numero_processo` int(11) DEFAULT NULL,
  `numeroPasta_processo` int(11) DEFAULT NULL,
  `andamento_processo` varchar(1) DEFAULT NULL,
  `acao_processo` varchar(255) DEFAULT NULL,
  `id_cliente` int(5) unsigned zerofill NOT NULL,
  `id_vara` int(5) unsigned zerofill DEFAULT NULL,
  `dataInicio_processo` date DEFAULT NULL,
  `dataFim_processo` date DEFAULT NULL,
  `diaSemana_processo` date DEFAULT NULL,
  `narrativa_processo` text,
  `consulta_processo` text,
  `obs_processo` text,
  PRIMARY KEY (`id_processo`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_vara` (`id_vara`),
  CONSTRAINT `modelo_tb_processo_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `modelo_tb_cliente` (`id_cliente`),
  CONSTRAINT `modelo_tb_processo_ibfk_2` FOREIGN KEY (`id_vara`) REFERENCES `modelo_tb_vara` (`id_vara`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_professor
CREATE TABLE IF NOT EXISTS `modelo_tb_professor` (
  `id_professor` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(5) unsigned zerofill NOT NULL,
  `campus_professor` varchar(20) DEFAULT NULL,
  `inativo_professor` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_professor`),
  KEY `id_pessoa` (`id_pessoa`),
  CONSTRAINT `modelo_tb_professor_ibfk_1` FOREIGN KEY (`id_pessoa`) REFERENCES `modelo_tb_pessoa` (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_relacoes
CREATE TABLE IF NOT EXISTS `modelo_tb_relacoes` (
  `id_relacoes` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `data_relacoes` varchar(10) DEFAULT NULL,
  `id_cliente` int(5) unsigned zerofill NOT NULL,
  `id_processo` int(5) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id_relacoes`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_processo` (`id_processo`),
  CONSTRAINT `modelo_tb_relacoesFBK1` FOREIGN KEY (`id_cliente`) REFERENCES `modelo_tb_cliente` (`id_cliente`),
  CONSTRAINT `modelo_tb_relacoesFBK2` FOREIGN KEY (`id_processo`) REFERENCES `modelo_tb_processo` (`id_processo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_relatorio
CREATE TABLE IF NOT EXISTS `modelo_tb_relatorio` (
  `id_relatorio` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `data_relatorio` date DEFAULT NULL,
  `atividade_relatorio` text,
  `id_grupo` int(5) unsigned zerofill NOT NULL,
  `id_processo` int(5) unsigned zerofill NOT NULL,
  `id_professor` int(5) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id_relatorio`),
  KEY `id_grupo` (`id_grupo`),
  KEY `id_processo` (`id_processo`),
  KEY `id_professor` (`id_professor`),
  CONSTRAINT `modelo_tb_relatorio_ibfk_1` FOREIGN KEY (`id_grupo`) REFERENCES `modelo_tb_grupo` (`id_grupo`),
  CONSTRAINT `modelo_tb_relatorio_ibfk_2` FOREIGN KEY (`id_processo`) REFERENCES `modelo_tb_processo` (`id_processo`),
  CONSTRAINT `modelo_tb_relatorio_ibfk_3` FOREIGN KEY (`id_professor`) REFERENCES `modelo_tb_professor` (`id_professor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_usuario
CREATE TABLE IF NOT EXISTS `modelo_tb_usuario` (
  `id_usuario` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `login_usuario` varchar(20) DEFAULT NULL,
  `senha_usuario` varchar(20) DEFAULT NULL,
  `inativo_usuario` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela emodelo.modelo_tb_vara
CREATE TABLE IF NOT EXISTS `modelo_tb_vara` (
  `id_vara` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nome_vara` varchar(20) DEFAULT NULL,
  `juiz_vara` varchar(20) DEFAULT NULL,
  `rua_vara` varchar(20) DEFAULT NULL,
  `numero_vara` int(11) DEFAULT NULL,
  `complemento_vara` varchar(20) DEFAULT NULL,
  `bairro_vara` varchar(20) DEFAULT NULL,
  `cep_vara` varchar(9) DEFAULT NULL,
  `cidade_vara` varchar(20) DEFAULT NULL,
  `estado_vara` varchar(2) DEFAULT NULL,
  `telefone_vara` varchar(11) DEFAULT NULL,
  `email_vara` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_vara`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
