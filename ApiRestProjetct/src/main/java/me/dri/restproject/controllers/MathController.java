package me.dri.restproject.controllers;


import me.dri.restproject.services.MathServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {


    @Autowired
    private MathServices mathServices;


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return mathServices.sum(numberOne, numberTwo);



    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                              @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return mathServices.subtraction(numberOne, numberTwo);


    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return mathServices.multiplication(numberOne, numberTwo);




    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return mathServices.division(numberOne, numberTwo);


    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne,
                          @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return mathServices.average(numberOne, numberTwo);


    }

    @RequestMapping(value = "/squareroot/{numberOne}", method = RequestMethod.GET)
    public Double squareroot(@PathVariable(value = "numberOne") String numberOne) throws Exception {

        return mathServices.squareroot(numberOne);


    }


}
