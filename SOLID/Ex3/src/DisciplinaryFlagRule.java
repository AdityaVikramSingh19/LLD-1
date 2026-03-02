public class DisciplinaryFlagRule implements EligibilityRule {
    @Override
    public boolean isFailed(StudentProfile student) {
        return student.disciplinaryFlag != LegacyFlags.NONE;
    }

    @Override
    public String getFailureReason() {
        return "disciplinary flag present";
    }
}
