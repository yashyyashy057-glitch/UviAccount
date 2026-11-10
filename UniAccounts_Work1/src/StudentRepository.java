import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

// Singleton Pattern: one central repository for all student accounts.
public class StudentRepository {
    private static StudentRepository instance;
    private final Map<String, StudentAccount> accounts = new LinkedHashMap<>();

    private StudentRepository() {
    }

    public static synchronized StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public void add(StudentAccount account) {
        if (accounts.containsKey(account.getId())) {
            throw new IllegalArgumentException("ID already exists: " + account.getId());
        }
        accounts.put(account.getId(), account);
    }

    public StudentAccount findById(String id) {
        return accounts.get(id);
    }

    public Collection<StudentAccount> getAll() {
        return accounts.values();
    }

    public int size() {
        return accounts.size();
    }
}
