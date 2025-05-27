package com.example.application.views.alignment;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.END;
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

        layout.add(new Button("Button 1"),
                new Button("Button 2"));

        var button3 = new Button("Button 3");

        var wrapper = new FlexLayout(button3);
        wrapper.setJustifyContentMode(END);
        layout.addAndExpand(wrapper);

        return layout;
    }

    private HorizontalLayout createLayoutThree() {
        var layout = createHorizontalLayout();

        layout.add(new Button("Button 1"),
                new Button("Button 2"));

        var button3 = new Button("Button 3");
        button3.addClassNames(Margin.Left.AUTO);
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

    private static HorizontalLayout createHorizontalLayout() {
        var layout = new HorizontalLayout();
        layout.addClassNames(
                LumoUtility.BorderColor.CONTRAST_50,
                LumoUtility.Border.ALL);
        layout.setPadding(true);
        layout.setWidthFull();
        return layout;
    }
}
