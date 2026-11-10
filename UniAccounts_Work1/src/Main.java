import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== UniAccounts - Work 1 ===");

        // =========================
        // 1. Builder Pattern
        // =========================
        System.out.println("\n--- Builder Pattern ---");

        StudentAccount student1 = new StudentAccount.Builder(
                "20260001",
                "Hadjer Ayachi",
                "hadjer@univ.dz"
        )
                .phone("0555000000")
                .level("L2")
                .major("Computer Science")
                .scholarship(true)
                .courses(List.of("Java", "UML", "Databases"))
                .build();

        System.out.println(student1);

        // =========================
        // 2. Singleton Pattern
        // =========================
        System.out.println("\n--- Singleton Pattern ---");

        StudentRepository repository1 = StudentRepository.getInstance();
        StudentRepository repository2 = StudentRepository.getInstance();

        repository1.add(student1);

        System.out.println("Same repository? " + (repository1 == repository2));
        System.out.println("Number of accounts: " + repository1.size());

        AuditLogger logger1 = AuditLogger.getInstance();
        AuditLogger logger2 = AuditLogger.getInstance();

        System.out.println("Same logger? " + (logger1 == logger2));
        logger1.log("Created account " + student1.getId());

        // =========================
        // 3. Prototype Pattern
        // =========================
        System.out.println("\n--- Prototype Pattern ---");

        StudentAccount student2 = student1.copyWithNewIdentity(
                "20260002",
                "Salima Djidour",
                "slima@univ.dz"
        );

        repository1.add(student2);
        logger1.log("Created account from prototype: " + student2.getId());

        System.out.println("Original account:");
        System.out.println(student1);

        System.out.println("\nCopied account:");
        System.out.println(student2);

        // =========================
        // Final result
        // =========================
        System.out.println("\n--- Repository contents ---");

        for (StudentAccount account : repository1.getAll()) {
            System.out.println(account);
        }

        System.out.println("\nTotal accounts: " + repository1.size());
        System.out.println("=== End ===");
    }
}
