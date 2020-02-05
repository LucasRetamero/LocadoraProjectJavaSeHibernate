package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Filme.class)
public abstract class Filme_ {

	public static volatile SingularAttribute<Filme, String> genero;
	public static volatile SingularAttribute<Filme, Integer> id_filme;
	public static volatile SingularAttribute<Filme, String> titulo;

	public static final String GENERO = "genero";
	public static final String ID_FILME = "id_filme";
	public static final String TITULO = "titulo";

}

