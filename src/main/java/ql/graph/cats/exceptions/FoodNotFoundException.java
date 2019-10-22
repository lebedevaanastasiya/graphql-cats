package ql.graph.cats.exceptions;

public class FoodNotFoundException extends GraphQLException {
    private String invalidFoodId;

    public FoodNotFoundException(String errorMessage, String invalidFoodId) {
        super(errorMessage);
        this.invalidFoodId = invalidFoodId;
        super.extensions.put("invalidFoodId", invalidFoodId);
        super.extensions.put("errorMessage", getMessage());
    }

    @Override
    public String getMessage() {
        return "Food with ID " + invalidFoodId + " could not be found";
    }
}
