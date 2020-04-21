package khh;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ex4 extends JFrame{//수정클릭시
	public ex4(){
	JPanel p = new JPanel();
    p.setLayout(null);
    Label l1= new Label("이름");
    Label l2 = new Label("아이디");
    Label l3= new Label("패스워드");
    Label l4 = new Label("주소");
   
    getContentPane().add(l1);
    getContentPane().add(l2);
    getContentPane().add(l3);
    getContentPane().add(l4);
  
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();
    t3.setEchoChar('*');
    getContentPane().add(t1);
    getContentPane().add(t2);
    getContentPane().add(t3);
    getContentPane().add(t4);
    t1.setEditable(false);
    t2.setEditable(false);
    t3.setEditable(false);
    JButton j1 = new JButton("수정");
    JButton j2 = new JButton("취소");
    getContentPane().add(j1);
    getContentPane().add(j2);
    l1.setBounds(40, 10, 40, 40);
    l2.setBounds(40, 50, 40, 40);
    l3.setBounds(40,90,60,40);
    l4.setBounds(40, 130, 40, 40);
  
    t1.setBounds(120, 10, 200, 30);
    t2.setBounds(120, 50, 200, 30);
    t3.setBounds(120, 90, 200, 30);
    t4.setBounds(120, 130, 280, 30);
    j1.setBounds(125, 330, 80, 30);
    j2.setBounds(240, 330, 80, 30);
getContentPane().add(p);
setSize(500,500);
setTitle("수정");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
try {                             
	   String s; 
	   String[] array; 
	   BufferedReader br = new BufferedReader(new FileReader("회원명단.txt")); 
	   while ((s = br.readLine()) != null) { 
	      array = s.split("/"); 
	     t1.setText(array[0]);
	     t2.setText(array[1]);
	     t3.setText(array[2]);
	     t4.setText("");
	     
	   } 
	   br.close(); 
	   } catch (IOException e2) { 
	   e2.printStackTrace(); 
	}
j1.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e77) {             
		// TODO Auto-generated method stub
		try{
			BufferedWriter bo = new BufferedWriter(new FileWriter("회원명단.txt"));
			bo.write(t1.getText()+"/");
			bo.write(t2.getText()+"/");
			bo.write(t3.getText()+"/");
			bo.write(t4.getText()+"/");
			
			bo.close();
			 JOptionPane.showMessageDialog(null, "저장하였습니다."); 
        } catch (Exception ex) { 
        JOptionPane.showMessageDialog(null, "저장에 실패하였습니다."); 
     } 
		}
});
j2.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
	}
});
	}
}

