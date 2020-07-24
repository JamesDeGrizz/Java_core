package java_advanced.lesson_1;

public class Team {
    private final int teamSize;
    private Creature[] team;
    private final String teamName;

    public Team(Creature[] teamMembers, String teamName) {
        teamSize = teamMembers.length;
        team = new Creature[teamSize];
        this.teamName = teamName;

        for (int i = 0; i < teamMembers.length; ++i) {
            team[i] = teamMembers[i];
        }
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
