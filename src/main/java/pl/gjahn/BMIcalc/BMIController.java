package pl.gjahn.BMIcalc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.gjahn.BMIcalc.model.BMIForm;

@Controller
public class BMIController {

    @GetMapping("/")
    public String main() {
        return "hello";
    }

    @GetMapping("/calculator")
    public String calculator(Model model){

        model.addAttribute( "BMIForm", new BMIForm());

        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@ModelAttribute ("BMIForm") BMIForm bmiForm,
                             Model model) {


        double BMI = (bmiForm.getWeight()/((bmiForm.getHeight()/100)*(bmiForm.getHeight()/100)));
        System.out.println(BMI);
        System.out.println(bmiForm.getHeight());
        System.out.println(bmiForm.getWeight());
        model.addAttribute("bmi", BMI);

        return "bmi_show";
    }

}
