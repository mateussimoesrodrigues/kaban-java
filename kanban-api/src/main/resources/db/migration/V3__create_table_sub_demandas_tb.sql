CREATE TABLE sub_demandas_tb (
    id_sub_demanda INT NOT NULL AUTO_INCREMENT,
    id_demanda INT NOT NULL,
    id_responsavel INT NOT NULL,
    TAREFA VARCHAR(100) DEFAULT NULL,
    DATA_INICIO DATETIME DEFAULT NULL,
    DATA_FIM_P DATETIME DEFAULT NULL,
    DATA_FIM_R DATETIME DEFAULT NULL,
    OBSERVACAO TEXT,
    STATUS VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (id_sub_demanda),
    CONSTRAINT fk_sub_demanda_demanda FOREIGN KEY (id_demanda) REFERENCES demandas_tb(id_demanda),
    CONSTRAINT fk_sub_demanda_responsavel FOREIGN KEY (id_responsavel) REFERENCES responsaveis_tb(id_responsavel)
);