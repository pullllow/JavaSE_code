package com.demo.unionfind;
/*
 *  @author changqi
 *  @date 2021/12/6 16:05
 *  @description
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionFind<V> {

    private class Element<V> {
        //封住为类 便于计算hash值
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public Map<V, Element<V>> elementMap;
    public Map<Element<V>, Element<V>> fatherMap;
    public Map<Element<V>, Integer> rankMap; //所有头结点的size


    public UnionFind(List<V> lists) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        rankMap = new HashMap<>();

        for (V list : lists) {
            Element<V> element = new Element<>(list);
            elementMap.put(list, element);
            fatherMap.put(element, element);
            rankMap.put(element, 1);
        }

    }

    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> path = new Stack<>();

        while (element != fatherMap.get(element)) {
            path.push(element);
            element = fatherMap.get(element);
        }

        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), element);
        }

        return element;

    }

    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {

            Element<V> aF = fatherMap.get(elementMap.get(a));
            Element<V> bF = fatherMap.get(elementMap.get(b));

            if (aF != bF) {
                Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                Element<V> small = big == aF ? bF : aF;
                fatherMap.put(small, big);
                rankMap.put(big, rankMap.get(big) + rankMap.get(small));
                rankMap.remove(small);
            }


        }
    }


}
