package gmartineza.tetris;

public class Tetris {
    private Board board;
    private PieceBase currentPiece;
    private Clock clock;
    private int count = 0;
    private static int status = 0;
    private String mensajeStatus = "";
    int row = 0;
    int randomCol;
    int col = 0;

    public Tetris(Board board, Clock clock) {
        this.clock = clock;
        this.board = board;
    }

    public static void setStatus(int value){
        status = value;
    }

    public PieceBase getCurrentPiece(){
        return currentPiece;
    }

    public void setCurrentPiece(PieceBase value){
        currentPiece = value;
    }

    // Iniciar el juego
    public void start() {
    status = 1;

    // Insertar una nueva pieza aleatoria en la parte superior
    setCurrentPiece(board.spawnNewPiece());

    // Bajar la pieza hasta llegar al final
    tick();

    count = board.lineCount();

    // Comprobar si el juego ha terminado ( Si no se puede insertar una nueva pieza
    // o hacer 5 tetris)
    if (!board.getCanPlacePiece(currentPiece, 0, 0)) {
        status = 2; // El juego ha terminado
    } else if (count == 5) {
        status = 3;
    }
}


    public String state() {
        if (status == 0) {
            mensajeStatus = "No iniciado";
        } else if (status == 1) {
            mensajeStatus = "Jugando";
        } else if (status == 2) {
            mensajeStatus = "Game Over";
        } else
            mensajeStatus = "You are Winner";

        return mensajeStatus;
    }

    public void tick() {
      
            if (getCurrentPiece() != null){
                board.movePiece(getCurrentPiece(), row);
            }
            board.lineCount();
            clock.tick();
        
    }

    public void rotateLeft() {
        currentPiece.rotateLeft();
    }

    public void rotateRight() {
        currentPiece.rotateRight();
    }
}