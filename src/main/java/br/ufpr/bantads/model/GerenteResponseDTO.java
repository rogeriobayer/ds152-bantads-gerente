package br.ufpr.bantads.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GerenteResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public String id;
    public String idManager;


}
