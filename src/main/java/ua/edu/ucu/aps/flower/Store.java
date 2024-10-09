package ua.edu.ucu.aps.flower;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Flower> flowers;

    public Store() {
        flowers = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public List<Flower> search(FlowerType flowerType, FlowerColor flowerColor) {
        List<Flower> result = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getFlowerType() == flowerType && flower.getColor().equals(flowerColor.getCode())) {
                result.add(flower);
            }
        }
        return result;
    }
}
