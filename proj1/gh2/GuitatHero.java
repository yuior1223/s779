package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitatHero
{
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args)
    {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                double concert = 440.0 * Math.pow(2, (i-24) / 12.0);
                GuitarString stringPlay = new GuitarString(concert);
                stringPlay.pluck();
                double sample = stringPlay.sample();
                StdAudio.play(sample);
                stringPlay.tic();

            }



            /* play the sample on standard audio */


        }
    }
}
