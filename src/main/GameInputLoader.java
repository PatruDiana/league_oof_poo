package main;

import java.util.ArrayList;
import fileio.FileSystem;
import map.Map;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }
    public void load() {
        int nr_rows = 0, nr_cols = 0;
        int nr_heros = 0, nr_rounds = 0;
        ArrayList<String> playersinfo = new ArrayList<>();
        ArrayList<Integer> coordplayers = new ArrayList<>();
        ArrayList<Character> arraymoves = new ArrayList<>();
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            nr_rows = fs.nextInt();
            nr_cols = fs.nextInt();
            Map map = Map.getInstance(nr_rows, nr_cols);

            for (int i = 0 ; i < nr_rows; i++) {
                map.setLocation(fs.nextWord(), i);
            }
            nr_heros = fs.nextInt();
//            System.out.println(nr_heros);
            for (int i = 0; i < nr_heros; i++) {
//                String a = fs.nextWord();
//                int b = fs.nextInt();
//                int c = fs.nextInt();
//                System.out.println(a);
//                System.out.println(b);
//                System.out.println(c);
                playersinfo.add(fs.nextWord());
                coordplayers.add(fs.nextInt());
                coordplayers.add(fs.nextInt());
            }
            nr_rounds = fs.nextInt();
            for (int i = 0; i < nr_rounds; i++) {
                String line_moves = fs.nextWord();
                char[] moves = line_moves.toCharArray();
                for (char c : moves) {
                    arraymoves.add(c);
                }
//                System.out.println(line_moves);
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Map map = Map.getInstance();
        map.display();
//        System.out.println(playersinfo.toString());
        System.out.println(coordplayers.toString());
//        System.out.println(arraymoves.toString());
         Game game = Game.getInstance(playersinfo,coordplayers, arraymoves, nr_rounds);
    }

}
