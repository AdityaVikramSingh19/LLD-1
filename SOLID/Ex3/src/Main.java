import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        
        // Configure rules using RuleInput for externalized configuration
        RuleInput config = new RuleInput();
        List<EligibilityRule> rules = Arrays.asList(
            new DisciplinaryFlagRule(),
            new CgrRule(config.minCgr),
            new AttendanceRule(config.minAttendance),
            new CreditsRule(config.minCredits)
        );
        
        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), rules);
        engine.runAndPrint(s);
    }
}
