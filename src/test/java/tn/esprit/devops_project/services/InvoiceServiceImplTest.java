package tn.esprit.devops_project.services;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceDetailRepository;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OperatorRepository operatorRepository;

    @Mock
    private InvoiceDetailRepository invoiceDetailRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    public InvoiceServiceImplTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void retrieveAllInvoices() {
        // Mock the behavior of the repository

        List<Invoice> invoice = Arrays.asList(new Invoice(), new Invoice());


        when(invoiceRepository.findAll()).thenReturn(invoice);

        // Call the service method
        List<Invoice> invoices = invoiceService.retrieveAllInvoices();

        // Verify the result
        verify(invoiceRepository).findAll();
        assertEquals(2, invoices.size());

        // Verify that the repository method was called
        verify(invoiceRepository, times(1)).findAll();
    }

    @Test
    void cancelInvoice() {
        // Mock data
        Long invoiceId = 1L;

        // Mock the behavior of the repository
        Invoice invoice = new Invoice();
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

        // Call the service method
        invoiceService.cancelInvoice(invoiceId);


        // Verify that the repository method was called
        verify(invoiceRepository, times(1)).findById(invoiceId);
        verify(invoiceRepository, times(1)).save(invoice);
    }

    @Test
    void retrieveInvoice() {
        // Mock data
        Long invoiceId = 1L;
        Invoice mockInvoice = new Invoice();
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(mockInvoice));

        // Call the service method
        Invoice result = invoiceService.retrieveInvoice(invoiceId);

        // Verify the result
        assertNotNull(result);

        // Verify that the repository method was called
        verify(invoiceRepository, times(1)).findById(invoiceId);
    }

    @Test
    void getInvoicesBySupplier() {
        // Mock data
        Long supplierId = 1L;
        Supplier mockSupplier = new Supplier();
        mockSupplier.setIdSupplier(supplierId);
        Invoice mockInvoice = new Invoice();
        mockInvoice.setSupplier(mockSupplier);
        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(mockSupplier));
        when(invoiceRepository.retrieveInvoicesBySupplier(mockSupplier)).thenReturn(Collections.singletonList(mockInvoice));

        // Call the service method
        List<Invoice> invoices = invoiceService.getInvoicesBySupplier(supplierId);

        // Verify the result
        assertNotNull(invoices);
        assertFalse(invoices.isEmpty());

        // Verify that the repository method was called
        verify(supplierRepository, times(1)).findById(supplierId);
        verify(invoiceRepository, times(1)).retrieveInvoicesBySupplier(mockSupplier);
    }

    @Test
    void assignOperatorToInvoice() {
        // Mock data
        Long operatorId = 1L;
        Long invoiceId = 2L;

        Operator mockOperator = new Operator();
        Invoice mockInvoice = new Invoice();

        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(mockOperator));
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(mockInvoice));

        // Call the service method
        invoiceService.assignOperatorToInvoice(operatorId, invoiceId);

        // Verify the result
        assertTrue(mockOperator.getInvoices().contains(mockInvoice));

        // Verify that the repository methods were called
        verify(operatorRepository, times(1)).findById(operatorId);
        verify(invoiceRepository, times(1)).findById(invoiceId);
        verify(operatorRepository, times(1)).save(mockOperator);
    }

    @Test

    void getTotalAmountInvoiceBetweenDates() {
        // Mock data
        Date startDate = new Date();
        Date endDate = new Date();
        float mockTotalAmount = 100.0f;

        when(invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(mockTotalAmount);

        // Call the service method
        float result = invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        // Verify the result
        assertEquals(mockTotalAmount, result);

        // Verify that the repository method was called
        verify(invoiceRepository, times(1)).getTotalAmountInvoiceBetweenDates(startDate, endDate);
    }
}
