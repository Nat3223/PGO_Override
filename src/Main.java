public class Main {

    public static void main(String[] args) {
        InsuranceOffice office = new InsuranceOffice("Secure Future");

        Policy p1 = new Policy("CAR-100", "Jan Nowak", 850.0, 3, 68000.0, true, true);
        Policy p2 = new Policy("CAR-203", "Anna Kowalska", 920.0, 4, 45000.0, false, false);
        Policy p3 = new Policy("CAR-230", "Piotr Rafal", 780.0, 2, 52000.0, true, false);

        office.addPolicy(p1);
        office.addPolicy(p2);
        office.addPolicy(p3);

        office.printReport();

        System.out.println("Total premium: " + office.calculateTotalPremium());
        System.out.println("Total renewal forecast: " + office.calculateTotalRenewalForecast());
        System.out.println("High-risk policies: " + office.countHighRiskPolicies());
        System.out.println("Created policy count: " + Policy.getCreatedPolicyCount());

        System.out.println();

        System.out.println("Risk summary for p1:");
        System.out.println(p1.getRiskSummary());

        System.out.println();

        System.out.println("Renewal forecast for p1:");
        System.out.println(p1.calculateRenewalPremium());

        System.out.println();

        System.out.println("Equals test:");
        System.out.println(p1.equals(new Policy("CAR-100", "Different client", 700.0, 1, 30000.0, false, false)));

        System.out.println();

        System.out.println("toString test:");
        System.out.println(p2);

        System.out.println();

        Policy found = office.findByNumber("CAR-203");
        System.out.println("Found: " + found);

        System.out.println();

        office.printCheaperThan(1200.0);
    }
}