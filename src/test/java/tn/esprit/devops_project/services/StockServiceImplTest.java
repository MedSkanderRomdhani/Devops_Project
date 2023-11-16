package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockServiceImplTest {
    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void addStock() {
        // Mocking behavior
        Stock stockToAdd = new Stock();
        when(stockRepository.save(any(Stock.class))).thenReturn(stockToAdd);

        // Testing the service method
        Stock addedStock = stockService.addStock(stockToAdd);

        // Verification
        assertNotNull(addedStock);
        assertEquals(stockToAdd, addedStock);
    }


    @Test
    void retrieveAllStock() {
        // Mocking behavior
        when(stockRepository.findAll()).thenReturn(List.of(new Stock(), new Stock()));

        // Testing the service method
        List<Stock> stocks = stockService.retrieveAllStock();

        // Verification
        assertNotNull(stocks);
        assertEquals(2, stocks.size());

    }
}
