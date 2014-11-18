
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class Test extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private static DefaultTableModel model;
	
	private JButton btn;
	private JButton btn_delete;
	private JButton btn_select;
	
	private JScrollPane tPane;
	private static Vector<String> data;
	
	private ResultSet res;
	private static Test test;
/*	String Type_code = "35#0106Yc110202";
	String Type_name = "안드로이드폰";
	String Type_price = "20000";
	String Type_yn = "Y";*/
	
	Sql_query sql = new Sql_query();
	
	
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JScrollPane gettPane() {
		return tPane;
	}

	public void settPane(JScrollPane tPane) {
		this.tPane = tPane;
	}

	public Vector<String> getData(){
			
		return data;
	}

	
	public void setData(Vector<String> data) {
				
		sql.insert_date(data.get(0), data.get(1),data.get(2),data.get(3));
		
	}
	/**
	 * Launch the application.
	 */
	 
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTime());
		test=new Test();
		test.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		btn = new JButton("Input");
		btn_delete= new JButton("Delete");
		btn_select = new JButton("Show");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		model = new DefaultTableModel(new String[]{"도서 코드","도서명","가격","재고상태"},0);
		
		table = new JTable(model);
		tPane = new JScrollPane(table);
		contentPane.add(tPane,"Center");
		contentPane.add(btn,"South");
		contentPane.add(btn_select,"East");
		contentPane.add(btn_delete,"West");
		
		btn.addActionListener(new ActionListener(){				
				@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubs					 
					InputBox input=new InputBox("INPUT BOX");	
					
				}
		});	
		
		btn_select.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				res=sql.select();
				
				try {					
					while(res.next()){
						String[] dt ={res.getString(1),res.getString(2),res.getString(3),res.getString(4)};
						model.addRow(dt);				
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		});
		
		
		
		
		btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Delete: "+getTable().getValueAt(getTable().getSelectedRow(), 0).toString());
				sql.delete_table(getTable().getValueAt(getTable().getSelectedRow(), 0).toString());
				model.removeRow(getTable().getSelectedRow());
			}
		});
	}
}