package anamikroservisi.raspored_servis.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GrupaDto {
    private String oznaka;

    public GrupaDto() {
    }

    public GrupaDto(String oznaka) {
        this.oznaka = oznaka;
    }
}
