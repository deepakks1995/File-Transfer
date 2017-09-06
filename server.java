import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.InetAddress;
public class server extends JFrame implements Serializable,ActionListener
{
    ServerSocket ss = null;
    Socket s = null;
    prop p = null;
    FileInputStream fis =null;
    String destpath = null;
    ObjectOutputStream outstream = null;
    String srcpath = null;
    JLabel l1;
    JTextField t1;
    JButton b1;
    public server()
    {
        l1 = new JLabel("Enter the source_path");
        t1 = new JTextField(12);
        b1 = new JButton("Send_File");
        try
        {
            System.out.println("IP Address: " + InetAddress.getLocalHost());
        }
        catch(Exception e1)
        {
            ;
        }
        this.add(l1);
        this.add(t1);
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
        try
        {
            ss = new ServerSocket(4012);
            s = ss.accept();
            outstream = new ObjectOutputStream(s.getOutputStream());

            System.out.println("Server Started Successfully......");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        try
        {
            p = new prop();
            p.set_src(t1.getText());
            srcpath = p.get_src();
            File file = new File(srcpath);
            long len = (int) file.length();
            fis = new FileInputStream(file);
            byte [] filebytes = new byte[(int) len];
            fis.read(filebytes);
            fis.close();
            p.len = len;
            p.set_filedata(filebytes);
            outstream.writeObject(p);
            System.out.println("Done...Going to exit");
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        server sr = new server();

    }
}
