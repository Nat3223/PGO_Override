import java.util.Objects;

public class Policy {
    private String policyNumber;
    private String clientName;
    private double basePremium;
    private int riskLevel;
    private double vehicleValue;
    private boolean hasAlarm;
    private boolean claimFreeClient;

    private static int createdPolicyCount = 0;
    private static final double ADMINISTRATIVE_FEE = 37.5;

    public Policy(String policyNumber, String clientName, double basePremium, int riskLevel, double vehicleValue,boolean hasAlarm, boolean claimFreeClient) {

        this.policyNumber = policyNumber;
        this.clientName = clientName;
        this.basePremium = basePremium;
        this.riskLevel = riskLevel;
        this.vehicleValue = vehicleValue;
        this.hasAlarm = hasAlarm;
        this.claimFreeClient = claimFreeClient;

        createdPolicyCount++;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double calculateFinalPremium() {
        double premium = basePremium + ADMINISTRATIVE_FEE;

        premium += riskLevel * 95;

        if (vehicleValue > 55000) {
            premium += 180;
        }

        if (riskLevel >= 4 && !hasAlarm) {
            premium += 100;
        }

        if (hasAlarm) {
            premium *= 0.93;
        }

        if (claimFreeClient) {
            premium *= 0.88;
        }

        if (premium < basePremium) {
            premium = basePremium;
        }

        return Math.round(premium * 100.0) / 100.0;

    }

    public double calculateRenewalPremium() {

        double current = calculateFinalPremium();
        double renewal = current;

        if (riskLevel == 3) {
            renewal *= 1.05;
        } else if (riskLevel == 4) {
            renewal *= 1.12;
        } else if (riskLevel >= 5) {
            renewal *= 1.18;
        }

        if (vehicleValue > 55000) {
            renewal += 130;
        }

        if (claimFreeClient) {
            renewal *= 0.90;
        }

        if (hasAlarm) {
            renewal *= 0.93;
        }

        double min = current * 0.85;
        double max = current * 1.30;

        if (renewal < min) renewal = min;
        if (renewal > max) renewal = max;

        return Math.round(renewal * 100.0) / 100.0;
    }

    public String getRiskSummary() {
        return clientName + " (Policy: " + policyNumber + ") Risk level: " + riskLevel;
    }

    public static int getCreatedPolicyCount() {
        return createdPolicyCount;
    }

    @Override
    public String toString() {
        return "Policy{" + "number='" + policyNumber + '\'' + ", client='" + clientName + '\'' + ", finalPremium=" + calculateFinalPremium() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }
}