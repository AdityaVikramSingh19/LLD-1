public interface EligibilityRule {
    boolean isFailed(StudentProfile student);
    String getFailureReason();
}
