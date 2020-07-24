package java_advanced.lesson_1;

public class TestMain {
    public static void main(String[] args) {
        Course c = new Course();

        Creature[] teamMembers = new Creature[4];
        teamMembers[0] = new Human(50, 1);
        teamMembers[1] = new Human(150, 2);
        teamMembers[2] = new Cat(1500, 3);
        teamMembers[3] = new Robot(15000, 6);

        Team team = new Team(teamMembers, "Fantastic Four");

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
