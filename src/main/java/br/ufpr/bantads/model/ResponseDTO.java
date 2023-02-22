package br.ufpr.bantads.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO {
    private GerenteResponseDTO manager;
    private String action;




}
