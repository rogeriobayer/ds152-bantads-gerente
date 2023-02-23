package br.ufpr.bantads.service;

import br.ufpr.bantads.model.*;
import br.ufpr.bantads.repository.GerenteRepository;
import org.apache.coyote.Response;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    public void autoCadastro(){
        Gerente g = repo.findFirstByOrderByNumClientes();
        g.setNum_clientes(g.getNum_clientes()+1);
        repo.save(g);
    }

    public void removerGerente(GerenteDTO gerenteDTO){
        Gerente g = repo.findByCpf(gerenteDTO.getCpf());
        repo.delete(g);
    }

    public void criarGerente(GerenteDTO gerenteDTO) {
        try {
            Gerente g = repo.findLastByOrderByNumClientes();
            g.setNum_clientes(g.getNum_clientes() - 1);
            gerenteDTO.setNum_clientes(1);
            Gerente gerenteNovo = modelMapper.map(gerenteDTO, Gerente.class);
            repo.save(g);
            repo.save(gerenteNovo);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
