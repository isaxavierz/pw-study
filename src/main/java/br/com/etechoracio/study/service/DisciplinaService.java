package br.com.etechoracio.study.service;

import br.com.etechoracio.study.entity.Disciplina;
import br.com.etechoracio.study.entity.Monitor;
import br.com.etechoracio.study.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> listar(){
        return repository.findAll();
    }
    public Disciplina buscarPorId(Long id){
        var existe = repository.findById(id);
        if(existe.isPresent())
            return existe.get();
        return null;
    }
    public Disciplina buscarPorNome(String nome){
        return repository.findByNome(nome);
    }

    public Disciplina cadastrar(Disciplina disciplina){
        return repository.save(disciplina);
    }

    public Disciplina alterar(Disciplina disciplina) {

        var existe = buscarPorId(disciplina.getId());
        if (existe != null){
            System.out.println("Monitor alterado.");
            return repository.save(disciplina);
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
