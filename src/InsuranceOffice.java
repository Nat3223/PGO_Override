import java.util.ArrayList;

public class InsuranceOffice {
    private String name;
    private ArrayList<Policy> policies;

    public InsuranceOffice(String name) {
        this.name = name;
        this.policies = new ArrayList<>();
    }

    public void addPolicy(Policy policy) {
        policies.add(policy);
    }

    public void printReport() {
        System.out.println("=== INSURANCE OFFICE REPORT ===");
        System.out.println("Office name: " + name);
        System.out.println("Policies in portfolio: " + policies.size());
        System.out.println();

        for (Policy policy : policies) {
            System.out.println(policy);
            System.out.println("Risk summary: " + policy.getRiskSummary());
            System.out.println("Final premium: " + policy.calculateFinalPremium());
            System.out.println("Renewal premium: " + policy.calculateRenewalPremium());
            System.out.println();
        }
    }

    public double calculateTotalPremium() {
        double total = 0;

        for (Policy policy : policies) {
            total += policy.calculateFinalPremium();
        }

        return Math.round(total * 100.0) / 100.0;
    }

    public double calculateTotalRenewalForecast() {
        double total = 0;

        for (Policy policy : policies) {
            total += policy.calculateRenewalPremium();
        }

        return Math.round(total * 100.0) / 100.0;
    }

    public int countHighRiskPolicies() {
        int count = 0;

        for (Policy policy : policies) {
            if (policy.getRiskSummary().contains("Risk level: 4") ||
                    policy.getRiskSummary().contains("Risk level: 5") ||
                    policy.getRiskSummary().contains("Risk level: 6") ||
                    policy.getRiskSummary().contains("Risk level: 7") ||
                    policy.getRiskSummary().contains("Risk level: 8") ||
                    policy.getRiskSummary().contains("Risk level: 9") ||
                    policy.getRiskSummary().contains("Risk level: 10")) {
                count++;
            }
        }

        return count;
    }

    public Policy findByNumber(String policyNumber) {
        for (Policy policy : policies) {
            if (policy.getPolicyNumber().equals(policyNumber)) {
                return policy;
            }
        }
        return null;
    }

    public void printCheaperThan(double threshold) {
        System.out.println("=== POLICIES CHEAPER THAN " + threshold + " ===");

        for (Policy policy : policies) {
            if (policy.calculateFinalPremium() < threshold) {
                System.out.println(policy);
            }
        }
    }
}