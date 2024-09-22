package kidsgame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;

public class I extends JFrame {
    private int score = 0;
    private JButton[] answerButtons;
    private JLabel[] emojiLabels;
    private JLabel scoreLabel;
    private Random random = new Random();
    private int correctButtonIndex;

    public I() {
        setTitle("Emoji Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);

        answerButtons = new JButton[4];
        emojiLabels = new JLabel[10]; // Maximum 10 emojis
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBounds(10, 10, 100, 30);
        add(scoreLabel);

        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].setBounds(70 + i * 80, 300, 60, 30);
            answerButtons[i].addActionListener(new AnswerButtonListener(i));
            add(answerButtons[i]);
        }

        for (int i = 0; i < 10; i++) {
            emojiLabels[i] = new JLabel();
            emojiLabels[i].setBounds(150 - 25 * i, 100, 50, 50);
            add(emojiLabels[i]);
        }

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(160, 10, 80, 30);
        exitButton.addActionListener(e -> exitGame());
        add(exitButton);

        initializeGame();
        setVisible(true);
    }

    private void initializeGame() {
        String[] emojis = {"😀", "🎈", "🌟", "🍎", "🐶", "🚀", "🌈", "🚲"};

        int correctAnswer = random.nextInt(7) + 1;
        List<Integer> answerPositions = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(answerPositions);

        for (int i = 0; i < 10; i++) {
            if (i < correctAnswer) {
                emojiLabels[i].setText(emojis[random.nextInt(emojis.length)]);
            } else {
                emojiLabels[i].setText("");
            }
        }

        int[] randomAnswers = generateDistinctRandomNumbers(4, 1, 10, correctAnswer);

        for (int i = 0; i < 4; i++) {
            int randomAnswer = randomAnswers[i];
            answerButtons[answerPositions.get(i)].setText(Integer.toString(randomAnswer));
        }

        correctButtonIndex = answerPositions.get(0);
        answerButtons[correctButtonIndex].setText(Integer.toString(correctAnswer));

        updateScoreLabel();
    }

    private void handleAnswer(int selectedAnswer) {
        if (selectedAnswer == Integer.parseInt(answerButtons[correctButtonIndex].getText())) {
            score += 10;
        }
        initializeGame();
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + score);
    }

    private void exitGame() {
        JOptionPane.showMessageDialog(this, "Final Score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        new Next().setVisible(true);
    }

    private class AnswerButtonListener implements ActionListener {
        private int index;

        public AnswerButtonListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedAnswer = Integer.parseInt(answerButtons[index].getText());
            handleAnswer(selectedAnswer);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new I());
    }

    private int[] generateDistinctRandomNumbers(int count, int min, int max, int exclude) {
        if (count > (max - min + 1) || (max - min + 1) < count) {
            throw new IllegalArgumentException("Cannot generate distinct random numbers within the given range.");
        }

        int[] result = new int[count];
        List<Integer> range = Arrays.asList(min, max);
        Collections.shuffle(range);

        int[] number = { -1 };

        for (int i = 0; i < count; i++) {
            int finalExclude = exclude;
            IntPredicate anyMatchPredicate = x -> x == number[0];
            do {
                number[0] = random.nextInt(max - min + 1) + min;
            } while (number[0] == finalExclude || Arrays.stream(result).anyMatch(anyMatchPredicate));
            result[i] = number[0];
        }

        return result;
    }
}