package id.ac.ui.cs.advprog.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Map;

@Getter
@NoArgsConstructor  // Konstruktor tanpa argumen untuk keperluan serialisasi
@AllArgsConstructor // Konstruktor otomatis untuk semua argumen
public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String, String> paymentData;

    // Konstruktor manual dengan logika status
    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        this.status = determineStatus(method, paymentData);
    }

    // Konstruktor dengan status langsung
    public Payment(String id, String method, Map<String, String> paymentData, String status) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        this.status = status;
    }

    private String determineStatus(String method, Map<String, String> paymentData) {
        System.out.println("Checking status for method: " + method + " with data: " + paymentData);

        if ("Voucher Code".equals(method)) {
            String voucherCode = paymentData.get("voucherCode");
            if (voucherCode != null && voucherCode.length() == 16 &&
                    voucherCode.startsWith("ESHOP") && voucherCode.replaceAll("\\D", "").length() == 8) {
                return "SUCCESS";
            }
            return "REJECTED";
        } else if ("Cash on Delivery".equals(method)) {
            if (paymentData.get("address") == null || paymentData.get("address").isEmpty() ||
                    paymentData.get("deliveryFee") == null || paymentData.get("deliveryFee").isEmpty()) {
                return "REJECTED";
            }
        } else if ("Bank Transfer".equals(method)) {
            if (paymentData.get("bankName") == null || paymentData.get("bankName").isEmpty() ||
                    paymentData.get("referenceCode") == null || paymentData.get("referenceCode").isEmpty()) {
                return "REJECTED";
            }
        }
        return "WAITING_PAYMENT";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}