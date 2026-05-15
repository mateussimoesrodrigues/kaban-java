package br.com.kanbanmateus.kanban_api.repository;

import br.com.kanbanmateus.kanban_api.entity.ResponsavelDemanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelDemandaRepository extends JpaRepository<ResponsavelDemanda, Integer> {
    
}
