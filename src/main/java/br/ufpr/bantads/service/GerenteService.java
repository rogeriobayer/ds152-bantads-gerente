package br.ufpr.bantads.service;

import br.ufpr.bantads.model.*;
import br.ufpr.bantads.repository.GerenteRepository;
import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repo;

    public ResponseDTO autoCadastro(PayloadDTO payloadDTO){
        Gerente g = repo.findFirstByOrderByNumClientes();
        g.setNum_clientes(g.getNum_clientes()+1);
        repo.save(g);
        return new ResponseDTO(new GerenteResponseDTO("2e7aeda7-4d07-487e-8d5d-d75a41438140","2e7aeda7-4d07-487e-8d5d-d75a41438140"),"manager-ok");
    }

    public void removerGerente(GerenteDTO gerenteDTO){
        Gerente g = repo.findByCpf(gerenteDTO.getCpf());
        repo.delete(g);
    }

    public void criarGerente(GerenteDTO gerenteDTO) {
        Gerente g = repo.findLastByOrderByNumClientes();

    }
}
