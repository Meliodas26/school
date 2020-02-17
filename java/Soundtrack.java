import java.io.File;
import javax.sound.sampled.*;

public class Soundtrack{

	private Clip espera, bifrost, game, fin;
	private String file;
	private AudioInputStream audioInputStream;
	private AudioFormat format;
	private DataLine.Info  info;

	public Soundtrack(){
		try{
			file = "../Sounds/espera.wav";
			audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
			format = audioInputStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			espera = (Clip)AudioSystem.getLine(info);
			espera.open(audioInputStream);
			espera.stop();

			file = "../Sounds/bifrost.wav";
			audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
			format = audioInputStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			bifrost = (Clip)AudioSystem.getLine(info);
			bifrost.open(audioInputStream);
			bifrost.stop();	

			file = "../Sounds/ironman.wav";
			audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
			format = audioInputStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			game = (Clip)AudioSystem.getLine(info);
			game.open(audioInputStream);
			game.stop();

			file = "../Sounds/fin.wav";
			audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
			format = audioInputStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			fin = (Clip)AudioSystem.getLine(info);
			fin.open(audioInputStream);
			fin.stop();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void onEspera(){
		espera.start();
	}

	public void offEspera(){
		espera.stop();
	}

	public void onBifrost(){
		bifrost.start();
	}
	public void offBifrost(){
		bifrost.stop();
	}

	public void onGame(){
		game.start();
	}
	public void offGame(){
		game.stop();
	}

	public void onFin(){
		game.stop();
		fin.start();
	}
	public void offFin(){
		fin.stop();
	}
}