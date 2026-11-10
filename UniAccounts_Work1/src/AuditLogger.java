import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Singleton Pattern: one audit log shared by the whole application.
public class AuditLogger {
    private static AuditLogger instance;
    private final List<String> events = new ArrayList<>();

    private AuditLogger() {
    }

    public static synchronized AuditLogger getInstance() {
        if (instance == null) {
            instance = new AuditLogger();
        }
        return instance;
    }

    public void log(String message) {
        String event = LocalDateTime.now() + " - " + message;
        events.add(event);
        System.out.println("[AUDIT] " + event);
    }

    public List<String> getEvents() {
        return new ArrayList<>(events);
    }
}
