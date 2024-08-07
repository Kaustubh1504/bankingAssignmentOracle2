package transactionDAO;

import java.time.LocalDate;

public class Transaction {
    private String transferId;
    private String source;
    private String toAccount;
    private double amount;
    private LocalDate dateOfTransfer;
    private String type;
    private String remarks;

    public Transaction(String transferId, String source, String toAccount, double amount, LocalDate dateOfTransfer, String type, String remarks) {
        this.transferId = transferId;
        this.source = source;
        this.toAccount = toAccount;
        this.amount = amount;
        this.dateOfTransfer = dateOfTransfer;
        this.type = type;
        this.remarks = remarks;
    }

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(LocalDate dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

