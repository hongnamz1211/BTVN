public class City {
    private int id;
    private String name;
    private double acreage;
    private int population;
    private double GDP;
    private String country;

    public City() {
    }

    public City(int id, String name, double acreage, int population, double GDP, String country) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", acreage=" + acreage +
                ", population=" + population +
                ", GDP=" + GDP +
                ", country='" + country + '\'' +
                '}';
    }
}
