package App.Control;

import App.View.MainMenuView;
import App.Control.LeaderboardControl;
import App.Model.LeaderboardModel;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenuControl implements ActionListener {
	private MainMenuView view;

	public MainMenuControl(MainMenuView view) {
		this.view = view;
		this.view.startButton.addActionListener(this);
		this.view.leaderboardButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.startButton) {
			int xSize, ySize, zSize;
			try {
				xSize = Integer.parseInt(view.xText.getText());
				ySize = Integer.parseInt(view.yText.getText());
				zSize = Integer.parseInt(view.zText.getText());
				new Control(xSize, ySize, zSize);
			} catch (NumberFormatException error) {
				new Control();
			}
			view.dispose();
		} else if (e.getSource() == view.leaderboardButton) {
			LeaderboardModel leaderboardModel = new LeaderboardModel();
			LeaderboardControl leaderboardControl = new LeaderboardControl(leaderboardModel);
		}
	}
}