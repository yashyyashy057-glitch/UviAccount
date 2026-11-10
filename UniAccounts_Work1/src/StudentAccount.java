import java.util.ArrayList;
import java.util.List;

// Prototype Pattern: StudentAccount can be copied to create new accounts.
public class StudentAccount implements Cloneable {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String level;
    private String major;
    private boolean scholarship;
    private List<String> courses;

    // Builder Pattern
    public static class Builder {
        private final String id;
        private final String fullName;
        private final String email;
        private String phone = null;
        private String level = "L1";
        private String major = null;
        private boolean scholarship = false;
        private List<String> courses = new ArrayList<>();

        public Builder(String id, String fullName, String email) {
            if (id == null || id.isBlank()) {
                throw new IllegalArgumentException("id cannot be empty");
            }
            if (fullName == null || fullName.isBlank()) {
                throw new IllegalArgumentException("fullName cannot be empty");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("email must contain @");
            }
            this.id = id;
            this.fullName = fullName;
            this.email = email;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder level(String level) {
            if (!List.of("L1", "L2", "L3", "M1", "M2").contains(level)) {
                throw new IllegalArgumentException("Invalid level");
            }
            this.level = level;
            return this;
        }

        public Builder major(String major) {
            this.major = major;
            return this;
        }

        public Builder scholarship(boolean scholarship) {
            this.scholarship = scholarship;
            return this;
        }

        public Builder courses(List<String> courses) {
            this.courses = new ArrayList<>(courses);
            return this;
        }

        public StudentAccount build() {
            return new StudentAccount(this);
        }
    }

    private StudentAccount(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.level = builder.level;
        this.major = builder.major;
        this.scholarship = builder.scholarship;
        this.courses = new ArrayList<>(builder.courses);
    }

    // Prototype Pattern: create a copy with a new student identity.
    public StudentAccount copyWithNewIdentity(String newId, String newFullName, String newEmail) {
        StudentAccount copy = this.clone();
        copy.id = newId;
        copy.fullName = newFullName;
        copy.email = newEmail;
        return copy;
    }

    @Override
    public StudentAccount clone() {
        try {
            StudentAccount copy = (StudentAccount) super.clone();
            copy.courses = new ArrayList<>(this.courses);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "StudentAccount{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", level='" + level + '\'' +
                ", major='" + major + '\'' +
                ", scholarship=" + scholarship +
                ", courses=" + courses +
                '}';
    }
}
