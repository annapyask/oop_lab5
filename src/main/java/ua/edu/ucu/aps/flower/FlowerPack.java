package ua.edu.ucu.aps.flower;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class FlowerPack {
    private Flower flower;
    private int count;
    public FlowerPack(Flower flower, int count) {
        this.flower = flower;
        this.count = count;
    }
    
}
