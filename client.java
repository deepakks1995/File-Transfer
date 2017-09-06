import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class client extends JFrame implements Serializable,ActionListener
{
    Socket s = null;
    boolean connect=false;
    ObjectInputStream inputStream = null;
    prop p = null;
    FileOutputStream fos = null;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1;
    public client()
    {
        l1 = new JLabel("Name of File....");
        t1 = new JTextField(12);
        l2 = new JLabel("IP Address of Server....");
         t2 = new JTextField(12);
        b1 = new JButton("Download File........");
        this.add(l1);
        this.add(t1);
        this.add(l2);
        this.add(t2);
        this.add(b1);
        setLayout(new FlowLayout());
        b1.addActionListener(this);
        setTitle("Sending File......");
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(!connect)
        {
            try
            {
                s= new Socket(t2.getText(),4012);
                   inputStream = new ObjectInputStream(s.getInputStream());
                connect = true;
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        try
        {
            p = (prop) inputStream.readObject();
            String outfile = p.get_dest()+ t1.getText();
            if(!new File(p.get_dest()).exists())
            {
                new File(p.get_dest()).mkdirs();
            }
            fos = new FileOutputStream(outfile);
            fos.write(p.get_filedata());
            fos.flush();
            fos.close();
            System.out.println("File copied successfully......");
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String args[])
    {
        client cl = new client();
    }
}
