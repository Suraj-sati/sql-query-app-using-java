import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class query_app extends JFrame implements ActionListener,KeyListener {
 
String t,d; 
int i=1; 
 
Connection con;
Statement st;
ResultSet rs;
ResultSetMetaData rsmd;
    


JPanel p1;
JPanel p2;
JLabel l1;
JLabel l2;
JTextField tf1;
JTextField tf2;
JTextArea ta1;
JTextArea ta2;
JButton ddl;
JButton dml;
JButton dql;
JButton reset;
JButton exit;
JButton showtable;
JButton select;
JButton insert;
JButton update;
JButton delete;
JButton merge;
JButton call;
JButton create;
JButton drop;
JButton alter;
JButton database;
JButton table;   
JButton execute;
JLabel background;


    
query_app()
{    

try
{
    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbit?useTimezone=true&serverTimezone=UTC","root","");
}    
catch(Exception e)
{
    System.out.println(e);
}
    

p1=new JPanel();
p2=new JPanel();
l1=new JLabel("SQL QUERY");
tf1=new JTextField(40);
ta1=new JTextArea("");
ddl=new JButton("DDL");
dml=new JButton("DML");
dql=new JButton("DQL");
reset=new JButton("RESET");
showtable=new JButton("SHOW TABLE");
exit=new JButton("EXIT");
select=new JButton("SELECT");
insert=new JButton("INSERT");
update=new JButton("UPDATE");
delete=new JButton("DELETE");
merge=new JButton("MERGE");
call=new JButton("CALL");
create=new JButton("CREATE");
drop=new JButton("DROP");
alter=new JButton("ALTER");
database=new JButton("DATABASE");
table=new JButton("TABLE");
execute=new JButton("EXECUTE");
background=new JLabel(new ImageIcon("house.jpg"));


//setContentPane(new JLabel(new ImageIcon("house.jpg")));


//add(background);
//setLayout(new BorderLayout());
add(p1);
p1.add(l1);
p1.add(tf1);
p1.add(ddl);
p1.add(dml);
p1.add(dql);
p1.add(exit);
p1.add(reset);
p1.add(select);
p1.add(insert);
p1.add(update);
p1.add(delete);
//p1.add(merge);
//p1.add(call);
p1.add(create);
p1.add(drop);
p1.add(alter);
//p1.add(database);
p1.add(table);
p1.add(execute);
p1.add(showtable);
p1.add(ta1);


tf1.addKeyListener(this);
ta1.addKeyListener(this);
exit.addActionListener(this);
ddl.addActionListener(this);
dml.addActionListener(this);
reset.addActionListener(this);
dql.addActionListener(this);
select.addActionListener(this);
insert.addActionListener(this);
update.addActionListener(this);
delete.addActionListener(this);
merge.addActionListener(this);
call.addActionListener(this);
create.addActionListener(this);
drop.addActionListener(this);
alter.addActionListener(this);
database.addActionListener(this);
table.addActionListener(this);
execute.addActionListener(this);
showtable.addActionListener(this);

disableButtons();

setLocation(400,50);
setTitle("SQL QUERY APP");

setVisible(true);
setSize(400,500);
ta1.setEditable(false);
tf1.setForeground(Color.red);
tf1.setFont(new Font("courier new",Font.BOLD,15));
ta1.setForeground(Color.red);
ta1.setFont(new Font("courier new",Font.BOLD,15));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);   
//setLayout(new GridLayout(2,0));
}

public void disableButtons()
{
    select.setEnabled(false);
    insert.setEnabled(false);
    update.setEnabled(false);
    delete.setEnabled(false);
    merge.setEnabled(false);
    call.setEnabled(false);
    reset.setEnabled(false);
    create.setEnabled(false);
    drop.setEnabled(false);
    alter.setEnabled(false);
    database.setEnabled(false);
    table.setEnabled(false);
    execute.setEnabled(false);
    showtable.setEnabled(false);
    
    
}

public void actionPerformed(ActionEvent ae)
{
    if (ae.getSource()==exit)
    {
        dispose();
    }
    
    if (ae.getSource()==reset)
    {
        tf1.setText("");
        ta1.setText("");
        table.setEnabled(false);
        
        
    }
    
    if (ae.getSource()==dml)
    {
       select.setEnabled(false);
       insert.setEnabled(true);
       update.setEnabled(true);
       delete.setEnabled(true);
       merge.setEnabled(true);
       call.setEnabled(true);
       reset.setEnabled(false);
       create.setEnabled(false);
       drop.setEnabled(false);
       alter.setEnabled(false);
       database.setEnabled(false);
       table.setEnabled(false);
        execute.setEnabled(false); 
        tf1.setText("");
       ta1.setText("");
       showtable.setEnabled(false);
   }
    
    if (ae.getSource()==ddl)
    {
       select.setEnabled(false);
       insert.setEnabled(false);
       update.setEnabled(false);
       delete.setEnabled(false);
       merge.setEnabled(false);
       call.setEnabled(false);
       reset.setEnabled(false);
       create.setEnabled(true);
       drop.setEnabled(true);
       alter.setEnabled(true); 
       database.setEnabled(false);
       table.setEnabled(false);
       execute.setEnabled(false);  
       tf1.setText("");
       ta1.setText("");
       showtable.setEnabled(false);
    }
    
     if (ae.getSource()==dql)
    {
        
      select.setEnabled(true);  
       insert.setEnabled(false);
       update.setEnabled(false);
       delete.setEnabled(false);
       merge.setEnabled(false);
       call.setEnabled(false);
       reset.setEnabled(false);
       create.setEnabled(false);
       drop.setEnabled(false);
       alter.setEnabled(false);   
       database.setEnabled(false);
       table.setEnabled(false);
       execute.setEnabled(false);  
       tf1.setText("");
       ta1.setText("");
       showtable.setEnabled(false);
    }   
    
    if (ae.getSource()==create)
    {
        
       select.setEnabled(false);  
       insert.setEnabled(false);
       update.setEnabled(false);
       delete.setEnabled(false);
       merge.setEnabled(false);
       call.setEnabled(false);
       reset.setEnabled(false);
       create.setEnabled(false);
       drop.setEnabled(false);
       alter.setEnabled(false); 
       database.setEnabled(true);
       table.setEnabled(true);
       execute.setEnabled(false);
       showtable.setEnabled(false);       
        ta1.setText("");
    }
    
    if (ae.getSource()==database)
    {
        tf1.setText("CREATE DATABASE  database_name ; ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
        database.setEnabled(true);
        table.setEnabled(true);
        execute.setEnabled(true);  
        t="  DATABASE ";
        ta1.setText("");        
        showtable.setEnabled(false);
    }
    
    if (ae.getSource()==table)
    {
        tf1.setText("CREATE TABLE  table_name (column1 datatype , column2 datatype .....); ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(true);
         database.setEnabled(true);
        execute.setEnabled(true);  
        t="  TABLE ";
        showtable.setEnabled(false);
        ta1.setText("");
    }
    
     if (ae.getSource()==drop)
    {
        tf1.setText(" DROP TABLE  table_name ; ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(false);
         database.setEnabled(false);
        execute.setEnabled(true);
        showtable.setEnabled(false);
        ta1.setText("");    
    }
   
    if (ae.getSource()==alter)
    {
        tf1.setText(" ALTER TABLE  table_name  ADD column_name datatype ; ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(false);
         database.setEnabled(false);
        execute.setEnabled(true);
        ta1.setText("");    
        showtable.setEnabled(false);
    }
    
        if (ae.getSource()==select)
    {
        tf1.setText(" SELECT * FROM  table_name ; ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(false);
         database.setEnabled(false);
        execute.setEnabled(false);
        ta1.setText(""); 
        showtable.setEnabled(true);
    }  

 
   if (ae.getSource()== insert)
   {
       tf1.setText(" INSERT INTO  table_name (column1,column2,.....) VALUES (value1,value2,.....) ; ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(false);
         database.setEnabled(false);
        execute.setEnabled(true);
        ta1.setText(""); 
         showtable.setEnabled(false);
       
   }      

   if (ae.getSource()== update)
   {
       tf1.setText(" UPDATE  table_name SET column1=value1 , column2=value2 ,.... WHERE condition ; ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(false);
         database.setEnabled(false);
        execute.setEnabled(true);
        ta1.setText(""); 
       showtable.setEnabled(false);
       
   }        
   
    if (ae.getSource()== delete)
   {
       tf1.setText(" DELETE FROM  table_name  WHERE condition ; ");
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(false);
         database.setEnabled(false);
        execute.setEnabled(true);
        ta1.setText(""); 
       showtable.setEnabled(false);
       
   }        
    
    if (ae.getSource()== showtable)
   {
        
        select.setEnabled(false);
        insert.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
        merge.setEnabled(false);
        call.setEnabled(false);
        reset.setEnabled(true);
         create.setEnabled(false);
        drop.setEnabled(false);
        alter.setEnabled(false);
         table.setEnabled(false);
         database.setEnabled(false);
        execute.setEnabled(false);
        ta1.setText(""); 
       showtable.setEnabled(true);
       
       
   try
   {
    String qry=tf1.getText();
    st=con.createStatement();
    rs=st.executeQuery(qry);
    
    String data="";
    String s="";
    rsmd=rs.getMetaData();
    
    for( int i=1; i<=rsmd.getColumnCount();  i++)
    {
        data=data+rsmd.getColumnName(i) + "\t" ;
            
    }
     
 // ta1.setText(data);
    
    
  // rs.first(); 
   
   while(rs.next())
   {
       for (i=1;i<=rsmd.getColumnCount();i++)
          
    {
        
               s=s+rs.getString(i)  + "\t" ; //"\t"+rs.getString(2)+ "\t"+rs.getString(3) +"\n";
                 
                 
    }
    s=s+"\n";
    
   }   
        
    ta1.setText(data+"\n"+s);
    
   

   }
   catch(Exception e)
   {
       JOptionPane.showMessageDialog(getContentPane(),e.toString());
   }
  
       
       
       
       
   }      
   
   
   
   
   if ( ae.getSource()==execute  )
    {        
     try
    
     {
        String qry=tf1.getText();
        st=(Statement)con.createStatement();
        st.execute(qry);
        ta1.setText("query executed");
        disableButtons();
        reset.setEnabled(true);
        
        
     }   
     catch(Exception e)
     {
        JOptionPane.showMessageDialog(getContentPane(),e.toString());
     }
   
    } 



   
   
    
}



public void keyPressed(KeyEvent ae)
{
    
}

public void keyReleased(KeyEvent ae)
{
    
}

public void keyTyped(KeyEvent ae)
{
    
}






// main class started................................................................................
    
public static void main(String args[]) 
{
    
new myapp();    
}    



    
}