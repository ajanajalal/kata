package ma.carrefour.kata.domain.exceptions;

public class GroupPurchaseExpiredException extends RuntimeException {
    public GroupPurchaseExpiredException(String message) {
        super(message);
    }
}
