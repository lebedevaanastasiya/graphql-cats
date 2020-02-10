package ql.graph.cats.exceptions;

public class CatNotFoundException extends GraphQLException {
    private String invalidCatId;

    public CatNotFoundException(String errorMessage, String invalidCatId) {
        super(errorMessage);
        this.invalidCatId = invalidCatId;
        super.extensions.put("invalidCatId", invalidCatId);
        super.extensions.put("errorMessage", getMessage());
    }

    @Override
    public String getMessage() {
        return "Cat with ID " + invalidCatId + " could not be found";
    }
}
