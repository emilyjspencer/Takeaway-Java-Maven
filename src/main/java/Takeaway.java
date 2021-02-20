public class Takeaway {

    private final Menu menu;

    public Takeaway(Menu menu) {
        this.menu = menu;
    }

    public Menu readMenu(Menu menu) {
        return menu.readMenu();
    }




}
