package pl.gjahn.BMIcalc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {

    @GetMapping("/")
    public String main() {
        return "hello";
    }

    @GetMapping("/calculator")
    public String calculator(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("weight") double weight,
                             @RequestParam("height") double height,
                             Model model) {

        model.addAttribute("weigth" , weight);
        model.addAttribute("heigth" , height);
        double BMI = weight/((height/100)*(height/100));
        //System.out.println(BMI);
        model.addAttribute("bmi", BMI);

        return "bmi_show";
    }

}
