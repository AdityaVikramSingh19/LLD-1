public class CreditsRule implements EligibilityRule {
    private final int minCredits;

    public CreditsRule(int minCredits) {
        this.minCredits = minCredits;
    }

    @Override
    public boolean isFailed(StudentProfile student) {
        return student.earnedCredits < minCredits;
    }

    @Override
    public String getFailureReason() {
        return "credits below " + minCredits;
    }
}
