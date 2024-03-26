import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Model {
    private static final Map<String, String> WINNING_MOVES = new HashMap<>();
    static {
        WINNING_MOVES.put("Rock", "Scissors");
        WINNING_MOVES.put("Paper", "Rock");
        WINNING_MOVES.put("Scissors", "Paper");
    }

    public String determineWinner(String userChoice, String opponentChoice) {
        if (WINNING_MOVES.get(userChoice).equals(opponentChoice)) {
            return "Winner!";
        } else if (WINNING_MOVES.get(opponentChoice).equals(userChoice)) {
            return "Loser!";
        } else {
            return "Draw!";
        }
    }

    public ArrayList<Integer> adjustScore(int userScore, int opponentScore, String outcome){
        switch (outcome){
            case "Winner!" -> userScore++;
            case "Loser!" -> opponentScore++;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(userScore);
        arr.add(opponentScore);
        return arr;
    }

    public int checkScore(int userScore, int opponentScore){
        if (userScore>=10 || opponentScore>=10)
            return 1;
        return 0;
    }

    public String declareWinner(int userScore, int opponentScore){
        if (userScore==10)
            return "USER WINS!!!";
        return "OPPONENT WINS :(";
    }

    public int checkTurn(int turn){
        if (turn>15)
            return 1;
        return 0;
    }

    public String robotChoice(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        String result = "Rock";
        switch (randomNum){
            case 1 -> result = "Rock";
            case 2 -> result = "Paper";
            case 3 -> result = "Scissors";
        }
        return result;
    }

    public int endOfRoundCheck(int turnCheck, int pointCheck){
        if (turnCheck==1||pointCheck==1)
            return 1;
        return 0;
    }


//    public String determineWinner(String userChoice, String opponentChoice){
//        if ((userChoice.equals("Rock")&&opponentChoice.equals("Scissors"))||(userChoice.equals("Paper")&&opponentChoice.equals("Rock"))||(userChoice.equals("Scissors")&&opponentChoice.equals("Paper"))){
//            return "Winner!";
//        } else if ((userChoice.equals("Scissors")&&opponentChoice.equals("Rock"))||(userChoice.equals("Rock")&&opponentChoice.equals("Paper"))||(userChoice.equals("Paper")&&opponentChoice.equals("Scissors"))){
//            return "Loser!";
//        } else {
//            return "Draw!";
//        }
//    }
}
