package Silver.날짜계산_1476;
// 당신은 또한 가져오기를 사용할 수 있습니다, 예를 들면: // import java.util. *;  // 디버깅 목적으로 stdout에 쓸 수 있습니다, 예. // System.out.println("이것은 디버그 메시지입니다");  클래스 솔루션 { Public int solution(int[] start, int[] dest, int[] limit) { // 여기에서 당신의 해결책을 구현하세요 }ss// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message")sd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(Pizza[] menu, OrderItem[] order) {
        int totalCost = 0;
        Map<String, Pizza> pizzaName = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaName.put(pizza.name, pizza);
        }

        for (OrderItem item : order) {
            Pizza pizza = pizzaName.get(item.name);
            int price = 0;
            switch (item.size) {
                case "Small":
                    price = pizza.price_S;
                    break;
                case "Medium":
                    price = pizza.price_M;
                    break;
                case "Large":
                    price = pizza.price_L;
                    break;
            }
            totalCost += price * item.quantity;
        }

        int minCost = totalCost; // 초기값은 할인 없는 총 비용


        // 1. 3개 이상 피자 할인
        int discount1Cost = totalCost;
        if(totalPizzas(order) >= 3){
            discount1Cost =  firstSolustion(order,pizzaName,totalCost);
            minCost = Math.min(minCost,discount1Cost);
        }


        // 2. 5개 동일 피자 할인
        int discount2Cost = totalCost;
        if (hasFiveSamePizza(order)) {
            discount2Cost = secondSolustion(order, pizzaName, totalCost);
            minCost = Math.min(minCost,discount2Cost);
        }

        // 3. 스몰 - 라지 조합 할인
        int discount3Cost = thridSolustion(order, pizzaName, totalCost);
        minCost = Math.min(minCost,discount3Cost);


        // 4. 라지 피자 3개 이상 할인
        int discount4Cost = totalCost;
        if (hasThreeLargePizza(order)) {
            discount4Cost = fourthSolustion(order, pizzaName, totalCost);
            minCost = Math.min(minCost,discount4Cost);
        }

        return minCost;
    }

    public int fourthSolustion(OrderItem[] order, Map<String, Pizza> pizzaName, int cost) {
        int minCost = cost;
        List<OrderItem> largePizzas = new ArrayList<>();
        for (OrderItem item : order) {
            if (item.size.equals("Large")) {
                for (int i = 0; i < item.quantity; i++) {
                    largePizzas.add(item);
                }
            }
        }
        if (largePizzas.size() >= 3) {
            for (int i = 0; i <= largePizzas.size() - 3; i++) {
                int tempCost = cost;
                for (int j = i; j < i + 3; j++) {
                    Pizza pizza = pizzaName.get(largePizzas.get(j).name);
                    tempCost -= pizza.price_L;
                    tempCost += pizza.price_M;
                }
                minCost = Math.min(minCost, tempCost);
            }
        }
        return minCost;
    }


    public int thridSolustion(OrderItem[] order, Map<String, Pizza> pizzaName, int cost) {
        int discountedCost = cost;
        Map<String, Integer> smallCounts = new HashMap<>();
        Map<String, Integer> largeCounts = new HashMap<>();

        for (OrderItem item : order) {
            if (item.size.equals("Small")) {
                smallCounts.put(item.name, smallCounts.getOrDefault(item.name, 0) + item.quantity);
            } else if (item.size.equals("Large")) {
                largeCounts.put(item.name, largeCounts.getOrDefault(item.name, 0) + item.quantity);
            }
        }

        for(String pizzaNameStr : smallCounts.keySet()){
            if(largeCounts.containsKey(pizzaNameStr)){
                int discountCount = Math.min(smallCounts.get(pizzaNameStr), largeCounts.get(pizzaNameStr));
                Pizza pizza = pizzaName.get(pizzaNameStr);
                discountedCost -= pizza.price_S * discountCount;
            }
        }
        return discountedCost;
    }


    public int secondSolustion(OrderItem[] order, Map<String, Pizza> pizzaName, int cost) {
        int minCost = cost;
        Map<String, Integer> pizzaCounts = new HashMap<>();
        for (OrderItem item : order) {
            pizzaCounts.put(item.name, pizzaCounts.getOrDefault(item.name, 0) + item.quantity);
        }

        for(String name : pizzaCounts.keySet()){
            if (pizzaCounts.get(name) >= 5) {
                Pizza pizza = pizzaName.get(name);
                int minPrice = Integer.MAX_VALUE;
                for (OrderItem item : order) {
                    if(item.name.equals(name)){
                        switch (item.size) {
                            case "Small":
                                minPrice = Math.min(minPrice,pizza.price_S);
                                break;
                            case "Medium":
                                minPrice =  Math.min(minPrice,pizza.price_M);
                                break;
                            case "Large":
                                minPrice =  Math.min(minPrice,pizza.price_L);
                                break;
                        }
                    }
                }
                minCost = Math.min(minCost,cost - (minPrice * 5) + 100);

            }
        }

        return minCost;
    }


    public int firstSolustion(OrderItem[] order, Map<String, Pizza> pizzaName, int cost) {
        int minCost = cost;
        List<Integer> pizzaPrices = new ArrayList<>();
        for (OrderItem item : order) {
            Pizza pizza = pizzaName.get(item.name);
            int price = 0;
            switch (item.size) {
                case "Small":
                    price = pizza.price_S;
                    break;
                case "Medium":
                    price = pizza.price_M;
                    break;
                case "Large":
                    price = pizza.price_L;
                    break;
            }
            for(int i = 0; i < item.quantity; i++){
                pizzaPrices.add(price);
            }
        }
        if (pizzaPrices.size() >= 3) {
            int minPrice = pizzaPrices.get(0);
            for (int price : pizzaPrices) {
                minPrice = Math.min(minPrice, price);
            }
            minCost -= minPrice;
        }
        return minCost;
    }

    public boolean hasFiveSamePizza(OrderItem[] order) {
        for (OrderItem item : order) {
            if (item.quantity >= 5) {
                return true;
            }
        }
        return false;
    }

    public boolean hasThreeLargePizza(OrderItem[] order) {
        int count = 0;
        for (OrderItem item : order) {
            if (item.size.equals("Large")) {
                count += item.quantity;
            }
        }
        return count >= 3;
    }

    public int totalPizzas(OrderItem[] order) {
        int total = 0;
        for (OrderItem item : order) {
            total += item.quantity;
        }
        return total;
    }
}

class Pizza {
    public String name;
    public int price_S;
    public int price_M;
    public int price_L;
}

class OrderItem {
    public String name;
    public String size;
    public int quantity;
}