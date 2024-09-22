package kidsgame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Label;

public class Next extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Next frame = new Next();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Next() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 500, 300);
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		
		Button button = new Button("ADD");
		button.setBounds(100,40,100,40);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new I().setVisible(true);
			}
		});
		
		Button button_1 = new Button("COUNT");
		button_1.setBounds(300,40,100,40);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new screen3().setVisible(true);
			}
		});
		contentPane.add(button_1);
		
		setContentPane(contentPane);
		JLabel label = new JLabel("",JLabel.LEFT);
		label.setIcon(new ImageIcon(Next.class.getResource("/kidsgame/img.jpeg")));
		label.setBounds(100,200,500,200);
		contentPane.add(label);
//		BufferedImage myPicture;
//		try {
//			myPicture = ImageIO.read(new File("img.jpeg"));
//			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//			picLabel.setBounds(100,60,500,300);
//			contentPane.add(picLabel);
//			picLabel.setVisible(true);
//
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
				
	}

}
