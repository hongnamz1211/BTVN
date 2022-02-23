import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CityServlet", value = "/home")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private final CityService cityService = new CityService();

    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "sort":
                sortCity(request, response);
                break;

            case "createGet":
                createGet(request, response);
                break;
            case "createPost":
                createPost(request, response);
                break;

            case "delete":
                deleteCity(request, response);
                break;
            case "editGet":
                editGet(request, response);
                break;
            case "editPost":
                editPost(request, response);
                break;
            case "search":
                searchCity(request, response);
                break;
            default:
                displayCity(request, response);
        }
    }

    private void searchCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("city-select");
        ArrayList<City> cities = cityService.searchCity(search);
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getCity(id);
        if (city != null) {
            city.setId(Integer.parseInt(request.getParameter("id")));
            city.setName(request.getParameter("name"));
            city.setAcreage(Double.parseDouble(request.getParameter("acreage")));
            city.setPopulation(Integer.parseInt(request.getParameter("population")));
            city.setGDP(Double.parseDouble(request.getParameter("GDP")));
            city.setCountry(request.getParameter("country"));
        }
        int index = -1;
        ArrayList<City> cities = cityService.display();
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getId() == city.getId()) {
                index = i;
            }
        }
        cityService.editCity(index, city);
        cities = cityService.display();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getCity(id);
        if (city != null) {
            request.setAttribute("city", city);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double acreage = Double.parseDouble(request.getParameter("acreage"));
        int population = Integer.parseInt(request.getParameter("population"));
        double GDP = Double.parseDouble(request.getParameter("GDP"));
        String country = request.getParameter("country");
        cityService.createCity(new City(id, name, acreage, population, GDP, country));
        ArrayList<City> cities = cityService.display();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.jsp");
    }



    private void sortCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<City> cities = cityService.sortCity();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    public void displayCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<City> cities = cityService.display();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    public void deleteCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getCity(id);
        if (city != null) {
            cityService.deleteCity(city);
        }
        ArrayList<City> cities = cityService.display();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }
}
