package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Login.class)
public abstract class Login_ {

	public static volatile SingularAttribute<Login, String> senha;
	public static volatile SingularAttribute<Login, Integer> id;
	public static volatile SingularAttribute<Login, String> login;

	public static final String SENHA = "senha";
	public static final String ID = "id";
	public static final String LOGIN = "login";

}

