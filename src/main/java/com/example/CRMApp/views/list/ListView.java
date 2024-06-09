package com.example.CRMApp.views.list;

import com.example.CRMApp.entity.Contact;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Contacts | CRMApp")
@Route(value = "")
@RouteAlias(value = "")
public class ListView extends VerticalLayout {

    Grid<Contact> contactGrid = new Grid<Contact>(Contact.class);
    TextField filterText = new TextField();

    public ListView() {

        addClassName("list-view");
        setSizeFull();
        
        configureGrid();
        add(getToolbar(), contactGrid);

    }

    private Component getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addContactButton = new Button("Add contact");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");

        return toolbar;
    }

    private void configureGrid() {
        contactGrid.addClassName("contact-grid");
        contactGrid.setSizeFull();
        contactGrid.setColumns("firstname", "lastname", "email");
        contactGrid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        contactGrid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        contactGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

}
