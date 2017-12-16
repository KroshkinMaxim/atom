package gameservice.model;

import gameservice.geometry.Point;

public final class GameField {
    private GameField() {}

    public static void generateMap(GameSession session) {
        for (int x = 0; x < 17; x++) {
            addStone(session, new Point(x, 0));
            addStone(session, new Point(x, 12));
        }
        for (int y = 1; y < 12; y++) {
            addStone(session, new Point(0, y));
            addStone(session, new Point(16, y));
        }
        for (int x = 2; x < 15; x++) {
            for (int y = 2; y < 11; y++) {
                if (x % 2 == 0 && y % 2 == 0) {
                    addStone(session, new Point(x, y));
                } else if (!((x == 2 || x == 14) && (y == 1 || y == 11))) {
                    addWood(session, new Point(x, y));
                }
            }
        }
        for (int i = 3; i < 10; i++) {
            addWood(session, new Point(15, i));
            addWood(session, new Point(1, i));
        }
        for (int i = 3; i < 14; i++) {
            addWood(session, new Point(i, 11));
            addWood(session, new Point(i, 1));
        }
    }

    private static void addWood(GameSession session, Point position) {
        session.addGameObject(new Wood(session, position));
    }

    private static void addStone(GameSession session, Point position) {
        session.addGameObject(new Wall(session, position));
    }

}
