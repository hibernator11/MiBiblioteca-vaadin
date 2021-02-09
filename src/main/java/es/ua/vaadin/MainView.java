package es.ua.vaadin;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route(value="miBiblioteca")
@PWA(name = "My Biblioteca", shortName = "My Biblioteca")
public class MainView extends VerticalLayout {
	
	private BookRepository bookRepository;
	final Grid<Book> grid;
	final TextField filter;
	private final Button addNewBtn;

    public MainView() {
    	
    	bookRepository = new BookRepository();
    	
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));
        add(button);
        
        this.grid = new Grid<>(Book.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New book", VaadinIcon.PLUS.create());
        
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);
        
        grid.setHeight("200px");
        grid.setColumns("author", "title", "publication");
        //grid.getColumnByKey("title").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by title");

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> bookList(e.getValue()));
        
        bookList(null);
    }
    
    void bookList(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(bookRepository.findAll());
        } else {
            grid.setItems(bookRepository.findByTitle(filterText));
        }
    }
}
