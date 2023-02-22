package br.ufpr.bantads.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayloadDTO implements Serializable {

    private UsuarioDTO manager;
    private String action;

    @Override
    public String toString() {
        return "PayloadDTO{" +
                "manager=" + manager +
                ", action='" + action + '\'' +
                '}';
    }
}
