
<table class="table table-striped table-bordered">
<thead>
<tr>
<th >Test case id</th>
<th>Test Scenario</th>
<th style="width: 1000px">Test Steps</th>
<th>Test Data</th>
<th>Expected results</th>
<th>Actual result</th>
<th>Pass/Fail</th>
</tr>
</thead>
<tbody>
<tr>
<td>TU01</td>
<td>Проверка входа в аккаунт с корректными данными</td>
<td>1.Перейти на сайт 21vek.by<br>2.Вввести почту<br>3.Ввести пароль<br>4.Нажать “войти”</td>
<td>Почта: <a href="mailto:dnapclexaby@gmial.com">dnapclexaby@gmial.com</a> <br> Пароль: 1234</td>
<td>Пользователь успешно авторизован</td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU02</td>
<td>Добавление товара в корзину</td>
<td>1.Найти товар<br>2.Нажать кнопку “В корзину”</td>
<td>Товар: <a href="https://www.21vek.by/weights/bb203_starfit_01.html">bb203_starfit_01</a></td>
<td>Счетчик товаров в корзине увеличен на единицу. Текст кнопки изменен на “В корзине”. Нажатие кнопки ведет в корзину. Товар отображается в корзине.</td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU03</td>
<td>Добавление в избранное</td>
<td>1.Найти товар<br>2.Нажать кнопку “Добавить в избранное”</td>
<td>Товар: <a href="https://www.21vek.by/weights/bb203_starfit_01.html">bb203_starfit_01</a></td>
<td>Счетчит товаров в избранном увеличен на единицу. Звезда меняет цвет на красный. Текст кнопки меняется на “удалить из избранного”.</td>
<td></td>
<td></td>
</tr>
<tr>
<td>TU04</td>
<td>Фильтрация товаров</td>
<td>1. Указать параметры фильтрации<br>2. Нажать кнопку “Показать товары”</td>
<td>Производитель: Xiaomi RAM: 8гб ROM: 256гб</td>
<td>Отображены товары, соответствующие критериям: 1.<a href="https://www.21vek.by/mobile/mi108gb256gb_xiaomi_01.html">mi108gb256gb</a><br>2.<a href="https://www.21vek.by/mobile/mi108gb256gb_xiaomi.html">mi108gb256gb</a></td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU05</td>
<td>Добавление в сравнение</td>
<td>1.Найти товар<br>2.Нажать кнопку “добавить в сравнение”<br>3.Перейти к сравнению</td>
<td>Товар: <a href="https://www.21vek.by/mobile/redminote9pro6gb128gb_xiaomi_01.html">redminote9pro</a></td>
<td>Текст кнопки изменен на “Удалить из сравнения”. Счетчик товаров в сравнении увеличен на единицу. Данный товар отображается на странице сравнений</td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU06</td>
<td>Оформление заказа</td>
<td>1.Зайти в корзину<br>2.Нажать кнопку “Оформить заказ”<br>3.Ввести информацию<br>4.Нажать “Подтвердить зказ”</td>
<td>Товар:<a href="https://www.21vek.by/weights/bb203_starfit_01.html">bb203_starfit_01</a><br>Адрес: “ул. Такая-то, д. 12”<br>Тел.: 3752956686**</td>
<td>Заказ получает статус “Оформлен, ожидает подтверждения”</td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU07</td>
<td>Применение промокода на 10% скидки</td>
<td>1.Ввести промокод<br>2.Применить</td>
<td>Товар:<a href="https://www.21vek.by/weights/bb203_starfit_01.html">bb203_starfit_01</a><br>Промокод: жировка10</td>
<td>Стоимость товара снижена на 10%(полная стоимость = 11.61; с промокодом = 10.45)</td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU08</td>
<td>Снятие скидки при выборе оплаты картой рассрочки</td>
<td>1.Ввести промокод<br>2.Применить<br>3.Выбрать оплату картой рассрочки</td>
<td>Товар:<a href="https://www.21vek.by/weights/bb203_starfit_01.html">bb203_starfit_01</a><br>Промокод: жировка10<br>Способ оплаты: карта рассрочки</td>
<td>Стоимость товара повышена до 11.61 (стоимость с промокодом = 10.45)</td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU09</td>
<td>Оплата сертификатом</td>
<td>1.Указать способ оплаты подарочным серитфикатом<br>2.Указать сумму</td>
<td>Товар:<a href="https://www.21vek.by/weights/bb203_starfit_01.html">bb203_starfit_01</a><br>Сумма: 100р</td>
<td>К оплате: 0р</td>
<td>As expected</td>
<td>Pass</td>
</tr>
<tr>
<td>TU10</td>
<td>Снятие скидки при выборе оплаты частями</td>
<td>1.Ввести промокод<br>2.Применить<br>3.Выбрать оплату частями</td>
<td>Товар:<a href="https://www.21vek.by/weights/bb203_starfit_01.html">bb203_starfit_01</a><br> Промокод: жировка10<br>Способ оплаты: оплата частями</td>
<td>Стоимость товара повышена до 11.61 (стоимость с промокодом = 10.45)</td>
<td>As expected</td>
<td>Pass</td>
</tr>
</tbody>
</table>
