package pl.gjahn.BMIcalc.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class BMIForm {

    @Min(30)
    @Max(180)
    private double weight;
    @Min(120)
    @Max(230)
    private double height;
}
