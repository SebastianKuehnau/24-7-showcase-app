package com.example.application.views.gantt;


import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.GanttSeries;
import com.vaadin.flow.component.charts.model.GanttSeriesItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;


@PageTitle("New in Vaadin 24.7")
@Menu(icon = LineAwesomeIconUrl.CHART_LINE_SOLID)
@Route("gantt")
@RouteAlias("")
public class GanttView extends VerticalLayout {

    private final LocalDate today = LocalDate.now();

    public GanttView() {

        Chart chart = new Chart(ChartType.GANTT);

        GanttSeries series = new GanttSeries();
        series.add(createTask("Design", 0, 1));
        series.add(createTask("Development", 1, 4));
        series.add(createTask("Testing", 4, 5));

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Website Launch Plan");
        conf.setSeries(series);

        add(chart);
    }

    private GanttSeriesItem createTask(String name, int start, int end) {
        GanttSeriesItem item = new GanttSeriesItem();

        item.setName(name);

        var startDate = today.plusDays(start);
        var endDate = today.plusDays(end);

        item.setStart(startDate.atStartOfDay().toInstant(ZoneOffset.UTC));
        item.setEnd(endDate.atStartOfDay().toInstant(ZoneOffset.UTC));
        item.setId(UUID.randomUUID().toString());

        return item;
    }

}
