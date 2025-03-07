package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
    }

    @Test
    void testCreatePaymentVoucherCodeValid() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("1", "Voucher Code", paymentData);

        assertEquals("1", payment.getId());
        assertEquals("Voucher Code", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentVoucherCodeInvalid() {
        paymentData.put("voucherCode", "INVALIDCODE123");
        Payment payment = new Payment("2", "Voucher Code", paymentData);

        assertEquals("2", payment.getId());
        assertEquals("Voucher Code", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentCashOnDeliveryValid() {
        paymentData.put("address", "Jl. Contoh No.1");
        paymentData.put("deliveryFee", "5000");
        Payment payment = new Payment("3", "Cash on Delivery", paymentData);

        assertEquals("3", payment.getId());
        assertEquals("Cash on Delivery", payment.getMethod());
        assertEquals("WAITING_PAYMENT", payment.getStatus());
    }

    @Test
    void testCreatePaymentCashOnDeliveryInvalid() {
        paymentData.put("address", "");
        paymentData.put("deliveryFee", "5000");
        Payment payment = new Payment("4", "Cash on Delivery", paymentData);

        assertEquals("4", payment.getId());
        assertEquals("Cash on Delivery", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankTransferValid() {
        paymentData.put("bankName", "Bank XYZ");
        paymentData.put("referenceCode", "12345678");
        Payment payment = new Payment("5", "Bank Transfer", paymentData);

        assertEquals("5", payment.getId());
        assertEquals("Bank Transfer", payment.getMethod());
        assertEquals("WAITING_PAYMENT", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankTransferInvalid() {
        paymentData.put("bankName", "");
        paymentData.put("referenceCode", "12345678");
        Payment payment = new Payment("6", "Bank Transfer", paymentData);

        assertEquals("6", payment.getId());
        assertEquals("Bank Transfer", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testSetStatusToSuccess() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("7", "Voucher Code", paymentData);
        payment.setStatus("SUCCESS");

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testSetStatusToRejected() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("8", "Voucher Code", paymentData);
        payment.setStatus("REJECTED");

        assertEquals("REJECTED", payment.getStatus());
    }
}
