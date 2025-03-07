package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    Order order;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        order = mock(Order.class);
        paymentData = new HashMap<>();
    }

    @Test
    void testAddPayment() {
        paymentData.put("bankName", "Bank ABC");
        paymentData.put("referenceCode", "123456");
        Payment payment = new Payment(order.getId(), "Bank Transfer", paymentData);
        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.addPayment(order, "Bank Transfer", paymentData);

        verify(paymentRepository, times(1)).save(any(Payment.class));
        assertEquals("Bank Transfer", result.getMethod());
        assertEquals("WAITING_PAYMENT", result.getStatus());
    }

    @Test
    void testSetStatus() {
        Payment payment = new Payment(order.getId(), "Bank Transfer", paymentData);
        doReturn(payment).when(paymentRepository).findById(payment.getId());
        payment.setStatus("SUCCESS");
        doReturn(payment).when(paymentRepository).save(payment);

        Payment result = paymentService.setStatus(payment, "SUCCESS");

        assertEquals("SUCCESS", result.getStatus());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testSetStatusInvalidPayment() {
        Payment payment = new Payment(order.getId(), "Bank Transfer", paymentData);
        doReturn(null).when(paymentRepository).findById(payment.getId());

        assertThrows(NoSuchElementException.class, () -> paymentService.setStatus(payment, "SUCCESS"));
        verify(paymentRepository, times(0)).save(any(Payment.class));
    }

    @Test
    void testGetPaymentIfExists() {
        Payment payment = new Payment(order.getId(), "Bank Transfer", paymentData);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        Payment result = paymentService.getPayment(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testGetPaymentIfNotExists() {
        doReturn(null).when(paymentRepository).findById("unknown");
        assertThrows(NoSuchElementException.class, () -> paymentService.getPayment("unknown"));
    }
}