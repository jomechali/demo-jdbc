package fr.diginamic.jdbc.entities;

/**
 * Represents a Fournisseur
 * (classe metier, element BO, que de la data, pas de logique)
 * @author Joseph
 *
 */
public class Fournisseur {

	private int id;
	private String nom;
	/**
	 * Constructor
	 * @param id
	 * @param nom
	 */
	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fournisseur [Id=");
		builder.append(id);
		builder.append(", Nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
