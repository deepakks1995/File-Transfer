import java.io.*;
public class prop implements Serializable
{
    private static final long serialVersionUID = 1L;
    String source;
    String dest = "D:/downloads/";
    String filename;
    byte []filedata;
    long len;
    BufferedReader br=null;
    String ip;

    public prop()
    {

    }
    void set_ip(String str)
    {
        ip = str;
    }
    String get_ip()
    {
        return ip;
    }
    String get_src()
    {
        return source;
    }
    String get_dest()
    {
        return dest;
    }

    void set_src(String src)
    {
        try
        {
            source = src;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


    String get_fname()
    {
        return filename;
    }

    void set_fname(String fname)
    {
        try
        {
            filename=fname;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    byte[] get_filedata()
    {
        return filedata;
    }

    void set_filedata(byte[] filedata)
    {
        this.filedata=filedata;
    }
}
