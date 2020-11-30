package com.company;

public class Main {

    public static void main(String[] args) {
        Account armani = new Account("Armani", 250);
        Account nurbol = new Account("nurbol", 420);
        Account sabirkin = new Account("sabirkin", 1015);
        Account beks = new Account("beks", 344);
        Account zarina = new Account("zarina", 500);
        Account botagramm = new Account("botagramm", 215);
        Account meirzhan = new Account("meirzhan", 985);
        Account bake = new Account("bake", 235);
        Account makpalgo = new Account("makpalgo", 95);
        Account berik = new Account("berik", 879);
        Account saburov = new Account("saburov", 670);
        Account miko = new Account("miko", 267);

        Graph<Account> instagram = new Graph<>(true);

        instagram.put(nurbol, sabirkin);

        instagram.put(armani, sabirkin);
        instagram.put(armani, meirzhan);

        instagram.put(beks, sabirkin);
        instagram.put(beks,zarina);
        instagram.put(beks,meirzhan);

        instagram.put(zarina, sabirkin);

        instagram.put(botagramm, beks);
        instagram.put(botagramm, meirzhan);

        instagram.put(sabirkin, zarina);
        instagram.put(sabirkin, botagramm);

        instagram.put(berik, meirzhan);
        instagram.put(berik, saburov);

        instagram.put(bake, makpalgo);
        instagram.put(bake, meirzhan);

        instagram.put(miko, berik);
        instagram.put(miko, saburov);

        instagram.put(makpalgo, botagramm);
        instagram.put(makpalgo, bake);
        instagram.put(makpalgo, saburov);

        instagram.put(saburov, berik);

        //System.out.println(instagram.find_account());



        City aktau = new City("Aktau", 76);
        City atyrau = new City("Atyrau", 55);
        City aktobe = new City("Aktobe", 87);
        City qyzylorda = new City("Qyzylorda", 105);
        City turkistan = new City("Turkistan", 45);
        City shymkent = new City("Shymkent", 50);
        City karagandy = new City("Karagandy", 98);
        City nursultan = new City("Nursultan", 220);
        City shu = new City("Shu", 20);
        City almaty = new City("Almaty", 120);
        City semey = new City("Semey", 35);
        City oskemen = new City("Oskemen", 68);

        Graph<City> list = new Graph<>(false);
        list.put(aktau, atyrau, 6);
        list.put(aktau, qyzylorda, 6);
        list.put(atyrau, qyzylorda, 8);
        list.put(atyrau, aktobe, 4);
        list.put(aktobe, qyzylorda, 14);
        list.put(qyzylorda, turkistan, 3);
        list.put(turkistan, shymkent, 5);
        list.put(shymkent, karagandy, 13);
        list.put(qyzylorda, karagandy, 12);
        list.put(aktobe, nursultan, 9);
        list.put(nursultan, karagandy, 4);
        list.put(shymkent, almaty, 10);
        list.put(almaty,karagandy, 16);
        list.put(almaty, shu, 4);
        list.put(almaty, oskemen, 19);
        list.put(oskemen, karagandy, 16);
        list.put(oskemen, semey, 6);
        list.put(almaty,semey, 17);
        list.put(semey,nursultan, 6);

        list.ambulance(shymkent, 15);




    }
}
