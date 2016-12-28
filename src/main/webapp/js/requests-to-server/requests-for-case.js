
function deleteCase() {
    var name = $('#advocateForDelete').val();
    $.ajax({
        type: "GET",
        url: "/case/search/deleteByAdvocate?advocate=" + name.replace("/ /g", "%20"),
        contentType: "application/json",
        dataType: 'json'
    });
}

function deleteAll() {
    $.ajax({
        type: 'GET',
        url: "/case/search/deleteAll/"
    });
}



function addNewCase() {
    var kindOfCase = $('#kindOfCase').val();
    var advocate = $('#advocate').val();
    var serviceOffice = $('#serviceOffice').val();
    var court = $('#court').val();

    var requestJSONparametr = "{\"kindOfCase\": \"" + kindOfCase + "\"" +
        ", \"advocate\": \"" + advocate + "\", \"serviceOffice\": \"" + serviceOffice + "\", \"court\": \"" + court + "\"}";
    $.ajax({
        type: "POST",
        url: "/case/",
        contentType: "application/json",
        dataType: 'json',
        data: requestJSONparametr
    });
}




var priceRequest = new XMLHttpRequest();
priceRequest.open("GET", "/case/", true);   //Указываем адрес GET-запроса
priceRequest.onload = function (){             //Функция которая отправляет запрос на сервер для получения всех студентов
    var parsedItem = JSON.parse(this.responseText);
    var itemsTable = document.getElementById('all-items'); //получаем элемент по Id
    itemsTable.innerHTML = '';      //очищаем таблицу от устаревших данных
    parsedItem._embedded.case.forEach(function(item)  {
        var itemNameElement = document.createElement('td'); //создаем элемент ячейку с названием для таблицы
        itemNameElement.innerHTML =  item['kindOfCase'] ;     //внедряем название предмета, полученное с сервера
        var itemPriceElement = document.createElement('td');
        itemPriceElement.innerHTML = item['advocate'];
        var serviceOffice = document.createElement('td');
        serviceOffice.innerHTML = item['serviceOffice'];
        var court = document.createElement('td');
        court.innerHTML = item['court'];
        var elementRow = document.createElement('tr'); /// /создаем строку таблицы

        elementRow.appendChild(itemNameElement);      //помещаем обе ячейки в строку
        elementRow.appendChild(itemPriceElement);
        elementRow.appendChild(serviceOffice);
        elementRow.appendChild(court);
        itemsTable.appendChild(elementRow);           //помещаем строку в таблицу
    });

};

priceRequest.send(null);
