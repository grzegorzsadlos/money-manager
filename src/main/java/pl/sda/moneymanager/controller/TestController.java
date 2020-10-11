package pl.sda.moneymanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.domain.IncomeSource;
import pl.sda.moneymanager.service.IncomeService;

@RestController
public class TestController {

    private final IncomeService incomeService;

    public TestController(final IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/create-test-income")
    Income creationTest() {
        Income myIncome = Income.builder()
            .incomeValueInCent(1_000_000)
            .build();

        return incomeService.createIncome(myIncome);
    }
}
