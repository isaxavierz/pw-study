package br.com.etechoracio.study.service;

import br.com.etechoracio.study.entity.Disciplina;
import br.com.etechoracio.study.entity.Monitor;
import br.com.etechoracio.study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {
    @Autowired
    private MonitorRepository repository;

    public List<Monitor> listar(){
        return repository.findAll();
    }

    public Monitor buscarPorId(Long id){
        var existe = repository.findById(id);
        if(existe.isPresent())
            return existe.get();
        return null;
    }

    public Monitor buscarPorNome(String nome){
        return repository.findByNome(nome);
    }

    public Monitor cadastrar(Monitor monitor){
        return repository.save(monitor);
    }

    public Monitor alterar(Monitor monitor) {

        var existe = buscarPorId(monitor.getId());
        if (existe != null){
            System.out.println("Monitor alterado.");
            return repository.save(monitor);
        }
        else {
            return null;
        }
    }

    public void excluir(Long id){
        var existe = buscarPorId(id);
        if(existe != null)
            repository.deleteById(id);
    }
}
