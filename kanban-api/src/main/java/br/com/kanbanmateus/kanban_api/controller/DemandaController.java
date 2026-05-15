package br.com.kanbanmateus.kanban_api.controller;

import br.com.kanbanmateus.kanban_api.dto.DemandaUpdateRequest;
import br.com.kanbanmateus.kanban_api.entity.Demanda;
import br.com.kanbanmateus.kanban_api.service.DemandaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandas")
@CrossOrigin(origins = "*")
public class DemandaController {

    private final DemandaService demandaService;

    public DemandaController(DemandaService demandaService) {
        this.demandaService = demandaService;
    }

    @GetMapping
    public ResponseEntity<List<Demanda>> buscarTodas() {
        return ResponseEntity.ok(demandaService.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demanda> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(demandaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Demanda> inserir(@RequestBody Demanda demanda) {
        return ResponseEntity.ok(demandaService.inserir(demanda));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Demanda> atualizarStatus(
            @PathVariable Integer id,
            @RequestBody Demanda novoStatus
    ) {
        return ResponseEntity.ok(demandaService.atualizarStatus(id, novoStatus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Demanda> atualizarDemandaEVincularResponsavel(
            @PathVariable Integer id,
            @RequestBody DemandaUpdateRequest request
    ) {
        Demanda demanda = new Demanda();
        demanda.setTitulo(request.getTitulo());
        demanda.setTipo(request.getTipo());
        demanda.setDescricao(request.getDescricao());
        demanda.setDataInicio(request.getDataInicio() != null ? request.getDataInicio().atStartOfDay() : null);
        demanda.setDataFimP(request.getDataFimP() != null ? request.getDataFimP().atStartOfDay() : null);
        demanda.setDataFimR(request.getDataFimR() != null ? request.getDataFimR().atStartOfDay() : null);
        demanda.setPrioridade(request.getPrioridade());
        demanda.setStatus(request.getStatus());
        demanda.setSegmento(request.getSegmento());
        demanda.setSegmentoDetalhe(request.getSegmentoDetalhe());
        demanda.setDataCriacao(request.getDataCriacao() != null ? request.getDataCriacao().atStartOfDay() : null);
        demanda.setCriadorDemanda(request.getCriadorDemanda());

        return ResponseEntity.ok(
                demandaService.atualizarDemandaEVincularResponsavel(
                        id,
                        demanda,
                        request.getIdResponsavel()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        demandaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}