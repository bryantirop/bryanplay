/* The main control system for bryanplay */

#include <stdint.h>
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

#include <vlc/vlc.h>
#include <jni.h>
#include "bryanplay_MediaPlayer.h"

libvlc_instance_t *vlc;
libvlc_media_list_t *playlist;
libvlc_media_list_player_t *playlist_player;
libvlc_media_player_t *playerObj;
libvlc_media_t *media, *current_media;

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_init(JNIEnv *env, jobject jobj)
{
	vlc = libvlc_new(0,NULL);
	playlist = libvlc_media_list_new(vlc);
	playlist_player = libvlc_media_list_player_new(vlc);
	playerObj = libvlc_media_player_new(vlc);
	
	libvlc_media_list_player_set_media_list(playlist_player,playlist);
	libvlc_media_list_player_set_media_player(playlist_player,playerObj);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_set_1video_1panel_1x(JNIEnv *env, jobject jobj, jlong drawable)
{	
	uint32_t panel = (uint32_t)drawable;
		
	libvlc_media_player_set_xwindow(playerObj,panel);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_set_1video_1panel_1hwnd(JNIEnv *env, jobject jobj,jlong hwnd)
{
	uint32_t hwn = (uint32_t)hwnd;
	uint32_t * panel;
	
	panel = &hwn;
	
	libvlc_media_player_set_hwnd(playerObj,(void *)panel);
}


JNIEXPORT jint JNICALL Java_bryanplay_MediaPlayer_add_1media(JNIEnv *env, jobject jobj,jstring filepath)
{
	const char *n_filepath = (*env)->GetStringUTFChars(env,filepath,NULL);
	if(n_filepath == NULL)
		return NULL;
	
	media = libvlc_media_new_path(vlc,n_filepath);
	libvlc_media_list_add_media(playlist,media);
	
	(*env)->ReleaseStringUTFChars(env,filepath,n_filepath);
	
	return 1;
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_play_1playlist(JNIEnv *env,jobject jobj)
{
	libvlc_media_list_player_play(playlist_player);
	
	while(1) sleep(200);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_refresh_1current_1media(JNIEnv *env,jobject jobj)
{
	current_media = libvlc_media_player_get_media(playerObj);	
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_player_1pause(JNIEnv *env,jobject jobj)
{
	libvlc_media_list_player_pause(playlist_player);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_play_1next(JNIEnv *env,jobject jobj)
{
	libvlc_media_list_player_next(playlist_player);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_play_1previous(JNIEnv *env,jobject jobj)
{
	libvlc_media_list_player_previous(playlist_player);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_player_1stop(JNIEnv *env,jobject jobj)
{
	libvlc_media_list_player_stop(playlist_player);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_play_1item(JNIEnv *env, jobject jobj, jint index)
{
	libvlc_media_list_player_play_item_at_index(playlist_player,index);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_set_1volume(JNIEnv *env, jobject jobj, jint volume)
{
	libvlc_audio_set_volume(playerObj,volume);
}
JNIEXPORT jint JNICALL Java_bryanplay_MediaPlayer_get_1volume(JNIEnv *env,jobject jobj)
{
	return (jint)libvlc_audio_get_volume(playerObj);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_set_1mute(JNIEnv *env, jobject jobj)
{
	libvlc_audio_toggle_mute(playerObj);
}
JNIEXPORT jboolean JNICALL Java_bryanplay_MediaPlayer_is_1media_1seekable(JNIEnv *env, jobject jobj)
{
	return (jboolean)libvlc_media_player_is_seekable(playerObj);
}
JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_seek_1time(JNIEnv *env, jobject jobj, jlong time)
{
	libvlc_media_player_set_time(playerObj,time);
}

JNIEXPORT jlong JNICALL Java_bryanplay_MediaPlayer_get_1media_1length(JNIEnv *env, jobject jobj)
{
	Java_bryanplay_MediaPlayer_refresh_1current_1media(env,jobj);
	current_media = libvlc_media_player_get_media(playerObj);
	libvlc_media_parse(media);
	
	return (jlong)libvlc_media_get_duration(media);
}

JNIEXPORT void JNICALL Java_bryanplay_MediaPlayer_set_1play_1mode(JNIEnv *env, jobject jobj, jshort mode)
{
	switch(mode)
	{
		case 0:
			libvlc_media_list_player_set_playback_mode(playlist_player,libvlc_playback_mode_default);
			break;
		case 1:
			libvlc_media_list_player_set_playback_mode(playlist_player,libvlc_playback_mode_loop);
			break;
		case 2:
			libvlc_media_list_player_set_playback_mode(playlist_player,libvlc_playback_mode_repeat);
			break;
		default:
		;	
	}

}

/* get metadata */

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1title(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char *title = libvlc_media_get_meta(current_media,libvlc_meta_Title);
	
	return (*env)->NewStringUTF(env,title);
	
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1artist(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	
	char * artist = libvlc_media_get_meta(current_media,libvlc_meta_Artist);
	
	return (*env)->NewStringUTF(env,artist);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1album(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * album = libvlc_media_get_meta(current_media,libvlc_meta_Album);
	
	return (*env)->NewStringUTF(env,album);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1track_1number(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * track = libvlc_media_get_meta(current_media,libvlc_meta_TrackNumber);
	
	return (*env)->NewStringUTF(env,track);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1artwork_1url(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * art = libvlc_media_get_meta(current_media,libvlc_meta_ArtworkURL);
	
	return (*env)->NewStringUTF(env,art);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1genre(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * genre = libvlc_media_get_meta(current_media,libvlc_meta_Genre);
	
	return (*env)->NewStringUTF(env,genre);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1date(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * date = libvlc_media_get_meta(current_media,libvlc_meta_Date);
	
	return (*env)->NewStringUTF(env,date);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1publisher(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * pub = libvlc_media_get_meta(current_media,libvlc_meta_Publisher);
	
	return (*env)->NewStringUTF(env,pub);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1copyright(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * copy = libvlc_media_get_meta(current_media,libvlc_meta_Copyright);
	
	return (*env)->NewStringUTF(env,copy);
}

JNIEXPORT jstring JNICALL Java_bryanplay_MediaPlayer_get_1current_1url(JNIEnv *env, jobject jobj)
{
	libvlc_media_parse_async(current_media);
	char * url = libvlc_media_get_meta(current_media,libvlc_meta_URL);
	
	return (*env)->NewStringUTF(env,url);
}


/* end of metadata */
