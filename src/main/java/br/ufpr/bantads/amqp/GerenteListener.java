package br.ufpr.bantads.amqp;

import br.ufpr.bantads.model.*;
import br.ufpr.bantads.service.GerenteService;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class GerenteListener {

    @Autowired
    GerenteService gerenteService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "orchestration-manager-register")
    public void recebeAutoCadastro(@Payload String json) {
            System.out.println("Recebi a mensagem " + json.toString());
            gerenteService.autoCadastro();
    }

    /*@RabbitListener(queues = "orchestration-manager-delete")
    public void recebeRemoverGerente(@Payload GerenteDTO gerenteDTO) {
        System.out.println("Recebi a mensagem " + gerenteDTO.toString());
        gerenteService.removerGerente(gerenteDTO);
    }

   @RabbitListener(queues = "orchestration-selfregistration-manager")
    public void recebeCriarGerente(@Payload String json) {
        try {
            JSONObject parsedJson = new JSONObject(json);
            JSONObject manager = parsedJson.getJSONObject("manager");
            JSONObject action = parsedJson.getJSONObject("action");
            GerenteDTO gerenteDTO = new GerenteDTO();
            if(action.getString("action").equals("create-manager")){
                gerenteDTO.setId(manager.getString("id"));
                gerenteDTO.setNome(manager.getString("nome"));
                gerenteDTO.setEmail(manager.getString("email"));
                gerenteDTO.setCpf(manager.getString("cpf"));
            }
            gerenteService.criarGerente(gerenteDTO);
        }catch (Exception e){
            System.out.println(e);
        }
    }
*/


}
