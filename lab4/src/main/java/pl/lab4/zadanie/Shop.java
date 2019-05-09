package pl.lab4.zadanie;

public abstract class Shop {
    private int budget;

    Shop(int budget){
        this.budget=budget;
    }

    protected void increaseBudget(int amountOfMoney) {
        budget += amountOfMoney;
    }

    protected void decreaseBudget(int amountOfMoney) {
        budget -= amountOfMoney;
    }

    protected int getBudget() {
        return budget;
    }
}
