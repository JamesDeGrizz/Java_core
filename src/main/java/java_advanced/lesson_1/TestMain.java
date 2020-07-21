package java_advanced.lesson_1;

public class TestMain {
    public static void main(String[] args) {
        Course c = new Course();
        Team team = new Team("Fantastic Four");

        try {
            c.doIt(team);
        }
        catch (Exception e) {
            System.out.println("Team can't solve the course, got exception " + e.getMessage());
            System.exit(1);
        }

        team.showOnlyGoodResults();
        team.showAllResults();
    }
}
