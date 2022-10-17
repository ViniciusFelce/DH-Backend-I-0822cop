package br.com.ecommerce.services.exceptions;

public class EntityWineNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public EntityWineNotFoundException (String msg){
        super(msg);
    }
}
