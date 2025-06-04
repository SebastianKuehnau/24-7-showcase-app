package com.example.application.views.alignment;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.*;
import static com.vaadin.flow.theme.lumo.LumoUtility.*;

@PageTitle("Aligning Individual Items on Horizontal Layout")
@Menu(order = 4, icon = LineAwesomeIconUrl.ALIGN_JUSTIFY_SOLID)
@Route(value = "alignment")
@RouteAlias("")
public class AlignmentView extends VerticalLayout {

    public AlignmentView() {
        add(new H4("Add Items to Horizontal Layout"));
        add(createLayoutOne());

        add(new H4("Use Wrapper to align item"));
        add(createLayoutTwo());

        add(new H4("Use Auto Margin to align item"));
        add(createLayoutThree());

        add(new H4("Use new Vaadin API to align item"));
        add(createLayoutFour());

        add(new H4("Example Use case"));
        add(createLayoutFive());
    }

    private HorizontalLayout createLayoutOne() {
        var layout = createHorizontalLayout();

        layout.add(new Button("Button 1"),
                new Button("Button 2"),
                new Button("Button 3"));

        return layout;
    }

    private HorizontalLayout createLayoutTwo() {
        var layout = createHorizontalLayout();

        layout.add(new Button("Button 1"));

        var button2 = new Button("Button 2");
        var wrapper1 = new FlexLayout(button2);
        wrapper1.setJustifyContentMode(CENTER);
        layout.addAndExpand(wrapper1);

        var button3 = new Button("Button 3");
        var wrapper2 = new FlexLayout(button3);
        wrapper2.setJustifyContentMode(END);
        layout.add(wrapper2);

        return layout;
    }

    private HorizontalLayout createLayoutThree() {
        var layout = createHorizontalLayout();

        layout.add(new Button("Button 1"));

        var button2 = new Button("Button 2");
        button2.addClassNames(Margin.Horizontal.AUTO);
        layout.add(button2);

        var button3 = new Button("Button 3");
        layout.add(button3);

        return layout;
    }

    private HorizontalLayout createLayoutFour() {
        var layout = createHorizontalLayout();

        layout.add(new Button("Button 1"),
                new Button("Button 2"));

        var button3 = new Button("Button 3");
        layout.addToEnd(button3);

        return layout;
    }


    private HorizontalLayout createLayoutFive() {
        var layout = createHorizontalLayout();

        var vaadinIcon = createAppIcon();
        var headline = createHeadline();
        var closeButton = createCloseButton();

        layout.addToStart(vaadinIcon);
        layout.addToMiddle(headline);
        layout.addToEnd(closeButton);

        return layout;
    }

    private static Component createCloseButton() {
        return VaadinIcon.CLOSE_SMALL.create();
    }

    private static Component createAppIcon() {
        return createIconButton(VaadinIcon.VAADIN_H.create());
    }

    private static Component createHeadline() {
        return new H4("Text in Headline");
    }

    private static Button createIconButton(Icon icon) {
        var menuButton = new Button(icon);
        menuButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        menuButton.addClassNames(IconSize.LARGE, TextColor.SECONDARY);
        return menuButton;
    }

    private static HorizontalLayout createHorizontalLayout() {
        var layout = new HorizontalLayout();
        layout.addClassNames(
                LumoUtility.BorderColor.CONTRAST_50,
                LumoUtility.Border.ALL,
                AlignItems.CENTER);
        layout.setPadding(true);
        layout.setWidthFull();
        return layout;
    }
}
