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

class StockServiceImplTest {
    @InjectMocks
    private StockServiceImpl stockService;
    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addStock() {
        Stock stockToAdd = new Stock();
        stockToAdd.setTitle("Test Stock");

        // Add stock to the service
        stockService.addStock(stockToAdd);

        // Retrieve the added stock and verify it is not null
        Stock retrievedStock = stockService.retrieveStock(stockToAdd.getIdStock());
        assertNotNull(retrievedStock);

        // Additional assertions if needed
        assertEquals(stockToAdd.getTitle(), retrievedStock.getTitle());
        // Add more assertions based on your specific implementation
    }

    @Test
    void retrieveStock() {
        Stock stockToAdd = new Stock();
        stockToAdd.setTitle("Test Stock");


        stockService.addStock(stockToAdd);


        Stock retrievedStock = stockService.retrieveStock(stockToAdd.getIdStock());
        assertNotNull(retrievedStock);


        assertEquals(stockToAdd.getTitle(), retrievedStock.getTitle());

    }

    @Test
    void retrieveAllStock() {
        Stock stock1 = new Stock();
        stock1.setTitle("Stock 1");

        Stock stock2 = new Stock();
        stock2.setTitle("Stock 2");

        stockService.addStock(stock1);
        stockService.addStock(stock2);

        List<Stock> allStocks = stockService.retrieveAllStock();
        assertFalse(allStocks.isEmpty());

        assertTrue(allStocks.contains(stock1));
        assertTrue(allStocks.contains(stock2));

    }
}
