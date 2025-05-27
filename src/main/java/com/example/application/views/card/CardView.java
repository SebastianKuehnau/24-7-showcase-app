package com.example.application.views.card;

import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Card Component (Preview)")
@Menu(order = 3, icon = LineAwesomeIconUrl.PHOTO_VIDEO_SOLID)
@Route(value = "card")
public class CardView extends VerticalLayout {

    public CardView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(createUserProfileCard(
                "images/card-image.png",
                "Maija Lumo",
                "Senior Software Developer",
                "Frontend Team",
                "Turku HQ",
                "maija@webpage.fi"
        ));
    }

    private Card createUserProfileCard(String imagePath, String name, String jobTitle,
                                       String team, String office, String email) {
        Card card = new Card();

        // User Image
        card.setMedia(createImage(imagePath, name));

        // User Name
        card.setTitle(new H2(name));

        // User Title;
        card.setSubtitle(new Div(jobTitle));

        // Badges
        card.add(
                new HorizontalLayout(
                        createOfficeBadge(office),
                        createTeamBadge(team)
                ));

        // User Email
        Div emailLinkContainer = createEmailIcon(email);
        card.addToFooter(emailLinkContainer);

        card.addClassNames(LumoUtility.TextAlignment.CENTER);
        card.addThemeVariants(
                CardVariant.LUMO_ELEVATED,
                CardVariant.LUMO_OUTLINED
        );

        return card;
    }

    private static Div createEmailIcon(String email) {
        Icon emailIcon = VaadinIcon.ENVELOPE.create();
        emailIcon.addClassNames(LumoUtility.TextColor.SECONDARY);

        var emailIconLink = new Anchor("mailto:" + email, emailIcon);
        var emailLink = new Anchor("mailto:" + email, email);
        emailLink.addClassNames(LumoUtility.TextColor.SECONDARY);

        Div emailLinkContainer = new Div(emailIconLink, emailLink);
        emailLinkContainer.setWidthFull();
        emailLinkContainer.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.EVENLY
        );
        return emailLinkContainer;
    }

    private static Image createImage(String imagePath, String name) {
        Image userImage = new Image(imagePath, name);
        userImage.setWidth("150px");
        userImage.setHeight("150px");
        userImage.getStyle().set("border-radius", "50%"); // round image
        return userImage;
    }

    private Div createTeamBadge(String team) {
        var badge = new Div(team);
        badge.getElement().getThemeList().add("badge warning");
        return badge;
    }

    private Div createOfficeBadge(String office) {
        var officeBadge = new Div(office);
        officeBadge.getElement().getThemeList().add("badge success");
        return officeBadge;
    }
}