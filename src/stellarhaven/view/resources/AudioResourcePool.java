package stellarhaven.view.resources;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 * A {@link ResourcePool} subclass that stores and loads
 * {@link Clip} instances for playback as sound effects
 * or longform audio music
 * 
 * @author William
 */
public class AudioResourcePool extends ResourcePool<Clip> {

    private final HashMap<String, Clip> clips = new HashMap<>();

    @Override
    public Clip getItem(String path) {
        if (clips.containsKey(path)) {
            return clips.get(path);
        }
        Clip audio = null;
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResourceAsStream(path)))) {
            audio = AudioSystem.getClip();
            audio.open(ais);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException("Problem loading file: " + path, e);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Looks like a problem with the clips");
        } catch (NullPointerException e) {
            System.err.println("Resource not found: " + path);
            return null;
        }
        clips.put(path, audio);
        return audio;
    }
    
}
