<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <div class="post">
            <jsp:include page="partials/_article.jsp" />
        </div>

        <form id="translate" action="/icms-war/article/<c:out value="${requestScope['article'].permalink}" escapeXml="true"/>">
            <select id="translate_to" name="translate_to">
                <option value="en">English</option>
                <option value="es">Spanish</option>
                <option value="it">Italian</option>
            </select>
            <input type="submit" value="Translate now!" />
        </form>

        <div class="spinner" id="translate_spinner"></div>
        <div id="translation" class="post translation">
        </div>