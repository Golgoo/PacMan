package Sound;

public interface Sound {




    /**
     * Plays the sound once, from beginning to end.
     *
     */
    public void play();

    /**
     * Plays the sound continuously; when the end is reached it starts over.
     */
    public void loop();

    /**
     * Stops the sound if it is currently playing (or looping).
     */
    public void stop();
}