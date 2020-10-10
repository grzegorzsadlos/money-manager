package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.repository.IncomeRepository;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class IncomeService {
    private final  IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }
    public List<Income> readIncomesWithQueryParams(int pageNumber,int pageSize){
        log.info("reading incomes with query params, page number = [{}], page size = [{}]", pageNumber, pageSize);
//        nowa java
        var result = incomeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        log.info("result from db: {}", result);

        return Collections.emptyList();
    }

}
