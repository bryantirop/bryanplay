#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <stdint.h>

#include <vlc/vlc.h>



libvlc_instance_t * media_inst;
libvlc_media_player_t *mediaplay = NULL;
libvlc_media_t *media_handle;

int current_media_duration;

int * hwnd_handle;


static bool media_play();


bool media_file_play(const char * filename,int * panel)
{
	
	hwnd_handle = panel;
	
	media_inst = libvlc_new(0,NULL);
	
	if(mediaplay != NULL)
	{
		libvlc_media_player_stop(mediaplay);
	}
	
	media_handle = libvlc_media_new_path(media_inst,filename);
	mediaplay = libvlc_media_player_new_from_media(media_handle);
	
		
	return media_play();
}

static bool media_file_dj_play(const char *filename,int * panel, float start,uint8_t end)
{
	hwnd_handle = panel;
	
	media_inst = libvlc_new(0,NULL);
	
	media_handle = libvlc_media_new_path(media_inst,filename);
	mediaplay = libvlc_media_player_new_from_media(media_handle);
	
	
}

bool media_url_play(const char *url,int * panel)
{
	
	hwnd_handle = panel;
	
	media_inst = libvlc_new(0,NULL);
	
	media_handle = libvlc_media_new_location(media_inst,url);
	mediaplay = libvlc_media_player_new_from_media(media_handle);
	
	
	
		
	return media_play();
}

static bool media_play()
{
	int64_t ms_media_length;
	int s_length;
	
	
	libvlc_media_parse(media_handle);
    s_length = (int)(ceil(libvlc_media_get_duration(media_handle)/1000));
	
	current_media_duration = s_length;
	
	if(s_length == -1)
		return false;
	
	libvlc_media_player_set_hwnd(mediaplay,(void *)hwnd_handle);
	
	libvlc_media_player_play(mediaplay);
		
	
	sleep(s_length);
	
	libvlc_media_player_stop(mediaplay);
	libvlc_media_release(media_handle);
	
	return true;
}

void media_set_time(uint32_t sec)
{
	if(mediaplay != NULL)
		libvlc_media_player_set_time(mediaplay,sec);
	else ;
}
int64_t media_get_time()
{
	if(mediaplay != NULL)
	{
		return libvlc_media_player_get_time(mediaplay);
	}
	
	return -1;	
}

void media_pause_resume()
{
	if(mediaplay != NULL)
		libvlc_media_player_pause(mediaplay);
	else ;
}

void media_stop()
{
	if(mediaplay != NULL)
		libvlc_media_player_stop(mediaplay);
	else;
}

bool media_replay()
{
	if(mediaplay != NULL)
	{
		libvlc_media_player_stop(mediaplay);	
		return media_play();
	}
	return false;
}

bool media_set_audio_volume(uint8_t volume)
{
	if(mediaplay != NULL)
	{
		int_fast8_t res = libvlc_audio_set_volume(mediaplay,volume);
	
		return res == 0 ? true : false;
	}
	return false;	
}
uint8_t media_get_audio_volume()
{
	if(mediaplay != NULL)
		return libvlc_audio_get_volume(mediaplay);
	return 0;
}

void media_mute_unmute()
{
	if(mediaplay != NULL)
	{
		libvlc_audio_toggle_mute(mediaplay);
	}
	else ;
}

void set_vedio_panel(int * panel)
{
	if(mediaplay != NULL)
		libvlc_media_player_set_hwnd(mediaplay,(void *)panel);
	else ;
}

bool can_play()
{
	if(mediaplay != NULL)
		return libvlc_media_player_will_play(mediaplay);
	return false;
}

bool is_media_seekable()
{
	if(mediaplay != NULL)
		return libvlc_media_player_is_seekable(mediaplay);
	else return false;
}

void seek_media(float fpos)
{
	if(mediaplay != NULL)
		libvlc_media_player_set_position(mediaplay,fpos);
	else ;
}

void* get_vedio_panel()
{
	return libvlc_media_player_get_hwnd(mediaplay);
}

int get_media_duration()
{
	if(mediaplay != NULL)
	{
		libvlc_media_parse(media_handle);
		return libvlc_media_get_duration(media_handle);
	}
	return -1;
}

/*MEDIA_META* KMCALL get_media_meta()
{
	MEDIA_META *meta_struct;
	
	libvlc_media_parse(media_handle);
	
	char *meta = libvlc_media_get_meta(media_handle,libvlc_meta_Title);
	meta_struct->Title = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Artist);
	meta_struct->Artist = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Genre);
	meta_struct->Genre = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Copyright);
	meta_struct->Copyright = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Album);
	meta_struct->Album = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_TrackNumber);
	meta_struct->TrackNumber = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Description);
	meta_struct->Description = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Rating);
	meta_struct->Rating = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Date);
	meta_struct->Date = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Setting);
	meta_struct->Setting = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_URL);
	meta_struct->URL = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Language);
	meta_struct->Language = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_NowPlaying);
	meta_struct->NowPlaying = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_Publisher);
	meta_struct->Publisher = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_EncodedBy);
	meta_struct->EncodedBy = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_ArtworkURL);
	meta_struct->ArtworkURL = meta;
	meta = libvlc_media_get_meta(media_handle,libvlc_meta_TrackID);
	meta_struct->TrackID = meta;
	
	return meta_struct;
}

bool KMCALL set_media_meta(MEDIA_META* meta_struct)
{
	bool res = true,tmp;
	libvlc_media_set_meta(media_handle,libvlc_meta_Title,meta_struct->Title);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Artist,meta_struct->Artist);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Genre,meta_struct->Genre);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Copyright,meta_struct->Copyright);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Album,meta_struct->Album);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_TrackNumber,meta_struct->TrackNumber);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Description,meta_struct->Description);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Rating,meta_struct->Rating);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Date,meta_struct->Date);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Setting,meta_struct->Setting);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_URL,meta_struct->URL);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Language,meta_struct->Language);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_NowPlaying,meta_struct->NowPlaying);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_Publisher,meta_struct->Publisher);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_EncodedBy,meta_struct->EncodedBy);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_ArtworkURL,meta_struct->ArtworkURL);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	libvlc_media_set_meta(media_handle,libvlc_meta_TrackID,meta_struct->TrackID);
	tmp = libvlc_media_save_meta(media_handle);
	res = (res & tmp);
	
	return res;	
}*/




int main(int argc, char * argv[])
{
	
	media_file_play(argv[1],NULL);

	return 0;
}














