package ua.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.edu.ucu.aps.flower.Flower;
import ua.edu.ucu.aps.flower.FlowerBucket;
import ua.edu.ucu.aps.flower.FlowerColor;
import ua.edu.ucu.aps.flower.FlowerPack;
import ua.edu.ucu.aps.flower.FlowerType;
import ua.edu.ucu.aps.flower.Store;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    private Store store;

    @BeforeEach
    public void setUp() {
        store = new Store();
    }

    @Test
    public void testAddFlower() {
        Flower flower = new Flower(5.0, FlowerColor.RED, 10.0, FlowerType.ROSE);
        store.addFlower(flower);
        List<Flower> flowers = store.search(FlowerType.ROSE, FlowerColor.RED);
        assertEquals(1, flowers.size());
        assertEquals(flower, flowers.get(0));
    }

    @Test
    public void testSearchByTypeAndColor() {
        Flower flower1 = new Flower(5.0, FlowerColor.RED, 10.0, FlowerType.ROSE);
        Flower flower2 = new Flower(6.0, FlowerColor.WHITE, 12.0, FlowerType.CHAMOMILE);
        Flower flower3 = new Flower(4.5, FlowerColor.YELLOW, 8.0, FlowerType.ROSE);
        store.addFlower(flower1);
        store.addFlower(flower2);
        store.addFlower(flower3);

        List<Flower> result = store.search(FlowerType.ROSE, FlowerColor.RED);
        assertEquals(1, result.size());
        assertEquals(flower1, result.get(0));

        result = store.search(FlowerType.CHAMOMILE, FlowerColor.WHITE);
        assertEquals(1, result.size());
        assertEquals(flower2, result.get(0));

        result = store.search(FlowerType.ROSE, FlowerColor.YELLOW);
        assertEquals(1, result.size());
        assertEquals(flower3, result.get(0));
    }

    @Test
    public void testSearchNoResults() {
        List<Flower> result = store.search(FlowerType.ROSE, FlowerColor.WHITE);
        assertTrue(result.isEmpty());
    }
}
