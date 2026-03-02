public class CgrRule implements EligibilityRule {
    private final double minCgr;

    public CgrRule(double minCgr) {
        this.minCgr = minCgr;
    }

    @Override
    public boolean isFailed(StudentProfile student) {
        return student.cgr < minCgr;
    }

    @Override
    public String getFailureReason() {
        return "CGR below " + minCgr;
    }
}
