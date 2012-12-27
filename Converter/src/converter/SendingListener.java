
package converter;


public interface SendingListener 
{
    void sendingfinished(boolean success);
    void sendingbegin(String addr);
}