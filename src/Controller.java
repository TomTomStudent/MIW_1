import java.util.ArrayList;

public class Controller {
    private View view;
    private Model model;
    private String opponentChoice;
    private int userScore = 0;
    private int opponentScore = 0;
    private int turn = 0;


    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void round() throws InterruptedException {
        opponentChoice = model.robotChoice();
        view.opponentChoiceLabel.setText("Chosen");
        String result = model.determineWinner(view.userChoiceLabel.getText(),opponentChoice);
        view.opponentChoiceLabel.setText(opponentChoice);
        System.out.println(opponentChoice);
        Thread.sleep(1000);
        view.outcomeLabel.setText(result);
        ArrayList<Integer> arrayList = model.adjustScore(userScore,opponentScore,result);
        userScore = arrayList.get(0);
        opponentScore = arrayList.get(1);
        view.userScoreLabel.setText(String.valueOf(userScore));
        view.opponentScoreLabel.setText(String.valueOf(opponentScore));
        turn++;
        view.turnLabel.setText(String.valueOf(turn));
        if (model.endOfRoundCheck(model.checkTurn(turn), model.checkScore(userScore,opponentScore))==1){
            System.exit(1);
        }
        view.userChoiceLabel.setText("Waiting...");
        view.opponentChoiceLabel.setText("Waiting...");
    }
}
