package com.paulo.lista_tarefas.service;

import com.paulo.lista_tarefas.entity.TarefaEntity;
import com.paulo.lista_tarefas.exception.TarefaNaoEncontradaException;

import java.util.List;

public interface TarefaService {

    TarefaEntity salvarTarefa(TarefaEntity tarefa);
    TarefaEntity buscarTarefa(Long id) throws TarefaNaoEncontradaException;
    List<TarefaEntity> buscarTarefas();
    void atualizarTarefa(Long id, TarefaEntity tarefa) throws TarefaNaoEncontradaException;
    void apagarTarefa(Long id) throws TarefaNaoEncontradaException;

}
