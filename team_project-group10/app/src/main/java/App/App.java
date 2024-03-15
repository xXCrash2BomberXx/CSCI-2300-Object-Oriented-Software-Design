package App;

import App.Control.MainMenuControl;
import App.View.MainMenuView;

public class App {
	public static void main(String args[]) throws IllegalArgumentException {
		MainMenuView view = new MainMenuView();
		new MainMenuControl(view);
	}
}