public class NoItemSelectedException extends RuntimeException {

    public NoItemSelectedException(String no_items_selected) {
        super(no_items_selected);
    }
}
