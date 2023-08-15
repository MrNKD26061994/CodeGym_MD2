public class TennisGame {
    final static int SCORE_ZERO = 0;
    final static int SCORE_FIFTEEN = 1;
    final static int SCORE_THIRTY = 2;
    final static int SCORE_FORTY = 3;

    public static StringBuilder getReadScoreBiggerBy4(int scorePlayerName1, int scorePlayerName2) {
        int minusScorePlayer1AndPlayer2 = scorePlayerName1-scorePlayerName2;
        if(minusScorePlayer1AndPlayer2 == 1) return new StringBuilder("Advantage player1");
        else if (minusScorePlayer1AndPlayer2 == -1) return new StringBuilder("Advantage player2");
        else if(minusScorePlayer1AndPlayer2 >= 2) return new StringBuilder("Win for player1");
        else return new StringBuilder("Win for player2");
    }
    public static StringBuilder getReadScore(int scorePlayerName1, int scorePlayerName2) {
        StringBuilder stringReadScore = new StringBuilder();
        stringReadScore.append(getStringScore(scorePlayerName1));
        stringReadScore.append("-");
        stringReadScore.append(getStringScore(scorePlayerName2));
        return stringReadScore;
    }

    public static StringBuilder getReadScoreDeuce(int scorePlayerName1){
        return new StringBuilder(switch (scorePlayerName1) {
            case SCORE_ZERO -> "Love-All";
            case SCORE_FIFTEEN -> "Fifteen-All";
            case SCORE_THIRTY -> "Thirty-All";
            case SCORE_FORTY -> "Forty-All";
            default -> "Deuce";
        });
    }

    public static String getStringScore(int score) {
        switch (score) {
            case SCORE_ZERO -> {
                return  "Love";
            }
            case SCORE_FIFTEEN -> {
                return  "Fifteen";
            }
            case SCORE_THIRTY -> {
                return "Thirty";
            }
            case SCORE_FORTY -> {
                return "Forty";
            }
            default -> {
                return "";
            }
        }
    }

    public static String getReadScore(String playerName1, String playerName2, int scorePlayerName1, int scorePlayerName2) {
        StringBuilder stringReadScore = new StringBuilder();
        if (scorePlayerName1 == scorePlayerName2) {
            stringReadScore = getReadScoreDeuce(scorePlayerName1);
        } else if (scorePlayerName1 >= 4 || scorePlayerName2 >= 4) {
            stringReadScore = getReadScoreBiggerBy4(scorePlayerName1, scorePlayerName2);
        }
        else {
            stringReadScore = getReadScore(scorePlayerName1, scorePlayerName2);
        }
        return stringReadScore.toString();
    }
}