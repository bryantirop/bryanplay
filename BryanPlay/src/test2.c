#include <vlc/vlc.h>
#include <stdlib.h>

libvlc_instance_t * vlc;
libvlc_media_list_t *ml;
libvlc_media_list_player_t *mlp;
libvlc_media_player_t *mp;
libvlc_media_t *md1, *md2;
 

void init()
{
	vlc = libvlc_new(0,NULL);
	ml = libvlc_media_list_new(vlc);
	mlp = libvlc_media_list_player_new(vlc);
	mp = libvlc_media_player_new(vlc);
	
	libvlc_media_list_player_set_media_list(mlp, ml);
    
    libvlc_media_list_player_set_media_player(mlp, mp);
}

void add_media(char *filepath)
{
	md1 = libvlc_media_new_path(vlc, filepath);
    
    libvlc_media_list_add_media(ml, md1);
    
    libvlc_media_release(md1);
    libvlc_media_release(md2);
 
     
    
      
    
}

void play()
{
	/* Play */
    libvlc_media_list_player_play(mlp);
 
    /* Let it play forever */
    while(1) sleep(300);
}

int main(int argc, char *argv[])
{
 	
 	init();
   
    
     add_media(argv[1]);
    
  
    play();
 }
 
