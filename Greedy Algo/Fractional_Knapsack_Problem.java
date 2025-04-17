import java.util.*;
class soln
{
   static class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    double fractionalKnapsack(int[] weight, int[] value, int capacity) {
        Item[] items = new Item[value.length];
        for (int i = 0; i < value.length; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare((double) b.value * a.weight, (double) a.value * b.weight));

        double totalValue = 0.0;
        for (Item item : items) {
            if (capacity <= 0) break;

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.value * ((double) capacity / item.weight);
                capacity = 0;
            }
        }
        return totalValue;
    }                               
}
public class Fractional_Knapsack_Problem
{
    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int capacity = 50;
        soln ob = new soln();
        double maxValue = ob.fractionalKnapsack(weight, value, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}