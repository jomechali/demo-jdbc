package fr.diginamic.jdbc.entities;

/**
 * Represents a Fournisseur
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
	
	
}
