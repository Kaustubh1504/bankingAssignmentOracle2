package personalDetailsDAO;

import java.util.List;

public interface PersonalDetailsDAO {
    void createPersonalDetails(PersonalDetails personalDetails);
    PersonalDetails getPersonalDetails(String userId);
    void updatePersonalDetails(PersonalDetails personalDetails);
    void deletePersonalDetails(String userId);
    List<PersonalDetails> getAllPersonalDetails();
}
