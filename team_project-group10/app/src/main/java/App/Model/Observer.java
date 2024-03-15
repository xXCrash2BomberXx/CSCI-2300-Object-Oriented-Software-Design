package App.Model;

public interface Observer {
	public void addSprites(Model model);
	public void draw(Model model);
	public void dispose();
}
