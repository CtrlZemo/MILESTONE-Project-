import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Inputter inputter = new Inputter();
        Validator validator = new Validator();
        Displayer displayer = new Displayer();
        RemoveProduct remover = new RemoveProduct();
        UpdateProduct updater = new UpdateProduct();
        SearchProduct searcher = new SearchProduct();
        FilterProducts filter = new FilterProducts();

        MenuHandler menuHandler = new MenuHandler(validator, inputter, displayer, remover, updater, searcher, filter);
        menuHandler.handleMenu(productList);
    }
}
