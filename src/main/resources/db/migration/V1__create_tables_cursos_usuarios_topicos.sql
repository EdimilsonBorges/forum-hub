USE forumhub;

CREATE TABLE cursos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL UNIQUE,
  categoria VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

CREATE TABLE usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

CREATE TABLE topicos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL UNIQUE,
  mensagem VARCHAR(500) NOT NULL UNIQUE,
  data_criacao DATETIME NOT NULL,
  usuario_id BIGINT NOT NULL,
  curso_id BIGINT NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_topicos_usuarios
      FOREIGN KEY (usuario_id)
      REFERENCES usuarios (id)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT fk_topicos_cursos
      FOREIGN KEY (curso_id)
      REFERENCES cursos (id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
