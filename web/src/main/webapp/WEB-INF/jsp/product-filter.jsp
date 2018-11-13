<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@include file="header.jsp" %>
<div>
    <form action="${pageContext.request.contextPath}/product-filters" method="post">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Выберите продукцию
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="#">Костюм спортивный</a>
                <a class="dropdown-item" href="#">Костюм тренировочный</a>
                <a class="dropdown-item" href="#">Форма игровая</a>
                <a class="dropdown-item" href="#">Майка парадная</a>
                <a class="dropdown-item" href="#">Жилет</a>
            </div>
        </div>
        <p><input name="value"></p>
        <br>
        <label for="value">До какой суммы за единицу:</label>
        <input type="number" id="value" name="value" size="10">
        <p>Введите максимальную стоимость за единицу:</p>
        <p><input name="value"></p>
        <br>
        <p><b>Сколько единиц продукции показывать на странице</b></p>
        <p><input type="checkbox" name="option1" value="a1" checked>5<Br>
            <input type="checkbox" name="option2" value="a2">10<Br>
            <input type="checkbox" name="option3" value="a3">20<Br>

        <p><input type="submit" value="Отправить"></p>
    </form>

</div>
</body>
</html>
