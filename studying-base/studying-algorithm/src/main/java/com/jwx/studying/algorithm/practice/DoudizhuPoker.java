package com.jwx.studying.algorithm.practice;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * PackageName:com.jwx.studying.algorithm.practice
 * FileName: DoudizhuPoker.java
 * Description:
 * 要求：一个类似于斗地主洗牌（52张）、发牌的算法
 * <p>
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/15
 */
public class DoudizhuPoker {

    /**
     * 纸牌花色枚举类
     */
    private enum ColorEnum {

        HONGTAO(0, "红桃"),

        FANGKUAI(1, "方块"),

        HEITAO(2, "黑桃"),

        MEIHUA(3, "梅花");

        private String value;
        private int id;

        ColorEnum(int id, String value) {
            this.id = id;
            this.value = value;
        }

        private static Map<Integer, String> idMap = new HashMap<Integer, String>();

        static {
            for (ColorEnum colorEnums : ColorEnum.values()) {
                idMap.put(colorEnums.id, colorEnums.value);
            }
        }

        public static String parseId(int id) {
            return idMap.get(id);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    /**
     * 纸牌类
     */
    private class Card {

        /**
         * 纸牌花色
         */
        private String color;
        /**
         * 纸牌数字
         */
        private int number;

        public String getColorEnum() {
            return color;
        }

        public void setColorEnum(String color) {
            this.color = color;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String toString() {
            return this.color + "-" + this.number;
        }
    }

    /**
     * 玩家类
     */
    private class player {
        /**
         * 玩家牌组
         */
        private List<Card> CardArray = new ArrayList<Card>(18);

        /**
         * 玩家姓名
         */
        private String name;

        public List<Card> getCardArray() {
            return CardArray;
        }

        public void setCardArray(List<Card> cardArray) {
            CardArray = cardArray;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public void shuffle(List<Card> pokerList, int count) {
        for (int i = 0; i < count; i++) {
            int length = pokerList.size();
            int x = (int) Math.round(Math.random() * pokerList.size());
            int y = (int) Math.round(Math.random() * pokerList.size());
            List<Card> tempList = pokerList.subList(Math.min(x, y), Math.max(x, y));
            List<Card> cloneL = new ArrayList<>(tempList);
            pokerList.removeAll(tempList);
            pokerList.addAll(cloneL);
        }
    }


    public static void main(String[] args) {
        List<Card> list = Lists.newArrayList();
        for (int i = 1; i <= 13; i++) {
            Card card = null;
            for (int j = 0; j < 4; j++) {
                card = new DoudizhuPoker().new Card();
                card.setNumber(i);
                card.setColorEnum(ColorEnum.parseId(j % 4));
                list.add(card);
            }
        }
        new DoudizhuPoker().shuffle(list, 30);
        /*    list.sort(Comparator.comparing(Card::getNumber));*/
        list.stream().forEach(var -> System.out.println(var));
    }

}
