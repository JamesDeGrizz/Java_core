package java_advanced.lesson_1;

public class Team {
    private final int teamSize;
    private Creature[] team;
    private final String teamName;

    public Team(String teamName) {
        teamSize = 4;
        team = new Creature[teamSize];
        this.teamName = teamName;

        team[0] = new Human(50, 1);
        team[1] = new Human(150, 2);
        team[2] = new Cat(1500, 3);
        team[3] = new Robot(15000, 6);
    }

    public Creature[] getTeam() {
        return team;
    }

    public void showOnlyGoodResults() {
        int index = 0;
        for (Creature member : team) {
            System.out.println("\nShowing only good results to member " + index);
            member.showOnlyGoodResults();
            ++index;
        }
    }

    public void showAllResults() {
        int index = 0;
        for (Creature member : team) {
            System.out.println("\nShowing all results to member " + index);
            member.showAllResults();
            ++index;
        }
    }
}
