package pl.sda.moneymanager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.sda.moneymanager.domain.Income;
import pl.sda.moneymanager.repository.IncomeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> readIncomesWithQueryParams(int pageNumber, int pageSize) {
        log.info("reading incomes with query params, page number = [{}], page size = [{}]", pageNumber, pageSize);
//        nowa java
        var result = incomeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        log.info("result from db: {}", result);

        return result;
    }

    public List<Income> readAllIncomes() {
        log.info("reading all incomes");
        var result = incomeRepository.findAll();
        log.info("Number of read elements: [{}]", result.size());
        log.info("result : {}", result);

        return result;
    }

    public Optional<Income> findIncomeById(Long id) {
        log.info("find income by id: [{}]", id);
        var result = incomeRepository.findById(id); //Zwraca Optional
        log.info("result: [{}]", result);
        return result;
    }

    public Income createIncome(Income toSave) {
        var saved = incomeRepository.save(toSave);
        log.info("saved object :[{}]", saved);

        return saved;
    }

    public boolean deleteIncomeById(Long id) {
        log.info("deleting by id: [{}]", id);
        incomeRepository.deleteById(id);
        return true;
    }

    public Income updateIncome(Income toUpdate) {
        var updated = incomeRepository.save(toUpdate);
        log.info("updated object :[{}]", updated);
        return updated;
    }

}




