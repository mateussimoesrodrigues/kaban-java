package br.com.kanbanmateus.kanban_api.repository;

import br.com.kanbanmateus.kanban_api.entity.SubDemanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDemandaRepository extends JpaRepository<SubDemanda, Integer> {
    
}
