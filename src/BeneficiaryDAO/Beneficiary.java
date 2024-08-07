package BeneficiaryDAO;

public class Beneficiary {
    private String beneficiaryId;
    private String source;
    private String accountNumber;

    public Beneficiary(String beneficiaryId, String source, String accountNumber) {
        this.beneficiaryId = beneficiaryId;
        this.source = source;
        this.accountNumber = accountNumber;
    }

    // Getters and Setters
    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(String beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

