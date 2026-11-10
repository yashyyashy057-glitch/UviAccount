# UniAccounts - Work 1

This project implements the first practical work of the Design Patterns assignment.

## Patterns used

1. **Builder**
   - Used to build `StudentAccount`.
   - Required fields: `id`, `fullName`, `email`.
   - Optional fields have the required defaults.

2. **Singleton**
   - `StudentRepository`: one central repository.
   - `AuditLogger`: one shared audit log.

3. **Prototype**
   - `StudentAccount.copyWithNewIdentity(...)` creates a new account by copying an existing account and changing the student's identity.

## How to run

Open the `src` folder in VS Code.

Compile:

```bash
javac src/*.java
```

Run:

```bash
java -cp src Main
```

Or open `Main.java` in VS Code and run it using the Java extension.

## Files

- `StudentAccount.java`
- `StudentRepository.java`
- `AuditLogger.java`
- `Main.java`

The code contains comments identifying the Design Patterns and their roles.
