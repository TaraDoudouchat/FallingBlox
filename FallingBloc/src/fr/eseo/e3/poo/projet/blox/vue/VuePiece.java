package fr.eseo.e3.poo.projet.blox.vue;
import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
public class VuePiece {
	public static final double MULTIPLIER_TEINTE = 0.5;
	private final int taille;
	private final Piece piece;
	
	public VuePiece(Piece piece, int taille){
		this.piece = piece;
		this.taille = taille;
	}
	private Piece getPiece() {
		return this.piece;
	}
	public Color teinte(Color couleur){
		Color col = getPiece().getElements().get(0).getCouleur().getCouleurPourAffichage();
		
		int cR = (int) (col.getRed()   + (255 - col.getRed())   * MULTIPLIER_TEINTE);
		int cG = (int) (col.getGreen() + (255 - col.getGreen()) * MULTIPLIER_TEINTE);	
		int cB = (int) (col.getBlue()  + (255 - col.getBlue())  * MULTIPLIER_TEINTE);
		
		//c = c + (255 − c) ∗ MULTIPLIER_TEINTE
		
		Color c = new Color(cR, cG, cB);
		
		return c;
	}
	
	public void afficherPiece(Graphics2D g2D) {
		Color color = this.teinte(this.piece.getElements().get(0).getCouleur().getCouleurPourAffichage());
		
		int i = 1;
		int ref = this.piece.getElements().size();
		while (ref>i) {
			g2D.setColor(getPiece().getElements().get(i).getCouleur().getCouleurPourAffichage());
			g2D.fill3DRect(getPiece().getElements().get(i).getCoordonnees().getAbscisse()*taille,
					getPiece().getElements().get(i).getCoordonnees().getOrdonnee()*taille, 
					this.taille, 
					this.taille,
					true);
			i += 1;
		}
		
		g2D.setColor(color);//premier element
		int abscisse = getPiece().getElements().get(0).getCoordonnees().getAbscisse()*this.taille;
		int ordonnee = getPiece().getElements().get(0).getCoordonnees().getOrdonnee()*this.taille;
		g2D.fill3DRect(abscisse,ordonnee, this.taille, this.taille,true);
	}
//	public void afficherPiece(Graphics2D g2D) {
//		Color col = getPiece().getElements().get(0).getCouleur().getCouleurPourAffichage();
//		g2D.setColor(teinte(col));
//		g2D.fill3DRect(getPiece().getElements().get(0).getCoordonnees().getAbscisse(),
//				getPiece().getElements().get(0).getCoordonnees().getOrdonnee(), 
//				taille, 
//				taille, 
//				false);
//		g2D.setColor(col);//g2D.fill3DRect(int x, int y, int width, int height, false);
//		for(int i = 1; i < getPiece().getElements().size();i++) {
//			g2D.fill3DRect(getPiece().getElements().get(i).getCoordonnees().getAbscisse(),
//					getPiece().getElements().get(i).getCoordonnees().getOrdonnee(), 
//					taille, 
//					taille, 
//					false);
//		}
//	}
}