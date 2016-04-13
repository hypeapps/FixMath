package pl.hypeapp.fixmath;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;

public class SFXManager implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {


    private MediaPlayer timer;
    private MediaPlayer keyboardClose;
    private MediaPlayer keyboardError;
    private MediaPlayer keyboardClick;
    private MediaPlayer keyboardBackspace;
    private MediaPlayer sameLineFigureClick;
    private MediaPlayer newLineFigureClick;
    private MediaPlayer correctLine;
    private MediaPlayer newBackground;
    private boolean isMuteSFX;
    private Context context;

    public SFXManager(Context context, boolean isMuteSFX){
        this.context = context;
        this.isMuteSFX = isMuteSFX;
        if(!isMuteSFX){
            timer = MediaPlayer.create(context, R.raw.timer_sfx);
            timer.setLooping(true);

        }
    }



    public void TimerSfxPlay(boolean isPlay){
        if(!isMuteSFX) {
            if (isPlay) {
                timer.start();
            } else {
                timer.stop();
            }
        }

    }

    public void KeyboardClickPlay(boolean isPlay){
        if(!isMuteSFX) {
            keyboardClick = MediaPlayer.create(this.context, R.raw.keyboard_click_sfx);

            if (isPlay) {
                try {
                    keyboardClick.prepare();
                }catch(Exception e){}
                keyboardClick.setOnCompletionListener(this);
                keyboardClick.setOnPreparedListener(this);

            } else {
                if (keyboardClick.isPlaying()) {
                    keyboardClick.stop();
                }
            }
        }
    }

    public void KeybordClosePlay(){
        if(!isMuteSFX) {
            keyboardClose = MediaPlayer.create(context, R.raw.close_keyboard_sfx);
            keyboardClose.setOnCompletionListener(this);
            keyboardClose.setOnPreparedListener(this);
        }
    }

    public void KeyboardErrorPlay(){
        if(!isMuteSFX) {
            keyboardError = MediaPlayer.create(context, R.raw.error_keyboard_sfx);
            keyboardError.setOnCompletionListener(this);
            keyboardError.setOnPreparedListener(this);
        }
    }

    public void SameLineFigureClickPlay(){
        if(!isMuteSFX) {
            sameLineFigureClick = MediaPlayer.create(context, R.raw.same_line_figure_click_sfx);
                try {
                sameLineFigureClick.prepare();
            }catch(Exception e){
                    sameLineFigureClick.setOnCompletionListener(this);
                    sameLineFigureClick.setOnPreparedListener(this);
                }
            sameLineFigureClick.setOnCompletionListener(this);
            sameLineFigureClick.setOnPreparedListener(this);
        }
    }

    public void NewLineFigureClickPlay(){
        if(!isMuteSFX) {
            newLineFigureClick = MediaPlayer.create(context, R.raw.new_line_figure_click_sfx);
            try {
                newLineFigureClick.prepare();
            }catch(Exception e){
                newLineFigureClick.setOnCompletionListener(this);
                newLineFigureClick.setOnPreparedListener(this);
            }
            newLineFigureClick.setOnCompletionListener(this);
            newLineFigureClick.setOnPreparedListener(this);

        }
    }

    public void KeyboardBackspacePlay(){
        if(!isMuteSFX) {
            keyboardBackspace = MediaPlayer.create(context, R.raw.keyboard_backspace_sfx);

            try {
                keyboardBackspace.prepare();
            }catch(Exception e){
                keyboardBackspace.setOnCompletionListener(this);
                keyboardBackspace.setOnPreparedListener(this);
            }
            keyboardBackspace.setOnCompletionListener(this);
            keyboardBackspace.setOnPreparedListener(this);
        }
    }

    public void CorrectLinePlay(){
        if(!isMuteSFX) {
            correctLine = MediaPlayer.create(context, R.raw.correct_line_sfx);
            try {
                correctLine.prepare();
            }catch(Exception e){
                correctLine.setOnCompletionListener(this);
                correctLine.setOnPreparedListener(this);
            }
            correctLine.setOnCompletionListener(this);
            correctLine.setOnPreparedListener(this);

        }
    }

    public void NewBackgroundPlay(){
        if(!isMuteSFX) {
            newBackground = MediaPlayer.create(context, R.raw.new_background_sfx);
            newBackground.setOnCompletionListener(this);
            newBackground.setOnPreparedListener(this);

        }
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.reset();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
