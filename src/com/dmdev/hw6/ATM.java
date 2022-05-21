package com.dmdev.hw6;

public class ATM {

    private final int TWENTY = 20;
    private final int FIFTY = 50;
    private final int ONE_HUNGRED = 100;

    int[] Banknotes = {ONE_HUNGRED, FIFTY, TWENTY};

    private int twentyNominationQuantity;
    private int fiftyNominationQuantity;
    private int oneHundredNominationQuantity;

    public void setTwentyNominationQuantity(int twentyNominationQuantity) {
        this.twentyNominationQuantity = twentyNominationQuantity;
    }

    public void setFiftyNominationQuantity(int fiftyNominationQuantity) {
        this.fiftyNominationQuantity = fiftyNominationQuantity;
    }

    public void setOneHundredNominationQuantity(int oneHundredNominationQuantity) {
        this.oneHundredNominationQuantity = oneHundredNominationQuantity;
    }


    public int getTwentyNominationQuantity() {
        return twentyNominationQuantity;
    }

    public int getFiftyNominationQuantity() {
        return fiftyNominationQuantity;
    }


    public int getOneHundredNominationQuantity() {
        return oneHundredNominationQuantity;
    }


    public ATM(int twentyNominationQuantity, int fiftyNominationQuantity, int oneHundredNominationQuantity) {
        this.twentyNominationQuantity = twentyNominationQuantity;
        this.fiftyNominationQuantity = fiftyNominationQuantity;
        this.oneHundredNominationQuantity = oneHundredNominationQuantity;
    }


    public void putMoney(int inputTwentyNominationQuantity, int inputFiftyNominationQuantity,
                         int inputOneHundredNominationQuantity) {
        this.setTwentyNominationQuantity(this.getTwentyNominationQuantity() + inputTwentyNominationQuantity);
        this.setFiftyNominationQuantity(this.getFiftyNominationQuantity() + inputFiftyNominationQuantity);
        this.setOneHundredNominationQuantity(this.getOneHundredNominationQuantity() + inputOneHundredNominationQuantity);
    }


    private int getNominationQuantity(int nomination) {
        return switch (nomination) {
            case TWENTY -> this.getTwentyNominationQuantity();
            case FIFTY -> this.getFiftyNominationQuantity();
            case ONE_HUNGRED -> this.getOneHundredNominationQuantity();
            default -> 0;
        };
    }

    private void setNominationQuantity(int nomination, int value) {
        switch (nomination) {
            case TWENTY -> this.setTwentyNominationQuantity(value);
            case FIFTY -> this.setFiftyNominationQuantity(value);
            case ONE_HUNGRED -> this.setOneHundredNominationQuantity(value);
            default -> {
            }
        }
        ;
    }

    private int getCurrentSum() {
        int twenty = this.getTwentyNominationQuantity() * TWENTY;
        int fifty = this.getFiftyNominationQuantity() * FIFTY;
        int oneHundred = this.getOneHundredNominationQuantity() * ONE_HUNGRED;
        return twenty + fifty + oneHundred;
    }

    public boolean withdrawMoney(int withdrawSum) {
        int[] withdrawNominationAmount = new int[Banknotes.length];
        int withdrawBalance = withdrawSum;
        int currentSum = this.getCurrentSum();
        if (withdrawBalance > currentSum) {
            return false;
        }
        for (int i = 0; i < Banknotes.length; i++) {
            int withdrawNominationAmountNeeded = withdrawBalance / Banknotes[i];
            int quantity = this.getNominationQuantity(Banknotes[i]);
            if (quantity < withdrawNominationAmountNeeded) {
                withdrawNominationAmountNeeded = quantity;
            }
            withdrawNominationAmount[i] = withdrawNominationAmountNeeded;
            withdrawBalance -= withdrawNominationAmountNeeded * Banknotes[i];
            if (withdrawBalance == 0) {
                break;
            }
        }
        if (withdrawBalance != 0) {
            return false;
        }
        for (int i = 0; i < Banknotes.length; i++) {
            int quantity = this.getNominationQuantity(Banknotes[i]);
            System.out.println("Выдается " + withdrawNominationAmount[i] + " купюры номиналом " + Banknotes[i]);
            this.setNominationQuantity(Banknotes[i], quantity - withdrawNominationAmount[i]);
        }
        return true;

    }
}