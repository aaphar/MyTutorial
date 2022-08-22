package collections.linkedHashMapSet;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.60, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.70, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 52, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 23.3, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 23);
        stockList.addStock(temp);

        temp = new StockItem("phone", 53.0, 54);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.50, 40);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.50, 30);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket basket = new Basket("Aphar");

        sellItems(basket, "car", 1);
        System.out.println(basket);

        sellItems(basket, "car", 1);
        System.out.println(basket);

        if (sellItems(basket, "car", 1) != 1) {
            System.out.println("There no more cars");
        }

        sellItems(basket, "spanner", 5);
//        System.out.println(basket);

        sellItems(basket, "juice", 4);
        sellItems(basket, "cup", 12);
        sellItems(basket, "bread", 1);
//        System.out.println(basket);

//        System.out.println(stockList);

        Basket newBasket = new Basket("customer");
        sellItems(newBasket, "cup", 100);
        sellItems(newBasket, "juice", 5);
        removeItem(newBasket, "cup", 1);
        System.out.println(newBasket);

        removeItem(basket, "car", 1);
        removeItem(basket, "cup", 9);
        removeItem(basket, "car", 1);
        System.out.println("cars removed: " + removeItem(basket, "car", 1));
        System.out.println(basket);

        // remove all items
        removeItem(basket, "bread", 1);
        removeItem(basket, "cup", 3);
        removeItem(basket, "juice", 4);
        removeItem(basket, "cup", 3);
        System.out.println(basket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(newBasket);
        System.out.println(stockList);
        checkOut(newBasket);
        System.out.println(newBasket);
        System.out.println(stockList);


//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);

        StockItem car = stockList.Items().get("car");
        if (car != null) {
            car.adjustStock(2000);
        }
        if (car != null) {
            stockList.get("car").adjustStock(-1000); // StockList get method()
        }

        System.out.println(stockList);

//        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " cost " + price.getValue());
//        }

        checkOut(basket);
        System.out.println(basket);
    }

    public static int sellItems(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        // if item sell, return diff from 0
        if (stockList.reservedStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        // if item sell, return diff from 0
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreservedStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
