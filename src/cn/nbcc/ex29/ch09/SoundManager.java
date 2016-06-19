package cn.nbcc.ex29.ch09;


import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import javafx.embed.swt.FXCanvas;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundManager implements IStatusChangeListener {
	
	private Media bellRing;
	private MediaPlayer mediaPlayer;
	
	public SoundManager(Composite parent ,int style) {
		FXCanvas canvas = new FXCanvas(parent, SWT.NONE);
		canvas.setLayoutData(new GridData(0, 0));
	}

	@Override
	public void onStatusChange(MicrowaveOven oven) {
		
		if (oven.getStatus() == MicrowaveOvenStatus.FINISHED) {
			URL bellURL = SoundManager.class.getResource("asserts/bell.mp3");
			System.out.println(bellURL);
			try {
				bellRing = new Media(bellURL.toURI().toString());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			mediaPlayer = new MediaPlayer(bellRing);
			mediaPlayer.play();
		}

	}

}
