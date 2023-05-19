package me.dri.restproject.services;

import me.dri.restproject.exception.UnsupportedMathOperationException;
import me.dri.restproject.utils.UtilsMath;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MathServices {



    public Double sum(@PathVariable(value = "numberOne")String numberOne,
                      @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

    UtilsMath.isNumeriValidantion(numberOne, numberTwo);
        return UtilsMath.converToDouble(numberOne) + UtilsMath.converToDouble(numberTwo);

    }


    public Double subtraction(@PathVariable(value = "numberOne")String numberOne,
                              @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        UtilsMath.isNumeriValidantion(numberOne, numberTwo);
        return UtilsMath.converToDouble(numberOne) -  UtilsMath.converToDouble(numberTwo);

    }


    public Double multiplication(@PathVariable(value = "numberOne")String numberOne,
                                 @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        UtilsMath.isNumeriValidantion(numberOne, numberTwo);
        return UtilsMath.converToDouble(numberOne) *  UtilsMath.converToDouble(numberTwo);

    }


    public Double division(@PathVariable(value = "numberOne")String numberOne,
                           @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        UtilsMath.isNumeriValidantion(numberOne, numberTwo);
        return UtilsMath.converToDouble(numberOne) /  UtilsMath.converToDouble(numberTwo);

    }


    public Double average(@PathVariable(value = "numberOne")String numberOne,
                          @PathVariable(value = "numberTwo")String numberTwo) throws Exception {

        UtilsMath.isNumeriValidantion(numberOne, numberTwo);
        return sum(numberOne, numberTwo) / 2;


    }


    public Double squareroot(@PathVariable(value = "numberOne")String numberOne) throws Exception {

        UtilsMath.isNumeriValidantion(numberOne);
        return Math.sqrt(UtilsMath.converToDouble(numberOne));
}
}