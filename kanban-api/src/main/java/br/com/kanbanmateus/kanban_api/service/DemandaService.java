package br.com.kanbanmateus.kanban_api.service;

import br.com.kanbanmateus.kanban_api.entity.Demanda;
import br.com.kanbanmateus.kanban_api.entity.Responsavel;
import br.com.kanbanmateus.kanban_api.entity.ResponsavelDemanda;
import br.com.kanbanmateus.kanban_api.repository.DemandaRepository;
import br.com.kanbanmateus.kanban_api.repository.ResponsavelDemandaRepository;
import br.com.kanbanmateus.kanban_api.repository.ResponsavelRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DemandaService {

    private final DemandaRepository demandaRepository;
    private final ResponsavelRepository responsavelRepository;
    private final ResponsavelDemandaRepository responsavelDemandaRepository;

    public DemandaService(DemandaRepository demandaRepository, ResponsavelRepository responsavelRepository, ResponsavelDemandaRepository responsavelDemandaRepository) {
        this.demandaRepository = demandaRepository;
        this.responsavelRepository = responsavelRepository;
        this.responsavelDemandaRepository = responsavelDemandaRepository;
    }

    public List<Demanda> buscarTodas() {
        return demandaRepository.findAll();
    }

    public Demanda buscarPorId(Integer id) {
        return demandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demanda não encontrada com id: " + id));
    }

    public Demanda inserir(Demanda demanda) {
        return demandaRepository.save(demanda);
    }

    public Demanda atualizarStatus(Integer idDemanda, Demanda novoStatus) {
        Demanda demanda = demandaRepository.findById(idDemanda)
                .orElseThrow(() -> new RuntimeException("Demanda não encontrada com id: " + idDemanda));

        demanda.setStatus(novoStatus.getStatus());
        return demandaRepository.save(demanda);
    }

    @Transactional
    public Demanda atualizarDemandaEVincularResponsavel(
            Integer idDemanda,
            Demanda demandaAtualizada,
            Integer idResponsavel
    ) {
        Demanda demanda = demandaRepository.findById(idDemanda)
                .orElseThrow(() -> new RuntimeException("Demanda não encontrada"));

        Responsavel responsavel = responsavelRepository.findById(idResponsavel)
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));

        demanda.setTitulo(demandaAtualizada.getTitulo());
        demanda.setTipo(demandaAtualizada.getTipo());
        demanda.setDescricao(demandaAtualizada.getDescricao());
        demanda.setDataInicio(demandaAtualizada.getDataInicio());
        demanda.setDataFimP(demandaAtualizada.getDataFimP());
        demanda.setDataFimR(demandaAtualizada.getDataFimR());
        demanda.setPrioridade(demandaAtualizada.getPrioridade());
        demanda.setStatus(demandaAtualizada.getStatus());
        demanda.setSegmento(demandaAtualizada.getSegmento());
        demanda.setSegmentoDetalhe(demandaAtualizada.getSegmentoDetalhe());
        demanda.setDataCriacao(demandaAtualizada.getDataCriacao());
        demanda.setCriadorDemanda(demandaAtualizada.getCriadorDemanda());

        ResponsavelDemanda responsavelDemanda = new ResponsavelDemanda();
        responsavelDemanda.setDemanda(demanda);
        responsavelDemanda.setResponsavel(responsavel);

        responsavelDemandaRepository.save(responsavelDemanda);

        return demandaRepository.save(demanda);
    }

    public void deletarPorId(Integer id) {
        if (!demandaRepository.existsById(id)) {
            throw new RuntimeException("Demanda não encontrada com id: " + id);
        }
        demandaRepository.deleteById(id);
    }
}
