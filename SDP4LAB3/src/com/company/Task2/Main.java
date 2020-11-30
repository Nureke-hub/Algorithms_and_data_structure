package com.company.Task2;

public class Main {
    public static void main(String[] args){
        Money money = new Money(200, Currency.TNG, 5);
        Money money1 = new Money(500, Currency.TNG, 2);
        Money money2 = new Money(1000, Currency.TNG, 3);
        Money money3 = new Money(2000, Currency.TNG, 9);
        Money money4 = new Money(5000, Currency.RUB, 1);
        Money money5 = new Money(10000, Currency.RUB, 6);
        Money money6 = new Money(20000, Currency.RUB, 4);

        Money money7 = new Money(1, Currency.USD, 5);
        Money money8 = new Money(500, Currency.USD, 2);
        Money money9 = new Money(1000, Currency.USD, 3);
        Money money10 = new Money(2000, Currency.EUR, 9);
        Money money11 = new Money(5000, Currency.EUR, 1);
        Money money12 = new Money(10000, Currency.EUR, 6);
        Money money13 = new Money(20000, Currency.EUR, 4);


        if(money6.compareTo(money8) == 1){
            System.out.println(money6);
        }else if (money6.compareTo(money8) == -1){
            System.out.println(money8);
        }else{
            System.out.println("Ravno");
        }

        System.out.println();

        Wallet wallet = new Wallet(4);
        wallet.add(money);
        wallet.add(money1);
        wallet.add(money6);
        wallet.add(money3);
        wallet.add(money7);
        wallet.add(money11);
        wallet.add(money2);
        wallet.add(money4);


        Wallet wallet1 = new Wallet();
        wallet1.add(money2);
        wallet1.add(money5);
        wallet1.add(money8);
        wallet1.add(money10);
        wallet1.add(money12);
        wallet1.add(money9);

        System.out.println(wallet);
        System.out.println(wallet1);

        System.out.println();

        wallet.sort();
        wallet1.sort();

        System.out.println(wallet);
        System.out.println(wallet1);


        if(wallet.compareTo(wallet1) == 1){
            System.out.println("wallet");
        }else if(wallet.compareTo(wallet1) == -1){
            System.out.println("wallet1");
        } else {
            System.out.println("Ravno");
        }

    }
}
