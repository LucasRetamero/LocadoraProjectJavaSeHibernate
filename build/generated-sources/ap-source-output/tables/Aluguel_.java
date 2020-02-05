package tables;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluguel.class)
public abstract class Aluguel_ {

	public static volatile SingularAttribute<Aluguel, Date> data_aluguel;
	public static volatile SingularAttribute<Aluguel, Integer> id_aluguel;
	public static volatile SingularAttribute<Aluguel, Integer> fk_id_cliente;
	public static volatile SingularAttribute<Aluguel, Date> data_devolucao;
	public static volatile SingularAttribute<Aluguel, Integer> fk_id_filme;

	public static final String DATA_ALUGUEL = "data_aluguel";
	public static final String ID_ALUGUEL = "id_aluguel";
	public static final String FK_ID_CLIENTE = "fk_id_cliente";
	public static final String DATA_DEVOLUCAO = "data_devolucao";
	public static final String FK_ID_FILME = "fk_id_filme";

}

