
package converter;

import converter.sendmail.SendEmail;

public class Sender
{
    public void sending(SendingListener jf, String mes, String addr) 
    {
        
        Thread st = new Thread(new ThreadForSend(jf, mes, addr));
        st.start();
    }
}

class ThreadForSend implements Runnable 
{
    private String mes; 
    private SendingListener jf;
    private String addr;
    public ThreadForSend(SendingListener jf, String mes, String addr) 
    {
        this.mes = mes;
        this.jf = jf;
        this.addr = addr;
    }

    @Override
    public void run() 
    {
        jf.sendingfinished(SendEmail.send(mes, addr));
    }
}