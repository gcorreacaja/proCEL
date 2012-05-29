package beans;

public class BeanClienteCorreoMasivo {

	String cod_cli,nom_cli,cona_cli,malia_cli,sex_cli,nom_tipo;

	public BeanClienteCorreoMasivo(String cod_cli, String nom_cli,
			String cona_cli, String malia_cli, String sex_cli, String nom_tipo) {
		super();
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.cona_cli = cona_cli;
		this.malia_cli = malia_cli;
		this.sex_cli = sex_cli;
		this.nom_tipo = nom_tipo;
	}

	public String getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(String cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getCona_cli() {
		return cona_cli;
	}

	public void setCona_cli(String cona_cli) {
		this.cona_cli = cona_cli;
	}

	public String getMalia_cli() {
		return malia_cli;
	}

	public void setMalia_cli(String malia_cli) {
		this.malia_cli = malia_cli;
	}

	public String getSex_cli() {
		return sex_cli;
	}

	public void setSex_cli(String sex_cli) {
		this.sex_cli = sex_cli;
	}

	public String getNom_tipo() {
		return nom_tipo;
	}

	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
	}
	
}
