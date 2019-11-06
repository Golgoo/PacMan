package graphicmotor.entities.pacman;


public abstract class MouthBounds {
	public final static double numSegments = 150.0;
	private final static double upStart = numSegments * (double)( 1 / 4.0 );
	private final static double leftStart = numSegments * (double)( 2 / 4.0);
	private final static double downStart = numSegments * (double)( 3 / 4.0);
	private final static double rightStart = numSegments * (double)( 4 / 4.0);
	
	public static int getStart(Direction direction, double mouthSize) {
		double start = 0;
		switch (direction) {
		case HAUT:
			start = upStart;
			break;
		case DROITE:
			start = rightStart;
			break;
		case GAUCHE:
			start = leftStart;
			break;
		case BAS:
			start = downStart;
			break;
		default:
			break;
		}
		
		
		start += ( mouthSize / 2);
		return (int)start; 
	}
	
	
}
