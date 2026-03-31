public class Main {

    public static void main(String[] args) {

        Policy p1 = new Policy("CAR-100", "Jan Nowak", 850.0, 3, 68000.0, true, true);
        Policy p2 = new Policy("CAR-203", "Anna Kowalska", 920.0, 4, 45000.0, false, false);
        Policy p3 = new Policy("CAR-230", "Piotr Rafal", 780.0, 2, 52000.0, true, false);

        System.out.println("=== POLICY TEST ===");

        System.out.println("Final premiums:");
        System.out.println(p1.calculateFinalPremium());
        System.out.println(p2.calculateFinalPremium());
        System.out.println(p3.calculateFinalPremium());

        System.out.println();

        System.out.println("Renewal premiums:");
        System.out.println(p1.calculateRenewalPremium());
        System.out.println(p2.calculateRenewalPremium());
        System.out.println(p3.calculateRenewalPremium());

        System.out.println();

        System.out.println("Risk summaries:");
        System.out.println(p1.getRiskSummary());
        System.out.println(p2.getRiskSummary());
        System.out.println(p3.getRiskSummary());

        System.out.println();

        System.out.println("Equals test:");
        System.out.println(p1.equals(new Policy("CAR-201", "Test", 700, 1, 30000, false, false)));

        System.out.println();

        System.out.println("toString test:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println();

        System.out.println("Created policies:");
        System.out.println(Policy.getCreatedPolicyCount());

    }
}