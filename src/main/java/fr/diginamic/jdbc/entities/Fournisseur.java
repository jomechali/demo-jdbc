package fr.diginamic.jdbc.entities;

/**
 * Represents a Fournisseur
 * (classe metier, element BO, que de la data, pas de logique)
 * @author Joseph
 *
 */
public class Fournisseur {

	private int Id;
	private String Nom;
	/**
	 * Constructor
	 * @param id
	 * @param nom
	 */
	public Fournisseur(int id, String nom) {
		super();
		Id = id;
		Nom = nom;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fournisseur [Id=");
		builder.append(Id);
		builder.append(", Nom=");
		builder.append(Nom);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * Getter
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * Getter
	 * @return the nom
	 */
	public String getNom() {
		return Nom;
	}
	/**
	 * Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		Nom = nom;
	}
	
	
}
