package fr.eseo.e3.poo.projet.blox.modele;
import java.util.Objects;
public class Element {
	private Coordonnees coordonnees;
	private Couleur couleur;
	public Element(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
		this.couleur = Couleur.ROUGE;
	}
	public Element(int abscisse, int ordonnee) {
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = Couleur.ROUGE;
	}
	public Element(Coordonnees coordonnees, Couleur couleur) {
		this.coordonnees = coordonnees;
		this.couleur = couleur;
	}
	public Element(int abscisse, int ordonnee, Couleur couleur) {
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = couleur;
	}
	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCoordonnees(Coordonnees newCoordonnees) {
		this.coordonnees = newCoordonnees;
	}
	public void setCouleur(Couleur newCouleur) {
		this.couleur = newCouleur;
	}
	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	@Override
	public String toString() {
		return getCoordonnees().toString()+" - "+getCouleur()+"";
	}
	public void deplacerDe(int deltaX, int deltaY) {
		int ab = getCoordonnees().getAbscisse();
		int or = getCoordonnees().getOrdonnee();
		getCoordonnees().setAbscisse(ab+deltaX);
		getCoordonnees().setOrdonnee(or+deltaY);
		
	}
}