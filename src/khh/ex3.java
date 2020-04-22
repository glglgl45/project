package khh;       // 로그인 성공시 뜨는 화면창~~
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ex3 extends JFrame{
	public ex3(){
	JPanel p = new JPanel();
    Label l1= new Label("이름");
    Label l2 = new Label("아이디");
    Label l3= new Label("패스워드");
    Label l4 = new Label("주소");
    
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    t3.setEchoChar('*');
    TextField t4 = new TextField();
    TextField t5 = new TextField();
    add(t1);
    add(t2);
    add(t3);
    add(t4);
    add(t5);
    t1.setEditable(false);
    t2.setEditable(false);
    t3.setEditable(false);
    t4.setEditable(false);
    t5.setEditable(false);
    JButton j1 = new JButton("확인");
    JButton j2 = new JButton("수정");
    add(j1);
    add(j2);
    l1.setBounds(40, 10, 40, 40);
    l2.setBounds(40, 50, 40, 40);
    l3.setBounds(40,90,60,40);
    l4.setBounds(40, 130, 40, 40);
    t1.setBounds(120, 10, 200, 30);
    t2.setBounds(120, 50, 200, 30);
    t3.setBounds(120, 90, 200, 30);
    t4.setBounds(120, 130, 280, 30);
    t5.setBounds(120, 180, 280, 120);
    j1.setBounds(125, 330, 80, 30);
    j2.setBounds(240, 330, 80, 30);
    try { //로그인하고 회원정보 데이터 입력
 	   String s; 
 	   String[] array; 
 	   BufferedReader br = new BufferedReader(new FileReader("회원명단.txt")); 
 	   while ((s = br.readLine()) != null) { 
 	      array = s.split("/"); 
 	     t1.setText(array[0]);
 	     t2.setText(array[1]);
 	     t3.setText(array[2]);
 	     t4.setText(array[3]);
 	     t5.setText(array[4]);
 	   } 
 	   br.close(); 
 	   } catch (IOException e2) { 
 	   e2.printStackTrace(); 
 	} 
add(p);
setSize(500,500);
setTitle("로그인 성공");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
j1.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e3) {
			ex5 drawing = new ex5 ();
	}
	
});
j2.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e4) {
		// TODO Auto-generated method stub
		ex4 f4 = new ex4();
	}
});
	}
}