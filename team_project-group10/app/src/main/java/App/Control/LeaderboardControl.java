package App.Control;

import App.Model.LeaderboardModel;
import App.View.LeaderboardView;
import App.Model.LeaderboardEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeaderboardControl {
    private LeaderboardModel model;
    private LeaderboardView view;

    public LeaderboardControl(LeaderboardModel model) {
        this.model = model;
        this.view = new LeaderboardView(prepareLeaderboardData(model.getEntries()), this);
    }

    private ArrayList<String> prepareLeaderboardData(ArrayList<LeaderboardEntry> entries) {
        ArrayList<String> leaderboardData = new ArrayList<>();
        for (LeaderboardEntry entry : entries) {
            String entryString = entry.getXSize() + "x" + entry.getYSize() + "x" + entry.getZSize() + " : " + entry.getTime();
            leaderboardData.add(entryString);
        }
        return leaderboardData;
    }

    public ActionListener getClearButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearLeaderboard();
            }
        };
    }

    public void clearLeaderboard() {
        model.clearEntries();
        ArrayList<String> leaderboardData = prepareLeaderboardData(model.getEntries());
        view.dispose();
        this.view = new LeaderboardView(leaderboardData, this);
    }
}
