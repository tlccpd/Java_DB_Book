import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class InputBox extends JFrame{
	Label label_name = new Label("책이름 : ");
	 Label label_code = new Label("책 코드 : ");
	 Label label_price = new Label("책 가격 : ");
	 Label label_yn = new Label("재고 여부 : ");
	
	 Button butt=new Button("Input");
	 TextArea tb_code = new TextArea(1,7);
	 TextArea tb_name = new TextArea(1,7);
	 TextArea tb_price = new TextArea(1,7);
	 TextArea tb_yn = new TextArea(1,7);
	 InputBox input;
	 Vector<String> data=new Vector<String>();
	 
	    public InputBox(String title){
	    	this.init();
	    	this.start();
	    	
	    	super.setSize(300,200);
	    	super.setTitle(title);
	    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    	Dimension frm = super.getSize();
	    	int xpos= (int)(screen.getWidth()/2-frm.getWidth()/2);
	    	int ypos =(int)(screen.getHeight()/2-frm.getHeight()/2);
	    	super.setLocation(xpos, ypos);
	    	super.setResizable(true);
	    	this.pack();
	    	super.setVisible(true);
	    }
	    public void init(){
	    	this.setLayout(new BorderLayout());
	
	    	Panel topPane=new Panel();
	    	topPane.add(label_code);
	    	topPane.add(tb_code, 0);
	    	topPane.add(label_name);
	    	topPane.add(tb_name, 0);
	    	topPane.add(label_price);
	    	topPane.add(tb_price, 0);
	    	topPane.add(label_yn);
	    	topPane.add(tb_yn, 0);
	    	
	    	topPane.add(butt);	    	
	    	
	    	this.add(topPane, "North");	
}
public Vector<String> getdata(){
   	return data;
}
public void start(){
		
		butt.addActionListener(new ActionListener() {
									
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {	
					 
					 Test test=new Test();
					public void run() {
						try {						
							
							data.add(0, tb_code.getText());
							data.add(1, tb_name.getText());
							data.add(2, tb_price.getText());
							data.add(3,tb_yn.getText());												
							test.setData(data);
							test.getModel().addRow(data);
							test.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});			
			}
		});
	} 
}