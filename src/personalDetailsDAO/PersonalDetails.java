package personalDetailsDAO;

import java.time.LocalDate;

public class PersonalDetails {
    private String userId;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fathersName;
    private String mobile;
    private String email;
    private String aadhar;
    private LocalDate dob;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String state;
    private String city;
    private String pincode;
    private String occupation;
    private String sourceOfIncome;
    private String grossAnnualIncome;
    private boolean debitCardOpted;
    private boolean netBankingOpted;

    public PersonalDetails(String userId, String title, String firstName, String middleName, String lastName, String fathersName, String mobile, String email, String aadhar, LocalDate dob, String addressLine1, String addressLine2, String landmark, String state, String city, String pincode, String occupation, String sourceOfIncome, String grossAnnualIncome, boolean debitCardOpted, boolean netBankingOpted) {
        this.userId = userId;
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.mobile = mobile;
        this.email = email;
        this.aadhar = aadhar;
        this.dob = dob;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.landmark = landmark;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.occupation = occupation;
        this.sourceOfIncome = sourceOfIncome;
        this.grossAnnualIncome = grossAnnualIncome;
        this.debitCardOpted = debitCardOpted;
        this.netBankingOpted = netBankingOpted;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public String getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(String grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public boolean isDebitCardOpted() {
		return debitCardOpted;
	}

	public void setDebitCardOpted(boolean debitCardOpted) {
		this.debitCardOpted = debitCardOpted;
	}

	public boolean isNetBankingOpted() {
		return netBankingOpted;
	}

	public void setNetBankingOpted(boolean netBankingOpted) {
		this.netBankingOpted = netBankingOpted;
	}

}
