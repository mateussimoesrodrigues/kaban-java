CREATE TABLE responsaveis_demandas_tb (
    id_responsavel_demanda INT NOT NULL AUTO_INCREMENT,
    id_demanda INT NOT NULL,
    id_responsavel INT NOT NULL,
    PRIMARY KEY (id_responsavel_demanda),
    CONSTRAINT fk_responsaveis_demandas_tb_demanda FOREIGN KEY (id_demanda) REFERENCES demandas_tb(id_demanda),
    CONSTRAINT fk_responsaveis_demandas_tb_responsavel FOREIGN KEY (id_responsavel) REFERENCES responsaveis_tb(id_responsavel)
);