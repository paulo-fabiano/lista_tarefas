package com.paulo.lista_tarefas.service;

import com.paulo.lista_tarefas.entity.TarefaEntity;
import com.paulo.lista_tarefas.exception.TarefaNaoEncontradaException;
import com.paulo.lista_tarefas.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository r) {
        this.tarefaRepository = r;
    }

    @Override
    public TarefaEntity salvarTarefa(TarefaEntity tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public TarefaEntity buscarTarefa(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(
                        () -> new TarefaNaoEncontradaException("Não existe tafera com esse ID.")
                );
    }

    @Override
    public List<TarefaEntity> buscarTarefas() {
        return tarefaRepository.findAll();
    }

    @Override
    public void atualizarTarefa(Long id, TarefaEntity tarefaEntity) {
        tarefaRepository.findById(id)
                .ifPresentOrElse(
                        tarefa -> {
                            if (tarefaEntity.getNome() != null) {
                                tarefa.setNome(tarefaEntity.getNome());
                            }
                            if (tarefaEntity.getPrioridade() != null) {
                                tarefa.setPrioridade(tarefaEntity.getPrioridade());
                            }
                            if (tarefaEntity.getRealizado() != null) {
                                tarefa.setPrioridade(tarefaEntity.getPrioridade());
                            }
                            tarefaRepository.save(tarefa);
                        },
                        () -> {
                            throw  new TarefaNaoEncontradaException("Não existe tafera com esse ID.");
                        }
                );
    }

    @Override
    public void apagarTarefa(Long id) {
         tarefaRepository.findById(id)
                 .ifPresentOrElse(
                         tarefa ->  tarefaRepository.delete(tarefa),
                         () -> {
                             throw new TarefaNaoEncontradaException("Não existe tarefa com esse ID.");
                         }
                 );
    }
}
