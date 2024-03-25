import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class View extends JFrame {
    public JLabel userChoiceLabel;
    public JLabel opponentChoiceLabel;
    public JLabel outcomeLabel;
    public JLabel userScoreLabel;
    public JLabel turnLabel;
    public JLabel opponentScoreLabel;
    private Controller controller;

    public void setController(Controller controller){
        this.controller = controller;
    }

    public static void GUI(){
        SwingUtilities.invokeLater(()->{
            View view = new View();
            view.setVisible(true);
        });
    }

    public View() {
        super("Rock, Paper, Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setSize(800, 800);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 3));
        JLabel userTextLabel = new JLabel("Your score: ", SwingConstants.CENTER);
        JLabel pauseLabel = new JLabel("");
        JLabel opponentTextLabel = new JLabel("Opponent score: ", SwingConstants.CENTER);
        textPanel.add(userTextLabel);
        textPanel.add(pauseLabel);
        textPanel.add(opponentTextLabel);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 2));
        userScoreLabel = new JLabel("0", SwingUtilities.CENTER);
        turnLabel = new JLabel("0",SwingUtilities.CENTER);
        opponentScoreLabel = new JLabel("0", SwingUtilities.CENTER);
        scorePanel.add(userScoreLabel);
        scorePanel.add(turnLabel);
        scorePanel.add(opponentScoreLabel);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(textPanel);
        topPanel.add(scorePanel);
        add(topPanel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(1, 3));
        JButton rockButton = new JButton();
        JButton paperButton = new JButton();
        JButton scissorsButton = new JButton();


        ImageIcon userIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/rock.jpg")));
        rockButton.setIcon((Icon) userIcon);
        rockButton.addActionListener(new OptionActionListener(0));

        userIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/paper.png")));
        paperButton.setIcon((Icon) userIcon);
        paperButton.addActionListener(new OptionActionListener(1));

        userIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/images/scissors.jpeg")));
        scissorsButton.setIcon((Icon) userIcon);
        scissorsButton.addActionListener(new OptionActionListener(2));

        optionsPanel.add(rockButton);
        optionsPanel.add(paperButton);
        optionsPanel.add(scissorsButton);

        JPanel optionTextPanel = new JPanel();
        optionTextPanel.setLayout(new GridLayout(1, 3));
        JLabel rockLabel = new JLabel("Rock", SwingUtilities.CENTER);
        JLabel paperLabel = new JLabel("Paper", SwingUtilities.CENTER);
        JLabel scrissorsLabel = new JLabel("Scissors", SwingUtilities.CENTER);
        optionTextPanel.add(rockLabel);
        optionTextPanel.add(paperLabel);
        optionTextPanel.add(scrissorsLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(optionsPanel);
        bottomPanel.add(optionTextPanel);
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1, 3));
        userChoiceLabel = new JLabel("Waiting...", SwingConstants.CENTER);
        outcomeLabel = new JLabel("DRAW!", SwingConstants.CENTER);
        opponentChoiceLabel = new JLabel("Waiting...", SwingConstants.CENTER);
        resultPanel.add(userChoiceLabel);
        resultPanel.add(outcomeLabel);
        resultPanel.add(opponentChoiceLabel);
        add(resultPanel, BorderLayout.CENTER);
    }

    private class OptionActionListener implements ActionListener {
        private int option;

        public OptionActionListener(int option) {
            this.option = option;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (option) {
                case 0 -> {
                    userChoiceLabel.setText("Rock");
                    try {
                        controller.round();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                case 1 -> {
                    userChoiceLabel.setText("Paper");
                    try {
                        controller.round();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                case 2 -> {
                    userChoiceLabel.setText("Scissors");
                    try {
                        controller.round();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                default -> userChoiceLabel.setText("ERROR");
            }
        }
    }
}