<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>Titan Project</title>

    </head>

    <style>

        body {
            margin: 0;
            background: #222;
            min-width: 960px;
        }

        rect {
            fill: none;
            pointer-events: all;
        }

        circle {
            fill: none;
            stroke-width: 2.5px;
        }

    </style>
    <body>

    <script src="<c:url value="//d3js.org/d3.v3.min.js"/>"></script>
    <script>

        var width = Math.max(960, innerWidth),
            height = Math.max(500, innerHeight);

        var i = 0;

        var svg = d3.select("body").append("svg")
            .attr("width", width)
            .attr("height", height);

        svg.append("rect")
            .attr("width", width)
            .attr("height", height)
            .on("ontouchstart" in document ? "touchmove" : "mousemove", particle);

        function particle() {
            var m = d3.mouse(this);

            svg.insert("circle", "rect")
                .attr("cx", m[0])
                .attr("cy", m[1])
                .attr("r", 1e-6)
                .style("stroke", d3.hsl((i = (i + 1) % 360), 1, .5))
                .style("stroke-opacity", 1)
                .transition()
                .duration(2000)
                .ease(Math.sqrt)
                .attr("r", 100)
                .style("stroke-opacity", 1e-6)
                .remove();

            d3.event.preventDefault();
        }

    </script>

        <h1> 1: Hello World! </h1>

        <form:form action="/upload?${_csrf.parameterName}=${_csrf.token}"  method="POST" enctype="multipart/form-data">
            <input type="file" name="testFile"/>
            <button type="submit" value="Upload">Log in!</button>
        </form:form>


    </body>
</html>
