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
                totalCost += price * item.quantity;
        }

        //1할인
        int firstVal = 0;
        if (totalPizzas(order) >= 3) {
            firstVal = firstSolustion(pizzaPrices,totalCost);
            if(firstVal<totalCost && firstVal != 0){
                totalCost = firstVal;
            }
        }
        //2할인
        int secondVal = 0;
        if (hasFiveSamePizza(order)) {
            secondVal = secondSolustion(order,pizzaName,totalCost);
            if(secondVal<totalCost && secondVal != 0){
                totalCost = firstVal;
            }
        }
        //3할인
        int thridVal = thridSolustion(order,pizzaName,totalCost);
        if(thridVal<totalCost && thridVal != 0){
            totalCost = firstVal;
        }
        //4할인
        int fourthVal = 0;
        if (hasThreeLargePizza(order)) {
            fourthVal = fourthSolustion(order,pizzaName,totalCost);
            if(fourthVal<totalCost && fourthVal != 0){
                totalCost = firstVal;
            }
        }
        return totalCost;
    }

    public int fourthSolustion(OrderItem[] order, Map<String, Pizza> pizzaName, int cost){
        int minCost = cost;

        List<OrderItem> largePizzas = new ArrayList<>();
        for (OrderItem item : order) {
            if (item.size.equals("Large")) {
                for(int i=0; i < item.quantity; i++){
                    largePizzas.add(item);
                }
            }
        }
        if(largePizzas.size() >= 3){
            for (int i = 0; i <= largePizzas.size() - 3; i++) {

                int tempCost = cost;
                for(int j = i; j< i + 3; j++){
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
        int minCost = cost;
        Map<String, Integer> smallCounts = new HashMap<>();
        Map<String, Integer> largeCounts = new HashMap<>();

        for(OrderItem item : order){
            if(item.size.equals("Small")){
                smallCounts.put(item.name, smallCounts.getOrDefault(item.name, 0) + item.quantity);
            } else if(item.size.equals("Large")){
                largeCounts.put(item.name, largeCounts.getOrDefault(item.name, 0) + item.quantity);
            }
        }

        for(OrderItem item: order){
            Pizza pizza = pizzaName.get(item.name);
            int price = 0;
            if(item.size.equals("Small")){
                price = pizza.price_S;
                if (largeCounts.containsKey(item.name) && largeCounts.get(item.name) > 0) {
                    int discountCount = Math.min(smallCounts.get(item.name), largeCounts.get(item.name));
                    minCost -= price * discountCount;
                    largeCounts.put(item.name, largeCounts.get(item.name) - discountCount);
                }
            }else{
                price =  item.size.equals("Medium") ? pizza.price_M : pizza.price_L;
                minCost += price * item.quantity;
            }
        }
        return minCost;
    }

    public int secondSolustion(OrderItem[] order,Map<String, Pizza> pizzaName,int cost){
        int minCost = 0;
        for(OrderItem item: order){
            if(item.quantity >= 5){
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
                minCost = cost - (price * 5) + 100;
            }
        }
        return minCost;
    }


    public int firstSolustion(List<Integer> pizzaPrices , int cost){
        int minCost = cost;
        if(pizzaPrices.size() >=3){
            int minPrice = pizzaPrices.get(0);
            for(int price: pizzaPrices){
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
        for(OrderItem item: order){
            total += item.quantity;
        }
        return total;
    }

}

class Pizza
{
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
