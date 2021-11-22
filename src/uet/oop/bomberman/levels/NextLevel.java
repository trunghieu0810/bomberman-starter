package uet.oop.bomberman.levels;

import static uet.oop.bomberman.BombermanGame._level;
import static uet.oop.bomberman.BombermanGame.authorView;
import static uet.oop.bomberman.entities.block.Portal.isPortal;

import javafx.scene.image.Image;

public class NextLevel {
    public static boolean wait;
    public static long waitingTime;

    public static void waitToLevelUp() {
        if (wait) {
            Image waitToNext = new Image("images/levelUp.png");
            authorView.setImage(waitToNext);
            long now = System.currentTimeMillis();
            if (now - waitingTime > 3000) {
                switch (_level) {
                    case 1:
                        isPortal = false;
                        new Level2();
                        break;
                    case 2:
                        new Level3();
                        break;
                    case 3:
                        new Level1();
                }
                wait = false;
            }
        }
    }
}
