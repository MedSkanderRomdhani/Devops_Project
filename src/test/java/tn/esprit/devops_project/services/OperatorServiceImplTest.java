package tn.esprit.devops_project.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import javax.swing.text.html.Option;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OperatorServiceImplTest {
    private OperatorRepository operatorRepository;
    private OperatorServiceImpl operatorService;


    @BeforeEach
    void setUp() {
        operatorRepository = mock(OperatorRepository.class); //mock instance creation
        operatorService = new OperatorServiceImpl(operatorRepository); //service instance with mocked repository
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void retrieveAllOperators() {
        // Mocking behavior for the repository's findAll method
        when(operatorRepository.findAll()).thenReturn(Arrays.asList(new Operator(), new Operator()));

        // Invoking the service method
        List<Operator> operators = operatorService.retrieveAllOperators();

        // Verifying the results
        assertNotNull(operators);
        assertEquals(2, operators.size());
    }

    @Test
    void addOperator() {
        Operator operatorToAdd = new Operator();
        when(operatorRepository.save(any(Operator.class))).thenReturn(operatorToAdd);

        Operator addedOperator = operatorService.addOperator(operatorToAdd);

        assertNotNull(addedOperator);
        assertEquals(operatorToAdd, addedOperator);
    }

    @Test
    void deleteOperator() {
        doNothing().when(operatorRepository).deleteById(anyLong());
        long anyOperatorId = 123L;
        assertDoesNotThrow(() -> operatorService.deleteOperator(anyOperatorId));
        verify(operatorRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void updateOperator() {
        Operator operatorToUpdate = new Operator();
        when(operatorRepository.save(any(Operator.class))).thenReturn(operatorToUpdate);

        Operator updatedOperator = operatorService.updateOperator(operatorToUpdate);

        assertNotNull(updatedOperator);
        assertEquals(operatorToUpdate, updatedOperator);
    }

    @Test
    void retrieveOperator() {
        // Mocking behavior
        when(operatorRepository.findById(anyLong())).thenReturn(Optional.of(new Operator()));

        // Testing the service method
        Operator retrievedOperator = operatorService.retrieveOperator(1L);

        // Verification
        assertNotNull(retrievedOperator);
    }
}