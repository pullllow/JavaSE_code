package com.learnJava5;

import java.util.*;

public class PockerDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        ArrayList<Integer> array = new ArrayList<Integer>();

        String[] colors = {"♦", "♥", "♣", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int index = 0;

        for (String number : numbers) {
            for (String color : colors) {
                array.add(index);
                hm.put(index, color + number);
                index++;
            }
        }

        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);

        System.out.println(array);
        System.out.println("------------");

        Collections.shuffle(array);
        System.out.println(array);

        ArrayList<Integer> player1Set = new ArrayList<Integer>();
        ArrayList<Integer> player2Set = new ArrayList<Integer>();
        ArrayList<Integer> player3Set = new ArrayList<Integer>();
        ArrayList<Integer> bottomSet = new ArrayList<Integer>();

        for (int i = 0; i < array.size(); i++) {

            if (i >= array.size() - 3) {
                bottomSet.add(array.get(i));
            } else if (i % 3 == 0) {
                player1Set.add(array.get(i));
            } else if (i % 3 == 1) {
                player2Set.add(array.get(i));
            } else if (i % 3 == 2) {
                player3Set.add(array.get(i));
            }

        }
        lookPoker("player1", player1Set, hm);
        lookPoker("player2", player2Set, hm);
        lookPoker("player3", player3Set, hm);
        lookPoker("底牌", bottomSet, hm);


        TreeSet<Integer> player1 = new TreeSet<Integer>();
        TreeSet<Integer> player2 = new TreeSet<Integer>();
        TreeSet<Integer> player3 = new TreeSet<Integer>();
        TreeSet<Integer> bottom = new TreeSet<Integer>();

        for (int ind = 0; ind < player1Set.size(); ind++) {
            player1.add(player1Set.get(ind));
            player2.add(player2Set.get(ind));
            player3.add(player3Set.get(ind));
            if (ind <= 2) {
                bottom.add(bottomSet.get(ind));
            }
        }
        System.out.println("---------------------");
        lookPoker("player1", player1, hm);
        lookPoker("player2", player2, hm);
        lookPoker("player3", player3, hm);
        lookPoker("底牌", bottom, hm);

    }

    public static void lookPoker(String name, ArrayList<Integer> ts, HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是：");
        for (Integer key : ts) {
            String poker = hm.get(key);
            System.out.printf(poker + " ");
        }
        System.out.println();
    }

    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是：");
        for (Integer key : ts) {
            String poker = hm.get(key);
            System.out.printf(poker + " ");
        }
        System.out.println();
    }

}
