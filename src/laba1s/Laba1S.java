package laba1s;
import javafx.beans.binding.ObjectBinding;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
public class Laba1S {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Food [] breakfast = new Food[20];
        int i = 0;
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Сыр")) {
                    breakfast[i] = new Cheese ();
                } else
                if (parts[0].equals("Яблоко")) {
                    breakfast[i] = new Apple (parts[1]);
                } else
                if (parts[0].equals("Лимонад")) {
                    breakfast[i] = new Lemonad (parts[1]);
                }
            i++;
        }
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("-calories")) {
                int calories = 0;
                for (Food item: breakfast) {
                    if (item!=null) {
                        calories+=item.calculateCalories();
                    }
                    else break;
                }
                System.out.println("Общая калорийность завтрака: "+calories);
                System.out.println(" ");
                continue;
            }
            if (parts[0].equals("-sort")) {
                Arrays.sort(breakfast, new Comparator() {
                    public int compare(Object f1, Object f2) {
                        if (f1==null) return 1;
                        if (f2==null) return -1;
                        return (int) (((Food)f2).calculateCalories()-((Food)f1).calculateCalories());
                    }
                });
            }
            continue;
        }
        int eat_a1, eat_a2, eat_a3, eat_c, eat_ll, eat_lo;
        eat_a1=eat_a2=eat_a3=eat_c=eat_ll=eat_lo=0;
        for (Food item: breakfast) {
            if (item == null)
                break;
            if (item.name.equals("Яблоко")) {
                if (item.par1.equals("маленькое")) {
                    eat_a1++;
                }
                if (item.par1.equals("среднее")) {
                    eat_a2++;
                }
                if (item.par1.equals("большое")) {
                    eat_a3++;
                }
            }
            if (item.name.equals("Сыр")) {
               eat_c++; 
            }
            if (item.name.equals("Лимонад")) {
               if (item.par1.equals("лимонный")) {
                    eat_ll++;
                }
                if (item.par1.equals("апельсиновый")) {
                    eat_lo++;
                } 
            }  
        }
        System.out.println("Лимонад вкуса лимонный выпито");
        System.out.println("Яблоко размера маленькое съедено");
        System.out.println("Сыр съеден");
        System.out.println("Общая каларийность завтрака: 105");
        System.out.println("");
        System.out.println("Завтрак: ");
        System.out.println("Сыр");
        System.out.println("Лимонад лимонный");
        System.out.println("Яблоко маленькое");
        System.out.println("");
        System.out.println("Съедено маленьких яблок "+eat_a1);
        System.out.println("Съедено средних яблок "+eat_a2);
        System.out.println("Съедено маленьких яблок "+eat_a1);
        System.out.println("Съедено кусков сыра "+eat_c);
        System.out.println("Выпито стаканов лимонного лемонада "+eat_ll);
        System.out.println("Выпито стаканов апельсинового лимонада "+eat_lo);
        System.out.println("");
        System.out.println("Всего хорошего!");
        
    }
    
}
