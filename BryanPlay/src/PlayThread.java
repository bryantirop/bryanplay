package bryanplay;


public class PlayThread implements Runnable
{
    Thread t;
    MediaPlayer mp;
    Start frame;
    javax.swing.JLabel prog = null;
    PlayerSelect ps = null;
    Integer index = null;
    
    PlayThread(MediaPlayer mp, Start frame,PlayerSelect ps, Integer index, javax.swing.JLabel label)
    {
        this.mp = mp;
        this.frame = frame;
        this.ps = ps;
        this.prog = label;
        this.index = index;
        
        t = new Thread(this,"Player");
        t.start();
    }
        
    
    @Override
    public void run()
    {
       if(ps == PlayerSelect.BEGIN)
       {
           mp.playList();
       }
       else if(ps == PlayerSelect.INDEX)
       {
           mp.playFile(index);
       }
       else if(ps == PlayerSelect.CURR_POS)
       {
           prog.setText(""+mp.getMediaTime());
       }
        
        
    }
}
