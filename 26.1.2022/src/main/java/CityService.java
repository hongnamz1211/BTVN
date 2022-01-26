import java.util.ArrayList;

public class CityService {
    private static final ArrayList<City> cities;

    static {
        cities = new ArrayList<>();
        cities.add(new City(1, "Ha Noi", 3358.6, 8250000, 5000000, "Viet Nam"));
        cities.add(new City(2, "New Jork", 789, 3200000, 12000000, "Hoa Ky"));
        cities.add(new City(3, "Tokyo", 2190.93, 9273000, 15000000, "Nhat Ban"));
        cities.add(new City(4, "Eng Land", 244.820, 327000, 11000000, "Anh"));
        cities.add(new City(5, "Singapore", 697, 5560300, 10000000, "Singapore"));
    }

    public City getCity(int id) {
        for (City c :
                cities) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void createCity(City city) {
        cities.add(city);
    }

    public void editCity(int id, City city) {
        cities.set(id, city);
    }

    public void deleteCity(City city) {
        cities.remove(city);
    }

    public ArrayList<City> display() {
        return cities;
    }

    public ArrayList<City> sortCity() {
        cities.sort((o1, o2) -> {
            if (o1.getAcreage() > o2.getAcreage()) return 1;
            else if (o1.getAcreage() < o2.getAcreage()) return -1;
            else return 0;
        });
        return cities;
    }

    public ArrayList<City> searchCity(String name) {
        ArrayList<City> cityArrayList = new ArrayList<>();
        for (City s :
                cities) {
            if (s.getName().equals(name)) {
                cityArrayList.add(s);
            }
        }
        return cityArrayList;
    }
}
