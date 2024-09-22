package kidsgame;


//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.Random;
//
//public class screen3 {
//    private int score = 0;
//    private JFrame mainFrame;
//
//    public screen3() {
//        createMainInterface();
//    }
//    
//
//    private void createMainInterface() {
//        mainFrame = new JFrame("Kids_World");
//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainFrame.setSize(500, 900);
//
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayout(4,4));
//          //mainPanel.setLayout(new (4, 1, 1, 2)); 
//        
//        
//
//        JButton countingButton = new JButton("Counting Game (1)");
//        JButton additionButton = new JButton("Addition Game (2)");
//        JButton subtractionButton = new JButton("Subtraction Game (3)");
//        JButton viewScoreButton = new JButton("View Score (4)");
//
//        countingButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //mainFrame.dispose(); // Close the main menu
//                openCountingGame();
//            }
//        });
//
//        additionButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //mainFrame.dispose(); // Close the main menu
//                openAdditionGame();
//            }
//        });
//
//        subtractionButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               // mainFrame.dispose(); // Close the main menu
//                openSubtractionGame();
//            }
//        });
//
//        viewScoreButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                viewScore();
//            }
//        });
//
//        mainPanel.add(countingButton);
//        mainPanel.add(additionButton);
//        mainPanel.add(subtractionButton);
//        mainPanel.add(viewScoreButton);
//
//        mainFrame.add(mainPanel);
//        mainFrame.setVisible(true);
//    }
// 
//    
//   
//  
//   
//
//    private void openGameScreen(JFrame gameFrame, String gameName) {
//        JLabel backLabel = new JLabel("Press 'b' to go back to the main menu.");
//        backLabel.setHorizontalAlignment(JLabel.CENTER);
//        backLabel.setFont(new Font("Arial", Font.PLAIN, 12));
//
//        gameFrame.add(backLabel, BorderLayout.SOUTH);
//
//        gameFrame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if (e.getKeyChar() == 'b' || e.getKeyChar() == 'B') {
//                    gameFrame.dispose();
//                    //createMainInterface(); // Return to the main menu
//                }
//            }
//        });
//
//        gameFrame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                createMainInterface(); // Return to the main menu when the game is closed
//            }
//        });
//
//        gameFrame.setTitle(gameName);
//        gameFrame.setVisible(true);
//        gameFrame.requestFocus();
//    }
//
//   private void openCountingGame() {
//        JFrame countingFrame = new JFrame();
//        countingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        countingFrame.setSize(400, 600);
//        //JOptionPane.showMessageDialog(null, "Total Score: " + score, "Score", JOptionPane.INFORMATION_MESSAGE);
//        
//        int count = generateRandomNumber(1, 10);
//        String emojiSequence = generateRandomEmojiSequence(count);
//
//        JLabel emojiLabel = new JLabel(emojiSequence);
//        emojiLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
//        emojiLabel.setHorizontalAlignment(JLabel.CENTER);
//
//        JButton checkButton = new JButton("Your Answer");
//        
//        
//
//        
//
//        checkButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int correctAnswer = count;
//                String userAnswer = JOptionPane.showInputDialog("Enter your answer: ");
//                if (userAnswer != null) {
//                    try {
//                        int userCount = Integer.parseInt(userAnswer);
//                        if (userCount == correctAnswer) {
//                            score += 10;
//                            JOptionPane.showMessageDialog(null, "Correct! You scored 10 points.");
//                            countingFrame.dispose();
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Incorrect. Try again.");
//                        }
//                    } catch (NumberFormatException ex) {
//                        JOptionPane.showMessageDialog(null, "Please enter a number.");
//                    }
//                }
//            }
//        });
//
//        countingFrame.add(emojiLabel, BorderLayout.CENTER);
//        countingFrame.add(checkButton, BorderLayout.SOUTH);
//        countingFrame.setVisible(true);
//
//        // ... (rest of your code for the counting game)
//
//        openGameScreen(countingFrame, "Counting Game");
//        
//    }
//
//
//    
//
//    private void openAdditionGame() {
//        JFrame additionFrame = new JFrame();
//        additionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        additionFrame.setSize(400, 300);
//        
//        int num1 = generateRandomNumber(1, 10);
//        int num2 = generateRandomNumber(1, 10);
//        int correctAnswer = num1 + num2;
//        String emojiSequence1 = generateRandomEmojiSequence(num1);
//        String emojiSequence2 = generateRandomEmojiSequence(num2);
//
//        JLabel equationLabel = new JLabel(emojiSequence1 + " + " + emojiSequence2 + " = ?");
//        equationLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
//
//        JButton checkButton = new JButton("Your Answer");
//
//        checkButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String userAnswer = JOptionPane.showInputDialog("Enter the correct answer:");
//                if (userAnswer != null) {
//                    try {
//                        int userResult = Integer.parseInt(userAnswer);
//                        if (userResult == correctAnswer) {
//                            score += 10;
//                            JOptionPane.showMessageDialog(null, "Correct! You scored 10 points.");
//                            additionFrame.dispose();
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Incorrect. Try again.");
//                        }
//                    } catch (NumberFormatException ex) {
//                        JOptionPane.showMessageDialog(null, "Please enter a number.");
//                    }
//                }
//            }
//        });
//
//        additionFrame.add(equationLabel, BorderLayout.CENTER);
//        additionFrame.add(checkButton, BorderLayout.SOUTH);
//        additionFrame.setVisible(true);
//
//        // ... (rest of your code for the addition game)
//
//        openGameScreen(additionFrame, "Addition Game");
//    }
//
//    private void openSubtractionGame() {
//        JFrame subtractionFrame = new JFrame();
//        subtractionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        subtractionFrame.setSize(400, 300);
//        
//        int num1 = generateRandomNumber(1, 10);
//        int num2 = generateRandomNumber(1, num1);
//        int correctAnswer = num1 - num2;
//        String emojiSequence1 = generateRandomEmojiSequence(num1);
//        String emojiSequence2 = generateRandomEmojiSequence(num2);
//
//        JLabel equationLabel = new JLabel(emojiSequence1 + " - " + emojiSequence2 + " = ?");
//        equationLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
//
//        JButton checkButton = new JButton("Your Answer");
//
//        checkButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String userAnswer = JOptionPane.showInputDialog("Enter the correct answer:");
//                if (userAnswer != null) {
//                    try {
//                        int userResult = Integer.parseInt(userAnswer);
//                        if (userResult == correctAnswer) {
//                            score += 10;
//                            JOptionPane.showMessageDialog(null, "Correct! You scored 10 points.");
//                            subtractionFrame.dispose();
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Incorrect. Try again.");
//                        }
//                    } catch (NumberFormatException ex) {
//                        JOptionPane.showMessageDialog(null, "Please enter a number.");
//                    }
//                }
//            }
//        });
//
//        subtractionFrame.add(equationLabel, BorderLayout.CENTER);
//        subtractionFrame.add(checkButton, BorderLayout.SOUTH);
//        subtractionFrame.setVisible(true);
//
//        // ... (rest of your code for the subtraction game)
//
//        openGameScreen(subtractionFrame, "Subtraction Game");
//    }
//    
//    
//
//    
//
//    private void viewScore() {
//        JOptionPane.showMessageDialog(null, "Total Score: " + score, "Score", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    private int generateRandomNumber(int min, int max) {
//        Random random = new Random();
//        return random.nextInt(max - min + 1) + min;
//    }
//
//    private String generateRandomEmojiSequence(int count) {
//        String[] emojis = {"❤", "😀", "🌟", "🍔", "🚀", "🌈", "🎉", "🐱", "🎸", "🌺"};
//        StringBuilder emojiSequence = new StringBuilder();
//
//        Random random = new Random();
//
//        for (int i = 0; i < count; i++) {
//            int randomIndex = random.nextInt(emojis.length);
//            emojiSequence.append(emojis[randomIndex]);
//        }
//
//        return emojiSequence.toString();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new screen3();
//            }
//        });
//    }
//}
//









import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;

public class screen3 extends JFrame {
    private int score = 0;
    private JButton[] answerButtons;
    private JLabel[] emojiLabels;
    private JLabel scoreLabel;
    private Random random = new Random();
    private int correctButtonIndex;

    public screen3() {
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
        SwingUtilities.invokeLater(() -> new screen3());
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






