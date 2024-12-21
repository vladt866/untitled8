import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CaloriesComparator implements Comparator<Nutritious> {
    @Override
    public int compare(Nutritious o1, Nutritious o2) {
        return Double.compare(o2.calculateCalories(), o1.calculateCalories()); // Сортировка по убыванию
    }
}




class ChewingGum implements Nutritious {
    private String flavour;
    private double calories;

    public ChewingGum(String flavour, double calories) {
        this.flavour = flavour;
        this.calories = calories;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public double calculateCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Жевательная резинка со вкусом: " + flavour + ", калорийность: " + calories;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChewingGum)) return false;
        ChewingGum other = (ChewingGum) obj;
        return this.flavour.equals(other.flavour);
    }
}
public class Main {
    public static void main(String[] args) {
        List<Nutritious> breakfast = new ArrayList<>();
        breakfast.add(new ChewingGum("арбуз", 10));
        breakfast.add(new ChewingGum("мята", 900));
        breakfast.add(new ChewingGum("арбуз", 50));
        breakfast.add(new ChewingGum("вишня",8));


        // Пункт б: подсчет жевательной резинки со вкусом "арбуз"
        String targetFlavour = "арбуз";
        int count = countFlavour(breakfast, targetFlavour);
        System.out.println("Количество жевательной резинки со вкусом " + targetFlavour + ": " + count);

        // Пункт г: подсчет калорий
        double totalCalories = calculateTotalCalories(breakfast);
        System.out.println("Общая калорийность завтрака: " + totalCalories);

        // Пункт д: сортировка по калорийности
        sortBreakfastByCalories(breakfast);
        System.out.println("Отсортированный завтрак:");
        for (Nutritious item : breakfast) {
            System.out.println(item);
        }
    }

    // Метод для подсчета количества жевательной резинки определенного вкуса
    private static int countFlavour(List<Nutritious> breakfast, String flavour) {
        int count = 0;
        for (Nutritious item : breakfast) {
            if (item instanceof ChewingGum && item.equals(new ChewingGum(flavour, 0))) {
                count++;
            }
        }
        return count;
    }

    // Метод для подсчета общей калорийности
    private static double calculateTotalCalories(List<Nutritious> breakfast) {
        double totalCalories = 0;
        for (Nutritious item : breakfast) {
            totalCalories += item.calculateCalories();
        }
        return totalCalories;
    }

    // Метод для сортировки списка по калорийности
    private static void sortBreakfastByCalories(List<Nutritious> breakfast) {
        Collections.sort(breakfast, new Comparator<Nutritious>() {
            @Override
            public int compare(Nutritious o1, Nutritious o2) {
                return Double.compare(o2.calculateCalories(), o1.calculateCalories());
            }
        });
    }
}

