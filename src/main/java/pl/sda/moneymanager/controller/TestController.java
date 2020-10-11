package pl.sda.moneymanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.domain.IncomeSource;
import pl.sda.moneymanager.service.IncomeService;

// @Controller
// nie trzeba tworzyć widoku
@RestController
public class TestController {
    private final IncomeService incomeService;

    public TestController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }



    //endpoint

    @GetMapping("/create-test-income")
    Income creationTest(){
        Income myIncome = Income.builder()
                .incomeValueInCent(1_000_000)
                .build();
        return incomeService.createIncome(myIncome);


    }

}

