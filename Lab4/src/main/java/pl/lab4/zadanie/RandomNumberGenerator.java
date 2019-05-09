package pl.lab4.zadanie;

import java.util.Random;

public class RandomNumberGenerator {
    private int randomNumber;

    RandomNumberGenerator(int lowerLimit, int upperLimit) {
        Random random = new Random();
        randomNumber = random.nextInt(upperLimit) + lowerLimit;
    }

    RandomNumberGenerator() {
        Random random = new Random();
        randomNumber = random.nextInt();
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
