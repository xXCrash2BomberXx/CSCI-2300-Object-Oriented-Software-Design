package App.View;

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenuView extends JFrame {
	public JTextField xText;
	public JTextField yText;
	public JTextField zText;
	public JButton startButton;
	public JButton leaderboardButton;

	public MainMenuView() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon rubiksImage = null;
		try {
			Image image = ImageIO.read(new FileInputStream("src/main/java/App/View/black_cube.jpg"));
			Image scaledImage = image.getScaledInstance(200, 200, image.SCALE_SMOOTH);
			rubiksImage = new ImageIcon(scaledImage);
		} catch (FileNotFoundException e) {
			System.err.println("Image file not found: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

		JPanel imagePanel = new JPanel();
		if (rubiksImage != null) {
			JLabel logoLabel = new JLabel(rubiksImage);
			imagePanel.add(logoLabel);
		}

		JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		inputPanel.add(new JLabel("Enter X Size:", SwingConstants.CENTER));
		inputPanel.add(xText = new JTextField("3", 10));
		inputPanel.add(new JLabel("Enter Y Size:", SwingConstants.CENTER));
		inputPanel.add(yText = new JTextField("3", 10));
		inputPanel.add(new JLabel("Enter Z Size:", SwingConstants.CENTER));
		inputPanel.add(zText = new JTextField("3", 10));

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		startButton = new JButton("Generate Rubik's Cube");
		leaderboardButton = new JButton("Open Leaderboard");
		buttonPanel.add(startButton);
		buttonPanel.add(leaderboardButton);

		add(imagePanel, BorderLayout.NORTH);
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}