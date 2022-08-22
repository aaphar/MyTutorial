package collections.linkedHashMapSet;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if we already have quantities of this item
            /**
             * get the item if item already exits in a list map
             * if not exits, use this item that we have passed to this
             * that going to be inStock
             */
            StockItem inStock = list.getOrDefault(item.getName(), item);

            // if there are already stocks on this item, adjust the quantity
            // checking did we actually get the item out of our map
            if (inStock != item) {
                // add to stock this item with inStock quantity
                item.adjustStock(inStock.availableQuantity());
            }

            // if already there is stock item with that name, update it
            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if (inStock != null && quantity > 0) {
            return inStock.finaliseStock(quantity);
        }
        return 0;

//        StockItem inStock = list.getOrDefault(item, null);
//
//        if ((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity > 0)) {
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
    }

    public int reservedStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if (inStock != null && quantity > 0) {
            return inStock.reservedStock(quantity);
        }
        return 0;
    }

    public int unreservedStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if (inStock != null && quantity > 0) {
            return inStock.unreservedStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + totalCost;
    }
}
