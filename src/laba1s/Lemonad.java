package laba1s;
public class Lemonad extends Food {
    private Double calories = null;
    public Lemonad(String favour) {
        super("Лимонад");
        par1 = favour;
    }
    public boolean equals (Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Lemonad)) return false;
            return par1.equals(((Lemonad)arg0).par1);
        } else
            return false;
    }
    public void consume () {
        System.out.println(this + "выпит");
    }
    public Double calculateCalories() {
        if(par1.equals("лимонный")) {
            calories = 40.0;
        }
        else if(par1.equals("апельсиновый")) {
            calories = 42.0;
        }
        return calories;
    }
    public String getFavour() {
        return par1;
    }
    public void setFavour(String favour) {
        this.par1 = favour;
    }
    public String toString() {
        return super.toString() + "вкуса '" +par1.toUpperCase() + "'";
    }    
}
