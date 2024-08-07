package BeneficiaryDAO;

import java.util.List;

public interface BeneficiaryDAO {
    void createBeneficiary(Beneficiary beneficiary);
    Beneficiary getBeneficiary(String beneficiaryId);
    void updateBeneficiary(Beneficiary beneficiary);
    void deleteBeneficiary(String beneficiaryId);
    List<Beneficiary> getAllBeneficiaries();
}

