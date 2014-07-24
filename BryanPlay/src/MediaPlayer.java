
package bryanplay;

import java.util.LinkedList;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

enum PlayMode
{
    REPEAT,LOOP,SHUFFLE;
}

enum PlayerSelect
{
    BEGIN,INDEX,CURR_POS;
}


public class MediaPlayer {
    
    public LinkedList<String> playlist;
    
    static
    {
        System.loadLibrary("mediacenter");
    }
    
    private native void init();
    private native void set_video_panel_x(long panel);
    private native void set_video_panel_hwnd(long hwnd);
    private native int add_media(String file);
    private native void play_playlist();
    private native void refresh_current_media();
    private native void player_pause();
    private native void play_next();
    private native void play_previous();
    private native void player_stop();
    private native void play_item(int item);
    private native void set_volume(int vol);
    private native int get_volume();
    private native void set_mute();
    private native boolean is_media_seekable();
    private native void seek_time(long time);
    private native long get_media_length();
    private native long get_media_time();
    private native void set_play_mode(short mode);
    private native String get_current_title(String fname);
    private native String get_current_artist(String fname);
    private native String get_current_album(String fname);
    private native String get_current_track_number(String fname);
    private native String get_current_artwork_url(String fname);
    private native String get_current_genre(String fname);
    private native String get_current_date(String fname);
    private native String get_current_publisher(String fname);
    private native String get_current_copyright(String fname);
    private native String get_current_url(String fname);
    
    public MediaPlayer(Canvas canv)
    {
        this.init();
        this.playlist = new LinkedList<>();
        this.getHandle(canv);
        
    }    
    
    public void addFile(String filepath)
    {
        this.add_media(filepath);
        this.playlist.add(filepath);
    }
    
    public void setVideoPanel(long panel)
    {
        this.set_video_panel_x(panel);
    }
    
    public void setVideoHWND(long hwnd)
    {
        this.set_video_panel_hwnd(hwnd);
    }
    
    public void playList()
    {
        this.play_playlist();
    }
    
    public void playFile(int index)
    {
        this.play_item(index);
    }
    
    public void playNext()
    {
        this.play_next();
    }
    
    public void playPrevious()
    {
        this.play_previous();
    }
    
    public void pause()
    {
        this.player_pause();
    }
    
    public void stop()
    {
        this.player_stop();
    }
    
    public void replay()
    {
        this.stop();
        this.playList();
    }
    
    public void setVolume(int volume)
    {
        this.set_volume(volume);
    }
    
    public int getVolume()
    {
        return this.get_volume();
    }
    
    public void mute()
    {
        this.set_mute();
    }
    public long getMediaTime()
    {
        return this.get_media_time();
    }
    public long getMediaLength()
    {
        return this.get_media_length();
    }
    
    public boolean mediaSeekable()
    {
        return this.is_media_seekable();
    }
    
    public void mediaSeek(long time)
    {
        this.seek_time(time);
    }
    public void refreshMedia()
    {
        this.refresh_current_media();
    }
        
    public void setPlayMode(short mode)
    {
        this.set_play_mode(mode);
    }
        
    public Meta getMeta(String fname)
    {
        Meta meta = new Meta();
        meta.Title = this.get_current_title(fname);
        meta.Album = this.get_current_album(fname);
        meta.Artist = this.get_current_artist(fname);
        meta.TrackNum = this.get_current_track_number(fname);
        meta.Genre = this.get_current_genre(fname);
        meta.Artwork = this.get_current_artwork_url(fname);
        meta.Copyright = this.get_current_copyright(fname);
        meta.Publisher = this.get_current_publisher(fname);
        meta.URL = this.get_current_url(fname);
        meta.Date = this.get_current_date(fname);
        
        return meta;
        
    }
    
    
    private void getHandle(Canvas c) 
    {
          if(java.lang.System.getProperty("os.name").contains("Windows")) 
          {
            try {
                   Class cl = Class.forName("sun.awt.windows.WComponentPeer");
                   java.lang.reflect.Field f = cl.getDeclaredField("hwnd");
                   f.setAccessible(true);
                   long handle = f.getLong(c.getPeer());
                   this.setVideoHWND(handle);
                }
                catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) 
                {
                   System.err.println(ex.getMessage());
                }
          }
          else
          {
             try 
             {
                Class cl = Class.forName("sun.awt.X11ComponentPeer");
                java.lang.reflect.Method m = cl.getMethod("getContentWindow", (Class[]) null);
                Object obj = m.invoke(c.getPeer());
                long handle = Long.parseLong(obj.toString());
                this.setVideoPanel(handle);
             }
             catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) 
             {
                System.err.println(ex.getMessage());
             }
           
          }
     }
    
          
}


