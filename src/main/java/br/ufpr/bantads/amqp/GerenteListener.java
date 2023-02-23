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

    @RabbitListener(queues = "orchestration-selfregistration-manager")
    public void recebeAutoCadastro(@Payload PayloadDTO payloadDTO) {
            System.out.println("Recebi a mensagem " + payloadDTO.toString());
            ResponseDTO responseDTO = gerenteService.autoCadastro(payloadDTO);
    }

    @RabbitListener(queues = "orchestration-manager-delete")
    public void recebeRemoverGerente(@Payload GerenteDTO gerenteDTO) {
        System.out.println("Recebi a mensagem " + gerenteDTO.toString());
        gerenteService.removerGerente(gerenteDTO);
    }

    @RabbitListener(queues = "orchestration-manager-create")
    public void recebeCriarGerente(@Payload GerenteDTO gerenteDTO) {
        System.out.println("Recebi a mensagem " + gerenteDTO.toString());
        gerenteService.criarGerente(gerenteDTO);
    }



}
