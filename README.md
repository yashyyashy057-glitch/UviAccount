UniAccounts - العمل الأول

هذا المشروع يطبّق العمل التطبيقي الأول (Work 1) الخاص بمادة Design Patterns.

الأنماط (Design Patterns) المستخدمة

1. Builder

- يُستخدم لبناء كائن StudentAccount.
- الحقول الإلزامية هي: "id"، "fullName"، "email".
- الحقول الاختيارية لها القيم الافتراضية المطلوبة.

2. Singleton

- StudentRepository: مستودع مركزي واحد.
- AuditLogger: سجل تدقيق (Audit Log) مشترك واحد.

3. Prototype

- الدالة "StudentAccount.copyWithNewIdentity(...)" تنشئ حسابًا جديدًا عن طريق نسخ حساب موجود، مع تغيير هوية الطالب.

كيفية التشغيل

افتح مجلد "src" في VS Code.

التجميع (Compile)

javac src/*.java

التشغيل (Run)

java -cp src Main

أو افتح الملف "Main.java" في VS Code وقم بتشغيله باستخدام إضافة Java.

الملفات

- "StudentAccount.java"
- "StudentRepository.java"
- "AuditLogger.java"
- "Main.java"

يحتوي الكود على تعليقات توضّح Design Patterns المستخدمة ودور كل نمط في المشروع.
