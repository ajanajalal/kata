package ma.carrefour.kata.domain.exceptions;

public class GroupPurchaseFullException extends RuntimeException {
    public GroupPurchaseFullException(String message) {
        super(message);
    }
}
