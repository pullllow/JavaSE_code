package com.writtenexam.test;
/*
 *  @author changqi
 *  @date 2022/3/5 13:45
 *  @description
 *  @Version V1.0
 */


import org.w3c.dom.Element;

import java.util.*;


class UnionFind<V> {

    public class Element<V> {
        public V value;


        public Element(V value) {
            this.value = value;
        }
    }


    public Map<V, Element<V>> elementMap;
    public Map<Element<V>, Element<V>> fatherMap;
    public Map<Element<V>, Integer> rankMap;

    public UnionFind(List<V> lists) {

        elementMap = new HashMap<>();

        fatherMap = new HashMap<>();

        rankMap = new HashMap<>();

        for (V list : lists) {
            Element<V> element = new Element<>(list);
            elementMap.put(list, element);
            fatherMap.put(element,element);
            rankMap.put(element,1);
        }
    }

    public Element<V> findHead(Element<V> element) {

        LinkedList<Element<V>> path = new LinkedList<>();

        while(element != fatherMap.get(element)) {
            path.offer(element);
            element = fatherMap.get(element);
        }

        while(!path.isEmpty()) {
            fatherMap.put(path.getLast(), element);
        }

        return element;
    }

    public boolean isSameHead(V a, V b) {
        if(elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }

        return false;
    }


    public void union(V a, V b) {
        if(elementMap.containsKey(a) && elementMap.containsKey(b)) {

            Element<V> aF = fatherMap.get(elementMap.get(a));
            Element<V> bF = fatherMap.get(elementMap.get(b));

            if(aF != bF) {
                Element<V> big = rankMap.get(aF)>rankMap.get(bF)?aF:bF;
                Element<V> small = rankMap.get(aF)<rankMap.get(bF)?aF:bF;

                fatherMap.put(small,big);
                rankMap.put(big, rankMap.get(big)+ rankMap.get(small));
                rankMap.remove(small);


            }

        }


    }
}