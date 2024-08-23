package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDAO;

import javax.servlet.http.HttpServletRequest;

@Controller()
public class CarController {

//    @GetMapping("/cars")
//    public String printTable(HttpServletRequest request) {
//        int countOfCars = request.getParameterMap().size();
//
//        System.out.println("Количество будущих столбцов: " + countOfCars);
//        return "cars";
//    }

    public final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }


    @GetMapping("/cars/{count}")
    public String printTable(@PathVariable("count") Integer count, Model model) {
        model.addAttribute("cars", carDAO.carTable(count));
        return "cars";
    }



    @GetMapping("/cars")
    public String printTable(@RequestParam(name = "count", required = false, defaultValue = "0") Integer count, ModelMap model) {
        model.addAttribute("cars", carDAO.carTable(count));
        return "cars";
    }


}
